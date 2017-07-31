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

public class CrudHome {
// 환경설정 파일을 이용하여 매퍼를 처리하는 객체
// 매퍼에 있는 쿼리 실행
	
	private final String namespace="myHomeMapper";

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
	
	//매퍼 처리하는 객체 생성 메소드
	private SqlSessionFactory getConnection(){
		String resource="MyBatisConfig.xml";
		InputStream inputStream=null;
		
		try{
			inputStream=Resources.getResourceAsStream(resource);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		return builder.build(inputStream);
	}
}
