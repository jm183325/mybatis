package mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DictTypeDao {
	public DictType dictTypeSelect(String type);
	//Pojo方式
	public Integer dictTypeInsert(DictType dictType);
	//命名参数
	public DictType dictTypeSelectParam(@Param("type")String type,@Param("isSql")String isSql);
	//默认方式
	public DictType dictTypeSelectParam1(String type,String isSql);
	//map方式
	public DictType dictTypeSelectMap(Map<String,Object> map);
	//list方式
	public DictType dictTypeSelectList(List<String> types);
	//数组方式
	public DictType dictTypeSelectArray(String [] types );
}
