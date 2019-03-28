public class BoundedInteger
{
    private int value, lower, upper;
    private BoundedStrategy b;
    private String message = " ";

    public BoundedInteger (int value, int lower, int upper, String command) throws OutOfBoundsException
    {
        setCommand(command);
        this.lower = lower;
        this.upper = upper;
        setValue(value);
    }

    public void setValue(int newValue) throws OutOfBoundsException
    {
        performStrategy(newValue);
    }

    public String getMessage()
    {
        return this.message;
    }


    public int getValue()
    {
        return this.value;
    }

    public void addWith (int newValue) throws OutOfBoundsException
    {
        int temp = this.value + newValue;
        setValue(temp);
    }


    public void setStrategy (BoundedStrategy strategy)
    {
        this.b = strategy;
    }

    public void performStrategy(int tempValue) throws OutOfBoundsException
    {
        this.value = b.bounded(tempValue, this.lower, this.upper);
    }

    public void setCommand (String command)
    {
        switch (command)
        {
            case "Exception": this.setStrategy(new BoundedStrategyException()); break;
            case "Wrap": this.setStrategy(new BoundedStrategyWrap()); break;
            case "Cap": this.setStrategy(new BoundedStrategyCap()); break;
            default: break;
        }
    }

    @Override
    public String toString() {
        return "This is your value: " + this.value;
    }
}
