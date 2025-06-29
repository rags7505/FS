package day41_13_05_2025;
/*
Venkatadri is a maths teacher.
He is teaching matrices to his students.
He is given a matrix of size m*n, and it contains only positive numbers.
He has given a task to his students to find the special matrix, 
in the iven matrix A[m][n].
A special matrix has following property:
	- The sum of elements in each row, each column and the two diagonals are equal.
	- Every 1*1 matrix is called as a special matrix.
	- The size of the special matrix should be a square, i.e., P*P.

Your task is to help the students to find the speical matrix  with max size P.


Input Format:
-------------
Line-1: Two space separated integers M and N, size of the matrix.
Next M lines: N space separated integers m and n.

Output Format:
--------------
Print an integer, maximum size P of the special matrix.


Sample Input-1:
---------------
5 5
7 8 3 5 6
3 5 1 6 7
3 5 4 3 1
6 2 7 3 2
5 4 7 6 2

Sample Output-1:
----------------
3

Explanation:
------------
The special square is:
5 1 6
5 4 3
2 7 3


Sample Input-2:
---------------
4 4
7 8 3 5
3 2 1 6
3 2 3 3
6 2 3 3

Sample Output-2:
----------------
2

Explanation:
------------
The special square is:
3 3
3 3
*/
/* chatgpt */
import java.util.*;
class program2{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(maxSpecialMatrix(arr, m, n));
    }
    public static int maxSpecialMatrix(int[][] arr, int m, int n) {
        int maxSize = 0;
        for (int size = Math.min(m, n); size >= 1; size--) {
            for (int i = 0; i <= m - size; i++) {
                for (int j = 0; j <= n - size; j++) {
                    if (isSpecialMatrix(arr, i, j, size)) {
                        return size;
                    }
                }
            }
        }
        return maxSize;
    }
    public static boolean isSpecialMatrix(int[][] arr, int row, int col, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[row][col + i];
        }
        for (int i = 1; i < size; i++) {
            int rowSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += arr[row + i][col + j];
            }
            if (rowSum != sum) {
                return false;
            }
        }
        for (int i = 0; i < size; i++) {
            int colSum = 0;
            for (int j = 0; j < size; j++) {
                colSum += arr[row + j][col + i];
            }
            if (colSum != sum) {
                return false;
            }
        }
        int diag1Sum = 0, diag2Sum = 0;
        for (int i = 0; i < size; i++) {
            diag1Sum += arr[row + i][col + i];
            diag2Sum += arr[row + i][col + size - 1 - i];
        }
        return diag1Sum == sum && diag2Sum == sum;
    }
}
/* Claude other responses */
/*
 package day41_13_05_2025;

import java.util.*;

class OptimizedSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        System.out.println(maxSpecialMatrix(arr, m, n));
    }
    
    public static int maxSpecialMatrix(int[][] arr, int m, int n) {
        // Start from largest possible size and work down
        for (int size = Math.min(m, n); size >= 1; size--) {
            for (int i = 0; i <= m - size; i++) {
                for (int j = 0; j <= n - size; j++) {
                    if (isSpecialMatrix(arr, i, j, size)) {
                        return size;
                    }
                }
            }
        }
        return 1; // Every 1x1 matrix is special
    }
    
    public static boolean isSpecialMatrix(int[][] arr, int row, int col, int size) {
        if (size == 1) return true; // 1x1 is always special
        
        // Calculate target sum using first row
        int targetSum = 0;
        for (int j = 0; j < size; j++) {
            targetSum += arr[row][col + j];
        }
        
        // Check all rows
        for (int i = 0; i < size; i++) {
            int rowSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += arr[row + i][col + j];
            }
            if (rowSum != targetSum) return false;
        }
        
        // Check all columns
        for (int j = 0; j < size; j++) {
            int colSum = 0;
            for (int i = 0; i < size; i++) {
                colSum += arr[row + i][col + j];
            }
            if (colSum != targetSum) return false;
        }
        
        // Check main diagonal
        int mainDiagSum = 0;
        for (int i = 0; i < size; i++) {
            mainDiagSum += arr[row + i][col + i];
        }
        if (mainDiagSum != targetSum) return false;
        
        // Check anti-diagonal
        int antiDiagSum = 0;
        for (int i = 0; i < size; i++) {
            antiDiagSum += arr[row + i][col + size - 1 - i];
        }
        if (antiDiagSum != targetSum) return false;
        
        return true;
    }
}

// Alternative: Early termination optimization
class EarlyTerminationSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        System.out.println(maxSpecialMatrix(arr, m, n));
    }
    
    public static int maxSpecialMatrix(int[][] arr, int m, int n) {
        for (int size = Math.min(m, n); size >= 1; size--) {
            for (int i = 0; i <= m - size; i++) {
                for (int j = 0; j <= n - size; j++) {
                    if (isSpecialMatrixOptimized(arr, i, j, size)) {
                        return size;
                    }
                }
            }
        }
        return 1;
    }
    
    public static boolean isSpecialMatrixOptimized(int[][] arr, int row, int col, int size) {
        if (size == 1) return true;
        
        // Calculate target sum using first row
        int targetSum = 0;
        for (int j = 0; j < size; j++) {
            targetSum += arr[row][col + j];
        }
        
        // Check rows and columns simultaneously
        for (int i = 0; i < size; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += arr[row + i][col + j];
                colSum += arr[row + j][col + i];
            }
            if (rowSum != targetSum || colSum != targetSum) {
                return false;
            }
        }
        
        // Check diagonals
        int mainDiag = 0, antiDiag = 0;
        for (int i = 0; i < size; i++) {
            mainDiag += arr[row + i][col + i];
            antiDiag += arr[row + i][col + size - 1 - i];
        }
        
        return mainDiag == targetSum && antiDiag == targetSum;
    }
}

// More readable version with detailed comments
class ReadableSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        System.out.println(findLargestSpecialMatrix(matrix, rows, cols));
    }
    
    
    // Finds the largest special (magic) square submatrix
    // A special matrix has equal sums for all rows, columns, and diagonals
     
    public static int findLargestSpecialMatrix(int[][] matrix, int rows, int cols) {
        int maxPossibleSize = Math.min(rows, cols);
        
        // Start from largest possible size and work downward
        // This ensures we find the maximum size special matrix
        for (int size = maxPossibleSize; size >= 1; size--) {
            // Try all possible top-left positions for this size
            for (int startRow = 0; startRow <= rows - size; startRow++) {
                for (int startCol = 0; startCol <= cols - size; startCol++) {
                    if (isMagicSquare(matrix, startRow, startCol, size)) {
                        return size; // Found largest special matrix
                    }
                }
            }
        }
        
        return 1; // Fallback: every 1x1 matrix is special
    }
    
    
    //   Checks if a square submatrix is a magic square
    //  (all rows, columns, and diagonals have equal sums)
     
    private static boolean isMagicSquare(int[][] matrix, int startRow, int startCol, int size) {
        if (size == 1) return true; // Base case
        
        // Calculate expected sum using first row
        int expectedSum = 0;
        for (int j = 0; j < size; j++) {
            expectedSum += matrix[startRow][startCol + j];
        }
        
        // Verify all rows have the expected sum
        for (int i = 0; i < size; i++) {
            int rowSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += matrix[startRow + i][startCol + j];
            }
            if (rowSum != expectedSum) return false;
        }
        
        // Verify all columns have the expected sum
        for (int j = 0; j < size; j++) {
            int colSum = 0;
            for (int i = 0; i < size; i++) {
                colSum += matrix[startRow + i][startCol + j];
            }
            if (colSum != expectedSum) return false;
        }
        
        // Verify main diagonal sum
        int mainDiagonalSum = 0;
        for (int i = 0; i < size; i++) {
            mainDiagonalSum += matrix[startRow + i][startCol + i];
        }
        if (mainDiagonalSum != expectedSum) return false;
        
        // Verify anti-diagonal sum
        int antiDiagonalSum = 0;
        for (int i = 0; i < size; i++) {
            antiDiagonalSum += matrix[startRow + i][startCol + size - 1 - i];
        }
        if (antiDiagonalSum != expectedSum) return false;
        
        return true; // All checks passed - it's a magic square!
    }
}
 */