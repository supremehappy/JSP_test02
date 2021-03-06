package crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.BBSItem;
import model.BookItem;

import model.CartItem;
import model.NoticeItem;
import model.UserInfo;

public class CrudHome {
	//=======================자유게시판 목록============================
			public Integer selectNextCount1(int seqno){
				SqlSession sqlSession = getConnection().openSession();
				try{
					String sql=namespace+".selectNextCount1";
					int result = sqlSession.selectOne(sql,seqno);
					return result;
				}finally{
					sqlSession.close();
				}
			}
			public List<BBSItem> selectBBSPage(int seqno){
				SqlSession sqlSession = getConnection().openSession();
				try{
					String sql=namespace+".selectBBSPage";
					List<BBSItem> list=sqlSession.selectList(sql, seqno);
					return list;
				}finally{
					sqlSession.close();
				}
			}
			public Integer selectPrevCount1(int seqno){
				SqlSession sqlSession = getConnection().openSession();
				try{
					String sql=namespace+".selectPrevCount1";
					int result = sqlSession.selectOne(sql,seqno);
					return result;
				}finally{
					sqlSession.close();
				}
			}
			public List<BBSItem> selectPrevPage1(int seqno){
				SqlSession sqlSession = getConnection().openSession();
				try{
					String sql=namespace+".selectPrevPage1";
					List<BBSItem> list=sqlSession.selectList(sql,seqno);
					return list;
				}finally{
					sqlSession.close();
				}
			}
			public List<BBSItem> selectNextPage1(int seqno){
				SqlSession sqlSession = getConnection().openSession();
				try{
					String sql=namespace+".selectNextPage1";
					List<BBSItem> list=sqlSession.selectList(sql,seqno);
					return list;
				}finally{
					sqlSession.close();
				}
			}
			
			public Integer selectPage1(){
				SqlSession sqlSession = getConnection().openSession();
				try{
					String sql=namespace+".selectPage1";
					Integer num = sqlSession.selectOne(sql);
					return num;
				}finally{
					sqlSession.close();
				}
			}
			public BBSItem selectBBSItem(Integer seqno){
				SqlSession sqlSession = getConnection().openSession();
				try{
					String sql=namespace+".selectBBSItem";
					BBSItem item = sqlSession.selectOne(sql,seqno);
					return item;
				}finally{
					sqlSession.close();
				}
			}
			
			public List<BBSItem> selectBBS(){
				SqlSession sqlSession = getConnection().openSession();
				try{
					String sql=namespace+".selectBBS";
					List<BBSItem> list = sqlSession.selectList(sql);
					return list;
				}finally{
					sqlSession.close();
				}
			}
	// ======================자유게시판 등록============================
	public Integer insertBBS(BBSItem bbs){
		SqlSession sqlSession = getConnection().openSession();
		try{
			String sql=namespace + ".insertBBS";
			int result = sqlSession.insert(sql,bbs);
			if(result > 0) sqlSession.commit();
			else sqlSession.rollback();
			return result;
		}finally{
			sqlSession.close();
		}
	}
	
	public Integer selectMaxSeqno(){
		SqlSession sqlSession = getConnection().openSession();
		try{
			String sql=namespace + ".selectMaxSeqno";
			Object result=sqlSession.selectOne(sql);
			if(result == null) return 0;
			else {
				int num = Integer.parseInt(String.valueOf(result));
				return num;
			}
		}finally{
			sqlSession.close();
		}
	}
	/*-------------------------------------------------------도서정보-------------------------------------------------------*/
	public Integer selectNextCount(int bookCode) {// 첫 페이지인지 처리를 위한 남은 글갯수 조회
		SqlSession sqlSession = getConnection().openSession();
		try {
			String sql = namespace + ".selectNextCount";
			int result = sqlSession.selectOne(sql, bookCode);
			return result;
		} finally {
			sqlSession.close();
		}
	}// end selectNextCount()
	public List<BookItem> selectPage(int bookCode) {// 페이지 번호 클릭시 처리
		SqlSession sqlSession = getConnection().openSession();
		try {
			String sql = namespace + ".selectBookPage";
			List<BookItem> list = sqlSession.selectList(sql, bookCode);
			return list;
		} finally {
			sqlSession.close();
		}
	}// end selectPage()
	public Integer selectPrevCount(int bookCode) {// 이전 페이지의 갯수를 조회
		SqlSession sqlSession = getConnection().openSession();
		try {
			String sql = namespace + ".selectPrevCount";
			int result = sqlSession.selectOne(sql, bookCode);
			return result;
		} finally {
			sqlSession.close();
		}
	}// end selectPrevCount
	public List<BookItem> selectPrevPage(int bookCode) {// 이전 페이지 처리
		SqlSession sqlSession = getConnection().openSession();
		try {
			String sql = namespace + ".selectPrevPage";
			List<BookItem> list = sqlSession.selectList(sql, bookCode);
			return list;
		} finally {
			sqlSession.close();
		}
	}// end selectNextPage();
	public List<BookItem> selectNextPage(int bookCode) {// 게시판 다음 페이지 처리
		SqlSession sqlSession = getConnection().openSession();
		try {
			String sql = namespace + ".selectNextPage";
			List<BookItem> list = sqlSession.selectList(sql, bookCode);
			return list;
		} finally {
			sqlSession.close();
		}
	}// end selectNextPage()
	public Integer selectPage() {// 도서 정보 전체 글 갯수 조회
		SqlSession sqlSession = getConnection().openSession();
		try {
			String sql = namespace + ".selectPage";
			Integer num = sqlSession.selectOne(sql);
			return num;
		} finally {
			sqlSession.close();
		}
	}// end selectPage()
	public BookItem selectBookItem(Integer bookCode) {// 도서정보 본문 보기 처리
		SqlSession sqlSession = getConnection().openSession();
		try {
			String sql = namespace + ".selectBookItem";
			BookItem item = sqlSession.selectOne(sql, bookCode);
			return item;
		} finally {
			sqlSession.close();
		}
	}// end selectBookItem()
	public List<BookItem> selectBook() {// 도서정보 리스트 조회
		SqlSession sqlSession = getConnection().openSession();
		try {
			String sql = namespace + ".selectBook";
			List<BookItem> list = sqlSession.selectList(sql);
			return list;
		} finally {
			sqlSession.close();
		}
	}// end selectBook()
	public Integer insertBook(BookItem book) {// 도서정보 등록
		SqlSession sqlSession = getConnection().openSession();
		try {
			String sql = namespace + ".insertBook";
			int result = sqlSession.insert(sql, book);
			if(result > 0) sqlSession.commit();
			else sqlSession.rollback();
			return result;
		} finally {
			sqlSession.close();
		}
	}// end insertBook()
	public Integer selectMaxBookCode() {// 도서정보 등록 전 도서코드 조회
		SqlSession sqlSession = getConnection().openSession();
		try {
			String sql = namespace + ".selectMaxBookCode";
			Object result = sqlSession.selectOne(sql);
			if(result == null) return 0;
			else {
				int num = Integer.parseInt(String.valueOf(result));// Object 객체는 Integer로 바로 가져올 수 없기 때문에 String으로 먼저 변환한다.
				return num;
			}
		} finally {
			sqlSession.close();
		}
	}// end selectMaxBookCode()
	/*-------------------------------------------------------도서정보 end---------------------------------------------------*/
	//--------------------------------------------------------------------기초 설정
	private final String namespace = "BookStoreMapper";
	
	//userInput
	
	public Integer insertUser(UserInfo user){
		SqlSession sqlSession = getConnection().openSession();
		try{
			String sql=namespace + ".insertUser";
			int result =sqlSession.insert(sql,user);			
			
			
			if(result > 0) {
				sqlSession.commit();
			}
			else {
				sqlSession.rollback();
			}
			
			return result;
		}finally{
			sqlSession.close();
		}
	}
	
	//===================================================================
	
	public Integer selectMaxCart_no() {
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql = namespace + ".selectMaxCart_no";
			Object result = sqlSession.selectOne(sql);
			
			if(result == null) {
				return 0;
			}
			else {
				return Integer.parseInt(String.valueOf(result));
			}
		}
		finally {
			sqlSession.close();
		}
	}
	
	public Integer insertCart(CartItem item) {
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql = namespace + ".insertCart";
			int result = sqlSession.insert(sql, item);
			
			if(result > 0) {
				sqlSession.commit();
			}
			else {
				sqlSession.rollback();
			}
			
			return result;
		}
		finally {
			sqlSession.close();
		}
	}

	public Integer updateCart(CartItem item) {
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql = namespace + ".updateCart";
			int result = sqlSession.update(sql,item);
			
			if(result > 0) {
				sqlSession.commit();
			}
			else {
				sqlSession.rollback();
			}
			
			return result;
		}
		finally {
			sqlSession.close();
		}
	}
	
	public Integer deleteCart(CartItem item) {
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql = namespace + ".deleteCart";
			int result = sqlSession.delete(sql, item);
			
			if(result > 0) {
				sqlSession.commit();
			}
			else {
				sqlSession.rollback();
			}
			
			return result;
		}
		finally {
			sqlSession.close();
		}
	}
		
	public List<CartItem> selectCart(String id) {
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectCart";
			List<CartItem> list=sqlSession.selectList(sql, id);

			return list;
		}
		finally {
			sqlSession.close();
		}
	}	
	
	//============================ login =======================================
	public UserInfo selectMember(String id){
		SqlSession sqlSession = getConnection().openSession();
		try{
			String sql=namespace+".selectMember";
			UserInfo info = sqlSession.selectOne(sql,id);
			
			return info;
		}finally{
			sqlSession.close();
		}
	}
	//============================notice =======================================
	public Integer selectNoticeMaxSeqno(){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace + ".selectNoticeMaxSeqno";
			Object result=sqlSession.selectOne(sql);
			
			if(result == null) return 0;
			else {
				int num = Integer.parseInt(String.valueOf(result));
				return num;
			}
		}finally{
			sqlSession.close();
		}
	}
	
	public Integer insertNoticeBBS(NoticeItem bbs){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace + ".insertNoticeBBS";
			int result = sqlSession.insert(sql,bbs);
			
			if(result > 0) sqlSession.commit();
			else sqlSession.rollback();
			
			return result;
		}finally{
			sqlSession.close();
		}
	}
	
	public List<NoticeItem> selectNotice(){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectNotice";
			List<NoticeItem> list = sqlSession.selectList(sql);
			
			return list;
		}finally{
			sqlSession.close();
		}
	}
	
	public NoticeItem selectNoticeItem(Integer seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectNoticeItem";
			NoticeItem item = sqlSession.selectOne(sql,seqno);
			
			return item;			
		}finally{
			sqlSession.close();
		}
	}
	
	public Integer selectNoticePage(){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectNoticePage";
			Integer num = sqlSession.selectOne(sql);
			
			return num;
		}finally{
			sqlSession.close();
		}
	}
	
	public List<NoticeItem> selectNoticeNextPage(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectNoticeNextPage";
			List<NoticeItem> list=sqlSession.selectList(sql,seqno);
			
			return list;
		}finally{
			sqlSession.close();
		}
	}	
		
	public List<NoticeItem> selectNoticePrevPage(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectNoticePrevPage";
			List<NoticeItem> list=sqlSession.selectList(sql,seqno);
			
			return list;
		}finally{
			sqlSession.close();
		}
	}
	
	public Integer selectNoticePrevCount(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectNoticePrevCount";
			int result = sqlSession.selectOne(sql,seqno);
			
			return result;
		}finally{
			sqlSession.close();
		}
	}
	
	public List<NoticeItem> selectNoticeNumPage(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectNoticeNumPage";
			List<NoticeItem> list=sqlSession.selectList(sql, seqno);
			
			return list;
		}finally{
			sqlSession.close();
		}
	}
	
	public Integer selectNoticeNextCount(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectNoticeNextCount";
			int result = sqlSession.selectOne(sql,seqno);
			
			return result;
		}finally{
			sqlSession.close();
		}
	}
	
	//============================ admin =======================================
	public UserInfo selectAdmin(String id){
		SqlSession sqlSession = getConnection().openSession();
		try{
			String sql=namespace+".selectAdmin";
			UserInfo info = sqlSession.selectOne(sql,id);
						
			return info;
		}finally{
			sqlSession.close();
		}
	}
	//===================================================================

	private SqlSessionFactory getConnection() {
		String resource = "mybatis-config.xml";//ȯ�漳������ �̸�
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		}
		catch(IOException e) {
			
		}
		if(inputStream == null) System.out.println("inputStream is null");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		return builder.build(inputStream);
	}
}
