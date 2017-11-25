package com.thunisoft.leetcode;

public class Q74 {

    public static void main(String[] args) {
//        int[][] matrix = {
//                     {1,   3,  5,  7},
//                     {10, 11, 16, 20},
//                     {23, 30, 34, 50}
//                   };
        int[][] matrix = {{1}};

        System.out.println(searchMatrix(matrix, 15));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return binarySearch(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    
    public static boolean binarySearch(int[][] matrix, int target, int beginRow, int beginColumn, int endRow, int endColumn) {
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
