import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class subject {
	JButton present,absent,delsub,edit;
	JLabel value,sname;
	String name;
	JFrame f;private int y;
	Fwriter fw=new Fwriter();
	int[] details=new int[2];
	position p=new position();
	public  subject(String name,int[] arr,int y) {
		this.name=name;
		details=arr;
		present=new JButton("present");
		absent=new JButton("absent");
		delsub=new JButton("DeleteSubject");
		edit=new JButton("Edit Attendance");
		sname=new JLabel(name);
		sname.setForeground(Color.ORANGE);
		value=new JLabel();
		if(details[1]>0) {
		int temp=details[0]*1000/details[1];
		int sum;
		if(temp%10>=5) {sum=temp/10+1;}
		else{sum=temp/10;}
		value.setText(sum+"%");
		if(sum>=75) value.setForeground(Color.GREEN);
		else value.setForeground(Color.RED);
		}else  value.setText("NA");
		
		this.y=y;
		listen();
	}
	public int getSubPos() {
		return y;
	}
	/*public void display() {
		f.getContentPane().add(present);
		f.getContentPane().add(absent);
		f.getContentPane().add(sname);
		sname.setBounds(x, y,100,25);
		present.setBounds(x+200, y,100,25);
		absent.setBounds(x+400, y,100,25);
		sname.setVisible(true);
		present.setVisible(true);
		absent.setVisible(true);
	}*/
	private void listen() {
		present.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				details[0]++;
				details[1]++;
				int temp=(int)details[0]*1000/details[1];
				int sum;
				if(temp%10>=5) {sum=temp/10+1;}
				else{sum=temp/10;}
				value.setText(sum+"%");
				if(sum>=75) value.setForeground(Color.GREEN);
				else value.setForeground(Color.RED);
				try{fw.setData("Subjects",name+".txt",details);}catch(Exception e) {}
		    }
		});
		absent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(details[0]<0)details[0]=0;
				details[1]++;
				int temp=details[0]*1000/details[1];
				int sum;
				if(temp%10>=5) {sum=temp/10+1;}
				else{sum=temp/10;}
				value.setText(sum+"%");
				if(sum>=75) value.setForeground(Color.GREEN);
				else value.setForeground(Color.RED);
				try{fw.setData("Subjects",name+".txt",details);}catch(Exception e) {}
		    }
		});
		delsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setDelPos(y);
				fw.delFile(name+".txt");
				sname.setVisible(false);
				present.setVisible(false);
				absent.setVisible(false);
				value.setVisible(false);
				delsub.setVisible(false);
				edit.setVisible(false);
				present.getParent().remove(present);
				absent.getParent().remove(absent);
				delsub.getParent().remove(delsub);
				value.getParent().remove(value);
				sname.getParent().remove(sname);
				edit.getParent().remove(edit);
			}
		});	
	   edit.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			   JTextField present = new JTextField();
			   JTextField total = new JTextField();
			   Object[] message = {
			       "DaysPresent:", present,
			       "DaysTotal:", total,
			   };

			   int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
			   if (option == JOptionPane.OK_OPTION) {
			       details[0]=Integer.parseInt(present.getText());
			       details[1]=Integer.parseInt(total.getText());
			       //System.out.println(details[0]+" "+details[1]);
			       int arr[]=details;
			       if(details[1]>0) {
			   		int temp=details[0]*1000/details[1];
			   		int sum;
			   		if(temp%10>=5) {sum=temp/10+1;}
			   		else{sum=temp/10;}
			   		value.setText(sum+"%");
			   		if(sum>=75) value.setForeground(Color.GREEN);
			   		else value.setForeground(Color.RED);
			   		}else  value.setText("NA");
			       try{fw.setData("Subjects",name+".txt", arr);}catch(Exception j) {}
			   }
		   }
	   });
	}

}
