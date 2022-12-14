package transporte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	private java.net.URL iconURL = getClass().getResource("/img/icon.png");
	private ImageIcon icon = new ImageIcon(iconURL);
	
	public MyFrame(String nome) {
		this.setSize(1020,600);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Projeto");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());
	}
}
