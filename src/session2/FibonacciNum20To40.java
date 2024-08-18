package session2;

import java.util.Scanner;

public class FibonacciNum20To40 {
    public static void main(String[] args) {

        long first, second, added;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter The First Number: ");
        first = Long.parseLong(input.nextLine());

        System.out.println("Enter The Second Number");
        second = Long.parseLong(input.nextLine());

        for (int i=3; i <= 40; i++) {

            added = first + second;
//                System.out.println(i + ") " + added);

                if (i >= 20 & i < 41)
                System.out.println(i + ") " + added);

            first = second;
            second = added;
        }
    }
}
