package stream;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/1/22
 * Time: 下午12:10
 * Description:
 */
public class TestStream1 {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
       numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).forEach(ints ->System.out.println( Arrays.toString(ints)));
        System.out.println();
        System.out.println("TestStream1");
    }
}