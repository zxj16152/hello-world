/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/1/18
 * Time: 下午4:17
 * Description:
 */
public class MeanOfThis {
    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            public void run() {
                int value = 10;
                System.out.println(this.value);
                System.out.println(value);
            }
        };
        r.run();
    }

    public static void main(String... args) {
        MeanOfThis m = new MeanOfThis();
        m.doIt();
    }


}