import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5 {
    static ArrayList<String> parameters;
    public static void main (String[] args){
        ArrayList<ArrayList<String>> fileData = getFileData("src/Day5Input");
        parameters = fileData.get(0);
        ArrayList<String> orders = fileData.get(1);

    }

    public static ArrayList<ArrayList<String>> getFileData(String fileName) {
        ArrayList<ArrayList<String>> fileData = new ArrayList<ArrayList<String>>();
        fileData.add(new ArrayList<>());
        fileData.add(new ArrayList<>());
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            int idx = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals("")) {
                    fileData.get(idx).add(line);
                } else{
                    idx = 1;
                }
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public static int partOne(ArrayList<String> orders){
        ArrayList<Integer> middles = new ArrayList<>();
        for (String order: orders){
            int[] split = convertInt(order.split(","));

            for (int i = 0; i < split.length; i++){
                ArrayList<Integer> lessThan = getLessThan(split[i]);
                for (int j = i + 1; j < split.length; j++){
                    if (lessThan.contains(split[j]))
                }
            }
        }
    }

    public static int[] convertInt(String[] split){
        int[] newList = new int[split.length];
        for (int i = 0; i < split.length; i++){
            newList[i] = Integer.parseInt(split[i]);
        }
        return newList;
    }

    public static ArrayList<Integer> getLessThan(int num){
        ArrayList<Integer> match = new ArrayList<>();

        for (String line: parameters){
            if (line.substring(0, 2).equals(""  + num)){
                match.add(Integer.parseInt(line.substring(3)));
            }
        }
        return match;
    }
}
