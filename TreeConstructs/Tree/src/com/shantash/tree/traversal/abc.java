package com.shantash.tree.traversal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class abc {
	private class TimeFrames {
		int start;
		int end;

		public TimeFrames(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}
	}

	private List<TimeFrames> timeFrames;

	public static void main(String[] args) {
		abc a = new abc();
		a.populateTimeFrames();
		a.printMinMachinesRequired();
	}

	private void printMinMachinesRequired() {
		List<Integer> allStartTimes = this.timeFrames.stream().map(f -> f.start).collect(Collectors.toList());
		List<Integer> allEndTimes = this.timeFrames.stream().map(f -> f.end).collect(Collectors.toList());
		allStartTimes.sort((a, b) -> a - b);
		allEndTimes.sort((a, b) -> a - b);
		int minStartTime = allStartTimes.get(0);
		int maxEndTime = allEndTimes.get(allEndTimes.size() - 1);
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i = minStartTime; i <= maxEndTime; i++) {
			if (countMap.get(i) == null)
				countMap.put(i, 0);
			for (TimeFrames f : this.timeFrames) {
				if (i >= f.start && i < f.end) {
					countMap.put(i, countMap.get(i) + 1);
				}
			}
		}
		int max = 0;
		Collection<Integer> allCounts = countMap.values();
		Iterator<Integer> itr = allCounts.iterator();
		while (itr.hasNext()) {
			Integer current = itr.next();
			max = current > max ? current : max;
		}
		System.out.println(max);
	}

	private void populateTimeFrames() {
		this.timeFrames = new ArrayList<TimeFrames>();
		this.timeFrames.add(new TimeFrames(11, 12));
		this.timeFrames.add(new TimeFrames(12, 13));
		this.timeFrames.add(new TimeFrames(11, 13));
	}
}
