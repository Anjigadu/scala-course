import java.util.List;
import static java.lang.System.currentTimeMillis
import java.util.regex.*;

public class Haha {
    interface I1 {
        default void n() {
            System.out.println("I1");
        }
    }
    interface I2 {
        default void n() {
            System.out.println("I2");
        }
    }
    static class C implements I1,I2 {

        @Override
        public void n() {
            I1.super.n();
        }
    }
    public static void main(String[] args) {
//        List<String> s;
//        s.stream()
    }
}
