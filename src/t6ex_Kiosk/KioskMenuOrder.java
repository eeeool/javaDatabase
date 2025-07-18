package t6ex_Kiosk;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class KioskMenuOrder {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;

	public static void main(String[] args) {
		new KioskMenuOrder();
	}

	public KioskMenuOrder() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 91, 535, 379);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(KioskMenuOrder.class.getResource("/t6ex_Kiosk/Images/크리미할라피뇨파퍼세트.jpg")));
		lblNewLabel.setBounds(12, 11, 269, 269);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 11, 2, 2);
		panel.add(scrollPane);
		
		JButton btnOrder = new JButton("주문하기");
	
		btnOrder.setBounds(293, 89, 189, 40);
		panel.add(btnOrder);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("단품");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(293, 11, 60, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("세트");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton_1.setBounds(357, 11, 60, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("할라피뇨보다 더 귀여운 매운맛");
		textArea.setEditable(false);
		textArea.setBounds(293, 139, 209, 141);
		panel.add(textArea);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		textField.setText("0");
		textField.setBounds(357, 40, 60, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("가격");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(293, 40, 57, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("원");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(418, 40, 18, 29);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 489, 508, 62);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnExit = new JButton("메인");
		
		btnExit.setBounds(12, 10, 131, 42);
		panel_1.add(btnExit);
		
		JButton btnOrderCheck = new JButton("주문 확인");
	
		btnOrderCheck.setBounds(155, 10, 131, 42);
		panel_1.add(btnOrderCheck);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 10, 535, 58);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("버거킹 메뉴 주문 화면");
		lblNewLabel_2.setBounds(0, 0, 535, 58);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 22));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		frame.setVisible(true);
		
	//------------------------위쪽은 디자인 , 아래쪽은 메소드------------------------------------------------------
		
		// 주문 확인
		btnOrderCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioskOrderCheck();
			}
		});
		
		// 주문하기
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "제품을 주문 하시겠습니까?", "제품 주문", JOptionPane.YES_NO_OPTION);
				
				if (ans == 0) {
					JOptionPane.showMessageDialog(frame, "제품을 주문했습니다.", "제품 주문", JOptionPane.INFORMATION_MESSAGE);					
				}
				else {
					JOptionPane.showMessageDialog(frame, "제품 주문에 실패했습니다.", "제품 주문", JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
		
		// 나가기
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "주문 주문을 취소하시겠습니까?", "제품 주문", JOptionPane.YES_NO_OPTION);
				
				if (ans == 0) {
					JOptionPane.showMessageDialog(frame, "제품 주문을 취소하였습니다.", "제품 주문", JOptionPane.OK_CANCEL_OPTION);
					frame.dispose();
					new KioskMain();
				}
			}
		});
	}
}
