package com.goodhealth.comm.util;


import com.goodhealth.comm.Student;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectMapUtil {
    /**
     *  ObjectToMap
     * @param obj  需要转化为map的java类
     * @return      Map<String, Object>
     * @throws Exception
     */
    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if(obj == null){
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        // 获取bean描述对象
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        // 获取属性描述对象数组
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter!=null ? getter.invoke(obj) : null;
            map.put(key, value);
        }
        return map;
    }

    /**
     * MapToObject
     * @param map  需要被转换成java类的map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static <T> T mapToObject(Map<String, Object> map, Class<T> beanClass) throws Exception {
        if (map == null) {
            return null;
        }
        T t = beanClass.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            Method setter = property.getWriteMethod();
            if (setter != null) {
                setter.invoke(t, map.get(key));
            }
        }
        return t;
    }


/*    public  static void main(String[] args)throws Exception{
        Student userDO = new Student("赫斯",1);
        System.out.println(objectToMap(userDO));
        HashMap<String, Object> zhangsan = new HashMap<>();
        zhangsan.put("age", 19);
        zhangsan.put("name","张三");
        System.out.println(mapToObject(zhangsan, Student.class));
    }*/

}
