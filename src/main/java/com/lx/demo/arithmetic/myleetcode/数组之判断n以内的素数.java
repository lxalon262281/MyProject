package com.lx.demo.arithmetic.myleetcode;

public class 数组之判断n以内的素数 {
    /**
     * memset(prime, false, LENGTH);//全部置 0；
     prime[2] = true;//偶数2为素数；
     for (int i = 3; i < LENGTH;i+=2)//奇数都设置为true;
     prime[i] = true;
     for (int i = 3; i <=sqrt(LENGTH);i++)//一个合数的最大质因子不大于它的平方根
     {
     int j;
     if (prime[i])
     {
     for (j = 2*i; j < LENGTH; j += i)
     prime[j] = false;
     }
     }
     //输出值为true的下标
     for (int i = 2; i < LENGTH; i++)
     {
     if (prime[i])
     cout << i << " ";
     }

     return 0;
     ————————————————
     版权声明：本文为CSDN博主「Dear文婷」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
     原文链接：https://blog.csdn.net/yzqcc/article/details/51067814
     */
}
