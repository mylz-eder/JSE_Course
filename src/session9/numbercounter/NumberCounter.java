package session9.numbercounter;

import java.util.Scanner;

public class NumberCounter {

    public static void main(String[] args) {

        long number, temp = 1, counter = 1;
        Scanner input = new Scanner(System.in);

        System.out.println("Provide the number to calculate: ");
        number = Long.parseLong(input.nextLine());

        temp = number;

        do {
            temp = temp / 10;
            if (temp != 0) {
                counter++;
            }
        }
        while (temp != 0);

        System.out.println("Your input is made of " + counter + " numbers");
    }
}

