package t6ex_Kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class KioskMenuInput {
	private String imageFileName = null;
	private JFileChooser chooser;
	private KioskDAO dao = new KioskDAO();
	private KioskVO vo = new KioskVO();
	private int res = 0;

	private JFrame frame;
	private JTextField txtProduct;
	private JTextField txtDetail;
	private JTextField txtCalorie;
	private JTextField txtPrice;

	public static void main(String[] args) {
		new KioskMenuInput();
	}

	public KioskMenuInput() {
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
		pn1.setBounds(0, 0, 784, 58);
		frame.getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("버거킹 메뉴 등록 화면");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 22));
		lblNewLabel.setBounds(0, 0, 784, 58);
		pn1.add(lblNewLabel);
		
		JPanel pn1_1 = new JPanel();
		pn1_1.setLayout(null);
		pn1_1.setBounds(0, 56, 784, 448);
		frame.getContentPane().add(pn1_1);
		
		JLabel lbl = new JLabel("상품분류");
		lbl.setFont(new Font("굴림", Font.BOLD, 18));
		lbl.setBounds(23, 28, 108, 31);
		pn1_1.add(lbl);
		
		JLabel lbl_1 = new JLabel("상품명");
		lbl_1.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_1.setBounds(23, 82, 108, 31);
		pn1_1.add(lbl_1);
		
		JLabel lbl_2 = new JLabel("간단설명");
		lbl_2.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_2.setBounds(23, 134, 108, 31);
		pn1_1.add(lbl_2);
		
		JLabel lbl_2_1 = new JLabel("상세설명");
		lbl_2_1.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_2_1.setBounds(23, 189, 108, 31);
		pn1_1.add(lbl_2_1);
		
		JLabel lblkcal = new JLabel("칼로리(kcal)");
		lblkcal.setFont(new Font("굴림", Font.BOLD, 18));
		lblkcal.setBounds(23, 273, 108, 31);
		pn1_1.add(lblkcal);
		
		JLabel lbl_4 = new JLabel("상품이미지");
		lbl_4.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_4.setBounds(23, 391, 108, 31);
		pn1_1.add(lbl_4);
		
		JLabel lbl_5 = new JLabel("상품가격");
		lbl_5.setFont(new Font("굴림", Font.BOLD, 18));
		lbl_5.setBounds(23, 332, 108, 31);
		pn1_1.add(lbl_5);
		
		JComboBox comboPart = new JComboBox();
		comboPart.setModel(new DefaultComboBoxModel(new String[] {"버거 단품", "버거 세트", "음료", "사이드"}));
		comboPart.setFont(new Font("굴림", Font.PLAIN, 17));
		comboPart.setBounds(158, 34, 316, 31);
		pn1_1.add(comboPart);
		
		txtProduct = new JTextField();
		txtProduct.setFont(new Font("굴림", Font.PLAIN, 18));
		txtProduct.setBounds(158, 82, 316, 31);
		pn1_1.add(txtProduct);
		txtProduct.setColumns(10);
		
		txtDetail = new JTextField();
		txtDetail.setFont(new Font("굴림", Font.PLAIN, 18));
		txtDetail.setColumns(10);
		txtDetail.setBounds(158, 134, 316, 31);
		pn1_1.add(txtDetail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(158, 187, 316, 61);
		pn1_1.add(scrollPane);
		
		JTextArea txtContent = new JTextArea();
		txtContent.setFont(new Font("Monospaced", Font.PLAIN, 18));
		scrollPane.setViewportView(txtContent);
		
		txtCalorie = new JTextField();
		txtCalorie.setFont(new Font("굴림", Font.PLAIN, 18));
		txtCalorie.setColumns(10);
		txtCalorie.setBounds(158, 273, 316, 31);
		pn1_1.add(txtCalorie);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("굴림", Font.PLAIN, 18));
		txtPrice.setColumns(10);
		txtPrice.setBounds(158, 332, 316, 31);
		pn1_1.add(txtPrice);
		
		JButton btnImage = new JButton("이미지등록");
		
		btnImage.setFont(new Font("굴림", Font.BOLD, 18));
		btnImage.setBounds(158, 391, 316, 31);
		pn1_1.add(btnImage);
		
		JLabel lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(null);
		lblImage.setOpaque(true);
		lblImage.setBackground(Color.LIGHT_GRAY);
		lblImage.setBounds(527, 34, 245, 245);
		pn1_1.add(lblImage);
		
		JPanel pn1_2 = new JPanel();
		pn1_2.setLayout(null);
		pn1_2.setBounds(0, 503, 784, 58);
		frame.getContentPane().add(pn1_2);
		
		JButton btnExit = new JButton("나가기");
	
	
		btnExit.setBounds(157, 10, 117, 38);
		pn1_2.add(btnExit);
		
		JButton btnMenuInput = new JButton("등록하기");
		btnMenuInput.setBounds(355, 10, 117, 38);
		pn1_2.add(btnMenuInput);
		
		
		
		frame.setVisible(true);
		
//------------------------위쪽은 디자인 , 아래쪽은 메소드------------------------------------------------------

		// 이미지 등록
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png");
				chooser.setFileFilter(filter);
				
				int res = chooser.showOpenDialog(null);
				
				if (res != chooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(frame, "파일을 선택해 주세요.", "경고", JOptionPane.WARNING_MESSAGE);
				}
				else {
					String filePath = chooser.getSelectedFile().getAbsolutePath();
					String fileName = chooser.getSelectedFile().getName();
													
					imageFileName = fileName;
					vo.setImage(fileName);
					
					lblImage.setIcon(new ImageIcon(filePath));
				}
			}
		});
		
		// 메인메뉴 등록하기 마우스 클릭시 수행
		btnMenuInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String part = comboPart.getSelectedItem().toString();
				String product = txtProduct.getText().trim();
				String detail = txtDetail.getText().trim();
				String content = txtContent.getText().trim();
				String calorie = txtCalorie.getText().trim();
				String image = imageFileName;
				String price = txtPrice.getText().trim();
				
				if (part.equals("")) {
					JOptionPane.showMessageDialog(frame, "분류를 선택하세요");
					return;
				} 
				if (product.equals("")) {
					JOptionPane.showMessageDialog(frame, "제품명을 입력하세요");
					return;
				}
				if (detail.equals("")) {
					JOptionPane.showMessageDialog(frame, "간단 설명을 입력하세요");
					return;
				}
				if (image == null || image.equals("")) {
					JOptionPane.showMessageDialog(frame, "이미지를 등록하세요");
					return;
				}
				if (!Pattern.matches("^[0-9]+$", price)) {
					JOptionPane.showMessageDialog(frame, "가격은 숫자로 입력하세요");
					return;
				}
				if (!Pattern.matches("^[0-9]+$", calorie)) {
				    JOptionPane.showMessageDialog(frame, "칼로리는 숫자로 입력하세요");
				    return;
				}
				
				vo = new KioskVO();
				vo.setPart(part);
				vo.setProduct(product);
				vo.setDetail(detail);
				vo.setContent(content);
				vo.setCalorie(Integer.parseInt(calorie));
				vo.setImage(image);
				vo.setPrice(Integer.parseInt(price));
						
				int ans = JOptionPane.showConfirmDialog(frame, "제품을 등록하시겠습니까?", "제품 등록", JOptionPane.YES_NO_OPTION);
				
				if (ans != JOptionPane.YES_OPTION) {
					return;
				}
				
				res = dao.setMenuInput(vo);
				if (res > 0) {
					JOptionPane.showMessageDialog(frame, "제품을 등록했습니다.", "제품 등록", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					new KioskMain();
				}
				else {
					JOptionPane.showMessageDialog(frame, "제품 등록에 실패했습니다.", "제품 등록", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// 작업종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "제품등록을 취소하고 나가시겠습니까?", "제품 등록", JOptionPane.YES_NO_OPTION);
				if (ans == 0) {
					JOptionPane.showMessageDialog(frame, "제품등록을 취소했습니다.");
					frame.dispose();
					new KioskMain();
				}
			}
		});
	
	}
}
