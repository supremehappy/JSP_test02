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
import model.UserInfo;

public class CrudHome {
//마이바티스 환경설정 파일을 사용해서, 매퍼를 처리하는 객체를 생성한다.
//매퍼에 있는 쿼리를 실행한다.
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
	
	private SqlSessionFactory getConnection(){
		String resource="mybatis-config.xml";//환경설정파일 이름
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







