import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReaderForFiles
{
    private String fileName;
    private File file;
    private ArrayList<String> temp;

    public ReaderForFiles (String name)
    {
        this.fileName = name;
        file = new File(this.fileName);
        temp = new ArrayList<>();
    }

    public ArrayList<String> retrieveLines() throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
        {
            temp.add(st);
        }

        return (temp);
    }

    public File getFile()
    {
        return this.file;
    }
}
