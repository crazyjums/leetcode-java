package secondTime;

public class MySqrt {
    public static int sqrt(int x) {
        if (x <= 1)
            return x;
        int res=1;
        //二分法
        int left=1,right=x;
        while (left<=right){
            int mid=(left+right)/2;
            if (x/mid==mid){
                return mid;
            }
            else if(x/mid>mid){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }
        return left-1;
    }

    public static void main(String[] args) {
        int x = 800;
        System.out.println(sqrt(x));
    }
}
