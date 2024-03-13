package src.main.java.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumberFromDigit {

	public static void main(String[] args) {
		Integer arr[] = {10,11,22,30,333,0,3};
		List<Integer> arrList = Arrays.asList(arr);
		arrList.sort(new IntegerComparator());
		System.out.println(arrList);
	}
}

class IntegerComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		int n2 = (int)Math.log10(o1);
		int a1 = (int) (o1/Math.pow(10, n2));
		int b1=o2,n1;
		while(b1!=0) {
			n1 = (int)Math.log10(o2);
			b1 = (int) (o2/Math.pow(10, n1)); 
		
			if (a1!=b1)
				return a1<b1 ? 1 : -1;
			o2 = o2/10;
		}
		
		return a1==b1 ? 0 : a1<b1 ? 1 : -1;
	}
	
}
