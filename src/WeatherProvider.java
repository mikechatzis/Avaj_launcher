import java.util.ArrayList;
import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider Wp;
    private final String weather[] = {"FOG", "SUN", "RAIN", "SNOW"};
    private ArrayList< WeatherAtCoordinates > WaC = new ArrayList<WeatherAtCoordinates>();

    private WeatherProvider(){}

    public static WeatherProvider getProvider(){
        final Random r = new Random();
        boolean b = r.nextBoolean();
        if (Wp == null || b)
            Wp = new WeatherProvider();
        return Wp;
    }

    public String getCurrentWeather(Coordinates C) {
        for (int i = 0; i < WaC.size(); ++i) {
            int Co[] = WaC.get(i).getCoordinates();
            if (C.getLongitude() == Co[0] && C.getLatitude() == Co[1] && C.getHeight() == Co[2])
                return WaC.get(i).getWeather();
        }
        final Random rand = new Random();
        String curWeather = this.weather[rand.nextInt(4)];
        WaC.add(new WeatherAtCoordinates(C.getLongitude(),
                                         C.getLatitude(),
                                         C.getHeight(),
                                         curWeather));
        return curWeather;
    }
}

class WeatherAtCoordinates {
    private String weather;
    private int Lo, La, H;

    public WeatherAtCoordinates(int Lo, int La, int H, String w) {
        this.weather = w;
        this.H = H; this.La = La; this.Lo = Lo;
    }

    public int[] getCoordinates() {
        int C[] = {Lo, La, H};
        return C;
    }

    public String getWeather() {
        return this.weather;
    }
}
