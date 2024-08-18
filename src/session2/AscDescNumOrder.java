package session2;

import java.util.Scanner;

public class AscDescNumOrder {
    public static void main(String[] args) {

        int firstNum, secondNum;
        Scanner input = new Scanner(System.in);

        System.out.println("This program takes the Numbers you provide and lists the numbers in between in order: ");

        System.out.println("Provide the first number: ");
        firstNum = Integer.parseInt(input.nextLine());

        System.out.println("Provide the second number: ");
        secondNum = Integer.parseInt(input.nextLine());
        System.out.println(firstNum);
        for (int i = firstNum; i <= secondNum; i++) {

            System.out.println(i);
        }
        for (int i = firstNum; i >= secondNum; i--) {

            System.out.println(i);
        }
    }
}
