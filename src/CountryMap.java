public class CountryMap {
    private String[] fileArray;
    private final int countSize;
    private String fileName;

    public CountryMap(String[] fileArray, int countSize, String fileName) {
        this.fileArray = fileArray;
        this.countSize = countSize;
        this.fileName = fileName;
    }

    public boolean checkMapFormat() {
        if (!checkFirstLine()) {
            return false;
        } else if (!checkSecondLine()) {
            return false;
        }
        else if (!checkThirdLine()){
            return false;
        }
        else if (!checkUntilLastLine()) {
            return false;
        }
        else if (!checkLastLine()){
            return false;
        }
        return true;
        // checkForthLine();
    }

    private boolean checkFirstLine() {
        boolean checkFirstLine = true;

        String firstNumberString = fileArray[0];
        boolean checkEmpty = false;
        if (firstNumberString.equals("")) {
            checkEmpty = true;
            firstNumberString = "First line is empty";
            System.out.println(firstNumberString);
        }
        try {
            int firstNumber = Integer.parseInt(firstNumberString);
        } catch (NumberFormatException err) {
            if (!checkEmpty) {
                System.out.println(firstNumberString + " is not a number");
                checkFirstLine = false;
            } else {
                checkFirstLine = false;
            }
        }
        return checkFirstLine;
    }

    private boolean checkSecondLine() {
        City city = new City(fileArray);
        return city.checkCity();
    }

    private boolean checkThirdLine(){
        boolean checkThirdLine = true;
        String number_of_routes = fileArray[2];
        boolean checkEmpty = false;
        if (number_of_routes.equals("")) {
            checkEmpty = true;
            number_of_routes = "Third line is empty";
            System.out.println(number_of_routes);
        }
        try {
            int thirdNumber = Integer.parseInt(number_of_routes);
        } catch (NumberFormatException err) {
            if (!checkEmpty) {
                System.out.println(number_of_routes + " is not a number");
                checkThirdLine = false;
            } else {
                checkThirdLine = false;
            }
        }
        return checkThirdLine;
    }

    private boolean checkUntilLastLine() {
        boolean checkRoutes = true;
        for (int i = 3; i<=fileArray.length-2;i++){
            int arrayIndexFromThree = i;
            String handler = fileArray[arrayIndexFromThree];
            arrayIndexFromThree += 1;
            String[] control = handler.split(" ");
            String firstPath = control[0];
            String secondPath = control[1];
            if (firstPath.equals(secondPath)) {
                System.out.println("Format is wrong they are same");
                System.out.println("Line "+ arrayIndexFromThree+1);
                System.out.println(firstPath + " equals " + secondPath);
                checkRoutes=  false;
            }
            boolean checkEmpty = false;
            try{
                if (control[2] == null){}
                checkEmpty = true;

            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Line "+ arrayIndexFromThree+": Number is empty");
            }
            if (checkEmpty){
                try {
                    int thirdNumber = Integer.parseInt(control[2]);
                } catch (NumberFormatException err) {
                    System.out.println("Line "+ arrayIndexFromThree+": "+control[2] + " is not a number");
                    checkRoutes = false;
                }
            }
        }
        return checkRoutes;
    }

    private boolean checkLastLine(){
        boolean checkLastLine = true;
        String handler = fileArray[fileArray.length-1];
        String[] control = handler.split(" ");
        if (control.length!=2){
            System.out.println("Last line: Txt format should include one initial city and one goal city");
            checkLastLine = false;
            return checkLastLine;
        }
        String firstPath = control[0];
        String secondPath = control[1];
        if (firstPath.equals(secondPath)) {
            checkLastLine = false;
            System.out.println("Last line : "+firstPath + " equals " + secondPath);
        }
        return checkLastLine;
    }
}