package t3_swing;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class T01_Basic extends JFrame {
	public T01_Basic() {
		super("스윙 연습");
		designView();
	}
	
	private void designView() {
	setBounds(500, 350, 400, 350);
	
	JButton btnExit = new JButton("종료");
	add(btnExit);
	
	setVisible(true);

//------------------- 위쪽은 사용자 인터페이스(UI), 아래쪽은 method(동작) 처리 --------------------
	
	// 종료버튼 클릭 시 수행
	btnExit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});

	// 종료버튼
	
	}

	public static void main(String[] args) {
		new T01_Basic();
	}
}
