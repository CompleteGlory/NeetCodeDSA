package Trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTree {

    public TreeNode insertBST( TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val<val){
            root.right = insertBST(root.right,val);
        }else if(root.val>val){
            root.left = insertBST(root.left,val);
        }
        return root;
    }

    public TreeNode removeBST(TreeNode root, int val){
        if(root ==null){
            return  null;
        }
        // Search for the value at first
        if(val>root.val){
            root.right = removeBST(root.right,val);
        }else if (val<root.val) {
            root.left = removeBST(root.left, val);
        }else{
            // we found the value we want to delete, first check if it has 0 or 1 child
            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }else{
                // Has more than 1 child:
                // 1.find min of the right subtree
                TreeNode min = findMinOfBST(root.right);
                // 2.replace it with the value we are deleting
                root.val = min.val;
                // 3.remove it from below (100% will execute removal in the previous cases)
                root.right = removeBST(root.right, min.val);
            }
        }
        return root;
    }

    public boolean BstSearch(TreeNode root,int target) {
        if (root == null) {
            return false;
        }
        if (target > root.val) {
            return BstSearch(root.left, target);
        } else if (target < root.val) {
            return BstSearch(root.right, target);
        } else {
            return true;
        }
    }

    public TreeNode findMinOfBST(TreeNode root){
        TreeNode cur = root;
        while(cur != null && cur.left != null){
            cur = cur.left;
        }
        return cur;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    public ArrayList<ArrayList<Integer>> BFS(TreeNode root){
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for(int i =0;i< size;i++){
                TreeNode current = queue.poll();
                level.add(current.val);
                if(current.left !=null){
                    queue.offer(current.left);
                }if (current.right !=null) {
                    queue.offer(current.right);
                }
            }
            answer.add(level);
        }
        return answer;
    }

    // Prints the tree as a proper 2D diagram, e.g.:
    //         _______ 80 _______
    //        /                  \
    //     _ 48 _              _ 92 _
    //    /      \            /      \
    //  35       52         82       98
    //    \       \        /
    //     40      53    83
    public void print(TreeNode root){
        if(root == null){
            return;
        }
        for(String line : _buildTreeString(root).lines){
            System.out.println(line);
        }
    }

    public TreeNode insert(TreeNode root, int v) {
        TreeNode newNode = new TreeNode(v);

        // Empty tree
        if (root == null) {
            return newNode;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Insert as left child if possible
            if (current.left == null) {
                current.left = newNode;
                return root;
            } else {
                queue.offer(current.left);
            }

            // Insert as right child if possible
            if (current.right == null) {
                current.right = newNode;
                return root;
            } else {
                queue.offer(current.right);
            }
        }

        return root;
    }

    // A rendered subtree: its text lines (all padded to `width`), plus the
    // column range [rootStart, rootEnd] the root's own label occupies in
    // line 0 — needed so the parent knows where to aim its slash/underscore.
    private static class Box {
        List<String> lines;
        int width;
        int rootStart;
        int rootEnd;
        Box(List<String> lines, int width, int rootStart, int rootEnd){
            this.lines = lines;
            this.width = width;
            this.rootStart = rootStart;
            this.rootEnd = rootEnd;
        }
    }

    private Box _buildTreeString(TreeNode node){
        if(node == null){
            return new Box(new ArrayList<>(), 0, 0, 0);
        }

        String nodeRepr = String.valueOf(node.val);
        int newRootWidth = nodeRepr.length();
        int gapSize = newRootWidth;

        Box lBox = _buildTreeString(node.left);
        Box rBox = _buildTreeString(node.right);

        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        int newRootStart;

        // branch down to the left subtree: underscores + '/'
        if(lBox.width > 0){
            int lRoot = (lBox.rootStart + lBox.rootEnd) / 2 + 1;
            line1.append(" ".repeat(lRoot + 1));
            line1.append("_".repeat(lBox.width - lRoot));
            line2.append(" ".repeat(lRoot)).append("/");
            line2.append(" ".repeat(lBox.width - lRoot));
            newRootStart = lBox.width + 1;
            gapSize += 1;
        } else {
            newRootStart = 0;
        }

        line1.append(nodeRepr);
        line2.append(" ".repeat(newRootWidth));

        // branch down to the right subtree: underscores + '\'
        if(rBox.width > 0){
            int rRoot = (rBox.rootStart + rBox.rootEnd) / 2;
            line1.append("_".repeat(rRoot));
            line1.append(" ".repeat(rBox.width - rRoot + 1));
            line2.append(" ".repeat(rRoot)).append("\\");
            line2.append(" ".repeat(rBox.width - rRoot - 1));
            gapSize += 1;
        }

        int newRootEnd = newRootStart + newRootWidth - 1;
        String gap = " ".repeat(gapSize);

        List<String> newBox = new ArrayList<>();
        newBox.add(line1.toString());
        newBox.add(line2.toString());

        int maxLines = Math.max(lBox.lines.size(), rBox.lines.size());
        for(int i = 0; i < maxLines; i++){
            String lLine = i < lBox.lines.size() ? lBox.lines.get(i) : " ".repeat(lBox.width);
            String rLine = i < rBox.lines.size() ? rBox.lines.get(i) : " ".repeat(rBox.width);
            newBox.add(lLine + gap + rLine);
        }

        return new Box(newBox, line1.length(), newRootStart, newRootEnd);
    }
}



