public class MouseWheelMovedData extends EventData{
    int rotation;
    MouseWheelMovedData(int rotation, long duration){
        this.rotation = rotation;
        this.duration = duration;
    }
}