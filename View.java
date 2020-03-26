package proiect;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame{
	
	private static JTextField m_polinom1 = new JTextField(20);
	private static JTextField m_polinom2 = new JTextField(20);
	
	private JTextField m_userInputpolinom = new JTextField(40);
	private static JTextField m_total = new JTextField(50);
	private JButton m_multiplyBtn = new JButton("Multiply");
	private JButton m_addBtn = new JButton("Add");
	private JButton m_subbBtn = new JButton("subb");
	private JButton m_mullBtn = new JButton("mul");
	private JButton m_divBtn = new JButton("div");
	private JButton m_derBtn = new JButton("der");
	private JButton m_intBtn = new JButton("integ");
	private JButton m_addBtncoef = new JButton("Coefficient");
	private JButton m_addBtnexpo = new JButton("Exponent");
	private JButton m_clearBtn = new JButton("Clear");
	private Model m_model;
	
	View(Model model)
	{
		m_model = model;
		JPanel content3 = new JPanel();
		JPanel content2 = new JPanel();
		JPanel content1 = new JPanel();
		JPanel content4 = new JPanel();
		JPanel content = new JPanel();
		
		
		content3.setLayout(new GridLayout(2,1));
		content4.setLayout(new GridLayout(2,2));
		content.setLayout(new FlowLayout());
		
		content1.setLayout(new GridLayout());
		content1.add(new JLabel("Primul Polinom:"));
		content1.add(m_polinom1);
		
		
		content2.setLayout(new GridLayout());
		content2.add(new JLabel("Al doilea Polinom:"));
		content2.add(m_polinom2);
		
		content3.add(content1);
		content3.add(content2);
		content.add(content3);
		
		
		content.add(new JLabel("Polinom"));
		content.add(m_total);
		content4.add(m_addBtn);
		content4.add(m_subbBtn);
		content4.add(m_mullBtn);
		content4.add(m_derBtn);
		content4.add(m_intBtn);
		content.add(content4);
		
		content.setSize(500, 500);
		this.setContentPane(content);
		this.pack();
		this.setTitle("Polynomial Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	void reset() {
		m_total.setText(Model.INITIAL_VALUE);
		}
	
	public static String getUsercoef() { 

		return m_polinom1.getText();
		}
	
	public static String getUserexpo() { 

		return m_polinom2.getText();
		}

	void addSumListener(ActionListener mal) {
		m_addBtn.addActionListener(mal);
		}
	void addSubbListener(ActionListener mal) {
		m_subbBtn.addActionListener(mal);
		}
	void addMulListener(ActionListener mal) {
		m_mullBtn.addActionListener(mal);
		}
	void addDivListener(ActionListener mal) {
		m_divBtn.addActionListener(mal);
		}
	void addDerListener(ActionListener mal) {
		m_derBtn.addActionListener(mal);
		}
	void addIntListener(ActionListener mal) {
		m_intBtn.addActionListener(mal);
		}
	void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
		}
	
	public static void setTotal(String total)
	{
		m_total.setText(total);
	}

	
	
}


