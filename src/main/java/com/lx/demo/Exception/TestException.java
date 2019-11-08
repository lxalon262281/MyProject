package com.lx.demo.Exception;

public class TestException {
    public TestException() {
    }

    boolean testEx() throws Exception {
        boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            // 同理不会捕捉异常
            System.out.println("testEx, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx1() throws Exception {
        boolean ret = true;
        try {
            ret = testEx2();  // 内部异常已被finally 的return 屏蔽
            if (!ret) {
                return false;
            }
            System.out.println("testEx1, at the end of try");
            return ret;
        } catch (Exception e) {
            // 异常处理器无效，此处代码跳过直接finally
            System.out.println("testEx1, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;  // 同理如果此处的return 被拿掉则不会屏蔽掉throw e ，关键就看当前函数的最后一条语句是return 还是 throw
        }
    }

    boolean testEx2() throws Exception {
        boolean ret = true;
        try {
            int b = 12;
            int c;
            for (int i = 2; i >= -2; i--) {
                c = b / i;
                // 1.首先打印2递减    打印i=2 , i=1
                System.out.println("i=" + i);   // 当i=0 运行时异常抛出
            }
            return true;
        } catch (Exception e) {
            // 2. Exception 包含除Error外的所有运行时异常，能够处理抛出异常 打印  testEx2, catch exception
            System.out.println("testEx2, catch exception");
            ret = false;
            //  3. 程序要抛出异常但是有finally子句，需要执行
            throw e;
        } finally {
            // 4. 打印
            System.out.println("testEx2, finally; return value=" + ret);
            // 5. 此处return JVM认定此函数能够正常响应 屏蔽throw e子句 ,如果此处不是return 子句，外层catch能捕获异常，因为JVM会认定此函数没有return , 返回异常
            return ret;
        }
    }

    public static void main(String[] args) {
//        TestException testException1 = new TestException();
//        try {
//            testException1.testEx();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Object object = new Object();
        System.gc();
    }
}