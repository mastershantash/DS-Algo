package com.shantash.tree.nodes;

public class DoublyLinkedlist<T> {
	private ListNode<T> start;
	private ListNode<T> end;
	public ListNode<T> getStart() {
		return start;
	}
	public void setStart(ListNode<T> start) {
		this.start = start;
	}
	public ListNode<T> getEnd() {
		return end;
	}
	public void setEnd(ListNode<T> end) {
		this.end = end;
	}
	
	public static<T> void print(DoublyLinkedlist<T> list){
		ListNode<T> start = list.getStart();
		while(start!=null){
			System.out.print(start.getData());
			start = start.getNext();
		}
		System.out.println("");
	}
	
	public static<T> void printReverse(DoublyLinkedlist<T> list){
		ListNode<T> end = list.getEnd();
		while(end!=null){
			System.out.print(end.getData());
			end = end.getPrev();
		}
		System.out.println("");
	}
}
