import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class UserManualWin implements ActionListener {
	
 JFrame f1;
 JPanel p1,p2;
 JLabel lblHead,lblEntry,lblReport,lblIndustry,lblDepartment,lblShift,lblStaff,lblAttendIn,lblAttendOut,lblLeaveApp,lblLeaveApproval,lblSalarySlip,lblPerformanceApp,lblRptIndustry,lblRptDepartment,lblRptShift,lblRptStaff,lblRptAttendIn,lblRptAttendOut,lblRptLeaveApp,lblRptLeaveApproval,lblRptSalarySlip,lblRptPerformanceApp,lblRptDeptStaff,lblRptShiftStaff,lblRptDateAttendancein,lblRptSidAttendancein,lblRptDeptAttendancein,lblRptSTimeAttendancein,lblRptDateAttendanceout,lblRptSidAttendanceout,lblRptDeptAttendanceout,lblRptSidLeaveapp,lblRptShiftnameLeaveapp,lblRptLtypeLeaveapp,lblRptSidLeaveapprove,lblRptStatusLeaveapprove,lblRptSlipnoSalaryslipgen,lblRptSidSalaryslipgen,lblRptDeptSalaryslipgen,lblRptSidPerformanceapp;
 JOptionPane dlg;
 Box vb,hb; 
 Font fnt1;
 Color maroon,mix;
 JButton btnClose;

 Statement stmtSelect;
 ResultSet rs;
 
 Connection conn;
 String entry,report;
 
 FlowLayout flw;
 GridLayout gl381;
 
 public UserManualWin() {
	f1=new JFrame ("EPAS");
	p1=new JPanel();
	p2=new JPanel();
	
lblHead= new JLabel ("User Manual");

lblEntry= new JLabel ("Entry :");
lblIndustry=new JLabel("To Add or Edit record for Industry,select Master-Industry Profile.");
lblDepartment=new JLabel("To Add or Edit record for Department,select Master-Industry Information.");
lblShift=new JLabel("To Add or Edit record for Shift,select Master-Shift Information.");
lblStaff=new JLabel("To Add or Edit record for Staff,select Master-Staff Information.");

lblAttendIn=new JLabel("To Add or Edit record for Attendance In,select Management-Attendance Information(In).");
lblAttendOut=new JLabel("To Add or Edit record for Attendance Out,select Management-Attendance Information(Out).");
lblLeaveApp=new JLabel("To Add or Edit record for Leave,select Management-Leave Information.");
lblLeaveApproval=new JLabel("To Add or Edit record for Leave Approval,select Management-Leave Approval Information.");
lblSalarySlip=new JLabel("To Add or Edit record for Salary Slip,select Management-Salary Slip Information.");
lblPerformanceApp=new JLabel("To Add or Edit record for Performance,select Master-Performance Information.");


lblReport= new JLabel ("Report :");

lblRptIndustry=new Jlabel("To view Industry Report,select Summary Report-Industry Information.");
lblRptDepartment=new Jlabel("To view Department Report,select Summary Report-Industry Information.");
lblRptShift=new Jlabel("To view Shift Report,select Summary Report-Shift Information.");
lblRptStaff=new Jlabel("To view Staff Report,select Summary Report-Staff Information.");
lblRptAttendIn=new Jlabel("To view Attendance(In) Report,select Summary Report-Attendance(In) Information.");
lblRptAttendOut=new Jlabel("To view Attendance(Out) Report,select Summary Report-Attendance(Out) Information.");
lblRptLeaveApp=new Jlabel("To view Leave Report,select Summary Report-Leave Information.");
lblRptLeaveApproval=new Jlabel("To view Leave Approval Report,select Summary Report-Leave Approval Information.");
lblRptSalarySlip=new Jlabel("To view Salary Slip Report,select Summary Report-Slip Salary Information.");
lblRptPerformanceApp=new Jlabel("To view Performance Report,select Summary Report-Performance Information.");


lblRptDeptStaff=new JLabel("To view Staff Report through Department,select Detail Report-Staff Information [Department]*");
lblRptShiftStaff=new JLabel("To view Staff Report through Shift,select Detail Report-Staff Information [Shift Name]*");
lblRptDateAttendancein=new JLabel("To view Attendance(In)Report through Date,select Detail Report-Attendance(In)Information [Date]*");
lblRptSidAttendancein=new JLabel("To view Attendance(In)Report through Staff Id.,select Detail Report-Attendance(In)Information [Staff Id]*");
lblRptDeptAttendancein=new JLabel("To view Attendance(In)Report through Department,select Detail Report-Attendance(In)Information[Department]*");
lblRptSTimeAttendancein=new JLabel("To view Attendance(In)Report through Start Time,select Detail Report-Attendance(In)Information [Start Time]*");
lblRptSidAttendanceout=new JLabel("To view Attendance(Out)Report through Staff Id.,select Detail Report-Attendance(Out)Information [Staff Id.]*");
lblRptDateAttendanceout=new JLabel("To view Attendance(Out)Report through Date,select Detail Report-Attendance(Out)Information [Date]*");
lblRpt=new JLabel("To view Attendance(Out)Report through Department,select Detail Report-Attendance(Out)Information [Department]*");


btnClose=new JButton("Close");
btnClose.addActionListener(this);

vb=Box.createVerticalBox();
hb=Box.createHorizontalBox();

maroon= new Color(128,0,0);
mix= new Color(125,70,200);

flw= new FlowLayout();
gl381= new GridLayout(38,1);

fnt1=new Font("Copperplate Gothic Bold",Font.BOLD,25);
lblHead.setFont(fnt1);
lblHead.setForeground(maroon);

p1.setLayout(flw);
p1.add(lblHead);

p2.setLayout(gl381);
p2.add(lblEntry);
p2.add(lblIndustry);
p2.add(lblDepartment);
p2.add(lblShift);
p2.add(lblStaff);
p2.add(lblAttendIn);
p2.add(lblAttendOut);
p2.add(lblLeaveApp);
p2.add(lblLeaveApproval);
p2.add(lblSalarySlip);
p2.add(lblPerformanceApp);

vb.add(Box.createVerticalStrut(20));
vb.add(p1);
vb.add(Box.createVerticalStrut(10));
vb.add(p2);

hb.add(Box.createHorizontalStrut(20));
hb.add(vb);
hb.add(Box.createHorizontalStrut(20));
f1.setLayout(new BorderLayout());
f1.add(hb,BorderLayout.CENTER);
f1.setBounds(10,10,1300,700);
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
	if(ae.getSource()==btnClose){
		  f1.setVisible(false);
		  f1.dispose();
	  }

	  
			}// close ends
}// class ends
	 
class UserManualApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
UserManualWin user;
user= new UserManualWin();
	}
	}