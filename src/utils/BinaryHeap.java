package utils;


public class BinaryHeap {
    private int[] array;
    private boolean big = false;
    private int size = 0;

    public int[] getArray() {
        return array;
    }

    private void setSize(int size) {
        this.size = size;
    }

    private int getSize() {
        return this.size;
    }


    public void setArray(int[] array) {
        this.array = array;
    }

    public boolean isBig() {
        return big;
    }

    public void setBig(boolean big) {
        this.big = big;
    }

    public BinaryHeap(int[] array) {
        this.array = array;
        setSize(array.length);

    }

    public void buildHeap(boolean big) {
        setBig(big);
        int n = getSize();
        for (int i = (int) ((n - 2) / 2); i >= 0; i--) {
            downAnjust(i);
        }
    }

    public BinaryHeap(int cap) {
        this.array = new int[cap];
    }

    public void add(int value) {
        int newSize = getSize()+1;
        int[] newArray = new int[newSize];
        setSize(newSize);
        newArray[getSize()-1] = value;
        System.arraycopy(this.array, 0, newArray, 0, getSize()-1);
        this.array = newArray;
        upAdjust();
    }

    public void remove() {

    }

    //当给定一个数组时，使用此方法进行初始化最大或最小堆
    private void downAnjust(int pIndex) {
        int n = getSize();
        int childIndex = 2 * pIndex + 1; //左子树
        int tem = this.array[pIndex];
        if (!isBig()) { //最小堆
            while (childIndex < n) {
                if (childIndex + 1 < n && this.array[childIndex + 1] < this.array[childIndex]) {
                    childIndex++;
                }
                if (tem < this.array[childIndex])
                    break;
                this.array[pIndex] = this.array[childIndex];
                pIndex = childIndex;
                childIndex = 2 * childIndex + 1;
            }
            this.array[pIndex] = tem;
        } else { //最大堆
            while (childIndex < n) {
                //当有右子树且右子树的值大于左子树的值，则定位到右子树，让大的数
                if (childIndex + 1 < n && this.array[childIndex + 1] > this.array[childIndex]) {
                    childIndex++;
                }
                /**
                 * 如果父节点的值大于其子节点的值，那么不需要交换
                 */
                if (tem > this.array[childIndex])
                    break;
                this.array[pIndex] = this.array[childIndex];
                pIndex = childIndex;
                childIndex = 2 * childIndex + 1;
            }
            this.array[pIndex] = tem;
        }
    }

    //当插入新元素时，使用此方法进行调整，将元素上浮
    private void upAdjust() {
        int n = getSize();
        int childIndex = n - 1;
        int value = this.array[childIndex];
        int pIndex = (int) (2 * childIndex - 1) / 2;
        if (isBig()) {
            while (childIndex > 0 && value > this.array[pIndex]) {
                this.array[childIndex] = this.array[pIndex];
                childIndex = pIndex;
                pIndex = (int) (2 * childIndex - 1) / 2;
            }
            this.array[childIndex] = value;
        } else {
            while (childIndex > 0 && value < this.array[pIndex]) {
                this.array[childIndex] = this.array[pIndex];
                childIndex = pIndex;
                pIndex = (int) (2 * childIndex - 1) / 2;
            }
            this.array[childIndex] = value;
        }
    }

    public void showHeap() {
        int n = getSize();
        int c = 0;
        int p = 0;
        for (int i = 0; i < n; i++) {
            c++;
            System.out.print(this.array[i] + "  ");
            if (c == Math.pow(2, p)) {
                System.out.println();
                c = 0;
                p++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 10, 8, 11, 18, 19, 34, 15};
        BinaryHeap binaryHeap = new BinaryHeap(a);
        binaryHeap.buildHeap(true);
        binaryHeap.showHeap();
        System.out.println("-----");
        binaryHeap.add(60);
        binaryHeap.showHeap();
        System.out.println("-----");
        binaryHeap.add(100);
        binaryHeap.showHeap();
    }
}
