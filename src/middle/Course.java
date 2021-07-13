package middle;

import java.util.LinkedList;
import java.util.Queue;

public class Course {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //拓扑排序
        int[] indegree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];
        Queue<Integer> queue = new LinkedList<>();

        //计算入度
        for (int i = 0; i < prerequisites.length; i ++) {
            indegree[prerequisites[i][1]] ++;
            matrix[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }

        //将入度为0的节点添加到队列
        for (int i = 0; i < indegree.length; i ++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int num = 0;//删除的节点
        while (!queue.isEmpty()) {
            int i = queue.poll();
            num ++;
            for (int j = 0; j < numCourses; j++) {
                if (matrix[i][j] == 1)
                    if (--indegree[j] == 0)
                        queue.add(j);
            }
        }

        return num == numCourses;

    }

    public static void main(String[] args) {
        int n = 3;
        int [][] nums = {{0,2},{1,2},{2,0}};
        System.out.println(new Course().canFinish(n,nums));
    }
}
