public enum Menus {
    INPUT_CARD("Please insert your Card!", "1 - insert card", "2 - not insert a card"),
    MAIN_MENU("Print balance or get money?", "1 - view balance", "2 - get money",
            "3 - exit. Return card"),
    CHECK_BALANCE("Check balance:", "1 - Draw check on screen", "2 - Print a paper check",
            "3 - return to previous menu",
            "4 - exit. Return card"),
    GET_MONEY("Get Money. Select amount:",
            "1 - " + Sums.FIFTY.getAmount() + " usd",
            "2 - " + Sums.ONE_HUNDRED.getAmount() + " usd",
            "3 - " + Sums.TWO_HUNDRED.getAmount() + " usd",
            "4 - " + Sums.FIFTH_HUNDRED.getAmount() + " usd",
            "5 - " + Sums.ONE_THOUSAND.getAmount() + " usd",
            "6 - other amount", "7 - return to previous menu",
            "8 - exit. Return card"),
    ASK_PRINT_CHECK("Do you want print check?", "1 - Print check",
            "2 - Don't print check. Save forest"),
    RETURN_MAIN_MENU("What do you want?", "1 - return to Main Menu",
            "2 - exit. Return card"),
    EXIT("Completion of work.", "Don't forget to pick up the card");

    private final String nameMenu;
    private final String item1;
    private String item5;
    private String item2;
    private String item6;
    private String item3;
    private String item7;
    private String item4;
    private String item8;


    Menus(String nameMenu, String item1) {
        this.nameMenu = nameMenu;
        this.item1 = item1;
    }

    Menus(String nameMenu, String item1, String item2) {
        this.nameMenu = nameMenu;
        this.item1 = item1;
        this.item2 = item2;
    }

    Menus(String nameMenu, String item1, String item2, String item3) {
        this.nameMenu = nameMenu;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    Menus(String nameMenu, String item1, String item2, String item3, String item4) {
        this.nameMenu = nameMenu;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
    }

    Menus(String nameMenu, String item1, String item2, String item3, String item4,
          String item5, String item6, String item7, String item8) {
        this.nameMenu = nameMenu;
        this.item1 = item1;
        this.item5 = item5;
        this.item2 = item2;
        this.item6 = item6;
        this.item3 = item3;
        this.item7 = item7;
        this.item4 = item4;
        this.item8 = item8;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public String getItem1() {
        return item1;
    }

    public String getItem2() {
        return item2;
    }

    public String getItem3() {
        return item3;
    }

    public String getItem4() {
        return item4;
    }

    public String getItem5() {
        return item5;
    }

    public String getItem6() {
        return item6;
    }

    public String getItem7() {
        return item7;
    }

    public String getItem8() {
        return item8;
    }
}