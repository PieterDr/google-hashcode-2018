package main.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    public int number;
    public List<Integer> rideNumbers = new ArrayList<>();

    public Car(int number) {
        this.number = number;
    }

    public void assign(Ride ride) {
        rideNumbers.add(ride.number);
    }

    @Override
    public String toString() {
        String result = String.format("%d ", rideNumbers.size());
        String rideNumbers = this.rideNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        return result + rideNumbers;
    }
}
