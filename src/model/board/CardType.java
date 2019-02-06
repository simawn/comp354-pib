package model.board;

public enum CardType {
    Red, Blue, Assassin, Bystander;
    private static final String PATH = "file:resources/";
    private static final String EXT = ".png";
    private static boolean sex = false;

    public static CardType charOf(char arg) {
        if (arg == 'R') {
            return CardType.Red;
        } else if (arg == 'B') {
            return CardType.Blue;
        } else if (arg == 'A') {
            return CardType.Assassin;
        } else if (arg == 'Y') {
            return CardType.Bystander;
        }
        throw new IllegalArgumentException();
    }

    public static String pathOf(CardType type) {
        StringBuilder temp = new StringBuilder(PATH).append(type.toString());

        if (type != Assassin) {
            temp.append(sex ? "Male" : "Female");
            sex = !sex;
        }
        return temp.append(EXT).toString();
    }
}
