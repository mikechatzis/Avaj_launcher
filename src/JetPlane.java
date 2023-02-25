public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower T;
    private JetPlane(String name, Coordinates C) throws Exception {
        super(name, C);
    }

    @Override
    public void updateConditions() throws Exception {
        String w = this.T.getWeather(coordinates);
        switch (w) {
            case "SUN":
                this.coordinates.setCoordinates(this.coordinates.getLongitude(),
                                                this.coordinates.getLatitude() + 10,
                                                this.coordinates.getHeight() + 2);
                System.out.printf("Jetplane#%s(%d) says: destination fire disk, GO!\n", this.name, this.id);
                break;
            case "FOG":
                this.coordinates.setCoordinates(this.coordinates.getLongitude(),
                                                this.coordinates.getLatitude() + 1,
                                                this.coordinates.getHeight());
                System.out.printf("Jetplane#%s(%d) says: I can't see my turbines\n", this.name, this.id);
                break;
            case "SNOW":
                this.coordinates.setCoordinates(this.coordinates.getLongitude(),
                                                this.coordinates.getLatitude(),
                                                this.coordinates.getHeight() - 7);
                System.out.printf("Jetplane#%s(%d) says: So white, it's racist\n", this.name, this.id);
                break;
            case "RAIN":
                this.coordinates.setCoordinates(this.coordinates.getLongitude(),
                                                this.coordinates.getLatitude() + 5,
                                                this.coordinates.getHeight());
                System.out.printf("Jetplane#%s(%d) says: It's raining men, halleluja\n", this.name, this.id);
                break;
            default:
                throw new customException("Weather conditions not recognised");
        }

    }

    @Override
    public void registerTower(WeatherTower T) throws Exception {
        if (T == null)
            throw new customException("Tower must be a valid object");
        this.T = T;
        this.T.register(this);
        System.out.printf("JetPlane#%s(%d) registered to Weather Tower\n", this.name, this.id);
    }

    public void unresterTower() {
        this.T.unregister(this);
        this.T = null;
        System.out.printf("JetPlane#%s(%d) unregistered from Weather Tower\n", this.name, this.id);
    }

    public static JetPlane createJetPlane(String name, Coordinates C) throws Exception {
        return new JetPlane(name, C);
    }
}
