import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MenuWin implements ActionListener{
	
JFrame f1;	
		JMenuBar mbar;
		JMenu master,mgmt,srpt,drpt,help,ext;
		JMenuItem Industry ,Department ,Shift ,Staff ,AttendanceIn,AttendanceOut,LeaveApp,LeaveApprove,SalarySlipGen,PerformanceApp,rptindustry,rptdepartment,rptshift,rptstaff,rptattendancein,rptattendanceout,rptleaveapp,rptleaveapprove,rptsalaryslipgen,rptperformanceapp,userm,yes,no,rptdeptstaff,rptshiftstaff,rptdateattendancein,rptsidattendancein,rptdeptattendancein,rptstimeattendancein,rptdateattendanceout,rptsidattendanceout,rptdeptattendanceout,rptsidleaveapp,rptshiftnameleaveapp,rptltypeleaveapp,rptsidleaveapprove,rptstatusleaveapprove,rptslipnosalaryslipgen,rptsidsalaryslipgen,rptdeptsalaryslipgen,rptsidperformanceapp,changepassword;
		ImageIcon img1;
		JLabel lbl1;
	
	public MenuWin(){
		
		mbar=new JMenuBar();
		f1=new JFrame("Menu App");
		master=new JMenu("Master");
		mgmt=new JMenu("Management");
		srpt=new JMenu("Summary Report");
		drpt=new JMenu("Detail Report");
		help=new JMenu("Help");
		ext=new JMenu("Exit");
		
	    Industry=new JMenuItem("Industry Profile");
		Industry.setAccelerator(KeyStroke.getKeyStroke("alt A"));
		
		Department=new JMenuItem("Department Information");
		Department.setAccelerator(KeyStroke.getKeyStroke("alt B"));
		
		Shift=new JMenuItem("Shift Information");
		Shift.setAccelerator(KeyStroke.getKeyStroke("alt C"));
		
		Staff=new JMenuItem("Staff Information");
		Staff.setAccelerator(KeyStroke.getKeyStroke("alt D"));
		
		AttendanceIn=new JMenuItem("Attendance Information(In)");
		AttendanceIn.setAccelerator(KeyStroke.getKeyStroke("alt E"));
		
		AttendanceOut=new JMenuItem("Attendance Information(Out)");
		AttendanceOut.setAccelerator(KeyStroke.getKeyStroke("alt F"));
		
		LeaveApp=new JMenuItem("Leave Information");
		LeaveApp.setAccelerator(KeyStroke.getKeyStroke("alt G"));
		
		LeaveApprove=new JMenuItem("Leave Approval Information");
		LeaveApprove.setAccelerator(KeyStroke.getKeyStroke("alt H"));
		
		SalarySlipGen=new JMenuItem("Salary Slip Information");
		SalarySlipGen.setAccelerator(KeyStroke.getKeyStroke("alt I"));
		
		PerformanceApp=new JMenuItem("Performance Information");
		PerformanceApp.setAccelerator(KeyStroke.getKeyStroke("alt J"));
		
		userm=new JMenuItem("User Manual");
		userm.setAccelerator(KeyStroke.getKeyStroke("ctrl alt A"));
		
		changepassword=new JMenuItem("Reset Password");
		changepassword.setAccelerator(KeyStroke.getKeyStroke("ctrl alt B"));
		
		yes=new JMenuItem("Yes");
		yes.setAccelerator(KeyStroke.getKeyStroke("ctrl alt C"));
		
		no=new JMenuItem("No");
		no.setAccelerator(KeyStroke.getKeyStroke("ctrl alt D"));
		
		rptindustry=new JMenuItem("Industry Information");
		rptindustry.setAccelerator(KeyStroke.getKeyStroke("ctrl A"));
		
		rptdepartment=new JMenuItem("Department Information");
		rptdepartment.setAccelerator(KeyStroke.getKeyStroke("ctrl B"));
		
		rptshift=new JMenuItem("Shift Information");
		rptshift.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
		
		rptstaff=new JMenuItem("Staff Information");
		rptstaff.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));
		
		rptattendancein=new JMenuItem("Attendance(In) Information");
		rptattendancein.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
		
		rptattendanceout=new JMenuItem("Attendance(Out) Information");
		rptattendanceout.setAccelerator(KeyStroke.getKeyStroke("ctrl F"));
		
		
		rptleaveapp=new JMenuItem("Leave Information");
		rptleaveapp.setAccelerator(KeyStroke.getKeyStroke("ctrl G"));
		
		
		rptleaveapprove=new JMenuItem("Leave Approval Information");
		rptleaveapprove.setAccelerator(KeyStroke.getKeyStroke("ctrl H"));
		
		rptsalaryslipgen=new JMenuItem("Salary Slip Information");
		rptsalaryslipgen.setAccelerator(KeyStroke.getKeyStroke("ctrl I"));
		
		rptperformanceapp=new JMenuItem("Performance Information");
		rptperformanceapp.setAccelerator(KeyStroke.getKeyStroke("ctrl J"));
		
		
		rptdeptstaff=new JMenuItem("Staff Information [Department]*");
		rptdeptstaff.setAccelerator(KeyStroke.getKeyStroke("ctrl K"));
	
	    rptshiftstaff=new JMenuItem("Staff Information [Shift Name]*");
		rptshiftstaff.setAccelerator(KeyStroke.getKeyStroke("ctrl L"));
		
		rptdateattendancein=new JMenuItem("Attendance(In)Information [Date]*");
        rptdateattendancein.setAccelerator(KeyStroke.getKeyStroke("ctrl M"));
		
		rptsidattendancein=new JMenuItem("Attendance(In)Information [Staff Id]*");
		rptsidattendancein.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
		
		rptdeptattendancein=new JMenuItem("Attendance(In)Information [Department]*");
		rptdeptattendancein.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		
		rptstimeattendancein=new JMenuItem("Attendance(In)Information [Start Time]*");
		rptstimeattendancein.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));
		
		rptsidattendanceout=new JMenuItem("Attendance(Out)Information [Date]*");
		rptsidattendanceout.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
		
		rptdateattendanceout=new JMenuItem("Attendance(Out)Information [Staff Id.]*");
		rptdateattendanceout.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
		
		rptdeptattendanceout=new JMenuItem("Attendance(Out)Information [Department]*");
		rptdeptattendanceout.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		
		rptsidleaveapp=new JMenuItem("Leave Application [Staff Id.]*");
		rptsidleaveapp.setAccelerator(KeyStroke.getKeyStroke("ctrl T"));
		
		rptshiftnameleaveapp=new JMenuItem("Leave Application [Shift Name]*");
		rptshiftnameleaveapp.setAccelerator(KeyStroke.getKeyStroke("ctrl U"));
		
		rptltypeleaveapp=new JMenuItem("Leave Application [Leave Type]*");
		rptltypeleaveapp.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));
		
		rptsidleaveapprove=new JMenuItem("Leave Approval Information [Staff Id.]*");
		rptsidleaveapprove.setAccelerator(KeyStroke.getKeyStroke("ctrl W"));
		
		rptstatusleaveapprove=new JMenuItem("Leave Approval Information [Status]*");
		rptstatusleaveapprove.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		
		rptslipnosalaryslipgen=new JMenuItem("Salary Slip Information [Slip No.]*");
		rptslipnosalaryslipgen.setAccelerator(KeyStroke.getKeyStroke("ctrl Y"));
		
		rptsidsalaryslipgen=new JMenuItem("Salary Slip Information [Staff Id.]*");
		rptsidsalaryslipgen.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
		
		rptdeptsalaryslipgen=new JMenuItem("Salary Slip Information [Department]*");
		rptdeptsalaryslipgen.setAccelerator(KeyStroke.getKeyStroke("ctrl Y"));
		
		rptsidperformanceapp=new JMenuItem("Performance Information [Staff Id.]*");
		rptsidperformanceapp.setAccelerator(KeyStroke.getKeyStroke("ctrl  Z"));
		
		img1=new ImageIcon("emp4.jpg");
		
		lbl1=new JLabel(img1);
		
		
		Industry.addActionListener(this);
		Department.addActionListener(this);
		Shift.addActionListener(this);
		Staff.addActionListener(this);
		AttendanceIn.addActionListener(this);
		AttendanceOut.addActionListener(this);
		LeaveApp.addActionListener(this);
		LeaveApprove.addActionListener(this);
		SalarySlipGen.addActionListener(this);
		PerformanceApp.addActionListener(this);
		rptindustry.addActionListener(this);
		rptdepartment.addActionListener(this);
		rptshift.addActionListener(this);
		rptstaff.addActionListener(this);
		rptattendancein.addActionListener(this);
		rptattendanceout.addActionListener(this);
		rptleaveapp.addActionListener(this);
		rptleaveapprove.addActionListener(this);
		rptsalaryslipgen.addActionListener(this);
		rptperformanceapp.addActionListener(this);
		rptdeptstaff.addActionListener(this);
		rptshiftstaff.addActionListener(this);
		rptdateattendancein.addActionListener(this);
		rptsidattendancein.addActionListener(this);
		rptdeptattendancein.addActionListener(this);
		rptstimeattendancein.addActionListener(this);
		rptdateattendanceout.addActionListener(this);
		rptsidattendanceout.addActionListener(this);
		rptdeptattendanceout.addActionListener(this);
		rptsidleaveapp.addActionListener(this);
		rptshiftnameleaveapp.addActionListener(this);
		rptltypeleaveapp.addActionListener(this);
		rptsidleaveapprove.addActionListener(this);
		rptstatusleaveapprove.addActionListener(this);
		rptslipnosalaryslipgen.addActionListener(this);
		rptsidsalaryslipgen.addActionListener(this);
		rptdeptsalaryslipgen.addActionListener(this);
		rptsidperformanceapp.addActionListener(this);
	    yes.addActionListener(this);
		changepassword.addActionListener(this);
		
		
		
		master.add(Industry);
		master.add(Department);
		master.add(Shift);
		master.add(Staff);
		
		mgmt.add(AttendanceIn);
		mgmt.add(AttendanceOut);
		mgmt.add(LeaveApp);
		mgmt.add(LeaveApprove);
		mgmt.add(SalarySlipGen);
		mgmt.add(PerformanceApp);

srpt.add(rptindustry);
srpt.add(rptdepartment);
srpt.add(rptshift);
srpt.add(rptstaff);
drpt.addSeparator();
srpt.add(rptattendancein);
srpt.add(rptattendanceout);
srpt.add(rptleaveapp);
srpt.add(rptleaveapprove);
srpt.add(rptsalaryslipgen);
srpt.add(rptperformanceapp);

drpt.add(rptdeptstaff);
drpt.add(rptshiftstaff);
drpt.addSeparator();
drpt.add(rptdateattendancein);
drpt.add(rptsidattendancein);
drpt.add(rptdeptattendancein);
drpt.add(rptstimeattendancein);
drpt.addSeparator();
drpt.add(rptdateattendanceout);
drpt.add(rptsidattendanceout);
drpt.add(rptdeptattendanceout);
drpt.addSeparator();
drpt.add(rptsidleaveapp);
drpt.add(rptshiftnameleaveapp);
drpt.add(rptltypeleaveapp);
drpt.addSeparator();
drpt.add(rptsidleaveapprove);
drpt.add(rptstatusleaveapprove);
drpt.addSeparator();
drpt.add(rptslipnosalaryslipgen);
drpt.add(rptsidsalaryslipgen);
drpt.add(rptdeptsalaryslipgen);
drpt.addSeparator();
drpt.add(rptsidperformanceapp);

help.add(userm); 
help.add(changepassword);


ext.add(yes);
ext.add(no);

mbar.add(master);
mbar.add(mgmt);
mbar.add(srpt);
mbar.add(drpt);
mbar.add(help);
mbar.add(ext);

		f1.setLayout(new BorderLayout());
		f1.add(mbar,BorderLayout.NORTH);
		f1.add(lbl1,BorderLayout.CENTER);
	     f1.setSize(1024,768);
		 f1.setBounds(10,10,1200,700);
		f1.setVisible(true);
	}
		
	public void actionPerformed(ActionEvent ae){
	if(ae.getSource()==yes){
		f1.setVisible(false);
		f1.dispose();
	}
	else if(ae.getSource()==Industry){
	   epas_IndusWin indus;
	   indus=new epas_IndusWin();
	}
	else if(ae.getSource()==Department){
	   epas_DepartmentWin dept;
	   dept=new epas_DepartmentWin();
	}
	else if(ae.getSource()==Shift){
	   epas_ShiftWin dept;
	   dept=new epas_ShiftWin();
	}
	else if(ae.getSource()==Staff){
	   epas_StaffWin staff;
	   staff=new epas_StaffWin();
	}
	else if(ae.getSource()==AttendanceIn){
	   epas_AttendInWin staff;
	   staff=new epas_AttendInWin();
	}
	else if(ae.getSource()==AttendanceOut){
	   epas_AttendOutWin staff;
	   staff=new epas_AttendOutWin();
	}
	else if(ae.getSource()==LeaveApp){
	   epas_LeaveAppWin staff;
	   staff=new epas_LeaveAppWin();
	}
	else if(ae.getSource()==LeaveApprove){
	   epas_LeaveApproveWin staff;
	   staff=new epas_LeaveApproveWin();
	}
	else if(ae.getSource()==SalarySlipGen){
	   epas_SalarySlipWin staff;
	   staff=new epas_SalarySlipWin();
	}
	else if(ae.getSource()==PerformanceApp){
	   epas_PerformanceWin staff;
	   staff=new epas_PerformanceWin();
	}
	else if(ae.getSource()==rptindustry){
	   epas_RptIndusWin rpt1;
	   rpt1=new epas_RptIndusWin();
	}
	else if(ae.getSource()==rptdepartment){
	   epas_RptDepartmentWin rpt1;
	   rpt1=new epas_RptDepartmentWin();
	}
	else if(ae.getSource()==rptshift){
	   epas_RptShiftWin rpt1;
	   rpt1=new epas_RptShiftWin();
	}
	else if(ae.getSource()==rptstaff){
	   epas_RptStaffWin rpt1;
	   rpt1=new epas_RptStaffWin();
	}
	else if(ae.getSource()==rptattendancein){
	   epas_RptAttendInWin rpt1;
	   rpt1=new epas_RptAttendInWin();
	}
	else if(ae.getSource()==rptattendanceout){
	   epas_RptAttendOutWin rpt1;
	   rpt1=new epas_RptAttendOutWin();
	}
	else if(ae.getSource()==rptleaveapp){
	   epas_RptLeaveAppWin rpt1;
	   rpt1=new epas_RptLeaveAppWin();
	}
	else if(ae.getSource()==rptleaveapprove){
	   epas_RptLeaveApproveWin rpt1;
	   rpt1=new epas_RptLeaveApproveWin();
	}
	else if(ae.getSource()==rptsalaryslipgen){
	   epas_RptSalarySlipWin rpt1;
	   rpt1=new epas_RptSalarySlipWin();
	}
	else if(ae.getSource()==rptperformanceapp){
	   epas_RptPerformanceWin rpt1;
	   rpt1=new epas_RptPerformanceWin();
	}
	else if(ae.getSource()==rptdeptstaff){
	   epas_RptStaffDeptWin rpt1;
	   rpt1=new epas_RptStaffDeptWin();
	}
	else if(ae.getSource()==rptshiftstaff){
	   epas_RptStaffShiftWin rpt1;
	   rpt1=new epas_RptStaffShiftWin();
	}
	else if(ae.getSource()==rptdateattendancein){
	   epas_RptAttendInDateWin rpt1;
	   rpt1=new epas_RptAttendInDateWin();
	}
	else if(ae.getSource()==rptsidattendancein){
	   epas_RptAttendInSidWin rpt1;
	   rpt1=new epas_RptAttendInSidWin();
	}
	else if(ae.getSource()==rptdeptattendancein){
	   epas_RptAttendInDeptWin rpt1;
	   rpt1=new epas_RptAttendInDeptWin();
	}
	else if(ae.getSource()==rptstimeattendancein){
	   epas_RptAttendInSTimeWin rpt1;
	   rpt1=new epas_RptAttendInSTimeWin();
	}
	else if(ae.getSource()==rptattendancein){
	   epas_RptAttendInWin rpt1;
	   rpt1=new epas_RptAttendInWin();
	}
	
	else if(ae.getSource()==rptsidattendanceout){
	   epas_RptAttendOutSidWin rpt1;
	   rpt1=new epas_RptAttendOutSidWin();
	}
	else if(ae.getSource()==rptdateattendanceout){
	   epas_RptAttendOutDateWin rpt1;
	   rpt1=new epas_RptAttendOutDateWin();
	}
	else if(ae.getSource()==rptdeptattendanceout){
	   epas_RptAttendOutDeptWin rpt1;
	   rpt1=new epas_RptAttendOutDeptWin();
	}
	else if(ae.getSource()==rptsidleaveapp){
	   epas_RptLeaveAppSidWin rpt1;
	   rpt1=new epas_RptLeaveAppSidWin();
	}
	else if(ae.getSource()==rptshiftnameleaveapp){
	   epas_RptLeaveAppSftWin rpt1;
	   rpt1=new epas_RptLeaveAppSftWin();
	}
	else if(ae.getSource()==rptltypeleaveapp){
	   epas_RptLeaveAppLeaveTypeWin rpt1;
	   rpt1=new epas_RptLeaveAppLeaveTypeWin();
	}
	else if(ae.getSource()==rptsidleaveapprove){
	   epas_RptLeaveApproveSidWin rpt1;
	   rpt1=new epas_RptLeaveApproveSidWin();
	}
	else if(ae.getSource()==rptstatusleaveapprove){
	   epas_RptLeaveApproveStatusWin rpt1;
	   rpt1=new epas_RptLeaveApproveStatusWin();
	}
	else if(ae.getSource()==rptslipnosalaryslipgen){
	   epas_RptSalarySlipSlipNoWin rpt1;
	   rpt1=new epas_RptSalarySlipSlipNoWin();
	}
	else if(ae.getSource()==rptsidsalaryslipgen){
	   epas_RptSalarySlipSidWin rpt1;
	   rpt1=new epas_RptSalarySlipSidWin();
	}
	else if(ae.getSource()==rptdeptsalaryslipgen){
	   epas_RptSalarySlipDeptWin rpt1;
	   rpt1=new epas_RptSalarySlipDeptWin();
	}
	else if(ae.getSource()==rptsidperformanceapp){
	   epas_RptPerformanceSidWin rpt1;
	   rpt1=new epas_RptPerformanceSidWin();
	}
	else if(ae.getSource()==changepassword){
	   ChangePasswordWin password;
	   password=new ChangePasswordWin();
	}
	
	
	
	
	
	} // actionPerformed ends
} // class ends
	
       
class MenuApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
MenuWin menu;
menu= new MenuWin();
	}
	}