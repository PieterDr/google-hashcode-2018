package main.exercise;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class InputConverter {


    public static Grid getGrid(String header) {
        List<Integer> headerNumbers = mapToInts(header);
        return new Grid(headerNumbers.get(0), headerNumbers.get(1), headerNumbers.get(5));
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
        List<List<Integer>> rideList = rides.stream()
                .map(InputConverter::mapToInts)
                .collect(toList());
        List<Ride> result = new ArrayList<>();
        int nr = 0;
        for (List<Integer> ride: rideList) {
            result.add(new Ride(
                    nr,
                    new Coordinate(ride.get(0), ride.get(1)),
                    new Coordinate(ride.get(2), ride.get(3)),
                    ride.get(4),
                    ride.get(5)));
            nr++;
        }
        return result;
    }
}
