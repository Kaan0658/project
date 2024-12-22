import java.util.Formatter;

public class WayFinder {
    String fileName;
    CountryMap countryMap;
    FileArrayHandler fileArrayHandler;
    public static String Result;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void findBestWay() {
        fileArrayHandler = new FileArrayHandler(getFileName());
        fileArrayHandler.readFile();
        //CountryMap gets FileArrayHandler array
        countryMap = new CountryMap(fileArrayHandler.getFileArray(), fileArrayHandler.getCountSize()
                , fileName);
        //City gets FileArrayHandler array
        //countryMap.createRoutes();
        if (countryMap.checkMapFormat()) {
            String calculation = "";
            String[] citiesPath = new String[30];
            int count = 0;
            //"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
            for (int i = 3; i <= fileArrayHandler.getFileArray().length - 2; i++) {
                int arrayIndexFromThree = i;
                String handler = fileArrayHandler.getFileArray()[arrayIndexFromThree];
                String[] control = handler.split(" ");
                String firstPath = control[0];
                String secondPath = control[1];
                int costNumber = Integer.parseInt(control[2]);
                boolean flag = true;
                if (count != 0) {
                    for (int j = 0; j < count; j++) {
                        String[] path = citiesPath[j].split(" ");
                        if (path[2].equals(control[0])) {
                            int newCostNumber = Integer.parseInt(path[path.length - 1]) + costNumber;
                            calculation = path[0] + " " + path[1] + " " + control[0] + " " + control[1] + " " + newCostNumber;
                            citiesPath[i - 3] = calculation;
                            flag = false;
                            i = i + 1;
                        } else if (path[1].equals(control[0])) {
                            int newCostNumber = Integer.parseInt(path[path.length - 1]) + costNumber;
                            calculation = path[0] + " " + control[0] + " " + control[1] + " " + newCostNumber;
                            citiesPath[i - 3] = calculation;
                            flag = false;
                            break;
                        }
                    }
                }
                count++;
                if (flag) {
                    calculation = firstPath + " " + secondPath + " " + costNumber;
                    citiesPath[i - 3] = calculation;
                }
            }
            //"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""

            //Below is Works!!

            String solutionPath = fileArrayHandler.getFileArray()[fileArrayHandler.getFileArray().length - 1];
            String[] solutionPaths = solutionPath.split(" ");
            String[] answers = new String[30];
            for (int j = 0; j < citiesPath.length; j++) {
                if (citiesPath[j] != null) {
                    String[] path = citiesPath[j].split(" ");
                    if (path[0].equals(solutionPaths[0]) && path[path.length - 2].equals(solutionPaths[1])) {
                        answers[j] = citiesPath[j];
                    }
                }
            }

            int countHolder = 0;
            for (int a = 0; a < answers.length; a++) {
                if (answers[a] != null) {
                    countHolder++;
                }
            }
            String[] finalArrayAnswer = new String[countHolder];
            int countA = 0;
            for (int b = 0; b < answers.length; b++) {
                if (answers[b] != null) {
                    finalArrayAnswer[countA] = answers[b];
                    countA++;
                }
            }
            System.out.println("\nPotantionel Routes: ");
            for (String a : finalArrayAnswer) {
                System.out.println(a);
            }
            String result = "";

            int cost = Integer.MAX_VALUE;

            for (int k = 0; k < finalArrayAnswer.length; k++) {
                String[] holder = finalArrayAnswer[k].split(" ");
                int newCost = Integer.parseInt(holder[holder.length - 1]);
                if (newCost < cost) {
                    result = finalArrayAnswer[k];
                    cost = newCost;
                }
            }

            System.out.println("\nSolution path :");
            System.out.println(result);
            Result = result;
        } else {
            System.out.println("\nTxt format is wrong program is terminating !!!");
        }
    }
    public String getResult(){
        return Result;
    }
}