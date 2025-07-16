package t2_AWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T02_2 extends Frame implements WindowListener, ActionListener {
	public T02_2() {
		setTitle("AWT 프레임");
//		setSize(300, 250); // 크기: 픽셀단위
		setBounds(500, 300, 400, 350);

		Label lblTitle = new Label("레이블 테스트");
		add(lblTitle);
		Button btnExit = new Button("Exit");
//		btnAction.setLabel("Action");
		add(btnExit);
		
		addWindowListener(this);
		btnExit.addActionListener(this);
		
		setVisible(true);
		
//		------------------- 위쪽은 사용자 인터페이스(UI), 아래쪽은 method(동작) 처리 --------------------
	}
	
	public static void main(String[] args) {
		new T02_2();
	}

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
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
