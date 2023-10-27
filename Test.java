import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class Test extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];
	public static int timer=200;

	// create jFrame with radioButton and JButton
	Test(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		String time="Time left: "+timer+" seconds left";
		g.setColor(Color.BLUE);
		if (timer>0){
			g.drawString(time,450,200);
			g.setFont(new Font("",Font.BOLD,20));

		}
		timer--;
		try{
			Thread.sleep(1000);
			repaint();
		}
		catch(Exception e){
			e.printStackTrace();
		}

		
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1: Miura-1 rocket launched by which country?");
			radioButton[0].setText("China");
			radioButton[1].setText("Japan");
			radioButton[2].setText("Spain");
			radioButton[3].setText("Brazil");
		}
		if (current == 1) {
			label.setText("Que2: Which team has won gold medal in Men's Cricket Category at Asian Games 2023?");
			radioButton[0].setText("India");
			radioButton[1].setText("Pakistan");
			radioButton[2].setText("Nepal");
			radioButton[3].setText("Sri Lanka");
		}
		if (current == 2) {
			label.setText("Que3:In January 2022,which country took over the G7 presidency? ");
			radioButton[0].setText("Netherlands");
			radioButton[1].setText("Germany");
			radioButton[2].setText("Austria");
			radioButton[3].setText("France");
		}
		if (current == 3) {
			label.setText("Que4: Which of the following country is not a menber of SAARC?");
			radioButton[0].setText("Nepal");
			radioButton[1].setText("Maldives");
			radioButton[2].setText("China");
			radioButton[3].setText("Afghanistan");
		}
		if (current == 4) {
			label.setText("Que5:  In December 2021,who among the following has been named as Times'2021 Athlete of the year?");
			radioButton[0].setText(" Tom Brady");
			radioButton[1].setText("Serena Williams");
			radioButton[2].setText("Lewis Hamilton");
			radioButton[3].setText("Simone Biles");
		}
		if (current == 5) {
			label.setText("Que6: Who has been crowned Miss Universe 2021?");
			radioButton[0].setText("Roshanara Ebrahim");
			radioButton[1].setText("Noa Kochba");
			radioButton[2].setText("Harnaaz Sandhu");
			radioButton[3].setText("Nandita Banna");
		}
		if (current == 6) {
			label.setText("Que7:  Which bridge connects Dibrugarh in Assam to Pasighat in Arunachal Pradesh?");
			radioButton[0].setText("Naini");
			radioButton[1].setText("Bogibeel");
			radioButton[2].setText("Coronation");
			radioButton[3].setText("Pamban");
		}
		if (current == 7) {
			label.setText("Que8:  Who has been appointed the new Vice-Chairmman of NITI Aayog in 2022?");
			radioButton[0].setText("Suman Bery");
			radioButton[1].setText("Promila Jaspal");
			radioButton[2].setText("Manoj Soni");
			radioButton[3].setText("Vikram Singh Mehta");
		}
		if (current == 8) {
			label.setText("Que9: Which country is the host of the 'FIDE World Championship 2023'?");
			radioButton[0].setText("Kazakhstan");
			radioButton[1].setText("Italy");
			radioButton[2].setText("Israel");
			radioButton[3].setText("India");
		}
		if (current == 9) {
			label.setText("Que10: India's lunar mission Chandrayaan 3 was launched on ?");
			radioButton[0].setText("July 14");
			radioButton[1].setText("July 20");
			radioButton[2].setText("June 14");
			radioButton[3].setText("June 20");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[2].isSelected());
		if (current == 1)
			return (radioButton[0].isSelected());
		if (current == 2)
			return (radioButton[1].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[3].isSelected());
		if (current == 5)
			return (radioButton[2].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[0].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
        Scanner sc =new Scanner(System.in);
		String name;
		System.out.println("enter your name");
		name=sc.nextLine();
		System.out.println("Welcome to the Quiz "+name);
		new Test("Quiz APP");

	}

}

