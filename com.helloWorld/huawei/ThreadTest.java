package huawei;

import static java.lang.Thread.yield;

/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/3/17
 * Time: 21:15
 * Description:
 */

public class ThreadTest {
    private static boolean flagA=true;
    private static boolean flagB=false;

    public static void main(String[] args){
        final ThreadTest testLock=new ThreadTest();
        new  Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    synchronized (testLock){
                    while (!flagA){
                        try {
                            testLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                        System.out.print("A");
                        flagA=false;
                        flagB=true;
                        testLock.notifyAll();
                }
                }

            }
        }).start();
        new  Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    synchronized (testLock){
                        while (!flagB){
                            try {
                                testLock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("B");
                        flagB=false;
                        flagA=true;
                        testLock.notifyAll();
                    }
                }

            }
        }).start();


    }
}