public class Baloon extends Aircraft implements Flyable {
    private WeatherTower T;
    private Baloon(String name, Coordinates C) throws Exception {
        super(name, C);
    }

    @Override
    public void updateConditions() throws Exception {
        String w = this.T.getWeather(coordinates);
        switch (w) {
            case "SUN":
                this.coordinates.setCoordinates(this.coordinates.getLongitude() + 2,
                                                this.coordinates.getLatitude(),
                                                this.coordinates.getHeight() + 4);
                System.out.printf("Baloon#%s(%d) says: destination fire disk, GO!\n", this.name, this.id);
                break;
            case "RAIN":
                this.coordinates.setCoordinates(this.coordinates.getLongitude(),
                                                this.coordinates.getLatitude(),
                                                this.coordinates.getHeight() - 5);
                System.out.printf("Baloon#%s(%d) says: It's raining men, halleluja\n", this.name, this.id);
                break;
            case "FOG":
                this.coordinates.setCoordinates(this.coordinates.getLongitude(),
                                                this.coordinates.getLatitude(),
                                                this.coordinates.getHeight() - 3);
                System.out.printf("Baloon#%s(%d) says: I can't see my curves\n", this.name, this.id);
                break;
            case "SNOW":
                this.coordinates.setCoordinates(this.coordinates.getLongitude(),
                                                this.coordinates.getLatitude(),
                                                this.coordinates.getHeight() - 15);
                System.out.printf("Baloon#%s(%d) says: So white, it's racist\n", this.name, this.id);
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
        System.out.printf("Baloon#%s(%d) registered to Weather Tower\n", this.name, this.id);
    }

    public void unresterTower() {
        this.T.unregister(this);
        this.T = null;
        System.out.printf("Baloon#%s(%d) unregistered from Weather Tower\n", this.name, this.id);
    }

    public static Baloon createBaloon(String name, Coordinates C) throws Exception {
        return new Baloon(name, C);
    }
}