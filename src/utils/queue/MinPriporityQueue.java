package utils.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小优先队列
 */
public class MinPriporityQueue {
    private List<Integer> array;

    public MinPriporityQueue() {
        array = new ArrayList<>();
    }

    public MinPriporityQueue(List<Integer> array) {
        this.array = array;
        buildHeap();
    }

    public void add(int value) {
        this.array.add(value);
        upAdjust(this.array.size()-1);
    }

    private void buildHeap() {
        int n = this.array.size();
        for (int i = (n-2)/2; i >-1; i--) {
            downAdjust(i);
        }
    }

    private void upAdjust(int childIndex) {
        int parentIndex = (int)(childIndex -1)/2;
        int tem = this.array.get(childIndex);
        while (childIndex > 0 && tem < this.array.get(parentIndex)){
            this.array.set(childIndex,this.array.get(parentIndex));  //将父节点的值赋值给子节点
            childIndex = parentIndex; //交换父子节点坐标
            this.array.set(childIndex,tem); //将子节点的值赋值给父节点
            parentIndex = (int)(childIndex -1)/2; //继续上浮
        }
    }

    private void downAdjust(int parentIndex) {
        int n = this.array.size();
        int childIndex = 2 * parentIndex + 1;
        int tem = this.array.get(parentIndex);
        while (childIndex < n){
            if (childIndex + 1 < n && this.array.get(childIndex+1) < this.array.get(childIndex))
                childIndex++;
            if (tem <= this.array.get(childIndex))
                break;
            this.array.set(parentIndex,this.array.get(childIndex));  //将子节点的值赋值给父节点
            parentIndex = childIndex; //交换父子节点坐标
            this.array.set(parentIndex,tem); //将子节点的值赋值给父节点
            childIndex = 2 * parentIndex + 1; //继续下沉
        }
    }

    public int get() {
        if (this.array.size() != 0)
            return this.array.get(0);
        else
            return Integer.MIN_VALUE;
    }

    public int remove(){
        int res=Integer.MIN_VALUE;
        int n = this.array.size();
        if (n!=0){
            res = this.array.get(0);
            this.array.set(0,this.array.get(n-1));
            this.array.remove(n-1);
            buildHeap();
        }
        return res;
    }

    public void showData() {
        if (this.array.size() != 0)
            for (int i = 0; i < this.array.size(); i++) {
                System.out.print(this.array.get(i) + "  ");
            }
        else
            System.out.print("空队列！！！");
        System.out.println();

    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        for (int i = 10; i >0; i--) {
            a.add(i);
        }

        MinPriporityQueue minPriporityQueue = new MinPriporityQueue();
        minPriporityQueue.add(1);
        minPriporityQueue.add(4);
        minPriporityQueue.add(12);
        minPriporityQueue.add(15);
        minPriporityQueue.add(5);
        minPriporityQueue.add(19);
        minPriporityQueue.add(30);
        minPriporityQueue.add(18);
        minPriporityQueue.add(23);
        minPriporityQueue.add(0);

        minPriporityQueue.showData();

        minPriporityQueue.remove();
        minPriporityQueue.showData();

        minPriporityQueue.add(3);
        minPriporityQueue.showData();

        minPriporityQueue.remove();
        minPriporityQueue.showData();
        minPriporityQueue.remove();
        minPriporityQueue.showData();
        minPriporityQueue.remove();
        minPriporityQueue.showData();
        minPriporityQueue.remove();
        minPriporityQueue.showData();
        minPriporityQueue.remove();
        minPriporityQueue.showData();
    }
}
