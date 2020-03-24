public class MouseDraggedData extends EventData{
    int x , y;
    MouseDraggedData(int x, int y, long duration){
        this.x = x;
        this.y = y;
        this.duration = duration;
    }
}