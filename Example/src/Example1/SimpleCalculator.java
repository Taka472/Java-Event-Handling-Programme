package Example1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SimpleCalculator extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JTextField t1, t2, tr;
	JButton b1, b2, b3;
	JRadioButton r1, r2, r3, r4;
	private int textFieldWidth = 20;
	
	@SuppressWarnings("unused")
	public SimpleCalculator() {
		super("Calculator");
		JLabel l1, l2, result;
		JPanel p = new JPanel();
		ButtonGroup btg = new ButtonGroup();
		
		
		p.add(l1 = new JLabel("Số 1: ", JLabel.LEFT));
		p.add(t1 = new JTextField(textFieldWidth));
		p.add(l2 = new JLabel("Số 2: ", JLabel.LEFT));
		p.add(t2 = new JTextField(textFieldWidth));
		p.add(result = new JLabel("Kết quả: ", JLabel.LEFT));
		p.add(tr = new JTextField(textFieldWidth));
		p.add(r1 = new JRadioButton("Cộng", true));
		p.add(r2 = new JRadioButton("Trừ"));
		p.add(r3 = new JRadioButton("Nhân"));
		p.add(r4 = new JRadioButton("Chia"));
		p.add(b1 = new JButton("Giải"));
		p.add(b2 = new JButton("Xóa"));
		p.add(b3 = new JButton("Thoát"));
		
		
		btg.add(r1);
		btg.add(r2);
		btg.add(r3);
		btg.add(r4);
		
		
		l1.setForeground(Color.blue);
		l2.setForeground(Color.blue);
		result.setForeground(Color.blue);
		
		
		r1.setForeground(Color.blue);
		r2.setForeground(Color.blue);
		r3.setForeground(Color.blue);
		r4.setForeground(Color.blue);
		
		
		t1.setBackground(Color.blue);
		t1.setForeground(Color.white);
		t2.setBackground(Color.blue);
		t2.setForeground(Color.white);
		tr.setBackground(Color.blue);
		tr.setEnabled(false);
		tr.setDisabledTextColor(Color.white);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		add(p);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(280, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if (source.equals(b1)) {
			if (t1.getText().equals("") || t2.getText().equals("")) {
				tr.setText("Nhập thiếu số");
				tr.setDisabledTextColor(Color.red);
			} else if (t1.getText().matches(".*[a-z].*") || t2.getText().matches(".*[a-z].*")) {
				tr.setText("Nhập có chữ trong dữ liệu");
				tr.setDisabledTextColor(Color.red);
			} else if (source.equals(b1)) {
				if (r1.isSelected()) {
					tr.setText(String.valueOf(Integer.parseInt(t1.getText()) + Integer.parseInt(t2.getText())));
					tr.setDisabledTextColor(Color.white);
				} else if (r2.isSelected()) {
					tr.setText(String.valueOf(Integer.parseInt(t1.getText()) - Integer.parseInt(t2.getText())));
					tr.setDisabledTextColor(Color.white);
				} else if (r3.isSelected()) {
					tr.setText(String.valueOf(Integer.parseInt(t1.getText()) * Integer.parseInt(t2.getText())));
					tr.setDisabledTextColor(Color.white);
				} else {
					if (Integer.parseInt(t2.getText()) == 0) {
						tr.setText("Chia 0");
						tr.setDisabledTextColor(Color.red);
					} else {
						tr.setText(String.valueOf(Float.parseFloat(t1.getText()) / Float.parseFloat(t2.getText())));
						tr.setDisabledTextColor(Color.white);
					}
				}
			}
		} else if (source.equals(b2)) {
			t1.setText("");
			t2.setText("");
			tr.setText("");
			r1.setSelected(true);
		} else this.dispose();
	}
	
	public static void main (String[] argv) {
		new SimpleCalculator();
	}
}