import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args){
        ArrayList<ArrayList<String>> fileData = getFileData("src/Day6Input");

        System.out.println(getCaratPosition(fileData));
    }

    public static int partOne(ArrayList<ArrayList<String>> f){
        HashSet<String> uniqueSpots = new HashSet<>();
        int[] pos = getPosition(f);

        while (pos[0] != 0 && pos[1] != 0){
            String s = f.get(pos[1]).get(pos[0]);
            if (s.equals("^")){

                if (f.get(pos[1] - 1).get(pos[0]) != "#"){
                        
                }
            }
        }

        return uniqueSpots.size();
    }

    // x, y
    public static int[] getPosition(ArrayList<ArrayList<String>> fileData){
        int[] pos = new int[2];
        for (int i = 0; i < fileData.size(); i++){
            for (int j = 0; j < fileData.get(0).size(); j++){
                String s = fileData.get(i).get(j);
                if (s.equals("^") || s.equals(">") || s.equals("V") || s.equals("<")){
                    pos[0] = j;
                    pos[1] = i;
                    return pos;
                }
            }
        }
        return pos;
    }

    public static ArrayList<ArrayList<String>> getFileData(String fileName) {
        ArrayList<ArrayList<String>> fileData = new ArrayList<>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                ArrayList<String> spaces = new ArrayList<>();
                if (!line.equals("")) {
                    for (int i = 0; i < line.length(); i++){
                        spaces.add(line.substring(i, i + 1));
                    }
                }
                fileData.add(spaces);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
