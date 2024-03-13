package com.practice.search;

public class AngryBirdsNest {

	public static void main(String[] args) {
		int[] nests = {1,2,4,8,9};
		int n = nests.length;
		System.out.println(minDistance(nests, n, 3));

	}

	private static int minDistance(int[] arr, int n, int b) {
		int e = arr[n-1]-arr[0];
		int s = arr[0];	//should be 0
		int ans = -1;
		while(s<=e) {
			int mid = (s+e)/2;
			if(checkPossible(arr, n, mid, b)) {
				ans = mid;
				s= mid+1;
			} else 
				e=mid-1;
		}
		
		return ans;
	}
	
	private static boolean checkPossible(int[] arr, int n, int m, int b) {
		int[] place = new int[b];
		place[0] = arr[0];
		b--;
		for(int i=1, j=1;i<n&&b>0;i++) {
			if(arr[i]-place[j-1]>=m) {
				place[j++] = arr[i];
				b--;
			}
		}
		if(b==0)
			return true;
		return false;
	}
}
