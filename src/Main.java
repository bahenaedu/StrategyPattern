import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception
    {
        //Variables
        Scanner scanner = new Scanner(System.in);
        LinesInfo linesInfo;
        String nameOfFile;

        //Ask the user for the file
        System.out.println("Enter file name: ");
        nameOfFile = scanner.nextLine();

        //Retrieving all the information in the file
        ReaderForFiles reader = new ReaderForFiles(nameOfFile);
        linesInfo = new LinesInfo(reader.retrieveLines());

        if (linesInfo.getCommand().equals("Exception"))
        {
            BoundedInteger bE = new BoundedIntegerException
                    (linesInfo.getValue(), linesInfo.getLower(), linesInfo.getUpper(), linesInfo.getCommand());
            writInFile(nameOfFile, linesInfo, bE);
        }
        else if (linesInfo.getCommand().equals("Wrap"))
        {
            BoundedInteger bW = new BoundedIntegerException
                    (linesInfo.getValue(), linesInfo.getLower(), linesInfo.getUpper(), linesInfo.getCommand());
            writInFile(nameOfFile, linesInfo, bW);
        }
        else if (linesInfo.getCommand().equals("Cap"))
        {
            BoundedInteger bC = new BoundedIntegerException
                    (linesInfo.getValue(), linesInfo.getLower(), linesInfo.getUpper(), linesInfo.getCommand());
            writInFile(nameOfFile, linesInfo, bC);
        }
    }

    public static void writInFile(String nameFile, LinesInfo linesInfo, BoundedInteger b) throws IOException
    {
        ArrayList<Integer> temp = linesInfo.getRestValues();
        BufferedWriter writer = new BufferedWriter(new FileWriter("out-" + nameFile));
        writer.write("Original value: " + b.getValue() + "\n");

        //For each value
        for (int i = 0; i < temp.size(); i++)
        {
            b.addWith(temp.get(i));
            if(b.getMessage().equals("L"))
            {
                writer.write("Sorry. The integer is out of bounds\n");
                break;
            }
            writer.write("New value: " + b.getValue() + "\n");
        }
        writer.close();
    }
}
