package JapanGi;


import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;


public class Money {

	static JPanel Containel4;
	JPanel Containel3;
	JPanel Containel2;
	JPanel Containel;
	JLabel txt, txt1;
	JTextField in,out;
	JButton inbtn,outbtn;
	static long currentMoney = 0;


	public Money(){

		Containel = new JPanel();
		txt = new JLabel("돈을 넣어주세요");
		in = new JTextField(10);

		Containel2 = new JPanel();

		inbtn = new JButton("투입");
		outbtn = new JButton("잔돈받기");

		Containel3 = new JPanel();
		txt1 = new JLabel("현재 금액");
		out = new JTextField(10);
		out.setEditable(false);
		
		Containel.add(txt);
		Containel.add(in);
		Containel.setBackground(new Color(213, 213, 213)); // 배경 수정
		Containel2.add(inbtn);
		Containel2.add(outbtn);
		Containel2.setBackground(new Color(213, 213, 213)); // 배경 수정
		Containel3.add(txt1);
		Containel3.add(out);
		Containel3.setBackground(new Color(213, 213, 213)); // 배경 수정
		
		Containel4 = new JPanel();
		Containel4.setLayout(new BoxLayout(Containel4, BoxLayout.Y_AXIS));
		
		Containel4.add(new Box.Filler(new Dimension(0,0), new Dimension(0, 150), new Dimension(0, 150)));
		Containel4.add(Containel);
		Containel4.add(Containel2);
		Containel4.add(Containel3);
		Containel4.add(new Box.Filler(new Dimension(0,0), new Dimension(0, 150), new Dimension(0, 150)));
		Containel4.setBorder(new TitledBorder(new LineBorder(Color.black),"결제")); // 테두리 설정
		Containel4.setBackground(new Color(213, 213, 213)); // 배경 수정
	}

	public static void inputMoney(long input)
	{
		currentMoney += input;
	}

	public static boolean buyMenu(long price) {
		boolean isOver = false;
		
		if(currentMoney - price >= 0)
		{
			currentMoney -= price;
			isOver = false;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "금액 초과 !!", "금액 초과", 0);
			isOver = true;
		}
		
		return isOver;
	}
}





