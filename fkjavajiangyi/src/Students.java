/**
 * @author pengxy
 */
public class Students {
    // 实例变量，没有static
    public String stuname;
    public int age;
    public String gender;
    public int phone;
    public int address;
    public String email;

    public void getStuname(String stuname) {
        if (stuname.length() == 1) {
            System.out.println("无法找到该名称");
            return;
        } else {
            this.stuname = stuname;
        }
    }
    public static void eat(String stuname){
        System.out.println(stuname + "正在吃东西");
    }
    public static void main(String[] args){
        Students s = new Students();
        String name1 = "zhangsan";
        s.getStuname(name1);
        s.eat(name1);
    }
}

