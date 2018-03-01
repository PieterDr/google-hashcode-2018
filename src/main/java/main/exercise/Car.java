package main.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    public int number;
    public List<Ride> rideNumbers = new ArrayList<>();

    public Car(int number) {
        this.number = number;
    }

    public void assign(Ride ride) {
        rideNumbers.add(ride);
    }

    @Override
    public String toString() {
        String result = String.format("%d ", rideNumbers.size());
        String rideNumbers = this.rideNumbers.stream()
                .map(ride -> ride.number)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        return result + rideNumbers;
    }

    public Coordinate getLastCoordinate() {
        if (rideNumbers.isEmpty()) {
            return new Coordinate(0, 0);
        }
        return rideNumbers.get(rideNumbers.size() -1).end;
    }
}
