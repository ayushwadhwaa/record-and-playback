package EventData;
public class MouseReleasedData extends EventData{
    public int button;
    public MouseReleasedData(int button, long duration){
        this.button = button;
        this.duration = duration;
    }
}