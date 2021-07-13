package utils;

import java.util.Arrays;

/**
 * 并查集的实现
 */
public class UnionSet {
    private int [] parents;
    private int [] rank;//表示构成的树的深度

    public UnionSet(int nodes) {
        this.parents = new int[nodes];
        this.rank = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            this.parents[i] = -1;
            this.rank[i] = 0;
        }
    }

    public int findRoot(int x) {
        int xRoot = x;
        while(this.parents[xRoot] != -1)
            xRoot = this.parents[xRoot];
        return xRoot;
    }

    public boolean unionRoot(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        if (xRoot == yRoot){//如果x和y的父节点相同，表示他们在一个环中
            return true;
        } else {
//            this.parents[xRoot] = yRoot;//把x的父节点设置成y
//            return false;
            if (this.rank[xRoot] > this.rank[yRoot]) {//如果x节点所在集合的深度大于y节点所在集合的深度，则将y集合连接到x集合上，让深度最小
                this.parents[yRoot] = xRoot;
            } else if (this.rank[xRoot] < this.rank[yRoot]) {//
                this.rank[xRoot] = yRoot;
            }else{//如果深度相同，则随意连接，但是对应的集合的rank要加1
                this.parents[xRoot] = yRoot;
                this.rank[yRoot] ++;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0,1},{1,2},{1,3},{2,5},{3,4}//,{4,5}
//                {0,1},{1,2}
        };
        UnionSet set = new UnionSet(6);
        boolean isCycle = false;
        for (int i = 0; i < graph.length; i++) {
            if(set.unionRoot(graph[i][0],graph[i][1])){
                System.out.println("is cycle detected");
                MyPrintFunction.print(set.parents);
                MyPrintFunction.print(set.rank);
                System.exit(0);
            }
        }
        MyPrintFunction.print(set.parents);
        MyPrintFunction.print(set.rank);
        System.out.println("no cycle");

        int[][] a = new int[][]{
                {4,5},{0,1},{1,2},{1,3},{2,5},{3,4}
        };
        Arrays.sort(a, (o1, o2) -> (o1[0] - o2[0]));
        MyPrintFunction.print(a);

    }
}

