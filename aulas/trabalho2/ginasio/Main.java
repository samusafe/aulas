package ginasio;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class Main {
	
	protected MyFrame frame = new MyFrame("FitnessHUB");
	private ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/img/gym.jpg"));
	private ImageIcon imagemLoad = new ImageIcon(getClass().getResource("/img/pullup.gif"));
	private ImageIcon backIcon = new ImageIcon(getClass().getResource("/img/back.png"));
	private ImageIcon bicepIcon = new ImageIcon(getClass().getResource("/img/bicep.png"));
	private ImageIcon calendarioIcon = new ImageIcon(getClass().getResource("/img/calendario.png"));
	private ImageIcon contaIcon = new ImageIcon(getClass().getResource("/img/conta.png"));
	private ImageIcon contratoIcon = new ImageIcon(getClass().getResource("/img/contratos.png"));
	private ImageIcon healthIcon = new ImageIcon(getClass().getResource("/img/health.png"));
	private ImageIcon trainersIcon = new ImageIcon(getClass().getResource("/img/trainers.png"));
	private ImageIcon weightIcon = new ImageIcon(getClass().getResource("/img/weight.png"));
	private ImageIcon ginasioIcon = new ImageIcon(getClass().getResource("/img/ginasio.png"));
	private ImageIcon infoIcon = new ImageIcon(getClass().getResource("/img/info.png"));
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
		
		JButton conta = new JButton(contaIcon);
		conta.setBounds(100, 240, 47, 47);
		conta.setBorder(null);
		conta.setOpaque(false);
		conta.setContentAreaFilled(false);
		conta.setBorderPainted(false);
		conta.setFocusable(false);
		conta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showError("ola");
			}
		});
		
		JButton ginasio = new JButton(ginasioIcon);
		ginasio.setBounds(200, 240, 47, 47);
		ginasio.setBorder(null);
		ginasio.setOpaque(false);
		ginasio.setContentAreaFilled(false);
		ginasio.setBorderPainted(false);
		ginasio.setFocusable(false);
		ginasio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawGinasioMenu();
			}
		});
		
		try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/LoveAmour.ttf"));
            slogan1.setFont(font.deriveFont(Font.ITALIC, 42f));
            slogan2.setFont(font.deriveFont(Font.ITALIC, 42f));
            slogan3.setFont(font.deriveFont(Font.ITALIC, 42f));
            slogan4.setFont(font.deriveFont(Font.ITALIC, 42f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		frame.add(slogan1);
		frame.add(slogan2);
		frame.add(slogan3);
		frame.add(slogan4);
		frame.add(conta);
		frame.add(ginasio);
		frame.add(imagemFundo);
		frame.repaint();
	}
	
	public void drawGinasioMenu() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		JButton back = new JButton(backIcon);
		back.setBounds(10, 20, 47, 47);
		back.setBorder(null);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setFocusable(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawMainMenu();
			}
		});
		
		JLabel ginasioTitle = new JLabel("FitnessHUB");
		ginasioTitle.setBounds(80, 25, 280, 47);
		ginasioTitle.setForeground(Color.WHITE);
		
		JButton horario = new JButton("Horário do ginásio");
		horario.setBounds(100, 130, 240, 60);
		horario.setBackground(Color.CYAN);
		horario.setForeground(Color.BLACK);
		horario.setFocusable(false);
		horario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawHorarioMenu();
			}
		});
		
		horario.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	horario.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	horario.setBackground(Color.CYAN);
		    }
		});
		
		JLabel horarioIcon = new JLabel(calendarioIcon);
		horarioIcon.setBounds(30, 140, 47, 47);
		
		JButton contratos = new JButton("Contratos");
		contratos.setBounds(100, 230, 240, 60);
		contratos.setBackground(Color.CYAN);
		contratos.setForeground(Color.BLACK);
		contratos.setFocusable(false);
		contratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawContratosMenu();
			}
		});
		
		contratos.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	contratos.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	contratos.setBackground(Color.CYAN);
		    }
		});
		
		JLabel contratosIcon = new JLabel(contratoIcon);
		contratosIcon.setBounds(25, 230, 47, 53);
		
		JButton primeirosSocorros = new JButton("Suporte básico de vida");
		primeirosSocorros.setBounds(100, 430, 240, 60);
		primeirosSocorros.setBackground(Color.CYAN);
		primeirosSocorros.setForeground(Color.BLACK);
		primeirosSocorros.setFocusable(false);
		primeirosSocorros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawHealthMenu();
			}
		});
		
		primeirosSocorros.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	primeirosSocorros.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	primeirosSocorros.setBackground(Color.CYAN);
		    }
		});
		
		JLabel primeirosSocorrosIcon = new JLabel(healthIcon);
		primeirosSocorrosIcon.setBounds(25, 430, 47, 53);

		JButton personalTrainers = new JButton("Personal trainers");
		personalTrainers.setBounds(100, 330, 240, 60);
		personalTrainers.setBackground(Color.CYAN);
		personalTrainers.setForeground(Color.BLACK);
		personalTrainers.setFocusable(false);
		personalTrainers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawTrainersMenu();
			}
		});
		
		personalTrainers.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	personalTrainers.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	personalTrainers.setBackground(Color.CYAN);
		    }
		});
		
		JLabel personalTrainersIcon = new JLabel(trainersIcon);
		personalTrainersIcon.setBounds(25, 330, 47, 53);
		
		try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/LoveAmour.ttf"));
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DinoAndFriend.ttf"));
            horario.setFont(font.deriveFont(Font.ITALIC, 22f));
            contratos.setFont(font.deriveFont(Font.ITALIC, 22f));
            primeirosSocorros.setFont(font.deriveFont(Font.ITALIC, 20f));
            personalTrainers.setFont(font.deriveFont(Font.ITALIC, 22f));
            ginasioTitle.setFont(font2.deriveFont(Font.BOLD | Font.ITALIC, 48f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		frame.add(horario);
		frame.add(contratos);
		frame.add(primeirosSocorros);
		frame.add(personalTrainers);
		frame.add(horarioIcon);
		frame.add(contratosIcon);
		frame.add(primeirosSocorrosIcon);
		frame.add(personalTrainersIcon);
		frame.add(ginasioTitle);
		frame.add(back);
		frame.repaint();
	}
	
	public void drawHorarioMenu() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		JButton back = new JButton(backIcon);
		back.setBounds(10, 20, 47, 47);
		back.setBorder(null);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setFocusable(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawGinasioMenu();
			}
		});
		
		JLabel horariosTitle = new JLabel("Horarios");
		horariosTitle.setBounds(80, 25, 280, 47);
		horariosTitle.setForeground(Color.WHITE);
		
		JLabel text1 = new JLabel("Dias uteis");
		text1.setBounds(40, 120, 180, 40);
		text1.setForeground (Color.CYAN);
		
		JLabel text2 = new JLabel("<html>Segunda-feira ‏ ‎‏‏‎ ‎‏‏‎ ‎‏‏‎ ‎ 07:00-23:00 <br> Terça-feira ‏‏‎ ‎‏‏‎ ‎‏‏‏‏‎ ‎‏‏‎ ‎‏‏‎ ‎ ‎‏‏‎‏‏‎ ‎‏‏‎ ‎ ‎‏‏‎ ‎ 07:00-23:00 <br> Quarta-feira ‏‏‎ ‎‏‏‎ ‎‏‏‎ ‎‏‏‎ ‎ ‏‏‎ ‏‏‎ ‎‏‏‎ ‏‏‎ ‎‎‎07:00-23:00"
				+ " <br> Quinta-feira ‏‏‎ ‎‏‏‎ ‎‏‏‎ ‎‏‏‎ ‎‏‏‎ ‏‏‎ ‎‏‏‎ ‎‎‏‏‎ ‎ 07:00-23:00 <br> Sexta-feira ‏‏‎ ‎‏‏‎ ‎‏‏‎ ‎‏‏‎ ‎‏‏‎ ‏‏‎ ‎‎‏‏‎ ‎‏‏‎ ‎‏‏‎ ‎‏‏‎ ‎ 07:00-23:00 </html>");
		text2.setBounds(40, 150, 240, 120);
		text2.setForeground (Color.WHITE);
		
		JLabel text3 = new JLabel("Sábados e Domingos");
		text3.setBounds(40, 280, 240, 40);
		text3.setForeground (Color.CYAN);
		
		JLabel text4 = new JLabel("<html>Sábados ‏ ‎‏‏‎ ‎‏‏‎ ‎‏‏‎‎‏‏‎ ‎‏‏‎ ‎‏‏‎‎‏‏‎‎‏‏‎ ‎‏‏‎ ‎‏‏‎‎‏‏‎ ‎‏‏‎‎‏‏‎‎‏‏‎ ‎‏‏‎‎‏‏‎ ‎‏‏‎ ‎‏‏‎ ‎‏‏‎‎‏‏‎ ‎‏‏‎‎ 08:00-20:00 <br> Domingos ‏‏‎ ‎‏‏‎ ‎‏‏‏‏‎ ‎‏‏‎ ‎‏‏‎ ‎ ‎‏‏‎‏‏‎ ‎‏‏‎ ‎ ‎‏‏‎ ‎ 09:00-19:00</html>");
		text4.setBounds(40, 310, 240, 60);
		text4.setForeground (Color.WHITE);
		
		JLabel text5 = new JLabel("Feriados e Épocas Festivas");
		text5.setBounds(40, 380, 280, 40);
		text5.setForeground (Color.CYAN);
		
		JLabel text6 = new JLabel("08:00-14:00");
		text6.setBounds(40, 410, 100, 40);
		text6.setForeground (Color.WHITE);
		
		try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DinoAndFriend.ttf"));
            text1.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 24f));
            text2.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 16f));
            text3.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 24f));
            text4.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 16f));
            text5.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 22f));
            text6.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 16f));
            horariosTitle.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 48f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		frame.add(text1);
		frame.add(text2);
		frame.add(text3);
		frame.add(text4);
		frame.add(text5);
		frame.add(text6);
		frame.add(horariosTitle);
		frame.add(back);
		frame.repaint();
	}

	public void drawContratosMenu() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		JButton back = new JButton(backIcon);
		back.setBounds(10, 20, 47, 47);
		back.setBorder(null);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setFocusable(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawGinasioMenu();
			}
		});
		
		JLabel contratosTitle = new JLabel("Contratos");
		contratosTitle.setBounds(80, 25, 280, 47);
		contratosTitle.setForeground(Color.WHITE);
		
		JButton button1 = new JButton("Acesso básico");
		button1.setBounds(60, 160, 240, 60);
		button1.setBackground(Color.CYAN);
		button1.setForeground(Color.BLACK);
		button1.setFocusable(false);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawContratosMenu();
			}
		});
		button1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button1.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button1.setBackground(Color.CYAN);
		    }
		});
		
		JLabel moreInfo = new JLabel("");
		moreInfo.setBounds(110, 230, 280, 47);
		moreInfo.setForeground(Color.WHITE);
		
		JButton info = new JButton(infoIcon);
		info.setBounds(70, 230, 30, 30);
		info.setBorder(null);
		info.setOpaque(false);
		info.setContentAreaFilled(false);
		info.setBorderPainted(false);
		info.setFocusable(false);
		info.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	moreInfo.setText( String.format( "<html> que lhe dá acesso apenas <br> aos serviços básicos (ginásio) </html>"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	moreInfo.setText("");
		    }
		});
		
		JButton button2 = new JButton("Acesso completo");
		button2.setBounds(60, 340, 240, 60);
		button2.setBackground(Color.CYAN);
		button2.setForeground(Color.BLACK);
		button2.setFocusable(false);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawContratosMenu();
			}
		});
		button2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button2.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button2.setBackground(Color.CYAN);
		    }
		});
		
		JLabel moreInfo2 = new JLabel("");
		moreInfo2.setBounds(110, 420, 280, 70);
		moreInfo2.setForeground(Color.WHITE);
		
		JButton info2 = new JButton(infoIcon);
		info2.setBounds(70, 410, 30, 30);
		info2.setBorder(null);
		info2.setOpaque(false);
		info2.setContentAreaFilled(false);
		info2.setBorderPainted(false);
		info2.setFocusable(false);
		info2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	moreInfo2.setText( String.format("<html> que para além dos acessos contemplados anteriormente, <br> também lhe permite aceder"
						+ " <br>a serviços como sauna e solário </html>"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	moreInfo2.setText("");
		    }
		});
		
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/LoveAmour.ttf"));
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DinoAndFriend.ttf"));
            button1.setFont(font.deriveFont(Font.ITALIC, 24f));
            button2.setFont(font.deriveFont(Font.ITALIC, 24f));
            moreInfo.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 14f));
            moreInfo2.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 14f));
            contratosTitle.setFont(font2.deriveFont(Font.BOLD | Font.ITALIC, 48f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		frame.add(button1);
		frame.add(button2);
		frame.add(moreInfo);
		frame.add(moreInfo2);
		frame.add(contratosTitle);
		frame.add(info);
		frame.add(info2);
		frame.add(back);
		frame.repaint();
	}
	
	public void drawHealthMenu() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		JButton back = new JButton(backIcon);
		back.setBounds(10, 20, 47, 47);
		back.setBorder(null);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setFocusable(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawGinasioMenu();
			}
		});
		
		frame.add(back);
		frame.repaint();
	}
	
	public void drawTrainersMenu() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		JButton back = new JButton(backIcon);
		back.setBounds(10, 20, 47, 47);
		back.setBorder(null);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setFocusable(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawGinasioMenu();
			}
		});
		
		frame.add(back);
		frame.repaint();
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
	
	public void SplashScreen() {
		frame.getContentPane().removeAll();
		
    	JLabel imagem = new JLabel(imagemLoad);
		imagem.setBounds(0, 0, 380, 480);
        
		JProgressBar progressBar = new JProgressBar();
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
	
	public static void main(String[] args) {
		Main menu = new Main();
		menu.drawMainMenu();
	}
}
	  
