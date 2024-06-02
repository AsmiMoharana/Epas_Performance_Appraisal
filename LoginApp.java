import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class LoginWin implements ActionListener {
	
 JFrame f1;
 JPanel p1,p2,p3;
 JLabel lblHead,lblUName,lblPassWord;
 JTextField txtUName;
 JPasswordField txtPassWord;
 JButton btnLogin,btnReset;
 JOptionPane dlg;
 Box vb,hb; 
 Font fnt1;
 Color maroon,mix;

 Statement stmtSelect;
 ResultSet rs;
 
 Connection conn;
 String uname,password;
 
 FlowLayout flw;
 GridLayout gl22;
 
 public LoginWin() {
	f1=new JFrame ("EPAS");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	
lblHead= new JLabel ("Authentification");

lblUName= new JLabel ("User Name");
lblPassWord= new JLabel ("Password");

txtUName= new JTextField ();
txtPassWord= new JPasswordField();

dlg=new JOptionPane();


btnLogin= new JButton("Login");
btnReset= new JButton("Reset");


btnLogin.addActionListener(this);
btnReset.addActionListener(this);

txtUName.addActionListener(this);
txtPassWord.addActionListener(this);


btnLogin.setToolTipText("Login to open Menu");
btnReset.setToolTipText("Reset your Password");


vb=Box.createVerticalBox();
hb=Box.createHorizontalBox();

maroon= new Color(128,0,0);
mix= new Color(125,70,200);

flw= new FlowLayout();
gl22= new GridLayout(2,2);

fnt1=new Font("Copperplate Gothic Bold",Font.BOLD,25);
lblHead.setFont(fnt1);
lblHead.setForeground(maroon);

p1.setLayout(flw);
p1.add(lblHead);

p2.setLayout(gl22);
p2.add(lblUName);
p2.add(txtUName);
p2.add(lblPassWord);
p2.add(txtPassWord);

p3.setLayout(flw);
p3.add(btnLogin);
p3.add(btnReset);

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
f1.setBounds(383,84,500,310);
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
	 if (ae.getSource()==btnReset){
		  txtUName.setText("");
		  txtPassWord.setText("");
		 
	  }
	  
	  //implementing enter starts here
	  
	  else if (ae.getSource()==txtUName){
		   txtPassWord.requestFocus();
	   }
	   else if (ae.getSource()==txtPassWord){
		   btnLogin.requestFocus();
	   }
	  //implementing enter ends here
	  
	  
	  
	   
	  else if (ae.getSource()==btnLogin){  
	  uname=txtUName.getText();
	  password=txtPassWord.getText();
	  
	  
	  try{
	  stmtSelect=conn.createStatement();
	  rs=stmtSelect.executeQuery("select * from tblLogin where uname='"+uname+"' and password='"+password+"'");
	  if(rs.next()){
		  dlg.showMessageDialog(f1,"Welcome Admin...","epas",1);
		  f1.setVisible(false);
		  f1.dispose();
		  MenuWin menu;
		  menu=new MenuWin();
	  }
	  else{
		  dlg.showMessageDialog(f1,"Sorry! Access Denied...","epas",1);
	  }

	  }
	  catch(SQLException se){
	  System.out.println("unable to Login"+se);
	  }
	 
			}// login btn ends
		} //actionPerformed ends
}// class ends
	 
class LoginApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
LoginWin login;
login= new LoginWin();
	}
	}