public class Atm {
    final String pinCode = "1234";
    private boolean cardInside = false;
    private int balance = (int) (50 + 100000 * Math.random());
    private final int FIFTY = 50;
    private final int ONE_HUNDRED = 100;
    private final int TWO_HUNDRED = 200;
    private final int FIFTH_HUNDRED = 500;
    private final int ONE_THOUSAND = 1000;
    private final boolean paperPresence = Math.random() < 0.8;

    DataValidation checkInputItem = new DataValidation();

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

    void drawItemMenu(Menus menus) {
        switch (menus) {
            case INPUT_CARD:
                System.out.format("\tPlease insert your Card!\t\n" +
                        "1 - insert card\n" +
                        "2 - not insert a card\n");
                break;
            case MAIN_MENU:
                System.out.format("\tPrint balance or get money?\t\n" +
                        "1 - view balance\n" +
                        "2 - get money\n" +
                        "3 - exit. Return card\n");
                break;
            case CHECK_BALANCE:
                System.out.format("\tCheck balance:\t\n" +
                        "1 - Draw check on screen\n" +
                        "2 - Print a paper check\n" +
                        "3 - return to previous menu\n" +
                        "4 - exit. Return card\n");
                break;
            case GET_MONEY:
                System.out.format("\tGet Money. Select amount:\t\n" +
                        "1 - " + FIFTY + " usd" + "\t\t5 - " + ONE_THOUSAND + " usd\n" +
                        "2 - " + ONE_HUNDRED + " usd" + "\t\t6 - other amount\n" +
                        "3 - " + TWO_HUNDRED + " usd" + "\t\t7 - return to previous menu\n" +
                        "4 - " + FIFTH_HUNDRED + " usd" + "\t\t8 - exit. Return card\n");
                break;
            case ASK_PRINT_CHECK:
                System.out.format("\tDo you want print check?\t\n" +
                        "1 - Print check\n" +
                        "2 - Don't print check. Save forest\n");
                break;
            case RETURN_MAIN_MENU:
                System.out.format("\tWhat do you want?\t\n" +
                        "1 - return to Main Menu\n" +
                        "2 - exit. Return card\n");
                break;
            case OUT_OF_PAPER:
                System.out.format("The ATM has run out of paper.\n" +
                        "Do you want to continue without printing a receipt?\n" +
                        "1 - continue without check\n" +
                        "2 - cancel and exit\n");
                break;
            case EXIT:
                System.out.format("\tCompletion of work.\t\n" +
                        "Don't forget to pick up the card");
                break;
        }
    }

    boolean inputCard(int selectedMenuItem) {
        return selectedMenuItem == 1;
    }

    void mainMenu(int selectedMenuItem) {
        if (selectedMenuItem == 1) {
            drawItemMenu(Menus.CHECK_BALANCE);
            checkBalance(checkInputItem.validationNumberMenuItem(4));
        } else if (selectedMenuItem == 2) {
            drawItemMenu(Menus.GET_MONEY);
            getMoney(checkInputItem.validationNumberMenuItem(8));
        } else if (selectedMenuItem == 3) {
            drawItemMenu(Menus.EXIT);
            setCardInside(false);
        }
    }

    void checkBalance(int selectedMenuItem) {
        if (selectedMenuItem == 1) {
            System.out.println("Balance on your account " + getBalance());
            drawItemMenu(Menus.RETURN_MAIN_MENU);
            returnMainMenu(checkInputItem.validationNumberMenuItem(2));
        } else if (selectedMenuItem == 2 && paperPresence) {
            System.out.println(toString());
            drawItemMenu(Menus.RETURN_MAIN_MENU);
            returnMainMenu(checkInputItem.validationNumberMenuItem(2));
        } else if (selectedMenuItem == 2) {
            System.out.println("The ATM has run out of paper.\n");
            drawItemMenu(Menus.CHECK_BALANCE);
            checkBalance(checkInputItem.validationNumberMenuItem(4));
        } else if (selectedMenuItem == 3) {
            drawItemMenu(Menus.MAIN_MENU);
            mainMenu(checkInputItem.validationNumberMenuItem(3));
        } else if (selectedMenuItem == 4) {
            drawItemMenu(Menus.EXIT);
            setCardInside(false);
        }
    }

    void returnMainMenu(int selectedMenuItem) {
        if (selectedMenuItem == 1) {
            drawItemMenu(Menus.MAIN_MENU);
            mainMenu(checkInputItem.validationNumberMenuItem(3));
        } else if (selectedMenuItem == 2) {
            drawItemMenu(Menus.EXIT);
            setCardInside(false);
        }
    }

    void getMoney(int selectedMenuItem) {
        if (selectedMenuItem == 1) {
            drawItemMenu(Menus.ASK_PRINT_CHECK);
            askPrintCheck(checkInputItem.validationNumberMenuItem(2), FIFTY);
        } else if (selectedMenuItem == 2) {
            drawItemMenu(Menus.ASK_PRINT_CHECK);
            askPrintCheck(checkInputItem.validationNumberMenuItem(2), ONE_HUNDRED);
        } else if (selectedMenuItem == 3) {
            drawItemMenu(Menus.ASK_PRINT_CHECK);
            askPrintCheck(checkInputItem.validationNumberMenuItem(2), TWO_HUNDRED);
        } else if (selectedMenuItem == 4) {
            drawItemMenu(Menus.ASK_PRINT_CHECK);
            askPrintCheck(checkInputItem.validationNumberMenuItem(2), FIFTH_HUNDRED);
        } else if (selectedMenuItem == 5) {
            drawItemMenu(Menus.ASK_PRINT_CHECK);
            askPrintCheck(checkInputItem.validationNumberMenuItem(2), ONE_THOUSAND);
        } else if (selectedMenuItem == 6) {
            System.out.println("Please input other amount: ");
            int otherAmount = checkInputItem.validationOtherAmount(getBalance());
            drawItemMenu(Menus.ASK_PRINT_CHECK);
            askPrintCheck(checkInputItem.validationNumberMenuItem(2), otherAmount);
        } else if (selectedMenuItem == 7) {
            drawItemMenu(Menus.MAIN_MENU);
            mainMenu(checkInputItem.validationNumberMenuItem(3));
        } else if (selectedMenuItem == 8) {
            drawItemMenu(Menus.EXIT);
            setCardInside(false);
        }
    }

    void askPrintCheck(int selectedMenuItem, int amount) {
        if (selectedMenuItem == 1 && paperPresence) {
            setBalance(getBalance() - amount);
            System.out.println(toString(amount));
            System.out.format("\tTake the money " + amount + " usd\n" +
                    "Don't forget the card after receiving the money.\n\n");
        } else if (selectedMenuItem == 1) {
            drawItemMenu(Menus.OUT_OF_PAPER);
            outOfPaper(checkInputItem.validationNumberMenuItem(2), amount);
        } else if (selectedMenuItem == 2) {
            setBalance(getBalance() - amount);
            System.out.format("\tTake the money " + amount + " usd\n" +
                    "Don't forget the card after receiving the money.\n\n");
        }
    }

    void outOfPaper(int selectedMenuItem, int amount) {
        if (selectedMenuItem == 1) {
            setBalance(getBalance() - amount);
            System.out.format("\tTake the money " + amount + " usd\n" +
                    "Don't forget the card after receiving the money.\n\n");
        } else if (selectedMenuItem == 2) {
            setCardInside(false);
        }
    }

    public String toString(int printSum) {
        return "\n|=================================|\n" +
                "\t\tPrinted check\n" +
                "\tYou have withdrawn " + printSum + " usd\n" +
                "Balance on your account " + getBalance() + " usd" +
                "\n|=================================|\n";
    }

    public String toString() {
        return "\n|=================================|\n" +
                "\t\tPrinted check\n" +
                "Balance on your account " + getBalance() + " usd" +
                "\n|=================================|\n";
    }
}