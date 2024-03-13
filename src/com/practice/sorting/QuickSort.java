package com.practice.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = {10,5,2,0,7,6,4};
//		quickSort(arr,0,arr.length-1);
//		for(int i: arr) {
//			System.out.println(i);
//		}
		
		int k = quickSelect(arr, 0, arr.length-1, 4);
		System.out.println(arr[k]);
	}

	private static void quickSort(int[] arr, int s, int e) {
		if(s>=e)
			return;
		int p = partition(arr, s, e);
		quickSort(arr, s, p-1);
		quickSort(arr, p+1, e);
	}
	
	private static int partition(int[] arr, int s, int e) {
		int i=s-1,j=s, temp;
		for(;i<e&&j<e;j++) {
			if(arr[j]<arr[e]) {
				i++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		i++;
		temp = arr[e];
		arr[e] = arr[i];
		arr[i] = temp;
		return i;
	}
	
	private static int quickSelect(int[] arr, int s, int e, int k) {
//		if(s==e)
//			return s;
		int p = partition(arr, s, e);
		if(p==k)
			return p;
		else if(p>k)
			return quickSelect(arr, s, p-1, k);
		return quickSelect(arr, p+1, e, k);
	}
}
