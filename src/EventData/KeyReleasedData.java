package EventData;
public class KeyReleasedData extends EventData{
    public String keyText;
    public KeyReleasedData(String keyText, long duration){
        this.keyText = keyText;
        this.duration = duration;
    }
}