import java.util.Random;

public class WeatherTower extends Tower {
    
    public String getWeather(Coordinates C) {
        Random rand = new Random();
        boolean b = rand.nextBoolean();
        if(b)
            changeWeather();
        return Wp.getCurrentWeather(C);
    }

    private void changeWeather() {
        Wp = WeatherProvider.getProvider();
    }
}
