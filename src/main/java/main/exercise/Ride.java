package main.exercise;

public class Ride {

    public Coordinate start;
    public Coordinate end;
    public int startTime;
    public int endTime;

    public Ride(Coordinate start, Coordinate end, int startTime, int endTime) {
        this.start = start;
        this.end = end;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
