package JapanGi;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Timer;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.*;

public class Ui extends JFrame implements ActionListener{ //////////////////// aa

	Product[] pd = new Product[6];
	Money mn = new Money();
	Machine mc = new Machine();

	public Ui(){

		initCenter();

		mn.inbtn.addActionListener(this);
		mn.outbtn.addActionListener(this);

		setLayout(new BorderLayout());

		add(Machine.mainPanel, BorderLayout.NORTH);
		add(Product.center, BorderLayout.CENTER);
		add(Money.Containel4, BorderLayout.EAST);
		add(Machine.bottomPanel, BorderLayout.SOUTH);
		
		setTitle("���Ǳ�");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocation(500, 200);

	}

	public void initCenter(){

		pd[0] = new Product("�Ƹ޸�ī��", 500);
		pd[1] = new Product("ī�����", 500);
		pd[2] = new Product("ī��Ḷ���߶�", 500);
		pd[3] = new Product("������", 300);
		pd[4] = new Product("������", 300);
		pd[5] = new Product("���۷���", 300);

		for(int i=0; i<6; i++)
			pd[i].setImg(new ImageIcon("imgs/btn" + i + ".gif"));

		Product.initTitle();

		for(int i=0; i<3; i++)
			pd[i].initButton(1);
		for(int i=3; i<6; i++)
			pd[i].initButton(2);

		for(int i=0; i<6; i++)
			pd[i].btn.addActionListener(this);

		Product.setDesign();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DecimalFormat df = new DecimalFormat("#,###");

		for(int i=0; i<6; i++)
		{
			if(e.getSource() == pd[i].btn)
			{
				if(Machine.ON.getIcon().equals(Machine.on))
				{
					boolean isOver = Money.buyMenu(pd[i].getPrice());
					mn.out.setText(String.valueOf(df.format(Money.currentMoney)));

					if(!isOver){
						Machine.go(pd[i].name, pd[i].getImg());
					}
				}
				else
					JOptionPane.showMessageDialog(null, "����� ���Դϴ� ...", "��ٸ�����", 0);
			}
		}

		if(e.getSource() == mn.inbtn) {
			String strIn = mn.in.getText(); 
			try {
				if(Integer.parseInt(strIn)<0)
					throw new Exception();

				Money.inputMoney(Integer.parseInt(strIn)); // ���ڿ��� ���ڷ�
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "�߸� �־����ϴ� !!", "�ݾ� ����", 0);
			}

			mn.out.setText(String.valueOf(df.format(Money.currentMoney))); // ���ڸ� ���ڿ���
			mn.in.setText("");				
		}

		if(e.getSource() == mn.outbtn) {
			JOptionPane.showMessageDialog(null, "�ܾ� " + mn.out.getText() + " ���� ���Խ��ϴ� !!", "�ܾ� ��ȯ", -1);
			mn.out.setText("");
			Money.currentMoney = 0;
		}

	}

	public static void main(String[] args) {
		new Ui();
	}

}
