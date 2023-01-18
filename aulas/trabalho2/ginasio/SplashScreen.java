package ginasio;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class SplashScreen extends Main {
	
	ImageIcon imagemLoad = new ImageIcon(getClass().getResource("/img/pullup.gif"));
	JProgressBar progressBar = new JProgressBar();

    public SplashScreen() {
    	JLabel imagem = new JLabel(imagemLoad);
		imagem.setBounds(0, 0, 380, 480);
        
        progressBar.setBounds(20,480,320,30);	
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.LIGHT_GRAY);
        progressBar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.CYAN));
        
        Timer timer = new Timer(20, new ActionListener() {

            private int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
            	progressBar.setValue(count);
                count++;
                if (count >= 100) {
                	drawMainMenu();
                }
            }
        });
        timer.start();
        
        frame.add(imagem);
        frame.add(progressBar);
        frame.repaint();
    }
}