package com.practice.recursion;

public class Sudoku {

	public static void main(String[] args) {
		int n=9;
		int[][] mat =  {{5,3,0,0,7,0,0,0,0},
						{6,0,0,1,9,5,0,0,0},
						{0,9,8,0,0,0,0,6,0},
						{8,0,0,0,6,0,0,0,3},
						{4,0,0,8,0,3,0,0,1},
						{7,0,0,0,2,0,0,0,6},
						{0,6,0,0,0,0,2,8,0},
						{0,0,0,4,1,9,0,0,5},
						{0,0,0,0,8,0,0,7,9}};
		

		solve(mat, 0 , 0, n);
	}
	
	private static boolean solve(int[][] mat, int i, int j, int n) {
		if(i>=n) {
			for(int p=0;p<n;p++) {
				for(int q=0;q<n;q++) 
					System.out.print(" "+mat[p][q]); 
				System.out.println();
			}
			return true;
		}
		if(j>=n)
			return solve(mat, i+1, 0, n);
		if(mat[i][j]!=0)
			return solve(mat,i,j+1,n);
		
		for(int k=1;k<=n;k++) {
			boolean temp;
			if(checkRowCol(mat, i, j, n, k) && checkBlock(mat, i, j, n, k)) {
				mat[i][j] = k;
				temp = solve(mat,i,j+1,n);
				if(temp)
					return true;
				mat[i][j]=0;
			}
		}
		
		return false;
	}
	
	private static boolean checkRowCol(int[][] mat, int i, int j, int n, int num) {
		for(int k=0;k<n;k++) {
			if(mat[i][k]==num || mat[k][j] == num)
				return false;
		}
		
		return true;
	}
	
	private static int getblock(int i) {
		return (i/3)*3;
	}
	
	private static boolean checkBlock(int[][] mat, int i, int j, int n, int num) {
		for(int p=getblock(i);p<getblock(i)+3;p++)
			for(int q=getblock(j);q<getblock(j)+3;q++)
				if(mat[p][q] == num)
					return false;
		
		return true;
	}
	
}
