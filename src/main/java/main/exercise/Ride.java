package main.exercise;

public class Ride {

    public int number;
    public Coordinate start;
    public Coordinate end;
    public int startTime;
    public int endTime;

    public Ride(int number, Coordinate start, Coordinate end, int startTime, int endTime) {
        this.number = number;
        this.start = start;
        this.end = end;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getDuration() {
        return start.calculateDistanceTo(end);
    }
}