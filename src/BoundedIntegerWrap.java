public class BoundedIntegerWrap extends BoundedInteger
{
    public BoundedIntegerWrap(int value, int lower, int upper, String command) throws OutOfBoundsException
    {
        super(value, lower, upper, command);
    }
}
