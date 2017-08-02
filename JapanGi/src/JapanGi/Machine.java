package JapanGi;

        import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class Machine {

    static JPanel mainPanel = new JPanel();
    static JPanel bottomPanel = new JPanel();
    static JLabel title = new JLabel();
    static JLabel ON;
    static JProgressBar bar;
    static ImageIcon on, off;

    public Machine(){
    	JPanel jp = new JPanel();
    	bar = new JProgressBar();
    	bar.setMinimum(0);
    	bar.setMaximum(100);
    	bar.setValue(0);
    	bar.setPreferredSize(new Dimension(555,70)); //사이즈
//    	bar.setStringPainted(true); //퍼센트 표시
    	bar.setForeground(new Color(243, 182, 0));
//    	bar.setBackground(Color.WHITE);
    	bar.setFont(new Font("Courier", Font.BOLD, 50));
    	bar.setBorder(new LineBorder(Color.black));
    	
    	on = new ImageIcon("imgs/signal0.gif");
        off = new ImageIcon("imgs/signal1.gif");
        ON = new JLabel(on);
        
        jp.add(bar);
        jp.setBackground(new Color(53, 53, 53));
        
        bottomPanel.setLayout(new BorderLayout(15, 5));
        bottomPanel.add(jp, BorderLayout.WEST);
        bottomPanel.add(ON, BorderLayout.CENTER);
        bottomPanel.setBackground(new Color(53, 53, 53)); // 색 수정
        
        title.setText("MINI STARBUCKS");
        title.setForeground(Color.white);
        title.setFont(new Font("Courier", Font.BOLD, 50)); // 폰트 크기 수정
        mainPanel.setBackground(new Color(0,153,0)); // 색 수정
        mainPanel.add(title);
    }
    
    public static void go(String name, Icon img) { 
    	new Thread(){ // 프로그레스 & 메시지 박스 & 신호
			public void run(){
				try        { 
					ON.setIcon(off);
					for(int i=0;i<=100;i++) { 
						bar.setValue(i); 
						Thread.sleep(30); 
					} 
					JOptionPane.showMessageDialog(null, name + " 가 완성되었습니다", "가져가세요", -1, img);
					ON.setIcon(on);
					bar.setValue(0);
				} 
				catch (InterruptedException e) {} 
			}
		}.start();
    } 
    
//    public static void showResult(String name, Icon img){
//    	JFrame frm = new JFrame("가져가세요");
//    	Container ct = frm.getContentPane();
//    	JLabel lb1 = new JLabel(name + " 가 완성되었습니다 !!");
//    	JLabel lb2 = new JLabel();
//    	lb2.setIcon(img);
//    	
//    	lb2.setHorizontalAlignment(JLabel.CENTER);
//    	lb1.setForeground(Color.white);
//        lb1.setFont(new Font("Courier", Font.BOLD, 20));
//        lb1.setHorizontalAlignment(JLabel.CENTER);
//        
//    	ct.setLayout(new BorderLayout());
//    	ct.add(lb1, BorderLayout.NORTH);
//    	ct.add(lb2, BorderLayout.CENTER);
//    	
//    	ct.setBackground(Color.black);
//    	frm.pack();
//    	frm.setLocation(700, 400);
//    	frm.setVisible(true);
//    }
    
}

