public class Baloon extends Aircraft implements Flyable {
    private WeatherTower T;
    private Baloon(String name, Coordinates C) {
        super(name, C);
    }

    public void updateConditions() {
        String w = this.T.getWeather(coordinates);
        switch (w) {
            case "SUN":
                System.out.println("Baloon says: destination fire disk, GO!");
            case "FOG":
                System.out.println("Baloon says: I can't see my rotors");
            case "SNOW":
                System.out.println("Baloon says: So white, it's racist");
            case "RAIN":
                System.out.println("Baloon says: It's raining men, halleluja");
        }
    }

    public void registerTower(WeatherTower T) {
        this.T = T;
    }

    public static Baloon createBaloon(String name, Coordinates C) {
        return new Baloon(name, C);
    }
}