package src.main.java.arrays;

public class SubarraySort {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,8,6,7,9,10,11};
		
		int smallest = Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;
		int n = arr.length;
		if(arr[0]>arr[1]) {
			smallest = Math.min(smallest, arr[0]);
			largest = Math.max(largest, arr[0]);
		}
		if(arr[n-1]<arr[n-2]) {
			smallest = Math.min(smallest, arr[n-1]);
			largest = Math.max(largest, arr[n-1]);
		}
			
		for(int i=1; i<n-1;i++) {
				if(arr[i]>arr[i+1] || arr[i]<arr[i-1]) {
					smallest = Math.min(smallest, arr[i]);
					largest = Math.max(largest, arr[i]);
				}
		}
		int left, right;
		left = right = -1;
		for(int i=0;i<n;i++) {
			if(arr[i]>smallest) {
				left = i;
				break;
			}
		}
		for(int i=n-1;i>=0;i--) {
			if(arr[i]<largest) {
				right = i;
				break;
			}
		}
		
		if(left == -1)
			System.err.println("Not found");
		else 
			System.out.println("X= "+left+" Y= "+right);

	}

}
