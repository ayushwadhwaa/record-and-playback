package EventData;
public class KeyReleasedData extends EventData{
    public String keyText;
    public long duration;
    public KeyReleasedData(String keyText, long duration){
        this.keyText = keyText;
        this.duration = duration;
    }
    public String getData(){
        return ("KeyReleased "+keyText+" "+duration);
    }
}