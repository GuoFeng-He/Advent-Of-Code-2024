
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args){
        ArrayList<ArrayList<String>> fileData = getFileData("src/Day6Input");

        System.out.println("Part One: " + partOne(fileData));
    }


    public static int partOne(ArrayList<ArrayList<String>> f){
        HashSet<String> uniquePositions = getAllPositions(f);
        return uniquePositions.size() + 1;
    }

    public static int partTwo(ArrayList<ArrayList<String>> f){
        HashSet<String> uniquePositions = getAllPositions(f);

        for (String pos: uniquePositions){
            String[] posSplit = pos.split(","); // columns [0], rows[1]
            int x = Integer.parseInt(posSplit[0]);
            int y = Integer.parseInt(posSplit[1]);

            String s = f.get(y).get(x);
            if (s.equals("^")){
                f.get(y - 1).set(x, "#");
            } else if (f.get())
        }
    }

    // x (columns), y (rows)
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

    public static HashSet<String> getAllPositions (ArrayList<ArrayList<String>> f){
        HashSet<String> uniquePositions = new HashSet<>();
        int[] pos = getPosition(f); // columns [0], rows[1]

        while (pos[0] != 0 && pos[0] != f.getFirst().size() - 1 && pos[1] != 0 && pos[1] != f.size() - 1){
            String s = f.get(pos[1]).get(pos[0]);
            if (s.equals("^") && !f.get(pos[1] - 1).get(pos[0]).equals("#")){
                f.get(pos[1]).set(pos[0], "X");
                f.get(pos[1] - 1).set(pos[0], "^");
            } else if (s.equals(">") && !f.get(pos[1]).get(pos[0] + 1).equals("#")){
                f.get(pos[1]).set(pos[0], "X");
                f.get(pos[1]).set(pos[0] + 1, ">");
            } else if (s.equals("V") && !f.get(pos[1] + 1).get(pos[0]).equals("#")){
                f.get(pos[1]).set(pos[0], "X");
                f.get(pos[1] + 1).set(pos[0], "V");
            } else if (s.equals("<") && !f.get(pos[1]).get(pos[0] - 1).equals("#")){
                f.get(pos[1]).set(pos[0], "X");
                f.get(pos[1]).set(pos[0] - 1, "<");
            } else {
                switch (s) {
                    case "^" -> f.get(pos[1]).set(pos[0], ">");
                    case ">" -> f.get(pos[1]).set(pos[0], "V");
                    case "V" -> f.get(pos[1]).set(pos[0], "<");
                    default -> f.get(pos[1]).set(pos[0], "^");
                }
            }
            uniquePositions.add(pos[0] + "," + pos[1]);
            pos = getPosition(f);
        }
        return uniquePositions;
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
