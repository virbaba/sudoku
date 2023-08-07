import java.util.* ;
import java.io.*; 
public class Sudoku {

	public static boolean isSafe(int[][] sudoku, int r, int c, int val){

    // checker
		for(int i = 0; i < 9; i++){

      // Check in each row
			if(sudoku[r][i] == val)
				return false;

      // Check in each column
			if(sudoku[i][c] == val)
				return false;

      // Check in each 3 * 3 matrix
			if(sudoku[3 * ( r / 3 ) + i / 3][3 * ( c / 3 ) + i % 3] == val)
				return false;

		}

    // if we are here mean a putting value pass all checker
		return true;
	}

	public static boolean solve(int[][] sudoku){

    // traversing 9 * 9 sudoku matrix
		for(int r = 0; r < 9; r++){
			
			for(int c = 0; c < 9; c++){

        // Check the empty place in sudoku
				if(sudoku[r][c] == 0){

          // try to place number from 1 - 9
					for(int val = 1; val <= 9; val++){

            // check putting number is safe or not
						if(isSafe(sudoku, r, c, val)){

							sudoku[r][c] = val;

              // if sudoku false mean we can't put particular or current  number due to previous putted number so we will backtrack
							if(solve(sudoku))
								return true;

							else
								sudoku[r][c] = 0; // back tracking
						}

					}
          // if we are here mean our code is fail to put number from 1 - 9 in empty place so this sudoku is invalid we return false
					return false;

				}
			}
		}

    // if we are here mean our code got success to fill all empty place into the sudoku
		return true;
	}
    
	public static void solveSudoku(int[][] sudoku) {
        // Write your code here.

		solve(sudoku);
        
	}
}
