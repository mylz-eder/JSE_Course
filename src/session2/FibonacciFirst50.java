package session2;


import java.util.Scanner;

public class FibonacciFirst50 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        long first, second, added;
        double divided, storage;

        System.out.println("Enter The First Number: ");
        first = Long.parseLong(input.nextLine());

        System.out.println("Enter The Second Number");
        second = Long.parseLong(input.nextLine());

        System.out.println("1) " + first);
        System.out.println("2) " + second);
        storage = (double) second;
        System.out.println("2/1 - " + storage / first);

        for (int i=3; i <= 50; i++) {

            added = first + second;
            System.out.println(i + ") " + added);
            storage = (double) second;
            divided = added / storage;
            System.out.println(i + "/" + (i-1) + " - " + divided);

            first = second;
            second = added;
        }
    }
}
