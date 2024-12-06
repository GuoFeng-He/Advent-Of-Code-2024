
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// 6787952


public class Day3 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day3Input");
        String fileDataString = "";

        for (String a: fileData){
            fileDataString += a;
        }


        ArrayList<String> allMatchesOne = new ArrayList<>();
        String regex = "mul\\([1-9][0-9]{0,2},[1-9][0-9]{0,2}\\)";
        ArrayList<String> allMatchesTwo = new ArrayList<>();
        String regexTwo  = "mul\\([1-9][0-9]{0,2},[1-9][0-9]{0,2}\\)|do\\(\\)|don't\\(\\)";

        Matcher m = Pattern.compile(regex).matcher(fileDataString);
        Matcher mTwo = Pattern.compile(regexTwo).matcher(fileDataString);

        while (m.find()) {
            allMatchesOne.add(m.group());
        }
//
        while(mTwo.find()){
            allMatchesTwo.add(mTwo.group());
        }
        System.out.println(allMatchesOne);


        System.out.println(partOne(allMatchesOne));
        System.out.println(partTwo(allMatchesTwo));




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

    public static int partOne(ArrayList<String> matches){
        int sum = 0;

        for (String str: matches){
            sum += multiply(str);
        }
        return sum;
    }

    public static int partTwo(ArrayList<String> matches){
        int sum = 0;
        boolean count = true;

        for (String str: matches){
            if (str.equals("don't()")){
                count = false;
            } else if (str.equals("do()")){
                count = true;
            } else if (count){
                sum += multiply(str);
            }
        }
        return sum;
    }

    public static int multiply(String str){
        int firstInt = Integer.parseInt(str.substring(4, str.indexOf(",")));
        int secondInt = Integer.parseInt(str.substring(str.indexOf(",") + 1, str.length() - 1));
        return firstInt * secondInt;
    }
}