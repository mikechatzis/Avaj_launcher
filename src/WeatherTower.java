import java.util.Random;

public class WeatherTower extends Tower {
    
    public String getWeather(Coordinates C) {
        Random rand = new Random();
        boolean b = rand.nextBoolean();
        if(b)
            changeWeather();
        return WeatherProvider.getCurrentWeather(C);
    }

    private void changeWeather() {
        WeatherProvider.getProvider();
    }
}
