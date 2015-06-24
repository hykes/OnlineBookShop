package cn.jxufe.core.dao;

import org.springframework.util.Assert;
/**
 * 
* 类名称：CountSqlBuilder   
* 类描述： 获得count语句的构建工具
* 创建人：Jxufe HeHaiYang
* 创建时间：2015-1-19 下午07:29:00     
* 修改备注：   
* @version
 */
public abstract class CountSqlBuilder {
	
	public static String getCountSql(String nativeSQL){
		return getCountSql(nativeSQL,"COUNT(0)");
	}

	public static String getCountSql(String nativeSQL,String countSQL){
		Assert.hasText(nativeSQL,"sql语句不正确!");
		String sql=nativeSQL.toUpperCase();
		if(sql.indexOf("DISTINCT(")>=0||sql.indexOf(" GROUP BY ")>=0){
			return "SELECT "+countSQL+" FROM ("+nativeSQL+") TEMP_COUNT_TABLE";
		}
		String[] froms=sql.split(" FROM ");
		String tempSql="";
		for(int i=0;i<froms.length;i++){
			if(i!=froms.length-1){
				tempSql=tempSql.concat(froms[i]+" FROM ");
			}else{
				tempSql=tempSql.concat(froms[i]);
			}
			int left=tempSql.split("\\(").length;
			int right=tempSql.split("\\)").length;
			if(left==right){
				break;
			}
		}
		tempSql=" FROM "+nativeSQL.substring(tempSql.length(),sql.length());
		int orderBy = tempSql.toUpperCase().indexOf(" ORDER BY ");
		if(orderBy>=0){
			tempSql=tempSql.substring(0,orderBy);
		}
		return "SELECT "+countSQL+" ".concat(tempSql);
	}
	
}
