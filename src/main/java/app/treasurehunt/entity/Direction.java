package app.treasurehunt.entity;

public enum Direction {
    N, E, S, O;

    public Direction rotateLeft() {
        return switch (this) {
            case N -> O;
            case O -> S;
            case S -> E;
            case E -> N;
        };
    }

    public Direction rotateRight() {
        return switch (this) {
            case N -> E;
            case O -> N;
            case S -> O;
            case E -> S;
        };
    }
}
