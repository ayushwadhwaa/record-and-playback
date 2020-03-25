package EventData;
public class MouseMovedData extends EventData{
    public int x , y;
    public long duration;
    public MouseMovedData(int x, int y, long duration){
        this.x = x;
        this.y = y;
        this.duration = duration;
    }
    public String getData(){
        return ("MouseMoved "+x+" "+y+" "+duration);
    }
}