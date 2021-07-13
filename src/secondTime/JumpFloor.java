package secondTime;

public class JumpFloor {
    public int jumpFloor(int target) {
        if (target<3)
            return target;
        int m1=1;
        int m2=2;
        int m3=m1+m2;
        for (int i = 2; i < target; i++) {
            m3=m1+m2;
            m1=m2;
            m2=m3;
        }
        return m3;
    }

    public static void main(String[] args) {
        int n=4;
        System.out.println(new JumpFloor().jumpFloor(n));
    }
}
