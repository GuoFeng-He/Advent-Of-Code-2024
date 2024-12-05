
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
        StringBuilder fileDataString = new StringBuilder();
        String testString = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";

        for (String a: fileData){
            fileDataString.append(a);
        }

        System.out.println(fileDataString);
        System.out.println(fileData);

        ArrayList<String> allMatches = new ArrayList<String>();
        String regex = "mul\\([1-9][0-9]{0,2},[1-9][0,9]{0,2}\\)";

        Matcher m = Pattern.compile(regex).matcher(fileDataString);

        while (m.find()) {
            allMatches.add(m.group());
        }

        System.out.println(allMatches);

        System.out.println(partOne(allMatches));




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
            int firstInt = Integer.parseInt(str.substring(4, str.indexOf(",")));
            int secondInt = Integer.parseInt(str.substring(str.indexOf(",") + 1, str.length() - 1));

            sum += firstInt * secondInt;
            System.out.print(firstInt+",");
            System.out.print(secondInt + "||||");
        }
        return sum;
    }
}