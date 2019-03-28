import java.util.ArrayList;

public class LinesInfo {
    private ArrayList<String> lines;
    private String command;
    private int value, lower, upper;
    private ArrayList<Integer> restValues;

    LinesInfo(ArrayList<String> lines)
    {
        this.restValues = new ArrayList<>();
        this.lines = lines;
        setAll();
    }

    public String getCommand()
    {
        return command;
    }

    public int getValue() {
        return value;
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }

    public ArrayList<Integer> getRestValues()
    {
        return (this.restValues);
    }

    public void setAll()
    {
        this.command = this.lines.get(0);
        this.lower = Integer.parseInt(this.lines.get(1).substring(0,splittingString(lines.get(1))));
        this.upper = Integer.parseInt(this.lines.get(1).substring(splittingString(lines.get(1)) + 1));
        this.value = (this.upper + this.lower) / 2;
        this.setRestValues();
    }

    public void setRestValues()
    {
        for (int i = 2; i < this.lines.size(); i++)
        {
            this.restValues.add(Integer.parseInt(this.lines.get(i)));
        }
    }


    public int splittingString (String string)
    {
        int spaceLocated = 0;
        char c;
        for(int i = 0; i < string.length(); i++)
        {
            c = string.charAt(i);

            if(c == ' ')
            {
                spaceLocated = i;
            }
        }
        return spaceLocated;
    }
}
