package t5_Insa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

public class InsaMain {

	private JFrame frame;

	public static void main(String[] args) {
		new InsaMain();
	}

	public InsaMain() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("파일 연습");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 62);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("인사관리 프로그램");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 760, 62);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 82, 760, 397);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(InsaMain.class.getResource("/t4_windowBuilder/images/4.jpg")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(0, 0, 760, 397);
		pn2.add(lblLogo);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 489, 760, 62);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnInput = new JButton("사원등록");
		
		btnInput.setBounds(12, 10, 117, 42);
		pn3.add(btnInput);
		
		JButton btnSearch = new JButton("개별조회");
	
		btnSearch.setBounds(141, 10, 117, 42);
		pn3.add(btnSearch);
		
		JButton btnNewButton_2 = new JButton("전체조회");
		btnNewButton_2.setBounds(270, 10, 117, 42);
		pn3.add(btnNewButton_2);
		
		JButton btnExit = new JButton("종료");
		btnExit.setBounds(631, 10, 117, 42);
		pn3.add(btnExit);
		
		frame.setVisible(true);
		
// -------------------------------아래는 메소드--------------------------------------
		
		// 회원 개별 조회버튼을 마우스 클릭 실행
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세요");
				InsaDAO dao = new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				
				if (vo.getName() == null) JOptionPane.showMessageDialog(frame, "검색한 회원이 없습니다.");
				else {
					frame.dispose();
					new InsaSearch(vo);
				}
			}
		});	
		
		// 사원등록 폼 호출
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new InsaInput();
			}
		});
		
		// Exit 버튼 클릭시 수행
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료할까요?", "작업 종료", JOptionPane.YES_NO_OPTION);
				if (ans == 0) System.exit(0);
			}
		});
	}
}
