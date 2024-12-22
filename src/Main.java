import java.util.Formatter;

public class Main {
    public static void main(String[] args) {
        WayFinder wayFinder = new WayFinder();
        if (args.length > 0) {
            wayFinder.setFileName(args[0]);
        } else {
            wayFinder.setFileName("map1");
            System.out.println("Please provide a file name as a command-line argument.");
        }
        wayFinder.findBestWay();
        Formatter f = null;
        try {
            f = new Formatter("solution.txt");
            f.format(wayFinder.getResult());
        } catch (Exception e) {
            System.err.println("Something went wrong.");
        } finally {
            if (f != null) {
                f.close();
            }
        }
    }
}