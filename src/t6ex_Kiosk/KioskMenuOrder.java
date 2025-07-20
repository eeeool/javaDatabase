package t6ex_Kiosk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class KioskMenuOrder {
	private KioskDAO dao = new KioskDAO();
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textPrice;
	private JPanel menuListPanel;
	private JButton btnMenu;
	private JTextField textFieldPrice;
    private JTextArea textAreaDetail;
    private JLabel lblImage;
    private JRadioButton rdbtnSingle, rdbtnSet;
    
    private String currentProduct = "";
    private String currentImage = "";
    private int currentPrice = 0;

	public static void main(String[] args) {
		new KioskMenuOrder();
	}

	public KioskMenuOrder() {
		initialize();
		menuList();
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
		
		menuListPanel = new JPanel();
		menuListPanel.setLayout(null);
		menuListPanel.setBounds(560, 91, 210, 379);
		menuListPanel.setBackground(Color.LIGHT_GRAY);
		
		JScrollPane scrollPane = new JScrollPane(menuListPanel);
		scrollPane.setBounds(560, 91, 210, 379);
		panel.add(scrollPane);
		frame.getContentPane().add(menuListPanel);
		
		JButton btnOrder = new JButton("주문하기");
	
		btnOrder.setBounds(293, 89, 189, 40);
		panel.add(btnOrder);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("단품");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(293, 11, 60, 23);
		panel.add(rdbtnNewRadioButton);
		
		lblImage = new JLabel();
		lblImage.setIcon(null);
		lblImage.setBounds(12, 11, 269, 269);
		panel.add(lblImage);
		
		textAreaDetail = new JTextArea();
		textAreaDetail.setEditable(false);
		textAreaDetail.setBounds(293, 139, 209, 141);
		panel.add(textAreaDetail);
		
		textPrice = new JTextField();
		textPrice.setHorizontalAlignment(SwingConstants.CENTER);
		textPrice.setBackground(new Color(255, 255, 255));
		textPrice.setEditable(false);
		textPrice.setText("0");
		textPrice.setBounds(293, 40, 82, 30);
		panel.add(textPrice);
		textPrice.setColumns(10);
		
		textFieldPrice = new JTextField("원");
		textFieldPrice.setEditable(false);
		textFieldPrice.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPrice.setBounds(374, 40, 38, 30);
		panel.add(textFieldPrice);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 489, 508, 62);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnMain = new JButton("메인");
		
		btnMain.setBounds(12, 10, 131, 42);
		panel_1.add(btnMain);
		
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
				if (currentProduct.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "주문할 메뉴를 선택하세요.");
					return;
				}
			 
				String part = rdbtnSingle.isSelected() ? "단품" : rdbtnSet.isSelected() ? "세트" : "";
				if (part.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "옵션을 선택하세요 (단품/세트)");
					return;
				}
				
				int ans = JOptionPane.showConfirmDialog(frame, "제품을 주문 하시겠습니까?", "제품 주문", JOptionPane.YES_NO_OPTION);
				if (ans == JOptionPane.YES_OPTION) {
					int res = dao.setMenuOrder(currentProduct, part, currentPrice);
				}
									
				if (ans > 0) {
					JOptionPane.showMessageDialog(frame, "제품을 주문했습니다.", "제품 주문", JOptionPane.INFORMATION_MESSAGE);					
				}
				else {
					JOptionPane.showMessageDialog(frame, "제품 주문에 실패했습니다.", "제품 주문", JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
		
		// 메인으로 이동
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "주문 주문을 취소하시겠습니까?", "제품 주문", JOptionPane.YES_NO_OPTION);
				
				if (ans == 0) {
					JOptionPane.showMessageDialog(frame, "제품 주문을 취소하였습니다.", "제품 주문", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					new KioskMain();
				}
			}
		});
	}
	
	// 메뉴 리스트
	private void menuList() {
		Vector menuList = dao.getAllMenuList();
		menuListPanel.removeAll();

		int y = 10;
		for (int i = 0; i < menuList.size(); i++) {
			Vector menu = (Vector) menuList.get(i);
			final String product = (String) menu.get(2);
			final String detail = (String) menu.get(3);
			final String image = (String) menu.get(4);
			final int price = (int) menu.get(7);
			
			final String imagePath = "/images/" + image;

			btnMenu = new JButton(product);
			btnMenu.setBounds(10, y, 200, 40);
			menuListPanel.add(btnMenu);
			y += 50;
			
			URL imageUrl = KioskMenuOrder.class.getResource(imagePath);

			if (imageUrl != null) {
			    lblImage.setIcon(new ImageIcon(imageUrl));
			} else {
			    System.out.println("이미지 경로 오류: " + imagePath);
			    lblImage.setIcon(null);
			}

			btnMenu.addActionListener(e -> {
				lblImage.setIcon(new ImageIcon(KioskMenuOrder.class.getResource(imagePath)));
				textAreaDetail.setText(detail);
				textFieldPrice.setText(String.valueOf(price));
				currentProduct = product;
				currentImage = image;
				currentPrice = price;
				buttonGroup.clearSelection();
			});
		}

		menuListPanel.revalidate();
		menuListPanel.repaint();
		menuListPanel.setPreferredSize(new Dimension(200, menuList.size() * 50));
	}
}
