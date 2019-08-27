package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HelloWord {
	public static void main(String[] args) {
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//DictType selectOne = sqlSession.selectOne("dictTypeSelectxml","1001");
			DictTypeDao  dictTypeDao= (DictTypeDao) sqlSession.getMapper(DictTypeDao.class);
			//DictType dictType = selectOne2.dictTypeSelect("1001");
			//System.out.println(selectOne);
			//System.out.println(dictType);
			DictType dictTdictTypeDaoype=new DictType();
			dictTdictTypeDaoype.setType("2");
			//oracle插空会报错，mysql映射的是jdbcType不会报错
			dictTdictTypeDaoype.setIsSql(null);
			dictTdictTypeDaoype.setCreateBy("1");
			Integer dictTypeCount = dictTypeDao.dictTypeInsert(dictTdictTypeDaoype);
			System.out.println(dictTypeCount);
			//命名参数
			DictType dictTypeParam=dictTypeDao.dictTypeSelectParam("1", "1");
			System.out.println("dictTypeParam=="+dictTypeParam);
			//param1,param2...paramn
			DictType dictTypeParam1=dictTypeDao.dictTypeSelectParam1("1", "1");
			System.out.println("dictTypeParam1=="+dictTypeParam1);
			//map
			Map<String,Object> map=new HashMap();
			map.put("type", "1");
			map.put("isSql", "1");
			map.put("dictType", "dict_type");
			DictType dictTypeMap=dictTypeDao.dictTypeSelectMap(map);
			System.out.println("dictTypeMap=="+dictTypeMap);
			//list
			List<String> types=new ArrayList();
			types.add("1");
			DictType dictTypeSelectList=dictTypeDao.dictTypeSelectList(types);
			System.out.println("dictTypeSelectList=="+dictTypeSelectList);
			//数组
			String[] typess= {"1","2"};
			DictType dictTypeSelectArray=dictTypeDao.dictTypeSelectArray(typess);
			System.out.println("dictTypeSelectArray=="+dictTypeSelectArray);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
