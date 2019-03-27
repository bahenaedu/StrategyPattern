public class BoundedStrategyCap implements BoundedStrategy {
    @Override
    public int bounded(int value, int lower, int upper) throws OutOfBoundsException
    {
        if (value < lower)
        {
            return lower;
        }
        else if (value > upper)
        {
            return upper;
        }
        return value;
    }
}
