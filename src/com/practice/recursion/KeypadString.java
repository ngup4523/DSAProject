package com.practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeypadString {

	public static String keypad[] = {"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
	public static void main(String[] args) {
		System.out.println(getPossibleString(String.valueOf(23)));

	}

	private static List<String> getPossibleString(String n) {
		List<String> result = new ArrayList<>();
		if(n.length()==1) {
			return getLetterMapping(Integer.parseInt(n));
		}
		List<String> intermediate = getPossibleString(n.substring(1));
		String keys = keypad[n.charAt(0)-48];
		for(String item: intermediate) {
			for(int i=0;i<keys.length();i++) {
				result.add(keys.charAt(i)+item);
			}
		}
		return result;
	}
	
	private static List<String> getLetterMapping(int num){
			return new ArrayList<String>(Arrays.asList(keypad[num].split("")));
		
	}
}
