import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;

public class LoginUI extends JFrame{

	//private JFrame loginViewer;
	private JTextField usrField;
	private JPasswordField passField;

	private static final String tLog = "treasurer";
	private static final String cLog = "coach";
	private static final String mLog = "member";
	private static final String pass = "password";

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.loginViewer.setVisible(true);
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
	public LoginUI() {
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//loginViewer = new JFrame();
		this.setTitle("Membership Manager");
		this.setBounds(100, 100, 261, 172);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel loginMain = new JPanel();
		this.getContentPane().add(loginMain, BorderLayout.CENTER);
		loginMain.setLayout(null);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(11, 102, 89, 23);
		loginMain.add(loginBtn);
		ActionListener loginListen = new loginListener();
		loginBtn.addActionListener(loginListen);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(146, 102, 89, 23);
		loginMain.add(cancelBtn);
		ActionListener cancelListen = new clearListener();
		cancelBtn.addActionListener(cancelListen);
		
		JPanel loginInputs = new JPanel();
		loginInputs.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		loginInputs.setBounds(10, 11, 225, 78);
		loginMain.add(loginInputs);
		loginInputs.setLayout(null);
		
		usrField = new JTextField();
		usrField.setBounds(91, 11, 121, 20);
		loginInputs.add(usrField);
		usrField.setColumns(10);
		
		JLabel usrLabel = new JLabel("Password:");
		usrLabel.setBounds(10, 45, 71, 14);
		loginInputs.add(usrLabel);
		
		JLabel passLabel = new JLabel("Username:");
		passLabel.setBounds(10, 14, 71, 14);
		loginInputs.add(passLabel);
		
		passField = new JPasswordField();
		passField.setBounds(91, 42, 121, 20);
		loginInputs.add(passField);
	}	
	class loginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String uName = usrField.getText();
			String pWord = String.valueOf(passField.getPassword());
			if (pWord.equals(pass)) {
				if (uName.equals(tLog)) {
					JFrame acWindow = new AccountantUI2();
					acWindow.setVisible(true);
					setVisible(false);
				}
				if (uName.equals(cLog)) {
					JFrame coWindow = new CoachUI2();
					coWindow.setVisible(true);
					setVisible(false);
				}
				if (uName.equals(mLog)) {
					JFrame meWindow = new MemberUI2();
					meWindow.setVisible(true);
					setVisible(false);
				}
				else {
					usrField.setText("Invalid Login/Password");
					passField.setText("Press Cancel");
				}
			}
			else {
				usrField.setText("Invalid Login/Password");
				passField.setText("Press Cancel");
			}
		}
	}

	class clearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			usrField.setText("");
			passField.setText("");
		}
	}
}
