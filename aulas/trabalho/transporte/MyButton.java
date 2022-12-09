package transporte;

import javax.swing.Icon;
import javax.swing.JButton;

public class MyButton extends JButton {
	
	public MyButton(Icon icon) {
		super(null, icon);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
	}
}
