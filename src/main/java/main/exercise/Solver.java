package main.exercise;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solver {

    public static List<String> solve(Grid grid, List<Car> cars, List<Ride> rides) {
        int ridesPerCar = (int) Math.ceil((double) rides.size() / (double) cars.size());
        return cars.stream()
                .peek(car -> assignRides(car, rides, ridesPerCar))
                .map(Car::toString)
                .collect(toList());
    }

    private static void assignRides(Car car, List<Ride> rides, int numberOfRides) {
        while (car.rideNumbers.size() < numberOfRides && !rides.isEmpty()) {
            Ride closestRide = findClosestRide(rides, car.getLastCoordinate());
            car.assign(closestRide);
            rides.remove(closestRide);
        }
    }

    private static Ride findClosestRide(List<Ride> rides, Coordinate coordinate) {
        int minDistance = Integer.MAX_VALUE;
        Ride result = rides.get(0);
        for (Ride ride : rides) {
            int distance = ride.start.calculateDistanceTo(coordinate);
            if (distance < minDistance) {
                result = ride;
            }
            minDistance = distance;
        }
        return result;
    }

    private static List<String> firstTry(List<Car> cars, List<Ride> rides) {
        int carNr = 0;
        for (Ride ride : rides) {
            cars.get(carNr).assign(ride);
            carNr++;
            if (carNr == cars.size()) {
                carNr = 0;
            }
        }
        return cars.stream().map(Car::toString).collect(toList());
    }
}
