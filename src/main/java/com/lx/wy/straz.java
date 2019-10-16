package com.lx.wy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class straz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<String> result = new ArrayList<>();
        dfs(n, m, k, "", result);
        System.out.println(result);
    }

    static boolean flag = false;

    public static void dfs(int n, int m, int k, String s, List<String> result) {
        if (n == 0 && m == 0) {
            result.add(s);
            if (result.size() == k) {
                //System.out.println(result);
                flag = true;
            }
            return;
        }
        if (flag) {
            return;
        }
        if (n > 0) {
            dfs(n - 1, m, k, s + 'a', result);
        }
        if (m > 0) {
            dfs(n, m - 1, k, s + 'z', result);
        }
    }
}
