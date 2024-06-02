import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class epas_IndusWin implements ActionListener {
	
 JFrame f1;
 JPanel p1,p2,p3,p4;
 JLabel lblHead,lblRNumber,lblIName,lblHOI,lblLocality,lblCity,lblState,lblPhone,lblMailid,lblGST,lblDate;
 JTextField txtRNumber,txtIName,txtHOI,txtLocality,txtCity,txtState,txtPhone,txtMailid,txtGST,txtDate;
 JButton btnClear,btnSave,btnNext,btnPrev,btnSearch,btnDelete,btnUpdate,btnClose;
  ImageIcon imgClear,imgSave,imgNext,imgPrev,imgSearch,imgDelete,imgUpdate,imgClose;
 JComboBox cmbState;
 JOptionPane dlg;
 Box vb,hb; 
 Font fnt1;
 Color red,mix;
 
 Connection conn;
 Statement stmtSave,stmtSelect,stmtDco,stmtUpdate,stmtDelete,stmtRno;
 String rno,ina,hoi,loc,city,state,phn,mail,gst,dt;
 ResultSet rs,rsRno;
 
 FlowLayout flw;
 GridLayout gl62, gl24;
 
 public epas_IndusWin() {
	f1=new JFrame ("EIPRSys");
	p1=new JPanel();
	p2=new JPanel();
	p3=new JPanel();
	p4=new JPanel();
	
lblHead= new JLabel ("Industry Profile");

lblRNumber= new JLabel ("Registration Number");
lblIName= new JLabel ("Industry Name");
lblHOI= new JLabel ("Head Of the Industry");
lblLocality= new JLabel ("Locality");
lblCity= new JLabel ("City");
lblState= new JLabel ("State/Union Teritory");
lblPhone= new JLabel ("Phone Number");
lblMailid= new JLabel ("                E-MailId");
lblGST= new JLabel ("G.S.T Number");
lblDate= new JLabel ("                  Date");

txtRNumber= new JTextField ();
txtIName= new JTextField ();
txtHOI= new JTextField ();
txtLocality= new JTextField ();
txtCity= new JTextField ();
txtPhone= new JTextField ();
txtMailid= new JTextField ();
txtGST= new JTextField ();
txtDate= new JTextField ();

cmbState=new JComboBox();

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

txtRNumber.addActionListener(this);
txtIName.addActionListener(this);
txtHOI.addActionListener(this);
txtLocality.addActionListener(this);
txtCity.addActionListener(this);
cmbState.addActionListener(this);
txtPhone.addActionListener(this);
txtMailid.addActionListener(this);
txtGST.addActionListener(this);
txtDate.addActionListener(this);


vb=Box.createVerticalBox();
hb=Box.createHorizontalBox();

red= new Color(255,0,0);
mix= new Color(125,70,200);

flw= new FlowLayout();
gl62= new GridLayout(6,2);
gl24= new GridLayout(2,4);

fnt1=new Font("Copperplate Gothic Bold",Font.BOLD,28);
lblHead.setFont(fnt1);
lblHead.setForeground(red);
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

p1.setLayout(flw);
p1.add(lblHead);

p2.setLayout(gl62);
p2.add(lblRNumber);
p2.add(txtRNumber);
p2.add(lblIName);
p2.add(txtIName);
p2.add(lblHOI);
p2.add(txtHOI);
p2.add(lblLocality);
p2.add(txtLocality);
p2.add(lblCity);
p2.add(txtCity);
p2.add(lblState);
p2.add(cmbState);


p3.setLayout(gl24);
p3.add(lblPhone);
p3.add(txtPhone);
p3.add(lblMailid);
p3.add(txtMailid);
p3.add(lblGST);
p3.add(txtGST);
p3.add(lblDate);
p3.add(txtDate);

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
	  rs=stmtSelect.executeQuery("select * from epas_tblIndus");
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
	  
	   else if (ae.getSource()==txtRNumber){
		   txtIName.requestFocus();
	   }
	   else if (ae.getSource()==txtIName){
		   txtHOI.requestFocus();
	   }
	   else if (ae.getSource()==txtHOI){
		   txtLocality.requestFocus();
	   }
	   else if (ae.getSource()==txtLocality){
		   txtCity.requestFocus();
	   }
	   else if (ae.getSource()==txtCity){
		   cmbState.requestFocus();
	   }
	    else if (ae.getSource()==cmbState){
		   txtPhone.requestFocus();
	   }
	   else if (ae.getSource()==txtPhone){
		   txtMailid.requestFocus();
	   }
	    else if (ae.getSource()==txtMailid){
		   txtGST.requestFocus();
	   }
	    else if (ae.getSource()==txtGST){
		   txtDate.requestFocus();
	   }
	   else if (ae.getSource()==txtDate){
		   btnSave.requestFocus();
	   }
	  
	  //implementing enter ends here
	  
	  else if (ae.getSource()==btnClear){
		  txtRNumber.setText("");
		  txtIName.setText("");
		  txtHOI.setText("");
		  txtLocality.setText("");
		  txtCity.setText("");
		  cmbState.setSelectedIndex(0);
		  txtPhone.setText("");
		  txtMailid.setText("");
		  txtGST.setText("");
		  txtDate.setText("");
	  }
	 
	  else if (ae.getSource()==btnSave){  
	  rno=txtRNumber.getText();
	  ina=txtIName.getText();
	  hoi=txtHOI.getText();
	  loc=txtLocality.getText();
	  city=txtCity.getText();
	  state=cmbState.getSelectedItem().toString();
	  
	  phn=txtPhone.getText();
	  mail=txtMailid.getText();
	  gst=txtGST.getText();
	  dt=txtDate.getText();
	  
	  try{
	  stmtSave=conn.createStatement();
	  stmtSave.executeUpdate("insert into epas_tblindus values('"+rno+"','"+ina+"','"+hoi+"','"+loc+"','"+city+"','"+state+"','"+phn+"','"+mail+"','"+gst+"','"+dt+"')");
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
		  rno=rs.getString("regdno");
		  ina=rs.getString("iname");
		  hoi=rs.getString("hname");
		  loc=rs.getString("locality");
		  city=rs.getString("city");
		  state=rs.getString("state");
		  phn=rs.getString("phoneno");
		  mail=rs.getString("emailid");
		  gst=rs.getString("gstno");
		  dt=rs.getString("gstdt");
		  
		  txtRNumber.setText(rno);
		  txtIName.setText(ina);
		  txtHOI.setText(hoi);
		  txtLocality.setText(loc);
		  txtCity.setText(city);
		  cmbState.setSelectedItem(state);
		  txtPhone.setText(phn);
		  txtMailid.setText(mail);
		  txtGST.setText(gst);
		  txtDate.setText(dt);
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
		  
		  rno=rs.getString("regdno");
		  ina=rs.getString("iname");
		  hoi=rs.getString("hname");
		  loc=rs.getString("locality");
		  city=rs.getString("city");
		  state=rs.getString("state");
		  phn=rs.getString("phoneno");
		  mail=rs.getString("emailid");
		  gst=rs.getString("gstno");
		  dt=rs.getString("gstdt");
		  
		  txtRNumber.setText(rno);
		  txtIName.setText(ina);
		  txtHOI.setText(hoi);
		  txtLocality.setText(loc);
		  txtCity.setText(city);
		  cmbState.setSelectedItem(state);
		  txtPhone.setText(phn);
		  txtMailid.setText(mail);
		  txtGST.setText(gst);
		  txtDate.setText(dt); 
		  }
	  }
	  catch(SQLException se){
		System.out.println("unable to go show");
	  }
	  }
	  else if(ae.getSource()==btnDelete){
	    rno=txtRNumber.getText();
		try{
			stmtDelete=conn.createStatement();
			stmtDelete.executeUpdate("delete from epas_tblindus where regdno='"+rno+"'");
			dlg.showMessageDialog(f1,"One Record Deleted","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to delete");
		}
		}
		else if(ae.getSource()==btnUpdate){
		  
		  rno=txtRNumber.getText();
		  ina=txtIName.getText();
		  hoi=txtHOI.getText();
		  loc=txtLocality.getText();
		  city=txtCity.getText();
		  state=cmbState.getSelectedItem().toString();
		  phn=txtPhone.getText();
		  mail=txtMailid.getText();
		  gst=txtGST.getText();
		  dt=txtDate.getText();
		
		try{
		stmtUpdate=conn.createStatement();
		stmtUpdate.executeUpdate("update epas_tblindus set iname='"+ina+"',hname='"+hoi+"',locality='"+loc+"',city='"+city+"',state='"+state+"',phoneno='"+phn+"',emailid='"+mail+"',gstno='"+gst+"',gstdt='"+dt+"' where regdno='"+rno+"'");
		dlg.showMessageDialog(f1,"One Record Updated","Alert",1);
		}
		catch(SQLException se){
		System.out.println("unable to update "+se);
		}
		}
		else if(ae.getSource()==btnSearch){
				rno=dlg.showInputDialog(f1,"Enter Regd. No. ","Search",1);
			
		try {
		stmtRno=conn.createStatement();
		rsRno=stmtRno.executeQuery("Select * from epas_tblindus where regdno='"+rno+"'");
		if(rsRno.next()) {
			  ina=rsRno.getString("iname");
			  hoi=rsRno.getString("hname");
			  loc=rsRno.getString("locality");
			  city=rsRno.getString("city");
			  state=rsRno.getString("state");
			  phn=rsRno.getString("phoneno");
			  mail=rsRno.getString("emailid");
			  gst=rsRno.getString("gstno");
			  dt=rsRno.getString("gstdt");

			  txtRNumber.setText(rno);
			  txtIName.setText(ina);
			  txtHOI.setText(hoi);
			  txtLocality.setText(loc);
			  txtCity.setText(city);
			  cmbState.setSelectedItem(state);
			  txtPhone.setText(phn);
			  txtMailid.setText(mail);
			  txtGST.setText(gst);
			  txtDate.setText(dt); 
			  
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
	 
class epas_IndusApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
epas_IndusWin dept;
dept= new epas_IndusWin();
	}
	}
