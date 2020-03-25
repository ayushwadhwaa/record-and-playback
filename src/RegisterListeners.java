import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
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
import EventData.EventData;
import EventData.KeyPressedData;
import EventData.KeyReleasedData;
import EventData.MouseDraggedData;
import EventData.MouseMovedData;
import EventData.MousePressedData;
import EventData.MouseReleasedData;
import EventData.MouseWheelMovedData;
public class RegisterListeners implements Runnable, NativeKeyListener, NativeMouseInputListener, NativeMouseWheelListener {
	private ReentrantLock lock = new ReentrantLock();
	private LinkedList < EventData > mylist;
	public void nativeKeyPressed(NativeKeyEvent e) {
		if(e.getRawCode()==161){
			lock.lock();
                        mylist.add(new KeyPressedData("Shift",System.currentTimeMillis()));
			lock.unlock();
		}else if(!((e.getKeyText(e.getKeyCode())).equals("Undefined"))){
			lock.lock();
			mylist.add(new KeyPressedData(NativeKeyEvent.getKeyText(e.getKeyCode()), System.currentTimeMillis()));
			lock.unlock();
		}
	}
	public void nativeKeyReleased(NativeKeyEvent e) {
		if(e.getRawCode()==161){
			lock.lock();
                        mylist.add(new KeyReleasedData("Shift",System.currentTimeMillis()));
			lock.unlock();
		}else if(!((e.getKeyText(e.getKeyCode())).equals("Undefined"))){
			lock.lock();
			mylist.add(new KeyReleasedData(NativeKeyEvent.getKeyText(e.getKeyCode()), System.currentTimeMillis()));
			lock.unlock();
		}
	}
	public void nativeKeyTyped(NativeKeyEvent e) {}
	public void nativeMouseClicked(NativeMouseEvent e) {}
	public void nativeMousePressed(NativeMouseEvent e) {
		lock.lock();
		mylist.add(new MousePressedData(e.getButton(), System.currentTimeMillis()));
		lock.unlock();
	}
	public void nativeMouseReleased(NativeMouseEvent e) {
		lock.lock();
		mylist.add(new MouseReleasedData(e.getButton(), System.currentTimeMillis()));
		lock.unlock();
	}
	public void nativeMouseMoved(NativeMouseEvent e) {
		lock.lock();
		mylist.add(new MouseMovedData(e.getX(), e.getY(), System.currentTimeMillis()));
		lock.unlock();
	}
	public void nativeMouseDragged(NativeMouseEvent e) {
		lock.lock();
		mylist.add(new MouseDraggedData(e.getX(), e.getY(), System.currentTimeMillis()));
		lock.unlock();
	}
	public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
		lock.lock();
		mylist.add(new MouseWheelMovedData(e.getWheelRotation(), System.currentTimeMillis()));
		lock.unlock();
	}
	public void unRegister() {
		try {
			GlobalScreen.unregisterNativeHook();
		} catch (NativeHookException ex) {
		}
	}
	RegisterListeners(LinkedList < EventData > mylist) {
		this.mylist = mylist;
	}
	public void run() {
		try {
			Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
			logger.setLevel(Level.OFF);
			logger.setUseParentHandlers(false);
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());
			System.exit(1);
		}
		RegisterListeners obj = new RegisterListeners(mylist);
		GlobalScreen.addNativeKeyListener(obj);
		GlobalScreen.addNativeMouseListener(obj);
		GlobalScreen.addNativeMouseMotionListener(obj);
		GlobalScreen.addNativeMouseWheelListener(obj);
	}

}