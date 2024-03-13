package com.practice.sorting;

public class InversionCount {

	public static void main(String[] args) {
		int arr[] = {0,5,2,3,1};
		int count = inversion(arr,0,arr.length-1);
		System.out.println(count);
	}

	private static int inversion(int[] arr, int s, int e) {
		if(s>=e)
			return 0;
		int m = (s+e)/2;
		int C1 = inversion(arr,s,m);
		int C2 = inversion(arr,m+1,e);
		int C3 = crossInversion(arr,s,e);
		
		return C1+C2+C3;
	}

	private static int crossInversion(int[] arr, int s, int e) {
		int m = (s+e)/2;
		int temp[] = new int[e-s+1];
		int i,j,k;
		int c = 0;
		for(i=s, j=m+1, k=0;i<=m&&j<=e;k++) {
			if(arr[i]<arr[j]) 
				temp[k] = arr[i++];
			else {
				temp[k] = arr[j++];
				c += m-i+1;
			}
		}
		
		while(i<=m) {
			temp[k++]= arr[i++];
		}
		while(j<=e) {
			temp[k++]= arr[j++];
		}
		for(i=0;i<k;i++) {
			arr[i+s] = temp[i];
		}
		return c;
	}

}
