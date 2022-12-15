package transporte;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import enums.TruckState;

public class Main {
	
	private MyFrame frame = new MyFrame("Projeto");
	private ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/img/warehouse.jpg"));
	private ImageIcon addTruckIcon = new ImageIcon(getClass().getResource("/img/add_truck.png"));
	private ImageIcon manageTruckIcon = new ImageIcon(getClass().getResource("/img/manage_truck.png"));
	private ImageIcon addBoxIcon = new ImageIcon(getClass().getResource("/img/add_box.png"));
	private ImageIcon truckIcon = new ImageIcon(getClass().getResource("/img/truck.png"));
	private GereTruck gereTruck = new GereTruck();
	
	public void drawMainMenu() {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 1020, 600);
		
		MyButton addTruck = new MyButton(addTruckIcon);
		addTruck.setBounds(800, 400, 176, 130);
		addTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawAddTruckMenu();
			}
		});
		
		MyButton manageTruck = new MyButton(manageTruckIcon);
		manageTruck.setBounds(805, 290, 150, 110);
		manageTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawManageTruckMenu();
			}
		});
		
		frame.add(addTruck);
		frame.add(manageTruck);
		frame.add(imagem);
		frame.repaint();
	}
	
	public void drawAddTruckMenu() {
		JTextField vol2 = new JTextField();
    	JTextField pes2 = new JTextField();
    	
    	Object[] message = {
    	    "Volume:", vol2,
    	    "Peso:", pes2,
    	};

    	int option = JOptionPane.showConfirmDialog(frame, message, "Camiões", JOptionPane.OK_CANCEL_OPTION);
    	
    	if (option == JOptionPane.CLOSED_OPTION) {
    		return;
    	}
    	
    	if (vol2.getText().equals("")) {
			showError("Insira um volume");
			return;
		}
    	if (pes2.getText().equals("")) {
			showError("Insira um peso");
			return;
		}
    	
    	String volume2 = vol2.getText();
    	int volume = Integer.parseInt(volume2);
    	
    	String peso2 = pes2.getText();
    	int peso = Integer.parseInt(peso2);

	    if (volume < 1 || volume > 10000) {
	    	showError("Valor inválido");
	    	return;
	    } else if (peso < 1 || peso > 10000) {
	    	showError("Valor inválido");
	    	return;
	    } else {
	    	gereTruck.createTruck(volume, peso);
	    }
	}
	
	public void drawTruckMenu(Truck truck, int option) {
		frame.getContentPane().removeAll();
		
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 1020, 600);
		
		JLabel label = new JLabel("Camião " + (option + 1));
		label.setBounds(500,150,200,50);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		
		MyButton manageTruck = new MyButton(manageTruckIcon);
		manageTruck.setBounds(805, 420, 150, 110);
		manageTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawManageTruckMenu();
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
				
				Object[] options = { "Adicionar", "Retirar", "Cancelar" };
				
		        int result = JOptionPane.showOptionDialog(frame, listBox, "Caixas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		        
		        if (result == JOptionPane.YES_OPTION){
		        	if (truck.getTruckState().equals(TruckState.IN_TRANSIT) || truck.getTruckState().equals(TruckState.DELIVERED)) {
		    			showError("Não pode ser modificado neste estado");
		    			return;
		    		}
		        	
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
		        	
		        	if (option == JOptionPane.CLOSED_OPTION) {
		        		return;
		        	}
		        	
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
		        	}
		        }
		        if (result == JOptionPane.NO_OPTION) {
		        	if (truck.getTruckState().equals(TruckState.IN_TRANSIT)) {
		    			showError("Não pode ser modificado neste estado");
		    			return;
		    		}
		        	if (listBox.getSelectedIndex() != -1) {
		        		gereTruck.takeBox(truck, listBox.getSelectedIndex());
		        	} else {
		        		showError("Seleciona uma caixa");
		        		return;
		        	}
		        }
			}
		});
		
		MyButton showTruck = new MyButton(truckIcon);
		showTruck.setBounds(240, 220, 600, 313);
		
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
		frame.repaint();
	}
	
	public void drawManageTruckMenu() {
		JLabel imagem = new JLabel(backgroundImage);
		imagem.setBounds(0, 0, 1020, 600);
		
		if (gereTruck.trucks.size() < 1) {
			showError("Não há camiões no armazem");
			return;
		}
	
		String[] choices = { "LOADING", "IN_TRANSIT", "DELIVERED" };
		
		String entrada = (String) JOptionPane.showInputDialog(frame, "Escolha o estado dos camiões", "Camiões", JOptionPane.YES_NO_OPTION, null, choices, null);
		
		if (entrada == "LOADING") {
			drawManageTruckListMenu(TruckState.LOADING);
		} else if (entrada == "IN_TRANSIT") {
			drawManageTruckListMenu(TruckState.IN_TRANSIT);
		} else if (entrada == "DELIVERED") {
			drawManageTruckListMenu(TruckState.DELIVERED);
		}
		
		frame.add(imagem);
		frame.repaint();
	}
	
	public void drawManageTruckListMenu(TruckState truckState) {
		DefaultListModel<Truck> truckList = new DefaultListModel<>();
		truckList.addAll(gereTruck.filterByType(truckState));
		
		JList<Truck> listTruck = new JList<>(truckList);
		listTruck.setLayoutOrientation(JList.VERTICAL);
		
		JScrollPane scrollPane = new JScrollPane();
		JPanel panel = new JPanel();
		
		panel.add(scrollPane);
		scrollPane.getViewport().add(listTruck);
		
		if (gereTruck.filterByType(truckState).size() < 1) {
			showError("Não há camiões nesse estado");
			return;
		}
		
		Object[] options = { "OK", "Modificar" };
		
        int result = JOptionPane.showOptionDialog(frame, scrollPane, "Caixas", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
        
        if (result == JOptionPane.YES_OPTION) {
        	if (listTruck.getSelectedIndex() == -1) {
        		showError("Escolha um camião");
        		return;
        	} else {
        		Truck truck = truckList.get(listTruck.getSelectedIndex());
        		for (int i = 0; i < truckList.size(); i++) {
        			if (truck.equals(truckList.get(i))) {
        				truck = truckList.get(i);
        				drawTruckMenu(truck, truck.getIdentificador());
        			}
        		}
        	}
        } else if (result == JOptionPane.NO_OPTION) {
        	if (listTruck.getSelectedIndex() == -1) {
        		showError("Escolha um camião");
        		return;
        	} else {
        		String[] choices = { "LOADING", "IN_TRANSIT", "DELIVERED" };
        		
        		String entrada = (String) JOptionPane.showInputDialog(frame, "Escolha o estado que pretende definir", "Camiões", JOptionPane.YES_NO_OPTION, null, choices, null);
        		
        		Truck truck = null;
        		for (int i = 0; i < truckList.size(); i++) {
        			if (truckList.get(listTruck.getSelectedIndex()) == truckList.get(i)) {
        				truck = truckList.get(i);
        			}
        		}
        		
        		if (entrada == "LOADING") {
        			if (truck.getTruckState().equals(TruckState.LOADING)) {
        				showError("Ja se encontra nesse estado");
        				return;
        			}
        			truck.setTruckState(TruckState.LOADING);
        		} else if (entrada == "IN_TRANSIT") {
        			if (truck.getTruckState().equals(TruckState.IN_TRANSIT)) {
        				showError("Ja se encontra nesse estado");
        				return;
        			}
        			truck.setTruckState(TruckState.IN_TRANSIT);
        		} else if (entrada == "DELIVERED") {
        			if (truck.getTruckState().equals(TruckState.DELIVERED)) {
        				showError("Ja se encontra nesse estado");
        				return;
        			}
        			truck.setTruckState(TruckState.DELIVERED);
        		}
        	}
		frame.repaint();
        }
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
