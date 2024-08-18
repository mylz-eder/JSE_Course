package session1;

import java.util.Scanner;

public class BodyMassCounter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int weight = getValidInput(input, "Please Type in your Weight (Positive integer - In KG): "),
                height = getValidInput(input, "Please Type in your Height (Positive integer - In CM): ");

        double bodyMassInteger = (double) weight / ((height/100.0) * (height/100.0));
        System.out.println("Your BMI Counter is: " + bodyMassInteger);
    }

    public static int getValidInput(Scanner input, String callout) {

        int value;
        while (true) {

            System.out.println(callout);
            value = Integer.parseInt(input.nextLine());

            if (value > 0) {
                break;
            }
            System.out.println("Invalid input. Please input a Positive Integer.");
        }
        return value;
    }
}
