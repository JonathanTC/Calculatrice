import java.awt.Color;
import java.awt.Font;

public class BoutonDigit extends Bouton {

	public BoutonDigit(String pName)
	{
		super(pName);
		baseColor = Color.WHITE;
		this.setBackground(baseColor);
		this.setFont(new Font("Arial", Font.BOLD, 16));
	}
}
