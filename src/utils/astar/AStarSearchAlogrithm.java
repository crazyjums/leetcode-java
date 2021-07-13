package utils.astar;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class AStarSearchAlogrithm {
    public static void main(String[] args) {
        int[][] route = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
        };
        GridNode start = new GridNode(2, 1);
        GridNode end = new GridNode(2, 5);
        AStarSearchAlogrithm aStarSearchAlogrithm = new AStarSearchAlogrithm(route, end);
        GridNode res = aStarSearchAlogrithm.aStarSearch(start);
//        if (res != null)
//            System.out.println(res.getX() + " " + res.getY());
//        else
//            System.out.println(res);

        List<GridNode> road = new ArrayList<>();
        while (res != null) {
            road.add(res.getParent());
            res = res.getParent();
        }
        for (int i = 0; i < road.size()-1; i++) {
            route[road.get(i).getX()][road.get(i).getY()] = 9;
        }
        for (int i = 0; i < route.length; i++) {
            for (int j = 0; j < route[0].length; j++) {
                System.out.print(route[i][j] + " ");
            }
            System.out.println();
        }
    }

    private List<GridNode> openList;// = new ArrayList<>();
    private List<GridNode> closeList;// = new ArrayList<>();
    private int[][] route;
    private GridNode end;

    public AStarSearchAlogrithm(int[][] route, GridNode end) {
        openList = new ArrayList<>();
        closeList = new ArrayList<>();
        this.route = route;
        this.end = end;
    }

    /**
     * 寻找算法
     *
     * @param start
     * @return
     */
    public GridNode aStarSearch(GridNode start) {
        this.openList.add(start);
//        int co = 1;
        while (this.openList.size() > 0) {
//            System.out.println("第"+co+"次运行...");
//            co++;
            GridNode cur = findMinFValue();
            this.openList.remove(cur);
            this.closeList.add(cur);
//            printList("openlist",openList);
//            printList("closelist",closeList);
            List<GridNode> neighbors = this.findNeighbors(cur);
            for (int i = 0; i < neighbors.size(); i++) {
                if (!this.containGrid(this.openList, neighbors.get(i).getX(), neighbors.get(i).getY())) {
                    neighbors.get(i).init(cur, this.end);
                    this.openList.add(neighbors.get(i));
                }
            }
            for (int i = 0; i < this.openList.size(); i++) {
                if (this.openList.get(i).getX() == this.end.getX() && this.openList.get(i).getY() == this.end.getY())
                    return this.openList.get(i);
            }
        }
        return null;
    }

    private void printList(String name, List<GridNode> open) {
        System.out.println("---" + name + "----");
        if (open.size() == 0)
            System.out.println("空列表。。。");
        for (int i = 0; i < open.size(); i++) {
            System.out.println("x=" + open.get(i).getX() + ",y=" + open.get(i).getY() + ",f=" + open.get(i).getF());
        }
        System.out.println("-------");
    }

    /**
     * 获取openlist中F值最小的节点
     * <p>
     * //     * @param this.openList
     *
     * @return
     */
    public GridNode findMinFValue() {
        GridNode tem = this.openList.get(0);
        for (int i = 0; i < this.openList.size(); i++) {
            if (tem.getF() > this.openList.get(i).getF())
                tem = this.openList.get(i);
        }
        return tem;
    }

    /**
     * 寻找当前节点的邻居节点
     *
     * @param cur
     * @return
     */
    public List<GridNode> findNeighbors(GridNode cur) {
        List<GridNode> neighbors = new ArrayList<>();
        if (isValid(cur.getX(), cur.getY() - 1))
            neighbors.add(new GridNode(cur.getX(), cur.getY() - 1));
        if (isValid(cur.getX(), cur.getY() + 1))
            neighbors.add(new GridNode(cur.getX(), cur.getY() + 1));
        if (isValid(cur.getX() - 1, cur.getY()))
            neighbors.add(new GridNode(cur.getX() - 1, cur.getY()));
        if (isValid(cur.getX() + 1, cur.getY()))
            neighbors.add(new GridNode(cur.getX() + 1, cur.getY()));
        return neighbors;
    }

    /**
     * 判断openlist中是否含有该节点
     *
     * @param x
     * @param y
     * @return
     */
    public boolean containGrid(List<GridNode> open, int x, int y) {
        for (int i = 0; i < open.size(); i++) {
            if (x == open.get(i).getX() && y == open.get(i).getY())
                return true;
        }
        return false;
    }

    public boolean isValid(int x, int y) {
        //越过边界
        if (x < 0 || x >= this.route.length || y < 0 || y >= this.route[0].length)
            return false;
        //当前节点有障碍物
        if (this.route[x][y] == 1)
            return false;
        //在open列表中
        if (containGrid(this.openList, x, y))
            return false;
        //在close列表中
        if (containGrid(this.closeList, x, y))
            return false;
        return true;
    }
}
