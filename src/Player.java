import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileReader;
public class Player implements Runnable{
    private FileReader reader = null;
    private Robot robot;
    private  StringBuilder stringBuilder= new StringBuilder() ;
    private String filePath;
    private File tempFile = null;
    private GetKeyConstant obj = new GetKeyConstant();
    public void run(){
        try{
            tempFile = new File(events.log);
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
            /*long follow;
            long current=0;
            String vk;*/
            for(int i=0; i<events.length; i++){
                Thread.sleep(500);
                event = events[i].split(" ");
                if(event[0].equals("KeyPressed")){
                    //vk = "VK_"+event[1].toUpperCase();
                    robot.keyPress(obj.getConstant(event[2].toUpperCase()));
                }else if(event[0].equals("KeyReleased")){
                    robot.keyRelease(obj.getConstant(event[1].toUpperCase()));
                }else if(event[0].equals("MouseMoved")){
                    robot.mouseMove(Integer.parseInt(event[1]), Integer.parseInt(event[2]));
                }else if(event[0].equals("MousePressed")){
                    robot.mousePress(Integer.parseInt(event[1]));
                    if(Integer.parseInt(event[1])==1){
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    }else if(Integer.parseInt(event[1])==2){
                        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                    }else if(Integer.parseInt(event[1])==3){
                        robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                    }
                }else if(event[0].equals("MouseReleased")){
                    robot.mouseRelease(Integer.parseInt(event[1]));
                }else if(event[0].equals("MouseDragged")){

                }else if(event[0].equals("MouseWheelMoved")){

                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}