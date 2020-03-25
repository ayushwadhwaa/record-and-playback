import java.awt.Robot;
import java.io.File;
import java.io.FileReader;
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
            robot = new Robot();
            for(int i=0; i<events.length; i++){

                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}