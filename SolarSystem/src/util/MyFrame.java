package util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


//将公共的方法和属性包装成一个父类，方便子类继承

public class MyFrame extends Frame {
	
 	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		setLocation(100, 100);
		setVisible(true);
		
		
		new PaintThread().start();   //自动重画线程
		addWindowListener(new WindowAdapter() {

			@Override
				public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
	
	class PaintThread extends Thread{
			
			public void run() {
				while(true) {
					repaint();
					try {
						Thread.sleep(50);		//休息50ms
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}
	}
}
