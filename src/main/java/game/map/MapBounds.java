package game.map;

public class MapBounds {
    private final float width;
    private final float height;
    private final float minX;
    private final float maxX;
    private final float minY;
    private final float maxY;

    public MapBounds(float width, float height){
        this.width = width;
        this.maxX = width/2f;
        this.minX = -maxX;
        this.height = height;
        this.maxY = height/2f;
        this.minY = -maxY;
    }
    public float getMinX(){
        return this.minX;
    }
    public float getMaxX(){
        return this.maxX;
    }
    public float getMinY(){
        return this.minY;
    }
    public float getMaxY(){
        return this.maxY;
    }

    public boolean isWithinBounds(float x, float y){
        return x > minX && x < maxX && y > minY && y < maxY;
    }
}
