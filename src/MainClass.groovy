import groovy.lang.Binding
import sun.misc.Unsafe

class MainClass {
    static void main(String[] args) {
        def fc1 = new FirstClass(name: 'Timmy', age: 19, address: 'Bern', cash: 120)

        println fc1 // Timmy 19 Bern 120.0

        println(intFunc())

        def binding = new Binding()
        binding.setVariable("name", 'AlterEgoTimmy')
        binding.setVariable("age", 91)
        binding.setVariable("address", 'Geneva')
        binding.setVariable("cash", 150)
        def fc2 = new FirstClass(binding)

        println fc2 // AlterEgoTimmy 91 Geneva 150.0
        println fc2.getName() // AlterEgoTimmy


        println("String instanceof Integer: " + (String instanceof Integer))    // false
        println("Integer instanceof String: " + (Integer instanceof String))    // false

        println FirstClass.doSmth() // if static it's ok

//        println(firstFunc(null))    // doesn't work
//        println(secondFunc(null))

        BigDecimal a = new BigDecimal(12)
        BigDecimal b = new BigDecimal(12)

        println("a.equals(b): " + a.equals(b)) // true
        println("a.is(b): " + a.is(b))  // false
        println("a == b: " + (a == b))  // true

        println(a + " add " + b + " = " + a.add(b)) // 12 add 12 = 24
        println(a + " divide " + b + " = " + a.divide(b))   // 12 divide 12 = 1
        println(a + " mult " + b + " = " + a.multiply(b))   // 12 mult 12 = 144

        println(a + " + " + b + " = " + (a + b))    // 12 + 12 = 24
        println(a + " / " + b + " = " + a / b)  // 12 / 12 = 1
        println(a + " * " + b + " = " + a * b)  // 12 * 12 = 144

        def x = 10
        println(x.getClass().getName()) // Integer
        x = 'f'
        println(x.getClass().getName()) // String
        x = 'First'
        println(x.getClass().getName()) // String

        def x1 = 'f'
        println(x.getClass().getName()) // String
        x1 = 'First'
        println(x.getClass().getName()) // String
        x1 = 10
        println(x.getClass().getName()) // String

        Date date1 = new Date(115, 1, 28)
        println(date1)  // Sat Feb 28 00:00:00 MSK 2015
        Date date2 = new Date(115, 0, 31)
        println(date2)  // Sat Jan 31 00:00:00 MSK 2015

        def res = date1 - date2
        println(res)    // 28

//        date1.minus()
////        date1.plus(new Date((2629743830L + 86400000L)))
//        println(date1)

        println(closureMinus(2, 2))
        println(closureMinus(2, 2))
        println(closureBoth(4.0, 2.0, 1))


    }

    static def closureDivide = {
        a, b -> a / b
    }

    static def closureMinus = {
        a, b -> a - b
    }

    static def closureBoth = {
        a, b, c -> MainClass.closureMinus(MainClass.closureDivide(a, b), c)
    }

    static Integer intFunc() {
        12
    }

    int firstFunc(Integer k) {
        return k * 120;
    }

    Integer secondFunc(Integer k) {
        return k * 120;
    }

}

// В классе FirstClass создайте явный конструктор и попытайтесь в файле MainClass создать экземпляр класса FirstClass.
// Возможно ли это сделать с поименной передачей параметров в этот конструктор?
// Нет, не возможно:
// Exception in thread "main" groovy.lang.GroovyRuntimeException: Could not find matching constructor for: FirstClass(LinkedHashMap)
//	at groovy.lang.MetaClassImpl.invokeConstructor(MetaClassImpl.java:1807)
//	at groovy.lang.MetaClassImpl.invokeConstructor(MetaClassImpl.java:1599)
//	at org.codehaus.groovy.runtime.callsite.MetaClassConstructorSite.callConstructor(MetaClassConstructorSite.java:46)
//	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:59)
//	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:263)
//	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:277)
//	at MainClass.main(MainClass.groovy:3)
//

