public class KeyPressedData extends EventData{
    String keyText;
    KeyPressedData(String keyString, long duration){
        this.keyText = keyString;
        this.duration = duration;
    }
}