package t4_windowBuilder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.MetaMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class T06_File {

	private JFrame frame;

	public static void main(String[] args) {
		new T06_File();
	}

	public T06_File() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnImage = new JButton("이미지 선택");
		
		btnImage.setFont(new Font("굴림", Font.BOLD, 14));
		btnImage.setBounds(12, 10, 144, 36);
		frame.getContentPane().add(btnImage);
		
		JLabel lblImage = new JLabel("이곳에 이미지가 출력됩니다");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(12, 56, 760, 435);
		frame.getContentPane().add(lblImage);
		
		JTextArea MaMessage = new JTextArea();
		MaMessage.setFont(new Font("Monospaced", Font.BOLD, 16));
		MaMessage.setBounds(12, 501, 760, 50);
		frame.getContentPane().add(MaMessage);
		
		frame.setVisible(true);
		
		// ------------------------------------------------------------------
		
		// 이미지 선택버튼을 클릭하면 수행 (lblImage 상자에 그림파일을 출력시켜준다.)
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png");
				chooser.setFileFilter(filter);
				
				int res = chooser.showOpenDialog(null);
				
				if (res != chooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(frame, "파일을 선택해 주세요", "경고", JOptionPane.WARNING_MESSAGE);
				}
				else {
					String filePath = chooser.getSelectedFile().getPath();
					String fileName = chooser.getSelectedFile().getName();
					
					lblImage.setIcon(new ImageIcon(filePath));
					String fileInfo = "경로명과 파일명: " + filePath + "\n파일명: " + fileName;
					MaMessage.setText(fileInfo);
				}
			}
		});
	}
}
