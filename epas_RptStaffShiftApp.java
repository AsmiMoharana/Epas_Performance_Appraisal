import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class epas_RptStaffShiftWin implements ActionListener{
	
	JFrame f1;
	JPanel p1;
	GridLayout gl51;
	BorderLayout b1;
	JLabel lblHead,lblIName,lblLocality,lblCity,lblState;
	String colHead []={"Sl.No","Staff Id","Staff Name","Gender","DOB","Locality","City","State/UnTerr","Pin","PhoneNo.","MailId","Qual","YOP","D.O.Join","Dept","sfcode","sfname","bsalary","daper","hraper","pfper","taxper"};
	Object data[][];
	JTable tblData;
	JScrollPane jspData;
	int slno,rw;
	Connection conn;
	Statement stmtView;
	ResultSet rs;
	Font fnt1;
	Color teal,mix;
	Font fnt2;
	JButton btnClose;
	int totrec;
	String sfname;
	JOptionPane dlg;
	
	
	public epas_RptStaffShiftWin(){
		f1=new JFrame("epas");
		p1=new JPanel();
		gl51=new GridLayout(5,1);
		b1=new BorderLayout();
	
		
		lblHead=new JLabel("Staff Information",JLabel.CENTER);
		lblIName=new JLabel("  SATYAM GROUP OF INDUSTRIES");
		lblLocality=new JLabel("  Industrial Estate");
		lblCity=new JLabel("  Jagatpur,Cuttack");
		lblState=new JLabel("  Odisha");
		
		btnClose=new JButton("Close Report");
		btnClose.addActionListener(this);
		
		p1.setLayout(gl51);
        p1.add(lblHead);
		p1.add(lblIName);
		p1.add(lblLocality);
		p1.add(lblCity);
		p1.add(lblState);
		
	
		
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
	  sfname=dlg.showInputDialog(f1,"Enter Shift Name","EPAS",1);
		rs=stmtView.executeQuery("select * from epas_tblstaff where sfname='"+sfname+"'");
		
		rs.last();
		totrec=rs.getRow();
		rs.beforeFirst();
		data=new Object[totrec][22];
		slno=1;
		rw=0;
		while(rs.next()){
			data[rw][0]=slno;
			data[rw][1]=rs.getString("sid");
			data[rw][2]=rs.getString("sname");
			data[rw][3]=rs.getString("gender");
			data[rw][4]=rs.getString("dbirth");
			data[rw][5]=rs.getString("locality");
			data[rw][6]=rs.getString("city");
			data[rw][7]=rs.getString("state");
			data[rw][8]=rs.getString("pin");
			data[rw][9]=rs.getString("phoneno");
			data[rw][10]=rs.getString("email");
			data[rw][11]=rs.getString("qual");
			data[rw][12]=rs.getString("yop");
			data[rw][13]=rs.getString("djoin");
			data[rw][14]=rs.getString("dept");
			data[rw][15]=rs.getString("sfcode");
			data[rw][16]=rs.getString("sfname");
			data[rw][17]=rs.getString("basic");
			data[rw][18]=rs.getString("daper");
			data[rw][19]=rs.getString("hraper");
			data[rw][20]=rs.getString("pfper");
			data[rw][21]=rs.getString("taxper");
			
			slno=slno+1;
			rw=rw+1;
	  }
	  }//try ends
	  catch(SQLException se){
		  System.out.println("Error");
	  }
	}// doConnect()ends
}//class ends

class epas_RptStaffShiftApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
epas_RptStaffShiftWin rpt1;
rpt1= new epas_RptStaffShiftWin();
	}
	}