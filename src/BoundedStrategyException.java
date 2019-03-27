public class BoundedStrategyException implements BoundedStrategy {
    @Override
    public int bounded(int value, int lower, int upper) throws OutOfBoundsException
    {
        if(value < lower || value > upper)
        {
            throw new OutOfBoundsException("Opss");
        }
        else
        {
            return value;
        }
    }
}
