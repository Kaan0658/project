public class CountryMap {
    private String[] fileArray;

    public CountryMap(String[] fileArray) {
        this.fileArray = fileArray;
    }

    public boolean checkMapFormat() {

        if (!checkFirstLine()){
            return false;
        }

        String handler = fileArray[3];
        String[] control = handler.split(" ");
        String firstPath = control[0];
        String secondPath = control[1];
        if (firstPath.equals(secondPath)) {
            System.out.println("Format is wrong they are same");
            System.out.println("Line 4");
            System.out.println(firstPath + " equals " + secondPath);
            return false;
        } else {
            System.out.println("There is no problem");
            return true;
        }

    }

    private boolean checkFirstLine(){
        boolean checkFirstLine = true;

        String firstNumberString = fileArray[0];
        boolean checkEmpty = false;
        if (firstNumberString.equals("")){
            checkEmpty = true;
            firstNumberString = "First line is empty";
        }
        try{
            int firstNumber = Integer.parseInt(firstNumberString);
        }
        catch (NumberFormatException err){
            if (!checkEmpty) {
                System.out.println(firstNumberString + " is not a number");
                checkFirstLine = false;
            }
            else {
                checkFirstLine = false;
            }
        }

        return checkFirstLine;
    }
}



