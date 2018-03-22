package master_worker;

import java.util.Map;
import java.util.Queue;

/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/3/22
 * Time: 14:21
 * Description:
 */
public class Worker implements Runnable{
    protected Queue<Object> workQueue;

    protected Map<String,Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
    public Object handle(Object input){
        return input;
    }

    @Override
    public void run() {
        while (true){
            Object input = workQueue.poll();
            if (input==null) break;
            Object re = handle(input);
            resultMap.put(Integer.toString(input.hashCode()),re);
        }
    }
}