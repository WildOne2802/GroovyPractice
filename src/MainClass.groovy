class MainClass {
    static void main(String[] args) {
        def fc1 = new FirstClass(name: 'Timmy', age: 19, address: 'Bern', cash: 120)
        println fc1.name + "\n" + fc1.age + "\n" + fc1.address + "\n" + fc1.cash
        println(String instanceof Integer)
        println(Integer instanceof String)

        def woof = { String a -> println("woof") }
        woof("woof")
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

