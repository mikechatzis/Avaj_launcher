public interface Flyable {
    public void updateConditions() throws Exception;
    public void registerTower(WeatherTower T) throws Exception;
    public int getAircraftHeight() throws Exception;
}
