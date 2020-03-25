import java.io.FileWriter;
import java.util.LinkedList;
import EventData.*;
public class CreateLogFile implements Runnable {
    private FileWriter fw;
    private LinkedList < EventData > list;
    private StringBuilder stringBuilder = new StringBuilder();
    private String eventName;
    private KeyPressedData keyPressed;;
    private KeyReleasedData keyReleased;;
    private MouseMovedData mouseMoved;;
    private MousePressedData mousePressed;;
    private MouseReleasedData mouseReleased;;
    private MouseDraggedData mouseDragged;
    private MouseWheelMovedData mouseWheelMoved;
    CreateLogFile(LinkedList < EventData > list) {
        this.list = list;
    }
    public void run() {
        try {
            fw = new FileWriter("events.log");
            for (int i = 0; i < list.size(); i++) {
                eventName = list.get(i).getClass().getSimpleName();
                if(eventName.equals("KeyPressedData")){
                    keyPressed = (KeyPressedData)list.get(i);
                    stringBuilder.append(keyPressed.getData());
                    stringBuilder.append("\n");
                }else if(eventName.equals("KeyReleasedData")){
                    keyReleased = (KeyReleasedData)list.get(i);
                    stringBuilder.append(keyReleased.getData());
                    stringBuilder.append("\n");
                }else if(eventName.equals("MouseMovedData")){
                    mouseMoved = (MouseMovedData)list.get(i);
                    stringBuilder.append(mouseMoved.getData());
                    stringBuilder.append("\n");
                }else if(eventName.equals("MousePressedData")){
                    mousePressed = (MousePressedData)list.get(i);
                    stringBuilder.append(mousePressed.getData());
                    stringBuilder.append("\n");
                }else if(eventName.equals("MouseReleasedData")){
                    mouseReleased = (MouseReleasedData)list.get(i);
                    stringBuilder.append(mouseReleased.getData());
                    stringBuilder.append("\n");
                }else if(eventName.equals("MouseDraggedData")){
                    mouseDragged = (MouseDraggedData)list.get(i);
                    stringBuilder.append(mouseDragged.getData());
                    stringBuilder.append("\n");
                }else if(eventName.equals("MouseWheelMovedData")){
                    mouseWheelMoved = (MouseWheelMovedData)list.get(i);
                    stringBuilder.append(mouseWheelMoved.getData());
                    stringBuilder.append("\n");
                }
            }
            fw = new FileWriter("events.log");
            fw.write(stringBuilder.toString());
        }catch(Exception e){   
        }
    }
}