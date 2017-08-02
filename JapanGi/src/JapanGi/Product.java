package JapanGi;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Product {
	static JPanel center, jpT1, jpT2, jpBtn1, jpBtn2;
	static JLabel lbT1, lbT2;
	JButton btn;
	ImageIcon img;
	String name;
	int price;

	static{
		center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		
		jpT1 = new JPanel();
		jpT2 = new JPanel();
		jpBtn1 = new JPanel();
		jpBtn2 = new JPanel();
	}
	
	public void setImg(ImageIcon img) {
		this.img = img;
	}
	
	public ImageIcon getImg() {
		return img;
	}

	public int getPrice() {
		return price;
	}

	public Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	
	public static void initTitle()
	{
		jpT1.setBackground(Color.white);

		lbT1 = new JLabel("C O F F E E");
		lbT1.setForeground(Color.red);
		lbT1.setFont(new Font("Courier", Font.BOLD, 30));
		
		jpT2.setBackground(Color.white);

		lbT2 = new JLabel("T E A");
		lbT2.setForeground(Color.red);
		lbT2.setFont(new Font("Courier", Font.BOLD, 30));

		jpT1.add(lbT1);
		jpT2.add(lbT2);
		jpT2.add(lbT2);
	}

	public void initButton(int jpBtn)
	{
		btn = new JButton(name + " " + price + "¿ø", img);
		btn.setHorizontalTextPosition(AbstractButton.CENTER);
		btn.setVerticalTextPosition(AbstractButton.BOTTOM);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false); 
		
		if(jpBtn == 1)
			jpBtn1.add(btn);
		else if(jpBtn == 2)
			jpBtn2.add(btn);
	}
	
	public static void setDesign()
	{
		center.add(jpT1);
		center.add(jpBtn1);
		center.add(jpT2);
		center.add(jpBtn2);
	}
}
