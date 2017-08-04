package myhome;

import java.util.ArrayList;

public class BBSList {
	//이전페이지, 다음페이지 링크를 위한 정보
	private boolean firstPage;//첫 페이지인지 여부
	//false이면 "이전 페이지"링크를 만든다. true이면 안만든다.
	private boolean lastPage;//마지막 페이지인지 여부
	//false이면 "다음 페이지"링크를 만든다. true이면 안만든다.
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

	
	//페이지 갯수에 대한 정보
	private int pageNum;
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	//게시글에 대한 모든 정보를 담는다.
	private ArrayList<Integer> seqNoList=new ArrayList<Integer>();//글번호
	private ArrayList<String> titleList=new ArrayList<String>();//글제목
	private ArrayList<String> writerList=new ArrayList<String>();//작성자
	private ArrayList<String> dateList=new ArrayList<String>();//작성일
	
	public int getListSize(){
		return seqNoList.size();
	}
	
	public Integer[] getSeqNoList(){
		return seqNoList.toArray(new Integer[seqNoList.size()]);
	}
	public String[] getTitleList(){
		return titleList.toArray(new String[titleList.size()]);
	}
	public String[] getWriterList(){
		return writerList.toArray(new String[writerList.size()]);
	}
	public String[] getDateList(){
		return dateList.toArray(new String[dateList.size()]);
	}
	
	public void setSeqNoList(int index, Integer seqNo){
		seqNoList.add(index, seqNo);
	}
	public void setTitleList(int index, String title){
		titleList.add(index, title);
	}
	public void setWriterList(int index, String writer){
		writerList.add(index, writer);
	}
	public void setDateList(int index, String date){
		dateList.add(index, date);
	}
}







