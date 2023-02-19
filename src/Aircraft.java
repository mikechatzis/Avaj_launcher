import java.util.concurrent.atomic.AtomicInteger;

public class Aircraft {

    protected long    id;
    protected String  name;
    protected Coordinates coordinates;

    protected Aircraft(String name, Coordinates coordinates){
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    
    private long nextId() {
        return idCounter.incrementAndGet();
    }
}