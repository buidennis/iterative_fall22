import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FileReader{
    public static void main(String[] args){
        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(args.length == 2 && args[1].equals("reverse")){
                    System.out.println(reverseString(data));
                }
                else{
                    System.out.println(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String reverseString(String ref){
        String revString = "";
        char ch;

        for(int i = 0; i < ref.length(); i++){
            ch = ref.charAt(i);
            revString = ch + revString;
        }
        return revString;
    }
}
