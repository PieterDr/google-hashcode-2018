package main.exercise;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solver {

    public static Grid GRID;
    public static int count = 0;

    public static List<String> solve(Grid grid, List<Car> cars, List<Ride> rides) {
        int maxLoops = (int) Math.floor(rides.size() / cars.size());
        for (int i = 0; i < maxLoops; i++) {
            giveBestRides(cars, rides, grid);
        }
        GRID = grid;
        int ridesPerCar = (int) Math.ceil((double) rides.size() / (double) cars.size());
        return cars.stream()
                .peek(car -> assignRides(car, rides, ridesPerCar))
                .map(Car::toString)
                .collect(toList());
    }

    public static List<String> tryMetropolis(List<Car>cars, List<Ride>rides, Grid grid){
        GRID = grid;
        int ridesPerCar = (int) Math.ceil((double) rides.size() / (double) cars.size());
        return cars.stream()
                .peek(car -> assignRides(car, rides, ridesPerCar))
                .map(Car::toString)
                .collect(toList());
    }

    public static void giveBestRides(List<Car> cars, List<Ride> rides, Grid grid) {
        cars.forEach(car -> {
            Ride closestRide = Util.findClosestAchievableRide(car, rides, grid);
            Util.assignAndRemoveFromInput(car, rides, closestRide);
        });
    }

    public static void assignRides(Car car, List<Ride> rides, int numberOfRides) {
        while (car.rides.size() < numberOfRides && !rides.isEmpty()) {
            Ride closestRide = Util.findClosestAchievableRide(car, rides, GRID);
            Util.assignAndRemoveFromInput(car, rides, closestRide);
        }
    }

    public static List<String> firstTry(List<Car> cars, List<Ride> rides) {
        Util.assignSequentiallyToCars(cars, rides);
        return Util.mapToOutputLine(cars);
    }
}
