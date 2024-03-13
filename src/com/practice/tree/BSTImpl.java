package com.practice.tree;

import java.util.LinkedList;

public class BSTImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//class Node<T> {
//	T data;
//	Node<T> left;
//	Node<T> right;
//
//	public Node(T data){
//		this.data = data;
//		this.left = null;
//		this.right = null;
//	}
//
//	void levelOrderPrint(Node<T> head) {
//		if(head == null)
//			return;
//		LinkedList<Node<T>> queue = new LinkedList<>();
//		queue.add(head);
//		queue.add(new Node<T>(null));
//		while(queue.size()!=0) {
//			Node next = queue.poll();
//			if(next==null) 
//				break;
//			if(next.data == null) {
//				System.out.println();
//				if(queue.size()!=0)
//					queue.add(new Node<T>(null));
//			}
//			if(next.left !=null)
//				queue.add(next.left);
//			if(next.right !=null)
//				queue.add(next.right);
//			if(next.data !=null)
//				System.out.print(next.data+" ");
//		}
//	}
//
//	Node<Integer> buildLevelOrder(LinkedList<Integer> list) {
//		if(list.isEmpty())
//			return null;
//		LinkedList<Node<Integer>> queue = new LinkedList<>();
//		Node<Integer> root = new Node<Integer>(list.poll());
//		Node<Integer> node,lnode,rnode;
//		queue.add(root);
//		Integer temp;
//		while(!queue.isEmpty()) {
//			node = queue.poll();
//			temp = list.poll();
//			if(temp!=null && temp!=-1) {
//				lnode = new Node<Integer>(temp);
//				node.left = lnode;
//				queue.add(lnode);
//			}
//			temp = list.poll();
//			if(temp!=null && temp!=-1) {
//				rnode = new Node<Integer>(temp);
//				node.right = rnode;
//				queue.add(rnode);
//			}
//		}
//		return root;
//	}
//
//	Node<Integer> findLCA(Node<Integer> root, Integer n1, Integer n2){	
//		if(root==null)
//			return null;
//		if(root.data.equals(n1) || root.data.equals(n2))
//			return root;
//		Node<Integer> lca1 = findLCA(root.left,n1,n2);
//		Node<Integer> lca2 = findLCA(root.right,n1,n2);
//		if(lca1!=null && lca2!=null)
//			return root;
//		return lca1!=null ? lca1 : lca2;
//	}
//
//	int findHeight(Node<T> root) {
//		if(root == null)
//			return 0;
//		int h1 = findHeight(root.left);
//		int h2 = findHeight(root.right);
//		return Math.max(h1, h2) + 1;
//	}
//	
//	Node<Integer> createMinHtBST(Node<Integer> root, int[] arr, int s, int e) {
//		if(s>e)
//			return null;
//		int m = (s+e)/2;
//		root = new Node<Integer>(arr[m]);
//		
//		root.left = createMinHtBST(root.left, arr, s, m-1);
//		root.right = createMinHtBST(root.right, arr, m+1, e);
//		
//		return root;
//	}
//}