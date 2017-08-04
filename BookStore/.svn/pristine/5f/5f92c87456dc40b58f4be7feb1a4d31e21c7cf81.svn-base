package model;

import java.util.ArrayList;

public class BookList {
	// 이전 페이지, 다음 페이지 링크를 위한 정보
	// request.setAttribute에 객체를 JSP가 호출할때 변수가 boolean 타입이면 BBS_LIST.(isFitstPage)를 찾기 때문에 선언시 is를 빼준다.
	private boolean firstPage;// 첫 페이지인지의 여부
	// false이면 "이전 페이지"링크를 만든다. true이면 안만든다.
	private boolean lastPage;// 마지막 페이지인지의 여부
	// false이면 "다음 페이지"링크를 만든다. true이면 안만든다.
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
	// 페이지 갯수에 대한 정보
	private int pageNum;
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	// 게시글에 대한 모든 정보를 담는다.
	private ArrayList<Integer> bookCodeList = new ArrayList<Integer>();// 도서코드
	private ArrayList<String> bookTitleList = new ArrayList<String>();// 도서제목
	private ArrayList<String> writerList = new ArrayList<String>();// 저자
	private ArrayList<String> companyList = new ArrayList<String>();// 출판사
	private ArrayList<Integer> priceList = new ArrayList<Integer>();// 작성일
	private ArrayList<String> regDateList = new ArrayList<String>();// 작성일
	/*setter*/
	public void setBookCodeList(int index, Integer bookCode) {
		bookCodeList.add(index, bookCode);
	}
	public void setBookTitleList(int index, String bookTitle) {
		bookTitleList.add(index, bookTitle);
	}
	public void setWriterList(int index, String writer) {
		writerList.add(index, writer);
	}
	public void setCompanyList(int index, String company) {
		companyList.add(index, company);
	}
	public void setPriceList(int index, Integer price) {
		priceList.add(index, price);
	}
	public void setRegDateList(int index, String regDate) {
		regDateList.add(index, regDate);
	}
	/*getter*/
	public Integer[] getBookCodeList() {
		// 컬렉션 프레임워크를 배열로 바꾸어서 리턴
		// toArray() 메서드가 배열로 바꾸어준다. 
		return bookCodeList.toArray(new Integer[bookCodeList.size()]);
	}
	public String[] getBookTitleList() {
		return bookTitleList.toArray(new String[bookTitleList.size()]);
	}
	public String[] getWriterList() {
		return writerList.toArray(new String[writerList.size()]);
	}
	public String[] getCompanyList() {
		return companyList.toArray(new String[companyList.size()]);
	}
	public Integer[] getPriceList() {
		return priceList.toArray(new Integer[priceList.size()]);
	}
	public String[] getRegDateList() {
		return regDateList.toArray(new String[regDateList.size()]);
	}
	// 상품정보의 크기를 리턴
	public int getListSize() {
		return bookCodeList.size();
	}
}
