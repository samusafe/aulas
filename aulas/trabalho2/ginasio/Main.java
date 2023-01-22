package ginasio;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

import enums.ContratoType;

public class Main {
	
	protected MyFrame frame = new MyFrame("FitnessHUB");
	private ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/img/gym.jpg"));
	private ImageIcon showPasswordImage = new ImageIcon(getClass().getResource("/img/showpassword.png"));
	private ImageIcon backIcon = new ImageIcon(getClass().getResource("/img/back.png"));
	private ImageIcon bicepIcon = new ImageIcon(getClass().getResource("/img/bicep.png"));
	private ImageIcon calendarioIcon = new ImageIcon(getClass().getResource("/img/calendario.png"));
	private ImageIcon contaIcon = new ImageIcon(getClass().getResource("/img/conta.png"));
	private ImageIcon editIcon = new ImageIcon(getClass().getResource("/img/edit.png"));
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
				drawAccountMenu();
			}
		});
		
		User user = null;
		
		JButton ginasio = new JButton(ginasioIcon);
		ginasio.setBounds(200, 240, 47, 47);
		ginasio.setBorder(null);
		ginasio.setOpaque(false);
		ginasio.setContentAreaFilled(false);
		ginasio.setBorderPainted(false);
		ginasio.setFocusable(false);
		ginasio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawGinasioMenu(user);
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
	
	public void drawAccountMenu() {
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
		
		JLabel contaTitle = new JLabel("Conta");
		contaTitle.setBounds(80, 25, 280, 47);
		contaTitle.setForeground(Color.WHITE);
		
		JLabel gymIcon = new JLabel(weightIcon);
		gymIcon.setBounds(160, 120, 47, 47);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(80, 180, 160, 47);
		emailLabel.setForeground(Color.WHITE);
		
		JTextField emailTextField = new JTextField("");
		emailTextField.setBounds(70, 220, 220, 47);
		emailTextField.setBackground(Color.WHITE);
		emailTextField.setForeground(Color.BLACK);
		emailTextField.setColumns(30);
		emailTextField.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(80, 280, 160, 47);
		passwordLabel.setForeground(Color.WHITE);
		
		JPasswordField passwordTextField = new JPasswordField("");
		passwordTextField.setBounds(70, 320, 220, 47);
		passwordTextField.setBackground(Color.WHITE);
		passwordTextField.setForeground(Color.BLACK);
		passwordTextField.setColumns(30);
		passwordTextField.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		JButton showPasswordIcon = new JButton(showPasswordImage);
		showPasswordIcon.setBounds(290, 330, 30, 30);
		showPasswordIcon.setBorder(null);
		showPasswordIcon.setOpaque(false);
		showPasswordIcon.setContentAreaFilled(false);
		showPasswordIcon.setBorderPainted(false);
		showPasswordIcon.setFocusable(false);
		showPasswordIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordTextField.getEchoChar() == (char)0) {
					passwordTextField.setEchoChar('\u2022');
				} else if (passwordTextField.getEchoChar() == ('\u2022')) {
					passwordTextField.setEchoChar((char)0);
				}
			}
		});
		
		JLabel haveAccount = new JLabel("<html> <u> Ainda não tens conta?</u> </html>");
		haveAccount.setBounds(80, 350, 160, 50);
		haveAccount.setForeground(Color.WHITE);
		haveAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		haveAccount.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				drawCreateAccount();
			}
		});
		
		JButton entrar = new JButton("Entrar");
		entrar.setBounds(240, 410, 90, 40);
		entrar.setBackground(Color.CYAN);
		entrar.setForeground(Color.BLACK);
		entrar.setFocusable(false);
		entrar.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (emailTextField.getText().equals("")) {
					showError("Insira email");
					return;
				}
				if (passwordTextField.getPassword().length == 0) {
					showError("Insira password");
					return;
				}
				if (!gereGinasio.hasUsers()) {
					showError("Nenhuma conta criada");
					return;
				}
				else {
					User user = gereGinasio.entrarSistema(emailTextField.getText(), passwordTextField.getPassword());
					if (user == null) {
						showError("Conta não existe");
						return;
					}
					
					if  (user instanceof Colaborador) {
						//drawColabMenu(user);
					} else if (user instanceof VIP) {
						//drawVipMenu(user);
					} else {
						drawGinasioMenu(user);
					}
				}
			}
		});
		
		try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DinoAndFriend.ttf"));
            emailLabel.setFont(font.deriveFont(Font.ITALIC, 24f));
            passwordLabel.setFont(font.deriveFont(Font.ITALIC, 24f));
            haveAccount.setFont(font.deriveFont(Font.PLAIN, 16f));
            entrar.setFont(font.deriveFont(Font.PLAIN, 14f));
            contaTitle.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 48f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		frame.add(emailLabel);
		frame.add(emailTextField);
		frame.add(passwordLabel);
		frame.add(passwordTextField);
		frame.add(haveAccount);
		frame.add(contaTitle);
		frame.add(entrar);
		frame.add(gymIcon);
		frame.add(showPasswordIcon);
		frame.add(back);
		frame.repaint();
	}
	
	public void drawCreateAccount() {
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
				drawAccountMenu();
			}
		});
		
		JLabel contaTitle = new JLabel("Criar conta");
		contaTitle.setBounds(80, 25, 280, 47);
		contaTitle.setForeground(Color.WHITE);
		
		JLabel gymIcon = new JLabel(weightIcon);
		gymIcon.setBounds(160, 100, 47, 47);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(80, 160, 160, 47);
		nomeLabel.setForeground(Color.WHITE);
		
		JTextField nomeTextField = new JTextField("");
		nomeTextField.setBounds(70, 200, 220, 47);
		nomeTextField.setBackground(Color.WHITE);
		nomeTextField.setForeground(Color.BLACK);
		nomeTextField.setColumns(30);
		nomeTextField.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(80, 240, 160, 47);
		emailLabel.setForeground(Color.WHITE);
		
		JTextField emailTextField = new JTextField("");
		emailTextField.setBounds(70, 280, 220, 47);
		emailTextField.setBackground(Color.WHITE);
		emailTextField.setForeground(Color.BLACK);
		emailTextField.setColumns(30);
		emailTextField.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(80, 320, 160, 47);
		passwordLabel.setForeground(Color.WHITE);
		
		JPasswordField passwordTextField = new JPasswordField("");
		passwordTextField.setBounds(70, 360, 220, 47);
		passwordTextField.setBackground(Color.WHITE);
		passwordTextField.setForeground(Color.BLACK);
		passwordTextField.setColumns(30);
		passwordTextField.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		JButton showPasswordIcon = new JButton(showPasswordImage);
		showPasswordIcon.setBounds(290, 370, 30, 30);
		showPasswordIcon.setBorder(null);
		showPasswordIcon.setOpaque(false);
		showPasswordIcon.setContentAreaFilled(false);
		showPasswordIcon.setBorderPainted(false);
		showPasswordIcon.setFocusable(false);
		showPasswordIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordTextField.getEchoChar() == (char)0) {
					passwordTextField.setEchoChar('\u2022');
				} else if (passwordTextField.getEchoChar() == ('\u2022')) {
					passwordTextField.setEchoChar((char)0);
				}
			}
		});
		
		JLabel numeroLabel = new JLabel("Numero");
		numeroLabel.setBounds(80, 400, 160, 47);
		numeroLabel.setForeground(Color.WHITE);
		
		JTextField numeroTextField = new JTextField("");
		numeroTextField.setBounds(70, 440, 220, 47);
		numeroTextField.setBackground(Color.WHITE);
		numeroTextField.setForeground(Color.BLACK);
		numeroTextField.setColumns(30);
		numeroTextField.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		JButton criar = new JButton("Criar");
		criar.setBounds(200, 500, 110, 40);
		criar.setBackground(Color.CYAN);
		criar.setForeground(Color.BLACK);
		criar.setFocusable(false);
		criar.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nomeTextField.getText().equals("")) {
					showError("Insira nome");
					return;
				}
				if (emailTextField.getText().equals("")) {
					showError("Insira email");
					return;
				}
				if (passwordTextField.getPassword().length == 0) {
					showError("Insira password");
					return;
				}
				if (numeroTextField.getText().equals("")) {
					showError("Insira numero");
					return;
				}
				if (!gereGinasio.criarConta(gereGinasio.users.size(), emailTextField.getText(),
						passwordTextField.getPassword(), nomeTextField.getText(), numeroTextField.getText())) {
					showError("Conta duplicada");
					return;
				}

				User user = gereGinasio.entrarSistema(emailTextField.getText(), passwordTextField.getPassword());
				
				if  (user instanceof Colaborador) {
					//drawColabMenu(user);
				} else if (user instanceof VIP) {
					//drawVipMenu(user);
				} else {
					drawGinasioMenu(user);
				}
			}
		});
		
		try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DinoAndFriend.ttf"));
            emailLabel.setFont(font.deriveFont(Font.ITALIC, 24f));
            nomeLabel.setFont(font.deriveFont(Font.ITALIC, 24f));
            passwordLabel.setFont(font.deriveFont(Font.ITALIC, 24f));
            numeroLabel.setFont(font.deriveFont(Font.ITALIC, 24f));
            criar.setFont(font.deriveFont(Font.PLAIN, 14f));
            contaTitle.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 48f));;
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		frame.add(emailLabel);
		frame.add(emailTextField);
		frame.add(nomeLabel);
		frame.add(nomeTextField);
		frame.add(passwordLabel);
		frame.add(passwordTextField);
		frame.add(numeroLabel);
		frame.add(numeroTextField);
		frame.add(contaTitle);
		frame.add(criar);
		frame.add(gymIcon);
		frame.add(showPasswordIcon);
		frame.add(back);
		frame.repaint();
	}
	
	public void drawGinasioMenu(User user) {
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
		horario.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		horario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawHorarioMenu(user);
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
		contratos.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		contratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawContratosMenu(user);
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
		
		JButton personalTrainers = new JButton("Personal trainers");
		personalTrainers.setBounds(100, 330, 240, 60);
		personalTrainers.setBackground(Color.CYAN);
		personalTrainers.setForeground(Color.BLACK);
		personalTrainers.setFocusable(false);
		personalTrainers.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		personalTrainers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawTrainersMenu(user);
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
		
		JButton primeirosSocorros = new JButton("Suporte básico de vida");
		primeirosSocorros.setBounds(100, 430, 240, 60);
		primeirosSocorros.setBackground(Color.CYAN);
		primeirosSocorros.setForeground(Color.BLACK);
		primeirosSocorros.setFocusable(false);
		primeirosSocorros.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		primeirosSocorros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawHealthMenu(user);
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
		
		JLabel welcome = new JLabel("");
		welcome.setBounds(80, 120, 240, 47);
		welcome.setForeground(Color.WHITE);
		
		JButton modifyAccount = new JButton("Editar conta");
		modifyAccount.setBounds(100, 460, 240, 60);
		modifyAccount.setBackground(Color.CYAN);
		modifyAccount.setForeground(Color.BLACK);
		modifyAccount.setFocusable(false);
		modifyAccount.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		modifyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawEditAccount(user);
			}
		});
		
		modifyAccount.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	modifyAccount.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	modifyAccount.setBackground(Color.CYAN);
		    }
		});
		
		JLabel modifyAccountIcon = new JLabel(contaIcon);
		modifyAccountIcon.setBounds(25, 460, 47, 53);
		
		JButton bookSession = new JButton("Marcar sessão");
		bookSession.setBounds(100, 230, 240, 60);
		bookSession.setBackground(Color.CYAN);
		bookSession.setForeground(Color.BLACK);
		bookSession.setFocusable(false);
		bookSession.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		bookSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showError("marcar");
			}
		});
		
		bookSession.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	bookSession.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	bookSession.setBackground(Color.CYAN);
		    }
		});
		
		JLabel bookSessionIcon = new JLabel(bicepIcon);
		bookSessionIcon.setBounds(25, 230, 47, 53);
		
		try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/LoveAmour.ttf"));
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DinoAndFriend.ttf"));
            horario.setFont(font.deriveFont(Font.ITALIC, 22f));
            contratos.setFont(font.deriveFont(Font.ITALIC, 22f));
            primeirosSocorros.setFont(font.deriveFont(Font.ITALIC, 18f));
            personalTrainers.setFont(font.deriveFont(Font.ITALIC, 22f));
            modifyAccount.setFont(font.deriveFont(Font.ITALIC, 22f));
            bookSession.setFont(font.deriveFont(Font.ITALIC, 22f));
            welcome.setFont(font2.deriveFont(Font.BOLD | Font.ITALIC, 24f));
            ginasioTitle.setFont(font2.deriveFont(Font.BOLD | Font.ITALIC, 48f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		if (user instanceof User) {
			horario.setBounds(100, 260, 240, 60);
			horarioIcon.setBounds(30, 270, 47, 47);
			
			primeirosSocorros.setBounds(100, 360, 240, 60);
			primeirosSocorrosIcon.setBounds(25, 360, 47, 53);
			
			welcome.setText("Bem-Vindo " + user.getNome());
			
			frame.add(horario);
			frame.add(horarioIcon);
			frame.add(modifyAccount);
			frame.add(modifyAccountIcon);
			frame.add(primeirosSocorros);
			frame.add(primeirosSocorrosIcon);
			frame.add(ginasioTitle);
			frame.add(welcome);
			frame.add(back);
			
			frame.repaint();
		} else if (user instanceof VIP) {
			
			frame.add(bookSession);
			frame.add(bookSessionIcon);
			
			frame.repaint();
		} else if (user instanceof Colaborador) {
			
			
			frame.repaint();
		} else {
			frame.add(horario);
			frame.add(horarioIcon);
			frame.add(primeirosSocorros);
			frame.add(primeirosSocorrosIcon);
			frame.add(personalTrainers);
			frame.add(personalTrainersIcon);
			frame.add(contratos);
			frame.add(contratosIcon);
			frame.add(ginasioTitle);
			frame.add(back);
			frame.repaint();
		}
	}
	
	public void drawEditAccount(User user) {
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
				drawGinasioMenu(user);
			}
		});
		
		JLabel editContaTitle = new JLabel("Editar");
		editContaTitle.setBounds(80, 25, 280, 47);
		editContaTitle.setForeground(Color.WHITE);
		
		JLabel personalInfo = new JLabel("Informações Pessoais");
		personalInfo.setBounds(60, 80, 280, 47);
		personalInfo.setForeground(Color.WHITE);
		
		JLabel text1 = new JLabel("Nome");
		text1.setBounds(40, 120, 100, 40);
		text1.setForeground (Color.CYAN);
		
		JLabel text2 = new JLabel(user.getNome());
		text2.setBounds(40, 140, 200, 40);
		text2.setForeground (Color.WHITE);
		
		JLabel text3 = new JLabel("Email");
		text3.setBounds(40, 180, 100, 40);
		text3.setForeground (Color.CYAN);
		
		JLabel text4 = new JLabel(user.getEmail());
		text4.setBounds(40, 200, 200, 40);
		text4.setForeground (Color.WHITE);
		
		JLabel text5 = new JLabel("Numero");
		text5.setBounds(40, 240, 100, 40);
		text5.setForeground (Color.CYAN);
		
		JLabel text6 = new JLabel(user.getNumero());
		text6.setBounds(40, 260, 200, 40);
		text6.setForeground (Color.WHITE);
		
		JLabel text7 = new JLabel("Password");
		text7.setBounds(40, 300, 120, 40);
		text7.setForeground (Color.CYAN);
		
		JLabel text8 = new JLabel(user.getPassword());
		text8.setBounds(40, 320, 200, 40);
		text8.setForeground (Color.WHITE);
		
		JLabel contractInfo = new JLabel("Contrato");
		contractInfo.setBounds(130, 360, 280, 47);
		contractInfo.setForeground(Color.WHITE);
		
		JLabel text9 = new JLabel("Tipo");
		text9.setBounds(40, 400, 120, 40);
		text9.setForeground (Color.CYAN);
		
		JLabel text10 = new JLabel("");
		text10.setBounds(80, 380, 200, 40);
		text10.setForeground (Color.WHITE);
		
		if (user.getContrato().getContratoType().equals(ContratoType.DIARIO)) {
			text10.setText("Diário");
		} else if (user.getContrato().getContratoType().equals(ContratoType.TRIMESTRAL)) {
			text10.setText("Trimestral");
		} else if (user.getContrato().getContratoType().equals(ContratoType.SEMESTRAL)) {
			text10.setText("Semestral");
		} else if (user.getContrato().getContratoType().equals(ContratoType.ANUAL)) {
			text10.setText("Anual");
		} else if (user.getContrato().getContratoType().equals(ContratoType.NULL)) {
			contractInfo.setVisible(false);
			text9.setVisible(false);
			text10.setVisible(false);
		}
		
		try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DinoAndFriend.ttf"));
            text1.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 24f));
            text2.setFont(font.deriveFont(Font.PLAIN, 18f));
            text3.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 24f));
            text4.setFont(font.deriveFont(Font.PLAIN, 18f));
            text5.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 24f));
            text6.setFont(font.deriveFont(Font.PLAIN, 18f));
            text7.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 24f));
            text8.setFont(font.deriveFont(Font.PLAIN, 18f));
            text9.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 24f));
            text10.setFont(font.deriveFont(Font.PLAIN, 18f));
            personalInfo.setFont(font.deriveFont(Font.BOLD, 24f));
            contractInfo.setFont(font.deriveFont(Font.BOLD, 24f));
            editContaTitle.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 48f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		frame.add(text1);
		frame.add(text2);
		frame.add(text3);
		frame.add(text4);
		frame.add(text5);
		frame.add(text6);
		frame.add(text7);
		frame.add(text8);
		frame.add(text9);
		frame.add(text10);
		frame.add(personalInfo);
		frame.add(contractInfo);
		frame.add(editContaTitle);
		frame.add(back);
		frame.repaint();
	}
	
	public void drawHorarioMenu(User user) {
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
				drawGinasioMenu(user);
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
	
	public void drawContratosMenu(User user) {
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
				drawGinasioMenu(user);
			}
		});
		
		JLabel contratos = new JLabel(contratoIcon);
		contratos.setBounds(150, 120, 47, 47);
		
		JLabel contratosTitle = new JLabel("Contratos");
		contratosTitle.setBounds(80, 25, 280, 47);
		contratosTitle.setForeground(Color.WHITE);
		
		JButton button1 = new JButton("Tipos de acesso");
		button1.setBounds(60, 190, 240, 60);
		button1.setBackground(Color.CYAN);
		button1.setForeground(Color.BLACK);
		button1.setFocusable(false);
		button1.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawAcessType(user);
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
		
		JButton button2 = new JButton("Durações");
		button2.setBounds(60, 270, 240, 60);
		button2.setBackground(Color.CYAN);
		button2.setForeground(Color.BLACK);
		button2.setFocusable(false);
		button2.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawDuration(user);
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
		
		JButton button3 = new JButton("Tipos de cliente");
		button3.setBounds(60, 350, 240, 60);
		button3.setBackground(Color.CYAN);
		button3.setForeground(Color.BLACK);
		button3.setFocusable(false);
		button3.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawClientType(user);
			}
		});
		button3.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button3.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button3.setBackground(Color.CYAN);
		    }
		});
		
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/LoveAmour.ttf"));
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DinoAndFriend.ttf"));
            button1.setFont(font.deriveFont(Font.ITALIC, 24f));
            button2.setFont(font.deriveFont(Font.ITALIC, 24f));
            button3.setFont(font.deriveFont(Font.ITALIC, 24f));
            contratosTitle.setFont(font2.deriveFont(Font.BOLD | Font.ITALIC, 48f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(contratos);
		frame.add(contratosTitle);
		frame.add(back);
		frame.repaint();
	}

	public void drawAcessType(User user) {
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
				drawContratosMenu(user);
			}
		});
		
		JLabel contratos = new JLabel(contratoIcon);
		contratos.setBounds(150, 120, 47, 47);
		
		JLabel contratosTitle = new JLabel("Tipos de acesso");
		contratosTitle.setBounds(80, 25, 280, 47);
		contratosTitle.setForeground(Color.WHITE);
		
		JButton button1 = new JButton("Acesso básico");
		button1.setBounds(60, 190, 240, 60);
		button1.setBackground(Color.CYAN);
		button1.setForeground(Color.BLACK);
		button1.setFocusable(false);
		button1.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		button1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button1.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button1.setBackground(Color.CYAN);
		    }
		});
		
		JLabel moreInfo = new JLabel("");
		moreInfo.setBounds(110, 260, 280, 47);
		moreInfo.setForeground(Color.WHITE);
		
		JButton info = new JButton(infoIcon);
		info.setBounds(70, 260, 30, 30);
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
		button2.setBounds(60, 330, 240, 60);
		button2.setBackground(Color.CYAN);
		button2.setForeground(Color.BLACK);
		button2.setFocusable(false);
		button2.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		button2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button2.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button2.setBackground(Color.CYAN);
		    }
		});
		
		JLabel moreInfo2 = new JLabel("");
		moreInfo2.setBounds(110, 410, 280, 70);
		moreInfo2.setForeground(Color.WHITE);
		
		JButton info2 = new JButton(infoIcon);
		info2.setBounds(70, 400, 30, 30);
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
            contratosTitle.setFont(font2.deriveFont(Font.BOLD | Font.ITALIC, 36f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		frame.add(button1);
		frame.add(button2);
		frame.add(moreInfo);
		frame.add(moreInfo2);
		frame.add(contratos);
		frame.add(contratosTitle);
		frame.add(info);
		frame.add(info2);
		frame.add(back);
		frame.repaint();
	}
	
	public void drawDuration(User user) {
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
				drawContratosMenu(user);
			}
		});
		
		JLabel contratos = new JLabel(contratoIcon);
		contratos.setBounds(150, 120, 47, 47);
		
		JLabel contratosTitle = new JLabel("Durações");
		contratosTitle.setBounds(80, 25, 280, 47);
		contratosTitle.setForeground(Color.WHITE);
		
		JButton button1 = new JButton("Diário");
		button1.setBounds(60, 190, 240, 60);
		button1.setBackground(Color.CYAN);
		button1.setForeground(Color.BLACK);
		button1.setFocusable(false);
		button1.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		button1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button1.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button1.setBackground(Color.CYAN);
		    }
		});
		
		JLabel moreInfo = new JLabel("");
		moreInfo.setBounds(110, 260, 280, 47);
		moreInfo.setForeground(Color.WHITE);
		
		JButton info = new JButton(infoIcon);
		info.setBounds(70, 260, 30, 30);
		info.setBorder(null);
		info.setOpaque(false);
		info.setContentAreaFilled(false);
		info.setBorderPainted(false);
		info.setFocusable(false);
		info.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	moreInfo.setText( String.format( "<html> onde o cliente pode cessar contrato <br> sempre que assim entender </html>"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	moreInfo.setText("");
		    }
		});
		
		JButton button2 = new JButton("Trimestral");
		button2.setBounds(60, 310, 240, 60);
		button2.setBackground(Color.CYAN);
		button2.setForeground(Color.BLACK);
		button2.setFocusable(false);
		button2.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		button2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button2.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button2.setBackground(Color.CYAN);
		    }
		});
		
		JButton button3 = new JButton("Semestral");
		button3.setBounds(60, 380, 240, 60);
		button3.setBackground(Color.CYAN);
		button3.setForeground(Color.BLACK);
		button3.setFocusable(false);
		button3.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		button3.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button3.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button3.setBackground(Color.CYAN);
		    }
		});
		
		JButton button4 = new JButton("Anual");
		button4.setBounds(60, 450, 240, 60);
		button4.setBackground(Color.CYAN);
		button4.setForeground(Color.BLACK);
		button4.setFocusable(false);
		button4.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		button4.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button4.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button4.setBackground(Color.CYAN);
		    }
		});
		
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/LoveAmour.ttf"));
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DinoAndFriend.ttf"));
            button1.setFont(font.deriveFont(Font.ITALIC, 24f));
            button2.setFont(font.deriveFont(Font.ITALIC, 24f));
            button3.setFont(font.deriveFont(Font.ITALIC, 24f));
            button4.setFont(font.deriveFont(Font.ITALIC, 24f));
            moreInfo.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 14f));
            contratosTitle.setFont(font2.deriveFont(Font.BOLD | Font.ITALIC, 36f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(moreInfo);
		frame.add(contratos);
		frame.add(contratosTitle);
		frame.add(info);
		frame.add(back);
		frame.repaint();
	}
	
	public void drawClientType(User user) {
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
				drawContratosMenu(user);
			}
		});
		
		JLabel contratos = new JLabel(contratoIcon);
		contratos.setBounds(150, 120, 47, 47);
		
		JLabel contratosTitle = new JLabel("Tipos de cliente");
		contratosTitle.setBounds(80, 25, 280, 47);
		contratosTitle.setForeground(Color.WHITE);
		
		JButton button1 = new JButton("Cliente normal");
		button1.setBounds(60, 220, 240, 60);
		button1.setBackground(Color.CYAN);
		button1.setForeground(Color.BLACK);
		button1.setFocusable(false);
		button1.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		button1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button1.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button1.setBackground(Color.CYAN);
		    }
		});
		
		JButton button2 = new JButton("Cliente VIP");
		button2.setBounds(60, 340, 240, 60);
		button2.setBackground(Color.CYAN);
		button2.setForeground(Color.BLACK);
		button2.setFocusable(false);
		button2.setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(), 
                new EmptyBorder(new Insets(15, 25, 15, 25))));
		button2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	button2.setBackground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	button2.setBackground(Color.CYAN);
		    }
		});
		
		JLabel moreInfo = new JLabel("");
		moreInfo.setBounds(110, 410, 280, 77);
		moreInfo.setForeground(Color.WHITE);
		
		JButton info = new JButton(infoIcon);
		info.setBounds(70, 410, 30, 30);
		info.setBorder(null);
		info.setOpaque(false);
		info.setContentAreaFilled(false);
		info.setBorderPainted(false);
		info.setFocusable(false);
		info.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	moreInfo.setText( String.format( "<html> que para além das condições<br> associadas ao cliente normal, <br>tem acesso aos serviços <br>de personal trainer </html>"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	moreInfo.setText("");
		    }
		});
		
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/LoveAmour.ttf"));
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DinoAndFriend.ttf"));
            button1.setFont(font.deriveFont(Font.ITALIC, 24f));
            button2.setFont(font.deriveFont(Font.ITALIC, 24f));
            moreInfo.setFont(font.deriveFont(Font.BOLD | Font.ITALIC, 14f));
            contratosTitle.setFont(font2.deriveFont(Font.BOLD | Font.ITALIC, 36f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		frame.add(button1);
		frame.add(button2);
		frame.add(moreInfo);
		frame.add(contratos);
		frame.add(contratosTitle);
		frame.add(info);
		frame.add(back);
		frame.repaint();
	}
	
	public void drawHealthMenu(User user) {
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
				drawGinasioMenu(user);
			}
		});
		
		JLabel primeirosIcon = new JLabel(healthIcon);
		primeirosIcon.setBounds(150, 120, 47, 47);
		
		JLabel primeirosTitle = new JLabel("Suporte basico de vida");
		primeirosTitle.setBounds(80, 25, 280, 47);
		primeirosTitle.setForeground(Color.WHITE);
		
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/LoveAmour.ttf"));
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DinoAndFriend.ttf"));
            primeirosTitle.setFont(font2.deriveFont(Font.BOLD | Font.ITALIC, 24f));
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
		
		frame.add(primeirosIcon);
		frame.add(primeirosTitle);
		frame.add(back);
		frame.repaint();
	}
	
	public void drawTrainersMenu(User user) {
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
				drawGinasioMenu(user);
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
	
	@SuppressWarnings("serial")
    class CustomeBorder extends AbstractBorder{
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y,
                int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(12));
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
        }   
    }
	
	public static void main(String[] args) {
		Main menu = new Main();
		menu.drawMainMenu();
	}
}
	  
