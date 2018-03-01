package main.exercise;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solver {

    public static List<String> solve(Grid grid, List<Car> cars, List<Ride> rides) {
        int carNr = 0;
        for (Ride ride: rides) {
            cars.get(carNr).assign(ride);
            carNr++;
            if (carNr == cars.size()) {
                carNr = 0;
            }
        }
        return cars.stream().map(Car::toString).collect(toList());
    }
}
