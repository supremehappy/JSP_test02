package crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.BBSItem;
import model.CartItem;
import model.Condition;
import model.IdSequence;
import model.UserInfo;
import model.Writing;
import model.ProItem;

public class CrudHome {
//���̹�Ƽ�� ȯ�漳�� ������ ����ؼ�, ���۸� ó���ϴ� ��ü�� �����Ѵ�.
//���ۿ� �ִ� ������ �����Ѵ�.
	private final String namespace = "myHomeMapper";
	
	public List<CartItem> selectCart(String id){
		SqlSession sqlSession = getConnection().openSession();
		try{
			String sql=namespace+".selectCart";
			List<CartItem> list=sqlSession.selectList(sql,id);
			return list;
		}finally{
			sqlSession.close();
		}
	}
	
	public Integer updateCart(CartItem item){
		SqlSession sqlSession = getConnection().openSession();
		try{
			String sql=namespace+".updateCart";
			int result = sqlSession.update(sql,item);
			if(result > 0) sqlSession.commit();
			else sqlSession.rollback();
			return result;
		}finally{
			sqlSession.close();
		}
	}
	public Integer deleteCart(CartItem item){
		SqlSession sqlSession = getConnection().openSession();
		try{
			String sql=namespace+".deleteCart";
			int result = sqlSession.delete(sql,item);
			if(result > 0) sqlSession.commit();
			else sqlSession.rollback();
			return result;
		}finally{
			sqlSession.close();
		}
	}
	public Integer selectMaxSeqnoCart(){
		SqlSession sqlSession = getConnection().openSession();
		try{
			String sql=namespace+".selectMaxSeqnoCart";
			Object result = sqlSession.selectOne(sql);
			if(result == null) return 0;
			else return Integer.parseInt(String.valueOf(result));
		}finally{
			sqlSession.close();
		}
	}
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
	public List<BBSItem> selectPrevPage(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		try{
			String sql=namespace+".selectPrevPage";
			List<BBSItem> list=sqlSession.selectList(sql,seqno);
			return list;
		}finally{
			sqlSession.close();
		}
	}
	public List<BBSItem> selectNextPage(int seqno){
		SqlSession sqlSession = getConnection().openSession();
		try{
			String sql=namespace+".selectNextPage";
			List<BBSItem> list=sqlSession.selectList(sql,seqno);
			return list;
		}finally{
			sqlSession.close();
		}
	}
	
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
	//------------------------------------------------------------------
	public List<ProItem> selectProListCondition(Condition c){ // 부분 조회
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".selectProListCondition";
			List<ProItem> result = session.selectList(sql,c);
			return result;
		}finally{
			session.close();
		}
	}
	//------------------------------------------------------------------ 수정된 product
	
	public int selectMaxGroupId(){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".selectMaxGroupId";
			Object result = session.selectOne(sql);
			
			if(result == null) return 0;
			
			return Integer.parseInt(String.valueOf(result));
		}finally{
			session.close();
		}
	}
	
	public int updateOrderNo(ProItem pro){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".updateOrderNo";
			int result = session.update(sql,pro);
			
			if(result>0) session.commit();
			else session.rollback();
			
			return result;
		}finally{
			session.close();
		}
	}
	
	public Integer selectLastId(String name){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".selectLastId";
			Object result = session.selectOne(sql, name);
			if(result == null) return 0;
			return Integer.parseInt(String.valueOf(result));
		}finally{
			session.close();
		}
	}
	
	public Integer insertLastId(IdSequence id){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".insertLastId";
			int result = session.insert(sql, id);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	
	public Integer updateLastId(IdSequence id){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".updateLastId";
			int result = session.update(sql, id);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	
	public Integer insertProInfo(ProItem pro){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".insertProInfo";
			int result = session.insert(sql, pro);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	
	public int insertProContent(ProItem pro){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".insertProContent";
			int result = session.insert(sql, pro);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	
	public ProItem selectProInfo(Integer pid){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".selectProInfo";
			ProItem result = session.selectOne(sql, pid);
			return result;
		}finally{
			session.close();
		}
	}
	
	public int deleteProInfo(Integer pid){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".deleteProInfo";
			int result = session.delete(sql,pid);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	
	public int deleteProContent(Integer seqno){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".deleteProContent";
			int result = session.delete(sql,seqno);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	
	public String selectProContent(Integer pid){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".selectProContent";
			String result = session.selectOne(sql, pid);
			return result;
		}finally{
			session.close();
		}
	}
	
	public int updateProInfo(ProItem pro){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".updateProInfo";
			int result = session.update(sql,pro);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	
	public int updateProContent(ProItem pro){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".updateProContent";
			int result = session.update(sql,pro);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	//------------------------------------------------------------------
	private SqlSessionFactory getConnection(){
		String resource="mybatis-config.xml";//
		InputStream inputStream=null;
		try{
			inputStream=Resources.getResourceAsStream(resource);
		}catch(IOException e){
			
		}
		SqlSessionFactoryBuilder builder = 
				new SqlSessionFactoryBuilder();
		return builder.build(inputStream);
	}
}







