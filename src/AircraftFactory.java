public class AircraftFactory {
    public Flyable newAircraftType(final String type,
                                   final String name,
                                   int Lo,
                                   int La,
                                   int H) throws Exception {

        Flyable F;
        switch (type) {
            case "Baloon":
                F =  Baloon.createBaloon(name, Coordinates.createCoordinates(Lo, La, H));
                break;
            case "JetPlane":
                F =  JetPlane.createJetPlane(name, Coordinates.createCoordinates(Lo, La, H));
                break;
            case "Helicopter":
                F =  Helicopter.createHelicopter(name, Coordinates.createCoordinates(Lo, La, H));
                break;
            default:
                F = null;
            }
            return F; 
    }
}
