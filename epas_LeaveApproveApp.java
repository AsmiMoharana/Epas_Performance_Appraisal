import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class epas_LeaveApproveWin implements ActionListener {
	
	JFrame f1;
	JPanel p1,p2,p3,p4,p5;
	JLabel lblHead,lblSlNo,lblDate,lblRefNo,lblSId,lblSName,lblGender,lblSftName,lblLeaveType,lblFromDate,lblToDate,lblRemark,lblStatus;
 JTextField txtSlNo,txtDate,txtRefNo,txtSId,txtSName,txtGender,txtSftName,txtLeaveType,txtFromDate,txtToDate,txtRemark,txtStatus;
 JButton btnClear,btnSave,btnNext,btnPrev,btnSearch,btnDelete,btnUpdate,btnClose;
  ImageIcon imgClear,imgSave,imgNext,imgPrev,imgSearch,imgDelete,imgUpdate,imgClose;
 JComboBox cmbRefNo,cmbStatus;
 JOptionPane dlg;
 JLabel b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;

 Box vb,hb; 
 Font fnt1;
 Color teal,mix;
 
  Connection conn;
 Statement stmtSave,stmtSelect,stmtRefNo,stmtUpdate,stmtDelete;
 Statement stmtSName;
 Statement stmtSlNo,stmtSId;
 String slno,date,refno,sid,sname,gender,sftname,leavetype,fromdate,todate,remark,status;
 ResultSet rs,rsRefNo,rsSlNo;
 ResultSet rsSId,rsSName;
 
 FlowLayout flw;
 GridLayout gl14,gl62, gl34;
 
 public epas_LeaveApproveWin() {
	f1=new JFrame ("EIPRSys");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	p5=new JPanel();
	p5=new JPanel();
	
lblHead= new JLabel ("Leave Approval");

lblSlNo= new JLabel("Sl No:");
lblDate= new JLabel("Date:");
lblRefNo= new JLabel("Reference No:");
lblSId= new JLabel ("Staff Id:");
lblSName=new JLabel ("Staff Name:");
lblGender= new JLabel ("Gender:");
lblSftName= new JLabel ("Shift Name:");
lblLeaveType= new JLabel ("Leave Type:");
lblFromDate= new JLabel ("From Date:");
lblToDate= new JLabel ("To Date:");
lblRemark= new JLabel ("Remark:");
lblStatus= new JLabel("Status:");

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
b13=new JLabel("");
b14=new JLabel("");
b15=new JLabel("");
b16=new JLabel("");


txtSlNo= new JTextField();
txtDate= new JTextField ();
txtRefNo= new JTextField ();
txtSId= new JTextField ();
txtSName= new JTextField ();
txtGender= new JTextField ();
txtSftName= new JTextField ();
txtLeaveType= new JTextField ();
txtFromDate= new JTextField ();
txtToDate= new JTextField ();
txtRemark= new JTextField ();
txtStatus= new JTextField ();

cmbRefNo=new JComboBox();
cmbStatus=new JComboBox();

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
txtRefNo.addActionListener(this);
txtSId.addActionListener(this);
txtSName.addActionListener(this);
txtGender.addActionListener(this);
txtSftName.addActionListener(this);
txtLeaveType.addActionListener(this);
txtFromDate.addActionListener(this);
txtToDate.addActionListener(this);
txtRemark.addActionListener(this);
txtStatus.addActionListener(this);

cmbRefNo.addActionListener(this);
cmbStatus.addActionListener(this);


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
gl62= new GridLayout(6,2);
gl34=new GridLayout(3,4);

fnt1=new Font("Copperplate Gothic Bold",Font.BOLD,30);
lblHead.setFont(fnt1);
lblHead.setForeground(teal);

cmbRefNo.addItem("--Select--");

cmbStatus.addItem("--Select--");
cmbStatus.addItem("Approved");
cmbStatus.addItem("Cancelled");

p1.setLayout(flw);
p1.add(lblHead);

p2.setLayout(gl14);
p2.add(lblSlNo);
p2.add(txtSlNo);
p2.add(lblDate);
p2.add(txtDate);


p3.setLayout(gl62);
p3.add(lblRefNo);
p3.add(cmbRefNo);
p3.add(b1);
p3.add(b2);
p3.add(lblSId);
p3.add(txtSId);
p3.add(b3);
p3.add(b4);
p3.add(lblSName);
p3.add(txtSName);
p3.add(b5);
p3.add(b6);
p3.add(lblGender);
p3.add(txtGender);
p3.add(b7);
p3.add(b8);
p3.add(lblSftName);
p3.add(txtSftName);
p3.add(b9);
p3.add(b10);
p3.add(lblLeaveType);
p3.add(txtLeaveType);
p3.add(b11);
p3.add(b12);

p4.setLayout(gl34);
p4.add(lblFromDate);
p4.add(txtFromDate);
p4.add(lblToDate);
p4.add(txtToDate);
p4.add(lblRemark);
p4.add(txtRemark);
p4.add(b13);
p4.add(b14);
p4.add(lblStatus);
p4.add(cmbStatus);
p4.add(b15);
p4.add(b16);


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
fillRefNo();
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
	  rs=stmtSelect.executeQuery("select * from epas_tblLeaveApproval");
	  }
	  catch(SQLException se){
		  System.out.println("Unable to connect");
	  }
 }
 public void fillRefNo(){
	 try{
        stmtRefNo=conn.createStatement();
		rsRefNo=stmtRefNo.executeQuery("select * from epas_tblLeaveApp");
		while(rsRefNo.next()){
            refno=rsRefNo.getString("refno");
			cmbRefNo.addItem(refno);			
		} // while ends
	 }// try ends
	 catch(SQLException se){
		System.out.println("Unable to create Reference No. Combo"); 
	 }
 }	 

 
public void actionPerformed(ActionEvent ae){
	if(ae.getSource()==btnClose){
		  f1.setVisible(false);
		  f1.dispose();
	  }
	  //show staff id,staff name,gender,shift name starts here
	  
	  else if(ae.getSource()==cmbRefNo && cmbRefNo.getSelectedIndex()>0){
		  refno=cmbRefNo.getSelectedItem().toString();
		  try{
			    stmtSId=conn.createStatement();
				rsSId=stmtSId.executeQuery("select * from epas_tblLeaveApp where refno='"+refno+"'");
				if(rsSId.next()){
					
					sid=rsSId.getString("sid");
					sname=rsSId.getString("sname");
					gender=rsSId.getString("gender");
					sftname=rsSId.getString("sftname");
					leavetype=rsSId.getString("leavetype");
					fromdate=rsSId.getString("fromdate");
					todate=rsSId.getString("todate");
					remark=rsSId.getString("remark");
					
					txtSId.setText(sid);
					txtSName.setText(sname);
					txtGender.setText(gender);
					txtSftName.setText(sftname);
					txtLeaveType.setText(leavetype);
					txtFromDate.setText(fromdate);
					txtToDate.setText(todate);
					txtRemark.setText(remark);
					
					txtRefNo.setText(refno);
					cmbStatus.requestFocus();
				}
		  }
		 catch(SQLException se){
			  System.out.println("Unable to show leave app data"+se);
			  
		  }
		  
	  }
	  // Ends here...
	  
	  // implementing enter starts here
	  
	   else if (ae.getSource()==txtSlNo){
		   txtDate.requestFocus();
	   }
	   else if (ae.getSource()==txtDate){
		   cmbRefNo.requestFocus();
	   }
	   else if (ae.getSource()==cmbRefNo){
		   cmbStatus.requestFocus();
	   }
		else if (ae.getSource()==cmbStatus){
		   btnSave.requestFocus();
		}
		   
		   //implementing Enter ends here
		   
		   
	  
	  else if (ae.getSource()==btnClear){
		  txtSlNo.setText("");
		  txtDate.setText("");
		  cmbRefNo.setSelectedIndex(0);
		  txtSId.setText("");
		  txtSName.setText("");
		  txtGender.setText("");
		  txtSftName.setText("");
		  txtLeaveType.setText("");
		  txtFromDate.setText("");
		  txtToDate.setText("");
		  txtRemark.setText("");
		  cmbStatus.setSelectedIndex(0);
		  
	  }
	  else if (ae.getSource()==btnSave){  
	  
	  slno=txtSlNo.getText();
	  date=txtDate.getText();
	  refno=cmbRefNo.getSelectedItem().toString();
	  sid=txtSId.getText();
	  sname=txtSName.getText();
	  gender=txtGender.getText();
	  sftname=txtSftName.getText();
	  leavetype=txtLeaveType.getText();
	  fromdate=txtFromDate.getText();
	  todate=txtToDate.getText();
	  remark=txtRemark.getText();
	  status=cmbStatus.getSelectedItem().toString();
	  
	  try{
	  stmtSave=conn.createStatement();
	  stmtSave.executeUpdate("insert into epas_tblLeaveApproval values('"+slno+"','"+date+"','"+refno+"','"+sid+"','"+sname+"','"+gender+"','"+sftname+"','"+leavetype+"','"+fromdate+"','"+todate+"','"+remark+"','"+status+"')");
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
		  refno=rs.getString("refno");
		  sid=rs.getString("sid");
		  sname=rs.getString("sname");
		  gender=rs.getString("gender");
		  sftname=rs.getString("sftname");
		  leavetype=rs.getString("leavetype");
		  fromdate=rs.getString("fromdate");
		  todate=rs.getString("todate");
		  remark=rs.getString("remark");
		  status=rs.getString("status");
		  		  
		  txtSlNo.setText(slno);
		  txtDate.setText(date);
		  cmbRefNo.setSelectedItem(refno);
		  txtSId.setText(sid);
		  txtSName.setText(sname);
		  txtGender.setText(gender);
		  txtSftName.setText(sftname);
		  txtLeaveType.setText(leavetype);
		  txtFromDate.setText(fromdate);
		  txtToDate.setText(todate);
		  txtRemark.setText(remark);
		  cmbStatus.setSelectedItem(status);
		  
	 }
	  }
	  catch(SQLException se){
	   System.out.println("unable to show"+se);
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
		  refno=rs.getString("refno");
		  sid=rs.getString("sid");
		  sname=rs.getString("sname");
		  gender=rs.getString("gender");
		  sftname=rs.getString("sftname");
		  leavetype=rs.getString("leavetype");
		  fromdate=rs.getString("fromdate");
		  todate=rs.getString("todate");
		  remark=rs.getString("remark");
		  status=rs.getString("status");
		  		  
		  txtSlNo.setText(slno);
		  txtDate.setText(date);
		  cmbRefNo.setSelectedItem(refno);
		  txtSId.setText(sid);
		  txtSName.setText(sname);
		  txtGender.setText(gender);
		  txtSftName.setText(sftname);
		  txtLeaveType.setText(leavetype);
		  txtFromDate.setText(fromdate);
		  txtToDate.setText(todate);
		  txtRemark.setText(remark);
		  cmbStatus.setSelectedItem(status);
		  
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
			stmtDelete.executeUpdate("delete from epas_tblLeaveApproval where slno='"+slno+"'");
			dlg.showMessageDialog(f1,"One Record Deleted","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to delete");
		}
		}
		else if(ae.getSource()==btnUpdate){
		  
		 slno=txtSlNo.getText();
	     date=txtDate.getText();
		 refno=cmbRefNo.getSelectedItem().toString();
	     sid=txtSId.getText();
	     sname=txtSName.getText();
	     gender=txtGender.getText();
	     sftname=txtSftName.getText();
	     leavetype=txtLeaveType.getText();
	     fromdate=txtFromDate.getText();
	     todate=txtToDate.getText();
	     remark=txtRemark.getText();
		 status=cmbStatus.getSelectedItem().toString();
		
		try{
		stmtUpdate=conn.createStatement();
		stmtUpdate.executeUpdate("update epas_tblLeaveApproval set refno='"+refno+"',date='"+date+"',sid='"+sid+"',sname='"+sname+"',gender='"+gender+"',sftname='"+sftname+"',leavetype='"+leavetype+"',fromdate='"+fromdate+"',todate='"+todate+"',status='"+status+"' where slno='"+slno+"'");
		dlg.showMessageDialog(f1,"One Record Updated","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to update "+se);
		}
		}
		else if(ae.getSource()==btnSearch){
				sid=dlg.showInputDialog(f1,"Enter Sl No. ","Search",1);
			
		try {
		stmtSlNo=conn.createStatement();
		rsSlNo=stmtSlNo.executeQuery("Select * from epas_tblLeaveApproval where slno='"+slno+"'");
		if(rsSlNo.next()) {
		  
		  
		  slno=rsSlNo.getString("slno");
		  date=rsSlNo.getString("date");
		  refno=rsSlNo.getString("refno");
		  sid=rsSlNo.getString("sid");
		  sname=rsSlNo.getString("sname");
		  gender=rsSlNo.getString("gender");
		  sftname=rsSlNo.getString("sftname");
		  leavetype=rsSlNo.getString("leavetype");
		  fromdate=rsSlNo.getString("fromdate");
		  todate=rsSlNo.getString("todate");
		  remark=rsSlNo.getString("remark");
		  status=rsSlNo.getString("status");
		  		  
		  txtSlNo.setText(slno);
		  txtDate.setText(date);
		  cmbRefNo.setSelectedItem(refno);
		  txtSId.setText(sid);
		  txtSName.setText(sname);
		  txtGender.setText(gender);
		  txtSftName.setText(sftname);
		  txtLeaveType.setText(leavetype);
		  txtFromDate.setText(fromdate);
		  txtToDate.setText(todate);
		  txtRemark.setText(remark);
		  cmbStatus.setSelectedItem(status);
			  
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
	 
class epas_LeaveApproveApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
epas_LeaveApproveWin staff;
staff= new epas_LeaveApproveWin();
	}
	}