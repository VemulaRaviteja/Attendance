import java.awt.Color;
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

public class start {

	private JFrame frame;
	private JTextField textField;
    int y,x=150;
    Fwriter fw=new Fwriter();
    Freader fr=new Freader();
    position p=new position(150);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start window = new start();
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
	public start() {
		initialize();
	}
	private void display(subject sb)
	{
		y=sb.getSubPos();
		frame.getContentPane().add(sb.present);
		frame.getContentPane().add(sb.absent);
		frame.getContentPane().add(sb.sname);
		frame.getContentPane().add(sb.value);
		frame.getContentPane().add(sb.delsub);
		frame.getContentPane().add(sb.edit);
		sb.sname.setBounds(x, y,100,25);
		sb.present.setBounds(x+200, y,100,25);
		sb.absent.setBounds(x+400, y,100,25);
		sb.value.setBounds(x+600,y,50,25);
		sb.edit.setBounds(x+700,y,130,25);
		sb.delsub.setBounds(x+925,y,125,25);
		sb.sname.setVisible(true);
		sb.sname.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		sb.present.setVisible(true);
		sb.absent.setVisible(true);
		sb.value.setVisible(true);
		sb.delsub.setVisible(true);
		sb.edit.setVisible(true);
		sb.present.setBackground(Color.GREEN);
		sb.present.setForeground(Color.white);
		sb.edit.setBackground(Color.orange);
		sb.edit.setForeground(Color.black);
		sb.edit.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		sb.edit.setFocusable(false);
		sb.delsub.setBackground(Color.black);
		sb.delsub.setForeground(Color.white);
		sb.delsub.setFocusable(false);
		sb.delsub.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		sb.present.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		sb.absent.setBackground(Color.red);
		sb.absent.setForeground(Color.white);
        sb.absent.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
        sb.value.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
        sb.present.setFocusable(false);
        sb.absent.setFocusable(false);
		p.setExact();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Attendance Manager");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\CR\\goblin-barrel.png"));
		textField = new JTextField();
		textField.setBounds(224, 36, 125, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("AddSubject");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=textField.getText();
				textField.setText("");
				int[] arr= {0,0};
				if(s.isEmpty()==false)
				{   y=p.getPos();
				    subject sb=new subject(s,arr,y);
				try{fw.setData("Subjects",s+".txt", arr);}catch(Exception e) {}
				display(sb);}
				else
				{JOptionPane.showMessageDialog(null,"Enter subject name");}
				
			}
		});
		btnEnter.setBounds(387, 36, 134, 25);
		btnEnter.setBackground(Color.BLUE);
		btnEnter.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFocusable(false);
		frame.getContentPane().add(btnEnter);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblSubject.setForeground(new Color(139, 0, 0));
		lblSubject.setBounds(126, 40, 56, 16);
		frame.getContentPane().add(lblSubject);
		
		try{loadfile();}catch(Exception e) {}
	}
	private void loadfile() throws IOException
	{
		String s[]=fr.dread("Subjects");
		for(String s1:s) {
			y=p.getPos();
			int a[]=fr.fread(s1);
			subject sb=new subject(s1.substring(0,s1.length()-4),a,y);
			display(sb);
		}
	}
}
