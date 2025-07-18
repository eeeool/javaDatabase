package t5_Insa;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class InsaSearch {
	private InsaDAO dao = new InsaDAO();
	private InsaVO vo = null;
	private int res = 0;
	
	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup buttonGroup = new ButtonGroup();

//	public static void main(String[] args) {
//		new InsaInput();
//	}

	public InsaSearch(InsaVO vo) {
		this.vo = vo;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("회원 조회 프로그램");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 62);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("회 원 개 별 조 회");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 760, 62);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 82, 760, 397);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성명");
		lblName.setFont(new Font("굴림", Font.PLAIN, 18));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(100, 45, 139, 42);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.PLAIN, 18));
		lblAge.setBounds(100, 132, 139, 42);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.PLAIN, 18));
		lblGender.setBounds(100, 219, 139, 42);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입사일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("굴림", Font.PLAIN, 18));
		lblIpsail.setBounds(100, 306, 139, 42);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setEnabled(false);
		txtName.setFont(new Font("굴림", Font.PLAIN, 16));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(240, 45, 262, 42);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.PLAIN, 16));
		txtAge.setHorizontalAlignment(SwingConstants.CENTER);
		txtAge.setColumns(10);
		txtAge.setBounds(240, 132, 262, 42);
		pn2.add(txtAge);
		
		JRadioButton rdMale = new JRadioButton("남 자");
		buttonGroup.add(rdMale);
		rdMale.setFont(new Font("굴림", Font.PLAIN, 16));
		rdMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdMale.setBounds(240, 219, 130, 42);
		pn2.add(rdMale);
		
		JRadioButton rdFemale = new JRadioButton("여 자");
		rdFemale.setSelected(true);
		buttonGroup.add(rdFemale);
		rdFemale.setFont(new Font("굴림", Font.PLAIN, 16));
		rdFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdFemale.setBounds(372, 219, 130, 42);
		pn2.add(rdFemale);
		
		// 년/월/일 초기값 생성하기
		String[] yy = new String[25];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi = 2025;
		
		for (int i=0; i<yy.length; i++) {
			yy[i] = imsi - i + "";
		}
		
		for (int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + "";
		}
		
		for (int i=0; i<dd.length; i++) {
			dd[i] = (i+1) + "";
		}
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setFont(new Font("굴림", Font.PLAIN, 18));
		cbYY.setBounds(240, 313, 109, 30);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setFont(new Font("굴림", Font.PLAIN, 18));
		cbMM.setBounds(416, 313, 109, 30);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setFont(new Font("굴림", Font.PLAIN, 18));
		cbDD.setBounds(576, 313, 109, 30);
		pn2.add(cbDD);
		
		JLabel lblYY = new JLabel("년");
		lblYY.setFont(new Font("굴림", Font.PLAIN, 16));
		lblYY.setHorizontalAlignment(SwingConstants.CENTER);
		lblYY.setBounds(347, 318, 23, 19);
		pn2.add(lblYY);
		
		JLabel lblMM = new JLabel("월");
		lblMM.setHorizontalAlignment(SwingConstants.CENTER);
		lblMM.setFont(new Font("굴림", Font.PLAIN, 16));
		lblMM.setBounds(525, 318, 23, 19);
		pn2.add(lblMM);
		
		JLabel lblDD = new JLabel("일");
		lblDD.setHorizontalAlignment(SwingConstants.CENTER);
		lblDD.setFont(new Font("굴림", Font.PLAIN, 16));
		lblDD.setBounds(684, 318, 23, 19);
		pn2.add(lblDD);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 489, 760, 62);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnUpdate = new JButton("수정하기");
	
		btnUpdate.setBounds(95, 10, 126, 42);
		pn3.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제하기");
		
		btnDelete.setBounds(316, 10, 126, 42);
		pn3.add(btnDelete);
		
		JButton btnClose = new JButton("창 닫 기");
		btnClose.setBounds(537, 10, 126, 42);
		pn3.add(btnClose);
		
		// vo에서 담겨서 넘어온 회원의 정보를 검색창에 뿌려줄 수 있도록 처리한다.
		txtName.setText(vo.getName());
		txtAge.setText(vo.getAge() + "");
		if (vo.getGender().equals("남자")) rdMale.setSelected(true);
		if (vo.getGender().equals("여자")) rdFemale.setSelected(true);
		
		// 날짜 형식의 자료를 '년/월/일'로 각각 뽑아서 콤보상자에 대입시켜준다.
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d"); // 2025-07-10
		LocalDate date = LocalDate.parse(vo.getIpsail().substring(0, 10), dtf);
		String strDate = date.format(dtf);
		String[] ymds = strDate.split("-");
		cbYY.setSelectedItem(ymds[0]);
		cbMM.setSelectedItem(ymds[1]);
		cbDD.setSelectedItem(ymds[2]);
		
		
//	 -------------------------------------------------------------------------------
		frame.setVisible(true);
		
	// -------------------------------아래는 메소드--------------------------------------
		
		// 회원 자료 삭제처리
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				
				int ans = JOptionPane.showConfirmDialog(frame, "회원 정보를 삭제하시겠습니까?", "회원 삭제창", JOptionPane.YES_NO_OPTION);
				
				int res = dao.setInsaDelete(name);
				if (ans == 0) {
					if (res != 0) {
						JOptionPane.showMessageDialog(frame, "회원자료가 삭제 되었습니다.");
						frame.dispose();
						new InsaMain();
					}
					else JOptionPane.showMessageDialog(frame, "회원정보 삭제 실패");
				}
				else JOptionPane.showMessageDialog(frame, "회원정보 삭제 취소");
			}
		});
		
		// 회원 수정버튼 마우스로 클릭시 수행
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String age = txtAge.getText().trim();
				String gender = "";
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();

				// 유효성 검사
				if (!Pattern.matches("^[0-9]+$", age)) {
					JOptionPane.showMessageDialog(frame, "나이는 숫자로 입력하세요");
					txtAge.requestFocus();
				}
				else {
					if (rdMale.isSelected()) gender = "남자";
					else gender = "여자";
					
					// 회원명 중복처리 완료 후 앞에서 기록한 내용을 vo에 담아서 DB에 저장한다.
					vo = new InsaVO();
					vo.setName(txtName.getText());
					vo.setAge(Integer.parseInt(age));
					vo.setGender(gender);
					vo.setIpsail(ipsail);
					
					res = dao.setInsaUpdate(vo);
					
					if (res != 0) {
						JOptionPane.showMessageDialog(frame, "회원정보가 수정 되었습니다.");
//						frame.dispose();
//						new InsaMain();
					}
					else JOptionPane.showMessageDialog(frame, "회원정보 수정 실패");
				}
			}
		});
		
		// Exit 버튼 클릭시 수행
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new InsaMain();
			}
		});
	}
}
