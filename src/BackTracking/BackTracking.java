package BackTracking;

import Trees.TreeNode;

import java.util.ArrayList;

public class BackTracking {
    // Tree maze is a function that returns true if there's a path from the root to any of the leaf nodes
    // that we can reach without passing by a node that's value is 0
    public boolean canReachLeaf(TreeNode root){
        if(root == null || root.val == 0){
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

    // To apply backTracking here we can make the case that we return the pass as a list
    public boolean canReachLeafPath(TreeNode root, ArrayList<Integer> path){
        if(root == null || root.val == 0){
            return false;
        }
        path.add(root.val);
        if(root.left==null && root.right==null){
            return true;
        }
        if (canReachLeafPath(root.left,path)){
            return true;
        }if (canReachLeafPath(root.right,path)){
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}
