import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;
public class RegisterListeners implements Runnable, NativeKeyListener, NativeMouseInputListener, NativeMouseWheelListener {
    private StringBuilder stringBuilder = new StringBuilder();
	public void nativeKeyPressed(NativeKeyEvent e) {
        stringBuilder.append("Key Pressed: "+NativeKeyEvent.getKeyText(e.getKeyCode())+"\n");
	}
	public void nativeKeyReleased(NativeKeyEvent e) {
        stringBuilder.append("Key Released: "+NativeKeyEvent.getKeyText(e.getKeyCode())+"\n");
	}
	public void nativeKeyTyped(NativeKeyEvent e) {	
    }
    public void nativeMouseClicked(NativeMouseEvent e) {
	}
	public void nativeMousePressed(NativeMouseEvent e) {
        stringBuilder.append("Mouse Pressed: "+e.getButton()+"\n");
	}
	public void nativeMouseReleased(NativeMouseEvent e) {   
        stringBuilder.append("Mouse Released: "+e.getButton()+"\n");
	}
	public void nativeMouseMoved(NativeMouseEvent e) {
        stringBuilder.append("Mouse Moved: " + e.getX() + ", " + e.getY()+"\n");
	}
	public void nativeMouseDragged(NativeMouseEvent e) {
        stringBuilder.append("Mouse Dragged: " + e.getX() + ", " + e.getY()+"\n");
    }
    public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
        stringBuilder.append("Mosue Wheel Moved: " + e.getWheelRotation()+"\n");
	}

	public void run() {
		try {
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
            logger.setUseParentHandlers(false);
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());
			System.exit(1);
		}
        RegisterListeners example = new RegisterListeners();
        GlobalScreen.addNativeKeyListener(example);
        GlobalScreen.addNativeMouseListener(example);
        GlobalScreen.addNativeMouseMotionListener(example);
		GlobalScreen.addNativeMouseWheelListener(example);
	}
}