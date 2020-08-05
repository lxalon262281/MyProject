package com.lx.demo.arithmetic.myleetcode;

import java.util.ArrayList;
import java.util.List;

public class 找出N以下的质数 {

    public List<Integer> getAllPrimeNumber(int n){
        List<Integer> primes = new ArrayList<Integer>();
        for(int i = n; i >1 ; i--){
            boolean flag = true;
            for(int j = i-1; j > 1; j--){
                if(i%j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                primes.add(i);
            }
        }
        return primes;
    }

}
