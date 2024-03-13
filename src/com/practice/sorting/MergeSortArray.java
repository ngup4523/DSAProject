package com.practice.sorting;

public class MergeSortArray {

	public static void main(String[] args) {
		int arr[] = {10,5,2,0,7,6,4};
		mergeSort(arr,0,arr.length-1);
		for(int i: arr) {
			System.out.println(i);
		}
	}
	
	private static void mergeSort(int[] arr, int s, int e) {
		if(s>=e)
			return;
		int m = (s+e)/2;
		mergeSort(arr,s,m);
		mergeSort(arr,m+1,e);
		merge(arr,s,e);
	}

	private static void merge(int[] arr, int s, int e) {
		int m = (s+e)/2;
		int temp[] = new int[e-s+1];
		int i,j,k;
		for(i=s, j=m+1, k=0;i<=m&&j<=e;k++) {
			if(arr[i]<arr[j]) 
				temp[k] = arr[i++];
			else
				temp[k] = arr[j++];	
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
	}
}
