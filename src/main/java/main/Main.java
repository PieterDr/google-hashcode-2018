package main;

public class Main {

    public static void main(String[] args) throws Exception {
        new Reader("example.in").readLines()
                .forEach(System.out::println);
    }
}
