public class BoundedIntegerCap extends BoundedInteger
{
    public BoundedIntegerCap(int value, int lower, int upper, String command) throws OutOfBoundsException
    {
        super(value, lower, upper, command);
    }
}
