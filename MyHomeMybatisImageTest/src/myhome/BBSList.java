package myhome;

import java.util.ArrayList;

public class BBSList {
	//����������, ���������� ��ũ�� ���� ����
	private boolean firstPage;//ù ���������� ����
	//false�̸� "���� ������"��ũ�� �����. true�̸� �ȸ����.
	private boolean lastPage;//������ ���������� ����
	//false�̸� "���� ������"��ũ�� �����. true�̸� �ȸ����.
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

	
	//������ ������ ���� ����
	private int pageNum;
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	//�Խñۿ� ���� ��� ������ ��´�.
	private ArrayList<Integer> seqNoList=new ArrayList<Integer>();//�۹�ȣ
	private ArrayList<String> titleList=new ArrayList<String>();//������
	private ArrayList<String> writerList=new ArrayList<String>();//�ۼ���
	private ArrayList<String> dateList=new ArrayList<String>();//�ۼ���
	
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







