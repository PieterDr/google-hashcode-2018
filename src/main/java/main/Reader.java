package main;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Reader {

    private final URI resource;

    public Reader(String resource) throws URISyntaxException {
        this.resource = getClass().getClassLoader().getResource(resource).toURI();
    }

    public List<String> readLines() throws IOException {
        return Files.lines(Paths.get(resource))
                .collect(toList());
    }
}
