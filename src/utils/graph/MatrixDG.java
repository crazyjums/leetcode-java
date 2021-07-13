package utils.graph;

import java.util.LinkedList;
import java.util.Queue;

/***
 * 有向图
 */
public class MatrixDG {
    private char[] vertexs;
    private int[][] matrix;
    private int[] inDegree;
    private Queue<Integer> topoSeries;

    public MatrixDG(char[][] edges, char[] vertexs) {
        this.vertexs = vertexs;
        this.inDegree = new int[vertexs.length];
        this.matrix = new int[vertexs.length][vertexs.length];
        this.topoSeries = new LinkedList<>();

        for (int i = 0; i < edges.length; i++) {
            int x = getPosition(edges[i][0]);
            int y = getPosition(edges[i][1]);
            int w = Integer.parseInt(String.valueOf(edges[i][2]));
            this.matrix[x][y] = w;
        }
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                if (matrix[i][j] != 0)
                    inDegree[j]++;
            }
        }
    }

    private int getPosition(char c) {
        for (int i = 0; i < vertexs.length; i++) {
            if (c == vertexs[i])
                return i;
        }
        return -1;
    }

    public void printIndegree() {
        System.out.print("入度序列： ");
        for (int i = 0; i < inDegree.length; i++) {
            System.out.print(inDegree[i] + " ");
        }
        System.out.println();
    }

    public void printGraph() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void bfs(int startIndex) {
        boolean[] visited = new boolean[vertexs.length];
        Queue<Integer> queue = new LinkedList<>();
        System.out.print("广度优先遍历： " + vertexs[startIndex] + " ");
        queue.add(startIndex);
        while (!queue.isEmpty()) {
            int curLine = queue.poll();
            for (int i = 0; i < vertexs.length; i++) {
                if (matrix[curLine][i] != 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(vertexs[i] + " ");
                }
            }
        }
        System.out.println();
    }

    public void dfs(int startIndex) {
        boolean[] visited = new boolean[vertexs.length];
        System.out.print("深度优先遍历： ");
        dfs(startIndex, visited);
    }

    private void dfs(int startIndex, boolean[] visited) {
        System.out.print(vertexs[startIndex] + " ");
        visited[startIndex] = true;
        for (int i = 0; i < visited.length; i++) {
            if (matrix[startIndex][i] != 0 && !visited[i])
                dfs(i, visited);
        }
    }

    /**
     * 拓扑排序的思路：不断的将有向图中的入度为0的顶点删除（放入队列序列中，该序列便是最终的拓扑排序结果），
     * 并将该节点对应的所有的出边删除（该节点的入度减1）
     */
    public void topoSort() {
        int num = 0;//表示入度为0的顶点的个数，也就是入队的顶点个数
        Queue<Integer> tem = new LinkedList<>();

        //将入度为0的顶点添加到拓扑排序的序列中
        for (int i = 0; i < vertexs.length; i++) {
            if (inDegree[i] == 0)
                topoSeries.offer(i);
        }

        while (!topoSeries.isEmpty()) {
            int i = topoSeries.peek();
            tem.add(topoSeries.poll());
            num++;
            for (int j = 0; j < vertexs.length; j++) {
                if (matrix[i][j] != 0) {
                    if (--inDegree[j] == 0)
                        topoSeries.offer(j);
                }
            }
        }
        if (num != vertexs.length)
            System.out.println("有环");
        else {
            System.out.print("拓扑排序： ");
            for (int i = 0; i < vertexs.length; i++) {
                System.out.print(vertexs[tem.poll()] + " ");
            }
            System.out.println();
        }
    }

    public boolean isCycle() {
        return false;
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E'};//, 'F', 'G', 'H', 'I', 'J', 'K'};
        char[][] edges = new char[][]{
                {'A', 'B', '9'},
                {'A', 'D', '3'},
                {'B', 'C', '1'},
                {'D', 'C', '5'},
                {'C', 'E', '9'},
                {'E', 'D', '9'},
//                {'A', 'C', '9'},
//                {'A', 'D', '4'},
//                {'A', 'F', '7'},
//                {'C', 'B', '9'},
//                {'C', 'I', '3'},
//                {'D', 'G', '7'},
//                {'D', 'G', '6'},
//                {'I', 'J', '5'},
//                {'F', 'E', '6'},
//                {'G', 'E', '4'},
//                {'D', 'H', '4'},
//                {'B', 'K', '4'},
        };

        MatrixDG matrixDG = new MatrixDG(edges, vexs);
        matrixDG.printGraph();
        matrixDG.printIndegree();
        matrixDG.topoSort();
        matrixDG.bfs(0);
        matrixDG.dfs(0);
    }
}
