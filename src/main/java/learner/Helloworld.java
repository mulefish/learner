package learner;

public class Helloworld {
    public static void main(String...strings) {
        Helloworld hw = new  Helloworld();
        String msg = hw.getMsg();
        System.out.println(msg);
    }
    public String getMsg() {
        return "Hello world! How does IDEA and github work?";
    }
}
