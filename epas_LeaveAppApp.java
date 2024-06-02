import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class epas_LeaveAppWin implements ActionListener {
	
	JFrame f1;
	JPanel p1,p2,p3,p4,p5;
	JLabel lblHead,lblRefNo,lblDate,lblSId,lblSName,lblGender,lblSftName,lblLeaveType,lblFromDate,lblToDate,lblRemark;
 JTextField txtRefNo,txtDate,txtSId,txtSName,txtGender,txtSftName,txtLeaveType,txtFromDate,txtToDate,txtRemark;
 JButton btnClear,btnSave,btnNext,btnPrev,btnSearch,btnDelete,btnUpdate,btnClose;
  ImageIcon imgClear,imgSave,imgNext,imgPrev,imgSearch,imgDelete,imgUpdate,imgClose;
 JComboBox cmbSId,cmbLeaveType;
 JOptionPane dlg;
 JLabel b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;

 Box vb,hb; 
 Font fnt1;
 Color teal,mix;
 
  Connection conn;
 Statement stmtSave,stmtSelect,stmtSId,stmtUpdate,stmtDelete;
 Statement stmtSName;
 Statement stmtRefNo;
 String refno,date,sid,sname,gender,sftname,leavetype,fromdate,todate,remark;
 ResultSet rs,rsRefNo;
 ResultSet rsSId,rsSName;
 
 FlowLayout flw;
 GridLayout gl14,gl52, gl24;
 
 public epas_LeaveAppWin() {
	f1=new JFrame ("EIPRSys");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	p5=new JPanel();
	p5=new JPanel();
	
lblHead= new JLabel ("Leave Application");

lblRefNo= new JLabel("Reference No.:");
lblDate= new JLabel("                Date:");
lblSId= new JLabel ("Staff Id:");
lblSName=new JLabel ("Staff Name:");
lblGender= new JLabel ("Gender:");
lblSftName= new JLabel ("Shift Name:");
lblLeaveType= new JLabel ("Leave Type:");
lblFromDate= new JLabel ("From Date:");
lblToDate= new JLabel ("               To Date:");
lblRemark= new JLabel ("Remark:");

b1=new JLabel("");
b2=new JLabel("");
b3=new JLabel("");
b4=new JLabel("");
b5=new JLabel("");
b6=new JLabel("");
b7=new JLabel("");
b8=new JLabel("");
b9=new JLabel("");
b10=new JLabel("");
b11=new JLabel("");
b12=new JLabel("");


txtRefNo= new JTextField();
txtDate= new JTextField ();
txtSId= new JTextField ();
txtSName= new JTextField ();
txtGender= new JTextField ();
txtSftName= new JTextField ();
txtLeaveType= new JTextField ();
txtFromDate= new JTextField ();
txtToDate= new JTextField ();
txtRemark= new JTextField ();

cmbSId=new JComboBox();
cmbLeaveType=new JComboBox();


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

txtRefNo.addActionListener(this);
txtDate.addActionListener(this);
cmbSId.addActionListener(this);
txtSName.addActionListener(this);
txtGender.addActionListener(this);
txtSftName.addActionListener(this);
txtLeaveType.addActionListener(this);
txtFromDate.addActionListener(this);
txtToDate.addActionListener(this);
txtRemark.addActionListener(this);

cmbSId.addActionListener(this);
cmbLeaveType.addActionListener(this);


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
gl52= new GridLayout(5,2);
gl24=new GridLayout(2,4);

fnt1=new Font("Copperplate Gothic Bold",Font.BOLD,30);
lblHead.setFont(fnt1);
lblHead.setForeground(teal);

cmbSId.addItem("--Select--");

cmbLeaveType.addItem("--Select--");
cmbLeaveType.addItem("Casual Leave");
cmbLeaveType.addItem("Earned/Vacation/Privilege Leave");
cmbLeaveType.addItem("Sick Leave/Medical Leave");
cmbLeaveType.addItem("Maternity Leave");
cmbLeaveType.addItem("Paternity Leave");
cmbLeaveType.addItem("Sabbatical Leave");
cmbLeaveType.addItem("Bereavement Leave");
cmbLeaveType.addItem("Marriage Leave");
cmbLeaveType.addItem("Compensatory Leave");
cmbLeaveType.addItem("Adoption Leave");
cmbLeaveType.addItem("Compassionate Leave");
cmbLeaveType.addItem("Half-day Leave");
cmbLeaveType.addItem("Public Holidays");
cmbLeaveType.addItem("Loss Of Pay Leave");

p1.setLayout(flw);
p1.add(lblHead);

p2.setLayout(gl14);
p2.add(lblRefNo);
p2.add(txtRefNo);
p2.add(lblDate);
p2.add(txtDate);


p3.setLayout(gl52);
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
p3.add(lblSftName);
p3.add(txtSftName);
p3.add(b7);
p3.add(b8);
p3.add(lblLeaveType);
p3.add(cmbLeaveType);
p3.add(b9);
p3.add(b10);

p4.setLayout(gl24);
p4.add(lblFromDate);
p4.add(txtFromDate);
p4.add(lblToDate);
p4.add(txtToDate);
p4.add(lblRemark);
p4.add(txtRemark);
p4.add(b11);
p4.add(b12);

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
	  rs=stmtSelect.executeQuery("select * from epas_tblLeaveApp");
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
	  //show staff name,gender,shift name starts here
	  
	  else if(ae.getSource()==cmbSId && cmbSId.getSelectedIndex()>0){
		  sid=cmbSId.getSelectedItem().toString();
		  try{
			    stmtSName=conn.createStatement();
				rsSName=stmtSName.executeQuery("select * from epas_tblStaff where sid='"+sid+"'");
				if(rsSName.next()){
					sname=rsSName.getString("sname");
					gender=rsSName.getString("gender");
					sftname=rsSName.getString("sfname");
					
					
					txtSName.setText(sname);
					txtGender.setText(gender);
					txtSftName.setText(sftname);
					
					txtSId.setText(sid);
					cmbLeaveType.requestFocus();
					
					
					
				}
		  }
		 catch(SQLException se){
			  System.out.println("Unable to show staff data"+se);
			  
		  }
		  
	  }
	  // Ends here...
	  
	  // implementing enter starts here
	  
	   else if (ae.getSource()==txtRefNo){
		   txtDate.requestFocus();
	   }
	   else if (ae.getSource()==txtDate){
		   cmbSId.requestFocus();
	   }
	   
	   else if (ae.getSource()==cmbLeaveType){
		   txtFromDate.requestFocus();
	   }
	   else if (ae.getSource()==txtFromDate){
		   txtToDate.requestFocus();
	   }
	   else if (ae.getSource()==txtToDate){
		   txtRemark.requestFocus();
	   }
		else if (ae.getSource()==txtRemark){
		   btnSave.requestFocus();
		}
		   
		   //implementing Enter ends here
		   
		   
	  
	  else if (ae.getSource()==btnClear){
		  txtRefNo.setText("");
		  txtDate.setText("");
		  cmbSId.setSelectedIndex(0);
		  txtSName.setText("");
		  txtGender.setText("");
		  txtSftName.setText("");
		  cmbLeaveType.setSelectedIndex(0);
		  txtFromDate.setText("");
		  txtToDate.setText("");
		  txtRemark.setText("");
		  
	  }
	  else if (ae.getSource()==btnSave){  
	  refno=txtRefNo.getText();
	  date=txtDate.getText();
	  sid=cmbSId.getSelectedItem().toString();
	  sname=txtSName.getText();
	  gender=txtGender.getText();
	  sftname=txtSftName.getText();
	  leavetype=cmbLeaveType.getSelectedItem().toString();
	  fromdate=txtFromDate.getText();
	  todate=txtToDate.getText();
	  remark=txtRemark.getText();
	 
	  
	  try{
	  stmtSave=conn.createStatement();
	  stmtSave.executeUpdate("insert into epas_tblLeaveApp values('"+refno+"','"+date+"','"+sid+"','"+sname+"','"+gender+"','"+sftname+"','"+leavetype+"','"+fromdate+"','"+todate+"','"+remark+"')");
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
		  
		  refno=rs.getString("refno");
		  date=rs.getString("date");
		  sid=rs.getString("sid");
		  sname=rs.getString("sname");
		  gender=rs.getString("gender");
		  sftname=rs.getString("sftname");
		  leavetype=rs.getString("leavetype");
		  fromdate=rs.getString("fromdate");
		  todate=rs.getString("todate");
		  remark=rs.getString("remark");
		  		  
		  txtRefNo.setText(refno);
		  txtDate.setText(date);
		  cmbSId.setSelectedItem(sid);
		  txtSName.setText(sname);
		  txtGender.setText(gender);
		  txtSftName.setText(sftname);
		  cmbLeaveType.setSelectedItem(leavetype);
		  txtFromDate.setText(fromdate);
		  txtToDate.setText(todate);
		  txtRemark.setText(remark);
		  
	 }
	  }
	  catch(SQLException se){
	   System.out.println("unable to show "+se);
	  }
	  }
	  else if(ae.getSource()==btnPrev){
	  try{
		  if(rs.isFirst()){
			  dlg.showMessageDialog(f1,"No more Records","Alert",1);
		  }
		  else{
		  rs.previous();
		  
		  refno=rs.getString("refno");
		  date=rs.getString("date");
		  sid=rs.getString("sid");
		  sname=rs.getString("sname");
		  gender=rs.getString("gender");
		  sftname=rs.getString("sftname");
		  leavetype=rs.getString("leavetype");
		  fromdate=rs.getString("fromdate");
		  todate=rs.getString("todate");
		  remark=rs.getString("remark");
		  		  
		  txtRefNo.setText(refno);
		  txtDate.setText(date);
		  cmbSId.setSelectedItem(sid);
		  txtSName.setText(sname);
		  txtGender.setText(gender);
		  txtSftName.setText(sftname);
		  cmbLeaveType.setSelectedItem(leavetype);
		  txtFromDate.setText(fromdate);
		  txtToDate.setText(todate);
		  txtRemark.setText(remark);
		  
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
			stmtDelete.executeUpdate("delete from epas_tblLeaveApp where refno='"+refno+"'");
			dlg.showMessageDialog(f1,"One Record Deleted","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to delete");
		}
		}
		else if(ae.getSource()==btnUpdate){
		  
		 refno=txtRefNo.getText();
	     date=txtDate.getText();
	     sid=cmbSId.getSelectedItem().toString();
	     sname=txtSName.getText();
	     gender=txtGender.getText();
	     sftname=txtSftName.getText();
	     leavetype=cmbLeaveType.getSelectedItem().toString();
	     fromdate=txtFromDate.getText();
	     todate=txtToDate.getText();
	     remark=txtRemark.getText();
		
		try{
		stmtUpdate=conn.createStatement();
		stmtUpdate.executeUpdate("update epas_tblLeaveApp set date='"+date+"',sid='"+sid+"',sname='"+sname+"',gender='"+gender+"',sftname='"+sftname+"',leavetype='"+leavetype+"',fromdate='"+fromdate+"',todate='"+todate+"' where refno='"+refno+"'");
		dlg.showMessageDialog(f1,"One Record Updated","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to update "+se);
		}
		}
		else if(ae.getSource()==btnSearch){
				refno=dlg.showInputDialog(f1,"Enter Reference No. ","Search",1);
			
		try {
		stmtRefNo=conn.createStatement();
		rsRefNo=stmtRefNo.executeQuery("Select * from epas_tblLeaveApp where refno='"+refno+"'");
		if(rsRefNo.next()) {
		  
		  
		  refno=rsRefNo.getString("refno");
		  date=rsRefNo.getString("date");
		  sid=rsRefNo.getString("sid");
		  sname=rsRefNo.getString("sname");
		  gender=rsRefNo.getString("gender");
		  sftname=rsRefNo.getString("sftname");
		  leavetype=rsRefNo.getString("leavetype");
		  fromdate=rsRefNo.getString("fromdate");
		  todate=rsRefNo.getString("todate");
		  remark=rsRefNo.getString("remark");
		  		  
		  txtRefNo.setText(refno);
		  txtDate.setText(date);
		  cmbSId.setSelectedItem(sid);
		  txtSName.setText(sname);
		  txtGender.setText(gender);
		  txtSftName.setText(sftname);
		  cmbLeaveType.setSelectedItem(leavetype);
		  txtFromDate.setText(fromdate);
		  txtToDate.setText(todate);
		  txtRemark.setText(remark);
			  
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
	 
class epas_LeaveAppApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
epas_LeaveAppWin staff;
staff= new epas_LeaveAppWin();
	}
	}