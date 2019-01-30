package model.constant;

public enum CardType {
    RED, BLUE, ASSASSIN, BYSTANDER;

    public static CardType charOf(char arg) {
        if (arg == 'R') {
            return CardType.RED;
        } else if (arg == 'B') {
            return CardType.BLUE;
        } else if (arg == 'A') {
            return CardType.ASSASSIN;
        } else if (arg == 'Y') {
            return CardType.BYSTANDER;
        }
        throw new IllegalArgumentException();
    }
}
