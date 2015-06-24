package cn.jxufe.core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.util.Assert;

import cn.jxufe.web.entity.Page;


/**
 * 
* 类名称：BaseDaoImpl   
* 类描述： 基础Dao层实现类
* 创建人：Jxufe HeHaiYang
* 创建时间：2015-1-19 上午10:26:14     
* 修改备注：   
* @version
 */
@Repository
public class BaseDaoImpl implements BaseDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	protected Logger logger = Logger.getLogger(getClass());

	/**
	 * 
	* 方法名: resultBeanMapper
	* 方法作用: TODO 当POJO对象和数据库表字段完全对应或者驼峰式与下划线式对应时，该类会根据构造函数中传递的class来自动填充数据。
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:34:05   
	* @param @param clazz
	* @param @return    
	* 返回值类型： RowMapper    
	* @throws
	 */
	protected RowMapper resultBeanMapper(Class clazz) {
		return ParameterizedBeanPropertyRowMapper.newInstance(clazz);
		
	}
	
	/**
	 * 
	* 方法名: paramBeanMapper
	* 方法作用: TODO 
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:46:17   
	* @param @param object
	* @param @return    
	* 返回值类型： BeanPropertySqlParameterSource    
	* @throws
	 */
	protected BeanPropertySqlParameterSource paramBeanMapper(Object object) {
		return new BeanPropertySqlParameterSource(object);
	}
	
	/**
	 * 
	* 方法名: findListBean
	* 方法作用: TODO 
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:40:14   
	* @param @param sql
	* @param @param clazz
	* @param @return    
	* 返回值类型： List    
	* @throws
	 */
	public List findListBean(final String sql, Class clazz) {
		try {
			Assert.hasText(sql, "sql语句不正确!");
			Assert.notNull(clazz, "类集合中对象类型不能为空!");
			logger.info("SQL:" + sql);
			List list = jdbcTemplate.query(sql, resultBeanMapper(clazz));
			logger.info("查询SQL响应条目:" + list.size());
			return list;
		} catch (EmptyResultDataAccessException e) {
			logger.error("查询SQL无结果------" + e);
			return null;
		} catch (Exception e) {
			logger.error("查询SQL异常 no result! {}" + e);
			return null;
		}
	}
	
	/**
	 * 
	* 方法名: findListBeanByArray
	* 方法作用: TODO 
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:36:53   
	* @param @param sql
	* @param @param clazz
	* @param @param arrayParams
	* @param @return    
	* 返回值类型： List    
	* @throws
	 */
	public List findListBeanByArray(final String sql, Class clazz, Object... arrayParams) {
		try {
			Assert.hasText(sql, "sql语句不正确!");
			Assert.notNull(clazz, "类集合中对象类型不能为空!");
			logger.info("SQL:" + sql);
			List list = null;
			if (arrayParams != null) {
				list = jdbcTemplate.query(sql, resultBeanMapper(clazz), arrayParams);
			} else {
				list = jdbcTemplate.query(sql, resultBeanMapper(clazz));
			}
			logger.info("查询SQL响应条目:" + list.size());
			return list;
		} catch (EmptyResultDataAccessException e) {
			logger.error("查询SQL无结果------" + e);
			return null;
		} catch (Exception e) {
			logger.error("查询SQL异常 no result! {}" + e);
			return null;
		}
	}
	
	/**
	 * 
	* 方法名: findListBeanByMap
	* 方法作用: TODO 
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:42:00   
	* @param @param sql
	* @param @param clazz
	* @param @param parameters
	* @param @return    
	* 返回值类型： List    
	* @throws
	 */
	public List findListBeanByMap(final String sql,Class clazz,Map parameters){
		try{
			Assert.hasText(sql,"sql语句不正确!");
			Assert.notNull(clazz,"集合中对象类型不能为空!");
			logger.info("SQL:"+sql);
			List list = null;
			if(parameters!=null){
				list = jdbcTemplate.query(sql, resultBeanMapper(clazz),parameters);
			}else{
				list = jdbcTemplate.query(sql, resultBeanMapper(clazz));
			}
			logger.info("响应条目:"+list.size());
			return list;
		}catch (EmptyResultDataAccessException ere) {
			return null;
		}catch (Exception e) {
			logger.error("not result!{}",e);
			return null;
		}
	}
	
	/**
	 * 
	* 方法名: findLongByBean
	* 方法作用: TODO 
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:44:44   
	* @param @param sql
	* @param @param beanParameters
	* @param @return    
	* 返回值类型： long    
	* @throws
	 */
	public long findLongByBean(final String sql,Object beanParameters){
		try{
			Assert.hasText(sql,"sql语句不正确!");
			logger.info("SQL:"+sql);
			if(beanParameters!=null){
				return jdbcTemplate.queryForLong(sql, paramBeanMapper(beanParameters));
			}else{
				return jdbcTemplate.queryForLong(sql);
			}
		}catch (EmptyResultDataAccessException ere) {
			return 0;
		}catch (Exception e) {
			logger.error("not result!{}",e);
			return 0;
		}
	}
	
	/**
	 * 
	* 方法名: findLongByMap
	* 方法作用: TODO
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:47:16   
	* @param @param sql
	* @param @param parameters
	* @param @return    
	* 返回值类型： long    
	* @throws
	 */
	public long findLongByMap(final String sql,Map parameters){
		try{
			Assert.hasText(sql,"sql语句不正确!");
			logger.info("SQL:"+sql);
			if(parameters!=null){
				return jdbcTemplate.queryForLong(sql, parameters);
			}else{
				return jdbcTemplate.queryForLong(sql);
			}
		}catch (EmptyResultDataAccessException ere) {
			return 0;
		}catch (Exception e) {
			logger.error("not result!{}",e);
			return 0;
		}
	}
	
	/**
	 * 
	* 方法名: findUniqueBeanByArray
	* 方法作用: TODO 
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:48:34   
	* @param @param sql
	* @param @param clazz
	* @param @param arrayParams
	* @param @return    
	* 返回值类型： Object    
	* @throws
	 */
	public Object findUniqueBeanByArray(final String sql, Class clazz, Object... arrayParams) {
		try {
			Assert.hasText(sql, "sql语句不正确!");
			Assert.notNull(clazz, "类集合中对象类型不能为空!");
			logger.info("SQL:" + sql);
			if (arrayParams != null) {
				return jdbcTemplate.queryForObject(sql, resultBeanMapper(clazz), arrayParams);
			} else {
				return jdbcTemplate.queryForObject(sql, resultBeanMapper(clazz));
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error("查询SQL无结果------" + e);
			return null;
		} catch (Exception e) {
			logger.error("查询SQL异常 no result! {}" + e);
			return null;
		}
	}

	/**
	 * 
	* 方法名: findUniqueBeanByMap
	* 方法作用: TODO 
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:48:17   
	* @param @param sql
	* @param @param clazz
	* @param @param parameters
	* @param @return    
	* 返回值类型： Object    
	* @throws
	 */
	public Object findUniqueBeanByMap(final String sql,Class clazz,Map parameters){
		try{
			Assert.hasText(sql,"sql语句不正确!");
			Assert.notNull(clazz,"集合中对象类型不能为空!");
			logger.info("SQL:"+sql);
			if(parameters!=null){
				return jdbcTemplate.queryForObject(sql, resultBeanMapper(clazz), parameters);
			}else{
				return jdbcTemplate.queryForLong(sql, resultBeanMapper(clazz));
			}
		}catch (EmptyResultDataAccessException ere) {
			return null;
		}catch (Exception e) {
			logger.error("not result!{}",e);
			return null;
		}
	}
	
	
	/**
	 * 
	* 方法名: findIntByArray
	* 方法作用: TODO 
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 下午01:00:48   
	* @param @param sql
	* @param @param arrayParams
	* @param @return    
	* 返回值类型： long    
	* @throws
	 */
	public int findIntByArray(final String sql, Object... arrayParams) {
		try {
			Assert.hasText(sql, "sql语句不正确!");
			logger.info("SQL:" + sql);
			if (arrayParams != null) {
				return jdbcTemplate.queryForInt(sql, arrayParams);
			} else {
				return jdbcTemplate.queryForInt(sql);
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error("查询SQL无结果------" + e);
			return 0;
		} catch (Exception e) {
			logger.error("查询SQL异常 no result! {}" + e);
			return 0;
		}
	}
	
	/**
	 * 
	* 方法名: findLongByArray
	* 方法作用: TODO 
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:49:37   
	* @param @param sql
	* @param @param arrayParams
	* @param @return    
	* 返回值类型： long    
	* @throws
	 */
	public long findLongByArray(final String sql, Object... arrayParams) {
		try {
			Assert.hasText(sql, "sql语句不正确!");
			logger.info("SQL:" + sql);
			if (arrayParams != null) {
				return jdbcTemplate.queryForLong(sql, arrayParams);
			} else {
				return jdbcTemplate.queryForLong(sql);
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error("查询SQL无结果------" + e);
			return 0;
		} catch (Exception e) {
			logger.error("查询SQL异常 no result! {}" + e);
			return 0;
		}
	}
	
	/**
	 * 
	* 方法名: executeByArray
	* 方法作用: TODO
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:51:16   
	* @param @param sql
	* @param @param arrayParams
	* @param @return
	* @param @throws Exception    
	* 返回值类型： int    
	* @throws
	 */
	public int executeByArray(final String sql,Object... arrayParams) throws Exception{
		Assert.hasText(sql, "sql语句不正确!");
		logger.info("SQL:" + sql);
		int affectCount=0;
		if(arrayParams!=null){
			affectCount=jdbcTemplate.update(sql, arrayParams);
		}else {
			affectCount=jdbcTemplate.update(sql);
		}
		logger.info("查询SQL影响条目:"+affectCount);
		return affectCount;
	}
	
	/**
	 * 
	* 方法名: executeByMap
	* 方法作用: TODO
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:51:19   
	* @param @param sql
	* @param @param parameters
	* @param @return
	* @param @throws Exception    
	* 返回值类型： int    
	* @throws
	 */
	public int executeByMap(final String sql,Map parameters)throws Exception{
		Assert.hasText(sql,"sql语句不正确!");
		logger.info("SQL:"+sql);
		int affectCount = 0;
		if(parameters!=null){
			affectCount = jdbcTemplate.update(sql, parameters);
		}else{
			affectCount = jdbcTemplate.update(sql);
		}
		logger.info("查询SQL影响条目:"+affectCount);
		return affectCount;
	}
	
	/**
	 * 
	* 方法名: executeByBean
	* 方法作用: TODO
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 上午10:52:12   
	* @param @param sql
	* @param @param bean
	* @param @return
	* @param @throws Exception    
	* 返回值类型： int    
	* @throws
	 */
	public int executeByBean(final String sql,Object bean)throws Exception{
		Assert.hasText(sql,"sql语句不正确!");
		logger.info("SQL:"+sql);
		int affectCount = 0;
		if(bean!=null){
			affectCount = jdbcTemplate.update(sql, paramBeanMapper(bean));
		}else{
			affectCount = jdbcTemplate.update(sql);
		}
		logger.info("影响条目:"+affectCount);
		return affectCount;
	}
	
	/**
	 * 
	* 方法名: findPageListByArray
	* 方法作用: TODO 
	* 创建人：Jxufe HeHaiYang
	* 创建时间：2015-1-19 下午07:45:54   
	* @param @param page
	* @param @param clazz
	* @param @param sql
	* @param @param parameters
	* @param @return    
	* 返回值类型： Page    
	* @throws
	 */
	public Page findPageListByArray(Page page, Class clazz, String sql, Object... parameters) {
		int count = findIntByArray(CountSqlBuilder.getCountSql(sql), parameters);
		page.setTotalRecord(count);
		sql = sql+" limit "+page.getStartIndex()+","+page.getPageSize();
		List list=jdbcTemplate.query(sql, parameters, resultBeanMapper(clazz));	
		page.setList(list);
		return page;
	}
	
	/**
	 * 获得自增长主键
	 */
	public int executeGetKey(final String sql, final Object[] args)throws Exception {
	 	KeyHolder keyHolder = new GeneratedKeyHolder();
	 	jdbcTemplate.update(new PreparedStatementCreator(){
	 		public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
	 			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	 			for (int i = 0; i < args.length; i++) {
	 				switch (args[i].getClass().getName()) {
					case "java.lang.String":
						ps.setString(i+1, (String)args[i]);
						break;
					case "java.lang.Long":
						ps.setLong(i+1, (Long)args[i]);
						break;
					case "java.lang.Integer":
						ps.setInt(i+1, (Integer)args[i]);
						break;
					case "java.lang.Double":
						ps.setDouble(i+1, (Double)args[i]);
						break;
					case "java.lang.Float":
						ps.setFloat(i+1, (Float)args[i]);
						break;
					case "java.sql.Date":
						ps.setDate(i+1, (Date)args[i]);
						break;
					case "java.util.Date":
						ps.setDate(i+1, (Date)args[i]);
						break;
					default:
						break;
					}
	 			}
	 			return ps;
	 		}
	 	},keyHolder);
	 	return keyHolder.getKey().intValue();//从主键执有者中获取主键
	}
	
}
