package EventData;
public class MousePressedData extends EventData{
    public int button;
    public long duration;
    public MousePressedData(int button, long duration){
        this.button = button;
        this.duration = duration;
    }
    public String getData(){
        return ("MousePressed "+button+" "+duration);
    }
}