
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// 2207 (too high)
public class Day6 {
    public static void main(String[] args){
        ArrayList<ArrayList<String>> fileData = getFileData("src/Day6Input");


        System.out.println("Part One: " + partOne(fileData));
        System.out.println("Part Two: " + partTwo(fileData));
    }


    public static int partOne(ArrayList<ArrayList<String>> f){
        HashSet<String> uniquePositions = getAllPositions(f);
        return uniquePositions.size() + 1;
    }

    public static int partTwo(ArrayList<ArrayList<String>> f){
        HashSet<String> uniquePositions = getAllPositions(f);
        int count = 0;

        for (String pos: uniquePositions){
            ArrayList<ArrayList<String>> b = getFileData("src/Day6Input");
            removeCarat(b);
            String[] posSplit = pos.split(","); // columns [0], rows[1]
            int x = Integer.parseInt(posSplit[0]);
            int y = Integer.parseInt(posSplit[1]);
            String symbol = pos.substring(pos.length() - 1);
            b.get(y).set(x, symbol);


            if (symbol.equals("^")){
                b.get(y - 1).set(x, "#");
            } else if (symbol.equals(">")){
                b.get(y).set(x + 1, "#");
            } else if (symbol.equals("V")){
                b.get(y + 1).set(x, "#");
            } else {
                b.get(y).set(x - 1, "#");
            }

            if (getAllPositions(b).isEmpty()){
                count++;
                System.out.println(count);
            }
        }
        return count;
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
        ArrayList<String> sequence = new ArrayList<>();
        int[] pos = getPosition(f); // columns [0] rows[1]

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

            String save = pos[0] + "," + pos[1] + "," + s;
            if (!sequence.contains(save)) {
                sequence.add(save);
            } else {
                return new HashSet<>();
            }
            uniquePositions.add(save);
            pos = getPosition(f);


//            for (int i = 0; i < f.size(); i++){
//                System.out.println(f.get(i));
//            }
//            System.out.println("/////////////");
        }
        return uniquePositions;
    }

    public static boolean removeCarat(ArrayList<ArrayList<String>> f){
        for (int i = 0; i < f.size(); i++){
            for (int j = 0; j < f.getFirst().size(); j++){
                if (f.get(i).get(j).equals("^")){
                    f.get(i).set(j, ".");
                    return true;
                }
            }
        }
        return false;
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