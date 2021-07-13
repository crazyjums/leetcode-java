package secondTime;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    ArrayList<String> res= new ArrayList<>();
    public ArrayList<String> generateParenthesis (int n) {
        backTrack(0,0,n,"");
        return res;
    }

    private void backTrack(int left, int right, int n, String s) {

        if (s.length()==2*n){
            res.add(s);
            return;
        }
        if (left<n)
            backTrack(left+1,right,n,s+"(");
        if (right<left && right<n)
            backTrack(left,right+1,n,s+")");
    }

    public static void main(String[] args) {
        List<String> r = new generateParenthesis().generateParenthesis(3);
        MyPrintFunction.print(r);
    }
}
