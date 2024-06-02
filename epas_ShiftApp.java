import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class epas_ShiftWin implements ActionListener {
	
 JFrame f1;
 JPanel p1,p2,p3;
 JLabel lblHead,lblSCode,lblSName,lblSTime,lblETime;
 JTextField txtSCode,txtSName,txtSTime,txtETime;
 JButton btnClear,btnSave,btnNext,btnPrev,btnSearch,btnDelete,btnUpdate,btnClose;
  ImageIcon imgClear,imgSave,imgNext,imgPrev,imgSearch,imgDelete,imgUpdate,imgClose;
 JOptionPane dlg;
 Box vb,hb; 
 Font fnt1;
 Color maroon,mix;
 
 Connection conn;
 Statement stmtSave,stmtSelect,stmtSco,stmtUpdate,stmtDelete;
 String sco,sna,sttime,endtime;
 ResultSet rs,rsSco;
 
 FlowLayout flw;
 GridLayout gl42,gl31;
 
 public epas_ShiftWin() {
	f1=new JFrame ("EIPRSys");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	
lblHead= new JLabel ("Shift Information");

lblSCode= new JLabel ("Shift Code");
lblSName= new JLabel ("Shift Name");
lblSTime= new JLabel ("Start Time");
lblETime= new JLabel ("End Time");

txtSCode= new JTextField ();
txtSName= new JTextField ();
txtSTime= new JTextField ();
txtETime=new JTextField();

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

txtSCode.addActionListener(this);
txtSName.addActionListener(this);
txtSTime.addActionListener(this);
txtETime.addActionListener(this);


vb=Box.createVerticalBox();
hb=Box.createHorizontalBox();

maroon= new Color(128,0,0);
mix= new Color(125,70,200);

flw= new FlowLayout();
gl42= new GridLayout(4,2);
gl31= new GridLayout(3,1);

fnt1=new Font("Copperplate Gothic Bold",Font.BOLD,28);
lblHead.setFont(fnt1);
lblHead.setForeground(maroon);

p1.setLayout(flw);
p1.add(lblHead);

p2.setLayout(gl42);
p2.add(lblSCode);
p2.add(txtSCode);
p2.add(lblSName);
p2.add(txtSName);
p2.add(lblSTime);
p2.add(txtSTime);
p2.add(lblETime);
p2.add(txtETime);

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
	  rs=stmtSelect.executeQuery("select * from epas_tblShift");
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
	  
	  else if (ae.getSource()==txtSCode){
		   txtSName.requestFocus();
	   }
	   else if (ae.getSource()==txtSName){
		   txtSTime.requestFocus();
	   }
	   else if (ae.getSource()==txtSTime){
		   txtETime.requestFocus();
	   }
	   else if (ae.getSource()==txtETime){
		   btnSave.requestFocus();
	   }
	  
	  
	  else if (ae.getSource()==btnClear){
		  txtSCode.setText("");
		  txtSName.setText("");
		  txtSTime.setText("");
		  txtETime.setText("");
		 
	  }
	  else if (ae.getSource()==btnSave){  
	  sco=txtSCode.getText();
	  sna=txtSName.getText();
	  sttime=txtSTime.getText();
	  endtime=txtETime.getText();
	 
	  
	  try{
	  stmtSave=conn.createStatement();
	  stmtSave.executeUpdate("insert into epas_tblShift values('"+sco+"','"+sna+"','"+sttime+"','"+endtime+"')");
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
		  sco=rs.getString("sftcode");
		  sna=rs.getString("sftname");
		  sttime=rs.getString("sttime");
			endtime=rs.getString("endtime");
		  
		  txtSCode.setText(sco);
		  txtSName.setText(sna);
		  txtSTime.setText(sttime);
		  txtETime.setText(endtime);
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
		  
		  sco=rs.getString("sftcode");
		  sna=rs.getString("sftname");
		  sttime=rs.getString("sttime");
		  endtime=rs.getString("endtime");
		  
		  txtSCode.setText(sco);
		  txtSName.setText(sna);
		  txtSTime.setText(sttime);
		  txtETime.setText(endtime);
		  }
	  }
	  catch(SQLException se){
		System.out.println("unable to go show");
	  }
	  }
	  else if(ae.getSource()==btnDelete){
	    sco=txtSCode.getText();
		try{
			stmtDelete=conn.createStatement();
			stmtDelete.executeUpdate("delete from epas_tblShift where sftcode='"+sco+"'");
			dlg.showMessageDialog(f1,"One Record Deleted","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to delete");
		}
		}
		else if(ae.getSource()==btnUpdate){
		  
		  sco=txtSCode.getText();
		  sna=txtSName.getText();
		  sttime=txtSTime.getText();
		  endtime=txtETime.getText();
		
		try{
		stmtUpdate=conn.createStatement();
		stmtUpdate.executeUpdate("update epas_tblShift set sftname='"+sna+"',sttime='"+sttime+"',endtime='"+endtime+"' where sftcode='"+sco+"'");
		dlg.showMessageDialog(f1,"One Record Updated","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to update "+se);
		}
		}
		else if(ae.getSource()==btnSearch){
				sco=dlg.showInputDialog(f1,"Enter Shift Code ","Search",1);
			
		try {
		stmtSco=conn.createStatement();
		rsSco=stmtSco.executeQuery("Select * from epas_tblShift where sftcode='"+sco+"'");
		if(rsSco.next()) {
			  sna=rsSco.getString("sftname");
			  sttime=rsSco.getString("sttime");
			  endtime=rsSco.getString("endtime");
			  
			  txtSCode.setText(sco);
		      txtSName.setText(sna);
		      txtSTime.setText(sttime);
		      txtETime.setText(endtime);
			  
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
	 
class epas_ShiftApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
epas_ShiftWin dept;
dept= new epas_ShiftWin();
	}
	}