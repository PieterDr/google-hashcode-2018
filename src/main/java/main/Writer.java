package main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Writer {

    private final String filename;

    Writer(String filename) {
        this.filename = filename;
    }

    public void write(List<String> content) throws IOException {
        Files.write(Paths.get(filename), content, Charset.defaultCharset());
    }
}
