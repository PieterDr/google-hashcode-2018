package main.exercise;

import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Util {

    public static void assignAndRemoveFromInput(Car car, List<Ride> rides, Ride toAssign) {
        car.assign(toAssign);
        rides.remove(toAssign);
    }

    public static void assignAndRemoveFromInput(Car car, Iterator<Ride> rides, Ride toAssign) {
        car.assign(toAssign);
        rides.remove();
    }

    public static void assignSequentiallyToCars(List<Car> cars, List<Ride> rides) {
        int carNr = 0;
        Iterator<Ride> iterator = rides.iterator();
        while (iterator.hasNext()) {
            assignAndRemoveFromInput(cars.get(carNr), iterator, iterator.next());
            carNr++;
            if (carNr == cars.size()) {
                carNr = 0;
            }
        }
    }

    public static List<String> mapToOutputLine(List<Car> cars) {
        return cars.stream().map(Car::toString).collect(toList());
    }

    public static Ride findClosestAchievableRide(Car car, List<Ride> rides, Grid grid) {
        List<Ride> achievableRides = rides.stream()
                .filter(ride -> isAchievableBy(ride, car, grid))
                .collect(toList());
        int minCost = Integer.MAX_VALUE;
        Ride result = achievableRides.isEmpty() ? rides.get(0) : achievableRides.get(0);
        for (Ride ride : achievableRides) {
            int waitTime = ride.startTime - car.getStepsUsed();
            int cost = ride.start.calculateDistanceTo(car.getLastCoordinate()) + ride.getDuration() + waitTime;
            boolean canGetBonus = ride.canGetBonusWith(car);
            if (result.canGetBonusWith(car)) {
                if (cost < minCost && canGetBonus) {
                    result = ride;
                    minCost = cost;
                }
            } else if (canGetBonus) {
                result = ride;
                minCost = cost;
            }
        }
        return result;
    }

    private static boolean isAchievableBy(Ride ride, Car car, Grid grid) {
        int stepsNeeded = ride.getDuration() + ride.start.calculateDistanceTo(car.getLastCoordinate());
        return car.getStepsUsed() + stepsNeeded < grid.duration;
    }
}
