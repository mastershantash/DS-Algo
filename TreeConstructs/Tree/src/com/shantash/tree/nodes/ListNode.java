package com.shantash.tree.nodes;

public class ListNode<T> {
	T data;
	ListNode<T> next;
	ListNode<T> prev;

	public ListNode() {
		super();
	}

	public ListNode(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}

	public ListNode<T> getPrev() {
		return prev;
	}

	public void setPrev(ListNode<T> prev) {
		this.prev = prev;
	}

}
