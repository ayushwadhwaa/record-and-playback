import java.io.File;
import java.io.FileReader;
public class GetKeyConstant{
    private FileReader fr;
    private File tempFile;
    GetKeyConstant(){
        try{
            tempFile = new File("constants//KeyjventConstants.log");
            fr = new FileReader(tempFile);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    static int getConstant(String str){
        return 0;
    }
}