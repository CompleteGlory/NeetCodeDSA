package BackTracking;

import Trees.TreeNode;
// Tree maze is a function that returns true if there's a path from the root to any of the leaf nodes
// that we can reach without passing by a node that's value is 0
public class TreeMaze {
    public boolean canReachLeaf(TreeNode root){
        if(root.val ==0 || root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        if (canReachLeaf(root.left)){
            return true;
        }if (canReachLeaf(root.right)){
            return true;
        }
        return false;
    }
}
