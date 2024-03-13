package src.main.java.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestBand {

	public static void main(String[] args) {
		int[] arr = {1,3,0,18,8,9,5,2,4,10,7,12,6};
		System.out.println(getBandLength(arr, arr.length));

	}

	private static int getBandLength(int[] arr, int n) {
		if(n<=0)
			return 0;
		
		int maxLength = 0;
		Set<Integer> inputSet = new HashSet<>();
		for(int i=0;i<n;i++)
			inputSet.add(arr[i]);
		
		for(int i=0;i<n;i++) {
			if(inputSet.contains(arr[i]-1))
				continue;
			int temp = 1;
			int start = arr[i];
			while(inputSet.contains(++start))
				temp++;
			maxLength = Math.max(maxLength, temp);
		}
		
		return maxLength;
	}
}
