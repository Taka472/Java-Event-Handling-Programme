package CongTruNhanChia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public JLabel title;
	public JPanel p1, p2, p3, box31;
	public JButton b1, b2, b3;
	public JTextField t1, t2, tr;
	public JRadioButton r1, r2, r3, r4;

	public GUI() {
		super("Cộng Trừ Nhân Chia");
		
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		
		JPanel jt = new JPanel();
		jt.add(title = new JLabel("Cộng Trừ Nhân Chia"));
		title.setFont(new Font("Arial", Font.BOLD, 30));
		title.setForeground(Color.blue);
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		Box box1 = Box.createHorizontalBox();
		box1.add(Box.createHorizontalStrut(50));
		box1.add(new JLabel("Nhập a: "));
		box1.add(Box.createHorizontalStrut(20));
		box1.add(t1 = new JTextField());
		box1.add(Box.createHorizontalStrut(50));
		t1.setMaximumSize(new Dimension(Integer.MAX_VALUE, t1.getMinimumSize().height));
		Box box2 = Box.createHorizontalBox();
		box2.add(Box.createHorizontalStrut(50));
		box2.add(new JLabel("Nhập b: "));
		box2.add(Box.createHorizontalStrut(20));
		box2.add(t2 = new JTextField());
		box2.add(Box.createHorizontalStrut(50));
		t2.setMaximumSize(new Dimension(Integer.MAX_VALUE, t1.getMinimumSize().height));
		Box box3 = Box.createHorizontalBox();
		box3.add(Box.createHorizontalStrut(113));
		box3.add(box31 = new JPanel());
		box31.setLayout(new GridLayout(2,2));
		box31.setPreferredSize(new Dimension(200, 200));
		box31.setBorder(BorderFactory.createTitledBorder("Phép tính"));
		box31.add(r1 = new JRadioButton("Cộng", true));
		box31.add(r2 = new JRadioButton("Trừ"));
		box31.add(r3 = new JRadioButton("Nhân"));
		box31.add(r4 = new JRadioButton("Chia"));
		box3.add(Box.createHorizontalStrut(50));
		Box box4 = Box.createHorizontalBox();
		box4.add(Box.createHorizontalStrut(50));
		box4.add(new JLabel("Kết quả: "));
		box4.add(Box.createHorizontalStrut(15));
		box4.add(tr = new JTextField());
		tr.setEditable(false);
		tr.setBorder(BorderFactory.createLineBorder(Color.cyan));
		box4.add(Box.createHorizontalStrut(50));
		tr.setMaximumSize(new Dimension(Integer.MAX_VALUE, t1.getMinimumSize().height));
		ButtonGroup btg = new ButtonGroup();
		btg.add(r1);
		btg.add(r2);
		btg.add(r3);
		btg.add(r4);
		
		center.add(Box.createVerticalStrut(10));
		center.add(box1);
		center.add(Box.createVerticalStrut(10));
		center.add(box2);
		center.add(Box.createVerticalStrut(10));
		center.add(box3);
		center.add(Box.createVerticalStrut(10));
		center.add(box4);
		center.add(Box.createVerticalStrut(10));
		
		JPanel buttons = new JPanel();
		buttons.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		buttons.setPreferredSize(new Dimension(100, 100));
		buttons.add(Box.createVerticalStrut(10));
		buttons.add(b1 = new JButton("Giải"));
		b1.setMaximumSize(new Dimension(Integer.MAX_VALUE, b1.getMinimumSize().height));
		buttons.add(Box.createVerticalStrut(10));
		buttons.add(b2 = new JButton("Xóa"));
		b2.setMaximumSize(new Dimension(Integer.MAX_VALUE, b1.getMinimumSize().height));
		buttons.add(Box.createVerticalStrut(10));
		buttons.add(b3 = new JButton("Thoát"));
		b3.setMaximumSize(new Dimension(Integer.MAX_VALUE, b1.getMinimumSize().height));
		buttons.setBackground(Color.LIGHT_GRAY);
		buttons.setOpaque(true);
		
		
		JPanel footer = new JPanel();
		footer.setBackground(Color.pink);
		footer.add(p1 = new JPanel());
		p1.setBackground(Color.blue);
		footer.add(p2 = new JPanel());
		p2.setBackground(Color.red);
		footer.add(p3 = new JPanel());
		p3.setBackground(Color.yellow);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		jp.add(jt, BorderLayout.NORTH);
		jp.add(footer, BorderLayout.SOUTH);
		jp.add(buttons, BorderLayout.WEST);
		jp.add(center, BorderLayout.CENTER);
		
		add(jp);
		setSize(500, 330);
		setLocation(550, 220);
		setVisible(true);
	}
	
	public static void main(String[] argv) {
		new GUI();
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == b1) {
			tr.setForeground(Color.black);
			if (t1.getText().equals("")) {
				tr.setForeground(Color.red);
				tr.setText("Nhập thiếu a");
				t1.requestFocus();
			} else if (!t1.getText().matches("-?\\d+(\\.\\d+)?")) {
				tr.setForeground(Color.red);
				tr.setText("Nhập sai a");
				t1.selectAll();
				t1.requestFocus();
			} else if (t2.getText().equals("")) {
				tr.setForeground(Color.red);
				tr.setText("Nhập thiếu b");
				t2.requestFocus();
			} else if (!t2.getText().matches("-?\\d+(\\.\\d+)?")) {
				tr.setForeground(Color.red);
				tr.setText("Nhập sai b");
				t2.selectAll();
				t2.requestFocus();
			} else {
				int a = Integer.parseInt(t1.getText());
				int b = Integer.parseInt(t2.getText());
				if (r1.isSelected()) {
					tr.setText(String.valueOf(a + b));
				} else if (r2.isSelected()) {
					tr.setText(String.valueOf(a - b));
				} else if (r3.isSelected()) {
					tr.setText(String.valueOf(a * b));
				} else {
					if (b == 0) {
						tr.setForeground(Color.red);
						tr.setText("Không thể chia cho 0");
						t2.selectAll();
						t2.requestFocus();
					} else {
						tr.setText(String.valueOf((double) a/b));
					}
				}
			}
		} else if (source == b2) {
			t1.setText("");
			t2.setText("");
			tr.setText("");
			t1.requestFocus();
		} else if (source == b3) {
			this.dispose();
		}
	}
}
