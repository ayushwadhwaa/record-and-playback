package EventData;
public class MouseReleasedData extends EventData{
    public int button;
    public long duration;
    public MouseReleasedData(int button, long duration){
        this.button = button;
        this.duration = duration;
    }
    public String getData(){
        return ("MouseReleased "+button+" "+duration);
    }
}