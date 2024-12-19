import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class City {
    private String[] fileArray;
    public City(String[] fileArray){
        this.fileArray = fileArray;
    }
    public void getCities(){
        for (String asd : fileArray){
            System.out.println(asd+" from cities");
        }
    }
}