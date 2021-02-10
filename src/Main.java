public class Main {

    private static boolean newOperation = true;

    public static void main(String[] args) {
        DataValidation check = new DataValidation();
        Atm atm = new Atm();

        while (newOperation) {
            atm.drawAndInputItemMenu(Menus.INPUT_CARD);
            if (atm.isCardInside()) {
                System.out.println("Input PIN");
                if (!check.checkPinCode(atm.pinCode)) {
                    System.out.println("You entered the PIN code incorrectly three times. Your card is blocked.");
                    break;
                } else {
                    atm.drawAndInputItemMenu(Menus.MAIN_MENU);
                }
            } else {
                newOperation = false;
            }
        }
    }
}