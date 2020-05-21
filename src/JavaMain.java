import java.math.BigDecimal;

public class JavaMain {
    public static void main(String[] args) {
//        String a = "hello";
//        System.out.println(a instanceof Integer);
//        Integer b = 1;
//        System.out.println(b instanceof String);

        BigDecimal a = new BigDecimal(12);
        BigDecimal b = new BigDecimal(12);

        System.out.println(a + " add " + b + " = " + a.add(b));
        System.out.println(a + " divide " + b + " = " + a.divide(b));
        System.out.println(a + " mult " + b + " = " + a.multiply(b));

//        System.out.println(a + " + " + b + " = " + (a + b));
//        System.out.println(a + " / " + b + " = " + a / b);
//        System.out.println(a + " * " + b + " = " + a * b);
    }
}
