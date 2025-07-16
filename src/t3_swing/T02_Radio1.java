package t3_swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class T02_Radio1 extends JFrame {
	public T02_Radio1() {
		super("스윙 연습");
		designView();
	}
	
	private void designView() {
	setSize(400, 350);
	setLocationRelativeTo(null); // 윈도우 화면 중앙에 배치
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 닫기 버튼을 클릭해서 창닫기
	setResizable(false); // 윈도우 창 크기 고정
	
	setLayout(new FlowLayout());
	JPanel pn1 = new JPanel();
	JPanel pn2 = new JPanel();
	
	pn1.setBackground(Color.BLUE);
	pn2.setBackground(Color.GREEN);
	
	JLabel lbl = new JLabel();
	lbl.setText("스윙 연습하기");
	pn1.add(lbl);
	
	JButton btnExit = new JButton("종료");
	pn2.add(btnExit);
	
	setVisible(true);

//------------------- 위쪽은 사용자 인터페이스(UI), 아래쪽은 method(동작) 처리 --------------------
	
	// 종료버튼 클릭 시 수행
	btnExit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	
	}

	public static void main(String[] args) {
		new T02_Radio1();
	}
}
