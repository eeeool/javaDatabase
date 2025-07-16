package t2_AWT;

import java.awt.Frame;

@SuppressWarnings("serial")
public class T01_2 extends Frame {
	public T01_2() {
		setTitle("AWT 프레임");
		setSize(300, 250); // 크기: 픽셀단위
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new T01_2();
	}
}
