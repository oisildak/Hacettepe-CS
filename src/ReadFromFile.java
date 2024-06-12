import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

    List<String[]> temp = new ArrayList <String[]>();
    public static String[] readFile(String path) {//I copied from assignmet1 pdf as I state in assignment1 it prove us to read file
        try {
            int i = 0;
            int length = Files.readAllLines(Paths.get(path)).size();
            String[] results = new String[length];//we  created a result string which has length of file
            for (String line : Files.readAllLines(Paths.get(path))) {
                results[i++] = line;//the we append on it
            }
            return results;
        } catch (IOException e) {//that helps us to avoid IO
            e.printStackTrace();
            return null;
        }
    }


    public void splitfile(String args) {//it helps to split file and add a array in this case that split it \t(tab)
        String[] lines = ReadFromFile.readFile(args);
        for (String line : lines) {
            String[] split = line.split("\t");
            temp.add(split);// temp is abb. of temporary it is holding spliting lines
        }


    }
}