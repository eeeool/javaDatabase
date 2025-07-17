package t4_windowBuilder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class T02_Radio_Checkbox {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		new T02_Radio_Checkbox();

	}

	public T02_Radio_Checkbox() {
		initialize();
	}

	private void initialize() {
	frame = new JFrame();
	frame.setTitle("라디오, 체크박스 연습");
	frame.getContentPane().setBackground(Color.WHITE);
	frame.setSize(800, 600);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JPanel pn1 = new JPanel();
	pn1.setBackground(Color.CYAN);
	pn1.setBounds(12, 10, 563, 40);
	frame.getContentPane().add(pn1);
	pn1.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("라디오 버튼 / 체크박스 연습");
	lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(0, 0, 562, 40);
	pn1.add(lblNewLabel);
	
	JPanel pn2 = new JPanel();
	pn2.setBackground(Color.WHITE);
	pn2.setBounds(12, 60, 563, 353);
	frame.getContentPane().add(pn2);
	pn2.setLayout(null);
	
	JRadioButton rdMale = new JRadioButton("남자");
	buttonGroup.add(rdMale);
	rdMale.setFont(new Font("굴림", Font.PLAIN, 14));
	rdMale.setBackground(Color.WHITE);
	rdMale.setHorizontalAlignment(SwingConstants.CENTER);
	rdMale.setBounds(133, 48, 101, 23);
	pn2.add(rdMale);
	
	JRadioButton rdFemale = new JRadioButton("여자");
	rdFemale.setSelected(true);
	buttonGroup.add(rdFemale);
	rdFemale.setFont(new Font("굴림", Font.PLAIN, 14));
	rdFemale.setBackground(Color.WHITE);
	rdFemale.setHorizontalAlignment(SwingConstants.CENTER);
	rdFemale.setBounds(261, 48, 101, 23);
	pn2.add(rdFemale);
	
	JCheckBox chHobby1 = new JCheckBox("등산");
	chHobby1.setHorizontalAlignment(SwingConstants.CENTER);
	chHobby1.setBounds(133, 107, 101, 23);
	pn2.add(chHobby1);
	
	JCheckBox chHobby2 = new JCheckBox("낚시");
	chHobby2.setHorizontalAlignment(SwingConstants.CENTER);
	chHobby2.setBounds(261, 107, 101, 23);
	pn2.add(chHobby2);
	
	JCheckBox chHobby3 = new JCheckBox("수영");
	chHobby3.setHorizontalAlignment(SwingConstants.CENTER);
	chHobby3.setBounds(389, 107, 101, 23);
	pn2.add(chHobby3);
	
	JCheckBox chHobby4 = new JCheckBox("바둑");
	chHobby4.setHorizontalAlignment(SwingConstants.CENTER);
	chHobby4.setBounds(192, 155, 101, 23);
	pn2.add(chHobby4);
	
	JCheckBox chHobby5 = new JCheckBox("바이크");
	chHobby5.setHorizontalAlignment(SwingConstants.CENTER);
	chHobby5.setBounds(332, 155, 101, 23);
	pn2.add(chHobby5);
	
	JLabel lblMessage = new JLabel("메세지가 출력 됩니다");
	lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
	lblMessage.setBounds(130, 263, 303, 44);
	pn2.add(lblMessage);
	
	JButton btnGender = new JButton("성별");
	
	btnGender.setBounds(17, 48, 97, 23);
	pn2.add(btnGender);
	
	JButton btnGender_1 = new JButton("취미");
	btnGender_1.setBounds(17, 107, 97, 23);
	pn2.add(btnGender_1);
	
	JPanel pn3 = new JPanel();
	pn3.setBackground(Color.PINK);
	pn3.setBounds(12, 423, 563, 51);
	frame.getContentPane().add(pn3);
	pn3.setLayout(null);
	
	JButton btnNewButton = new JButton("성별 출력");
	btnNewButton.setFont(new Font("굴림", Font.PLAIN, 12));
	btnNewButton.setBounds(12, 10, 97, 31);
	pn3.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("취미 출력");
	
	
	btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 12));
	btnNewButton_1.setBounds(163, 10, 97, 31);
	pn3.add(btnNewButton_1);
	
	JButton btnExit = new JButton("종 료");
	btnExit.setFont(new Font("굴림", Font.PLAIN, 12));
	btnExit.setBounds(306, 10, 97, 31);
	pn3.add(btnExit);
	
	frame.setVisible(true);
	
	// ---------------------------위쪽은 디자인, 아래쪽은 메소드-------------------------
	
	// 취미 출력버튼 클릭시 수행
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String hobby = "선택하신 취미는? ";
			if (chHobby1.isSelected()) hobby += chHobby1.getText() + "/";
			if (chHobby2.isSelected()) hobby += chHobby2.getText() + "/";
			if (chHobby3.isSelected()) hobby += chHobby3.getText() + "/";
			if (chHobby4.isSelected()) hobby += chHobby4.getText() + "/";
			if (chHobby5.isSelected()) hobby += chHobby5.getText() + "/";
			
			hobby = hobby.substring(0, hobby.length()-1);
			
			lblMessage.setText(hobby);
		}
	});
	
	// 성별 출력버튼 클릭시 수행
	btnGender.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String gender = "선택하신 성별은? ";
			if (rdMale.isSelected()) gender += rdMale.getText();
			else gender += rdFemale.getText();
			
			lblMessage.setText(gender);
		}
	});
	
	// 종료버튼을 마우스로 클릭시 수행
	btnExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료할까요?", "작업 종료", JOptionPane.YES_NO_OPTION);
			if (ans == 0) System.exit(0);
		}
	});
	}
}
