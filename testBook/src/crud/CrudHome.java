package crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.CartItem;
import model.NoticeItem;
import model.UserInfo;

public class CrudHome {

//-------------------------------------------------------------------- 湲곗큹 �꽕�젙
	private final String namespace = "BookStoreMapper";

	private SqlSessionFactory getConnection() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		}
		catch(IOException e) {
			
		}
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		return builder.build(inputStream);
	}

//-------------------------------------------------------------------- login	
	//怨꾩젙 議고쉶
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
	
//-------------------------------------------------------------------- notice	
	// 媛��옣 �겙 寃뚯떆湲� 踰덊샇
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
	
	// 寃뚯떆湲� �벑濡�
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
	
	//寃뚯떆湲�紐⑸줉 議고쉶
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
	
	//湲� �궡�슜 議고쉶
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
	
	// 寃뚯떆湲� �닔
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
	
	// �떎�쓬�럹�씠吏�
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
		
	// �씠�쟾�럹�씠吏�
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
			String sql=namespace+".selectPrevCount";
			int result = sqlSession.selectOne(sql,seqno);
			
			return result;
		}finally{
			sqlSession.close();
		}
	}
	
	// �럹�씠吏�踰덊샇
	public List<NoticeItem> selectNoticePage(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectNoticePage";
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
	
//-------------------------------------------------------------------- cart
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
}
