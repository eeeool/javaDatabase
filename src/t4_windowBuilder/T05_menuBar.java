package t4_windowBuilder;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

public class T05_menuBar {

	private JFrame frame;

	public static void main(String[] args) {
		new T05_menuBar();
	}

	public T05_menuBar() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("메뉴연습");
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("File");
		btnNewButton.setIcon(new ImageIcon(T05_menuBar.class.getResource("/t4_windowBuilder/images/Image20250717122332.jpg")));
		toolBar.add(btnNewButton);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setIcon(new ImageIcon(T05_menuBar.class.getResource("/t4_windowBuilder/images/Image20250717122342.jpg")));
		toolBar.add(btnOpen);
		
		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon(T05_menuBar.class.getResource("/t4_windowBuilder/images/Image20250717122348.jpg")));
		toolBar.add(btnSave);
		
//		JSeparator separator_1 = new JSeparator();
//		toolBar.add(separator_1);
		toolBar.addSeparator();
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(T05_menuBar.class.getResource("/t4_windowBuilder/images/Image20250717122345.jpg")));
		toolBar.add(btnExit);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("About");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("About SpringGroup");
		
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		frame.setVisible(true);
		
//-------------------------------------아래는 메소드----------------------------------------------
		
		// About 버튼 클릭시 수행
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "SpringGroup Version 1.0");
			}
		});
		
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료할까요?", "작업 종료", JOptionPane.YES_NO_OPTION);
				if (ans == 0) System.exit(0);
			}
		});
		
		// 메뉴의 Exit 버튼 클릭시 수행
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(frame, "작업을 종료할까요?", "작업 종료", JOptionPane.YES_NO_OPTION);
				if (ans == 0) System.exit(0);
			}
		});
	}

}
