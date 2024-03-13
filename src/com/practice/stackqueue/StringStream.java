package com.practice.stackqueue;

import java.util.*;

class Parent{
	static void print() {}
}

public class StringStream extends Parent {

	public static void main(String[] args) {
		String input = "aabccbcd";
		Queue<Character> queue = new LinkedList<>();
		int[] freq = new int[256];
		int n = input.length();
		
		for(int i=0;i<n;i++) {
			char next = input.charAt(i);
			freq[next] = freq[next]+1;
			if(freq[next]==1)
				queue.add(next);
			
			char peek;
			while(queue.size()!=0) {
				peek = queue.peek();
				if(freq[peek]==1) {
					System.out.print(peek+" ");
					break;
				} else {
					queue.remove();
				}
			}
			
			if(queue.size()==0)
				System.out.print("-1 ");
		}
		
	}

}
