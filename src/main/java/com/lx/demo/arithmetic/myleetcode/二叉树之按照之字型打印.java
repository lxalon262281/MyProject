package com.lx.demo.arithmetic.myleetcode;

public class 二叉树之按照之字型打印 {
    /**
     * function Print(pRoot) {
     const lists = [];

     if (pRoot === null) {
     return lists;
     }

     const stack1 = [];
     const stack2 = [];

     stack2.push(pRoot);
     let i = 1;
     while (stack1.length !== 0 || stack2.length !== 0) {
     const list = [];

     // 为奇数层
     if ((i & 1) === 1) {
     while (stack2.length !== 0) {
     const tmp = stack2[stack2.length - 1];
     stack2.pop();
     list.push(tmp.val);
     if (tmp.left !== null) stack1.push(tmp.left);
     if (tmp.right !== null) stack1.push(tmp.right);
     }
     }
     // 为偶数层
     else {
     while (stack1.length !== 0) {
     const tmp = stack1[stack1.length - 1];
     stack1.pop();
     list.push(tmp.val);
     if (tmp.right !== null) stack2.push(tmp.right);
     if (tmp.left !== null) stack2.push(tmp.left);
     }
     }
     ++i;
     lists.push(list);
     }
     return lists;
     }
     ————————————————
     版权声明：本文为CSDN博主「wangmumu_zzz」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
     原文链接：https://blog.csdn.net/qq_40608516/article/details/91128825
     */
}
