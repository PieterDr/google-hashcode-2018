package main.exercise;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BonusSolver {

    public static List<String> solve(Grid grid, List<Car> cars, List<Ride> rides) {
        List<Ride> bonusRides = findBonusRidesAtStart(rides, grid);
        rides.removeAll(bonusRides);
        Util.assignSequentiallyToCars(cars, bonusRides);
        Util.assignSequentiallyToCars(cars, rides);
        return Util.mapToOutputLine(cars);
    }

    private static List<Ride> findBonusRidesAtStart(List<Ride> rides, Grid grid) {
        return rides.stream()
                .filter(ride -> ride.start.calculateDistanceTo(new Coordinate(0, 0)) < grid.duration)
                .collect(toList());
    }

}