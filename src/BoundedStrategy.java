public interface BoundedStrategy {
    int bounded(int value, int lower, int upper) throws OutOfBoundsException; //setting the rule for each strategy.
}
