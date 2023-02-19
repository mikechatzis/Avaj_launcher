public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower T;
    private Helicopter(String name, Coordinates C) {
        super(name, C);
    }

    public void updateConditions() {
        String w = this.T.getWeather(coordinates);
        switch (w) {
            case "SUN":
                System.out.println("Helicopter says: destination fire disk, GO!");
            case "FOG":
                System.out.println("Helicopter says: I can't see my rotors");
            case "SNOW":
                System.out.println("Helicopter says: So white, it's racist");
            case "RAIN":
                System.out.println("Helicopter says: It's raining men, halleluja");
        }
    }

    public void registerTower(WeatherTower T) {
        this.T = T;
    }

    public static Helicopter createHelicopter(String name, Coordinates C) {
        return new Helicopter(name, C);
    }
}
