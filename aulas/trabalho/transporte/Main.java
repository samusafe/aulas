package transporte;
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
				String entrada = JOptionPane.showInputDialog(null ,"Volume máximo", 
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
				return;
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
		errorFrame.setResizable(false);
		errorFrame.setVisible(true);
	}

	public static void main(String[] args) {
		Main menu = new Main();
		menu.drawMainMenu();
	}

}
