public class KeyReleasedData extends EventData{
    String keyText;
    KeyReleasedData(String keyText, long duration){
        this.keyText = keyText;
        this.duration = duration;
    }
}