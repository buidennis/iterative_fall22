https://www.w3schools.com/java/java_files_read.asp
// Wrap in a Try-Catch

File Class
    File obj = new File("path");
    File obj = new File(args[0]);
    
    Catch: FileNotFoundException e; e.printStackTrace();

Scanner Class
    Scanner reader = new Scanner(obj);
    
    .hasNextLine()
        Output: Boolean
    .nextLine()
        Output: String
    .close()
        
https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
    == tests for reference equality (whether they are the same object).
    .equals() tests for value equality (whether they are logically "equal")
