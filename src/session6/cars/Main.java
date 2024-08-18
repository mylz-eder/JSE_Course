package session6.cars;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = -1;

        try {
            do {
                System.out.println("0) Close the Application");
                System.out.println("1) Submit a Sport Car Specification: ");
                System.out.println("1) Submit a Sport Specification: ");
                System.out.println("2) Submit an SUV Specification: ");
                System.out.println("3) Submit an Off-road Specification: ");
                System.out.println("4) Submit your Mini Specification: ");
                System.out.println("Choose your desired course of operation:    \n ");
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {
                    case 0:
                        System.out.println("Program terminated successfully");
                        break;
                    case 1:
                        System.out.println("Submit a Sport Car Specification: ");
                        Sport newSportsCar = new Sport();
                        System.out.println("What is the name of the Car?");
//                        newSportsCar.getName(input.nextLine());

                        break;
                    case 2:
                        System.out.println("Submit an SUV Car Specification: ");
                        break;
                    case 3:
                        System.out.println("Submit an Off-road Specification: ");
                        break;
                    case 4:
                        System.out.println("Submit your Mini Specification: ");
                        break;
                    default:
                        System.out.println("Invalid choice. please Submit a valid option.");
                        break;
                }
            } while (choice != 0);

        }catch(Exception e){
            System.out.println("Invalid Input!!!");
        }
    }
}