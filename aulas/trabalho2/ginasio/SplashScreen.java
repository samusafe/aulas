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
	
	ImageIcon imagemLoad = new ImageIcon(getClass().getResource("/img/splash.gif"));
	JProgressBar progressBar = new JProgressBar();

    public SplashScreen() {
    		addImage();
            addProgressBar();
            runningPBar();
    }
    
    public void addImage(){
    	JLabel imagem = new JLabel(imagemLoad);
		imagem.setBounds(0, 0, 380, 440);
		
        frame.add(imagem);
        frame.repaint();
    }
    
    public void addProgressBar() {
        progressBar.setBounds(20,480,320,30);	
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.LIGHT_GRAY);
        progressBar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.CYAN));
        
        frame.add(progressBar);
        frame.repaint();
    }
    
    public void runningPBar() {
    	Timer timer = new Timer(35, new ActionListener() {

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
    }
}