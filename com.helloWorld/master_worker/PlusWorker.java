package master_worker;

/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/3/22
 * Time: 14:43
 * Description:
 */
public class PlusWorker extends Worker{
    @Override
    public Object handle(Object input) {
        Integer i= (Integer) input;
        return i*i*i;
    }
}