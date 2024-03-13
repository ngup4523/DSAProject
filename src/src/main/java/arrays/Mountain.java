package src.main.java.arrays;

public class Mountain {

	public static void main(String[] args) {
		int[] input = {5,6,1,2,3,4,5,4,3,2,0,1,2,3,-2,4};
		System.out.println(getMaxPeak(input, input.length));
	}

	private static int getMaxPeak(int[] input, int n) {
		int lastLow, lastPeak;
		lastLow = lastPeak = -1;
		int maxPeak = 0;
		for(int i=1;i<n-1;i++) {
			if(input[i]<input[i-1] && input[i]<input[i+1])
				lastLow = i;
			else if (input[i]>input[i-1] && input[i]>input[i+1]) {
				lastPeak = i;
				while(input[i]>input[i+1] && i<n-1)
					i++;
				maxPeak = Math.max(maxPeak, i-lastLow+1);
				lastLow = i;
			}	
		}
		return maxPeak;
	}
}
