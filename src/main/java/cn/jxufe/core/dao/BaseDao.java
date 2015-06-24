package cn.jxufe.core.dao;

import java.util.List;
import java.util.Map;

import cn.jxufe.web.entity.Page;

public interface BaseDao {

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
	public abstract List findListBean(final String sql, Class clazz);

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
	public abstract List findListBeanByArray(final String sql, Class clazz,
			Object... arrayParams);

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
	public abstract List findListBeanByMap(final String sql, Class clazz,
			Map parameters);

	public abstract int findIntByArray(final String sql, Object... arrayParams);
	
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
	public abstract long findLongByBean(final String sql, Object beanParameters);

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
	public abstract long findLongByMap(final String sql, Map parameters);

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
	public abstract Object findUniqueBeanByArray(final String sql, Class clazz,
			Object... arrayParams);

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
	public abstract Object findUniqueBeanByMap(final String sql, Class clazz,
			Map parameters);

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
	public abstract long findLongByArray(final String sql,
			Object... arrayParams);

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
	public abstract int executeByArray(final String sql, Object... arrayParams)
			throws Exception;

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
	public abstract int executeByMap(final String sql, Map parameters)
			throws Exception;

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
	public abstract int executeByBean(final String sql, Object bean)
			throws Exception;
	
	public abstract Page findPageListByArray(Page page, Class clazz, String sql, Object... parameters);

	public abstract int executeGetKey(final String sql, final Object[] args)throws Exception;
}