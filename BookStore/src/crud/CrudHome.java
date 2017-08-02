package crud;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CrudHome {

	//--------------------------------------------------------------------기초 설정
		private final String namespace = "myHomeMapper";

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

}
