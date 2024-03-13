package src.main.java.arrays;

import java.util.Arrays;

public class MaxSubarraySum {

	public static void main(String[] args) {
		int arr[] = {-2,-3,4,-1,-2,1,5,-3};
		int maxSoFar = Integer.MIN_VALUE;
		int sumSoFar = 0;
		for(int i: arr) {
			sumSoFar += i;
			maxSoFar = Math.max(maxSoFar, sumSoFar);
			if (sumSoFar<0)
				sumSoFar = 0;
		}
		maxSoFar = Math.max(maxSoFar, 0);
		System.out.println("maxSoFar= "+maxSoFar);
		minDifference();
	}

	private static void minDifference() {
		int a[] = {1, 2, 3};
		int b[] = {1,1,4};
		Arrays.sort(a);
		Arrays.sort(b);
		int minDif = Integer.MAX_VALUE;
		for(int i= 0;i<a.length;i++) {
			minDif = Math.min(minDif, Math.abs(a[i]-b[i]));
		}
		System.out.println("min diff = "+minDif);
	}
	
	private static void arrayProductWithoutDiv() {
		int arr[] = {1,2,3,4,5};
		int left[] =new int[5];
		int right[] = new int[5];
		left[0]=1;
		right[4] = 1;
		for(int i=1;i<5;i++)
			left[i] = left[i-1]*arr[i-1];
		for(int i=4-1;i>=0;i--)
			right[i] = right[i-1]*arr[i-1];
	
		int prod[] = new int[5];
		prod[0] = right[0];
		prod[4] = left[4];
		for(int i=1;i<5-1;i++)
			prod[i] = left[i]*right[i];
		
		for(int i: prod)
		System.out.println(i);
	}
}
