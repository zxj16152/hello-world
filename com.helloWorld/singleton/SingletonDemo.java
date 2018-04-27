package singleton;


/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/3/30
 * Time: 19:19
 * Description:
 */
public class SingletonDemo {
    private static class SingletonClassInstance{
        private static final SingletonDemo instance=new SingletonDemo();
    }
    public static  SingletonDemo getInstance(){
        return SingletonClassInstance.instance;
    }
}