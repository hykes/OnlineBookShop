package cn.jxufe.web.admin.service;

import java.util.List;

import cn.jxufe.web.entity.Category;
import cn.jxufe.web.entity.Page;

public interface CategoryService {

	public abstract int insertCategory(Category cate) throws Exception;

	public abstract int updateCategory(Category cate) throws Exception;

	public abstract int deleteCategory(Integer id) throws Exception;

	public abstract Category queryCategory(Integer id);

	public abstract Page getCategoryPage(Page page);

	public abstract List<Category> getCategoryList();

	public abstract List<Category> getPCategoryList();
	
	public abstract List<Category> getPCategoryListForIndex();

}