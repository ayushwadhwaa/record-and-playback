public class MouseReleasedData extends EventData{
    int button;
    MouseReleasedData(int button, long duration){
        this.button = button;
        this.duration = duration;
    }
}