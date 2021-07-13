package test;

import java.util.*;

public class Search {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int [] rooms=new int[n],ins=new int[n],outs=new int[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rooms[i]=scanner.nextInt();
            ins[i]=scanner.nextInt();
            outs[i]=scanner.nextInt();
            if (a>=ins[i]&&a<=outs[i])
                res.add(rooms[i]);
        }

        if (res.size()==0)
            System.out.println("null");
        else{
            Collections.sort(res);
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i));
            }
        }
    }
}
