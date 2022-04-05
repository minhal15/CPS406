import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class MemberUI2 extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea memInboxText;
	private BufferedReader buffread;

	//private Jthis this;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberUI window = new MemberUI();
					window.this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the application.
	 */
	public MemberUI2() {
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		//this = new Jthis();
		this.setBounds(100, 100, 496, 262);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane memTabs = new JTabbedPane(JTabbedPane.TOP);
		this.getContentPane().add(memTabs, BorderLayout.CENTER);
		
		JPanel memMain = new JPanel();
		memTabs.addTab("Main", null, memMain, null);
		memMain.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Schedule Practise", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 452, 148);
		memMain.add(panel);
		panel.setLayout(null);
		
		JLabel lblClassName = new JLabel("Class Name:");
		lblClassName.setBounds(10, 36, 120, 14);
		panel.add(lblClassName);
		
		JLabel lblInstructor = new JLabel("Instructor:");
		lblInstructor.setBounds(10, 62, 81, 14);
		panel.add(lblInstructor);
		
		textField = new JTextField();
		textField.setBounds(86, 33, 133, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 59, 133, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPayment = new JLabel("Payment:");
		lblPayment.setBounds(229, 62, 70, 14);
		panel.add(lblPayment);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(232, 36, 46, 14);
		panel.add(lblDate);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(309, 33, 133, 20);
		panel.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(309, 58, 133, 22);
		panel.add(comboBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 96, 432, 2);
		panel.add(separator);
		
		JButton btnNewButton_2 = new JButton("Paypal");
		btnNewButton_2.setBounds(297, 109, 145, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Credit/Debit");
		btnNewButton_3.setBounds(142, 109, 145, 23);
		panel.add(btnNewButton_3);
		
		JPanel memInbox = new JPanel();
		memTabs.addTab("Inbox", null, memInbox, null);
		memInbox.setLayout(new BorderLayout(0, 0));
		
		JScrollPane memInboxView = new JScrollPane();
		memInbox.add(memInboxView, BorderLayout.CENTER);
		
		memInboxText = new JTextArea();
		memInboxText.setEditable(false);
		memInboxView.setViewportView(memInboxText);
		
		setMessage("membermsgs.txt");
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnLogout = new JButton("Logout");
		toolBar.add(btnLogout);
		ActionListener logoutListen = new logoutListener();
		btnLogout.addActionListener(logoutListen);
		
		JButton btnNewButton_1 = new JButton("Shutdown");
		toolBar.add(btnNewButton_1);
	}
	class logoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFrame loWindow = new LoginUI();
			loWindow.setVisible(true);
			setVisible(false);
		}
	}
	
	public void setMessage(String file) {
		try {
	        	BufferedReader buffread = new BufferedReader(new FileReader(file));
	        	String line = buffread.readLine();
	        	while(line != null){
	        		memInboxText.append(line + "\n");
	          		line = buffread.readLine();
	       		}
	        	buffread.close();
		}
	      	catch (IOException e) {
	        System.out.println("Could not find file");
	    }	
	}
}