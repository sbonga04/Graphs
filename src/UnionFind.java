import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnionFind {

    int[] parent;   //parent of vertex i is parent[i]
    int[] rank; //depth of tree for balance// come back to this

    //every vertex is now it's parent
    void makeSet(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i <n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x){
        if (parent[x]  != x){
            parent[x]  = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            }else{
                parent[rootY] = rootX;
                rank[rootX] ++;}

        }
    }

    public List<Edge> kruskalMST(List<Edge> edges, int numVertices) {
        Collections.sort(edges); // uses compareTo from Edge

        makeSet(numVertices); // initialize DSU

        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            int from = edge.getFrom();
            int to = edge.getTo();

            if (find(from) != find(to)) { // no cycle
                union(from, to);
                mst.add(edge);
            }

            if (mst.size() == numVertices - 1) break;
        }

        return mst;
    }
}
