
public class App {
    public static void main(String[] args) throws Exception {
        try {
            if (args.length != 1)
                throw new customException("wrong number of arguments. Format: 'avaj_launcher <path_to_scenario>'");
            fileReader R = new fileReader(args[0]);
            R.createAircrafts();
            R.scenarioLoop();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
