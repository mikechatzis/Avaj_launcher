public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower T;
    private JetPlane(String name, Coordinates C) {
        super(name, C);
    }

    public void updateConditions() {
        String w = this.T.getWeather(coordinates);
        switch (w) {
            case "SUN":
                System.out.println("Jetplane says: destination fire disk, GO!");
            case "FOG":
                System.out.println("Jetplane says: I can't see my rotors");
            case "SNOW":
                System.out.println("Jetplane says: So white, it's racist");
            case "RAIN":
                System.out.println("Jetplane says: It's raining men, halleluja");
        }
    }

    public void registerTower(WeatherTower T) {
        this.T = T;
    }

    public static JetPlane createJetPlane(String name, Coordinates C) {
        return new JetPlane(name, C);
    }
}
