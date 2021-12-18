package com.dev.playground.solid.dip;

/*
Dependency Inversion Principal:
We must use abstraction (abstract class and interface) instead of concrete class,
High-level module should not depends on low-level module but both should depends on abstraction.
*/

//==BEFORE===============================================================

/*
High-level class/module that depends on low-level classes/modules
OR we can say its tightly coupled with low-level classes (CreditCard or DebitCard)
Due to tightly coupled if we want to change payment option
from CreditCard to DebitCard it will not easy in this case.
*/
class ShoppingMallx {
    void doSomePurchase(CreditCardx creditCard) {
        creditCard.doTransaction(1500);
    }

}

/*
Low-level class/module
*/
class CreditCardx {
    void doTransaction(double amt) { }
}

/*
Low-level class/module
*/
class DebitCardx {
    void doTransaction(double amt) { }
}

//==With DIP===============================================================
/*
High-level class/module that not depend on low-level classes/modules instead its depends on abstraction
OR we can say its loosely coupled with low-level classes (CreditCard or DebitCard),
Due to loosely coupled if we want to change payment option
from CreditCard to DebitCard we can easy change it, please have look in main method.
*/
class ShoppingMall {
    void doSomePurchase(BankCard bankCard) {
        bankCard.doTransaction(1500);
    }
}

 interface BankCard {
     void doTransaction(double amt);
}

/*
Low-level class/module
*/
 class CreditCard implements BankCard{

    @Override
    public void doTransaction(double amt) {

    }
}

/*
Low-level class/module
*/
class DebitCard implements BankCard{
    @Override
    public void doTransaction(double amt) {

    }
}

//=============
public class DependencyInversionEx1 {

    public static void main(String[] arr) {
        ShoppingMall shoppingMall = new ShoppingMall();
        shoppingMall.doSomePurchase(new CreditCard());
        // OR
        shoppingMall.doSomePurchase(new DebitCard());
    }
}
