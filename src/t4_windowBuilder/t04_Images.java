package t4_windowBuilder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class t04_Images {
	JLabel lblImg1, lblImg2, lblImg3, lblImg4, lblMessage;
	int img1Cnt = 0, img2Cnt = 0, img3Cnt = 0, img4Cnt = 0;

	private JFrame frame;

	public static void main(String[] args) {
		new t04_Images();
	}

	public t04_Images() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("카드 횟수 맞추기");
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 960, 48);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);

		JButton btnTotal = new JButton("모두보기");

		btnTotal.setBounds(12, 10, 109, 28);
		pn1.add(btnTotal);

		JButton btn1 = new JButton("1번 보기");

		btn1.setBounds(133, 10, 109, 28);
		pn1.add(btn1);

		JButton btn2 = new JButton("2번 보기");
		btn2.setBounds(254, 10, 109, 28);
		pn1.add(btn2);

		JButton btn3 = new JButton("3번 보기");
		btn3.setBounds(375, 10, 109, 28);
		pn1.add(btn3);

		JButton btn4 = new JButton("4번 보기");
		btn4.setBounds(496, 10, 109, 28);
		pn1.add(btn4);

		JButton brnRandom = new JButton("랜덤 보기");

		brnRandom.setBounds(617, 10, 109, 28);
		pn1.add(brnRandom);

		JButton btnExit = new JButton("종 료");

		btnExit.setBounds(863, 10, 97, 28);
		pn1.add(btnExit);

		JButton btnClose = new JButton("모두 닫기");

		btnClose.setBounds(738, 10, 109, 28);
		pn1.add(btnClose);

		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 89, 960, 385);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);

		lblImg1 = new JLabel("New label");
		lblImg1.setIcon(new ImageIcon(t04_Images.class.getResource("/t4_windowBuilder/images/amur-tiger-4155922_1280.jpg")));
		lblImg1.setBounds(22, 10, 212, 365);
		pn2.add(lblImg1);

		lblImg2 = new JLabel("New label");
		lblImg2.setIcon(new ImageIcon(t04_Images.class.getResource("/t4_windowBuilder/images/deer-1367217_1280.jpg")));
		lblImg2.setBounds(256, 10, 212, 365);
		pn2.add(lblImg2);

		lblImg3 = new JLabel("New label");
		lblImg3.setIcon(new ImageIcon(t04_Images.class.getResource("/t4_windowBuilder/images/pets-3715733_1280.jpg")));
		lblImg3.setBounds(490, 10, 212, 365);
		pn2.add(lblImg3);

		lblImg4 = new JLabel("New label");
		lblImg4.setIcon(new ImageIcon(t04_Images.class.getResource("/t4_windowBuilder/images/wolf-142173_1280.jpg")));
		lblImg4.setBounds(724, 10, 212, 365);
		pn2.add(lblImg4);

		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 503, 960, 48);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);

		lblMessage = new JLabel("선택된 카드의 횟수를 보여줍니다");
		lblMessage.setBackground(Color.WHITE);
		lblMessage.setFont(new Font("굴림", Font.BOLD, 16));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(0, 0, 960, 48);
		pn3.add(lblMessage);

		frame.setVisible(true);

// --------------------------아래는 메소드-----------------------------------------
		// 1번보기 클릭시 수행
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblImg1.setVisible(true);
				lblImg2.setVisible(false);
				lblImg3.setVisible(false);
				lblImg4.setVisible(false);
				
				img1Cnt++;
				displayCount();
			}
		});

		// 2번보기 클릭시 수행
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblImg1.setVisible(false);
				lblImg2.setVisible(true);
				lblImg3.setVisible(false);
				lblImg4.setVisible(false);
				
				img2Cnt++;
				displayCount();
			}
		});

		// 3번보기 클릭시 수행
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblImg1.setVisible(false);
				lblImg2.setVisible(false);
				lblImg3.setVisible(true);
				lblImg4.setVisible(false);
				
				img3Cnt++;
				displayCount();
			}
		});

		// 4번보기 클릭시 수행
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblImg1.setVisible(false);
				lblImg2.setVisible(false);
				lblImg3.setVisible(false);
				lblImg4.setVisible(true);
				
				img4Cnt++;
				displayCount();
			}
		});

		// 랜덤보기 클릭시 수행
		brnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rand = (int) (Math.random() * 4) + 1;

				if (rand == 1) {
					lblImg1.setVisible(true);
					lblImg2.setVisible(false);
					lblImg3.setVisible(false);
					lblImg4.setVisible(false);
					
					img1Cnt++;
					displayCount();
				} else if (rand == 2) {
					lblImg1.setVisible(false);
					lblImg2.setVisible(true);
					lblImg3.setVisible(false);
					lblImg4.setVisible(false);
					
					img2Cnt++;
					displayCount();
				} else if (rand == 3) {
					lblImg1.setVisible(false);
					lblImg2.setVisible(false);
					lblImg3.setVisible(true);
					lblImg4.setVisible(false);
					
					img3Cnt++;
					displayCount();
				} else if (rand == 4) {
					lblImg1.setVisible(false);
					lblImg2.setVisible(false);
					lblImg3.setVisible(false);
					lblImg4.setVisible(true);
					
					img4Cnt++;
					displayCount();
				}
			}
		});

		// 모두보기 버튼 클릭시 수행
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allDisplay();
				
				img1Cnt++;
				img2Cnt++;
				img3Cnt++;
				img4Cnt++;

				displayCount();
			}
		});

		// 모두닫기 버튼 클릭시 수행
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allClose();
				
				img1Cnt = 0;
				img2Cnt = 0;
				img3Cnt = 0;
				img4Cnt = 0;
				
				displayCount();
			}
		});

		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료할까요?", "작업 종료", JOptionPane.YES_NO_OPTION);
				if (ans == 0) System.exit(0);
			}
		});
	}

	// 카운트 수를 레이블에 출력하기
	protected void displayCount() {
		lblMessage.setText("1번: " + img1Cnt + ", 2번: " + img2Cnt + ", 3번: " + img3Cnt + ", 4번: " + img4Cnt);
	}

	// 모두 보기 버튼 클릭시 수행 메소드
	protected void allDisplay() {
		lblImg1.setVisible(true);
		lblImg2.setVisible(true);
		lblImg3.setVisible(true);
		lblImg4.setVisible(true);
	}

	// 모두 닫기 버튼 클릭시 수행 메소드
	protected void allClose() {
		lblImg1.setVisible(false);
		lblImg2.setVisible(false);
		lblImg3.setVisible(false);
		lblImg4.setVisible(false);
	}
}
