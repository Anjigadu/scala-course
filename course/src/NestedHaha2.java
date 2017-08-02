public class NestedHaha2 {

    class Inner {

    }
    static class Nested {

    }
    Runnable r = new Runnable() {
        @Override
        public void run() {

        }
    };

    public static void main(String[] args) {
        NestedHaha2 haha = new NestedHaha2();
        Inner innerDeInstanta = haha.new Inner();
        Nested nested = new Nested();
    }
}
