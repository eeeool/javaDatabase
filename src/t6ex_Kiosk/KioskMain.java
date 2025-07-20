package t6ex_Kiosk;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KioskMain {

	private JFrame frame;

	public static void main(String[] args) {
		new KioskMain();
	}

	public KioskMain() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("버거킹");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("BURGER KING");
		lblLogo.setForeground(Color.RED);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 28));
		lblLogo.setBounds(81, 26, 226, 48);
		frame.getContentPane().add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(KioskMain.class.getResource("")));
		lblNewLabel.setBounds(66, 80, 250, 389);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnMenuInput = new JButton("메뉴 등록 하기");
		btnMenuInput.setFont(new Font("굴림", Font.BOLD, 20));
		btnMenuInput.setBounds(427, 112, 220, 50);
		frame.getContentPane().add(btnMenuInput);
		
		JButton btnMenuOrder = new JButton("메뉴 주문 하기");
		
		btnMenuOrder.setFont(new Font("굴림", Font.BOLD, 20));
		btnMenuOrder.setBounds(427, 228, 220, 50);
		frame.getContentPane().add(btnMenuOrder);
		
		JButton btnOrderCheck = new JButton("주문 확인 하기");
	
	
		btnOrderCheck.setFont(new Font("굴림", Font.BOLD, 20));
		btnOrderCheck.setBounds(427, 335, 220, 50);
		frame.getContentPane().add(btnOrderCheck);
		
		JButton btnExit = new JButton("작 업 종 료");
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(427, 439, 220, 50);
		frame.getContentPane().add(btnExit);
		
		frame.setVisible(true);
		
//------------------------위쪽은 디자인 , 아래쪽은 메소드------------------------------------------------------
		
		// 주문 확인
		btnOrderCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioskOrderCheck();
			}
		});
		
		// 메인메뉴 주문하기 마우스 클릭시 수행
		btnMenuOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioskMenuOrder();
			}
		});

		// 메인메뉴 등록하기 마우스 클릭시 수행
		btnMenuInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioskMenuInput();
			}
		});
		
		// 작업종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "프로그램을 종료할까요?", "프로그램 종료", JOptionPane.YES_NO_OPTION);
				if (ans ==0) System.exit(0);
			}
		});
	}

}
