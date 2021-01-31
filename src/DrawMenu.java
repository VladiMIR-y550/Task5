public class DrawMenu {

    static void inputCard() {
        System.out.println("\t" + "- " + Menus.INPUT_CARD.getNameMenu() + " -");
        System.out.println(Menus.INPUT_CARD.getItem1());
        System.out.println(Menus.INPUT_CARD.getItem2());
    }

    static void itemMainMenu() {
        System.out.println("\t" + "- " + Menus.MAIN_MENU.getNameMenu() + " -");
        System.out.println(Menus.MAIN_MENU.getItem1());
        System.out.println(Menus.MAIN_MENU.getItem2());
        System.out.println(Menus.MAIN_MENU.getItem3());
    }

    static void checkBalance() {
        System.out.println("\t" + "- " + Menus.CHECK_BALANCE.getNameMenu() + " -");
        System.out.println(Menus.CHECK_BALANCE.getItem1());
        System.out.println(Menus.CHECK_BALANCE.getItem2());
        System.out.println(Menus.CHECK_BALANCE.getItem3());
        System.out.println(Menus.CHECK_BALANCE.getItem4());
    }

    static void getMoney() {
        System.out.println("\t" + "- " + Menus.GET_MONEY.getNameMenu() + " -");
        System.out.println(Menus.GET_MONEY.getItem1() + "\t\t\t" + Menus.GET_MONEY.getItem5());
        System.out.println(Menus.GET_MONEY.getItem2() + "\t\t\t" + Menus.GET_MONEY.getItem6());
        System.out.println(Menus.GET_MONEY.getItem3() + "\t\t\t" + Menus.GET_MONEY.getItem7());
        System.out.println(Menus.GET_MONEY.getItem4() + "\t\t\t" + Menus.GET_MONEY.getItem8());
    }

    static void askPrintCheck() {
        System.out.println("\t" + "- " + Menus.ASK_PRINT_CHECK.getNameMenu() + " -");
        System.out.println(Menus.ASK_PRINT_CHECK.getItem1());
        System.out.println(Menus.ASK_PRINT_CHECK.getItem2());
    }

    static void returnMainMenu() {
        System.out.println("\t" + "- " + Menus.RETURN_MAIN_MENU.getNameMenu() + " -");
        System.out.println(Menus.RETURN_MAIN_MENU.getItem1());
        System.out.println(Menus.RETURN_MAIN_MENU.getItem2());
    }

    static void exit() {
        System.out.println("\t" + "- " + Menus.EXIT.getNameMenu() + " -");
        System.out.println(Menus.EXIT.getItem1() + "\n");
    }
}
