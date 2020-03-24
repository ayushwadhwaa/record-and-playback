package EventData;
public class MouseWheelMovedData extends EventData{
    public int rotation;
    public MouseWheelMovedData(int rotation, long duration){
        this.rotation = rotation;
        this.duration = duration;
    }
}