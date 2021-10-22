package examination;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
public class frame3 extends JFrame {
	File src;
	File src1;
	
	private JPanel contentPane;
	String data;
	String data1;
	String data2;
	String data3 ;
	int count;
	int count1;
	public static Connection con=null;
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	private JTable table_2;
  

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame3 frame = new frame3();
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
	public frame3() throws Exception{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 333);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JOptionPane.showMessageDialog(null, "Excel  file should Contain two columns i.e, 'name' && 'rollnumber'  ");
		
		JButton btnUploadExcelFile = new JButton("UPLOAD CSE EXCEL FILE");
		btnUploadExcelFile.setFont(new Font("Arial", Font.BOLD, 11));
		btnUploadExcelFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FOR ECE DEPARTMENT 
				
				JFileChooser chose=new JFileChooser();
				int result=chose.showOpenDialog(null);
				if(result==JFileChooser.APPROVE_OPTION)
				
				{
					
						
					
					String path=chose.getSelectedFile().getAbsolutePath();
					JOptionPane.showMessageDialog(null, path);
					 src=new File(path);
			
						FileInputStream fis;
						try {
							
							  Driver de=new oracle.jdbc.driver.OracleDriver();
							  DriverManager.registerDriver(de);
							con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","santhu");
							ps=con.prepareStatement("TRUNCATE TABLE CSETABLE");
							ps.executeQuery();
							ps=con.prepareStatement("insert into CSETABLE values(?,?)");
							fis = new FileInputStream(src);
							XSSFWorkbook wb=new XSSFWorkbook(fis);
							XSSFSheet sheet=wb.getSheetAt(0);
							 count=sheet.getLastRowNum();
								
								for(int i=0;i<=count;i++)
								{
								 
								data=sheet.getRow(i).getCell(0).getStringCellValue();
								data1=  sheet.getRow(i).getCell(1).getStringCellValue();
								
								ps.setString(1,data);
								ps.setString(2, data1);
								ps.executeUpdate();
								}
								
								JOptionPane.showMessageDialog(null, "file uploaded successfully");
								
								String qry="select * from CSETABLE";
								Statement st=con.createStatement();
								ResultSet rs=st.executeQuery(qry);
							table_2.setModel(DbUtils.resultSetToTableModel(rs));
								
								
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						}
						
								
				}
			}		
			
		});
		btnUploadExcelFile.setBounds(536, 95, 169, 23);
		contentPane.add(btnUploadExcelFile);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 51, 425, 233);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		
		JButton btnAllocation = new JButton("ALLOCATION");
		btnAllocation.setForeground(new Color(255, 0, 0));
		btnAllocation.setFont(new Font("Arial", Font.BOLD, 11));
		btnAllocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame4 f4=new frame4();
				f4.show(); 
			}
		});
		btnAllocation.setBounds(536, 219, 169, 23);
		contentPane.add(btnAllocation);
		
		JButton btnUploadEceExcel = new JButton("UPLOAD ECE EXCEL FILE");
		btnUploadEceExcel.setFont(new Font("Arial", Font.BOLD, 11));
		btnUploadEceExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chose=new JFileChooser();
				int result=chose.showOpenDialog(null);
				if(result==JFileChooser.APPROVE_OPTION)
					
				{
					
						
					
					String path=chose.getSelectedFile().getAbsolutePath();
					JOptionPane.showMessageDialog(null, path);
					 src1=new File(path);
					 
					 FileInputStream fis1;
						try {
 							
							  Driver de=new oracle.jdbc.driver.OracleDriver();
							  DriverManager.registerDriver(de);
							con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","santhu");
						
							ps1=con.prepareStatement("TRUNCATE TABLE ECETABLE");
							ps1.executeQuery();
							ps1=con.prepareStatement("insert into ECETABLE values(?,?)");
							fis1 = new FileInputStream(src1);
							XSSFWorkbook wb1=new XSSFWorkbook(fis1);
							XSSFSheet sheet1=wb1.getSheetAt(0);
							 count1=sheet1.getLastRowNum();
							 for(int i=0;i<=count1;i++)
								{
								 
								data2=sheet1.getRow(i).getCell(0).getStringCellValue();
								data3=  sheet1.getRow(i).getCell(1).getStringCellValue();
								
								ps1.setString(1,data2);
								ps1.setString(2, data3);
								ps1.executeUpdate();
								}
							 JOptionPane.showMessageDialog(null, "file uploaded successfully");
								
								String qry="select * from ECETABLE";
								Statement st1=con.createStatement();
								ResultSet rs1=st1.executeQuery(qry);
							table_2.setModel(DbUtils.resultSetToTableModel(rs1));
								
								
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						}	
				
				
				}}
			
				
			
		});
		btnUploadEceExcel.setBounds(536, 51, 169, 23);
		contentPane.add(btnUploadEceExcel);
		
		JButton btnUploadEeeExcel = new JButton("UPLOAD EEE EXCEL SHEET");
		btnUploadEeeExcel.setFont(new Font("Arial", Font.BOLD, 11));
		btnUploadEeeExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chose=new JFileChooser();
				int result=chose.showOpenDialog(null);
				if(result==JFileChooser.APPROVE_OPTION)
				
				{
					
						
					
					String path=chose.getSelectedFile().getAbsolutePath();
					JOptionPane.showMessageDialog(null, path);
					 src=new File(path);
			
						FileInputStream fis;
						try {
							
							  Driver de=new oracle.jdbc.driver.OracleDriver();
							  DriverManager.registerDriver(de);
							con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","santhu");
							ps=con.prepareStatement("TRUNCATE TABLE EEETABLE");
							ps.executeQuery();
							ps=con.prepareStatement("insert into EEETABLE values(?,?)");
							fis = new FileInputStream(src);
							XSSFWorkbook wb=new XSSFWorkbook(fis);
							XSSFSheet sheet=wb.getSheetAt(0);
							 count=sheet.getLastRowNum();
								
								for(int i=0;i<=count;i++)
								{
								 
								data=sheet.getRow(i).getCell(0).getStringCellValue();
								data1=  sheet.getRow(i).getCell(1).getStringCellValue();
								
								ps.setString(1,data);
								ps.setString(2, data1);
								ps.executeUpdate();
								}
								
								JOptionPane.showMessageDialog(null, "file uploaded successfully");
								
								String qry="select * from EEETABLE";
								Statement st=con.createStatement();
								ResultSet rs=st.executeQuery(qry);
							table_2.setModel(DbUtils.resultSetToTableModel(rs));
								
								
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						}		


					
				}
				
			}
		});
		btnUploadEeeExcel.setBounds(536, 135, 169, 23);
		contentPane.add(btnUploadEeeExcel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Arial", Font.BOLD, 11));
		btnBack.setForeground(new Color(128, 0, 0));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2 f5=new frame2();
				f5.show();
			}
		});
		btnBack.setBounds(677, 11, 89, 23);
		contentPane.add(btnBack);
		
		
		
		
	}
}
