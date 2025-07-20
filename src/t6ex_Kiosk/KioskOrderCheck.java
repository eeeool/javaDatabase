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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JButton btnMainMove = new JButton("메인");
		
		btnMainMove.setBounds(12, 10, 116, 52);
		pn3.add(btnMainMove);
		
		JButton btnOrder = new JButton("상품 주문");
	
		btnOrder.setBounds(140, 10, 116, 52);
		pn3.add(btnOrder);
		
		// table 
		// Vector에 저장
		col = new Vector();
		col.add("주문번호");
		col.add("상품명");
		col.add("옵션");
		col.add("가격");
		col.add("주문시간");
		
		// 데이터를 Vector로 준비 
		vData = dao.getOrderList();
		
		// 'vData'와 'col'을 DefaultTableModel 객체 생성시 할당
		dtm = new DefaultTableModel(vData, col);

		// DefaultTableModel에 담긴 백터타입의 데이터/타이틀을 JTable 객체 생성시 담아준다.
		table = new JTable(dtm);
		
		// 자료가 담긴 JTable을 JScrollPane 객체 생성시에 담아준다
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 736, 375);
		pn2.add(scrollPane);

		scrollPane.setViewportView(table);
		
		frame.setVisible(true);
		
		//------------------------위쪽은 디자인 , 아래쪽은 메소드------------------------------------------------------
		
		// 메인 이동
		btnMainMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioskMain();
			}
		});
		
		// 상품주문 이동
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new KioskMenuOrder();
			}
		});
	}
}
