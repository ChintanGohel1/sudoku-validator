// { Driver Code Starts

import java.io.*;
import java.util.*;

class SudokuValidator{  // change  className to GFG if you want to submit this in GeekforGeeks
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}// } Driver Code Ends


class Solution{
	
	public  int isValid(int[][] sudoku) {

			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					if(sudoku[i][j] != 0) {
						for(int x=0;x<9;x++) {
							if( j!=x  &&  sudoku[i][j] == sudoku[i][x]) {
								return 0;
							}
							if( i!=x && sudoku[i][j] == sudoku[x][j]) {
								return 0;
							}
						}
					}
				}
			}
		
		
		
				for(int j=0;j < 3 ; j++) {
					for(int i =0;i< 3;i++) {
						for(int innerRow  = j * 3  ; innerRow < (j+1) * 3; innerRow++) {
							
								for(int innerColumn = i * 3 ; innerColumn < (i+1) * 3 ;innerColumn++) {

									if(sudoku[innerRow][innerColumn] != 0) {
										int counter = 0;
										for(int x = j*3; x < (j+1) * 3 ; x++) {

											for(int y = i*3; y < (i+1) * 3;y++) {
												if(sudoku[innerRow][innerColumn] == sudoku[x][y]) {
													counter ++;
												}
												if(counter > 1) {
												//	System.out.println("invalid data at place :: sudoku[" + innerRow +"][" + innerColumn + "] = " + sudoku[innerRow][innerColumn]);
													return 0;
												}
											}
										}
									}
							}
						}
					}
				}
		
		return 1;
	}
}
