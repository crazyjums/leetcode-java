package utils.lru;

public class DNode {
    int key,val;
    DNode pre,next;

    public DNode(int val) {
        this.val = val;
    }

    public DNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
