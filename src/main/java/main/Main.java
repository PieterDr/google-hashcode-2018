package main;

import main.exercise.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] files = new String[]{
                "a_example.in",
                "b_should_be_easy.in",
                "c_no_hurry.in",
                "d_metropolis.in",
                "e_high_bonus.in"
        };
        for (String file: files) {
            solve(file);
        }
    }

    private static void solve(String fileName) throws IOException, URISyntaxException {
        List<String> input = new Reader(fileName).readLines();
        String header = input.get(0);
        Grid grid = InputConverter.getGrid(header);
        List<Car> cars = InputConverter.getCars(header);
        List<Ride> rides = InputConverter.getRides(input.subList(1, input.size()));

        List<String> output = Solver.solve(grid, cars, rides);
        new Writer("output/" + fileName + ".out").write(output);
    }
}
