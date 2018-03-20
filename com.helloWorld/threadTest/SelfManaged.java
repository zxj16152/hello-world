package threadTest;

/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/3/19
 * Time: 22:11
 * Description:
 */
public class SelfManaged implements Runnable{
    private int countDown=5;
    private Thread thread=new Thread(this);

    public SelfManaged(String string) {
        thread.setName(string);
        thread.start();
    }
    public String toString(){
        return "#"+Thread.currentThread().getName()+"("+countDown+"),";
    }

    @Override
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
            new SelfManaged(i+"");
        }
    }
}