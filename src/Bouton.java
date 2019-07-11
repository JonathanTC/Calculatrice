import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener{

	protected Color baseColor = Color.LIGHT_GRAY;
	
	public Bouton(String pName)
	{
		super(pName);
		this.setBorderPainted(false);
		this.addMouseListener(this);
		this.setBackground(baseColor);
		this.setFont(new Font("Arial", Font.PLAIN, 16));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setBackground(Color.GRAY);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setBackground(baseColor);
		
	}
}
