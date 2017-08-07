package myhome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.ServletException;

import crud.CrudHome;
import model.CartItem;

public class Cart {
	//��ǰ��ȣ, ��ǰ����
	private LinkedList<Integer> codeList=new LinkedList<Integer>();
	private LinkedList<Integer> numList=new LinkedList<Integer>();
	
	public void setCodeList(Integer code){
		codeList.add(code);
	}
	public void setNumList(Integer num){
		numList.add(num);
	}
	
	public void deleteItem(String code, String id)
		throws ServletException{//��ǰ ����
		for(int i=0; i<codeList.size(); i++){
			if(codeList.get(i) == Integer.parseInt(code)){
				codeList.remove(i);//��ǰ���� 
				numList.remove(i);//��������
				deleteCart(Integer.parseInt(code), id);
				return;
			}
		}
	}
	
	public void modifyItem(String code, String num,String id)
		throws ServletException{//��ǰ�� ���� ����
		for(int i=0; i<codeList.size(); i++){
			if(codeList.get(i)== Integer.parseInt(code)){
				numList.set(i, Integer.parseInt(num));
				updateCart(Integer.parseInt(code),
						Integer.parseInt(num),id);
				return;
			}
		}
	}
	
	public int getCode(int index){
	//index��° ��ǰ�� ��ȣ�� ����
		return codeList.get(index);
	}
	public int getNum(int index){
	//index��° ��ǰ�� ������ ����
		return numList.get(index);
	}
	
	public int getItemSize(){//īƮ�� ��� ��ǰ��ȣ�� ����
		return codeList.size();
	}
	
	private void insertCart(int code,int num,String id)throws ServletException{
		int seqno=1; CrudHome crud = new CrudHome();
		int maxSeqno = crud.selectMaxSeqnoCart();
		seqno = seqno + maxSeqno;
		CartItem item = new CartItem();
		item.setSeqno(seqno);
		item.setCode(code);
		item.setNum(num);
		item.setId(id);
		int result = crud.insertCart(item);
		if(result < 0) throw new ServletException("īƮ ���� �� ����!");
	}
	private void deleteCart(int code, String id)throws ServletException{
		CrudHome crud = new CrudHome();
		CartItem item = new CartItem();
		item.setCode(code); item.setId(id);
		int result = crud.deleteCart(item);
		if(result<0) throw new ServletException("��ǰ���� �� ����!");
	}
	private void updateCart(int code,int num,String id)throws ServletException{
		CrudHome crud = new CrudHome();
		CartItem item = new CartItem();
		item.setCode(code); item.setNum(num); item.setId(id);
		int result = crud.updateCart(item);
		if(result<0) throw new ServletException("��ǰ���� ���� �� ����!");
	}
	//��ǰ�� īƮ�� ��� �޼���
	public void addCart(int code, int num, String id) throws ServletException{
		for(int i=0; i< codeList.size(); i++){
			if(codeList.get(i)==code){
				numList.set(i, numList.get(i)+1);//��ǰ���� 1 ����
				updateCart(code,numList.get(i),id);
				return;//�޼��� ����
			}//������ ��ǰ��ȣ�� �ִ� ���
		}//��ǰ��ȣ�� ������ŭ �ݺ��ϸ鼭, ������ ��ǰ��ȣ�� �ִ��� �˻�
		codeList.add(code);//��ǰ�� ��ȣ�� ����
		numList.add(num);//��ǰ�� ������ ����
		insertCart(code,num,id);//DB�� ����
	}
}













