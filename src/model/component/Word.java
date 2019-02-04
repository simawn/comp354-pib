package model.component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;



/*
    The purpose of this Class is to pick a random set of 25 words from the words.txt file,
    and turn it into an array of strings which is used to build the board.
*/
public class Word implements Component {
    private static final Path PATH = Paths.get("resources/words.txt");

    @Override
    public String[] build() throws IOException {
        if (!Files.exists(PATH)) {
            throw new IOException("Error: Missing " + PATH);
        }

        List<String> list = Files.readAllLines(PATH);
        Collections.shuffle(list);

        return list.toArray(new String[SIZE]);
    }

}
