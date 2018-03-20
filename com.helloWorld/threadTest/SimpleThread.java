package threadTest;

/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/3/19
 * Time: 22:02
 * Description:
 */
public class SimpleThread extends Thread {
    private int countDown=100;
    private static int threadCount=0;
    public SimpleThread(){
        super(Integer.toString(++threadCount));
        start();
    }
    public String toString(){
        return "#"+getName()+"("+countDown+"),";
    }
    public void run(){
        while (true){
            System.out.print(this);
            if (--countDown==0){
                return;
            }
        }
    }
    public static void main(String[] args){
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}