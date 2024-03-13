package com.practice.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeImpl {

	public static void main(String[] args) {
		//		Node<Integer> root = new Node<Integer>(1);
		//		root.left = new Node<Integer>(2);
		//		root.right = new Node<Integer>(3);
		//		root.left.left = new Node<Integer>(4);
		//		root.left.right = new Node<Integer>(5);
		//		root.left.right.left = new Node<Integer>(7);
		//		root.right.right = new Node<Integer>(6);
		//
		//		root.levelOrderPrint(root);

		LinkedList<Integer> input = new LinkedList<>(Arrays.asList(1,2,3,4,5,-1,6,-1,-1,7,-1,-1,-1,-1,-1));
		Node<Integer> node = new Node<Integer>(1);
		Node<Integer> root = node.buildLevelOrder(input);
//		root.levelOrderPrint(root);
//		System.out.println(root.findHeight(root));
//		System.out.println(root.findLCA(root, 4, 5).data);
//		System.out.println(root.diameter(root));
		int sum = root.findSum(root);
		root.levelOrderPrint(root);
	}

}

class Node<T> {
	T data;
	Node<T> left;
	Node<T> right;

	public Node(T data){
		this.data = data;
		this.left = null;
		this.right = null;
	}

	void levelOrderPrint(Node<T> head) {
		if(head == null)
			return;
		LinkedList<Node<T>> queue = new LinkedList<>();
		queue.add(head);
		queue.add(new Node<T>(null));
		while(queue.size()!=0) {
			Node next = queue.poll();
			if(next==null) 
				break;
			if(next.data == null) {
				System.out.println();
				if(queue.size()!=0)
					queue.add(new Node<T>(null));
			}
			if(next.left !=null)
				queue.add(next.left);
			if(next.right !=null)
				queue.add(next.right);
			if(next.data !=null)
				System.out.print(next.data+" ");
		}
	}

	Node<Integer> buildLevelOrder(LinkedList<Integer> list) {
		if(list.isEmpty())
			return null;
		LinkedList<Node<Integer>> queue = new LinkedList<>();
		Node<Integer> root = new Node<Integer>(list.poll());
		Node<Integer> node,lnode,rnode;
		queue.add(root);
		Integer temp;
		while(!queue.isEmpty()) {
			node = queue.poll();
			temp = list.poll();
			if(temp!=null && temp!=-1) {
				lnode = new Node<Integer>(temp);
				node.left = lnode;
				queue.add(lnode);
			}
			temp = list.poll();
			if(temp!=null && temp!=-1) {
				rnode = new Node<Integer>(temp);
				node.right = rnode;
				queue.add(rnode);
			}
		}
		return root;
	}

	Node<Integer> findLCA(Node<Integer> root, Integer n1, Integer n2){	
		if(root==null)
			return null;
		if(root.data.equals(n1) || root.data.equals(n2))
			return root;
		Node<Integer> lca1 = findLCA(root.left,n1,n2);
		Node<Integer> lca2 = findLCA(root.right,n1,n2);
		if(lca1!=null && lca2!=null)
			return root;
		return lca1!=null ? lca1 : lca2;
	}

	int findHeight(Node<T> root) {
		if(root == null)
			return 0;
		int h1 = findHeight(root.left);
		int h2 = findHeight(root.right);
		return Math.max(h1, h2) + 1;
	}
	
	int[] diameterOptimise(Node<T> root) {
		if(root == null)
			return new int[] {0,0};
		
		int[] lval = diameterOptimise(root.left);
		int[] rval = diameterOptimise(root.right);
		int D1 = lval[0]+rval[0];
		int D2 = lval[1];
		int D3 = rval[1];
		int dia = Math.max(D1, Math.max(D2, D3));
		int height = Math.max(lval[0], rval[0]) + 1;
		return new int[] {height, dia}; 
	}
	
	int diameter(Node<T> root) {
		if(root == null)
			return 0;
		
		int D1 = findHeight(root.left) + findHeight(root.right);
		int D2 = diameter(root.left);
		int D3 = diameter(root.right);
		int dia = Math.max(D1, Math.max(D2, D3));
	
		return dia;
	}
	
	int findSum(Node<Integer> root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return root.data;
		int temp = root.data;
		int sum = findSum(root.left) + findSum(root.right);
		root.data = sum;
		return sum+temp;
	}
}












