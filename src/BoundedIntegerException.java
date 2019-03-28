public class BoundedIntegerException extends BoundedInteger
{
    public BoundedIntegerException(int value, int lower, int upper, String command) throws OutOfBoundsException
    {
        super(value, lower, upper, command);
    }
}
