import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (String str: fileData){
            String[] splitString = str.split(" ");
            ArrayList<Integer> smallList = new ArrayList<>();

            for (int i = 0; i < splitString.length; i++){
                smallList.add(Integer.parseInt(splitString[i]));
            }
            list.add(smallList);
        }

        System.out.println(partTwo(list));
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public static int partOne(ArrayList<ArrayList<Integer>> list){
        int count = 0;
        for (ArrayList<Integer> intList: list){
            if (isSafe(intList)){
                count++;
            }
        }
        return count;
    }

    public static boolean isSafe(ArrayList<Integer> list){
        int lastDifference = 0;

        for (int i = 0; i < list.size() - 1; i++){
            int difference = list.get(i + 1) - list.get(i);
            if (difference * lastDifference >= 0 && Math.abs(difference) >= 1 && Math.abs(difference) <= 3){
                lastDifference = difference;
            } else {
                break;
            }

            if (i == list.size() - 2){
                return true;
            }
        }
        return false;
    }

    public static int partTwo(ArrayList<ArrayList<Integer>> list){
        int count = 0;
        for (ArrayList<Integer> intList: list){
            for (int i = 0; i < intList.size(); i++){
                ArrayList<Integer> tempList = new ArrayList<>();
                for (int num: intList){
                    tempList.add(num);
                }
                tempList.remove(i);

                if (isSafe(tempList)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}