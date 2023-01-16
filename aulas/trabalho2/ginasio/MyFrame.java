package ginasio;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	private java.net.URL iconURL = getClass().getResource("/img/icon.png");
	private ImageIcon icon = new ImageIcon(iconURL);
	
	public MyFrame(String nome) {
		this.setSize(380,600);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle(nome);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());
	}
}
