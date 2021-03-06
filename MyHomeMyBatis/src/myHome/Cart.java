package myHome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import crud.CrudHome;
import model.CartItem;

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
				
				System.out.println("addCart code: "+code);
				System.out.println("addCart numList.get(i): "+numList.get(i));
				System.out.println("addCart id: "+id);
				
				updateCart(code,numList.get(i),id);
				return;
			}
		}
		//동일한 상품번호가 없다면
		codeList.add(code);
		numList.add(num);
		
		insertCart(code,num,id);

	}
	
	public void deleteItem(String code, String id) throws ServletException{
		for(int i=0; i<codeList.size();i++){
			if(codeList.get(i)==Integer.parseInt(code)){
				codeList.remove(i);
				numList.remove(i);
				deleteCart(Integer.parseInt(code),id);
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
		
		int seqno=1;
		CrudHome crud = new CrudHome();
		int maxSeqno = crud.selectMaxSeqnoCart();
		
		seqno = seqno + maxSeqno;
		
		CartItem item = new CartItem();
		
		System.out.println("insertCart id : "+id);
		item.setSeqno(seqno);
		item.setCode(code);
		item.setNum(num);
		item.setId(id);
		
		int result = crud.insertCart(item);
		
		if(result < 0) throw new ServletException("cart error!");
		
	}
	
	private void updateCart(int code, int num, String id) throws ServletException{
		
		CrudHome crud = new CrudHome();
		CartItem item = new CartItem();
		
		item.setCode(code);
		item.setId(id);
		item.setNum(num);
		
		System.out.println("updateCart code :"+code);
		System.out.println("updateCart id :"+id);
		System.out.println("updateCart num :"+num);
		int result = crud.deleteCart(item);
		
		if(result < 0) throw new ServletException("cart error!");
	}
	
	private void deleteCart(int code, String id) throws ServletException{
		
		CrudHome crud = new CrudHome();
		CartItem item = new CartItem();
		
		item.setCode(code);
		item.setId(id);
		
		System.out.println("code"+code);
		System.out.println("id"+id);		
		int result = crud.deleteCart(item);
		
		if(result < 0) throw new ServletException("cart error!");
	}
}
