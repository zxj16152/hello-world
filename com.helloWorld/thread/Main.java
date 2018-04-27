package thread;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/4/28
 * Time: 01:15
 * Description:
 */

class Log{
    public static void print(String s){
        System.out.println(Thread.currentThread().getName()+":"+s);
    }
}
class BoundedResource{
    private final Semaphore semaphore;
    private int permits;
    private final static Random random=new Random();
    public BoundedResource(int permits){
        semaphore=new Semaphore(permits);
        this.permits=permits;
    }
    public void use(){
        try {
            semaphore.acquire();
            doUse();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
    }
    protected void doUse() throws InterruptedException {
        Log.print("BEGIN:used="+(permits-semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.print("END:used="+(permits-semaphore.availablePermits()));
    }
}
class UserThread extends Thread{
    private final static Random random=new Random(26535);
    private final BoundedResource boundedResource;
    public UserThread(BoundedResource boundedResource){
        this.boundedResource=boundedResource;
    }
    public void run(){
        try {
            while (true){
                boundedResource.use();
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args){
        BoundedResource boundedResource = new BoundedResource(3);
        for (int i = 0; i < 10; i++) {
            new UserThread(boundedResource).start();
        }
    }
}