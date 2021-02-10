public class Main {

    private static boolean newOperation = true;

    public static void main(String[] args) {
        DataValidation check = new DataValidation();
        Atm atm = new Atm();

        while (newOperation) {
<<<<<<< HEAD
            atm.drawAndInputItemMenu(Menus.INPUT_CARD);
=======
            atm.launchMenu("cardInside");
>>>>>>> 629400b3429896b5619743d83da275048a2b3ff5
            if (atm.isCardInside()) {
                System.out.println("Input PIN");
                if (!check.checkPinCode(atm.pinCode)) {
                    System.out.println("You entered the PIN code incorrectly three times. Your card is blocked.");
                    break;
                } else {
<<<<<<< HEAD
                    atm.drawAndInputItemMenu(Menus.MAIN_MENU);
=======
                    atm.launchMenu("mainMenu");
>>>>>>> 629400b3429896b5619743d83da275048a2b3ff5
                }
            } else {
                newOperation = false;
            }
        }
    }
}