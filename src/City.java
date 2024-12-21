import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class City {
    private String[] fileArray;
    private String[] cities;
    public City(String[] fileArray){
        this.fileArray = fileArray;
    }
    public boolean checkCity(){
        boolean checkSecondLine = true;
        int firstLineNumber = Integer.parseInt(fileArray[0]);
        String [] cities = fileArray[1].split(" ");
        if (firstLineNumber != cities.length){
            System.out.println("There is no "+ firstLineNumber+" cities in my txt");
            checkSecondLine = false;
        }
        for (int i = 0; i < cities.length; i++){
            String city = cities[i];
            if (i+1 != firstLineNumber){
                for (int j = i+1; j < cities.length; j++){
                    if (city.equals(cities[j])){
                        System.out.println(city +" equals " + cities[j]);
                        checkSecondLine = false;
                        break;
                    }
                }
            }
            if (!checkSecondLine){
                break;
            }
        }
        if (checkSecondLine){

        }
        return checkSecondLine;
    }
    public String[] getCity(){
        cities = fileArray[1].split(" ");
        return cities;
    }
}