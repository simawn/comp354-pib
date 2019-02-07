package model.board;

/**
 * This enum type represents the possible "true identities" of the code names.
 * It is also used by the view in keeping track of the path to images
 * 
 * @author David Gray, Rani Rafid
 */
public enum CardType {
    Red, Blue, Assassin, Bystander;
    private static final String PATH = "file:resources/";
    private static final String EXT = ".png";
    private static boolean sex = false;

    /**
     * Used in initializing the board. Key Cards are stored as 25 character strings in a text file,
     * representing the 5 rows of 5 squares of colors under the following mapping.
    */
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

    /**
     * Returns the file path to the image used by the GUI for the corresponding CardType.
     * Switches the sex of the figure on the image each time it is called.
     * 
     * @param type
     * @return path to image as string
     */
    public static String pathOf(CardType type) {
        StringBuilder temp = new StringBuilder(PATH).append(type.toString());

        if (type != Assassin) {
            temp.append(sex ? "Male" : "Female");
            sex = !sex;
        }
        return temp.append(EXT).toString();
    }
}
