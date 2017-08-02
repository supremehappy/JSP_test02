package crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.NoticeItem;
import model.UserInfo;

public class CrudHome {

//-------------------------------------------------------------------- 기초 설정
	private final String namespace = "myHomeMapper";

	private SqlSessionFactory getConnection(){
		String resource="mybatis-config.xml";
		InputStream inputStream=null;
		try{
			inputStream=Resources.getResourceAsStream(resource);
		}catch(IOException e){
			
		}
		SqlSessionFactoryBuilder builder = 
				new SqlSessionFactoryBuilder();
		return builder.build(inputStream);
	}

//-------------------------------------------------------------------- login	
	//계정 조회
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
	// 가장 큰 게시글 번호
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
	
	// 게시글 등록
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
	
	//게시글목록 조회
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
	
	//글 내용 조회
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
	
	// 게시글 수
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
	
	// 다음페이지
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
		
	// 이전페이지
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
	
	// 페이지번호
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
}
