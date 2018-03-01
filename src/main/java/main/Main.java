package main;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> input = new Reader("a_example.in").readLines();
        new Writer("output/a.out").write(input);
    }
}
