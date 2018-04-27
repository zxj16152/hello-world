/*import com.google.common.base.Function;

import java.util.Comparator;
import java.util.function.Supplier;

public class HelloWorldImlp {
    int portNumber = 1337;
    public void sayHelloWorld() {

        portNumber=2;
        Runnable r =new Runnable() {
            @Override
            public void run() {
                System.out.println(portNumber);
            }
        };
        new Thread(r).start();
        portNumber=1;

       *//* System.out.println(portNumber);
        portNumber=1;*//*
    }

    public static void main(String[] args){
        Function<Integer, Person> c2 =(integer -> new Person(integer));
        Function<Integer, Person> c3 = new Function<Integer, Person>() {
            @Override
            public Person apply(Integer integer) {
                return new Person(integer);
            }
        };
        Person a2 = c2.apply(110);
        System.out.println(a2.getAge());
    }

}*/
