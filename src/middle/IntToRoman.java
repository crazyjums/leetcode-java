package middle;

public class IntToRoman {
    public String intToRoman(int num) {
        /**
         * 思路：从大到小寻找，每次寻找所能表示的最大罗马符号
         */
        StringBuffer res = new StringBuffer();
        while (num!=0){
            if (num>=1000){
                num-=1000;
                res.append("M");
            }else if (num>=900){
                num-=900;
                res.append("CM");
            }else if (num>=500){
                num-=500;
                res.append("D");
            }else if (num>=400){
                num-=400;
                res.append("CD");
            }else if (num>=100){
                num-=100;
                res.append("C");
            }else if (num>=90){
                num-=90;
                res.append("XC");
            }else if (num>=50){
                num-=50;
                res.append("L");
            }else if (num>=40){
                num-=40;
                res.append("XL");
            }else if (num>=10){
                num-=10;
                res.append("X");
            }else if (num>=9){
                num-=9;
                res.append("IX");
            }else if (num>=5){
                num-=5;
                res.append("V");
            }else if (num>=4){
                num-=4;
                res.append("IV");
            }else if (num>=1){
                num-=1;
                res.append("I");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = new IntToRoman().intToRoman(2020);
        System.out.println(s);
    }
}
