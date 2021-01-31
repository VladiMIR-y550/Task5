import java.util.Scanner;

public class Main {
    private final Scanner scan = new Scanner(System.in);
    private boolean newOperation = true;
    private boolean cardInside = false;
    private final String pinCode = "1234";
    private int balance = 10000;
    private int otherAmount;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isCardInside() {
        return cardInside;
    }

    public void setCardInside(boolean cardInside) {
        this.cardInside = cardInside;
    }

    public int getOtherAmount() {
        return otherAmount;
    }

    public void setOtherAmount(int otherAmount) {
        this.otherAmount = otherAmount;
    }

    public static void main(String[] args) {
        Main main = new Main();
        while (main.newOperation) {
            DrawMenu.inputCard();
            main.setCardInside(main.itemInputCard(main.validationInput(2)));
            if (main.isCardInside()) {
                System.out.println("Input PIN");
                if (!main.checkPinCode(main.pinCode)) {
                    System.out.println("You entered the PIN code incorrectly three times. Your card is blocked.");
                    break;
                } else {
                    DrawMenu.itemMainMenu();
                    main.itemMeinMenu(main.validationInput(3));
                }
            } else {
                main.newOperation = false;
            }
        }

    }

    boolean itemInputCard(int number) {
        boolean card = false;
        switch (number) {
            case 1:
                card = true;
                break;
            case 2:
                card = false;
                break;
            default:
                break;
        }
        return card;
    }

    int validationInput(int numberMenuItems) {
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

    int validationOtherAmount() {
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

    void itemMeinMenu(int number) {
        switch (number) {
            case 1:
                DrawMenu.checkBalance();
                itemCheckBalance(validationInput(4));
                break;
            case 2:
                DrawMenu.getMoney();
                itemGetMoney(validationInput(8));
                break;
            case 3:
                DrawMenu.exit();
                setCardInside(false);
                break;
            default:
                break;
        }
    }

    void itemCheckBalance(int item) {
        switch (item) {
            case 1:
                System.out.println("Balance on your account " + getBalance());
                DrawMenu.returnMainMenu();
                itemReturnMainMenu(validationInput(2));
                break;
            case 2:
                System.out.println(toString());
                DrawMenu.returnMainMenu();
                itemReturnMainMenu(validationInput(2));
                break;
            case 3:
                DrawMenu.itemMainMenu();
                itemMeinMenu(validationInput(4));
                break;
            case 4:
                DrawMenu.exit();
                setCardInside(false);
                break;
            default:
                break;
        }
    }

    void itemReturnMainMenu(int item) {
        switch (item) {
            case 1:
                DrawMenu.itemMainMenu();
                itemMeinMenu(validationInput(3));
                break;
            case 2:
                DrawMenu.exit();
                setCardInside(false);
                break;
            default:
                break;
        }
    }

    void itemGetMoney(int item) {
        switch (item) {
            case 1:
                setBalance(getBalance() - Sums.FIFTY.getAmount());
                DrawMenu.askPrintCheck();
                if (itemAskPrintCheck(validationInput(2))) {
                    System.out.println(toString(Sums.FIFTY.getAmount()));
                }
                System.out.println("Take the money " + Sums.FIFTY.getAmount() + " usd\n");
                System.out.println("Do not forget the card after receiving the money\n");
                break;
            case 2:
                setBalance(getBalance() - Sums.ONE_HUNDRED.getAmount());
                DrawMenu.askPrintCheck();
                if (itemAskPrintCheck(validationInput(2))) {
                    System.out.println(toString(Sums.ONE_HUNDRED.getAmount()));
                }
                System.out.println("Take the money " + Sums.ONE_HUNDRED.getAmount() + " usd\n");
                System.out.println("Do not forget the card after receiving the money\n");
                break;
            case 3:
                setBalance(getBalance() - Sums.TWO_HUNDRED.getAmount());
                DrawMenu.askPrintCheck();
                if (itemAskPrintCheck(validationInput(2))) {
                    System.out.println(toString(Sums.TWO_HUNDRED.getAmount()));
                }
                System.out.println("Take the money " + Sums.TWO_HUNDRED.getAmount() + " usd\n");
                System.out.println("Do not forget the card after receiving the money\n");
                break;
            case 4:
                setBalance(getBalance() - Sums.FIFTH_HUNDRED.getAmount());
                DrawMenu.askPrintCheck();
                if (itemAskPrintCheck(validationInput(2))) {
                    System.out.println(toString(Sums.FIFTH_HUNDRED.getAmount()));
                }
                System.out.println("Take the money " + Sums.FIFTH_HUNDRED.getAmount() + " usd\n");
                System.out.println("Do not forget the card after receiving the money\n");
                break;
            case 5:
                setBalance(getBalance() - Sums.ONE_THOUSAND.getAmount());
                DrawMenu.askPrintCheck();
                if (itemAskPrintCheck(validationInput(2))) {
                    System.out.println(toString(Sums.ONE_THOUSAND.getAmount()));
                }
                System.out.println("Take the money " + Sums.ONE_THOUSAND.getAmount() + " usd\n");
                System.out.println("Do not forget the card after receiving the money\n");
                break;
            case 6:
                System.out.println("Please input other amount: ");
                setOtherAmount(validationOtherAmount());
                setBalance(getBalance() - getOtherAmount());
                DrawMenu.askPrintCheck();
                if (itemAskPrintCheck(validationInput(2))) {
                    System.out.println(toString(getOtherAmount()));
                }
                System.out.println("Take the money " + getOtherAmount() + " usd\n");
                System.out.println("Do not forget the card after receiving the money\n");
                break;
            case 7:
                DrawMenu.itemMainMenu();
                itemMeinMenu(validationInput(4));
                break;
            case 8:
                DrawMenu.exit();
                setCardInside(false);
                break;
            default:
                break;
        }
    }

    boolean itemAskPrintCheck(int item) {
        if (item == 1) {
            return true;
        } else if (item == 2) {
            return false;
        }
        return false;
    }

    public String toString(int sum) {
        return "\n|==============================|\n" +
                "\t\tPrinted check\n" +
                "\tYou have withdrawn " + sum + " usd\n" +
                "Balance on your account " + getBalance() + " usd\n" +
                "\n|==============================|\n";
    }

    public String toString() {
        return "\n|==============================|\n" +
                "\t\tPrinted check\n" +
                "Balance on your account " + getBalance() + " usd\n" +
                "\n|==============================|\n";
    }
}