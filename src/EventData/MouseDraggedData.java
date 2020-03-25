package EventData;
public class MouseDraggedData extends EventData{
    public int x , y;
    public long duration;
    public MouseDraggedData(int x, int y, long duration){
        this.x = x;
        this.y = y;
        this.duration = duration;
    }
    public String getData(){
        return ("MouseDragged "+x+" "+y+" "+duration);
    }
}