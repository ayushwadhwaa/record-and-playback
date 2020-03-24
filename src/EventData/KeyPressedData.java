package EventData;
public class KeyPressedData extends EventData{
    public String keyText;
    public KeyPressedData(String keyString, long duration){
        this.keyText = keyString;
        this.duration = duration;
    }
}