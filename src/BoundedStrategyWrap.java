public class BoundedStrategyWrap implements BoundedStrategy {
    @Override
    public int bounded(int value, int lower, int upper) throws OutOfBoundsException
    {
        if(!(value > lower && value < upper))
        {
            if(value > upper)
            {
                value = lower + (value - upper) % (upper -lower);
            }
            else
            {
                value = (upper - value) % (upper - lower);
            }
        }
        return value;
    }
}
