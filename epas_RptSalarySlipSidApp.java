import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class epas_RptSalarySlipSidWin implements ActionListener{
	
	JFrame f1;
	JPanel p1;
	GridLayout gl51;
	BorderLayout b1;
	JLabel lblHead,lblIName,lblLocality,lblCity,lblState;
	String colHead []={"Sl.No","Slip No.","Date","Month","Year","Staffid","Staff Name","Gender","Department","Shift Name","Basic Salary","DA%","DA Amount","HRA%","HRA Amount","PF%","PF Amount","Tax%","Tax Amount","Gross Salary","Net Salary"};
	Object data[][];
	JTable tblData;
	JScrollPane jspData;
	int slno1,rw;
	Connection conn;
	Statement stmtView;
	ResultSet rs;
	Font fnt1;
	Color teal,mix;
	Font fnt2;
	Box vb,hb; 
	JButton btnClose;
	int totrec;
	String sid;
	JOptionPane dlg;
	
	public epas_RptSalarySlipSidWin(){
		f1=new JFrame("epas");
		p1=new JPanel();
		gl51=new GridLayout(5,1);
		b1=new BorderLayout();
	
		
		lblHead=new JLabel("Salary Slip Information",JLabel.CENTER);
		lblIName=new JLabel("  SATYAM GROUP OF INDUSTRIES");
		lblLocality=new JLabel("  Industrial Estate");
		lblCity=new JLabel("  Jagatpur,Cuttack");
		lblState=new JLabel("  Odisha");
		dlg=new JOptionPane();
		
		btnClose=new JButton("Close Report");
		btnClose.addActionListener(this);
		
		p1.setLayout(gl51);
        p1.add(lblHead);
		p1.add(lblIName);
		p1.add(lblLocality);
		p1.add(lblCity);
		p1.add(lblState);
		
		vb=Box.createVerticalBox();
hb=Box.createHorizontalBox();
		
		teal= new Color(0,128,128);
mix= new Color(125,70,200);

fnt1=new Font("Copperplate Gothic Bold",Font.BOLD,30);
		lblHead.setFont(fnt1);
lblHead.setForeground(teal);

fnt2=new Font("Times New Roman",Font.BOLD,16);
		lblIName.setFont(fnt2);
lblLocality.setFont(fnt2);
lblCity.setFont(fnt2);
lblState.setFont(fnt2);

		
		doConnect();
		
		 tblData=new JTable(data,colHead);
		jspData =new JScrollPane(tblData);
		f1.setLayout(b1);
		f1.add(p1,BorderLayout.NORTH);
		f1.add(jspData,BorderLayout.CENTER);
		f1.add(btnClose,BorderLayout.SOUTH);
		f1.setBounds(10,10,1300,700);
		f1.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
	if(ae.getSource()==btnClose){
		f1.setVisible(false);
		f1.dispose();
	}
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
	  stmtView=conn.createStatement();
	  
	  sid=dlg.showInputDialog(f1,"Enter Staff Id.","EPAS",1);
		rs=stmtView.executeQuery("select * from epas_tblSalarySlip where sid='"+sid+"'");
		
		rs.last();
		totrec=rs.getRow();
		rs.beforeFirst();
		data=new Object[totrec][21];
		
		
		slno1=1;
		rw=0;
		while(rs.next()){
			data[rw][0]=slno1;
			data[rw][1]=rs.getString("slipno");
			data[rw][2]=rs.getString("date");
			data[rw][3]=rs.getString("month");
			data[rw][4]=rs.getString("year");
			data[rw][5]=rs.getString("sid");
			data[rw][6]=rs.getString("sname");
			data[rw][7]=rs.getString("gender");
			data[rw][8]=rs.getString("dept");
			data[rw][9]=rs.getString("sftname");
			data[rw][10]=rs.getString("bsalary");
			data[rw][11]=rs.getString("daper");
			data[rw][12]=rs.getString("amount1");
			data[rw][13]=rs.getString("hraper");
			data[rw][14]=rs.getString("amount2");
			data[rw][15]=rs.getString("pfper");
			data[rw][16]=rs.getString("amount3");
			data[rw][17]=rs.getString("taxper");
			data[rw][18]=rs.getString("amount4");
			data[rw][19]=rs.getString("gsalary");
			data[rw][20]=rs.getString("nsalary");
			
			
			slno1=slno1+1;
			rw=rw+1;
	  }
	  }//try ends
	  catch(SQLException se){
		  System.out.println("Error");
	  }
	}// doConnect()ends
}//class ends

class epas_RptSalarySlipSidApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
epas_RptSalarySlipSidWin rpt1;
rpt1= new epas_RptSalarySlipSidWin();
	}
	}