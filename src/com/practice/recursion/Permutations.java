package com.practice.recursion;

public class Permutations {

	public static void main(String[] args) {
		String input = "ab";
		printPermutations(input, 0);
	}

	private static void printPermutations(String s, int i) {
		if(i==s.length()) {
			System.out.println(s);
			return;
		}
		
		for(int j=i;j<s.length();j++) {
			printPermutations(swapLetters(s, i, j), i+1);
		}
	}
	
	private static String swapLetters(String s, int i, int j) {
		String replaced = new String();
		//s="abc" 0,1
		for(int k=0;k<s.length();k++) {
			if(k==i) 
				replaced += s.charAt(j);
			else if(k==j)
				replaced += s.charAt(i);
			else
				replaced += s.charAt(k);
				
		}
		return replaced;
		
	}
}
