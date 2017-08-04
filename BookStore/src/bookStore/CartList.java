package bookStore;

import java.util.ArrayList;

public class CartList {
	private ArrayList<Integer> cart_noList = new ArrayList<Integer>();
	private ArrayList<Integer> book_codeList = new ArrayList<Integer>();
	private ArrayList<String> book_titleList = new ArrayList<String>();
	private ArrayList<Integer> numList = new ArrayList<Integer>();
	private ArrayList<Integer> priceList = new ArrayList<Integer>();
	private ArrayList<String> idList = new ArrayList<String>();
	
	public int getListSize() {
		return cart_noList.size();
	}
	
	public Integer[] getCart_noList() {
		return cart_noList.toArray(new Integer[cart_noList.size()]);
	}
	public Integer[] getBook_codeList() {
		return book_codeList.toArray(new Integer[book_codeList.size()]);
	}
	public Integer[] getNumList() {
		return numList.toArray(new Integer[numList.size()]);
	}
	public Integer[] getPriceList() {
		return priceList.toArray(new Integer[priceList.size()]);
	}
	public String[] getIdList() {
		return idList.toArray(new String[idList.size()]);
	}
	public String[] getBook_titleList() {
		return book_titleList.toArray(new String[book_titleList.size()]);
	}
	
	public void setCart_noList(int index, Integer cart_no) {
		cart_noList.add(index, cart_no);
	}
	public void setBook_codeList(int index, Integer book_code) {
		book_codeList.add(index, book_code);
	}
	public void setNumList(int index, Integer num) {
		numList.add(index, num);
	}
	public void setPriceList(int index, Integer price) {
		priceList.add(index, price);
	}
	public void setIdList(int index, String id) {
		idList.add(index, id);
	}
	public void setBook_titleList(int index, String book_title) {
		book_titleList.add(index, book_title);
	}
}
