package com.adbhut.service;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

import com.adbhut.bean.TestBean;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class GetterAndSetter {
	public static void main(String[] args) {
		GetterAndSetter gs = new GetterAndSetter();
		TestBean tc = new TestBean();
		gs.callSetter(tc, "name", "John");
		gs.callSetter(tc, "value", 12);
		gs.callSetter(tc, "flag", true);
		// Getting fields of the class
		Field[] fields = tc.getClass().getDeclaredFields();
		BeanWrapper bw = new BeanWrapperImpl(tc); 
		MutablePropertyValues pvs = new MutablePropertyValues();
		pvs.addPropertyValue(new PropertyValue("name", "Adbhut"));
		pvs.addPropertyValue(new PropertyValue("value", 12));
		pvs.addPropertyValue(new PropertyValue("flag", true));
		bw.setPropertyValues(pvs);
		
		for (Field field : fields) {
			if (field.isAnnotationPresent(JsonProperty.class)) {
				BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(tc);
				Object value =  beanWrapper.getPropertyValue(field.getName());
				log.info("Value of field is [{}]", value);
			
				JsonProperty jsonProperty = field.getAnnotation( JsonProperty.class );
				log.info("Value of annoatation is [{}]", jsonProperty.value());
			}
		}

		for (Field f : fields) {
			String fieldName = f.getName();
			System.out.println("Field Name -- " + fieldName);
		}
		gs.callGetter(tc, "name");
		gs.callGetter(tc, "value");
		gs.callGetter(tc, "flag");
	}

	/**
	 * 
	 * @param obj
	 * @param fieldName
	 * @param value
	 */
	private void callSetter(Object obj, String fieldName, Object value) {
		PropertyDescriptor pd;
		try {
			pd = new PropertyDescriptor(fieldName, obj.getClass());
			pd.getWriteMethod().invoke(obj, value);
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param obj
	 * @param fieldName
	 * @param value
	 */
	private void callGetter(Object obj, String fieldName) {
		PropertyDescriptor pd;
		try {
			pd = new PropertyDescriptor(fieldName, obj.getClass());
			System.out.println("" + pd.getReadMethod().invoke(obj));
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}