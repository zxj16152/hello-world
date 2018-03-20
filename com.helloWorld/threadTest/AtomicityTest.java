package threadTest;

import java.util.concurrent.*;

/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/3/20
 * Time: 11:24
 * Description:
 */
public class AtomicityTest implements Runnable {
    private int i=0;
    public int getValue(){
        return i;
    }
    private synchronized void evenIncrement(){
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true){
            int val=at.getValue();
            if (val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}