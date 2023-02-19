import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();
    protected WeatherProvider Wp = WeatherProvider.getProvider();

    protected void conditionsChanged() {
        Wp = WeatherProvider.getProvider();
    }

    public void register(Flyable F) {
        observers.add(F);
    }

    public void unregister(Flyable F) {
        observers.remove(F);
    }

}
