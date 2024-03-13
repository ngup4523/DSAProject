package com.practice.search;

public class SparseSearch {

	public static void main(String[] args) {
		String[] arr = {"ai","","","bat","","","car",
				"cat","","","dog",""};
		int s= 0, e = arr.length-1;
		String k = "cat";
		int mid = -1;
		while(s<=e) {
		mid = getmid(arr, s, e);
		if(mid==-1) 
			break;
		if(arr[mid].equals(k))
			break;
		else if(arr[mid].compareTo(k)<0) {
			s=mid+1;
		} else {
			e=mid;
		}	
		}
		System.out.println(mid);
	}

	private static int getmid(String[] arr, int s, int e) {
		int m = (s+e)/2;
		if(!arr[m].isEmpty())
			return m;
		for(int l=m-1,r=m+1;l>=s&&r<=e;) {
			if(!arr[l].isEmpty())
				return l;
			else if(!arr[r].isEmpty())
				return r;
			l--;
			r++;
		}
		return -1;
	}
}
