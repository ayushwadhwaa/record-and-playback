package EventData;
public class MousePressedData extends EventData{
    public int button;
    public MousePressedData(int button, long duration){
        this.button = button;
        this.duration = duration;
    }
}