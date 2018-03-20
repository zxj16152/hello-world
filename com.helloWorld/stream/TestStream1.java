package stream;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;
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
      /*  List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
       numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).forEach(ints ->System.out.println( Arrays.toString(ints)));
        System.out.println("===================");
        numbers1.stream().flatMap(i -> numbers2.stream().filter(j->(i+j)%3==0).map(j -> new int[]{i, j})).forEach(ints ->System.out.println( Arrays.toString(ints)));
        System.out.println();
        System.out.println("TestStream1");
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        );*/
//        pythagoreanTriples.forEach(t->System.out.println(t[0]+" ,"+t[1]+" ,"+t[2]));
/*
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);*/
      /*  Stream.iterate(new int[]{0, 1}, t->new int[]{t[1],t[0]+t[1]})
           .limit(20)
               .map(t->t[0]).forEach(System.out::println);
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream(); List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(), (List<Integer> l, Integer e) -> { l.add(e);return l; }, (List<Integer> l1, List<Integer> l2) -> { l1.addAll(l2);return l1; });*/

        TestStream1 stream1 = new TestStream1();
        Map<Boolean, List<Integer>> booleanListMap = stream1.partitionPrimes(100);
        System.out.println(Runtime.getRuntime().availableProcessors()+"--------------");

        for (Boolean aBoolean : booleanListMap.keySet()) {
            System.out.println(booleanListMap.get(aBoolean)+" :");
            Function.identity();
        }

    }
    public boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        partitioningBy(candidate -> isPrime(candidate)));
    }
}