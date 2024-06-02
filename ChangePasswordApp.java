import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class ChangePasswordWin implements ActionListener {
	
 JFrame f1;
 JPanel p1,p2,p3;
 JLabel lblHead,lblCurrPassword,lblNewPassword,lblConfirmPassword,lblCurrUsername,lblNewUsername;
 JTextField txtCurrPassword,txtCurrUsername,txtNewUsername;
 JPasswordField txtNewPassword,txtConfirmPassword;
 JButton btnReset,btnCancel;
 JOptionPane dlg;
 Box vb,hb; 
 Font fnt1;
 Color maroon,mix;


 Statement stmtSelect,stmtUpdate;
 ResultSet rs;
 
 Connection conn;
 String currpassword,newpassword,confirmpassword,currusername,newusername;
 
 FlowLayout flw;
 GridLayout gl52;
 
 public ChangePasswordWin() {
	f1=new JFrame ("EPAS");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	
lblHead= new JLabel ("Change Password");

lblCurrPassword= new JLabel ("Current Password");
lblNewPassword= new JLabel ("New Password");
lblConfirmPassword= new JLabel ("Confirm Password");
lblCurrUsername= new JLabel ("Current Username");
lblNewUsername= new JLabel ("New Username");

txtCurrPassword= new JTextField ();
txtNewPassword= new JPasswordField();
txtConfirmPassword= new JPasswordField();
txtCurrUsername= new JTextField();
txtNewUsername= new JTextField();


dlg=new JOptionPane();


btnReset= new JButton("Reset");
btnCancel= new JButton("Cancel");


btnReset.addActionListener(this);
btnCancel.addActionListener(this);

txtCurrPassword.addActionListener(this);
txtNewPassword.addActionListener(this);
txtConfirmPassword.addActionListener(this);

txtCurrUsername.addActionListener(this);
txtNewUsername.addActionListener(this);

btnReset.setToolTipText("Reset your Password");
btnCancel.setToolTipText("Do not change Password");


vb=Box.createVerticalBox();
hb=Box.createHorizontalBox();

maroon= new Color(128,0,0);
mix= new Color(125,70,200);

flw= new FlowLayout();
gl52= new GridLayout(5,2);

fnt1=new Font("Copperplate Gothic Bold",Font.BOLD,25);
lblHead.setFont(fnt1);
lblHead.setForeground(maroon);

p1.setLayout(flw);
p1.add(lblHead);

p2.setLayout(gl52);
p2.add(lblCurrPassword);
p2.add(txtCurrPassword);

p2.add(lblNewPassword);
p2.add(txtNewPassword);

p2.add(lblConfirmPassword);
p2.add(txtConfirmPassword);
 
p2.add(lblCurrUsername);
p2.add(txtCurrUsername);

p2.add(lblNewUsername);
p2.add(txtNewUsername);

p3.setLayout(flw);
p3.add(btnReset);
p3.add(btnCancel);

vb.add(Box.createVerticalStrut(20));
vb.add(p1);
vb.add(Box.createVerticalStrut(10));
vb.add(p2);
vb.add(Box.createVerticalStrut(30));
vb.add(p3);


hb.add(Box.createHorizontalStrut(20));
hb.add(vb);
hb.add(Box.createHorizontalStrut(20));
f1.setLayout(new BorderLayout());
f1.add(hb,BorderLayout.CENTER);
f1.setBounds(383,94,500,310);
f1.setVisible(true);
doConnect();
}
 public void doConnect(){
	  try{
	  Class.forName("com.mysql.jdbc.Driver");
	  }
	  catch(ClassNotFoundException enfe){
	  System.out.println("unable to load Driver");
	  }
	  try{
	  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/epasdb","root","root");
	  }
	  catch(SQLException se){
		  System.out.println("Unable to connect");
	  }
 }
public void actionPerformed(ActionEvent ae){

	  if(ae.getSource()==btnCancel){
		  f1.setVisible(false);
		  f1.dispose();
	  }
	  
	  //implementing enter starts here
	  
	  else if (ae.getSource()==txtCurrPassword){
		   txtNewPassword.requestFocus();
	   }
	   else if (ae.getSource()==txtNewPassword){
		   txtConfirmPassword.requestFocus();
	   }
	   else if(ae.getSource()==txtConfirmPassword){
	       txtCurrUsername.requestFocus();
	   }
	   else if (ae.getSource()==txtCurrUsername){
		   txtNewUsername.requestFocus();
	   }
	   else if (ae.getSource()==txtNewUsername){
	       btnReset.requestFocus();
	   }
	  //implementing enter ends here
	  
	  
	   
	  else if (ae.getSource()==btnReset){  
	  currpassword=txtCurrPassword.getText();
	  newpassword=txtNewPassword.getText();
	  confirmpassword=txtConfirmPassword.getText();
	  currusername=txtCurrUsername.getText();
	  newusername=txtNewUsername.getText();
	  
	  try{
	  stmtSelect=conn.createStatement();
	  rs=stmtSelect.executeQuery("select * from tbllogin where password='"+currpassword+"' and uname='"+currusername+"'");
	  if(rs.next()){
		  if(newpassword.equals(confirmpassword)){
			  // update query
			 // dlg.showMessageDialog(f1,"here","epas",1);
			  stmtUpdate=conn.createStatement();
			  stmtUpdate.executeUpdate("update tbllogin set password='"+newpassword+"',uname='"+newusername+"'");
		  dlg.showMessageDialog(f1,"Successfully changed your password..","epas",1);
		  } // match ends
		  else{
			  dlg.showMessageDialog(f1,"Password and Confirmed password does not match....","epas",1);
		  }
	  }
	  else{
		  dlg.showMessageDialog(f1,"Sorry! Access Denied...","epas",1);
	  }

	  }
	  catch(SQLException se){
	  System.out.println("unable to Reset Password"+se);
	  }
	  
	 
			}// login btn ends
		} //actionPerformed ends
}// class ends
	 
class ChangePasswordApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChangePasswordWin password;
password= new ChangePasswordWin();
	}
	}