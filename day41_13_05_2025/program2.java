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