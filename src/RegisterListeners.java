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
	private LinkedList<EventData> list = new LinkedList<EventData>();
	public void nativeKeyPressed(NativeKeyEvent e) {
		lock.lock();
		list.add(new KeyPressedData(NativeKeyEvent.getKeyText(e.getKeyCode()),System.currentTimeMillis()));
		lock.unlock();
	}
	public void nativeKeyReleased(NativeKeyEvent e) {
		lock.lock();
		list.add(new KeyReleasedData(NativeKeyEvent.getKeyText(e.getKeyCode()),System.currentTimeMillis()));
		lock.unlock();
	}
	public void nativeKeyTyped(NativeKeyEvent e) {	
    }
    public void nativeMouseClicked(NativeMouseEvent e) {
	}
	public void nativeMousePressed(NativeMouseEvent e) {
		lock.lock();
		list.add(new MousePressedData(e.getButton(),System.currentTimeMillis()));
		lock.unlock();
	}
	public void nativeMouseReleased(NativeMouseEvent e) {   
		lock.lock();
		list.add(new MouseReleasedData(e.getButton(),System.currentTimeMillis()));
		lock.unlock();
	}
	public void nativeMouseMoved(NativeMouseEvent e) {
		lock.lock();
		list.add(new MouseMovedData(e.getX(),e.getY(),System.currentTimeMillis()));
		lock.unlock();
	}
	public void nativeMouseDragged(NativeMouseEvent e) {
		lock.lock();
		list.add(new MouseDraggedData(e.getX(),e.getY(),System.currentTimeMillis()));
		lock.unlock();
    }
    public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
		lock.lock();
		list.add(new MouseWheelMovedData(e.getWheelRotation(),System.currentTimeMillis()));
		lock.unlock();
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
		RegisterListeners obj = new RegisterListeners();
        GlobalScreen.addNativeKeyListener(obj);
        GlobalScreen.addNativeMouseListener(obj);
        GlobalScreen.addNativeMouseMotionListener(obj);
		GlobalScreen.addNativeMouseWheelListener(obj);
	}
}