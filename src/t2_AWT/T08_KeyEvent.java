package t2_AWT;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T08_KeyEvent extends Frame implements WindowListener, ActionListener, KeyListener {
	
	public T08_KeyEvent() {
		designView();
	}
	
	private void designView() {
		setTitle("키 이벤트 연습)");
		setBounds(500, 350, 400, 350);
		

		addKeyListener(this);
		addWindowListener(this);
		
		setVisible(true);
	}
	
//		------------------- 위쪽은 사용자 인터페이스(UI), 아래쪽은 method(동작) 처리 --------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("키보드 입력 중..");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("키보드를 누르고 있는 중입니다.");
		char keyCode = e.getKeyChar();
		System.out.println("입력된 키는? " + keyCode);
		
		if (keyCode == 'E') System.exit(0);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("키보드를 눌렀다가 놓습니다.");
	}

	public static void main(String[] args) {
		new T08_KeyEvent();
	}
}
