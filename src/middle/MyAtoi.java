package middle;

public class MyAtoi {
    public static int atoi(String s) {
        if (s.length() == 0)
            return 0;
        int left = 0;
        StringBuffer res = new StringBuffer();
        int right = s.length();
        while (left < right && s.charAt(left) == ' ') {
            left++;
        }
        if (left < right)
            if (s.charAt(left) == '+' || s.charAt(left) == '-') {
                res.append(s.charAt(left++));
            }
        while (left < right) {
//            if (s.charAt(left) == '-' || s.charAt(left) == '+') {
//                res.delete(0, res.length());
//                break;
//            }
            if (s.charAt(left) >= '0' && s.charAt(left) <= '9') {
                res.append(s.charAt(left++));
            } else {
                break;
            }
        }
        if (res.length() == 0)
            return 0;

        try {
            if (Double.parseDouble(res.toString()) > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (Double.parseDouble(res.toString()) < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        } catch (Exception e) {
            return 0;
        }
        return Integer.parseInt(res.toString());
    }

    public static int strToInt(String str){
        if(str==null || str.length()==0)return 0;

        int left = 0;
        int flag = 1;
        while(str.charAt(left)==' '){
            left++;
        }
        if (left<str.length() && str.charAt(left) == '-') {
            flag = -1;
            left++;
        }else if (left<str.length() && str.charAt(left) == '+'){
            left++;
        }

        if(left<str.length()&&str.charAt(left) >= '0' && str.charAt(left)<='9'){
            if(str.charAt(left) == '-'){
                flag = -1;
                left++;
            }
            String n = "";
            while(left<str.length()&&str.charAt(left) >= '0' && str.charAt(left)<='9' ){
                n += str.charAt(left++);
            }
            long res = atoi2(n)*flag;
            if(res>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(res<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            return (int)res;

        }

        return 0;
    }

    private static long atoi2(String s){
        int len = s.length();
        char[] cc = s.toCharArray();
        long res = 0;
        for(int i=0;i<len;i++){
            res +=(cc[i]-'0')* Math.pow(10,len-i-1);
        }
        return res;
    }

    public static void main(String[] args) {
        //
        String[] ss = {"  -5-", "+-12", "  -ww12", "   +4545"};
        for (String each : ss) {
            System.out.println(strToInt(each));
        }
        long a= 12121212121212L;
        System.out.println(((Integer.MAX_VALUE+1)>>32) != 0);
    }
}
