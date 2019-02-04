package model.component;

import model.constant.CardType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/*
    The purpose of this Class is to pick a random keycard from keyCards.txt file,
    and turn it into an array of CardTypes which will then be used to initialize the boards Card array.
*/
public class KeyCard implements Component {
    private final Path PATH = Paths.get("resources/keyCards.txt");

    @Override
    public CardType[] build() throws IOException {
        if (!Files.exists(PATH)) {
            throw new IOException("Error: Missing " + PATH);
        }

        List<String> list = Files.readAllLines(PATH);
        Collections.shuffle(list);

        String temp = list.remove(0);

        if (temp.length() != SIZE) {
            throw new IllegalArgumentException();
        }

        CardType[] types = new CardType[SIZE];
        for (int i = 0; i < temp.length(); i++) {
            types[i] = CardType.charOf(temp.charAt(i));
        }
        return types;
    }
}
