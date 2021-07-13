package utils.astar;

public class GridNode {
    private int f=0;
    private int g=0;
    private int h=0;
    private GridNode parent;
    private int x;
    private int y;

    public GridNode() {
    }

    public GridNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void init(GridNode parent, GridNode end) {
        this.parent = parent;
        if (parent != null) {
            this.g = parent.g + 1;
        } else
            this.g = 1;
        this.h = Math.abs(this.x - end.x) + Math.abs(this.y-end.y);
        this.f = this.g+this.h;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public GridNode getParent() {
        return parent;
    }

    public void setParent(GridNode parent) {
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
