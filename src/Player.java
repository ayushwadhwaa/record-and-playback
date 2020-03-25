import java.awt.Robot;
import java.io.File;
import java.io.FileReader;
import java.awt.event.KeyEvent;
public class Player implements Runnable{
    private FileReader reader = null;
    private Robot robot;
    private  StringBuilder stringBuilder= new StringBuilder() ;
    private String filePath;
    private File tempFile = null;
    Player(String filePath){
        this.filePath = filePath;
    }
    public void run(){
        try{
            tempFile = new File(filePath);
            reader = new FileReader(tempFile);
            if(tempFile.exists()){
                int ch;
                while((ch = reader.read() )!= -1){
                    stringBuilder.append((char)ch);
                }
            }
            String str = stringBuilder.toString();
            String events[] = str.split("\n");
            String event[];
            robot = new Robot();
            long follow;
            long current=0;
            String vk;
            for(int i=0; i<events.length; i++){
                Thread.sleep(current);
                event = events[i].split(" ");
                if(event[1].equals("KeyPressed")){
                    vk = "VK_"+event[2].toUpperCase();
                    robot.keyPress(KeyEvent.vk);
                }else if(event[i].equals("KeyReleased")){

                }else if(event[i].equals("MouseMoved")){

                }else if(event[i].equals("MousePressed")){

                }else if(event[i].equals("MouseReleased")){

                }else if(event[i].equals("MouseDragged")){

                }else if(event[i].equals("MouseWheelMoved")){

                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}