package com.practice.linkedlist;

public class LinkedListSearch {

	public static void main(String[] args) {
		Node<Integer> headnode = new Node(1);
		headnode.next = new Node(2);
		headnode.next.next = new Node(3);
		headnode.next.next.next = new Node(4);
		headnode.next.next.next.next = new Node(5);
		
//		headnode.printAll(headnode);
//		System.out.println(headnode.isKeyPresent(7, headnode));
//		System.out.println(headnode.isKeyPresent(11, headnode));
//		Node<Integer> newhead = headnode.recursiveReverse(headnode);
//		Node<Integer> newhead = headnode.iterativeReverse(headnode);
		Node<Integer> newhead = headnode.reverseInK(headnode, 2);
		newhead.printAll(newhead);

	}

}

class Node<T> {
	T data;
	Node<T> next;
	
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
	
    public boolean isKeyPresent(T key, Node<T> head) {
		Node<T> temp = head;
		while(temp != null) {
			if(temp.data == key)
				return true;
			temp = temp.next;
		}
		
		return false;
	}
    
    public void printAll(Node<T> head) {
    	Node<T> temp = head;
		while(temp.next != null) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.print(temp.data);
		
    }
    
    public Node<T> recursiveReverse(Node<T> head) {
    	if(head == null || head.next == null)
    		return head;
    	Node<T> shead = recursiveReverse(head.next);
    	head.next.next = head;
    	head.next = null;
    	return shead;	
    }
    
    public Node<T> iterativeReverse(Node<T> head) {
    	Node<T> prev, curr,temp;
    	prev = null;
    	curr = head;
    	
    	while(curr != null) {
    	temp = curr.next;
    	curr.next = prev;
    	prev = curr;
    	curr = temp;
    	}
    	
    	return prev;	
    }
    
    public Node<T> reverseInK(Node<T> head, int k) {
    	//1>2>3>4>5 K=3
    	Node curr, prev,temp;
    	prev = null;
    	curr = head;
    	int i;
    	for(i=0;i<k && curr !=null;i++) {
    		temp = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = temp;
    	}
    	//1<2<3 4>5 CURR = 4, PREV = 3, HEAD = 1
    	if(i==k) {
	    	Node<T> localhead = reverseInK(curr, k);
	    	// 1<2<3 4<5 CURR = 4, PREV = 3, HEAD = 1 localhead = 5\
	    	head.next = localhead;
    	}
    	return prev;
    }
}
