package suport2;

import org.activiti.engine.form.AbstractFormType;

public class SimpleSelectFormType extends AbstractFormType {

	public static final String TYPE_NAME = "simpleSelect";
	   
   	public String getName() {
   		return TYPE_NAME;
   	}
   
   	@Override
   	public Object convertFormValueToModelValue(String propertyValue) {
   		Integer table = Integer.valueOf(propertyValue);
   		return table;
   	}
   
   	@Override
   	public String convertModelValueToFormValue(Object modelValue) {
   		if	(modelValue	== null) {
   			return null;
   		}
   		return modelValue.toString();
   	}
}
