public class Main {

    public static void main(String[] args) {

        // Classes

        Car porsche = new Car();
        Car holden = new Car();
        // System.out.println("Model is " + porsche.getModel()); // null
        porsche.setModel("Carrera");
        System.out.println("Model is " + porsche.getModel());

        System.out.println();

        // Constructors

        Account peterAcccount = new Account(  );
        Account bobsAccount = new Account("12345", 0.00, "Bob Brown", "myemail@bob.com", " 1234567");
        System.out.println(bobsAccount.getCustomerName());

        bobsAccount.withdrawal( 100.0 );
        bobsAccount.deposit( 50.0 );
        bobsAccount.withdrawal( 100.0 );
        bobsAccount.deposit( 51.0 );
        bobsAccount.withdrawal( 100.0 );

        Account timsAccount = new Account( "Tim", "Tim@email.com", "12345" );
        System.out.println(timsAccount.getNumber() + " name " + timsAccount.getCustomerName());

        VipCustomer person1 = new VipCustomer(  );
        System.out.println(person1.getName());

        VipCustomer person2 = new VipCustomer( "Bob", 25_000.00 );
        System.out.println(person2.getName());

        VipCustomer person3 = new VipCustomer( "Tim", 100.00, "tim@email.com" );
        System.out.println(person3.getName());
        System.out.println(person3.getEmailAddress());

        // Inheritance - szülő

	    Animal animal = new Animal( 1,1,5,5,"Animal" );
	    Dog dog = new Dog(8,20, "Yorkie", 2, 4, 1, 20, "Brown");

	    dog.eat();

	    dog.walk();
	    dog.run();
    }
}
