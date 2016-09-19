package com.xyztech.jframe.alert;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.xyztech.action.ActionPage;
import com.xyztech.bean.Beans;
import com.xyztech.service.TestLogin;
import com.xyztech.util.Sql;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XiuGai extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_5;
	public JTextField textField_6;
	public JComboBox<?> comboBox;
	public JComboBox<?> comboBox_1;
	public JComboBox<?> comboBox_2;
	public JButton button ;
	public JButton btnNewButton;
	public JButton  button_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XiuGai frame = new XiuGai();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public XiuGai() {
		final  XiuGai that=this;
		setTitle("\u5458\u5DE5\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 325, 475);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setBounds(38, 80, 54, 15);
		
		JLabel label_5 = new JLabel("\u59D3\u540D\uFF1A");
		label_5.setBounds(38, 41, 54, 15);
		
		JLabel label_1 = new JLabel("\u90E8\u95E8\uFF1A");
		label_1.setBounds(38, 119, 36, 15);
		
		JLabel label_2 = new JLabel("\u804C\u4F4D\uFF1A");
		label_2.setBounds(38, 158, 36, 15);
		
		JLabel label_3 = new JLabel("\u6743\u9650\uFF1A");
		label_3.setBounds(38, 197, 36, 15);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD\uFF1A");
		label_4.setBounds(38, 236, 36, 15);
		
		JLabel label_6 = new JLabel("\u6027\u522B\uFF1A");
		label_6.setBounds(38, 272, 36, 15);
		
		textField = new JTextField();
		textField.setBounds(96, 38, 137, 21);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(96, 77, 137, 21);
		textField_1.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(96, 233, 137, 21);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(96, 272, 137, 21);
		textField_6.setColumns(10);
		
		 comboBox = new JComboBox();
		 comboBox.setBounds(96, 116, 137, 21);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u8D22\u52A1\u90E8", "\u6280\u672F\u90E8", "\u884C\u653F\u90E8", "\u4E1A\u52A1\u90E8", "\u603B\u7ECF\u529E"}));
		
		 comboBox_1 = new JComboBox();
		 comboBox_1.setBounds(96, 155, 137, 21);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u603B\u88C1", "T1", "T2", "T3", "P1", "P2", "P3"}));
		
		 comboBox_2 = new JComboBox();
		 comboBox_2.setBounds(96, 194, 137, 21);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A\u7528\u6237", "\u90E8\u95E8\u7ECF\u7406", "\u603B\u7ECF\u7406", "\u7BA1\u7406\u5458"}));
		
		 button = new JButton("\u4FEE\u6539");
		 button.setBounds(38, 343, 57, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new ActionPage().actionXiugai(that);
				//修改数据
				Beans beans=new Beans();
				beans.setUsername(that.textField.getText());
				beans.setPassword(that.textField_1.getText());
				beans.setTelphone(that.textField_5.getText());
				beans.setGender(that.textField_6.getText());
				beans.setRankid(that.comboBox_2.getSelectedIndex()+1);
				beans.setDepid(that.comboBox.getSelectedIndex()+1);
				beans.setPerid(that.comboBox_1.getSelectedIndex()+1);
				String sql=new Sql().sql_xiugai(beans);
				new TestLogin().updateUser(sql);
			}
		});
		
		 btnNewButton = new JButton("\u5220\u9664");
		 btnNewButton.setBounds(113, 343, 57, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除数据
				Beans beans=new Beans();
				beans.setUsername(that.textField.getText());
				beans.setTelphone(textField_5.getText());
				String sql=new Sql().sql_delete(beans);
				new TestLogin().updateUser(sql);
			}
		});
		
		JButton button_1 = new JButton("\u5173\u95ED");
		button_1.setBounds(188, 343, 57, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.dispose();
			}
		});
		
		 button_2 = new JButton("\u65B0\u589E");
		 button_2.setVisible(false);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//增加
				Beans beans=new Beans();
				beans.setUsername(that.textField.getText());
				beans.setPassword(that.textField_1.getText());
				beans.setTelphone(that.textField_5.getText());
				beans.setGender(that.textField_6.getText());
				beans.setRankid(that.comboBox_2.getSelectedIndex()+1);
				beans.setDepid(that.comboBox.getSelectedIndex()+1);
				beans.setPerid(that.comboBox_1.getSelectedIndex()+1);
				new TestLogin().updateUser(new Sql().sql_inset(beans));
			}
		});
		button_2.setBounds(75, 343, 57, 23);
		panel.setLayout(null);
		panel.add(label_5);
		panel.add(label_1);
		panel.add(label);
		panel.add(label_2);
		panel.add(label_3);
		panel.add(label_4);
		panel.add(label_6);
		panel.add(comboBox_2);
		panel.add(comboBox);
		panel.add(textField_6);
		panel.add(textField_5);
		panel.add(textField_1);
		panel.add(textField);
		panel.add(comboBox_1);
		panel.add(button);
		panel.add(button_2);
		panel.add(btnNewButton);
		panel.add(button_1);
	}
}
