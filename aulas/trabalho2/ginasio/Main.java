package ginasio;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	
	protected MyFrame frame = new MyFrame("Projeto");
	private ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/img/gym.jpg"));
	private GereGinasio gereGinasio = new GereGinasio();
	
	public void drawMainMenu() {
		frame.getContentPane().removeAll();
		
		JLabel imagemFundo = new JLabel(backgroundImage);
		imagemFundo.setBounds(0, 0, 380, 600);
		
		JLabel slogan1 = new JLabel("WORK");
		slogan1.setBounds(20, 60, 300, 40);
		slogan1.setForeground (Color.BLACK);
		
		JLabel slogan2 = new JLabel("HARD");
		slogan2.setBounds(170, 60, 300, 40);
		slogan2.setForeground (Color.WHITE);
		
		JLabel slogan3 = new JLabel("NO");
		slogan3.setBounds(20, 110, 300, 40);
		slogan3.setForeground (Color.WHITE);
		
		JLabel slogan4 = new JLabel("REGRET");
		slogan4.setBounds(100, 110, 300, 40);
		slogan4.setForeground (Color.BLACK);
		
		JButton criar = new JButton("Contratos");
		criar.setBounds(30,450,120,20);
		criar.setBackground(Color.WHITE);
		criar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawCreateAccount();	
			}
		});
		
		JButton login = new JButton("Entrar conta");
		login.setBounds(180,450,120,20);
		login.setBackground(Color.WHITE);
		login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawLoginAccount ();
			}
		});
		
		try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Chalkduster.ttf"));
            slogan1.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 42f));
            slogan2.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 42f));
            slogan3.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 42f));
            slogan4.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 42f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		
		frame.add(slogan1);
		frame.add(slogan2);
		frame.add(slogan3);
		frame.add(slogan4);
		//frame.add(criar);
		//frame.add(login);
		frame.add(imagemFundo);
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
		//Main menu = new Main();
		//menu.drawMainMenu();
		SplashScreen splashScreen = new SplashScreen();
	}
}
	  
