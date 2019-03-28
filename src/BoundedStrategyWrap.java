public class BoundedStrategyWrap implements BoundedStrategy {
    @Override
    public int bounded(int value, int lower, int upper) throws OutOfBoundsException
    {
        if (value > upper) {
            while (value > upper){
                value -= upper - lower + 1;
            }
        }
        else {
            while (value < lower){
                value += upper - lower + 1;
            }
        }
        return value;
    }
}
