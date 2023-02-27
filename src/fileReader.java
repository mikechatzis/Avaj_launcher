import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Vector;

public class fileReader {
    private Vector<String> lines = new Vector<String>();
    private Vector<Flyable> aircrafts = new Vector<Flyable>();
    private WeatherTower T = new WeatherTower();
    fileWriter W =  new fileWriter();

    public fileReader(String filePath) throws Exception {
        final File scenario = new File(filePath);
        final Scanner reader = new Scanner(scenario);
        while (reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }
        reader.close();
    }

    public void createAircrafts() throws Exception {
        for (int i = 1; i < this.lines.size(); ++i) {
            String[] split = this.lines.elementAt(i).split(" ");
            switch (split[0]) {
                default:
                    throw new customException(String.format("unrecognised aircaft type at line: %d", i));
                case "Baloon":
                    aircrafts.add(Baloon.createBaloon(split[1], Coordinates.createCoordinates(Integer.parseInt(split[2]),
                                                                                              Integer.parseInt(split[3]),
                                                                                              Integer.parseInt(split[4]))));
                    aircrafts.elementAt(i - 1).registerTower(T);
                    break;
                case "Helicopter":
                    aircrafts.add(Helicopter.createHelicopter(split[1], Coordinates.createCoordinates(Integer.parseInt(split[2]),
                                                                                              Integer.parseInt(split[3]),
                                                                                              Integer.parseInt(split[4]))));
                    aircrafts.elementAt(i - 1).registerTower(T);
                    break;
                case "JetPlane":
                    aircrafts.add(JetPlane.createJetPlane(split[1], Coordinates.createCoordinates(Integer.parseInt(split[2]),
                                                                                              Integer.parseInt(split[3]),
                                                                                              Integer.parseInt(split[4]))));
                    aircrafts.elementAt(i - 1).registerTower(T);
                    break;
            }
        }
    }

    public void scenarioLoop() throws Exception {
        for (int i = 0; i < Integer.parseInt(lines.elementAt(0)); ++i) {
            for (int j = 0; j < aircrafts.size(); ++j) {
                aircrafts.elementAt(j).updateConditions();
                if (aircrafts.elementAt(j).getAircraftHeight() <= 0) {
                    aircrafts.removeElementAt(j);
                    --j;
                }
            }
        }
    }
}
