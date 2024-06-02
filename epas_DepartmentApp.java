import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class epas_DepartmentWin implements ActionListener {
	
 JFrame f1;
 JPanel p1,p2,p3;
 JLabel lblHead,lblDCode,lblDName,lblHOD,lblPhone;
 JTextField txtDCode,txtDName,txtHOD,txtPhone;
 JButton btnClear,btnSave,btnNext,btnPrev,btnSearch,btnDelete,btnUpdate,btnClose;
  ImageIcon imgClear,imgSave,imgNext,imgPrev,imgSearch,imgDelete,imgUpdate,imgClose;
 JOptionPane dlg;
 Box vb,hb; 
 Font fnt1;
 Color green,mix;
 
 Connection conn;
 Statement stmtSave,stmtSelect,stmtDco,stmtUpdate,stmtDelete;
 String dco,dna,hod,phn;
 ResultSet rs,rsDco;
 
 FlowLayout flw;
 GridLayout gl42,gl31;
 
 public epas_DepartmentWin() {
	f1=new JFrame ("EIPRSys");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	
lblHead= new JLabel ("Department Information");

lblDCode= new JLabel ("Department Code");
lblDName= new JLabel ("Department Name");
lblHOD= new JLabel ("Head Of the Department");
lblPhone= new JLabel ("Phone Number");

txtDCode= new JTextField ();
txtDName= new JTextField ();
txtHOD= new JTextField ();
txtPhone=new JTextField();
dlg=new JOptionPane();

imgClear=new ImageIcon("INew.png");
imgSave=new ImageIcon("ISave.png");
imgNext=new ImageIcon("INext.png");
imgPrev=new ImageIcon("IPrior.png");
imgSearch=new ImageIcon("ISearch.png");
imgDelete=new ImageIcon("IDelete.png");
imgUpdate=new ImageIcon("IEdit.png");
imgClose=new ImageIcon("IClose.png");

btnClear= new JButton("Clear",imgClear);
btnSave= new JButton("Save",imgSave);
btnNext= new JButton("Next",imgNext);
btnPrev= new JButton("Previous",imgPrev);
btnSearch= new JButton("Search",imgSearch);
btnDelete= new JButton("Delete",imgDelete);
btnUpdate= new JButton("Update",imgUpdate);
btnClose= new JButton("Close",imgClose);


btnClear.addActionListener(this);
btnSave.addActionListener(this);
btnNext.addActionListener(this);
btnPrev.addActionListener(this);
btnDelete.addActionListener(this);
btnUpdate.addActionListener(this);
btnSearch.addActionListener(this);
btnClose.addActionListener(this);

btnClear.setToolTipText("Clear the Record");
btnSave.setToolTipText("Saves the Record");
btnNext.setToolTipText("Record goes Next");
btnPrev.setToolTipText("Goes to previous Record");
btnSearch.setToolTipText("Search the Record");
btnDelete.setToolTipText("Delete the Record");
btnUpdate.setToolTipText("Update the Record");
btnClose.setToolTipText("Close the page");

txtDCode.addActionListener(this);
txtDName.addActionListener(this);
txtHOD.addActionListener(this);
txtPhone.addActionListener(this);


vb=Box.createVerticalBox();
hb=Box.createHorizontalBox();

green= new Color(0,128,0);
mix= new Color(125,70,200);

flw= new FlowLayout();
gl42= new GridLayout(4,2);
gl31= new GridLayout(3,1);

fnt1=new Font("Copperplate Gothic Bold",Font.BOLD,28);
lblHead.setFont(fnt1);
lblHead.setForeground(green);
p1.setLayout(flw);
p1.add(lblHead);

p2.setLayout(gl42);
p2.add(lblDCode);
p2.add(txtDCode);
p2.add(lblDName);
p2.add(txtDName);
p2.add(lblHOD);
p2.add(txtHOD);
p2.add(lblPhone);
p2.add(txtPhone);

p3.setLayout(flw);
p3.add(btnClear);
p3.add(btnSave);
p3.add(btnNext);
p3.add(btnPrev);
p3.add(btnSearch);
p3.add(btnDelete);
p3.add(btnUpdate);
p3.add(btnClose);

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
f1.setBounds(200,100,800,450);
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
	  stmtSelect=conn.createStatement();
	  rs=stmtSelect.executeQuery("select * from epas_tblDepartment");
	  }
	  catch(SQLException se){
		  System.out.println("Unable to connect");
	  }
 }
public void actionPerformed(ActionEvent ae){
	if(ae.getSource()==btnClose){
		  f1.setVisible(false);
		  f1.dispose();
	  }
	  
	  //implementing enter starts here
	  
	  else if (ae.getSource()==txtDCode){
		   txtDName.requestFocus();
	   }
	   else if (ae.getSource()==txtDName){
		   txtHOD.requestFocus();
	   }
	  else if (ae.getSource()==txtHOD){
		   txtPhone.requestFocus();
	   }
	   else if (ae.getSource()==txtPhone){
		   btnSave.requestFocus();
	   }
	  
	  //implementing enter ends here
	  
	  else if (ae.getSource()==btnClear){
		  txtDCode.setText("");
		  txtDName.setText("");
		  txtHOD.setText("");
		  txtPhone.setText("");
		 
	  }
	  else if (ae.getSource()==btnSave){  
	  dco=txtDCode.getText();
	  dna=txtDName.getText();
	  hod=txtHOD.getText();
	  phn=txtPhone.getText();
	  
	  try{
	  stmtSave=conn.createStatement();
	  stmtSave.executeUpdate("insert into epas_tblDepartment values('"+dco+"','"+dna+"','"+hod+"','"+phn+"')");
	 dlg.showMessageDialog(f1,"One Record Saved Successfully","Alert",1);
	  }
	  catch(SQLException se){
	  System.out.println("unable to save"+se);
	  }
	  }
	  else if (ae.getSource()==btnNext){
	  try{
		  if(rs.isLast()){
			  dlg.showMessageDialog(f1,"No more Records","Alert",1);
		  }
     else
	 {
		  rs.next();
		  dco=rs.getString("dcode");
		  dna=rs.getString("dname");
		  hod=rs.getString("hod");
		  phn=rs.getString("phoneno");
		  
		  txtDCode.setText(dco);
		  txtDName.setText(dna);
		  txtHOD.setText(hod);
		  txtPhone.setText(phn);
	 }
	  }
	  catch(SQLException se){
	   System.out.println("unable to show");
	  }
	  }
	  else if(ae.getSource()==btnPrev){
	  try{
		  if(rs.isFirst()){
			  dlg.showMessageDialog(f1,"No more Records","Alert",1);
		  }
		  else{
		  rs.previous();
		  
		  dco=rs.getString("dcode");
		  dna=rs.getString("dname");
		  hod=rs.getString("hod");
		  phn=rs.getString("phoneno");
		  
		  txtDCode.setText(dco);
		  txtDName.setText(dna);
		  txtHOD.setText(hod);
		  txtPhone.setText(phn);
		  }
	  }
	  catch(SQLException se){
		System.out.println("unable to go show");
	  }
	  }
	  else if(ae.getSource()==btnDelete){
	    dco=txtDCode.getText();
		try{
			stmtDelete=conn.createStatement();
			stmtDelete.executeUpdate("delete from epas_tblDepartment where dcode='"+dco+"'");
			dlg.showMessageDialog(f1,"One Record Deleted","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to delete");
		}
		}
		else if(ae.getSource()==btnUpdate){
		  
		  dco=txtDCode.getText();
		  dna=txtDName.getText();
		  hod=txtHOD.getText();
		  phn=txtPhone.getText();
		
		try{
		stmtUpdate=conn.createStatement();
		stmtUpdate.executeUpdate("update epas_tblDepartment set dname='"+dna+"',hod='"+hod+"',phoneno='"+phn+"' where dcode='"+dco+"'");
		dlg.showMessageDialog(f1,"One Record Updated","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to update "+se);
		}
		}
		else if(ae.getSource()==btnSearch){
				dco=dlg.showInputDialog(f1,"Enter Dept. Code ","Search",1);
			
		try {
		stmtDco=conn.createStatement();
		rsDco=stmtDco.executeQuery("Select * from epas_tblDepartment where dcode='"+dco+"'");
		if(rsDco.next()) {
			  dna=rsDco.getString("dname");
			  hod=rsDco.getString("hod");
			  phn=rsDco.getString("phoneno");

			  txtDCode.setText(dco);
			  txtDName.setText(dna);
			  txtHOD.setText(hod);
			  txtPhone.setText(phn); 
			  
		}
		else {
			dlg.showMessageDialog(f1,"Record Not Found","Alert",1);
		}
		}
		catch(SQLException se) {
			System.out.println("Unable to search");
		}
			}// search btn ends
		} //actionPerformed ends
		} // class ends
	 
class epas_DepartmentApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
epas_DepartmentWin dept;
dept= new epas_DepartmentWin();
	}
	}
