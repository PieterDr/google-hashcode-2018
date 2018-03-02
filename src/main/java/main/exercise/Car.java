package main.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    public int number;
    public List<Ride> rides = new ArrayList<>();

    public Car(int number) {
        this.number = number;
    }

    public void assign(Ride ride) {
        rides.add(ride);
    }

    @Override
    public String toString() {
        String result = String.format("%d ", rides.size());
        String rideNumbers = this.rides.stream()
                .map(ride -> ride.number)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        return result + rideNumbers;
    }

    public Coordinate getLastCoordinate() {
        if (rides.isEmpty()) {
            return new Coordinate(0, 0);
        }
        return rides.get(rides.size() - 1).end;
    }

    public int getStepsUsed() {
        if (rides.isEmpty()) {
            return 0;
        }
        int result = rides.get(0).start.calculateDistanceTo(Coordinate.zero());
        for (int i = 1; i < rides.size(); i++) {
            result += rides.get(i - 1).end.calculateDistanceTo(rides.get(i).start);
            result += rides.get(i).getDuration();
        }
        return result;
    }
}