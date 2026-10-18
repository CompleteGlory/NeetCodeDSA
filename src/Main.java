import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import BackTracking.BackTracking;
import DynamicProgramming.TwoDimensionalDP;
import Graphs.AdjacencyList;
import Graphs.MatrixDFS;
import Trees.BinaryTree;
import Trees.TreeNode;
import sorting.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        int[] nums = {2, 1, 2, 0, 0, 2};
//        int[] arr = {3, 1, 2, 5, 4};
        //        InsertionSort insertion = new InsertionSort();
        //        insertion.sort(nums);
        //        MergeSort merge = new MergeSort();
        //        merge.mergeSort(nums,0,nums.length-1);
//        QuickSort quick = new QuickSort();
//        quick.quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
//        BucketSort bucket = new BucketSort();
//        bucket.sort(nums,3);
//        System.out.println(Arrays.toString(nums));
//        BinaryTree tree = new BinaryTree();
//        TreeNode root = null;
//        int[] treeVals = {5, 1, 0, 0, 4};
//        for (int v : treeVals) {
//            root = tree.insert(root, v);
//        }
//        tree.print(root); // in-order traversal -> prints sorted: 1 3 4 5 8
//        System.out.println(tree.BFS(root));
//        tree.print(tree.findMinOfBST(root));
//        tree.removeBST(root,5);
//        tree.print(root);
//        System.out.println(tree.BFS(root));
//        BackTracking t= new BackTracking();
//        System.out.println(t.canReachLeaf(root));
//        ArrayList<Integer> path = new ArrayList<>();
//        t.canReachLeafPath(root,path);
//        System.out.println(path);
        AdjacencyList list = new AdjacencyList();
        HashMap<String, ArrayList<String>> adjList = new HashMap<>();
        System.out.println(list.dfs("A","E", list.buildAdjList(),new HashSet<>()));
        System.out.println(list.bfs("A","D", list.buildAdjList()));
        TwoDimensionalDP d = new TwoDimensionalDP();
        int[][] cache = new int[4][4];
        System.out.println(d.memoization(0,0,4,4,cache));
        System.out.println(d.dp(4,4));
    }
}