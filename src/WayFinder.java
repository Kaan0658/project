public class WayFinder {
    City city;
    CountryMap countryMap;
    FileArrayHandler fileArrayHandler;
    public void findBestWay(){
        fileArrayHandler = new FileArrayHandler();
        fileArrayHandler.readFile();
        //CountryMap gets FileArrayHandler array
        countryMap = new CountryMap(fileArrayHandler.getFileArray());
        //City gets FileArrayHandler array
        city = new City(fileArrayHandler.getFileArray());

        if(countryMap.checkMapFormat()){
            //Create algorithm
        }
        else {
            System.out.println("Txt format is wrong !!!");
        }

    }
}