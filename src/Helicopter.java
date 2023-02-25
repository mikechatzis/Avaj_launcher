public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower T;
    private Helicopter(String name, Coordinates C) throws Exception {
        super(name, C);
    }

    @Override
    public void updateConditions() throws Exception {
        String w = this.T.getWeather(coordinates);
        switch (w) {
            case "SUN":
                this.coordinates.setCoordinates(this.coordinates.getLongitude() + 10,
                                                this.coordinates.getLatitude(),
                                                this.coordinates.getHeight() + 2);
                System.out.printf("Helicopter %s %d says: destination fire disk, GO!\n", this.name, this.id);
                break;
            case "RAIN":
                this.coordinates.setCoordinates(this.coordinates.getLongitude() + 5,
                                                this.coordinates.getLatitude(),
                                                this.coordinates.getHeight());
                System.out.printf("Helicopter %s %d says: It's raining men, halleluja\n", this.name, this.id);
                break;
            case "FOG":
                this.coordinates.setCoordinates(this.coordinates.getLongitude() + 1,
                                                this.coordinates.getLatitude(),
                                                this.coordinates.getHeight());
                System.out.printf("Helicopter %s %d says: I can't see my rotors\n", this.name, this.id);
                break;
            case "SNOW":
                this.coordinates.setCoordinates(this.coordinates.getLongitude(),
                                                this.coordinates.getLatitude(),
                                                this.coordinates.getHeight() - 12);
                System.out.printf("Helicopter %s %d says: So white, it's racist\n", this.name, this.id);
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
        System.out.printf("Helicopter#%s(%d) registered to Weather Tower\n", this.name, this.id);
    }

    public void unresterTower() {
        this.T.unregister(this);
        this.T = null;
        System.out.printf("Helicopter#%s(%d) unregistered from Weather Tower\n", this.name, this.id);
    }

    public static Helicopter createHelicopter(String name, Coordinates C) throws Exception {
        return new Helicopter(name, C);
    }
}
