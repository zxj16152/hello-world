import java.util.Objects;

public class CglibProxyExample  {
    private   final int j;
    public CglibProxyExample(){
        j=0;
    }
    public  CglibProxyExample(int i){
        j=i;
    }
    public static void main(String[] args){
        CglibProxyExample cglibProxyExample = new CglibProxyExample();
        System.out.println(cglibProxyExample.j);
        CglibProxyExample cglibProxyExample1 = new CglibProxyExample(29);
        System.out.println(cglibProxyExample1.j);
    }


}
