package main.exercise;

public class Coordinate {

    public int row;
    public int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int calculateDistanceTo(Coordinate other) {
        return Math.abs(row - other.row) + Math.abs(column - other.column);
    }

    public static Coordinate zero() {
        return new Coordinate(0, 0);
    }
}
