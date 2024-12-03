import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 743, 444, 442

public class Day2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        ArrayList<int[]> list = new ArrayList<>();
        for (String str: fileData){
            String[] splitString = str.split(" ");
            int[] smallList = new int[splitString.length];

            for (int i = 0; i < splitString.length; i++){
                smallList[i] = Integer.parseInt(splitString[i]);
            }
            list.add(smallList);
        }

        int count = 0;
        for (int[] intList: list){
            int lastDifference = 0;
            int[] original = intList;
            boolean strike = false;
            boolean strikeTwo = false;

            for (int i = 0; i < intList.length - 1; i++){
                int difference = intList[i + 1] - intList[i];

                if (difference * lastDifference >= 0 && Math.abs(difference) >= 1 && Math.abs(difference) <= 3){
                    lastDifference = difference; // between the current idx and the next idx
                } else {
                    if (!strike){
                        intList = removeElement(i, intList);
                        strike = true;
                        i--;
                    } else {
                        if (!strikeTwo){
                            intList = removeFirstElement(original);
                            strikeTwo = true;
                            i = 0;
                        } else {
                            break;
                        }
                    }
                }

                if (i == intList.length - 2){
                    count++;
                }
            }
        }
        System.out.println(count);
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

    public static int[] removeElement(int idx, int[] list){
        int[] newList = new int[list.length - 1];
        int increment = 0;

        for (int i = 0; i < list.length; i++){
            if (i != idx){
                newList[i - increment] = list[i];
            }else{
                increment = 1;
            }
        }
        return newList;
    }
    public static int[] removeFirstElement(int[] list){
        int[] newList = new int[list.length - 1];
        int increment = 0;

        for (int i = 0; i < list.length; i++){
            if (i != 0){
                newList[i - increment] = list[i];
            } else{
                increment = 1;
            }
        }
        return newList;
    }
}