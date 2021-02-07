package examination;

import java.awt.BorderLayout;
import java.lang.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.proteanit.sql.DbUtils;
import oracle.jdbc.driver.Const;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class frame4 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	int total;
	int no1;
	int dup;
	int temp=0;
	int q=0;
	PreparedStatement	ps2;
	PreparedStatement	ps3;
	PreparedStatement ps4;
	PreparedStatement ps5;
	PreparedStatement ps6;
	int ind=0;
	Connection con;
	File src1;
	FileInputStream fis1;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileOutputStream fout;
	int capacity;
	ResultSet cse;
	ResultSet ece;
	ResultSet eee;
	Statement st2;
	Statement st3;
	Statement st4;
	int p=0;
	int a1=0;
	int b1=0;
	int c1=0;
	int d1=0;
	int[] arr=new int[100];
	int[] row=new int[100];
	int[] col=new int[100];
	private JLabel lblNoofStudentPer;
	private JTextField textField_4;
	private JTable table;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame4 frame = new frame4();
					
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
	public frame4() {
	String no=JOptionPane.showInputDialog(null, "ENTER NO OF CLASS ROOMS");
	 no1=Integer.parseInt(no);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterNoOf = new JLabel("ENTER DETAILS OF CLASS");
		lblEnterNoOf.setForeground(Color.RED);
		lblEnterNoOf.setFont(new Font("Arial", Font.BOLD, 11));
		lblEnterNoOf.setBounds(29, 40, 167, 24);
		contentPane.add(lblEnterNoOf);
		
		textField = new JTextField();
		textField.setBounds(206, 42, 35, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNoOfRows = new JLabel("NO OF STUDENT PER ROWS");
		lblNoOfRows.setFont(new Font("Arial", Font.BOLD, 11));
		lblNoOfRows.setBounds(29, 124, 156, 24);
		contentPane.add(lblNoOfRows);
		
		textField_2 = new JTextField();
		textField_2.setBounds(198, 126, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNoOfColums = new JLabel("NO OF ROWS");
		lblNoOfColums.setFont(new Font("Arial", Font.BOLD, 11));
		lblNoOfColums.setBounds(29, 92, 105, 14);
		contentPane.add(lblNoOfColums);
		
		textField_3 = new JTextField();
		textField_3.setBounds(198, 89, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	
		for(int i=temp+1;i<no1+1;i++)
		{
			String j=Integer.toString(i);
		textField.setText(j);
		dup=i++;
		break;
		}
		
		
	try {
		 Driver de1=new oracle.jdbc.driver.OracleDriver();
		 DriverManager.registerDriver(de1);
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","santhu");
		  String S="classTable";
		ps3=con.prepareStatement("TRUNCATE TABLE classTable");
		ps3.executeQuery();
	}catch(Exception e1) {
		e1.printStackTrace();
	}
		JButton btnGenerate = new JButton("UPDATE");
		btnGenerate.setFont(new Font("Arial", Font.BOLD, 11));
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i;
	
				try {
					ps2=con.prepareStatement("insert into classTable values(?,?,?,?,?)");
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				String z="1";
				
			
				String b=textField_2.getText();
				 b1=Integer.parseInt(b);
				String c=textField_3.getText();
				c1=Integer.parseInt(c);
			row[ind]=c1;
			col[ind]=c1;
				textField_4.setText(b);
				//d1=Integer.parseInt(d);
				
				 capacity=b1*c1;
				 
				 
				
						//int capacity1=capacity*d1;
						 arr[ind]=capacity;
						 ind++;
				String cap=Integer.toString(capacity);
				JOptionPane.showInputDialog(null, "capacity of the class is",capacity);
				JOptionPane.showInputDialog(null,"No. of columns",b1);
				
				String j;
				for( i=dup+1;i<no1+1;i++)
				{
					 j=Integer.toString(i);
				textField.setText(j);
				dup++;
				
				
				break;
				}
				for(int u=q+1;u<no1+1;u++)
				{	String v;
					v=Integer.toString(u);
					try {
						ps2.setString(1, v);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					q++;
					break;
				}
				
				try {
					ps2.setString(2,c);
					ps2.setString(3,b);
					ps2.setString(4,b);
					ps2.setString(5,cap);
					ps2.executeUpdate();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
					
					
					
			
				p=i;
					
				if(p==no1+1)
				{
					JOptionPane.showMessageDialog(null,"class limit completed ");
				}	
				
			
				
				String qry="select * from classTable";
				
				
				try {
					ResultSet rs2;
					Statement st2=con.createStatement();
					rs2 = st2.executeQuery(qry);
					table.setModel(DbUtils.resultSetToTableModel(rs2));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				}
				
				
				
				
			
		});
		//JOptionPane.showMessageDialog(null,"data uploaded successfully");
		btnGenerate.setBounds(87, 171, 89, 23);
		contentPane.add(btnGenerate);
		
		lblNoofStudentPer = new JLabel("NO OF COLUMNS");
		lblNoofStudentPer.setFont(new Font("Arial", Font.BOLD, 11));
		lblNoofStudentPer.setBounds(29, 263, 147, 24);
		contentPane.add(lblNoofStudentPer);
		
		textField_4 = new JTextField();
		textField_4.setBounds(147, 265, 49, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(312, 84, 298, 105);
		contentPane.add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("ARRANGEMENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					st2 = con.createStatement();
					cse = st2.executeQuery("select rollnumber from csetable");
					st3=con.createStatement();
					ece=st3.executeQuery("select rollnumber from eceTable");
					st4=con.createStatement();
					eee=st4.executeQuery("select rollnumber from eeeTable");
					
					
			 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				 src1=new File("C:\\Users\\Admin\\Desktop\\a2.xlsx");
				try {
					fis1=new FileInputStream(src1);
					
						 wb=new XSSFWorkbook(fis1);
						 sheet=wb.getSheetAt(0);
						
						 System.out.println();
						// sheet.addMergedRegion(new CellRangeAddress(2,2,1,5));
							total =0;
						 for(int l=0;l<arr.length;l++)
						 {
							
							 total+=arr[l];
							 total+=3;
						 }
						 System.out.println(total);
						 int i;int p=0; int j=1;int g=0;int sc=0;int row_index1=0; int col_index;int cap_index1=0;
						for(i=0;i<total;i++)
						 {	
						 if(j<(no1+1)) {
						sheet.createRow(i).createCell(0).setCellValue("class-"+j);j++;
						sheet.createRow(++i).createCell(0).setCellValue("Capacity of the room is:"+arr[p]);
						++i;
						
						int g1=i;
							for( col_index=cap_index1;col_index<col[col_index];col_index++)
							{	
								for(int row_index=0;row_index<row[row_index];row_index++)
								{
								while(cse.next())
								{
									
							sheet.createRow(g1).createCell(col_index).setCellValue(cse.getString(1));break;
							 
							}
							
								
						}
									
									for(int row_index=0;row_index<row[row_index];row_index++)
									{
									while(ece.next())
									{
										
								sheet.getRow(g1).createCell(col_index+2).setCellValue(ece.getString(1));break;
								 
								
									
							}}
										
										for(int row_index=0;row_index<row[row_index];row_index++)
										{
										while(eee.next())
										{
											
									sheet.getRow(g1).createCell(col_index+4).setCellValue(eee.getString(1));break;
									 
									
									
										
								}
							}}
						/*int cp=arr[p];
						System.out.println(cp);
						 System.out.println("abc");
						 g=i;
						 sc=i;
						 for(int m=0;m<(cp/3);m++)
							{
								while(cse.next()) {
							sheet.createRow(++i).createCell(0).setCellValue(cse.getString(1));
							
							break;
							}
							
						}
						 for(int m=0;m<(cp/3);m++)
							{
								while(ece.next()) {
							sheet.getRow(++g).createCell(3).setCellValue(ece.getString(1));
							
							break;
							}
								
							
						}
						 for(int m=0;m<(cp/3);m++)
							{
								while(eee.next()) {
							sheet.getRow(++sc).createCell(6).setCellValue(eee.getString(1));
							
							break;
							}
								
							
						}**/
							++i;
						
						
						p++;
						 }
						}
						
						fout=new FileOutputStream(src1);
						wb.write(fout);
						wb.close();
						
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				
				JOptionPane.showMessageDialog(null, "seating arrangement design is generated 'open a2.xlsx in destop' ");
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.setBounds(242, 264, 199, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Arial", Font.BOLD, 11));
		btnBack.setForeground(new Color(128, 0, 0));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				frame3 f6=new frame3();
				f6.show();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnBack.setBounds(521, 11, 89, 23);
		contentPane.add(btnBack);
	}
}
