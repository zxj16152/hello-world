package master_worker;

import java.util.Map;
import java.util.Set;

/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/3/22
 * Time: 14:45
 * Description:
 */
public class TestMasterWorker {
    public static void main(String[] args) {
        Master master = new Master(new PlusWorker(), 5);
        for (int i = 0; i < 13; i++) {
            master.submit(i);
        }
        master.execute();
        int re = 0;
        Map<String, Object> resultMap = master.getResultMap();
        while (resultMap.size()>0||!master.isComplete()){
            Set<String> keys = resultMap.keySet();
            String key=null;
            for (String k : keys) {
                key=k;
                break;
            }
            Integer i=null;
            if (key!=null){
              i= (Integer) resultMap.get(key);
            }
            if (i != null) {
                re+=i;
            }
            if (key != null) {
                resultMap.remove(key);
            }
        }
        System.out.println(re);
    }
}