package session9.databseassign;

import session9.databseassign.entity.Product;

import java.util.Scanner;


public class Main {
    public static void main(String[] args)  {


        Scanner input = new Scanner(System.in);
        int choice;
        do {

            System.out.println("1) Add Product. ");
            System.out.println("2) Edit Product. ");
            System.out.println("3) Remove Product. ");
            System.out.println("4) Invoice list. ");
            System.out.println("5) Total Price. ");
            System.out.println("6) Print Invoice. ");
            System.out.println("0) Exit\n ");
            System.out.print("Choose your desired course of operation: ");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    Product addProduct = new Product();
                    System.out.println("1) Add a Product: ");
                    System.out.print("Product Name: ");
                    addProduct.setName(input.nextLine());

                    System.out.print("product price: ");
                    addProduct.setPrice(Integer.parseInt(input.nextLine()));

                    break;
                case 2:
                    System.out.println("2) Edit Product. ");

                    break;
                case 3:
                    System.out.println("3) Remove Product. ");
                    System.out.print("Type the product id you want to remove: ");

                    break;
                case 4:
                    System.out.println("4) Print the entire invoice list: ");

                    break;
                case 5:
                    System.out.println("5) The Total Price is: ");

                    break;
                case 6:
                    System.out.println("6) Print the last Invoice");

                    break;
                case 0:
                    System.out.println("0) Program Terminated successfully");

                    break;
                default:
                    System.out.println("Try Again!!!");
                
            }


        } while (choice != 0);
    }
}
