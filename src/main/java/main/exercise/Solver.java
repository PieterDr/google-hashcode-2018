package main.exercise;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solver {

    public static Grid GRID;

    public static List<String> solve(Grid grid, List<Car> cars, List<Ride> rides) {
        GRID = grid;
        int ridesPerCar = (int) Math.ceil((double) rides.size() / (double) cars.size());
        return cars.stream()
                .peek(car -> assignRides(car, rides, ridesPerCar))
                .map(Car::toString)
                .collect(toList());
    }

    private static void assignRides(Car car, List<Ride> rides, int numberOfRides) {
        while (car.rides.size() < numberOfRides && !rides.isEmpty()) {
            Ride closestRide = Util.findClosestAchievableRide(car, rides, car.getLastCoordinate(), GRID);
            Util.assignAndRemoveFromInput(car, rides, closestRide);
        }
    }

    private static List<String> firstTry(List<Car> cars, List<Ride> rides) {
        Util.assignSequentiallyToCars(cars, rides);
        return Util.mapToOutputLine(cars);
    }
}