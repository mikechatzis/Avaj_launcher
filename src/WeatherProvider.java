import java.util.ArrayList;
import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider Wp;
    private static final String weather[] = {"FOG", "SUN", "RAIN", "SNOW"};
    private static ArrayList< WeatherAtCoordinates > WaC = new ArrayList<WeatherAtCoordinates>();

    private WeatherProvider(){}

    public static WeatherProvider getProvider(){
        if (Wp == null)
            Wp = new WeatherProvider();
        return Wp;
    }

    public static String getCurrentWeather(Coordinates C) {
        for (int i = 0; i < WaC.size(); ++i) {
            int Co[] = WaC.get(i).getCoordinates();
            if (C.getLongitude() == Co[0] && C.getLatitude() == Co[1] && C.getHeight() == Co[2])
                return WaC.get(i).getWeather();
        }
        final Random rand = new Random();
        String curWeather = weather[rand.nextInt(4)];
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

    WeatherAtCoordinates(int Lo, int La, int H, String w) {
        this.weather = w;
        this.H = H; this.La = La; this.Lo = Lo;
    }

    int[] getCoordinates() {
        int C[] = {Lo, La, H};
        return C;
    }

    String getWeather() {
        return this.weather;
    }
}
