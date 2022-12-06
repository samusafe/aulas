package transporte;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import transporte.Truck.truckState;

public class Main {
	
	private JFrame frame = new JFrame("Projeto");
	private ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/img/warehouse.jpg"));
	private ImageIcon addTruckIcon = new ImageIcon(getClass().getResource("/img/add_truck.png"));
	private ImageIcon manageTruckIcon = new ImageIcon(getClass().getResource("/img/manage_truck.png"));
	private ImageIcon addBoxIcon = new ImageIcon(getClass().getResource("/img/add_box.png"));
	private ImageIcon truckIcon = new ImageIcon(getClass().getResource("/img/truck.png"));
	private java.net.URL iconURL = getClass().getResource("/img/icon.png");
	private ImageIcon icon = new ImageIcon(iconURL);
	private GereTruck gereTruck = new GereTruck();
	
	public void drawMainMenu() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 1020, 600);
		
		JButton addTruck = new JButton(addTruckIcon);
		addTruck.setOpaque(false);
		addTruck.setContentAreaFilled(false);
		addTruck.setBorderPainted(false);
		addTruck.setFocusPainted(false);
		addTruck.setBounds(800, 400, 176, 130);
		addTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entrada = JOptionPane.showInputDialog(frame ,"Volume máximo", 
						"Camião " + (gereTruck.trucks.size() + 1), JOptionPane.INFORMATION_MESSAGE);
				if (entrada == null) {
					return;
				}
				if (entrada.isEmpty()) {
					return;
				}
				int volume = Integer.parseInt(entrada);
			    if (volume < 1 || volume > 10000) {
			    	showError("Valor inválido");
			    	return;
			    } else {
			    	Truck truck = new Truck(truckState.LOADING, volume);
			    	gereTruck.trucks.add(truck);
			    }
			}
		});
		
		JButton manageTruck = new JButton(manageTruckIcon);
		manageTruck.setOpaque(false);
		manageTruck.setContentAreaFilled(false);
		manageTruck.setBorderPainted(false);
		manageTruck.setFocusPainted(false);
		manageTruck.setBounds(805, 290, 150, 110);
		manageTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gereTruck.trucks.size() < 1) {
					showError("Não há camiões no armazem");
					return;
				}
				
				DefaultListModel<Truck> truckList = new DefaultListModel<>();
				truckList.addAll(gereTruck.trucks);
				
				JList<Truck> listTruck = new JList<>(truckList);
				listTruck.setLayoutOrientation(JList.VERTICAL);
				
				JOptionPane.showMessageDialog(frame, listTruck, "Camiões", JOptionPane.INFORMATION_MESSAGE);
				
				if (listTruck.getSelectedIndex() > -1) {
					drawTruckMenu(gereTruck.trucks.get(listTruck.getSelectedIndex()), listTruck.getSelectedIndex());
				}
			}
		});
		
		JButton addBox = new JButton(addBoxIcon);
		addBox.setOpaque(false);
		addBox.setContentAreaFilled(false);
		addBox.setBorderPainted(false);
		addBox.setFocusPainted(false);
		addBox.setBounds(330, 290, 100, 100);
		addBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				return;
			}
		});
		
		JButton showTruck = new JButton(truckIcon);
		showTruck.setOpaque(false);
		showTruck.setContentAreaFilled(false);
		showTruck.setBorderPainted(false);
		showTruck.setFocusPainted(false);
		showTruck.setBounds(240, 220, 600, 313);
		showTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				return;
			}
		});
		
		frame.add(addTruck);
		frame.add(manageTruck);
		frame.add(imagem);
		frame.setSize(1020,600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Projeto");
		frame.setIconImage(icon.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
	}
	
	public void drawTruckMenu(Truck truck, int option) {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 1020, 600);
		
		JLabel label = new JLabel("Camião " + (option + 1));
		label.setBounds(500,150,200,50);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		
		JButton addTruck = new JButton(addTruckIcon);
		addTruck.setOpaque(false);
		addTruck.setContentAreaFilled(false);
		addTruck.setBorderPainted(false);
		addTruck.setFocusPainted(false);
		addTruck.setBounds(800, 400, 176, 130);
		addTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entrada = JOptionPane.showInputDialog(frame ,"Volume máximo", 
						"Camião " + (gereTruck.trucks.size() + 1), JOptionPane.INFORMATION_MESSAGE);
				if (entrada == null) {
					return;
				}
				if (entrada.isEmpty()) {
					return;
				}
				int volume = Integer.parseInt(entrada);
			    if (volume < 1 || volume > 10000) {
			    	showError("Valor inválido");
			    	return;
			    } else {
			    	Truck truck = new Truck(truckState.LOADING, volume);
			    	gereTruck.trucks.add(truck);
			    }
			}
		});
		
		JButton manageTruck = new JButton(manageTruckIcon);
		manageTruck.setOpaque(false);
		manageTruck.setContentAreaFilled(false);
		manageTruck.setBorderPainted(false);
		manageTruck.setFocusPainted(false);
		manageTruck.setBounds(805, 420, 150, 110);
		manageTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gereTruck.trucks.size() < 1) {
					showError("Não há camiões no armazem");
					return;
				}
				
				DefaultListModel<Truck> truckList = new DefaultListModel<>();
				truckList.addAll(gereTruck.trucks);
				
				JList<Truck> listTruck = new JList<>(truckList);
				listTruck.setLayoutOrientation(JList.VERTICAL);
				
				JOptionPane.showMessageDialog(frame, listTruck, "Camiões", JOptionPane.INFORMATION_MESSAGE);
				
				if (listTruck.getSelectedIndex() > -1) {
					drawTruckMenu(gereTruck.trucks.get(listTruck.getSelectedIndex()), listTruck.getSelectedIndex());
				}
			}
		});
		
		JButton addBox = new JButton(addBoxIcon);
		addBox.setOpaque(false);
		addBox.setContentAreaFilled(false);
		addBox.setBorderPainted(false);
		addBox.setFocusPainted(false);
		addBox.setBounds(330, 290, 100, 100);
		addBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				DefaultListModel<Box> boxList = new DefaultListModel<>();
				boxList.addAll(truck.getCaixas());
				
				JList<Box> listBox = new JList<>(boxList);
				listBox.setLayoutOrientation(JList.VERTICAL);
				
				Object[] options = { "Adicionar", "Remover", "Cancelar" };
				
		        int result = JOptionPane.showOptionDialog(frame, listBox, "Caixas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		        
		        if (result == JOptionPane.YES_OPTION){
		        	JTextField ref2 = new JTextField();
		        	JTextField peso2 = new JTextField();
		        	JTextField comprimento2 = new JTextField();
		        	JTextField altura2 = new JTextField();
		        	JTextField largura2 = new JTextField();
		        	
		        	Object[] message = {
		        	    "Referencia:", ref2,
		        	    "Peso:", peso2,
		        	    "Comprimento:", comprimento2,
		        	    "Altura:", altura2,
		        	    "Comprimento:", largura2
		        	};

		        	int option = JOptionPane.showConfirmDialog(frame, message, "Caixas", JOptionPane.OK_CANCEL_OPTION);
		        	
		        	if (ref2.getText().equals("")) {
						showError("Insira referencia");
						return;
					}
		        	if (peso2.getText().equals("")) {
						showError("Insira um peso");
						return;
					}
		        	if (comprimento2.getText().equals("")) {
						showError("Insira um comprimento");
						return;
					}
		        	if (altura2.getText().equals("")) {
						showError("Insira uma altura");
						return;
					}
		        	if (largura2.getText().equals("")) {
						showError("Insira uma largura");
						return;
					}
		        	
		        	String largura1 = largura2.getText();
		        	int largura = Integer.parseInt(largura1);

		        	String altura1 = altura2.getText();
		        	int altura = Integer.parseInt(altura1);

		        	String comprimento1 = comprimento2.getText();
		        	int comprimento = Integer.parseInt(comprimento1);

		        	String peso1 = peso2.getText();
		        	int peso = Integer.parseInt(peso1);

		        	String reference = ref2.getText();
		        	
		        	if (option == JOptionPane.OK_OPTION) {
		        		gereTruck.addBox(reference, peso, comprimento, altura, largura, truck);
		        	    return;
		        	} else {
		        		return;
		        	}
		        }
			}
		});
		
		JButton showTruck = new JButton(truckIcon);
		showTruck.setOpaque(false);
		showTruck.setContentAreaFilled(false);
		showTruck.setBorderPainted(false);
		showTruck.setFocusPainted(false);
		showTruck.setBounds(240, 220, 600, 313);
		showTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				return;
			}
		});
		
		JButton back = new JButton("<<<");
		back.setBounds(20,20,70,20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Arial", Font.BOLD, 14));
		back.setOpaque(true);
		back.setContentAreaFilled(false);
		back.setBorderPainted(true);
		back.setFocusPainted(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawMainMenu();
			}
		});
		
		frame.add(back);
		frame.add(label);
		frame.add(addBox);
		frame.add(manageTruck);
		frame.add(showTruck);
		frame.add(imagem);
		frame.setSize(1020,600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Projeto");
		frame.setIconImage(icon.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	public static void main(String[] args) {
		Main menu = new Main();
		menu.drawMainMenu();
	}

}
