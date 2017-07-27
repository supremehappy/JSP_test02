package myHome;

import java.util.ArrayList;

public class BBSList {

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
