package main;

import main.exercise.*;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> input = new Reader("a_example.in").readLines();
        String header = input.get(0);
        Grid grid = InputConverter.getGrid(header);
        List<Car> cars = InputConverter.getCars(header);
        List<Ride> rides = InputConverter.getRides(input.subList(1, input.size()));

        List<String> output = Solver.solve(grid, cars, rides);
        new Writer("output/a.out").write(output);
    }
}
