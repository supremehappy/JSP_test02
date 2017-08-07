package myHome;

import java.util.ArrayList;

public class ProList {

	private boolean firstPage;
	private boolean lastPage;

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.firstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.lastPage = isLastPage;
	}
	
	//--------------------------------------------------------------------
	
	private int pageNum;
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	//--------------------------------------------------------------------
	
	private ArrayList<Integer> proList = new ArrayList<Integer>();
	private ArrayList<String> nameList = new ArrayList<String>();
	private ArrayList<Integer> priceList = new ArrayList<Integer>();
	private ArrayList<String> dateList = new ArrayList<String>();
	private ArrayList<String> writerList = new ArrayList<String>();
	
	public int getListSize(){
		return proList.size();
	}
	
	public Integer[] getProList(){
		return proList.toArray(new Integer[proList.size()]);
	}
	
	public String[] getNameList(){
		return nameList.toArray(new String[nameList.size()]);
	}
	
	public Integer[] getPriceList(){
		return priceList.toArray(new Integer[priceList.size()]);
	}
	
	public String[] getwriterList(){
		return writerList.toArray(new String[writerList.size()]);
	}
	
	public String[] getdateList(){
		return dateList.toArray(new String[dateList.size()]);
	}
	
	public void setProList(int index, Integer pro){
		proList.add(index, pro);
	}
	
	public void setNameList(int index, String name){
		nameList.add(index, name);
	}
	
	public void setPriceList(int index, Integer price){
		priceList.add(index, price);
	}
	
	public void setWriterList(int index, String writer){
		writerList.add(index, writer);
	}
	
	public void setDateList(int index, String date){
		dateList.add(index, date);
	}		
}
