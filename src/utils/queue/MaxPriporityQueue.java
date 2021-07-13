package utils.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大优先队列
 */
public class MaxPriporityQueue {
    private List<Integer> array;

    public MaxPriporityQueue() {
        array = new ArrayList<>();
    }

    public MaxPriporityQueue(List<Integer> array) {
        this.array = array;
        buildHeap();
    }

    public void add(int value) {
        this.array.add(value);
        upAdjust(this.array.size()-1);
    }

    private void buildHeap() {
        int n = this.array.size();
        for (int i = n-1; i >-1; i--) {
            upAdjust(i);
        }
    }

    private void upAdjust(int childIndex) {
        int parentIndex = (int)(childIndex -1)/2;
        int tem = this.array.get(childIndex);
        while (childIndex > 0 && tem > this.array.get(parentIndex)){
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
        for (int i = 1; i < 8; i++) {
            a.add(i);
        }

        MaxPriporityQueue maxPriporityQueue = new MaxPriporityQueue();
        maxPriporityQueue.add(1);
        maxPriporityQueue.add(4);
        maxPriporityQueue.add(12);
        maxPriporityQueue.add(15);
        maxPriporityQueue.add(5);
        maxPriporityQueue.add(19);
        maxPriporityQueue.add(30);
        maxPriporityQueue.add(18);
        maxPriporityQueue.add(23);
        maxPriporityQueue.add(0);

        maxPriporityQueue.showData();

        maxPriporityQueue.remove();
        maxPriporityQueue.showData();
        maxPriporityQueue.remove();
        maxPriporityQueue.showData();
        maxPriporityQueue.remove();
        maxPriporityQueue.showData();
        maxPriporityQueue.remove();
        maxPriporityQueue.showData();
        maxPriporityQueue.remove();
        maxPriporityQueue.showData();
        maxPriporityQueue.remove();
        maxPriporityQueue.showData();
    }

}
