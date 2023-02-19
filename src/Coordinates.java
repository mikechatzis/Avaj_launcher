public class Coordinates {
    
    private int longitude, latitude, height;

    private Coordinates(int longitude, int latitude, int height) {
            this.longitude = longitude;
            this.latitude = latitude;
            this.height = height;
        }
    
    public int getLongitude(){
        return this.longitude;
    }

    public int getLatitude(){
        return this.latitude;
    }

    public int getHeight(){
        return this.height;
    }

    public static Coordinates createCoordinates(int Lo, int La, int H) {
        return new Coordinates(Lo, La, H);
    }
}
