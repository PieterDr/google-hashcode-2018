package main.exercise;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class InputConverter {


    public static Grid getGrid(String header) {
        List<Integer> headerNumbers = mapToInts(header);
        return new Grid(headerNumbers.get(0), headerNumbers.get(1));
    }

    private static List<Integer> mapToInts(String header) {
        return stream(header.split(" "))
                .map(Integer::parseInt)
                .collect(toList());
    }

    public static List<Car> getCars(String header) {
        List<Car> cars = new ArrayList<>();
        int nrOfCars = mapToInts(header).get(2);
        for (int i = 0; i < nrOfCars; i++) {
            cars.add(new Car(i));
        }
        return cars;
    }

    public static List<Ride> getRides(List<String> rides) {
        return rides.stream()
                .map(InputConverter::mapToInts)
                .map(ride -> new Ride(
                        new Coordinate(ride.get(0), ride.get(1)),
                        new Coordinate(ride.get(2), ride.get(3)),
                        ride.get(4),
                        ride.get(5)
                ))
                .collect(toList());
    }
}
