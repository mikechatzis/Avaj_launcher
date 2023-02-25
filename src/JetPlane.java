public class JetPlane extends Aircraft implements Flyable {
    private JetPlane(String name, Coordinates C) throws Exception {
        super(name, C);
    }

    @Override
    public void updateConditions() throws Exception {
        String w = T.getWeather(coordinates);
        switch (w) {
            case "SUN":
                this.coordinates.setCoordinates(this.coordinates.getLongitude(),
                                                this.coordinates.getLatitude() + 10,
                                                this.coordinates.getHeight() + 2);
                fileWriter.printWriter.printf("Jetplane#%s(%d) says: destination fire disk, GO!\n", this.name, this.id);
                break;
            case "FOG":
                this.coordinates.setCoordinates(this.coordinates.getLongitude(),
                                                this.coordinates.getLatitude() + 1,
                                                this.coordinates.getHeight());
                fileWriter.printWriter.printf("Jetplane#%s(%d) says: I can't see my turbines\n", this.name, this.id);
                break;
            case "SNOW":
                this.coordinates.setCoordinates(this.coordinates.getLongitude(),
                                                this.coordinates.getLatitude(),
                                                this.coordinates.getHeight() - 7);
                fileWriter.printWriter.printf("Jetplane#%s(%d) says: So white, it's racist\n", this.name, this.id);
                break;
            case "RAIN":
                this.coordinates.setCoordinates(this.coordinates.getLongitude(),
                                                this.coordinates.getLatitude() + 5,
                                                this.coordinates.getHeight());
                fileWriter.printWriter.printf("Jetplane#%s(%d) says: It's raining men, halleluja\n", this.name, this.id);
                break;
            default:
                throw new customException("Weather conditions not recognised");
        }
        if (coordinates.getHeight() > 100)
            coordinates.setCoordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
        if (coordinates.getLongitude() < 0)
            coordinates.setCoordinates(0, coordinates.getLatitude(), coordinates.getHeight());
        if (coordinates.getLatitude() < 0)
            coordinates.setCoordinates(coordinates.getLongitude(), 0, coordinates.getHeight());
        if (coordinates.getHeight() <= 0) {
            fileWriter.printWriter.printf("JetPlane#%s(%d) landing at: : 'Longitude: %d, Latitude: %d'\n", this.name,
                                                                                                 this.id,
                                                                                                 this.coordinates.getLongitude(),
                                                                                                 this.coordinates.getLatitude());
            this.unregisterTower();
        }
    }

    @Override
    public void registerTower(WeatherTower T) throws Exception {
        if (T == null)
            throw new customException("Tower must be a valid object");
        Aircraft.T = T;
        T.register(this);
        fileWriter.printWriter.printf("Tower says: JetPlane#%s(%d) registered to Weather Tower\n", this.name, this.id);
    }

    @Override
    public int getAircraftHeight() throws Exception {
        return this.coordinates.getHeight();
    }

    public void unregisterTower() {
        T.unregister(this);
        fileWriter.printWriter.printf("Tower says: JetPlane#%s(%d) unregistered from Weather Tower\n", this.name, this.id);
    }

    public static JetPlane createJetPlane(String name, Coordinates C) throws Exception {
        return new JetPlane(name, C);
    }
}
