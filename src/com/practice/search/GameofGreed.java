package com.practice.search;

public class GameofGreed {

	public static void main(String[] args) {
		int arr[] = {10,20,30,15};
		System.out.println(getMinPossibleValue(arr, arr.length, 2));

	}
	
	private static int getMaxPossibleValue(int[] arr, int n, int k) {
		int min = arr[0];
		int max = 0;
		for(int i: arr)
			min = Math.min(min, i);
		for(int i: arr)
			max += i;
		int ans = min;
		while(min<=max) {
			int m = (min+max)/2;
			if(checkPossibleValue(arr, n, k, m)) {
				ans = m;
				min = m+1;
			} else {
				max = m-1;
			}
		}
		return ans;
	}
	
	private static int getMinPossibleValue(int[] arr, int n, int k) {
		int min = arr[0];
		int max = 0;
		for(int i: arr)
			min = Math.min(min, i);
		for(int i: arr)
			max += i;
		int ans = arr[0];
		while(min<=max) {
			int m = (min+max)/2;
			if(checkPossibleValue(arr, n, k, m)) {
				ans = m;
				max = m-1;
			} else {
				min = m+1;
			}
		}
		return ans;
	}
	
	private static boolean checkPossibleValue(int[] arr, int n, int k, int m) {
		int[] allot = new int[k];
		
		for(int i=0, j=0;i<n&&j<k-1;i++) {
			if(allot[j]<m)
				allot[j] += arr[i];
			else 
				allot[++j] = arr[i];
		}
		if(allot[k-1]>=m)
			return true;
		return false;
	}

}
