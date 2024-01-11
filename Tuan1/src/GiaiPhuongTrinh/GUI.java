package GiaiPhuongTrinh;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	public JLabel t;
	public JButton b1, b2, b3;
	public JTextField t1, t2, t3, tr;
	
	public GUI() {
		super("^-^");
		
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		
		JPanel title = new JPanel();
		title.add(t = new JLabel("Giải phương trình bậc hai"));
		t.setFont(new Font("Arial", Font.BOLD, 25));
		title.setBackground(Color.cyan);
		
		Box center = Box.createVerticalBox();
		Box box1 = Box.createHorizontalBox();
		box1.add(Box.createHorizontalStrut(30));
		box1.add(new JLabel("Nhập a: "));
		box1.add(Box.createHorizontalStrut(10));
		box1.add(t1 = new JTextField(10));
		box1.add(Box.createHorizontalStrut(30));
		t1.setMaximumSize(new Dimension(Integer.MAX_VALUE, t1.getMinimumSize().height));
		Box box2 = Box.createHorizontalBox();
		box2.add(Box.createHorizontalStrut(30));
		box2.add(new JLabel("Nhập b: "));
		box2.add(Box.createHorizontalStrut(10));
		box2.add(t2 = new JTextField(10));
		box2.add(Box.createHorizontalStrut(30));
		t2.setMaximumSize(new Dimension(Integer.MAX_VALUE, t1.getMinimumSize().height));
		Box box3 = Box.createHorizontalBox();
		box3.add(Box.createHorizontalStrut(30));
		box3.add(new JLabel("Nhập c: "));
		box3.add(Box.createHorizontalStrut(10));
		box3.add(t3 = new JTextField(10));
		box3.add(Box.createHorizontalStrut(30));
		t3.setMaximumSize(new Dimension(Integer.MAX_VALUE, t1.getMinimumSize().height));
		Box box4 = Box.createHorizontalBox();
		box4.add(Box.createHorizontalStrut(30));
		box4.add(new JLabel("Kết quả: "));
		box4.add(Box.createHorizontalStrut(10));
		box4.add(tr = new JTextField(10));
		box4.add(Box.createHorizontalStrut(30));
		tr.setMaximumSize(new Dimension(Integer.MAX_VALUE, t1.getMinimumSize().height));
		tr.setEditable(false);
		tr.setBorder(BorderFactory.createLineBorder(Color.cyan));
		
		//center.add(Box.createVerticalStrut(10));
		center.add(box1);
		//center.add(Box.createVerticalStrut(10));
		center.add(box2);
		//center.add(Box.createVerticalStrut(10));
		center.add(box3);
		center.add(box4);
		
		JPanel buttons = new JPanel();
		buttons.add(b1 = new JButton("Giải"));
		buttons.add(b2 = new JButton("Xóa"));
		buttons.add(b3 = new JButton("Thoát"));
		buttons.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		jp.add(title, BorderLayout.NORTH);
		jp.add(buttons, BorderLayout.SOUTH);
		jp.add(center, BorderLayout.CENTER);
		
		add(jp);
		setSize(430, 300);
		setVisible(true);
	}
	
	public static void main(String[] argv) {
		new GUI();
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == b1) {
			if (t1.getText().equals("")) {
				tr.setText("Nhập thiếu a");
				tr.setForeground(Color.red);
				t1.requestFocus();
			} else if (!t1.getText().matches("-?\\d+(\\.\\d+)?")) {
				tr.setText("Nhập sai a");
				tr.setForeground(Color.red);
				t1.selectAll();	
				t1.requestFocus();
			} else if (t2.getText().equals("")) {
				tr.setText("Nhập thiếu b");
				tr.setForeground(Color.red);
				t1.requestFocus();
			} else if (!t2.getText().matches("-?\\d+(\\.\\d+)?")) {
				tr.setText("Nhập sai b");
				tr.setForeground(Color.red);
				t2.selectAll();
				t2.requestFocus();
			} else if (t3.getText().equals("")) {
				tr.setText("Nhập thiếu c");
				tr.setForeground(Color.red);
				t3.requestFocus();
			} else if (!t3.getText().matches("-?\\d+(\\.\\d+)?")) {
				tr.setText("Nhập sai c");
				tr.setForeground(Color.red);
				t3.selectAll();
				t3.requestFocus();
			} else {
				tr.setForeground(Color.black);
				int a = Integer.parseInt(t1.getText());
				int b = Integer.parseInt(t2.getText());
				int c = Integer.parseInt(t3.getText());
				if (a == 0 && b == 0 && c == 0) {
					tr.setText("Vô số nghiệm");
				} else if (a == 0 && b == 0 && c != 0) {
					tr.setText("Vô nghiệm");
				} else if (a == 0) {
					tr.setText("x = " + String.valueOf((double) -c/b));
				} else {
					double d = b*b - 4*a*c;
					if (d > 0) {
						tr.setText("x1 = " + String.valueOf((double)(-b - Math.sqrt(d))/(2*a)) + 
								"; x2 = " + String.valueOf((double)(-b + Math.sqrt(d))/(a*2)));
					} else if (d == 0) {
						tr.setText("x = " + String.valueOf((double) -b/(2*a)));
					} else {
						tr.setText("Vô nghiệm");
					}
				}
			}
		} else if (source == b2) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			tr.setText("");
			t1.requestFocus();
		} else if (source == b3) {
			this.dispose();
		}
	}
}