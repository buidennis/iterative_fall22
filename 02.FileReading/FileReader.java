import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
public class FileReader{
    public static void main(String[] args){
        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);

            // reverse option
            boolean reverse = (args.length == 2 && args[1].equals("reverse"));
            if(reverse){
                File revFile = new File("rev:" + args[0]);
                FileWriter revWriter = new FileWriter("rev:" + args[0]);
                if(revFile.createNewFile()){
                    System.out.println("File created: " + revFile.getName());
                }
                else{
                    System.out.println("File is already created");
                }
            }
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(reverse){
                    System.out.println(reverseString(data));
                    revWriter.write(reverseString(data));
                }
                else{
                    System.out.println(data);
                }
            }
            myReader.close();
            if(reverse){
                revWriter.close();
            }
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
