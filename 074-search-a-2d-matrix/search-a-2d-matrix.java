// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//
// 	Integers in each row are sorted from left to right.
// 	The first integer of each row is greater than the last integer of the previous row.
//
//
// Example 1:
//
//
// Input:
// matrix = [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// target = 3
// Output: true
//
//
// Example 2:
//
//
// Input:
// matrix = [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// target = 13
// Output: false
//


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return binarySearch(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    
    public boolean binarySearch(int[][] matrix, int target, int beginRow, int beginColumn, int endRow, int endColumn) {
        int rowLength = matrix[0].length;
        int n = (endRow - beginRow) * rowLength + endColumn - beginColumn + 1;
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return target == matrix[beginRow][beginColumn];
        } else {
            int mid = n/2;
            int midColumn = (beginColumn + mid)%rowLength;
            int midRow = beginRow + ((beginColumn + mid)/rowLength);
            if (matrix[midRow][midColumn] < target) {
                midColumn += 1;
                if (midColumn == rowLength) {
                    midColumn = 0;
                    midRow+=1;
                }
                return binarySearch(matrix, target, midRow, midColumn, endRow, endColumn);
            } else if(matrix[midRow][midColumn] > target) {
                midColumn -= 1;
                if (midColumn == -1) {
                    midColumn = rowLength - 1;
                    midRow-=1;
                }
                return binarySearch(matrix, target, beginRow, beginColumn, midRow, midColumn);
            } else {
                return true;
            }
        }
    }
}
