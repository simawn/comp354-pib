package model.component;

import java.io.IOException;

public interface Component {
    int SIZE = 25;

    Object[] build() throws IOException;
}
