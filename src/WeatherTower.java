import java.util.Random;

public class WeatherTower extends Tower {
    
    public String getWeather(Coordinates C) {
        Random rand = new Random();
        int r = rand.nextInt(25);
        if(r == 4)
            changeWeather();
        return WeatherProvider.getCurrentWeather(C);
    }

    private void changeWeather() {
        WeatherProvider.changeWeather();
        this.conditionsChanged();
    }
}
