package session2;

import java.util.Scanner;

public class PerfectNum {
    /*
     * This code was fully written by me, however, It was inside another project, so I just copy-pasted
     * my own code which I sent you the screenshots of in here
     *  */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your desired number: \n ");

        int number = Integer.parseInt(input.nextLine());
        int sumOfDivisors = 0;

        if (number < 0) {
            System.out.println("This number is invalid!!!");
        } else {
            for (int loopCounter = 1; loopCounter < number - 1; loopCounter++) {
                if (number % loopCounter == 0) {
                    System.out.println("The divisions include: " + loopCounter);
                    sumOfDivisors += loopCounter;
                }

            }
            if (sumOfDivisors == number) {
                System.out.println("Yup," + number + " is a Perfect number.");
            } else {
                System.out.println("Nope," + number + " is not a perfect number.");
            }
        }
    }
}
