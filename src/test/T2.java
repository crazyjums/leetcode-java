package test;

import sun.security.krb5.internal.PAData;
import utils.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T2 {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> getRes(int[] nums,int n) {
        List<Integer> path = new ArrayList<>();
        backTrack(nums, path,n);
        return res;
    }

    private static void backTrack(int[] nums, List<Integer> path,int n) {
        if (path.size()==n&&isValid(path)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i]))
                continue;
            path.add(nums[i]);
            backTrack(nums, path,n);
            path.remove(path.size() - 1);
        }
    }

    private static boolean isValid(List<Integer> path) {
        if (path.size() > 0) {
            int r = path.get(0);
            int t = r;
            for (int i = 1; i < path.size(); i++) {
                if (r>=path.get(i))
                    return false;
                r = (r & path.get(i));
            }
            if (r == t)
                return true;
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] nums= new int[n];
        int i=1;
        while (scanner.hasNext() && i<n){
            nums[i++]=scanner.nextInt();
        }
        for (int j = 2; j < n; j++) {
            getRes(nums,j);
        }
        System.out.println(res.size());

    }
}
