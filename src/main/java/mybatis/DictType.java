package mybatis;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DictType {
	private String type;
	private String isSql;
	private Date createTime;
	private String createBy;
	private Date updateTime;
	private Integer version;
}
