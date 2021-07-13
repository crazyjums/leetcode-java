package interview;
//不在volatile关键字，线程2修改的只是线程2中的flag的一个拷贝，因为线程1和2都用到了flag，所以他们各自
//会在虚拟机栈中拷贝一份该变量，但是由于没有volatile的修饰，线程2不能讲该值写回到方法区中，
//此时线程1所读取到的值依旧是原来的值
//加上volatile关键字，线程2对flag的修改将会写回到方法区中，此时flag的值将会变成true

public class volatileTest {
    private volatile static boolean flag = false;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是线程1.。。");
                while (flag==false){
                }
                System.out.println("我结束了");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我是线程2...");
                change();
                System.out.println("我改完了。。。");
            }
        }).start();
    }
    private static void change(){
        flag=true;
    }
}
