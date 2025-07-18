package t6ex_Kiosk;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

@SuppressWarnings({"unchecked", "rawtypes", "unused"})
public class KioskOrderCheck {
	private Vector col, vData;
	private DefaultTableModel dtm;
	private JFrame frame;
	private JTable table;
	
	KioskDAO dao = new KioskDAO();

	public static void main(String[] args) {
		new KioskOrderCheck();
	}

	public KioskOrderCheck() {
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
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 58);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("주문 확인");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 22));
		lblNewLabel.setBounds(0, 0, 760, 58);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 78, 760, 395);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 479, 760, 72);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnNewButton = new JButton("메인");
		btnNewButton.setBounds(12, 10, 116, 52);
		pn3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("상품 주문");
		btnNewButton_1.setBounds(140, 10, 116, 52);
		pn3.add(btnNewButton_1);
		
		// table 
		// Vector에 저장
		col = new Vector();
		col.add("번호");
		col.add("상품분류");
		col.add("상품명");
		col.add("간단설명");
		col.add("상세설명");
		col.add("칼로리");
		col.add("가격");
		
		// 데이터를 Vector로 준비 
		vData = dao.getMenuList();
		
		// 'vData'와 'col'을 DefaultTableModel 객체 생성시 할당
		dtm = new DefaultTableModel(vData, col);

		// DefaultTableModel에 담긴 백터타입의 데이터/타이틀을 JTable 객체 생성시 담아준다.
		table = new JTable(dtm);
		
		// 자료가 담긴 JTable을 JScrollPane 객체 생성시에 담아준다
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 736, 375);
		pn2.add(scrollPane);

		scrollPane.setViewportView(table);
		
		frame.setVisible(true);
	}
}
