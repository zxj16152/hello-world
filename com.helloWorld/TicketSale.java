/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/1/19
 * Time: 上午11:01
 * Description:
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;


public class TicketSale {

    public static void main(String args[]) {
        TicketSale test = new TicketSale();
        test.work();
    }

    private void work() {
        AtomicInteger total = new AtomicInteger(50) ;

        CountDownLatch startTogather = new CountDownLatch(1) ;
        new Thread(new MovieTickets(total,startTogather),"meituan").start();
        new Thread(new MovieTickets(total,startTogather),"maoyan").start();
        new Thread(new MovieTickets(total,startTogather),"weipiao").start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("一起开始");
        startTogather.countDown();
    }

    class MovieTickets implements Runnable {

        AtomicInteger total;
        CountDownLatch startTogather ;
        public MovieTickets(AtomicInteger total,CountDownLatch startTogather) {
            this.total = total;
            this.startTogather = startTogather ;
        }

        @Override
        public void run() {
            try {
                startTogather.await();
                System.out.println(Thread.currentThread().getName() + " 开始~~~~~");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int preCount = 0;
            while (true) {
                if ((preCount = total.getAndDecrement()) > 0) {
                    System.out.println(Thread.currentThread().getName() + " 卖了一个.剩下 " + (preCount-1));
                }else {
                    System.out.println(Thread.currentThread().getName() + " 发现卖光了,game over!");
                    break;
                }
            }
        }
    }
}