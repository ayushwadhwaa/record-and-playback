public class MouseMovedData extends EventData{
    int x , y;
    MouseMovedData(int x, int y, long duration){
        this.x = x;
        this.y = y;
        this.duration = duration;
    }
}