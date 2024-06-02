import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class epas_AttendOutWin implements ActionListener {
	
	JFrame f1;
	JPanel p1,p2,p3,p4,p5;
	JLabel lblHead,lblSlNo,lblDate,lblSId,lblSName,lblGender,lblDept,lblSftName,lblETime,lblOutTime,lblEarlyBy;
 JTextField txtSlNo,txtDate,txtSId,txtSName,txtGender,txtDept,txtSftName,txtETime,txtOutTime,txtEarlyBy;
 JButton btnClear,btnSave,btnNext,btnPrev,btnSearch,btnDelete,btnUpdate,btnClose;
  ImageIcon imgClear,imgSave,imgNext,imgPrev,imgSearch,imgDelete,imgUpdate,imgClose;
 JComboBox cmbSId;
 JOptionPane dlg;
 JLabel b1,b2,b3,b4,b5,b6,b7,b8;

 Box vb,hb; 
 Font fnt1;
 Color teal,mix;
 
  Connection conn;
 Statement stmtSave,stmtSelect,stmtSid,stmtUpdate,stmtDelete;
 Statement stmtSId,stmtSlNo;
 Statement stmtSName;
 ResultSet rsSId;
 ResultSet rsSName;
 Statement stmtSftEnd;
 ResultSet rsSftEnd;
 String slno,date,sid,sname,gender,dept,sftname,endtime,outtime,earlyby;
 String searlyby;
 ResultSet rs,rsSlNo;
 
 String ndhr,ndmn,outhr,outmn;
 int ndhr1,ndmn1,outhr1,outmn1,totend,totout,earlyby1;
 int erlyhr,erlymn;
 FlowLayout flw;
 GridLayout gl14,gl42, gl24;
 
 public epas_AttendOutWin() {
	f1=new JFrame ("EIPRSys");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	p5=new JPanel();
	
lblHead= new JLabel ("Attendance Register (Out)");

lblSlNo= new JLabel("Serial No.");
lblDate= new JLabel("                    Date");
lblSId= new JLabel ("Staff Id");
lblSName=new JLabel ("Staff Name");
lblGender= new JLabel ("Gender");
lblDept= new JLabel ("Department");
lblSftName= new JLabel ("Shift Name");
lblETime= new JLabel ("                    End Time");
lblOutTime= new JLabel ("Out Time");
lblEarlyBy= new JLabel ("                    Early By");

b1=new JLabel("");
b2=new JLabel("");
b3=new JLabel("");
b4=new JLabel("");
b5=new JLabel("");
b6=new JLabel("");
b7=new JLabel("");
b8=new JLabel("");

txtSlNo= new JTextField();
txtDate= new JTextField ();
txtSId= new JTextField ();
txtSName= new JTextField ();
txtGender= new JTextField ();
txtDept= new JTextField ();
txtSftName= new JTextField ();
txtETime= new JTextField ();
txtOutTime= new JTextField ();
txtEarlyBy= new JTextField ();


cmbSId=new JComboBox();


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

txtSlNo.addActionListener(this);
txtDate.addActionListener(this);
cmbSId.addActionListener(this);
txtSName.addActionListener(this);
txtGender.addActionListener(this);
txtDept.addActionListener(this);
txtSftName.addActionListener(this);
txtETime.addActionListener(this);
txtOutTime.addActionListener(this);
txtEarlyBy.addActionListener(this);

cmbSId.addActionListener(this);
txtOutTime.addActionListener(this);

btnClear.setToolTipText("Clear the Record");
btnSave.setToolTipText("Save the Record");
btnNext.setToolTipText("Go to next Record");
btnPrev.setToolTipText("Go to previous Record");
btnSearch.setToolTipText("Search Record");
btnDelete.setToolTipText("Delete Record");
btnUpdate.setToolTipText("Update Record");
btnClose.setToolTipText("Close the page");


vb=Box.createVerticalBox();
hb=Box.createHorizontalBox();

teal= new Color(0,128,128);
mix= new Color(125,70,200);

flw= new FlowLayout();
gl14= new GridLayout(1,4);
gl42= new GridLayout(4,2);
gl24= new GridLayout(2,4);

fnt1=new Font("Copperplate Gothic Bold",Font.BOLD,30);
lblHead.setFont(fnt1);
lblHead.setForeground(teal);

cmbSId.addItem("--Select--");


p1.setLayout(flw);
p1.add(lblHead);

p2.setLayout(gl14);
p2.add(lblSlNo);
p2.add(txtSlNo);
p2.add(lblDate);
p2.add(txtDate);


p3.setLayout(gl42);
p3.add(lblSId);
p3.add(cmbSId);
p3.add(b1);
p3.add(b2);
p3.add(lblSName);
p3.add(txtSName);
p3.add(b3);
p3.add(b4);
p3.add(lblGender);
p3.add(txtGender);
p3.add(b5);
p3.add(b6);
p3.add(lblDept);
p3.add(txtDept);
p3.add(b7);
p3.add(b8);

p4.setLayout(gl24);
p4.add(lblSftName);
p4.add(txtSftName);
p4.add(lblETime);
p4.add(txtETime);
p4.add(lblOutTime);
p4.add(txtOutTime);
p4.add(lblEarlyBy);
p4.add(txtEarlyBy);

p5.setLayout(flw);
p5.add(btnClear);
p5.add(btnSave);
p5.add(btnNext);
p5.add(btnPrev);
p5.add(btnSearch);
p5.add(btnDelete);
p5.add(btnUpdate);
p5.add(btnClose);

vb.add(Box.createVerticalStrut(40));
vb.add(p1);
vb.add(Box.createVerticalStrut(40));
vb.add(p2);
vb.add(p3);
vb.add(p4);
vb.add(Box.createVerticalStrut(30));
vb.add(p5);
hb.add(Box.createHorizontalStrut(30));
hb.add(vb);
hb.add(Box.createHorizontalStrut(30));
f1.setLayout(new BorderLayout());
f1.add(hb,BorderLayout.CENTER);
f1.setBounds(60,110,1200,530);
f1.setVisible(true);
doConnect();
fillSId();
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
	  rs=stmtSelect.executeQuery("select * from epas_tblAttendOut");
	  }
	  catch(SQLException se){
		  System.out.println("Unable to connect");
	  }
 }
 public void fillSId(){
	 try{
        stmtSId=conn.createStatement();
		rsSId=stmtSId.executeQuery("select * from epas_tblStaff");
		while(rsSId.next()){
            sid=rsSId.getString("sid");
			cmbSId.addItem(sid);			
		} // while ends
	 }// try ends
	 catch(SQLException se){
		System.out.println("Unable to create Staff Id. Combo"); 
	 }
 }	 

 
public void actionPerformed(ActionEvent ae){
	if(ae.getSource()==btnClose){
		  f1.setVisible(false);
		  f1.dispose();
	  }
	  //show staff name,gender,department,shift name starts here
	  
	  else if(ae.getSource()==cmbSId && cmbSId.getSelectedIndex()>0){
		  sid=cmbSId.getSelectedItem().toString();
		  try{
			    stmtSName=conn.createStatement();
				rsSName=stmtSName.executeQuery("select * from epas_tblStaff where sid='"+sid+"'");
				if(rsSName.next()){
					sname=rsSName.getString("sname");
					gender=rsSName.getString("gender");
					dept=rsSName.getString("dept");
					sftname=rsSName.getString("sfname");
					
					// collect end time
						stmtSftEnd=conn.createStatement();
						rsSftEnd=stmtSftEnd.executeQuery("Select * from epas_tblShift where sftname='"+sftname+"'");
						if(rsSftEnd.next())
							endtime=rsSftEnd.getString("endtime");
					// collect end time ends here 
					
					txtSName.setText(sname);
					txtGender.setText(gender);
					txtDept.setText(dept);
					txtSftName.setText(sftname);
					txtETime.setText(endtime);
					txtOutTime.requestFocus();
					
				}
		  }
		 catch(SQLException se){
			  System.out.println("Unable to show staff data"+se);
			  
		  }
		  
	  }
	  // Ends here...
	  
	  // calculating early by starts here
	  
	  else if (ae.getSource()==txtOutTime) {
		  
		  endtime=txtETime.getText();
		  outtime=txtOutTime.getText();
		  ndhr=endtime.substring(0,endtime.indexOf(":"));
		  ndmn=endtime.substring(endtime.indexOf(":")+1);
		  outhr=outtime.substring(0,outtime.indexOf(":"));
		  outmn=outtime.substring(outtime.indexOf(":")+1);
		  
		  ndhr1=Integer.parseInt(ndhr);
		  ndmn1=Integer.parseInt(ndmn);
		  outhr1=Integer.parseInt(outhr);
		  outmn1=Integer.parseInt(outmn);
		  totend=ndhr1*60+ndmn1;
		  totout=outhr1*60+outmn1;
		  earlyby1=totend-totout;
		  erlyhr=earlyby1 / 60;
		  erlymn=earlyby1 % 60;
		   searlyby=erlyhr+":"+erlymn;
		  //txtEarlyBy.setText(String.valueOf(searlyby1));
		  txtEarlyBy.setText(searlyby);
		  btnSave.requestFocus();
	  }
	  // ends here
	  
	  // implementing enter starts here
	  
	   else if (ae.getSource()==txtSlNo){
		   txtDate.requestFocus();
	   }
	   else if (ae.getSource()==txtDate){
		   cmbSId.requestFocus();
	   }
	 
		else if (ae.getSource()==txtOutTime){
		   btnSave.requestFocus();
		}
		   
		   //implementing Enter ends here
		   
		   
	  
	  else if (ae.getSource()==btnClear){
		  txtSlNo.setText("");
		  txtDate.setText("");
		  cmbSId.setSelectedIndex(0);
		  txtSName.setText("");
		  txtGender.setText("");
		  txtDept.setText("");
		  txtSftName.setText("");
		  txtETime.setText("");
		  txtOutTime.setText("");
		  txtEarlyBy.setText("");
		  
	  }
	  else if (ae.getSource()==btnSave){  
	  slno=txtSlNo.getText();
	  date=txtDate.getText();
	  sid=cmbSId.getSelectedItem().toString();
	  sname=txtSName.getText();
	  gender=txtGender.getText();
	  dept=txtDept.getText();
	  sftname=txtSftName.getText();
	  endtime=txtETime.getText();
	  outtime=txtOutTime.getText();
	  earlyby=txtEarlyBy.getText();
	 
	 
	  
	  try{
	  stmtSave=conn.createStatement();
	  stmtSave.executeUpdate("insert into epas_tblAttendOut values('"+slno+"','"+date+"','"+sid+"','"+sname+"','"+gender+"','"+dept+"','"+sftname+"','"+endtime+"','"+outtime+"','"+earlyby+"')");
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
		  
		  slno=rs.getString("slno");
		  date=rs.getString("date");
		  sid=rs.getString("sid");
		  sname=rs.getString("sname");
		  gender=rs.getString("gender");
		  dept=rs.getString("dept");
		  sftname=rs.getString("sftname");
		  endtime=rs.getString("endtime");
		  outtime=rs.getString("outtime");
		  earlyby=rs.getString("earlyby");
		  
		  		  
		  txtSlNo.setText(slno);
		  txtDate.setText(date);
		  cmbSId.setSelectedItem(sid);
		  txtSName.setText(sname);
		  txtGender.setText(gender);
		  txtDept.setText(dept);
		  txtSftName.setText(sftname);
		  txtETime.setText(endtime);
		  txtOutTime.setText(outtime);
		  txtEarlyBy.setText(earlyby);
		  
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
		  
		  slno=rs.getString("slno");
		  date=rs.getString("date");
		  sid=rs.getString("sid");
		  sname=rs.getString("sname");
		  gender=rs.getString("gender");
		  dept=rs.getString("dept");
		  sftname=rs.getString("sftname");
		  endtime=rs.getString("endtime");
		  outtime=rs.getString("outtime");
		  earlyby=rs.getString("earlyby");
		  
		  txtSlNo.setText(slno);
		  txtDate.setText(date);
		  cmbSId.setSelectedItem(sid);
		  txtSName.setText(sname);
		  txtGender.setText(gender);
		  txtDept.setText(dept);
		  txtSftName.setText(sftname);
		  txtETime.setText(endtime);
		  txtOutTime.setText(outtime);
		  txtEarlyBy.setText(earlyby);
		  }
	  }
	  catch(SQLException se){
		System.out.println("unable to go previous");
	  }
	  }
	  else if(ae.getSource()==btnDelete){
	    sid=txtSId.getText();
		try{
			stmtDelete=conn.createStatement();
			stmtDelete.executeUpdate("delete from epas_tblAttendOut where slno='"+slno+"'");
			dlg.showMessageDialog(f1,"One Record Deleted","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to delete");
		}
		}
		else if(ae.getSource()==btnUpdate){
		  
		  slno=txtSlNo.getText();
		  date=txtDate.getText();
		  sid=cmbSId.getSelectedItem().toString();
		  sname=txtSName.getText();
		  gender=txtGender.getText();
		  dept=txtDept.getText();
		  sftname=txtSftName.getText();
		  endtime=txtETime.getText();
		  outtime=txtOutTime.getText();
		  earlyby=txtEarlyBy.getText();
		
		try{
		stmtUpdate=conn.createStatement();
		stmtUpdate.executeUpdate("update epas_tblAttendOut set date='"+date+"',sid='"+sid+"',sname='"+sname+"',gender='"+gender+"',dept='"+dept+"',sftname='"+sftname+"',endtime='"+endtime+"',outtime='"+outtime+"',earlyby='"+earlyby+"' where slno='"+slno+"'");
		dlg.showMessageDialog(f1,"One Record Updated","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to update "+se);
		}
		}
		else if(ae.getSource()==btnSearch){
				sid=dlg.showInputDialog(f1,"Enter Serial No. ","Search",1);
			
		try {
		stmtSlNo=conn.createStatement();
		rsSlNo=stmtSlNo.executeQuery("Select * from epas_tblAttendOut where slno='"+slno+"'");
		if(rsSlNo.next()) {
		  
		  
		  slno=rs.getString("slno");
		  date=rs.getString("date");
		  sid=rs.getString("sid");
		  sname=rs.getString("sname");
		  gender=rs.getString("gender");
		  dept=rs.getString("dept");
		  sftname=rs.getString("sftname");
		  endtime=rs.getString("endtime");
		  outtime=rs.getString("outtime");
		  earlyby=rs.getString("earlyby");
		  
		  txtSlNo.setText(slno);
		  txtDate.setText(date);
		  cmbSId.setSelectedItem(sid);
		  txtSName.setText(sname);
		  txtGender.setText(gender);
		  txtDept.setText(dept);
		  txtSftName.setText(sftname);
		  txtETime.setText(endtime);
		  txtOutTime.setText(outtime);
		  txtEarlyBy.setText(earlyby);
			  
		}
		else {
			dlg.showMessageDialog(f1,"Record Not Found","Alert",1);
		}
		}
		catch(SQLException se) {
			System.out.println("Unable to search"+se);
		}
			}// search btn ends
		} //actionPerformed ends
		} // class ends
	 
class epas_AttendOutApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
epas_AttendOutWin staff;
staff= new epas_AttendOutWin();
	}
	}