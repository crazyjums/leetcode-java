package middle;

public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        int n1=first.length();
        int n2=second.length();
        if (Math.abs(n1-n2)>1)return false;
        int i=0,j=0;
        int tem=1;
        while (i<n1&&j<n2){
            /**
             * 如果两个字符相等，则继续向后遍历
             */
            if (first.charAt(i)==second.charAt(j)){
                i++;
                j++;
            }else if (tem>0&&n1==n2)//如果不相等且两个字符串长度一致，则直接替换
            {
                i++;
                j++;
                tem--;//替换字符
            }else if (tem>0){//如果两个字符串的长度不一致，可以对其中一个进行添加和删除字符
                if (n1>n2){//第一个字符串更长，对第二个字符串添加一个字符
                    tem--;//对第二个字符串添加一个字符
                    i++;
                }else{//第二个字符串更长，对第一个字符串添加一个字符
                    tem--;//对第一个字符串添加一个字符
                    j++;
                }
            }else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "palep";
        String s2 = "ple";
        System.out.println(new OneEditAway().oneEditAway(s1,s2));
    }
}
