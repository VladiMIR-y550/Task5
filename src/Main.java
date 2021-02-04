public class Main {

    private static boolean newOperation = true;

    public static void main(String[] args) {
        DataValidation check = new DataValidation();
        Atm atm = new Atm();

        System.out.println(atm.getBalance());
        while (newOperation) {
            atm.drawItemMenu(Menus.INPUT_CARD);
            atm.setCardInside(atm.inputCard(check.validationNumberMenuItem(2)));
            if (atm.isCardInside()) {
                System.out.println("Input PIN");
                if (!check.checkPinCode(atm.pinCode)) {
                    System.out.println("You entered the PIN code incorrectly three times. Your card is blocked.");
                    break;
                } else {
                    atm.drawItemMenu(Menus.MAIN_MENU);
                    atm.mainMenu(check.validationNumberMenuItem(3));
                }
            } else {
                newOperation = false;
            }
        }
    }
}