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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.xyztech.action.ActionPage;
import com.xyztech.bean.Beans;
import com.xyztech.bean.Chaxun;
import com.xyztech.bean.Salarys;
import com.xyztech.jframe.alert.XiuGai;
import com.xyztech.service.Connections;
import com.xyztech.service.CreateTable;
import com.xyztech.util.Fenye;
import com.xyztech.util.Sql;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ManageHr extends JFrame {

	private JPanel contentPane;
	public JTable table;
	public JTextField textField;
	public JLabel label_3; 
	Connections connect=new Connections();
	public JFormattedTextField formattedTextField;
	public JFormattedTextField formattedTextField_1;
	public JComboBox<?> comboBox;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManageHr frame = new ManageHr();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param bean 
	 */
	public ManageHr(final Beans bean) {
		final ManageHr that=this;
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
		menu.add(menuItem_5);
		
		JMenu menu_1 = new JMenu("\u4EBA\u4E8B\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5458\u5DE5\u7BA1\u7406");
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "\u5458\u5DE5\u57FA\u672C\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 0, 999, 75);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(10, 36, 54, 15);
		panel.add(label);
		
		 formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(42, 33, 115, 21);
		panel.add(formattedTextField);
		
		JLabel label_1 = new JLabel("\u90E8\u95E8\uFF1A");
		label_1.setBounds(323, 36, 54, 15);
		panel.add(label_1);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\u8D22\u52A1\u90E8", "\u6280\u672F\u90E8", "\u884C\u653F\u90E8", "\u4E1A\u52A1\u90E8", "\u603B\u7ECF\u529E"}));
		comboBox.setBounds(364, 33, 67, 21);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询功能
				Chaxun cx=new Chaxun();
				cx.setName(formattedTextField.getText().trim());
				cx.setTelphone(formattedTextField_1.getText().trim());
				cx.setUid(comboBox.getSelectedIndex());
//				Connections connect =new Connections();
				connect.setSql(new Sql().sql_chaxun(cx));
				CreateTable ct=new CreateTable();
				ArrayList<Salarys> al=connect.returnSalary();
				Fenye.xiaYiYe(al);
				ct.preTableBuild(al);
				table.setModel(ct.putSalary());
			}
		});
		btnNewButton.setBounds(485, 32, 93, 23);
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//点击修改，修改数据
				if(table.getSelectedRow()!=-1){
					int uid=connect.returnSalary().get(table.getSelectedRow()+(Fenye.currentPage-1)*10).getUid();
					new ActionPage().actionXiugai(uid);
				}
				
			}
		});
		button.setBounds(624, 32, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("\u65B0\u589E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XiuGai xg=new XiuGai();
				xg.btnNewButton.setVisible(false);
				xg.button.setVisible(false);
				xg.button_2.setVisible(true);
				xg.setVisible(true);
			}
		});
		button_1.setBounds(759, 32, 93, 23);
		panel.add(button_1);
		
		JLabel label_2 = new JLabel("\u7535\u8BDD\uFF1A");
		label_2.setBounds(167, 36, 54, 15);
		panel.add(label_2);
		
		
		formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(198, 33, 115, 21);
		panel.add(formattedTextField_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 100, 999, 245);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 370, 401, 126);
		contentPane.add(panel_1);
		
		JButton button_2 = new JButton("\u4E0A\u4E00\u9875");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//上一页
				do_actionPerformed_lastpage(e);
			}
		});
		button_2.setBounds(10, 51, 81, 23);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("\u4E0B\u4E00\u9875");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//下一页
				do_actionPerformed_nextpage(e);
			}
		});
		button_3.setBounds(112, 51, 81, 23);
		panel_1.add(button_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(203, 52, 57, 21);
		panel_1.add(textField);
		
		label_3 = new JLabel("\u51710"+Fenye.totalPage+"\uFF0C\u5F53\u524D\u9875\u4E3A1");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(203, 10, 160, 23);
		panel_1.add(label_3);
		
		JButton button_4 = new JButton("GO");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//转到指定页
				do_actionPerformed(e);
			}
		});
		button_4.setBounds(281, 51, 82, 23);
		panel_1.add(button_4);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//部门人员表格
				String sql="select a.UID,UName,DepName,SalBasic,SalHouse,SalOld,SalHealth,SalEmp,SalRefund,SalPerformance,SalDate from Employee as a,Department as b,Salary as c where b.DepID=a.DepID and c.UID=a.UID"
						+" and a.DepID=(select DepID from Employee where UName='"+bean.getUsername()+"' and UPassword='"+bean.getPassword()+"'  and RankID="+bean.getRankid()+" )";
						connect.setSql(sql);
						exchangeTable();
			}
		});
		btnNewButton_1.setBounds(281, 93, 81, 23);
		panel_1.add(btnNewButton_1);

		
	}
	//转到指定页
		private void do_actionPerformed(ActionEvent e ){
			int i=Fenye.totalPage;
			int j=Integer.valueOf(textField.getText());
			if(j<=i&&j>=1){
				Fenye.currentPage=j;
				exchangeTable();
				label_3.setText("共"+Fenye.totalPage+"页，当前页为"+Fenye.currentPage);
			}
		}
		//上一页
		private void do_actionPerformed_lastpage(ActionEvent e) {
			if(Fenye.currentPage!=1){
				Fenye.currentPage--;
				exchangeTable();
				label_3.setText("共"+Fenye.totalPage+"页，当前页为"+Fenye.currentPage);
			}
			
		}
		//下一页
		private void do_actionPerformed_nextpage(ActionEvent e) {
			if(Fenye.currentPage!=Fenye.totalPage){
				Fenye.currentPage++;
				exchangeTable();
				label_3.setText("共"+Fenye.totalPage+"页，当前页为"+Fenye.currentPage);
			}
}
		//换页通用方法
		private  void exchangeTable(){
			CreateTable ct=new CreateTable();
			ct.preTableBuild(connect.returnSalary());
			ct.putSalary();
			table.setModel(ct.putSalary());
		}
}
