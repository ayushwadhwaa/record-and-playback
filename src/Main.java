import EventData.*;
import java.util.LinkedList;
public class Main implements Runnable{
    private LinkedList<EventData> list = new LinkedList<>();
    RegisterListeners register;Thread thread;
    
    public void saveFile(){
        
        register.unRegister();
        System.out.println(list.size());
        
        
    }
    public void run(){
        try{
            register = new RegisterListeners(list);
             thread = new Thread(register);
            thread.start();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}