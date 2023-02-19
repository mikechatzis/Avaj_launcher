public class AircraftFactory {
    public Flyable newAircraftType(String type,
                                   String name,
                                   int Lo,
                                   int La,
                                   int H) {
        switch (type) {
            case "Baloon":
                return Baloon.createBaloon(name, Coordinates.createCoordinates(Lo, La, H));
            case "JetPlane":
                return JetPlane.createJetPlane(name, Coordinates.createCoordinates(Lo, La, H));
            case "Helicopter":
                return Helicopter.createHelicopter(name, Coordinates.createCoordinates(Lo, La, H));
            default:
                return null;
            
        }
    }
}
