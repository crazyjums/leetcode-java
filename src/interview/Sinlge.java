package interview;

public class Sinlge {
    private static volatile Sinlge sinlge;
    public Sinlge getInstance(){
        if (sinlge==null){
            synchronized (Sinlge.class){
                if (sinlge==null)
                    sinlge = new Sinlge();
            }
        }
        return sinlge;
    }

    public static void main(String[] args) {
//        int a,b;
//        //线程1
//        Sinlge sinlge = new Sinlge();//1
//        boolean f = false;//2
//        //线程2
//        while (!f)//3
//            System.out.println("线程2");
//        doSomething(sinlge);//4
        int l=1,r=5;
        System.out.println(l+(r-l)>>1);
        System.out.println((l + ((r-l)>>1)));
        System.out.println(l+(r-l)/2);
    }

    private static void doSomething(Sinlge sinlge) {
    }
}
