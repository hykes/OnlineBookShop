package cn.jxufe.core.web;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import cn.jxufe.core.web.FormatConstants;
import cn.jxufe.core.web.CustomStringEditor;
import cn.jxufe.core.web.editor.DoubleEditor;
import cn.jxufe.core.web.editor.FloatEditor;

/**
 * 
* 类名称：DefaultBindingInitializer   
* 类描述： Spring MVC WebBindingInitializer绑定属性类型
* 创建人：Jxufe HeHaiYang
* 创建时间：2014-11-16 下午02:18:30     
* 修改备注：   
* @version
 */
public class DefaultBindingInitializer implements WebBindingInitializer{

	public void initBinder(WebDataBinder binder, WebRequest request) {
		DateFormat dateFormat = FormatConstants.DATE_TIME_FORMAT;
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Integer.class,new CustomNumberEditor(Integer.class,true));
		binder.registerCustomEditor(Long.class,new CustomNumberEditor(Long.class,true));
		binder.registerCustomEditor(String.class,new CustomStringEditor(String.class));
		binder.registerCustomEditor(Collection.class, new CustomCollectionEditor(Collection.class, true));
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor(true));
		binder.registerCustomEditor(Double.class, new DoubleEditor());
		binder.registerCustomEditor(Float.class, new FloatEditor());
	}
	
}
