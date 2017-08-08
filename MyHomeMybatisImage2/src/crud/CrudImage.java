package crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Condition;
import model.IdSequence;
import model.Writing;

public class CrudImage {
	//-------------------------------------------------------------------
	private final String namespace = "imageMapper";
	
	private SqlSessionFactory getConnection(){
		String resource="mybatis-config.xml";//ȯ�漳������ �̸�
		InputStream inputStream=null;
		try{
			inputStream=Resources.getResourceAsStream(resource);
		}catch(IOException e){
			
		}
		SqlSessionFactoryBuilder builder = 
				new SqlSessionFactoryBuilder();
		return builder.build(inputStream);
	}

	//-------------------------------------------------------------------
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
	
	public Integer insertWrtingInfo(Writing writing){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".insertWrtingInfo";
			int result = session.insert(sql, writing);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	
	public int insertWritingContent(Writing writing){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".insertWritingContent";
			int result = session.insert(sql, writing);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	
	public List<Writing> selectImageList(){ // 전체조회
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".selectImageList";
			List<Writing> result = session.selectList(sql);
			return result;
		}finally{
			session.close();
		}
	}
	//-------------------------------------------------------------------
	public List<Writing> selectImageListCondition(Condition c){ // 부분 조회
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".selectImageListCondition";
			List<Writing> result = session.selectList(sql,c);
			return result;
		}finally{
			session.close();
		}
	}
	//-------------------------------------------------------------------
	public Writing selectWritingInfo(Integer seqno){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".selectWritingInfo";
			Writing result = session.selectOne(sql, seqno);
			return result;
		}finally{
			session.close();
		}
	}
	
	public String selectWritingContent(Integer seqno){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".selectWritingContent";
			String result = session.selectOne(sql, seqno);
			return result;
		}finally{
			session.close();
		}
	}
	//-------------------------------------------------------------------
	public int deleteWritingInfo(Integer seqno){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".deleteWritingInfo";
			int result = session.delete(sql,seqno);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	
	public int deleteWritingContent(Integer seqno){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".deleteWritingContent";
			int result = session.delete(sql,seqno);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	//-------------------------------------------------------------------
	public int updateWritingInfo(Writing writing){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".updateWritingInfo";
			int result = session.update(sql,writing);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	
	public int updateWritingContent(Writing writing){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".updateWritingContent";
			int result = session.update(sql,writing);
			if(result > 0) session.commit();
			else session.rollback();
			return result;
		}finally{
			session.close();
		}
	}
	//-------------------------------------------------------------------

	public int selectImageCount(){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".selectImageCount";
			int result = session.selectOne(sql);
			return result;
		}finally{
			session.close();
		}
	}
	
	//-------------------------------------------------------------------
	
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
	
	//-------------------------------------------------------------------
	
	public int updateOrderNo(Writing writing){
		SqlSession session = getConnection().openSession();
		try{
			String sql = namespace + ".updateOrderNo";
			int result = session.update(sql,writing);
			
			if(result>0) session.commit();
			else session.rollback();
			
			return result;
		}finally{
			session.close();
		}
	}
}





