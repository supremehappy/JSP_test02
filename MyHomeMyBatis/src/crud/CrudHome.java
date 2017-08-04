package crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.BBSItem;
import model.ProItem;
import model.UserInfo;
import model.CartItem;


public class CrudHome {
// 환경설정 파일을 이용하여 매퍼를 처리하는 객체
// 매퍼에 있는 쿼리 실행
	
	private final String namespace="myHomeMapper";

	
//--------------------------------------------------------------------------------초기 설정	
	//매퍼 처리하는 객체 생성 메소드
	private SqlSessionFactory getConnection(){
		String resource="mybatis-config.xml";
		InputStream inputStream=null;
		
		try{
			inputStream = Resources.getResourceAsStream(resource);
		}catch(IOException e){
			
		}
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		return builder.build(inputStream);
	}
//--------------------------------------------------------------------------------login
	// 계정 조회 하는 메소드
	public UserInfo selectMember(String id){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			
			//매퍼 네임스페이스.셀렉트 아이디
			String sql=namespace+".selectMember";
			//select 건수가 하나일때 selectOne 메소드 사용 / 다수일때 selectList 메소드 사용
			UserInfo info = sqlSession.selectOne(sql,id);
			
			return info;
			
		}finally{
			sqlSession.close();
		}
	}
//--------------------------------------------------------------------------------bbs	
	// bbs 제일 큰 글번호 찾는 메소드
	public Integer selectMaxSeqno(){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectMaxSeqno";
			Object result=sqlSession.selectOne(sql);
			
			if(result == null) return 0;
			else{
				int num = Integer.parseInt(String.valueOf(result));
				return num;
			}
		}finally{
			sqlSession.close();
		}
	}
	
	// bbs 게시글 등록 메소드
	public Integer insertBBS(BBSItem bbs){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql = namespace+".insetBBS";
			int result = sqlSession.insert(sql, bbs);
			
			if(result >0) sqlSession.commit();
			else sqlSession.rollback();
			return result;
			
		}finally{
			sqlSession.close();
		}
	}

//--------------------------------------------------------------------------------bbs
	// 페이지 번호 처리하기 위한 보조 메소드
	public Integer selectNextCount(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectNextCount";
			int result = sqlSession.selectOne(sql,seqno);
			return result;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 페이지 번호 처리 하는 메소드
	public List<BBSItem> selectBBSPage(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectBBSPage";
			List<BBSItem> list = sqlSession.selectList(sql,seqno);
			return list;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 이전페이지 처리하기 위한 보조 메소드
	public Integer selectPrevCount(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectPrevCount";
			int result = sqlSession.selectOne(sql,seqno);
			return result;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 이전페이지 처리하는 메소드
	public List<BBSItem> selectPrevPage(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectPrevPage";
			List<BBSItem> list = sqlSession.selectList(sql,seqno);
			return list;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 다음페이지 처리하는 메소드
	public List<BBSItem> selectNextPage(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectNextPage";
			List<BBSItem> list = sqlSession.selectList(sql,seqno);
			return list;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 페이지 처리하는 메소드
	public Integer selectPage(){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectPage";
			Integer num = sqlSession.selectOne(sql);
			return num;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 글 내용 보여주기 위한 메소드
	public BBSItem selectBBSItem(Integer seqno){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectBBSItem";
			BBSItem item = sqlSession.selectOne(sql, seqno);
			return item;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 게시글 리스트 처리 하기 위한 메소드
	public List<BBSItem> selectBBS(){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectBBS";
			List<BBSItem> list=sqlSession.selectList(sql);
			return list;
			
		}finally{
			sqlSession.close();
		}
	}

//--------------------------------------------------------------------------------product	
	// product 제일 큰 글번호 찾는 메소드
	public Integer selectMaxPid(){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectMaxPid";
			Object result=sqlSession.selectOne(sql);
			
			if(result == null) return 0;
			
			else{
				int num = Integer.parseInt(String.valueOf(result));
				return num;
			}
		}finally{
			sqlSession.close();
		}
	}
	
	// product 게시글 등록 메소드
	public Integer insertPro(ProItem pro){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql = namespace+".insetPro";
			int result = sqlSession.insert(sql, pro);
			
			if(result >0) sqlSession.commit();
			else sqlSession.rollback();
			return result;
			
		}finally{
			sqlSession.close();
		}
	}
	
//--------------------------------------------------------------------------------product	
	// 페이지 번호 처리하기 위한 보조 메소드
	public Integer selectProNextCount(int pid){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectProNextCount";
			int result = sqlSession.selectOne(sql,pid);
			return result;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 페이지 번호 처리 하는 메소드
	public List<ProItem> selectProPage(int pid){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectProPage";
			List<ProItem> list = sqlSession.selectList(sql,pid);
			return list;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 이전페이지 처리하기 위한 보조 메소드
	public Integer selectProPrevCount(int pid){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectProPrevCount";
			int result = sqlSession.selectOne(sql,pid);
			return result;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 이전페이지 처리하는 메소드
	public List<ProItem> selectProPrevPage(int pid){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectProPrevPage";
			List<ProItem> list = sqlSession.selectList(sql,pid);
			return list;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 다음페이지 처리하는 메소드
	public List<ProItem> selectProNextPage(int pid){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectProNextPage";
			List<ProItem> list = sqlSession.selectList(sql,pid);
			return list;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 페이지 처리하는 메소드
	public Integer selectProPageNum(){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectProPageNum";
			Integer num = sqlSession.selectOne(sql);
			return num;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 글 내용 보여주기 위한 메소드
	public ProItem selectProItem(Integer pid){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectProItem";
			ProItem item = sqlSession.selectOne(sql, pid);
			return item;
			
		}finally{
			sqlSession.close();
		}
	}
	
	// 게시글 리스트 처리 하기 위한 메소드
	public List<ProItem> selectPro(){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectPro";
			List<ProItem> list=sqlSession.selectList(sql);
			return list;
			
		}finally{
			sqlSession.close();
		}
	}
	
//--------------------------------------------------------------------------------cart
	//
	public Integer selectMaxSeqnoCart(){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			if(sqlSession == null)			System.out.println("sqlSession is null");
			String sql=namespace+".selectMaxSeqnoCart";
			Object result = sqlSession.selectOne(sql);
			
			if(result == null) 	return 0;
			else return Integer.parseInt(String.valueOf(result));
			
		}finally{
			sqlSession.close();
		}
	}
	
	//
	public Integer insertCart(CartItem item){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".insertCart";
			int result = sqlSession.insert(sql, item);
			
			if(result > 0) sqlSession.commit();
			else sqlSession.rollback();
			return result;
			
		}finally{
			sqlSession.close();
		}
	}
	
	//
	public Integer deleteCart(CartItem item){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".deleteCart";
			int result = sqlSession.selectOne(sql, item);
			
			if(result >0) sqlSession.commit();
			else sqlSession.rollback();
			
			return result;
			
		}finally{
			sqlSession.close();
		}
	}
	
	//
	public Integer updateCart(CartItem item){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".updateCart";
			int result = sqlSession.selectOne(sql, item);
			
			if(result >0) sqlSession.commit();
			else sqlSession.rollback();
			
			return result;
			
		}finally{
			sqlSession.close();
		}
	}
	
	public List<CartItem> selectCart(String id){
		SqlSession sqlSession = getConnection().openSession();
		
		try{
			String sql=namespace+".selectCart";
			
			System.out.println("selectCart sql : "+sql);
			System.out.println("selectCart id : "+id);
			
			List<CartItem> list = sqlSession.selectOne(sql, id);
			
			System.out.println("selectCart list : "+list);
			
			return list;
			
		}finally{
			sqlSession.close();
		}
	}
}
