package examination;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class frame1 {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 window = new frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 11));
		lblUsername.setBounds(52, 77, 86, 20);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 11));
		lblPassword.setBounds(52, 118, 69, 20);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(131, 77, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 121, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("LOG IN");
		btnLogin.setFont(new Font("Arial", Font.BOLD, 11));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=textField.getText();
				String b=passwordField.getText();
				if(a.equals("exam") && b.equals("ucet"))
				{
					JOptionPane.showMessageDialog(null, "login successfull");
					frame2 f2=new frame2();
					f2.show();
					
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"enter valid username and password ");
					
				
				}
			}
		});
		btnLogin.setBounds(77, 175, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}
