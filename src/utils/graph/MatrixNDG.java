package utils.graph;

import org.omg.CORBA.PUBLIC_MEMBER;
import utils.MyPrintFunction;

import java.util.*;

public class MatrixNDG {

    int size;//图顶点个数
    char[] vertexs;//图顶点名称
    int[][] matrix;//图关系矩阵

    public MatrixNDG(char[] vertexs, char[][] edges, boolean isWeight) {
        size = vertexs.length;
        matrix = new int[size][size];//设定图关系矩阵大小
        this.vertexs = vertexs;
        if (!isWeight)
            for (char[] c : edges) {//设置矩阵值
                int p1 = getPosition(c[0]);//根据顶点名称确定对应矩阵下标
                int p2 = getPosition(c[1]);

                matrix[p1][p2] = 1;//无向图，在两个对称位置存储
                matrix[p2][p1] = 1;
            }
        else
            for (char[] c : edges) {//设置矩阵值
                int p1 = getPosition(c[0]);//根据顶点名称确定对应矩阵下标
                int p2 = getPosition(c[1]);
                int w = c[2] - '0';

                matrix[p1][p2] = w;//无向图，在两个对称位置存储
                matrix[p2][p1] = w;
            }
    }


    //图的遍历输出
    public void print() {
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    //根据顶点名称获取对应的矩阵下标
    private int getPosition(char ch) {
        return ch - 'A';
//        for (int i = 0; i < vertexs.length; i++)
//            if (vertexs[i] == ch)
//                return i;
//        return -1;
    }

    /**
     * @param index 开始遍历的顶点
     */
    public void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertexs.length];

        System.out.print(vertexs[index] + " ");
        visited[index] = true;
        queue.add(index);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < vertexs.length; i++) {
                if (matrix[cur][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    System.out.print(vertexs[i] + " ");
                }
            }
        }
    }

    /**
     * @param visited 标记哪些顶点被访问过
     * @param index   遍历的顶点的索引
     */
    private void dfs(boolean[] visited, int index) {
        System.out.print(vertexs[index] + " ");
        visited[index] = true;

        for (int i = 0; i < vertexs.length; i++) {
            if (matrix[index][i] != 0 && !visited[i]) {
                dfs(visited, i);
            }
        }
    }

    public void dfs(int index) {
        boolean[] visited = new boolean[vertexs.length];
        dfs(visited, index);
    }


    public void bfs2(int index) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertexs.length];
        System.out.print(vertexs[index] + " ");
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int curIndex = queue.poll();
            for (int i = 0; i < vertexs.length; i++) {
                if (matrix[curIndex][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    System.out.print(vertexs[i] + " ");
                }
            }
        }
    }

    public boolean isCycle() {
        int[] parents = new int[vertexs.length];
        int[] rank = new int[vertexs.length];
        Arrays.fill(parents, -1);
        List<int[]> edges = new ArrayList<>();
        //将图的邻接矩阵表示转换成顶点表示，如[[1,2], [2,3], ...]，表示顶点1和顶点2相连...
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < j; i++) {
                if (matrix[i][j] != 0)
                    edges.add(new int[]{i, j});
            }
        }
        for (int i = 0; i < edges.size(); i++) {
            if (unionSet(edges.get(i)[0], edges.get(i)[1], rank, parents))
                return true;
        }
        return false;
    }

    private int findRoot(int x, int[] parents) {
        int x_root = x;
        while (parents[x_root] != -1) {
            x_root = parents[x_root];
        }
        return x_root;
    }

    private boolean unionSet(int x, int y, int[] rank, int[] parents) {
        int x_root = findRoot(x, parents);
        int y_root = findRoot(y, parents);
        if (x_root == y_root) {
            return true;
        } else {
            if (rank[x_root] > rank[y_root]) {
                parents[y_root] = x_root;
            } else if (rank[x_root] < rank[y_root]) {
                parents[x_root] = y_root;
            } else {
                parents[x_root] = y_root;
                rank[y_root]++;
            }
            return false;
        }
    }


    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        char[][] edges = new char[][]{
                {'A', 'C', '1'},
                {'A', 'D', '4'},
                {'A', 'F', '7'},
                {'C', 'B', '9'},
                {'C', 'I', '3'},
                {'D', 'G', '7'},
                {'I', 'J', '5'},
                {'C', 'D', '6'},
        };
        MatrixNDG pG;
        // 自定义"图"(输入矩阵队列)
        // 采用已有的"图"
        pG = new MatrixNDG(vexs, edges, true);
        pG.print();   // 打印图

        System.out.print("深度优先搜索：");
        pG.dfs(0);
        System.out.println();
        System.out.print("广度优先搜索：");
        pG.bfs(0);

        System.out.println();
        System.out.print("广度优先搜索2：");
        pG.bfs2(0);


        System.out.println();
        System.out.println(pG.isCycle());
    }
}