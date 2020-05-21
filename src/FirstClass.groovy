class FirstClass {
    String name
    int age
    String address
    double cash

    @Override
    String toString() {
        return name + " " + age + " " + address + " " + cash

    }

    FirstClass() {}

    FirstClass(name, age, address, cash) {
        this.name = name
        this.age = age
        this.address = address
        this.cash = cash
    }


    FirstClass(Binding binding) {
        name = binding.getProperty("name")
        age = binding.getProperty("age")
        address = binding.getProperty("address")
        cash = binding.getProperty("cash")
    }

    static doSmth() {
        return "Doing smth"
    }
}
