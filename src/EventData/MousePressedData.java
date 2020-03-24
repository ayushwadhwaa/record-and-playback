public class MousePressedData extends EventData{
    int button;
    MousePressedData(int button, long duration){
        this.button = button;
        this.duration = duration;
    }
}