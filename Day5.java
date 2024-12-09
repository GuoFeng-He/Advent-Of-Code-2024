import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 4140 (too low)

public class Day5 {
    static ArrayList<String> parameters;
    public static void main (String[] args){
        ArrayList<ArrayList<String>> fileData = getFileData("src/Day5Input");
        parameters = fileData.get(0);
        ArrayList<String> orders = fileData.get(1);

        System.out.println(partOne(orders));
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
        int sum = 0;
        for (String order: orders){
            ArrayList<Integer> split = convertInt(order.split(","));
            if (!isIncorrect(order, split)){
                sum += split.get((split.size() / 2));
            }
        }
        return sum;
    }

    public static int partTwo(ArrayList<String> orders){
        ArrayList<ArrayList<Integer>> incorrectOrders = new ArrayList<>();

        for (String order: orders){
            ArrayList<Integer> split = convertInt(order.split(","));
            if (isIncorrect(order, split)){
                incorrectOrders.add(split);
            }
        }

        for (ArrayList<Integer> a: incorrectOrders){
            for (int i = 0; )
        }
        return 0;
    }

    public static boolean isIncorrect(String order, ArrayList<Integer> split){
        for (int i = 0; i < split.size(); i++){
            ArrayList<Integer> lessThan = getLessThan(split.get(i));
            for (int j = 0; j < lessThan.size(); j++){
                if (split.contains(lessThan.get(j)) && split.indexOf(lessThan.get(j)) < i ){
                    return true;
                }
            }
        }
        return false;
    }

    public static ArrayList<Integer> convertInt(String[] split){
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < split.length; i++){
            newList.add(Integer.parseInt(split[i]));
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