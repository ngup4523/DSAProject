package com.practice.pqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KNearestCab {

	public static void main(String[] args) {
		int[] inp = {1,5,2,6,8,3};
		PriorityQueue<Integer> pqueue = new PriorityQueue<>(Comparator.reverseOrder());
		int k=3, temp;
		for(int i=0;i<k;i++) 
			pqueue.add(inp[i]);
		
		for(int i=k;i<inp.length;i++) {
			temp = pqueue.peek();
			if(temp>inp[i]) {
				pqueue.poll();
				pqueue.add(inp[i]);
			}
		}
		System.out.println(pqueue);

	}

}
