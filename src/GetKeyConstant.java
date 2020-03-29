import java.io.File;
import java.io.FileReader;
public class GetKeyConstant {
    private FileReader reader;
    private File tempFile;
    private StringBuilder stringBuilder = new StringBuilder();
    private String logs;
    GetKeyConstant(){
        try{
            tempFile = new File("constants//KeyEventConstants.log");
            reader = new FileReader(tempFile);
            int ch;
            while((ch = reader.read() )!= -1){
                stringBuilder.append((char)ch);
            }
            logs = stringBuilder.toString();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public Integer getConstant(String str){
        String search = "VK_";
        search += str;
        if(logs.contains(search)){
            int beginIndex = logs.indexOf(search)+search.length()+1;
            int endIndex = logs.indexOf("\n", beginIndex);
            return (Integer.parseInt(logs.subSequence(beginIndex, endIndex-1).toString()));
        } else{
            return -1;
        }
    }
}