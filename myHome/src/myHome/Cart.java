package myHome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

public class Cart {

	private LinkedList<Integer> codeList = new LinkedList<Integer>();
	private LinkedList<Integer> numList = new LinkedList<Integer>();
	
	public int getItemSize(){
		return codeList.size();
	}
	
	public int getCode(int index){
		return codeList.get(index);
	}
	
	public int getNum(int index){
		return numList.get(index);
	}
	
	public void setCodeList(Integer code){
		codeList.add(code);
	}
	
	public void setNumList(Integer num){
		numList.add(num);
	}
	
	public void addCart(int code, int num, String id) throws ServletException{
		for(int i=0;i<codeList.size() ;i++){// 상품번호 갯수 만큼 반복하며 동일한 상품번호가 있는지
			
			if(codeList.get(i)==code){// 동일한 상품번호가 있다면
				numList.set(i, numList.get(i)+1);
				updateCart(code,numList.get(i),id);
				return;
			}
		}
		//동일한 상품번호가 없다면
		codeList.add(code);
		numList.add(num);
		
		insertCart(code,num,id);

	}
	
	public void deleteItem(String code) throws ServletException{
		for(int i=0; i<codeList.size();i++){
			if(codeList.get(i)==Integer.parseInt(code)){
				codeList.remove(i);
				numList.remove(i);
				deleteCart(Integer.parseInt(code));
				return;
			}
		}
	}
	
	public void modifyItem(String code, String num, String id) throws ServletException{
		for(int i=0; i<codeList.size();i++){
			if(codeList.get(i)==Integer.parseInt(code)){
				numList.set(i, Integer.parseInt(num));
				updateCart(Integer.parseInt(code),Integer.parseInt(num),id);
				return;
			}
		}
	}
	
	private void insertCart(int code, int num, String id) throws ServletException{
		
		Connection conn=null; Statement stmt = null;
		int seqno=1;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			stmt=conn.createStatement();
			
			ResultSet rs= stmt.executeQuery("select max(seqno) max_no from cart");		
			
			if(rs.next()) seqno = seqno + rs.getInt("max_no");
			
			String sql="insert into cart values("+seqno+","+code+","+num+",'"+id+"')";
			
			stmt.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{stmt.close(); conn.close();}catch(Exception e){}
		}
	}
	
	private void updateCart(int code, int num, String id) throws ServletException{
		
		Connection conn=null; Statement stmt = null;
		int seqno=1;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			stmt=conn.createStatement();
			
			String sql="update cart set num="+num+" where code="+code+" and id='"+id+"'";
			
			stmt.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{stmt.close(); conn.close();}catch(Exception e){}
		}
	}
	
	private void deleteCart(int code) throws ServletException{
		
		Connection conn=null; Statement stmt = null;
		int seqno=1;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","hr","1234");
			
			if(conn==null) throw new Exception("error");				
			stmt=conn.createStatement();
			
			String sql="delete from cart where code="+code;
			
			stmt.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{stmt.close(); conn.close();}catch(Exception e){}
		}
	}
}
