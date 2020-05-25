import static java.util.Calendar.MONTH

class MainClass {
    static void main(String[] args) {
        def fc1 = new FirstClass(name: 'Timmy', age: 19, address: 'Bern', cash: 120)

        println fc1 // Timmy 19 Bern 120.0


        def binding = new Binding()
        binding.setVariable("name", 'AlterEgoTimmy')
        binding.setVariable("age", 91)
        binding.setVariable("address", 'Geneva')
        binding.setVariable("cash", 150)

        def fc2 = new FirstClass(binding)
        println fc2 // AlterEgoTimmy 91 Geneva 150.0
        println fc2.getName() // AlterEgoTimmy

        println("String instanceof Integer: " + (String instanceof Integer))    // String instanceof Integer: false
        println("Integer instanceof String: " + (Integer instanceof String))    // Integer instanceof String: false

        println FirstClass.doSmth() // if static it's ok: Doing smth

        ClassToCheckDef check = new ClassToCheckDef(name: 'Timmy', id: 1, cash: 15.0, specialVariable: "hello")
        println(check)  // Name: Timmy id: 1 Cash: 15.0 specialVariable: hello
        check.specialVariable = 130.0
        println(check)  // Name: Timmy id: 1 Cash: 15.0 specialVariable: 130.0


        println('intFunc: ' + intFunc()) // intFunc: 12

//        println('firstFunc: ' + firstFunc(null))    // doesn't work
        println('secondFunc: ' + secondFunc(null))   // null

        BigDecimal a = new BigDecimal(12)
        BigDecimal b = new BigDecimal(12)

        println("a.equals(b): " + a.equals(b)) // a.equals(b): true
        println("a.is(b): " + a.is(b))  // a.is(b): false
        println("a === b: " + (a === b)) // a === b: false
        println("a == b: " + (a == b))  // a == b: true

        println(a + " add " + b + " = " + a.add(b)) // 12 add 12 = 24
        println(a + " divide " + b + " = " + a.divide(b))   // 12 divide 12 = 1
        println(a + " mult " + b + " = " + a.multiply(b))   // 12 mult 12 = 144

        println(a + " + " + b + " = " + (a + b))    // 12 + 12 = 24
        println(a + " / " + b + " = " + a / b)  // 12 / 12 = 1
        println(a + " * " + b + " = " + a * b)  // 12 * 12 = 144

        def x = 10
        println(x.getClass().getName()) // java.lang.Integer
        x = 'f'
        println(x.getClass().getName()) // java.lang.String
        x = 'First'
        println(x.getClass().getName()) // java.lang.String

        def x1 = 'f'
        println(x1.getClass().getName()) // java.lang.String
        x1 = 'First'
        println(x1.getClass().getName()) // java.lang.String
        x1 = 10
        println(x1.getClass().getName()) // java.lang.Integer

        Date date1 = new Date(115, 1, 28)
        println(date1)  // Sat Feb 28 00:00:00 MSK 2015

        Date date2 = new Date(115, 0, 31)
        println(date2)  // Sat Jan 31 00:00:00 MSK 2015

        def result = new Date(date1.getTime() - date2.getTime())
        println('date1.getTime() - date2.getTime(): ' + result)
        // date1.getTime() - date2.getTime(): Thu Jan 29 03:00:00 MSK 1970

        def res = date1 - date2
        println('date1 - date2: ' + res)    // date1 - date2: 28

        Date date3 = new Date(115, 1, 28)

        def prevMonth = date3[MONTH] - 1
        date3.set(month: prevMonth)
        println(date3)  // Wed Jan 28 00:00:00 MSK 2015

        def nextMonth = date3[MONTH] + 1
        date3.set(month: nextMonth)
        println(date3)  // Sat Feb 28 00:00:00 MSK 2015

        date3 = date3.next()
        println(date3)  // Sun Mar 01 00:00:00 MSK 2015

        println('closureDivide: ' + closureDivide(2, 2))    // closureDivide: 1
        println('closureBoth: ' + closureBoth(4.0, 2.0, 1))   // closureBoth: 1
        println('closureMinus: ' + closureMinus(2, 2)) // closureMinus: 0
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

    static int firstFunc(Integer k) {
        return k
    }

    static Integer secondFunc(Integer k) {
        return k
    }
}



