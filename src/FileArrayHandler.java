import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileArrayHandler {
    private String[] fileArray;
    private String fileName;
    private int countSize = 0;

    public FileArrayHandler(String fileName){
        this.fileName = fileName;
    }
    public void readFile() {
        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }
        Scanner reader = null;
        try {
            reader = new Scanner(Paths.get(fileName));
            while (reader.hasNextLine()) {
                reader.nextLine();
                countSize++;
            }
            //Private method call
            createArrayFile(countSize);
        } catch (IOException e) {
            System.out.println("There is no such a file : " + fileName);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private void createArrayFile(int countSize) {
        fileArray = new String[countSize];
        Scanner reader = null;
        int count = 0;
        try {
            reader = new Scanner(Paths.get(fileName));
            while (reader.hasNextLine()) {
                fileArray[count] = reader.nextLine();
                count++;
            }
        } catch (IOException e) {
            System.out.println("There is no such a file : " + fileName);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public String[] getFileArray() {
        return fileArray;
    }

    public int getCountSize(){
        return countSize;
    }
}