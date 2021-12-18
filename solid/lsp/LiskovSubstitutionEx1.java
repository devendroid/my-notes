package com.dev.playground.solid.lsp;


/*
Liskov Substitution Principle:
Subclass object should be substitute of super class object,
means we should able to replace parent class with child class without interrupting the behaviour of the programm.
*/

class Vehicle {
    void start(){
        System.out.print("Start vehicle");
    }
    void stop(){
        System.out.print("Stop vehicle");
    }
}

class Car extends Vehicle {
    @Override
    void start(){
        System.out.print("Start car");
    }

    @Override
    void stop(){
        System.out.print("Stop car");
    }
}

/*
Here Bike class Does Not support SLP and its cant be a substitute of Vehicle because its doing some undesired work
*/
class Bike extends Vehicle {
    @Override
    void start(){
        System.out.print("Start bike");
        System.out.print("Do some undesired work and throw exception on condition");
        throw new RuntimeException("Bike booom...");
    }

    @Override
    void stop(){
        System.out.print("Stop bike");
    }
}

//============
public class LiskovSubstitutionEx1 {

    static void testDrive(Vehicle vehicle) {
        vehicle.start();
        vehicle.stop();
    }

    public static void main(String[] arr) {
        testDrive(new Vehicle());
        testDrive(new Car());
        testDrive(new Bike()); // Does Not Support Liskov Principle
    }

}





