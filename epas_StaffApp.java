import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class epas_StaffWin implements ActionListener {
	
	JFrame f1;
	JPanel p1,p2,p3,p4;
	JLabel lblHead,lblSId,lblSName,lblGender,lblDOB,lblLocality,lblCity,lblState,lblPIN,lblPhone,lblMailid,lblQualification,lblYOP,lblDJoin,lblDept,lblSfCode,lblSfName,lblBSalary,lblDA,lblHRA,lblPF,lblTax;
 JTextField txtSId,txtSName,txtGender,txtDOB,txtLocality,txtCity,txtState,txtPIN,txtPhone,txtMailid,txtQualification,txtYOP,txtDJoin,txtDept,txtSfCode,txtSfName,txtBSalary,txtDA,txtHRA,txtPF,txtTax;
 JButton btnClear,btnSave,btnNext,btnPrev,btnSearch,btnDelete,btnUpdate,btnClose;
  ImageIcon imgClear,imgSave,imgNext,imgPrev,imgSearch,imgDelete,imgUpdate,imgClose;
 JComboBox cmbState,cmbGender,cmbSfCode,cmbDept;
 JOptionPane dlg;
 JLabel b1,b2,b3,b4;
 Box vb,hb; 
 Font fnt1;
 Color teal,mix;
 
  Connection conn;
 Statement stmtSave,stmtSelect,stmtSid,stmtUpdate,stmtDelete;
 Statement stmtDept;
 Statement stmtSfCode,stmtSfName;
 ResultSet rsDept;
 ResultSet rsSfCode,rsSfName;
 String sid,sname,gender,dbirth,locality,city,state,pin,phoneno,email,qual,yop,djoin,dept,sfcode,sfname,basic,daper,hraper,pfper,taxper;
 ResultSet rs,rsSid;
 
 FlowLayout flw;
 GridLayout gl23, gl104;
 
 public epas_StaffWin() {
	f1=new JFrame ("EIPRSys");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	
lblHead= new JLabel ("Staff Information");

lblSId= new JLabel("Staff Id");
lblSName= new JLabel("Staff Name");
lblGender= new JLabel ("Gender");
lblDOB=new JLabel ("               Date Of Birth");
lblLocality= new JLabel ("Locality");
lblCity= new JLabel ("               City");
lblState= new JLabel ("State/Union Teritory");
lblPIN= new JLabel ("               PIN");
lblPhone= new JLabel ("Phone Number");
lblMailid= new JLabel ("               E-MailId");
lblQualification= new JLabel ("Qualification");
lblYOP= new JLabel ("               YOP");
lblDJoin= new JLabel ("Date Of Join");
lblDept= new JLabel ("               Department");
lblSfCode= new JLabel ("Shift Code");
lblSfName= new JLabel ("               Shift Name");
lblBSalary= new JLabel ("Basic Salary");
lblDA= new JLabel ("DA %ge");
lblHRA= new JLabel ("               HRA %ge");
lblPF= new JLabel ("P.F %ge");
lblTax= new JLabel ("               Tax %ge");
b1=new JLabel("");
b2=new JLabel("");
b3=new JLabel("");
b4=new JLabel("");

txtSId= new JTextField();
txtSName= new JTextField ();
txtDOB= new JTextField ();
txtLocality= new JTextField ();
txtCity= new JTextField ();
txtPIN= new JTextField ();
txtPhone= new JTextField ();
txtMailid= new JTextField ();
txtQualification= new JTextField ();
txtYOP= new JTextField ();
txtDJoin= new JTextField ();
txtSfName= new JTextField ();
txtBSalary= new JTextField ();
txtDA= new JTextField ();
txtHRA= new JTextField ();
txtPF= new JTextField ();
txtTax= new JTextField ();

cmbState=new JComboBox();
cmbGender= new JComboBox ();
cmbDept=new JComboBox();
cmbSfCode=new JComboBox();

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
cmbSfCode.addActionListener(this);

btnClear.setToolTipText("Clear the Record");
btnSave.setToolTipText("Saves the Record");
btnNext.setToolTipText("Record goes Next");
btnPrev.setToolTipText("Goes to previous Record");
btnSearch.setToolTipText("Search the Record");
btnDelete.setToolTipText("Delete the Record");
btnUpdate.setToolTipText("Update the Record");
btnClose.setToolTipText("Close the page");

txtSId.addActionListener(this);
txtSName.addActionListener(this);
cmbGender.addActionListener(this);
txtDOB.addActionListener(this);
txtLocality.addActionListener(this);
txtCity.addActionListener(this);
cmbState.addActionListener(this);
txtPIN.addActionListener(this);
txtPhone.addActionListener(this);
txtMailid.addActionListener(this);
txtQualification.addActionListener(this);
txtYOP.addActionListener(this);
txtDJoin.addActionListener(this);
cmbDept.addActionListener(this);
cmbSfCode.addActionListener(this);
txtSfName.addActionListener(this);
txtBSalary.addActionListener(this);
txtDA.addActionListener(this);
txtHRA.addActionListener(this);
txtPF.addActionListener(this);
txtTax.addActionListener(this);



vb=Box.createVerticalBox();
hb=Box.createHorizontalBox();

teal= new Color(0,128,128);
mix= new Color(125,70,200);

flw= new FlowLayout();
gl23= new GridLayout(2,3);
gl104= new GridLayout(10,4);

fnt1=new Font("Copperplate Gothic Bold",Font.BOLD,28);
lblHead.setFont(fnt1);
lblHead.setForeground(teal);
cmbState.addItem("--Select--");
cmbState.addItem("Andhra Pradesh");
cmbState.addItem("Bihar");
cmbState.addItem("Goa");
cmbState.addItem("Chhattisgarh");
cmbState.addItem("West Bengal");
cmbState.addItem("Karnataka");
cmbState.addItem("Punjab");
cmbState.addItem("Maharashtra");
cmbState.addItem("Tripura");
cmbState.addItem("Mizoram");
cmbState.addItem("Uttar Pradesh");
cmbState.addItem("Haryana");
cmbState.addItem("Nagaland");
cmbState.addItem("Jharkhand");
cmbState.addItem("Odisha");
cmbState.addItem("Sikkim");
cmbState.addItem("Rajasthan");
cmbState.addItem("Tamil Nadu");
cmbState.addItem("Kerela");
cmbState.addItem("Madhya Pradesh");
cmbState.addItem("Arunachal Pradesh");
cmbState.addItem("Gujarat");
cmbState.addItem("Assam");
cmbState.addItem("Meghalaya");
cmbState.addItem("Manipur");
cmbState.addItem("Himachal Pradesh");
cmbState.addItem("Uttarakhand");
cmbState.addItem("Telangana");
cmbState.addItem("Delhi");
cmbState.addItem("Jammu & Kashmir");
cmbState.addItem("Andaman & Nicobar Island");
cmbState.addItem("Dadra & Nagar Haveli and Daman & Diu");
cmbState.addItem("Ladakh");
cmbState.addItem("Lakshadweep");
cmbState.addItem("Puducherry");
cmbState.addItem("Chandigarh");

cmbGender.addItem("--Select--");
cmbGender.addItem("Male");
cmbGender.addItem("Female");
cmbGender.addItem("Trans");
cmbGender.addItem("Bisexual");
cmbGender.addItem("Other");

cmbDept.addItem("--Select--");

cmbSfCode.addItem("--Select--");


p1.setLayout(flw);
p1.add(lblHead);

p2.setLayout(gl23);
p2.add(lblSId);
p2.add(txtSId);
p2.add(b3);
p2.add(lblSName);
p2.add(txtSName);
p2.add(b4);


p3.setLayout(gl104);
p3.add(lblGender);
p3.add(cmbGender);
p3.add(lblDOB);
p3.add(txtDOB);
p3.add(lblLocality);
p3.add(txtLocality);
p3.add(lblCity);
p3.add(txtCity);
p3.add(lblState);
p3.add(cmbState);
p3.add(lblPIN);
p3.add(txtPIN);
p3.add(lblPhone);
p3.add(txtPhone);
p3.add(lblMailid);
p3.add(txtMailid);
p3.add(lblQualification);
p3.add(txtQualification);
p3.add(lblYOP);
p3.add(txtYOP);
p3.add(lblDJoin);
p3.add(txtDJoin);
p3.add(lblDept);
p3.add(cmbDept);
p3.add(lblSfCode);
p3.add(cmbSfCode);
p3.add(lblSfName);
p3.add(txtSfName);
p3.add(lblBSalary);
p3.add(txtBSalary);
p3.add(b1);
p3.add(b2);
p3.add(lblDA);
p3.add(txtDA);
p3.add(lblHRA);
p3.add(txtHRA);
p3.add(lblPF);
p3.add(txtPF);
p3.add(lblTax);
p3.add(txtTax);


p4.setLayout(flw);
p4.add(btnClear);
p4.add(btnSave);
p4.add(btnNext);
p4.add(btnPrev);
p4.add(btnSearch);
p4.add(btnDelete);
p4.add(btnUpdate);
p4.add(btnClose);

vb.add(Box.createVerticalStrut(20));
vb.add(p1);
vb.add(Box.createVerticalStrut(10));
vb.add(p2);
vb.add(p3);
vb.add(Box.createVerticalStrut(30));
vb.add(p4);

hb.add(Box.createHorizontalStrut(20));
hb.add(vb);
hb.add(Box.createHorizontalStrut(20));
f1.setLayout(new BorderLayout());
f1.add(hb,BorderLayout.CENTER);
f1.setBounds(60,110,1200,550);
f1.setVisible(true);
doConnect();
fillDept();
fillSfCode();
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
	  rs=stmtSelect.executeQuery("select * from epas_tblStaff");
	  }
	  catch(SQLException se){
		  System.out.println("Unable to connect");
	  }
 }
 public void fillDept(){
	 try{
        stmtDept=conn.createStatement();
		rsDept=stmtDept.executeQuery("select * from epas_tblDepartment");
		while(rsDept.next()){
            dept=rsDept.getString("dname");
			cmbDept.addItem(dept);			
		} // while ends
	 }// try ends
	 catch(SQLException se){
		System.out.println("Unable to create Dept. Combo"); 
	 }
 }	 
	 public void fillSfCode(){
	 try{
        stmtSfCode=conn.createStatement();
		rsSfCode=stmtSfCode.executeQuery("select * from epas_tblShift");
		while(rsSfCode.next()){
            sfcode=rsSfCode.getString("sftcode");
			cmbSfCode.addItem(sfcode);			
		} // while ends
	 }// try ends
	 catch(SQLException se){
		System.out.println("Unable to create Shift Code Combo"); 
	 } 
	 
 }
 
 
 
public void actionPerformed(ActionEvent ae){
	if(ae.getSource()==btnClose){
		  f1.setVisible(false);
		  f1.dispose();
	  }
	  else if(ae.getSource()==cmbSfCode && cmbSfCode.getSelectedIndex()>0){
		  sfcode=cmbSfCode.getSelectedItem().toString();
		  try{
			    stmtSfName=conn.createStatement();
				rsSfName=stmtSfName.executeQuery("select * from epas_tblshift where sftcode='"+sfcode+"'");
				if(rsSfName.next()){
					sfname=rsSfName.getString("sftname");
					txtSfName.setText(sfname);
					
					txtSfCode.setText(sfcode);
					txtBSalary.requestFocus();
				}
		  }
		  catch(SQLException se){
			  System.out.println("Unable to show shift name");
		  }
	  } // show shiftname ends here
	  
	  else if (ae.getSource()==txtSId){
		   txtSName.requestFocus();
	   }
	   else if (ae.getSource()==txtSName){
		   cmbGender.requestFocus();
	   }
	   else if (ae.getSource()==cmbGender){
		   txtDOB.requestFocus();
	   }
	   else if (ae.getSource()==txtDOB){
		   txtLocality.requestFocus();
	   }
	   else if (ae.getSource()==txtLocality){
		   txtCity.requestFocus();
	   }
	   else if (ae.getSource()==txtCity){
		   cmbState.requestFocus();
	   }
	   else if (ae.getSource()==cmbState){
		   txtPIN.requestFocus();
	   }
	   else if (ae.getSource()==txtPIN){
		   txtPhone.requestFocus();
	   }
	   else if (ae.getSource()==txtPhone){
		   txtMailid.requestFocus();
	   }
	   else if (ae.getSource()==txtMailid){
		   txtQualification.requestFocus();
	   }
	   else if (ae.getSource()==txtQualification){
		   txtYOP.requestFocus();
	   }
	   else if (ae.getSource()==txtYOP){
		   txtDJoin.requestFocus();
	   }
	   else if (ae.getSource()==txtDJoin){
		   cmbDept.requestFocus();
	   }
	   else if (ae.getSource()==cmbDept){
		   cmbSfCode.requestFocus();
	   }
	   else if (ae.getSource()==cmbSfCode){
		   txtBSalary.requestFocus();
	   }
	   else if (ae.getSource()==txtBSalary){
		   txtDA.requestFocus();
	   }
	   else if (ae.getSource()==txtDA){
		   txtHRA.requestFocus();
	   }
	   else if (ae.getSource()==txtHRA){
		   txtPF.requestFocus();
	   }
	   else if (ae.getSource()==txtPF){
		   txtTax.requestFocus();
	   }
	   else if (ae.getSource()==txtTax){
		   btnSave.requestFocus();
	   }
	   
	  
	  
	  
	  else if (ae.getSource()==btnClear){
		  txtSId.setText("");
		  txtSName.setText("");
		  cmbGender.setSelectedIndex(0);
		  txtDOB.setText("");
		  txtLocality.setText("");
		  txtCity.setText("");
		  cmbState.setSelectedIndex(0);
		  txtPIN.setText("");
		  txtPhone.setText("");
		  txtMailid.setText("");
		  txtQualification.setText("");
		  txtYOP.setText("");
		  txtDJoin.setText("");
		  cmbDept.setSelectedIndex(0);
		  cmbSfCode.setSelectedIndex(0);
		  txtSName.setText("");
		  txtBSalary.setText("");
		  txtDA.setText("");
		  txtHRA.setText("");
		  txtPF.setText("");
		  txtTax.setText("");
	  }
	  else if (ae.getSource()==btnSave){  
	  sid=txtSId.getText();
	  sname=txtSName.getText();
	  gender=cmbGender.getSelectedItem().toString();
	  dbirth=txtDOB.getText();
	  locality=txtLocality.getText();
	  city=txtCity.getText();
	  state=cmbState.getSelectedItem().toString();
	  pin=txtPIN.getText();
	  phoneno=txtPhone.getText();
	  email=txtMailid.getText();
	  qual=txtQualification.getText();
	  yop=txtYOP.getText();
	  djoin=txtDJoin.getText();
	  dept=cmbDept.getSelectedItem().toString();
	  sfcode=cmbSfCode.getSelectedItem().toString();
	  sfname=txtSfName.getText();
	  basic=txtBSalary.getText();
	  daper=txtDA.getText();
	  hraper=txtHRA.getText();
	  pfper=txtPF.getText();
	  taxper=txtTax.getText();
	  
	  try{
	  stmtSave=conn.createStatement();
	  stmtSave.executeUpdate("insert into epas_tblStaff values('"+sid+"','"+sname+"','"+gender+"','"+dbirth+"','"+locality+"','"+city+"','"+state+"','"+pin+"','"+phoneno+"','"+email+"','"+qual+"','"+yop+"','"+djoin+"','"+dept+"','"+sfcode+"','"+sfname+"','"+basic+"','"+daper+"','"+hraper+"','"+pfper+"','"+taxper+"')");
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
		  sid=rs.getString("sid");
		  sname=rs.getString("sname");
		  gender=rs.getString("gender");
		  dbirth=rs.getString("dbirth");
		  locality=rs.getString("locality");
		  city=rs.getString("city");
		  state=rs.getString("state");
		  pin=rs.getString("pin");
		  phoneno=rs.getString("phoneno");
		  email=rs.getString("email");
		  qual=rs.getString("qual");
		  yop=rs.getString("yop");
		  djoin=rs.getString("djoin");
		  dept=rs.getString("dept");
		  sfcode=rs.getString("sfcode");
		  sfname=rs.getString("sfname");
		  basic=rs.getString("basic");
		  daper=rs.getString("daper");
		  hraper=rs.getString("hraper");
		  pfper=rs.getString("pfper");
		  taxper=rs.getString("taxper");
		  		  
		  txtSId.setText(sid);
		  txtSName.setText(sname);
		  cmbGender.setSelectedItem(gender);
		  txtDOB.setText(dbirth);
		  txtLocality.setText(locality);
		  txtCity.setText(city);
		  cmbState.setSelectedItem(state);
		  txtPIN.setText(pin);
		  txtPhone.setText(phoneno);
		  txtMailid.setText(email);
		  txtQualification.setText(qual);
		  txtYOP.setText(yop);
		  txtDJoin.setText(djoin);
		  cmbDept.setSelectedItem(dept);
		  cmbSfCode.setSelectedItem(sfcode);
		  txtSfName.setText(sfname);
		  txtBSalary.setText(basic);
		  txtDA.setText(daper);
		  txtHRA.setText(hraper);
		  txtPF.setText(pfper);
		  txtTax.setText(taxper);
		  
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
		  
		   sid=rs.getString("sid");
		  sname=rs.getString("sname");
		  gender=rs.getString("gender");
		  dbirth=rs.getString("dbirth");
		  locality=rs.getString("locality");
		  city=rs.getString("city");
		  state=rs.getString("state");
		  pin=rs.getString("pin");
		  phoneno=rs.getString("phoneno");
		  email=rs.getString("email");
		  qual=rs.getString("qual");
		  yop=rs.getString("yop");
		  djoin=rs.getString("djoin");
		  dept=rs.getString("dept");
		  sfcode=rs.getString("sfcode");
		  sfname=rs.getString("sfname");
		  basic=rs.getString("basic");
		  daper=rs.getString("daper");
		  hraper=rs.getString("hraper");
		  pfper=rs.getString("pfper");
		  taxper=rs.getString("taxper");
		  
		  
		  txtSId.setText(sid);
		  txtSName.setText(sname);
		  cmbGender.setSelectedItem(gender);
		  txtDOB.setText(dbirth);
		  txtLocality.setText(locality);
		  txtCity.setText(city);
		  cmbState.setSelectedItem(state);
		  txtPIN.setText(pin);
		  txtPhone.setText(phoneno);
		  txtMailid.setText(email);
		  txtQualification.setText(qual);
		  txtYOP.setText(yop);
		  txtDJoin.setText(djoin);
		  cmbDept.setSelectedItem(dept);
		  cmbSfCode.setSelectedItem(sfcode);
		  txtSfName.setText(sfname);
		  txtBSalary.setText(basic);
		  txtDA.setText(daper);
		  txtHRA.setText(hraper);
		  txtPF.setText(pfper);
		  txtTax.setText(taxper);
		  }
	  }
	  catch(SQLException se){
		System.out.println("unable to go show"+se);
	  }
	  }
	  else if(ae.getSource()==btnDelete){
	    sid=txtSId.getText();
		try{
			stmtDelete=conn.createStatement();
			stmtDelete.executeUpdate("delete from epas_tblStaff where sid='"+sid+"'");
			dlg.showMessageDialog(f1,"One Record Deleted","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to delete"+se);
		}
		}
		else if(ae.getSource()==btnUpdate){
		  
		  sid=txtSId.getText();
		  sname=txtSName.getText();
		  gender=cmbGender.getSelectedItem().toString();
		  dbirth=txtDOB.getText();
		  locality=txtLocality.getText();
		  city=txtCity.getText();
		  state=cmbState.getSelectedItem().toString();
		  pin=txtPIN.getText();
		  phoneno=txtPhone.getText();
		  email=txtMailid.getText();
		  qual=txtQualification.getText();
		  yop=txtYOP.getText();
		  djoin=txtDJoin.getText();
		  dept=cmbDept.getSelectedItem().toString();
		  sfcode=cmbSfCode.getSelectedItem().toString();
		  sfname=txtSfName.getText();
		  basic=txtBSalary.getText();
		  daper=txtDA.getText();
		  hraper=txtHRA.getText();
		  pfper=txtPF.getText();
		  taxper=txtTax.getText();
		
		try{
		stmtUpdate=conn.createStatement();
		stmtUpdate.executeUpdate("update epas_tblStaff set sname='"+sname+"',gender='"+gender+"',dbirth='"+dbirth+"',locality='"+locality+"',city='"+city+"',state='"+state+"',phoneno='"+phoneno+"',email='"+email+"',qual='"+qual+"',yop='"+yop+"',djoin='"+djoin+"',dept='"+dept+"',sfcode='"+sfcode+"',sfname='"+sfname+"',basic='"+basic+"',daper='"+daper+"',hraper='"+hraper+"',pfper='"+pfper+"',taxper='"+taxper+"' where sid='"+sid+"'");
		dlg.showMessageDialog(f1,"One Record Updated","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to update "+se);
		}
		}
		else if(ae.getSource()==btnSearch){
				sid=dlg.showInputDialog(f1,"Enter Staff Id. ","Search",1);
			
		try {
		stmtSid=conn.createStatement();
		rsSid=stmtSid.executeQuery("Select * from epas_tblStaff where sid='"+sid+"'");
		if(rsSid.next()) {
			   sid=rsSid.getString("sid");
		  sname=rsSid.getString("sname");
		  gender=rsSid.getString("gender");
		  dbirth=rsSid.getString("dbirth");
		  locality=rsSid.getString("locality");
		  city=rsSid.getString("city");
		  state=rsSid.getString("state");
		  pin=rsSid.getString("pin");
		  phoneno=rsSid.getString("phoneno");
		  email=rsSid.getString("email");
		  qual=rsSid.getString("qual");
		  yop=rsSid.getString("yop");
		  djoin=rsSid.getString("djoin");
		  dept=rsSid.getString("dept");
		  sfcode=rsSid.getString("sfcode");
		  sfname=rsSid.getString("sfname");
		  basic=rsSid.getString("basic");
		  daper=rsSid.getString("daper");
		  hraper=rsSid.getString("hraper");
		  pfper=rsSid.getString("pfper");
		  taxper=rsSid.getString("taxper");
			  
		  txtSId.setText(sid);
		  txtSName.setText(sname);
		  cmbGender.setSelectedItem(gender);
		  txtDOB.setText(dbirth);
		  txtLocality.setText(locality);
		  txtCity.setText(city);
		  cmbState.setSelectedItem(state);
		  txtPIN.setText(pin);
		  txtPhone.setText(phoneno);
		  txtMailid.setText(email);
		  txtQualification.setText(qual);
		  txtYOP.setText(yop);
		  txtDJoin.setText(djoin);
		  cmbDept.setSelectedItem(dept);
		  cmbSfCode.setSelectedItem(sfcode);
		  txtSfName.setText(sfname);
		  txtBSalary.setText(basic);
		  txtDA.setText(daper);
		  txtHRA.setText(hraper);
		  txtPF.setText(pfper);
		  txtTax.setText(taxper);
			  
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
	 
class epas_StaffApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
epas_StaffWin staff;
staff= new epas_StaffWin();
	}
	}
	