package com.xyztech.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.xyztech.bean.Beans;
import com.xyztech.service.*;

import com.xyztech.service.CreateTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YuangongManage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public JPanel panel_1; 
	public JPanel panel;
	public JFormattedTextField formattedTextField;
	public JLabel lblNewLabel;
	public JScrollPane scrollPane_1 ;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					YuangongManage frame = new YuangongManage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public YuangongManage(final Beans bean) {
		final JFrame that=this;
		setTitle("\u666E\u901A\u5458\u5DE5\u7EC8\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 555);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u83DC\u5355");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u6CE8\u9500");
		menu.add(menuItem);
		
		JMenuItem menuItem_5 = new JMenuItem("\u4E2A\u4EBA\u60C5\u51B5");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CreateTable ct=	new CreateTable();
			ct.preTalbeBuild(bean);
			table.setModel(ct.putSalary());
			scrollPane_1.setVisible(true);
			}
		});
		menu.add(menuItem_5);
		
		JMenu menu_1 = new JMenu("\u4EBA\u4E8B\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5458\u5DE5\u7BA1\u7406");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				that.dispose();			
				new ManageHr(bean).setVisible(true);
			}
		});
		menu_1.add(menuItem_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u6CE8\u518C\u5458\u5DE5");
		menu_1.add(menuItem_3);
		
		JMenu menu_3 = new JMenu("\u85AA\u916C\u7BA1\u7406");
		menuBar.add(menu_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u85AA\u916C\u4FEE\u6539");
		menu_3.add(menuItem_4);
		
		JMenu menu_2 = new JMenu("\u516C\u544A\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("\u516C\u544A\u53D1\u5E03");
		menu_2.add(menuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u516C\u544A\u4FEE\u6539");
		menu_2.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 0, 999, 75);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCExxxx\u767B\u5F55MicroSaft\u5458\u5DE5\u7BA1\u7406\u7CFB\u7EDF~");
		lblNewLabel.setBounds(10, 10, 846, 55);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u516C\u544A\u680F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setToolTipText("");
		panel_1.setBounds(0, 85, 1019, 284);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 10, 499, 264);
		panel_1.add(textPane);
		textPane.setText("\u56E0\u6781\u7AEF\u5929\u6C14\u5F71\u54CD\uFF0C\u4ECA\u5929\u4E0B\u53482\u70B9\u4E0B\u73ED\r\n\u529E\u516C\u5BA4\r\n2016-9-19 \r\n-----------------------\r\n\u56E0\u5475\u5475\u7231\u6765\u770B\u624B\u673A\u57AB\u4ED8");
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 379, 999, 107);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane_1.setViewportView(table);
		scrollPane_1.setVisible(false);
		
	}
}
