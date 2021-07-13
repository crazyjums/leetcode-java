package middle;

public class IsExponential {
    //暴力破解 O(logn)
    public boolean isExponential(int target){
        int t = 1;
        while (t<=target){
            if (t==target)
                return true;
            t *= 2;
        }
        return false;
    }

    //小优化  O(logn)
    public boolean isExponential2(int target){
        int t = 1;
        while (t<=target){
            if (t==target)
                return true;
            t =t<< 1;
        }
        return false;
    }

    //使用位运算
    public boolean isExponential3(int target){
        return (target & (target - 1))==0 ?true: false;
    }

    public static void main(String[] args) {
        int target = 17;
        IsExponential isExponential = new IsExponential();
        System.out.println(isExponential.isExponential(target));
        System.out.println(isExponential.isExponential2(target));
        System.out.println(isExponential.isExponential3(target));
    }
}
