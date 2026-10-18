package Graphs;// GraphNode used for adjacency list
/* 
public class GraphNode {
    int val;
    List<GraphNode> neighbors;
    
    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<GraphNode>();
    }
}
*/

import java.util.*;

public class AdjacencyList {

    public  HashMap<String, ArrayList<String>> buildAdjList() {
        HashMap<String, ArrayList<String>> adjList = new HashMap<>();

        String[][] edges = {{"A", "B"}, {"B", "C"}, {"B", "E"}, {"C", "E"}, {"E", "D"}};
        HashSet<String> visit = new HashSet<>();

        adjList.put("A", new ArrayList<String>());
        adjList.put("B", new ArrayList<String>());

        for (String[] edge: edges) {
            String src = edge[0], dst = edge[1];
            if (!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList<String>());
            }
            if (!adjList.containsKey(dst)) {
                adjList.put(dst, new ArrayList<String>());
            }
            adjList.get(src).add(dst);
        }
        return adjList;
    }

    // Count paths (backtracking)
    public int dfs(String node, String target, HashMap<String,ArrayList<String>> adjList , HashSet<String> visit) {
        if(visit.contains(node)){
            return 0;
        }
        if (node == target){
            return 1;
        }

        visit.add(node);
        int count = 0;
        for(String neighbour : adjList.get(node)){
            count += dfs(neighbour, target, adjList,visit);
        }
        visit.remove(node);
        return count;
    }

    // Shortest path from node to target.
    public int bfs(String node, String target, HashMap<String, ArrayList<String>> adjList) {
        int length = 0;
        HashSet<String> visit = new HashSet<>();
        visit.add(node);
        Queue<String> q = new LinkedList<String>();
        q.offer(node);
        while(!q.isEmpty()){
            int qLength = q.size();
            for (int i = 0; i< qLength ; i++){
                String cur = q.poll();
                if(Objects.equals(cur, target)){
                    return length;
                }
                for(String neighbour : adjList.get(cur)){
                    if(!visit.contains(neighbour)){
                        visit.add(neighbour);
                        q.add(neighbour);
                    }
                }
            }
            length++;
        }
        return length;
    }
}