package com.dev.playground.solid.isp;

/*
Interface Segregation Principle:
Larger interface should splits into smaller onse having only relevant methods,
means service provider/interface should not force the client/class to use the services/methods
that do not want to use.
*/

//===BEFORE==============================================

interface Restaurant {
    void vegMeals();
    void nonVegMeals();
}

class ABCVegRestaurant implements Restaurant {
    @Override
    public void vegMeals() {
    }

    @Override
    public void nonVegMeals() {
        // No use of this
        System.out.println("Sorry we dont serve this");
    }
}

//===With ISP============================================
interface VegRestaurant {
    void vegMeals();
}

interface NonVegRestaurant {
    void nonVegMeals();
}

class AbcVegRestaurant implements VegRestaurant {
    @Override
    public void vegMeals() {
    }
}

class XyzRestaurant implements VegRestaurant, NonVegRestaurant {

    @Override
    public void vegMeals() {
    }

    @Override
    public void nonVegMeals() {
    }
}

public class InterfaceSegregationEx1 {
}


