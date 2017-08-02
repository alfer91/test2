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
		
		setTitle("자판기");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocation(500, 200);

	}

	public void initCenter(){

		pd[0] = new Product("아메리카노", 500);
		pd[1] = new Product("카페라테", 500);
		pd[2] = new Product("카라멜마끼야또", 500);
		pd[3] = new Product("율무차", 300);
		pd[4] = new Product("유자차", 300);
		pd[5] = new Product("동글레차", 300);

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
					JOptionPane.showMessageDialog(null, "만드는 중입니다 ...", "기다리세요", 0);
			}
		}

		if(e.getSource() == mn.inbtn) {
			String strIn = mn.in.getText(); 
			try {
				if(Integer.parseInt(strIn)<0)
					throw new Exception();

				Money.inputMoney(Integer.parseInt(strIn)); // 문자열을 숫자로
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "잘못 넣었습니다 !!", "금액 오류", 0);
			}

			mn.out.setText(String.valueOf(df.format(Money.currentMoney))); // 숫자를 문자열로
			mn.in.setText("");				
		}

		if(e.getSource() == mn.outbtn) {
			JOptionPane.showMessageDialog(null, "잔액 " + mn.out.getText() + " 원이 나왔습니다 !!", "잔액 반환", -1);
			mn.out.setText("");
			Money.currentMoney = 0;
		}

	}

	public static void main(String[] args) {
		new Ui();
	}

}
