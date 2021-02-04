import java.util.Scanner;

public class DataValidation {

    private final Scanner scan = new Scanner(System.in);

    int validationNumberMenuItem(int numberMenuItems) {
        String inputStr;
        int number = 0;
        boolean valid = false;
        while (!valid) {
            try {
                inputStr = scan.next();
                int inputNumber = Integer.parseInt(inputStr);
                if (inputNumber > 0 && inputNumber <= numberMenuItems) {
                    number = inputNumber;
                    valid = true;
                } else {
                    System.out.println("Please select a menu item from the suggested");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number");
            }
        }
        return number;
    }

    boolean checkPinCode(String pinCode) {
        String strInput;
        int attemptLeft = 3;
        boolean pin = false;
        for (int attempt = 0; attempt < 3; attempt++) {
            if (scan.hasNext()) {
                strInput = scan.next();
                if (strInput.length() == 4 && strInput.equals(pinCode)) {
                    pin = true;
                    break;
                } else {
                    attemptLeft--;
                    System.out.println("Wrong PIN! Attempts left " + attemptLeft);
                }
            } else {
                attemptLeft--;
                System.out.println("Wrong PIN! Attempts left " + attemptLeft);
            }
        }
        return pin;
    }

    int validationOtherAmount(int balance) {
        String inputStr;
        int number = 0;
        boolean valid = false;
        while (!valid) {
            try {
                inputStr = scan.next();
                int inputNumber = Integer.parseInt(inputStr);
                if (inputNumber > 0 && inputNumber % 50 == 0) {
                    if (inputNumber <= balance) {
                        number = inputNumber;
                        valid = true;
                    } else {
                        System.out.println("There are insufficient funds in your account");
                    }
                } else {
                    System.out.println("Incorrect entry of the amount.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number");
            }
        }
        return number;
    }
}