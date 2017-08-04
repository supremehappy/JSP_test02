package BookStore;

import java.util.LinkedList;

import javax.servlet.ServletException;

import crud.CrudHome;
import model.CartItem;

public class Cart {
	private LinkedList<Integer> book_codeList =  new LinkedList<Integer>();
	private LinkedList<Integer> numList =  new LinkedList<Integer>();
	
	public int getbook_code(int index) {
		return book_codeList.get(index);
	}
	
	public int getNum(int index) {
		return numList.get(index);
	}
	
	public void setCodeList(Integer book_code){
		book_codeList.add(book_code);
	}
	public void setNumList(Integer num){
		numList.add(num);
	}
	
	public void deleteItem(String book_code, String id) throws ServletException {
		
		for(int i = 0; i < book_codeList.size(); i++) {
			if(book_codeList.get(i) == Integer.parseInt(book_code)) {
				book_codeList.remove(i);
				numList.remove(i);
				deleteCart(Integer.parseInt(book_code), id);
				
				return;
			}
		}
	}
		
	public void modifyItem(String book_code, String num, String id) throws ServletException {
			
		for(int i=0; i < book_codeList.size(); i++) {
			if(book_codeList.get(i) == Integer.parseInt(book_code)) {
				numList.set(i, Integer.parseInt(num));
				updateCart(Integer.parseInt(book_code), Integer.parseInt(num), id);
				
				return;
			}
		}
	}
	
	public int getListSize() {
		return book_codeList.size();
	}
	
	public void insertCart(Integer book_code, Integer num, String id) throws ServletException {
    	CrudHome crud = new CrudHome();
    	CartItem item = new CartItem();
    	
    	int cart_no = 1;
    	int maxCart_no = crud.selectMaxCart_no();
    	cart_no = cart_no + maxCart_no;
    	    	
    	item.setCart_no(cart_no);
    	item.setBook_code(book_code);
    	item.setNum(num);
    	item.setId(id);
    	
    	int result = crud.insertCart(item);
    	
    	if(result < 0) {
    		throw new ServletException("error");
    	}
    }

	public void updateCart(Integer book_code, Integer num, String id) throws ServletException {
		CrudHome crud = new CrudHome();
    	CartItem item = new CartItem();
    	
    	item.setBook_code(book_code);
    	item.setNum(num);
    	item.setId(id);
    	
    	int result = crud.updateCart(item);

    	if(result < 0) {
    		throw new ServletException("error");
    	}
    }
	
    public void deleteCart(Integer book_code, String id) throws ServletException {
    	CrudHome crud = new CrudHome();
    	CartItem item = new CartItem();
    	
    	item.setBook_code(book_code);
    	item.setId(id);
    	
    	int result = crud.deleteCart(item);

    	if(result < 0) {
    		throw new ServletException("error");
    	}
    }
	
	public void addCart(Integer book_code, Integer num, String id) throws ServletException {
		
		for(int i = 0; i < book_codeList.size(); i++) {
			if(book_codeList.get(i) == book_code) {
				numList.set(i, numList.get(i) + 1);
				updateCart(book_code, numList.get(i), id);
				
				return;
			}
		}
		
		book_codeList.add(book_code);
		numList.add(num);
		insertCart(book_code, num, id);
	}
}

