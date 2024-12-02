import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        ArrayList<Integer> listOne = new ArrayList<>();
        ArrayList<Integer> listTwo = new ArrayList<>();

        for (String str: fileData){
            String[] split = str.split("   ");
            listOne.add(Integer.parseInt(split[0]));
            listTwo.add(Integer.parseInt(split[1]));
        }
        System.out.println(listOne);
        System.out.println("////");
        System.out.println(listTwo);

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

    public static ArrayList<Integer> sortChronological(ArrayList<Integer> array){
        for (int i = 0; i < array.size(); i++){
            int val = array.get(i);
            int nextVal = array.get(i + 1)
            if (val > nextVal){
                int temp = array.get(i);

            }
        }
    }
}