package t4_windowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class T03_Combo_ListBox {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	new T03_Combo_ListBox();
			
	}

	/**
	 * Create the application.
	 */
	public T03_Combo_ListBox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 292, 294);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("직업을 선택하세요");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 268, 28);
		pn1.add(lblNewLabel);
		
		JComboBox comboJob = new JComboBox();
		
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"학생", "의사", "변호사", "회계사", "군인", "회사원", "공무원", "간호사", "자영업", "기타"}));
		comboJob.setBounds(0, 48, 280, 28);
		pn1.add(comboJob);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(316, 10, 292, 294);
		frame.getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 94, 268, 88);
		pn2.add(scrollPane);
		
		JList listJob = new JList();
		listJob.setFont(new Font("굴림", Font.BOLD, 14));
		listJob.setModel(new AbstractListModel() {
			String[] values = new String[] {"학생", "의사", "변호사", "회계사", "군인", "회사원", "공무원", "간호사", "자영업", "기타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listJob);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 314, 596, 60);
		frame.getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JButton btnNewButton = new JButton("콤보 출력");
		btnNewButton.setBounds(12, 10, 106, 40);
		pn3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("리스트 출력");
	
		btnNewButton_1.setBounds(130, 10, 106, 40);
		pn3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("메세지 출력");
		btnNewButton_2.setBounds(248, 10, 106, 40);
		pn3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("종 료");
		
		btnNewButton_3.setBounds(478, 10, 106, 40);
		pn3.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 384, 596, 167);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMessage = new JLabel("메세지가 출력 됩니다");
		lblMessage.setBounds(101, 62, 410, 45);
		panel.add(lblMessage);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		
		frame.setVisible(true);
		
//--------------------------아래는 메소드------------------------------------------------
		// 직업 리스트박스를 선택할때 수행
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "";
//				Object[] jobs = listJob.getSelectedValues();
				Object[] jobs = listJob.getSelectedValuesList().toArray();
				
				for (Object job : jobs) msg += job + "/";
				msg = msg.substring(0, msg.length()-1);
				
				lblMessage.setText(msg);
			}
		});
		
		// 직업 콤보박스를 선택할때 수행
		comboJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = comboJob.getSelectedItem().toString() + "(" + comboJob.getSelectedIndex()+ ")";
				
				lblMessage.setText(msg);
			}
		});
		
		// 종료
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료할까요?", "작업 종료", JOptionPane.YES_NO_OPTION);
				if (ans == 0) System.exit(0);
			}
		});
	}
}
