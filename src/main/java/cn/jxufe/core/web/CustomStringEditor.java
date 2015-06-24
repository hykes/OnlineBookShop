package cn.jxufe.core.web;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class CustomStringEditor extends PropertyEditorSupport implements PropertyEditor {

	public CustomStringEditor(Class<String> class1) {
		super(class1);
	}

	/**
	 * 如果字符串长度为0，设置为null。
	 */
	@Override
	public void setAsText(String str) throws IllegalArgumentException {
		if(str == null || str.length() <= 0){
			super.setValue(null);
		}else{
			super.setValue(str);
		}
	}
	
	@Override
	public String getAsText() {
		return (String) getValue();
	}
}