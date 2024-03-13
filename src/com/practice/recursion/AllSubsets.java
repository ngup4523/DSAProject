package com.practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AllSubsets {

	public static void main(String[] args) {
//		List<String> res = printSubstring("abc");
//		int[] input = {1,2,3,4,5};
//		int c = countSubsets(input,5,10);
//		System.out.println(c);
		System.out.println(generateBracket("", 0, 0, 3, 0));
	}

	private static List<String> printSubstring(String s) {
		
		List<String> result = new ArrayList<>(Arrays.asList(""));
		if(s.isEmpty())
			return result;
		result = printSubstring(s.substring(1));
		ListIterator<String> i = result.listIterator();
		while(i.hasNext()) {
			String n = i.next();
			i.add(s.charAt(0)+n);
		}
		return result;
	}
	
	private static int countSubsets(int[] arr, int n, int sum) {
		if(n==0) {
			if(sum==0)
				return 1;
			else
				return 0;
		}
		int c1 = countSubsets(arr, n-1, sum-arr[n-1]);
		int c2 = countSubsets(arr, n-1, sum);
		return c1+c2;
	}
	
	private static List<String> generateBracket(String out, int open, int close, int n, int i) {
		List<String> result = new ArrayList<>();
		if(i==2*n) {
			result.add(out);
			return result;
		}
		List<String> r1 = new ArrayList<>(),r2 = new ArrayList<>();
		if(open<n) {
			r1 = generateBracket(out+"(", open+1, close, n, i+1);
		}
		if(open>close) {
			r2 = generateBracket(out+")", open, close+1, n, i+1);
		}
		result.addAll(r1);
		result.addAll(r2);
		return result;
	}
}
