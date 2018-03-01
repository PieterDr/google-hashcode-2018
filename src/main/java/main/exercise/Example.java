package main.exercise;

import java.util.List;

public class Example implements Exercise {

    private final List<String> input;

    public Example(List<String> input) {
        this.input = input;
    }

    @Override
    public List<String> solve() {
        return input;
    }
}
