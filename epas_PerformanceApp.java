import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class epas_PerformanceWin implements ActionListener {
	
	JFrame f1;
	JPanel p1,p2,p3,p4;
	JLabel lblHead,lblRefNo,lblDate,lblSId,lblSName,lblGender,lblDept,lblSftName,lblJK,lblCommunicationSkill,lblConflictResolution,lblInterpersonalSkill,lblInitiative,lblTeamwork,lblDToImprove,lblOverallPerformance;
 JTextField txtRefNo,txtDate,txtSId,txtSName,txtGender,txtDept,txtSftName,txtJK,txtCommunicationSkill,txtConflictResolution,txtInterpersonalSkill,txtInitiative,txtTeamwork,txtDToImprove,txtOverallPerformance;
 JButton btnClear,btnSave,btnNext,btnPrev,btnSearch,btnDelete,btnUpdate,btnClose;
  ImageIcon imgClear,imgSave,imgNext,imgPrev,imgSearch,imgDelete,imgUpdate,imgClose;
 JComboBox cmbSId,cmbJK,cmbCommunicationSkill,cmbConflictResolution,cmbInterpersonalSkill,cmbInitiative,cmbTeamwork,cmbDToImprove,cmbOverallPerformance;
 JOptionPane dlg;
 JLabel b1,b2;

 Box vb,hb; 
 Font fnt1;
 Color maroon,mix;
 
  Connection conn;
 Statement stmtSave,stmtSelect,stmtSId,stmtUpdate,stmtDelete;
 Statement stmtSName;
 Statement stmtRefNo;
 String refno,date,sid,sname,gender,dept,sftname,jk,communicationskill,conflictresolution,interpersonalskill,initiative,teamwork,dtoimprove,overallperformance; 
 
 ResultSet rs,rsRefNo;
 ResultSet rsSId,rsSName;
 
 FlowLayout flw;
 GridLayout gl74,gl22;
 
 public epas_PerformanceWin() {
	f1=new JFrame ("EIPRSys");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	
lblHead= new JLabel ("Performance Appraisal");

lblRefNo= new JLabel("Reference Number:");
lblDate= new JLabel("Date:");
lblSId= new JLabel ("Staff Id:");
lblSName=new JLabel ("Staff Name:");
lblGender= new JLabel ("Gender:");
lblDept= new JLabel("Department:");;
lblSftName= new JLabel ("Shift Name:");
lblJK= new JLabel ("Job Knowledge:");
lblCommunicationSkill= new JLabel ("Communication Skill:");
lblConflictResolution= new JLabel ("Conflict Resolution:");
lblInterpersonalSkill= new JLabel ("Interpersonal Skill:");
lblInitiative= new JLabel("Initiative:");
lblTeamwork= new JLabel ("Teamwork:");
lblDToImprove= new JLabel("Desire To Improve:");
lblOverallPerformance= new JLabel ("Overall Performance:");


b1=new JLabel("");
b2=new JLabel("");


txtRefNo= new JTextField();
txtDate= new JTextField ();
txtSId= new JTextField ();
txtSName= new JTextField ();
txtGender= new JTextField ();
txtDept= new JTextField ();
txtSftName= new JTextField ();
txtJK= new JTextField ();
txtCommunicationSkill= new JTextField ();
txtConflictResolution= new JTextField ();
txtInterpersonalSkill= new JTextField ();
txtInitiative= new JTextField ();
txtTeamwork= new JTextField ();
txtDToImprove= new JTextField ();
txtOverallPerformance= new JTextField ();

cmbJK=new JComboBox();
cmbCommunicationSkill=new JComboBox();
cmbSId=new JComboBox();
cmbConflictResolution=new JComboBox();
cmbInterpersonalSkill=new JComboBox();
cmbInitiative=new JComboBox();
cmbTeamwork=new JComboBox();
cmbDToImprove=new JComboBox();
cmbOverallPerformance=new JComboBox();

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
txtSName.addActionListener(this);
txtGender.addActionListener(this);
txtDept.addActionListener(this);
txtSftName.addActionListener(this);

cmbSId.addActionListener(this);
cmbJK.addActionListener(this);
cmbCommunicationSkill.addActionListener(this);
cmbConflictResolution.addActionListener(this);
cmbInterpersonalSkill.addActionListener(this);
cmbInitiative.addActionListener(this);
cmbTeamwork.addActionListener(this);
cmbDToImprove.addActionListener(this);
cmbOverallPerformance.addActionListener(this);


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

maroon= new Color(128,0,0);
mix= new Color(125,70,200);

flw= new FlowLayout();
gl74= new GridLayout(7,4);
gl22= new GridLayout(2,2);

fnt1=new Font("Copperplate Gothic Bold",Font.BOLD,30);
lblHead.setFont(fnt1);
lblHead.setForeground(maroon);


cmbJK.addItem("--Select--");
cmbJK.addItem("Exceptional");
cmbJK.addItem("Exceeds Expectation");
cmbJK.addItem("Below expectation");
cmbJK.addItem("Needs Improvement");

cmbCommunicationSkill.addItem("--Select--");
cmbCommunicationSkill.addItem("Exceptional");
cmbCommunicationSkill.addItem("Exceeds Expectation");
cmbCommunicationSkill.addItem("Below expectation");
cmbCommunicationSkill.addItem("Needs Improvement");

cmbConflictResolution.addItem("--Select--");
cmbConflictResolution.addItem("Exceptional");
cmbConflictResolution.addItem("Exceeds Expectation");
cmbConflictResolution.addItem("Below expectation");
cmbConflictResolution.addItem("Needs Improvement");

cmbInterpersonalSkill.addItem("--Select--");
cmbInterpersonalSkill.addItem("Exceptional");
cmbInterpersonalSkill.addItem("Exceeds Expectation");
cmbInterpersonalSkill.addItem("Below expectation");
cmbInterpersonalSkill.addItem("Needs Improvement");

cmbInitiative.addItem("--Select--");
cmbInitiative.addItem("Exceptional");
cmbInitiative.addItem("Exceeds Expectation");
cmbInitiative.addItem("Below expectation");
cmbInitiative.addItem("Needs Improvement");

cmbTeamwork.addItem("--Select--");
cmbTeamwork.addItem("Exceptional");
cmbTeamwork.addItem("Exceeds Expectation");
cmbTeamwork.addItem("Below expectation");
cmbTeamwork.addItem("Needs Improvement");

cmbDToImprove.addItem("--Select--");
cmbDToImprove.addItem("Exceptional");
cmbDToImprove.addItem("Exceeds Expectation");
cmbDToImprove.addItem("Below expectation");
cmbDToImprove.addItem("Needs Improvement");

cmbOverallPerformance.addItem("--Select--");
cmbOverallPerformance.addItem("Exceptional");
cmbOverallPerformance.addItem("Exceeds Expectation");
cmbOverallPerformance.addItem("Below expectation");
cmbOverallPerformance.addItem("Needs Improvement");

cmbSId.addItem("--Select--");


p1.setLayout(flw);
p1.add(lblHead);

p2.setLayout(gl74);
p2.add(lblRefNo);
p2.add(txtRefNo);
p2.add(lblDate);
p2.add(txtDate);
p2.add(lblSId);
p2.add(cmbSId);
p2.add(b1);
p2.add(b2);
p2.add(lblSName);
p2.add(txtSName);
p2.add(lblGender);
p2.add(txtGender);
p2.add(lblDept);
p2.add(txtDept);
p2.add(lblSftName);
p2.add(txtSftName);
p2.add(lblJK);
p2.add(cmbJK);
p2.add(lblCommunicationSkill);
p2.add(cmbCommunicationSkill);
p2.add(lblConflictResolution);
p2.add(cmbConflictResolution);
p2.add(lblInterpersonalSkill);
p2.add(cmbInterpersonalSkill);
p2.add(lblInitiative);
p2.add(cmbInitiative);
p2.add(lblTeamwork);
p2.add(cmbTeamwork);


p3.setLayout(gl22);
p3.add(lblDToImprove);
p3.add(cmbDToImprove);
p3.add(lblOverallPerformance);
p3.add(cmbOverallPerformance);


p4.setLayout(flw);
p4.add(btnClear);
p4.add(btnSave);
p4.add(btnNext);
p4.add(btnPrev);
p4.add(btnSearch);
p4.add(btnDelete);
p4.add(btnUpdate);
p4.add(btnClose);

vb.add(Box.createVerticalStrut(30));
vb.add(p1);
vb.add(Box.createVerticalStrut(20));
vb.add(p2);
vb.add(p3);
vb.add(Box.createVerticalStrut(30));
vb.add(p4);
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
	  rs=stmtSelect.executeQuery("select * from epas_tblPerformance");
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
					dept=rsSName.getString("dept");
					sftname=rsSName.getString("sfname");
					
					
					txtSName.setText(sname);
					txtGender.setText(gender);
					txtDept.setText(dept);
					txtSftName.setText(sftname);
					
					
					txtSId.setText(sid);
					 cmbJK.requestFocus(); 
					
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
	   else if (ae.getSource()==cmbJK){
		   cmbCommunicationSkill.requestFocus();
	   }
	   else if (ae.getSource()==cmbCommunicationSkill){
		   cmbConflictResolution.requestFocus();
	   }
	   else if (ae.getSource()==cmbConflictResolution){
		   cmbInterpersonalSkill.requestFocus();
	   }
	   else if (ae.getSource()==cmbInterpersonalSkill){
		   cmbInitiative.requestFocus();
	   }
	   else if (ae.getSource()==cmbInitiative){
		   cmbTeamwork.requestFocus();
	   }
	   else if (ae.getSource()==cmbTeamwork){
		   cmbDToImprove.requestFocus();
	   }
	   else if (ae.getSource()==cmbDToImprove){
		   cmbOverallPerformance.requestFocus();
	   }
	   else if (ae.getSource()==cmbOverallPerformance){
		   btnSave.requestFocus();
	   }
	   
		   //implementing Enter ends here
		   
	  else if (ae.getSource()==btnClear){
		  
		  txtRefNo.setText("");
		  txtDate.setText("");
		  cmbSId.setSelectedIndex(0);
		  txtSName.setText("");
		  txtGender.setText("");
		  txtDept.setText("");
		  txtSftName.setText("");
		  cmbJK.setSelectedIndex(0);
		  cmbCommunicationSkill.setSelectedIndex(0);
		  cmbConflictResolution.setSelectedIndex(0);
		  cmbInterpersonalSkill.setSelectedIndex(0);
		  cmbInitiative.setSelectedIndex(0);
		  cmbTeamwork.setSelectedIndex(0);
		  cmbDToImprove.setSelectedIndex(0);
		  cmbOverallPerformance.setSelectedIndex(0);
		  
	  }
	  else if (ae.getSource()==btnSave){  
	  
	  refno=txtRefNo.getText();
	  date=txtDate.getText();
	  sid=cmbSId.getSelectedItem().toString();
	  sname=txtSName.getText();
	  gender=txtGender.getText();
	  dept=txtDept.getText();
	  sftname=txtSftName.getText();
	  jk=cmbJK.getSelectedItem().toString();
	  communicationskill=cmbCommunicationSkill.getSelectedItem().toString();
	  conflictresolution=cmbConflictResolution.getSelectedItem().toString();
	  interpersonalskill=cmbInterpersonalSkill.getSelectedItem().toString();
	  initiative=cmbInitiative.getSelectedItem().toString();
	  teamwork=cmbTeamwork.getSelectedItem().toString();
	  dtoimprove=cmbDToImprove.getSelectedItem().toString();
	  overallperformance=cmbOverallPerformance.getSelectedItem().toString();
	  
	  
	  try{
	  stmtSave=conn.createStatement();
	  stmtSave.executeUpdate("insert into epas_tblPerformance values('"+refno+"','"+date+"','"+sid+"','"+sname+"','"+gender+"','"+dept+"','"+sftname+"','"+jk+"','"+communicationskill+"','"+conflictresolution+"','"+interpersonalskill+"','"+initiative+"','"+teamwork+"','"+dtoimprove+"','"+overallperformance+"')");
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
		  dept=rs.getString("dept");
		  sftname=rs.getString("sftname");
		  jk=rs.getString("jk");
		  communicationskill=rs.getString("communicationskill");
		  conflictresolution=rs.getString("conflictresolution");
		  interpersonalskill=rs.getString("interpersonalskill");
		  initiative=rs.getString("initiative");
		  teamwork=rs.getString("teamwork");
		  dtoimprove=rs.getString("dtoimprove");
		  overallperformance=rs.getString("overallperformance");
		  
		  		  
		  txtRefNo.setText(refno);
		  txtDate.setText(date);
		  cmbSId.setSelectedItem(sid);
		  txtSName.setText(sname);
		  txtGender.setText(gender);
		  txtDept.setText(dept);
		  txtSftName.setText(sftname);
		  cmbJK.setSelectedItem(jk);
		  cmbCommunicationSkill.setSelectedItem(communicationskill);
		  cmbConflictResolution.setSelectedItem(conflictresolution);
		  cmbInterpersonalSkill.setSelectedItem(interpersonalskill);
		  cmbInitiative.setSelectedItem(initiative);
		  cmbTeamwork.setSelectedItem(teamwork);
		  cmbDToImprove.setSelectedItem(dtoimprove);
		  cmbOverallPerformance.setSelectedItem(overallperformance);
		 
		  
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
		  dept=rs.getString("dept");
		  sftname=rs.getString("sftname");
		  jk=rs.getString("jk");
		  communicationskill=rs.getString("communicationskill");
		  conflictresolution=rs.getString("conflictresolution");
		  interpersonalskill=rs.getString("interpersonalskill");
		  initiative=rs.getString("initiative");
		  teamwork=rs.getString("teamwork");
		  dtoimprove=rs.getString("dtoimprove");
		  overallperformance=rs.getString("overallperformance");
		  
		  		  
		  txtRefNo.setText(refno);
		  txtDate.setText(date);
		  cmbSId.setSelectedItem(sid);
		  txtSName.setText(sname);
		  txtGender.setText(gender);
		  txtDept.setText(dept);
		  txtSftName.setText(sftname);
		  cmbJK.setSelectedItem(jk);
		  cmbCommunicationSkill.setSelectedItem(communicationskill);
		  cmbConflictResolution.setSelectedItem(conflictresolution);
		  cmbInterpersonalSkill.setSelectedItem(interpersonalskill);
		  cmbInitiative.setSelectedItem(initiative);
		  cmbTeamwork.setSelectedItem(teamwork);
		  cmbDToImprove.setSelectedItem(dtoimprove);
		  cmbOverallPerformance.setSelectedItem(overallperformance);
		  
		  
		  }
	  }
	  catch(SQLException se){
		System.out.println("unable to go previous "+se);
	  }
	  }
	  else if(ae.getSource()==btnDelete){
	    sid=txtSId.getText();
		try{
			stmtDelete=conn.createStatement();
			stmtDelete.executeUpdate("delete from epas_tblPerformance where refno='"+refno+"'");
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
		 dept=txtDept.getText();
	     sftname=txtSftName.getText();
		 jk=cmbJK.getSelectedItem().toString();
		 communicationskill=cmbCommunicationSkill.getSelectedItem().toString();
		 conflictresolution=cmbConflictResolution.getSelectedItem().toString();
		 interpersonalskill=cmbInterpersonalSkill.getSelectedItem().toString();
		 initiative=cmbInitiative.getSelectedItem().toString();
		 teamwork=cmbTeamwork.getSelectedItem().toString();
		 dtoimprove=cmbDToImprove.getSelectedItem().toString();
		 overallperformance=cmbOverallPerformance.getSelectedItem().toString();
		
		
		try{
		stmtUpdate=conn.createStatement();
		stmtUpdate.executeUpdate("update epas_tblPerformance set date='"+date+"',sid='"+sid+"',sname='"+sname+"',gender='"+gender+"',dept='"+dept+"',sftname='"+sftname+"',jk='"+jk+"',communicationskill='"+communicationskill+"',conflictresolution='"+conflictresolution+"',interpersonalskill='"+interpersonalskill+"',initiative='"+initiative+"',teamwork='"+teamwork+"',dtoimprove='"+dtoimprove+"',overallperformance='"+overallperformance+"' where refno='"+refno+"'");
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
		rsRefNo=stmtRefNo.executeQuery("Select * from epas_tblPerformance where refno='"+refno+"'");
		if(rsRefNo.next()) {
		 
		  
		  
		  refno=rsRefNo.getString("refno");
		  date=rsRefNo.getString("date");
		  sid=rsRefNo.getString("sid");
		  sname=rsRefNo.getString("sname");
		  gender=rsRefNo.getString("gender");
		  dept=rsRefNo.getString("dept");
		  sftname=rsRefNo.getString("sftname");
		  jk=rsRefNo.getString("jk");
		  communicationskill=rsRefNo.getString("communicationskill");
		  conflictresolution=rsRefNo.getString("conflictresolution");
		  interpersonalskill=rsRefNo.getString("interpersonalskill");
		  initiative=rsRefNo.getString("initiative");
		  teamwork=rsRefNo.getString("teamwork");
		  dtoimprove=rsRefNo.getString("dtoimprove");
		  overallperformance=rsRefNo.getString("overallperformance");
		  
		  		  
		  txtRefNo.setText(refno);
		  txtDate.setText(date);
		  cmbSId.setSelectedItem(sid);
		  txtSName.setText(sname);
		  txtGender.setText(gender);
		  txtDept.setText(dept);
		  txtSftName.setText(sftname);
		  cmbJK.setSelectedItem(jk);
		  cmbCommunicationSkill.setSelectedItem(communicationskill);
		  cmbConflictResolution.setSelectedItem(conflictresolution);
		  cmbInterpersonalSkill.setSelectedItem(interpersonalskill);
		  cmbInitiative.setSelectedItem(initiative);
		  cmbTeamwork.setSelectedItem(teamwork);
		  cmbDToImprove.setSelectedItem(dtoimprove);
		  cmbOverallPerformance.setSelectedItem(overallperformance);
		  
		  
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
	 
class epas_PerformanceApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
epas_PerformanceWin staff;
staff= new epas_PerformanceWin();
	}
	}