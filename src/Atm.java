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
    private final int ITEM_ONE = 1;
    private final int ITEM_TWO = 2;
    private final int ITEM_THREE = 3;
    private final int ITEM_FOUR = 4;
    private final int ITEM_FIVE = 5;
    private final int ITEM_SIX = 6;
    private final int ITEM_SEVEN = 7;
    private final int ITEM_EIGHT = 8;


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

    void drawAndInputItemMenu(Menus menus) {
        switch (menus) {
            case INPUT_CARD:
                System.out.format("\tPlease insert your Card!\t\n" +
                        "1 - insert card\n" +
                        "2 - not insert a card\n");
                setCardInside(inputCard(checkInputItem.validationNumberMenuItem(2)));
                break;
            case MAIN_MENU:
                System.out.format("\tPrint balance or get money?\t\n" +
                        "1 - view balance\n" +
                        "2 - get money\n" +
                        "3 - exit. Return card\n");
                mainMenu(checkInputItem.validationNumberMenuItem(3));
                break;
            case CHECK_BALANCE:
                System.out.format("\tCheck balance:\t\n" +
                        "1 - Draw check on screen\n" +
                        "2 - Print a paper check\n" +
                        "3 - return to previous menu\n" +
                        "4 - exit. Return card\n");
                checkBalance(checkInputItem.validationNumberMenuItem(4));
                break;
            case GET_MONEY:
                System.out.format("\tGet Money. Select amount:\t\n" +
                        "1 - " + FIFTY + " usd" + "\t\t5 - " + ONE_THOUSAND + " usd\n" +
                        "2 - " + ONE_HUNDRED + " usd" + "\t\t6 - other amount\n" +
                        "3 - " + TWO_HUNDRED + " usd" + "\t\t7 - return to previous menu\n" +
                        "4 - " + FIFTH_HUNDRED + " usd" + "\t\t8 - exit. Return card\n");
                getMoney(checkInputItem.validationNumberMenuItem(8));
                break;
            case RETURN_MAIN_MENU:
                System.out.format("\tWhat do you want?\t\n" +
                        "1 - return to Main Menu\n" +
                        "2 - exit. Return card\n");
                returnMainMenu(checkInputItem.validationNumberMenuItem(2));
                break;
            case EXIT:
                System.out.format("\tCompletion of work.\t\n" +
                        "Don't forget to pick up the card");
                setCardInside(false);
                break;
            default:
                break;
        }
    }

    void drawAndInputItemMenu(Menus menus, int choiceAmount) {
        switch (menus) {
            case ASK_PRINT_CHECK:
                System.out.format("\tDo you want print check?\t\n" +
                        "1 - Print check\n" +
                        "2 - Don't print check. Save forest\n");
                askPrintCheck(checkInputItem.validationNumberMenuItem(2), choiceAmount);
                break;
            case OUT_OF_PAPER:
                System.out.format("\t!!! The ATM has run out of paper !!!\n" +
                        "Do you want to continue without printing a receipt?\n" +
                        "1 - continue without check\n" +
                        "2 - cancel and exit\n");
                outOfPaper(checkInputItem.validationNumberMenuItem(2), choiceAmount);
                break;
        }
    }

    boolean inputCard(int selectedMenuItem) {
        return selectedMenuItem == ITEM_ONE;
    }

    void mainMenu(int selectedMenuItem) {
        if (selectedMenuItem == ITEM_ONE) {
            drawAndInputItemMenu(Menus.CHECK_BALANCE);
        } else if (selectedMenuItem == ITEM_TWO) {
            drawAndInputItemMenu(Menus.GET_MONEY);
        } else if (selectedMenuItem == ITEM_THREE) {
            drawAndInputItemMenu(Menus.EXIT);
        }
    }

    void checkBalance(int selectedMenuItem) {
        if (selectedMenuItem == ITEM_ONE) {
            System.out.println("Balance on your account " + getBalance());
            drawAndInputItemMenu(Menus.RETURN_MAIN_MENU);
        } else if (selectedMenuItem == ITEM_TWO) {
            if (paperPresence) {
                System.out.println(toString());
                drawAndInputItemMenu(Menus.RETURN_MAIN_MENU);
            } else {
                System.out.println("The ATM has run out of paper.\n");
                drawAndInputItemMenu(Menus.CHECK_BALANCE);
            }
        } else if (selectedMenuItem == ITEM_THREE) {
            drawAndInputItemMenu(Menus.MAIN_MENU);
        } else if (selectedMenuItem == ITEM_FOUR) {
            drawAndInputItemMenu(Menus.EXIT);
        }
    }

    void getMoney(int selectedMenuItem) {
        if (selectedMenuItem == ITEM_ONE) {
            drawAndInputItemMenu(Menus.ASK_PRINT_CHECK, FIFTY);
        } else if (selectedMenuItem == ITEM_TWO) {
            drawAndInputItemMenu(Menus.ASK_PRINT_CHECK, ONE_HUNDRED);
        } else if (selectedMenuItem == ITEM_THREE) {
            drawAndInputItemMenu(Menus.ASK_PRINT_CHECK, TWO_HUNDRED);
        } else if (selectedMenuItem == ITEM_FOUR) {
            drawAndInputItemMenu(Menus.ASK_PRINT_CHECK, FIFTH_HUNDRED);
        } else if (selectedMenuItem == ITEM_FIVE) {
            drawAndInputItemMenu(Menus.ASK_PRINT_CHECK, ONE_THOUSAND);
        } else if (selectedMenuItem == ITEM_SIX) {
            System.out.println("Please input other amount: ");
            int otherAmount = checkInputItem.validationOtherAmount(getBalance());
            drawAndInputItemMenu(Menus.ASK_PRINT_CHECK, otherAmount);
        } else if (selectedMenuItem == ITEM_SEVEN) {
            drawAndInputItemMenu(Menus.MAIN_MENU);
        } else if (selectedMenuItem == ITEM_EIGHT) {
            drawAndInputItemMenu(Menus.EXIT);
        }
    }

    void askPrintCheck(int selectedMenuItem, int amount) {
        if ((selectedMenuItem == ITEM_ONE && paperPresence) || selectedMenuItem == ITEM_TWO) {
            makeChangeBalance(amount);
            if (selectedMenuItem == ITEM_ONE) {
                System.out.println(toString(amount));
            }
        } else {
            drawAndInputItemMenu(Menus.OUT_OF_PAPER, amount);
        }
        takeMoney(amount);
    }

    void outOfPaper(int selectedMenuItem, int amount) {
        if (selectedMenuItem == ITEM_ONE) {
            makeChangeBalance(amount);
        } else if (selectedMenuItem == ITEM_TWO) {
            setCardInside(false);
        }
    }

    void returnMainMenu(int selectedMenuItem) {
        if (selectedMenuItem == ITEM_ONE) {
            drawAndInputItemMenu(Menus.MAIN_MENU);
        } else if (selectedMenuItem == ITEM_TWO) {
            drawAndInputItemMenu(Menus.EXIT);
        }
    }

    void makeChangeBalance(int amount) {
        setBalance(getBalance() - amount);
    }

    void takeMoney(int amount) {
        System.out.format("\tTake the money " + amount + " usd\n" +
                "Don't forget the card after receiving the money.\n\n");
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