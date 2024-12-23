package college;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Age extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	int s,l,n,o;
	int y1,y2;
	int k1,k2;
	int x1,x2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Age frame = new Age();
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
	public Age() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Age Calculator");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(162, 11, 131, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date of Birth:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(106, 69, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date of Today:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(106, 125, 102, 14);
		contentPane.add(lblNewLabel_1_1);
		
		t1 = new JTextField();
		t1.setToolTipText("dd//mm/yyyy");
		t1.setBounds(218, 69, 102, 17);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel l1 = new JLabel("");
		l1.setBounds(141, 225, 212, 14);
		
		contentPane.add(l1);
		
		t2 = new JTextField();
		t2.setToolTipText("dd/mm/yyyy");
		t2.setColumns(10);
		t2.setBounds(218, 123, 102, 17);
		contentPane.add(t2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
				String a=t1.getText();
				String b=t2.getText();
				
				       
				     DateTimeFormatter format =DateTimeFormatter.ofPattern("dd/MM/yyyy");
				     DateTimeFormatter format1 =DateTimeFormatter.ofPattern("dd-MM-yyyy");
				     LocalDate date1=parseDate(a,format,format1);
				     LocalDate date2=parseDate(b,format,format1);
				     if(date1!=null || date2!=null) {
				    	 Period date=Period.between(date1, date2);
				    	 l1.setText("Age: " + date.getYears() + " years, " +
			                date.getMonths() + " months, " + date.getDays() + " days");
				     }
				     else {
				    	 l1.setText("You Entered Wrong Input");
				     }
				     
				     
				}
				catch(Exception e1){
					System.out.println(e1);
				}}
			private static LocalDate parseDate(String dateStr,DateTimeFormatter... formats) {
				for(DateTimeFormatter format : formats) {
					try {
						return LocalDate.parse(dateStr,format);
						
					}
					catch(DateTimeParseException ignored){
						
					}
					
				}
				return null;
				
			}
				

			    
			
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(177, 172, 74, 29);
		contentPane.add(btnNewButton);
	}
}
