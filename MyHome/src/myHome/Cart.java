package myHome;

import java.util.LinkedList;

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
	
	public void addCart(int code, int num, String id) throws ServletException{
		
		for(int i=0;i<codeList.size() ;i++){// 상품번호 갯수 만큼 반복하며 동일한 상품번호가 있는지
			
			if(codeList.get(i)==code){// 동일한 상품번호가 있다면
				numList.set(i, numList.get(i)+1);
				return;
			}
			//동일한 상품번호가 없다면
			codeList.add(code);
			numList.add(num);
		}
	}	
}
