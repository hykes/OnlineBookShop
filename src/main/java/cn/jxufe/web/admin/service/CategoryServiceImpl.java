package cn.jxufe.web.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.core.dao.BaseDao;
import cn.jxufe.web.entity.Category;
import cn.jxufe.web.entity.Page;

@Service
public  class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	public BaseDao baseDao;
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.CategoryService#insertCategory(cn.jxufe.web.entity.Category)
	 */
	public int insertCategory(Category cate) throws Exception{
		String sql = "insert into t_category(name,pid,description,orderIndex) values(?,?,?,?)";
		Object[] args=new Object[]{ cate.getName(), cate.getPid(), cate.getDescription(), cate.getOrderIndex() };
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.CategoryService#updateCategory(cn.jxufe.web.entity.Category)
	 */
	public int updateCategory(Category cate) throws Exception{
		String sql = "update t_category set name=?,pid=?,description=?,orderIndex=? where id=?";
		Object[] args=new Object[]{ cate.getName(), cate.getPid(), cate.getDescription(), cate.getOrderIndex(), cate.getId() };
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.CategoryService#deleteCategory(java.lang.Integer)
	 */
	public int deleteCategory(Integer id) throws Exception{
		String sql = "delete  t_category where id=?";
		Object[] args=new Object[]{ id };
		return baseDao.executeByArray(sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.CategoryService#queryCategory(java.lang.Integer)
	 */
	public Category queryCategory(Integer id){
		String sql = "select * from t_category where id = ? ";
		Object[] args = new Object[] { id };
		return  (Category) baseDao.findUniqueBeanByArray(sql, Category.class, args);
	}

	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.CategoryService#getCategoryPage(cn.jxufe.web.entity.Page)
	 */
	public Page getCategoryPage(Page page){
		String sql = "select * from t_category order by orderIndex desc";
		Object[] args = new Object[] {  };
		return baseDao.findPageListByArray(page, Category.class, sql, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.CategoryService#getCategoryList()
	 */
	public List<Category> getCategoryList(){
		String sql = "select * from t_category";
		Object[] args = new Object[] {  };
		return baseDao.findListBeanByArray(sql, Category.class, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.CategoryService#getPCategoryList()
	 */
	public List<Category> getPCategoryList(){
		String sql = "select * from t_category where pid=0";
		Object[] args = new Object[] {  };
		return baseDao.findListBeanByArray(sql, Category.class, args);
	}
	
	/* (non-Javadoc)
	 * @see cn.jxufe.web.admin.service.CategoryService#getPCategoryList()
	 */
	public List<Category> getPCategoryListForIndex(){
		String sql = "select * from t_category where pid=0 order by orderIndex desc limit 0,5";
		Object[] args = new Object[] {  };
		return baseDao.findListBeanByArray(sql, Category.class, args);
	}
	

}
