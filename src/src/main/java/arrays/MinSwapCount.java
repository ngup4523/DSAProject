package src.main.java.arrays;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
public class MinSwapCount {

	public static void main(String[] args) {
		int[] arr = {10,11,5,4,3,2,1};
		int n = 7;
		Map<Integer,Integer> posMap = new HashMap<>();
		for(int i=0;i<n;i++) 
			posMap.put(arr[i], i);
		
		Arrays.sort(arr);
		int[] visited = new int[n];
		int count = 0;
		for(int i=0;i<n;i++) {
			if(visited[i]==1 || posMap.get(arr[i]) == i)
				continue;
			int node = i;
			int cycle=0;
			while(visited[node]==0) {
			visited[node] = 1;
			node = posMap.get(arr[node]);
			cycle++;
			}
			count += (cycle-1);
			
		}
		
		System.out.println(count);
	}

}
