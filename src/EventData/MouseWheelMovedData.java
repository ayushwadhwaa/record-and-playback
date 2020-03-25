package EventData;
public class MouseWheelMovedData extends EventData{
    public int rotation;
    public long duration;
    public MouseWheelMovedData(int rotation, long duration){
        this.rotation = rotation;
        this.duration = duration;
    }
    public String getData(){
        return ("MouseWheelMoved "+rotation+" "+duration);
    }
}