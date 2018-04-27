package java8test;

/**
 * User: xinjian.zhou
 * Mail: xinjian.zhou@phicomm.com
 * Date: 2018/4/18
 * Time: 17:19
 * Description:
 */
public class Java8Tester {
/*
    public static void main(String args[]){
        Java8Tester tester = new Java8Tester();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };
        System.out.println("==================================");
        System.out.println(multiplication.operation(5,6));

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
    */



        final static String salutation = "Hello! ";

        public static void main(String args[]){
            GreetingService greetService1 = message -> System.out.println(salutation + message);
//            greetService1.sayMessage("Runoob");
        }

        interface GreetingService {
            void sayMessage(String message);

    }
}
