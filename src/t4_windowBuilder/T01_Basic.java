package t4_windowBuilder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class T01_Basic {

	private JFrame frame;
	private JTextField txtMid;
	private JPasswordField txtPwd;
	private JTextField txtName;
	private JTextField txtAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new T01_Basic();
	}

	/**
	 * Create the application.
	 */
	public T01_Basic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
//		frame.setBounds(100, 100, 800, 600);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton BtnExit = new JButton("작업종료");
		BtnExit.setFont(new Font("굴림", Font.BOLD, 24));
		BtnExit.setBounds(492, 427, 200, 40);
		frame.getContentPane().add(BtnExit);
		
		JButton BtnInput = new JButton("회원가입");
		BtnInput.setFont(new Font("굴림", Font.BOLD, 24));
		BtnInput.setBounds(12, 427, 200, 40);
		frame.getContentPane().add(BtnInput);
		
		JButton BtnReset = new JButton("다시입력");
		BtnReset.setFont(new Font("굴림", Font.BOLD, 24));
		BtnReset.setBounds(246, 427, 200, 40);
		frame.getContentPane().add(BtnReset);
		
		JLabel lblNewLabel = new JLabel("나이");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 219, 152, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("성명");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 84, 152, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 151, 152, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("아이디");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 10, 152, 40);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtMid = new JTextField();
		txtMid.setBounds(150, 16, 245, 30);
		frame.getContentPane().add(txtMid);
		txtMid.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(150, 157, 245, 30);
		frame.getContentPane().add(txtPwd);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(150, 90, 245, 30);
		frame.getContentPane().add(txtName);
		
		txtAge = new JTextField();
		txtAge.setText("0");
		txtAge.setColumns(10);
		txtAge.setBounds(150, 225, 245, 30);
		frame.getContentPane().add(txtAge);
		
		JLabel lblNewLabel_3_1 = new JLabel("자기소개");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(12, 277, 152, 40);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 284, 245, 102);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txtContent = new JTextArea();
		scrollPane.setViewportView(txtContent);
		
		frame.setVisible(true);
		
		// ---------------------------위쪽은 디자인, 아래쪽은 메소드--------------------------------
		
		// 종료 버튼 클릭시 수행
		BtnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		BtnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});
		
		// 회원가입 버튼 클릭시 수행
		BtnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mid = txtMid.getText();
				String pwd = txtPwd.getText();
				String name = txtName.getText();
				int age = Integer.parseInt(txtAge.getText());
				String content = txtContent.getText();
				
				if (mid.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디는 필수입력 입니다.", "회원가입창", JOptionPane.WARNING_MESSAGE);
				} 
				else if(pwd.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호 필수 입력입니다.", "회원가입창", JOptionPane.WARNING_MESSAGE);
				} 
				else if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명은 필수 입력입니다.", "회원가입창", JOptionPane.WARNING_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "회원에 가입합니다.", "회원가입", JOptionPane.INFORMATION_MESSAGE);			
				}
				
			}
		});
	}
}
