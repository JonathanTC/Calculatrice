import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Fenetre extends JFrame implements ActionListener {
	
	private JPanel container, containerNumbers, containerOperator, containerResult;
	private JButton bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8, bouton9, bouton0, boutonPoint, boutonEqual;
	private JButton reset, addition, soustraction, multiplication, division;
	private JLabel label, view;
	
	private Double resultat = 0d;
	private String nombre = "";
	private char lastOperator;
	
	private Boolean nouveau = true;
	
	public Fenetre(String pName)
	{
		super(pName);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);

		BorderLayout layout = new BorderLayout();
		layout.setHgap(8);
		layout.setVgap(10);
		
		container = new JPanel();
		container.setLayout(layout);
		container.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		containerResult = new JPanel();
		containerResult.setPreferredSize(new Dimension(this.getWidth(), 75));
		containerResult.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		containerResult.setLayout(new BorderLayout());
		container.add(containerResult, BorderLayout.NORTH);
		
		/*
		 * Création du label pour visualiser l'opération
		 */
		
		view = new JLabel();
		view.setPreferredSize(new Dimension(this.getWidth(),25));
		view.setHorizontalAlignment(JLabel.RIGHT);
		view.setFont(new Font("Arial", Font.PLAIN, 15));
		
		containerResult.add(view, BorderLayout.NORTH);
		
		/*
		 * Création du label de resultat
		 */
		
		label = new JLabel(resultat.toString());
		label.setPreferredSize(new Dimension(this.getWidth(),50));
		label.setHorizontalAlignment(JLabel.RIGHT);
		label.setFont(new Font("Arial", Font.BOLD, 30));
		
		containerResult.add(label, BorderLayout.CENTER);
		
		/* 
		 * Création du pavé numérique
		 */
	
		GridLayout grid = new GridLayout(4, 3);
		grid.setHgap(5);
		grid.setVgap(5);
		
		containerNumbers = new JPanel();
		containerNumbers.setLayout(grid);
		
		bouton1 = new BoutonDigit("1"); containerNumbers.add(bouton1); bouton1.addActionListener(new input("1"));
		bouton2 = new BoutonDigit("2"); containerNumbers.add(bouton2); bouton2.addActionListener(new input("2"));
		bouton3 = new BoutonDigit("3"); containerNumbers.add(bouton3); bouton3.addActionListener(new input("3"));
		bouton4 = new BoutonDigit("4"); containerNumbers.add(bouton4); bouton4.addActionListener(new input("4"));
		bouton5 = new BoutonDigit("5"); containerNumbers.add(bouton5); bouton5.addActionListener(new input("5"));
		bouton6 = new BoutonDigit("6"); containerNumbers.add(bouton6); bouton6.addActionListener(new input("6"));
		bouton7 = new BoutonDigit("7"); containerNumbers.add(bouton7); bouton7.addActionListener(new input("7"));
		bouton8 = new BoutonDigit("8"); containerNumbers.add(bouton8); bouton8.addActionListener(new input("8"));
		bouton9 = new BoutonDigit("9"); containerNumbers.add(bouton9); bouton9.addActionListener(new input("9"));
		bouton0 = new BoutonDigit("0"); containerNumbers.add(bouton0); bouton0.addActionListener(new input("0"));
		boutonPoint = new Bouton("."); containerNumbers.add(boutonPoint); boutonPoint.addActionListener(new input(".")); 
		boutonEqual = new Bouton("="); containerNumbers.add(boutonEqual); boutonEqual.addActionListener(this);
		
		container.add(containerNumbers, BorderLayout.CENTER);
		
		/* 
		 * Création des opérateurs
		 */		
		
		grid = new GridLayout(5, 1);
		grid.setHgap(5);
		grid.setVgap(5);
		
		containerOperator = new JPanel();
		containerOperator.setLayout(grid);
		containerOperator.setPreferredSize(new Dimension(80, 50));
		
		reset = new Bouton("C"); containerOperator.add(reset); reset.addActionListener(this);
		addition = new Bouton("+"); containerOperator.add(addition); addition.addActionListener(new operation('+'));
		soustraction = new Bouton("-"); containerOperator.add(soustraction); soustraction.addActionListener(new operation('-'));
		multiplication = new Bouton("*"); containerOperator.add(multiplication); multiplication.addActionListener(new operation('*'));
		division = new Bouton("/"); containerOperator.add(division); division.addActionListener(new operation('/'));
		
		container.add(containerOperator, BorderLayout.EAST);
		
		this.setContentPane(container);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == reset) {
			resultat = 0.0d;
			nombre = "";
			label.setText(resultat.toString());
			view.setText("");
			
			nouveau = true;
		}
		
		if(e.getSource() == boutonEqual)
		{
			if(!nouveau)
			{
				switch(lastOperator)
				{
					case '+' : resultat = resultat + Double.parseDouble(nombre); break;
					case '-' : resultat = resultat - Double.parseDouble(nombre); break;
					case '*' : resultat = resultat * Double.parseDouble(nombre); break;
					case '/' : resultat = resultat / Double.parseDouble(nombre); break;
					default: break;
				}
				
				label.setText(resultat.toString());
				view.setText("");
				
				nombre = resultat.toString();
				nouveau = true;
			}
		}
	}
	
	class operation implements ActionListener
	{
		private char operator;
		
		public operation(char pOperator) {
			operator = pOperator;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(nouveau)
			{
				nouveau = false;
				resultat = Double.parseDouble(nombre);
				
				view.setText(nombre + " " + operator + " ");
				nombre = "";
				
				lastOperator = operator;
			}
			else
			{
				switch(lastOperator)
				{
					case '+' : resultat = resultat + Double.parseDouble(nombre); break;
					case '-' : resultat = resultat - Double.parseDouble(nombre); break;
					case '*' : resultat = resultat * Double.parseDouble(nombre); break;
					case '/' : resultat = resultat / Double.parseDouble(nombre); break;
					default: break;
				}
				
				view.setText(view.getText() + nombre + " " + operator + " ");
				nombre = "";
				label.setText(resultat.toString());
				
				lastOperator = operator;
			}
			
		}
		
	}
	
	class input implements ActionListener
	{
		private String value;
		
		public input(String pValue)
		{
			value = pValue;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			nombre += value;
			label.setText(nombre);
		}
	}
}