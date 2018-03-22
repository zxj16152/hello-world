package clone.test;

import java.util.Vector;

/**
 * User: zhouxinjian
 * Mail: zhouxj@hshbao.com
 * Date: 2018/3/22
 * Time: 10:36
 * Description:
 */
public class Student implements Cloneable{
    private int id;
    private String name;
    private Vector<String > courses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<String > getCourses() {
        return courses;
    }

    public void setCourses(Vector courses) {
        this.courses = courses;
    }

    public Student() {
        try {
            Thread.sleep(1000);
            System.out.println("Student Constructor Called");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
       Student  stu = (Student) super.clone();
        Vector<String> courses = stu.getCourses();
        Vector<String> course1 = new Vector<>();
        for (String s : courses) {
            course1.add(s);
        }
        stu.setCourses(course1);
        return stu;
    }

    public Student newInstance(){
        try {
            return (Student) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args){
        Student student = new Student();
        Vector<String> cs = new Vector<>();
        cs.add("Java");
        student.setId(1);
        student.setName("XiaoMing");
        student.setCourses(cs);

        Student student1 = student.newInstance();
        student1.setId(2);
        student1.setName("XiaoDong");
        student1.getCourses().add("C#");

        System.out.println("student"+student);
        System.out.println("student1"+student1);

    }

}