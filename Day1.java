import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        int size = fileData.size();
        int[] listOne = new int[size];
        int[] listTwo = new int[size];

        for (int i = 0; i < size; i++){
            listOne[i] = Integer.parseInt(fileData.get(i).split("   ")[0]);
            listTwo[i] = Integer.parseInt(fileData.get(i).split("   ")[1]);
        }

        int sum = 0;
        // part 1
//        Arrays.sort(listOne);
//        Arrays.sort(listTwo);
//
//        for (int i = 0; i < size; i++){
//            sum += Math.abs(listOne[i] - listTwo[i]);
//        }

        // part 2
        for (int i: listOne){
            sum += i * countNum(listTwo, i);
        }
        System.out.println(sum);

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

    public static void printList(int[] list){
        for (int i: list){
            System.out.println(i);
        }
        System.out.println("///////////////////");
    }

    public static int countNum(int[] list, int num){
        int count = 0;
        for (int i: list){
            if (i == num){
                count++;
            }
        }
        return count;
    }

//    public static ArrayList<Integer> sortChronological(ArrayList<Integer> array){
//        for (int i = 0; i < array.size(); i++){
//            int val = array.get(i);
//            int nextVal = array.get(i + 1)
//            if (val > nextVal){
//                int temp = array.get(i);
//
//            }
//        }
//    }
}