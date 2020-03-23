public class Main{
    public static void main(String args[]){
        try{
            new Thread(new RegisterListeners()).start();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}