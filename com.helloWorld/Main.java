import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.sun.tools.doclint.Entity.gt;
import static com.sun.tools.doclint.Entity.sum;
import static sun.corba.Bridge.get;

public class Main {

    public static void main(String args[]){

    }
    public void whatThis(){
        //转全小写
        List<String> proStrs = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> execStrs = proStrs.stream().map(str -> {
            System.out.println(this.getClass().getName());
            return str.toLowerCase();
        }).collect(Collectors.toList());
        execStrs.forEach(System.out::println);
    }
   // @Test
//    public void testLimitAndSkip()
//        List<Person> persons = new ArrayList();
//        for (int i = 1; i <= 5; i++) {
//            Person person = new Person(i, "name" + i);
//            persons.add(person);
//        }
//        List<Person> personList2 = persons.stream().limit(2).sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
//        System.out.println(personList2);
//    }
//    private class Person {
//        public int no;
//        private String name;
//        public Person (int no, String name) {
//            this.no = no;
//            this.name = name;
//        }
//        public String getName() {
//            System.out.println(name);
//            return name;
//        }
//    }



}
