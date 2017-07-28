package myHome;

import java.util.ArrayList;

public class BBSList {

//----------페이지 링크--------------------------------------------------------------

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
		
//----------페이지 갯수--------------------------------------------------------------	

		private int pageNum;
	
		public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}
		
//----------게시글 정보--------------------------------------------------------------
		
		private ArrayList<Integer> seqNoList = new ArrayList<Integer>();
		private ArrayList<String> titleList = new ArrayList<String>();
		private ArrayList<String> writerList = new ArrayList<String>();
		private ArrayList<String> dateList = new ArrayList<String>();
		
		public int getListSize(){
			return seqNoList.size();
		}
		
		public Integer[] getSeqNoList(){
			return seqNoList.toArray(new Integer[seqNoList.size()]);
		}
		
		public String[] getTitleList(){
			return titleList.toArray(new String[titleList.size()]);
		}
		
		public String[] getwriterList(){
			return writerList.toArray(new String[writerList.size()]);
		}
		
		public String[] getdateList(){
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
