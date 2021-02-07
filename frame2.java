package examination;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class frame2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 frame = new frame2();
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
	public frame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("UPLOAD INFORMATION");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame3 f3;
				try {
					f3 = new frame3();
					f3.show();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(119, 82, 168, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSeatingArrangement = new JButton("SEATING ARRANGEMENT");
		btnSeatingArrangement.setFont(new Font("Arial", Font.BOLD, 11));
		btnSeatingArrangement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame4 f4=new frame4();
				f4.show();
			}
		});
		btnSeatingArrangement.setBounds(119, 134, 168, 23);
		contentPane.add(btnSeatingArrangement);
	}

}
