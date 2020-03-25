package EventData;
public class KeyPressedData extends EventData{
    public String keyText;
    public long duration;
    public KeyPressedData(String keyString, long duration){
        this.keyText = keyString;
        this.duration = duration;
    }
    public String getData(){
        return ("KeyPressed "+keyText+" "+duration);
    }
}