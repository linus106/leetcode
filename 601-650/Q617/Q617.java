package com.thunisoft.leetcode;


public class Q617 {

    public static void main(String[] args) {
        //        mergeTrees(1,4);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null && t2==null) {
            return null;
        }
        int valueFromT1 = t1==null ? 0 : t1.val;
        int valueFromT2 = t2==null ? 0 : t2.val;
        int value = valueFromT1 + valueFromT2;
        
        TreeNode root = new TreeNode(value);
        root.left = mergeTrees(t1!=null?t1.left : null, t2!=null?t2.left : null);
        root.right = mergeTrees(t1!=null?t1.right : null, t2!=null?t2.right : null);
        return root;
    }
    
    

    private class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
