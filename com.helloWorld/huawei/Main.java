package huawei;

import java.util.Scanner;

/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/3/1
 * Time: 10:21
 * Description:
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String  str=scanner.nextLine().toUpperCase();
        String str2 = str.trim();
        char one=str2.charAt(str2.length()-1);
        String[] split = str2.split(" ");

        // String next = scanner.next();

//        char ch=scanner.nextLine().toUpperCase().charAt(0);
        System.out.println(str);
    }
}