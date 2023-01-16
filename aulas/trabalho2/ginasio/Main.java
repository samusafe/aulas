package ginasio;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	
	protected MyFrame frame = new MyFrame("Projeto");
	private ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/img/"));
	private GereGinasio gereGinasio = new GereGinasio();
	
	public void drawMainMenu() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 380, 600);
		
		JButton criar = new JButton("Criar conta");
		criar.setBounds(30,450,120,20);
		criar.setBackground(Color.WHITE);
		criar.setFont(new Font("Arial", Font.BOLD, 14));
		criar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawCreateAccount();	
			}
		});
		
		JButton login = new JButton("Entrar conta");
		login.setBounds(180,450,120,20);
		login.setBackground(Color.WHITE);
		login.setFont(new Font("Arial", Font.BOLD, 14));
		login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawLoginAccount ();
			}
		});
		
		frame.add(criar);
		frame.add(login);
		frame.add(imagem);
		frame.repaint();
	}
	
	public void drawCreateAccount() {
		
	}
	
	public void drawLoginAccount() {
		
	}
	  
	public void showError(String error) {
		JFrame errorFrame = new JFrame("Error");
	
		JLabel errorLabel = new JLabel(error);
		errorLabel.setBounds(20,0,100,70);
		
		errorFrame.add(errorLabel);
		errorFrame.setSize(220,150);
		errorFrame.setLayout(new GridBagLayout());
		errorFrame.setLocationRelativeTo(frame);
		errorFrame.setResizable(false);
		errorFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SplashScreen splashScreen = new SplashScreen();
	}
}
	  
