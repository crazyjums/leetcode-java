package interview;

public class lock {
    private  static Object a = new Object();
    private  static Object b = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("in thread 1 ---a");
                    synchronized (b){
                        System.out.println("in thread 1 ---b");
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    System.out.println("in thread 2 ---b");
                    synchronized (a){
                        System.out.println("in thread 2 ---a");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
