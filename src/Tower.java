import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    protected void conditionsChanged() {
        fileWriter.printWriter.println("Tower says: Alert! To all aircrafts! Weather condition changed");
    }

    public void register(Flyable F) {
        observers.add(F);
    }

    public void unregister(Flyable F) {
        observers.remove(F);
    }

}
