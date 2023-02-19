public class App {
    public static void main(String[] args) throws Exception {
        Coordinates C = Coordinates.createCoordinates(10, 11, 12);
        Aircraft b747 = new Aircraft("747", C);
        Aircraft b757 = new Aircraft("757", Coordinates.createCoordinates(4,5,6));
        System.out.printf("Hello, World! this is: %s, %d and %s, %d\n", b747.name, b747.id, b757.name, b757.id);
    }
}
