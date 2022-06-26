package com.vttp;

import java.util.LinkedList;
import java.util.Scanner;

public class App 
{

    static LinkedList<String> cart = new LinkedList<>();

    public static void main( String[] args )
    {
        System.out.println("Welcome to your shopping cart");
        Scanner scan = new Scanner(System.in);
        
        
        while (true) {
            System.out.print("Input here: ");
            String prompt = scan.nextLine();
            String[] promptArray = prompt.split(" ");

            switch (promptArray[0]) {
                case "list": 
                 if (cart.isEmpty()) {
                    System.out.println("Cart is empty");
                 } else {
                    
                    // Method 1 - For LOOP
                    for (int i = 0; i < cart.size(); i++) {
                        System.out.println((i+1) + ". " + cart.get(i));
                    }
                    
                    // Method 2 - For IN LOOP
                    // for (String item: cart) {
                    //     System.out.println(item);
                    // }

                    // Method 3 - Lambda
                    // cart.forEach(item -> System.out.println(item) );

                    // Method 4
                    // cart.forEach(System.out::println);
                 }
                break;
                case "add":
                 if (promptArray.length >= 2) {
                    for (int i = 1; i < promptArray.length; i++) {
                        String[] str = new String[promptArray.length];
                        str[i] = promptArray[i].replaceAll(",", "");

                        if (!cart.contains(str[i])) {
                            System.out.println(str[i] + " added to cart");
                            cart.add(str[i]);
                        } else {
                            System.out.println("You have " + str[i] + " in your cart.");
                            continue;
                        }
                        
                    }
                 }
                
                 
                break;
                case "delete":
                String itemForRemove = promptArray[1];
                cart.remove(itemForRemove);
                System.out.println(itemForRemove + " has been removed.");
                 
                break;
                case "exit":
                System.exit(0);
                break;
                default:
            }
        }

    }
}
