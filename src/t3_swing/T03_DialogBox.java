package t3_swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class T03_DialogBox extends JFrame {
	public T03_DialogBox() {
		super("스윙 연습(메세지 연습)");
		designView();
	}
	
	private void designView() {
	setSize(400, 350);
	setLocationRelativeTo(null); // 윈도우 화면 중앙에 배치
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 닫기 버튼을 클릭해서 창닫기
	setResizable(false); // 윈도우 창 크기 고정
	
	setLayout(new GridLayout(2,1));
	
	JPanel pn1 = new JPanel();
	JPanel pn2 = new JPanel();
	
	pn1.setBackground(Color.GRAY);
	pn2.setBackground(Color.ORANGE);
	
	JButton btn1 = new JButton("경고");
	JButton btn2 = new JButton("입력");
	JButton btn3 = new JButton("종료");
	JButton btn4 = new JButton("종료(예/아니오)");
	JButton btn5 = new JButton("종료(예/아니오/취소)");
	
	pn1.add(btn1);
	pn1.add(btn2);
	pn1.add(btn3);
	pn1.add(btn4);
	pn1.add(btn5);

	JLabel lblMessage = new JLabel("메세지가 출력됩니다.");
	pn2.add(lblMessage);
	
	add(pn1);
	add(pn2);
	
	setVisible(true);

//------------------- 위쪽은 사용자 인터페이스(UI), 아래쪽은 method(동작) 처리 --------------------
	
	// 경고메세지 출력
	btn1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			lblMessage.setText("경고 버튼을 누르셨습니다.");
//			JOptionPane.showMessageDialog(null, lblMessage.getText());
			JOptionPane.showMessageDialog(null, lblMessage.getText(), "경고 메세지", JOptionPane.WARNING_MESSAGE);
		}
	});
	
	// 입력메세지 출력
	btn2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			lblMessage.setText("입력 버튼을 누르셨습니다.");
			String name = JOptionPane.showInputDialog(null, "성명을 입력하세요", "입력창", JOptionPane.DEFAULT_OPTION);
			if (name != null) lblMessage.setText("성명: " + name);
		}
	});
	
	// 예/아니오 출력
	btn4.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			lblMessage.setText("예/아니오 버튼을 누르셨습니다.");
			int ans = JOptionPane.showConfirmDialog(null, "작업을 계속 하시겠습니까?", "작업 종료창", JOptionPane.YES_NO_OPTION);
			if (ans == 0) {
				JOptionPane.showMessageDialog(null, "작업을 계속 진행합니다.");
			}
			else {
				JOptionPane.showMessageDialog(null, "작업을 마칩니다.");
				System.exit(0);
			}
		}
	});
	
	// 예/아니오/취소 출력
	btn5.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			lblMessage.setText("예/아니오/취소 버튼을 누르셨습니다.");
			int ans = JOptionPane.showConfirmDialog(null, "작업을 계속 하시겠습니까?", "작업 종료창", JOptionPane.YES_NO_CANCEL_OPTION);
			if (ans == 0) {
				JOptionPane.showMessageDialog(null, "작업을 계속 진행합니다.");
			}
			else if (ans == 1) {
				JOptionPane.showMessageDialog(null, "작업을 마칩니다.");
				System.exit(0);
			}
			else {
				JOptionPane.showMessageDialog(null, "작업을 취소합니다.");
				System.exit(0);
			}
		}
	});
	
	// 종료버튼 클릭 시 수행
	btn3.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	
	}

	public static void main(String[] args) {
		new T03_DialogBox();
	}
}
