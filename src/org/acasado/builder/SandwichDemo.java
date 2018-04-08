package org.acasado.builder;

public class SandwichDemo {
    public static void main(String args[]) {


        Sandwich.Builder sandwichBuilder = new Sandwich.Builder("Freanch bread","XL");
//Composite????
        sandwichBuilder.dressing("ketchup").meat("chicken").topping("onion").dressing("asf");

        Sandwich sandwich = sandwichBuilder.buildSandwich();

        System.out.println(sandwich.toString());
    }

}
