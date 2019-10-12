package com.goodhealth.comm.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.mapper.MapperWrapper;

/**
 * XML字符串和JavaBean的相互转化，使用XStream实现
 */
public class XMLUtil {

/*    public static void main(String[] args){
        System.out.println(toXML(new Student("小王",18)));
        System.out.println(toObject("<dto.Student> <name>小王</name> <age>18</age> </dto.Student>",Student.class));

    }*/
	
	/**
	 * 
	 * @param xmlObj
	 * @return
	 */
	public static String toXML(Object xmlObj) {
		String xmlStr = null;
		XStream stream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
		// 如果没有这句，JavaBean中的注解不会生效
		stream.processAnnotations(xmlObj.getClass());
        xmlStr = stream.toXML(xmlObj);
        return xmlStr;
        
	}
	
	/**
	 * 
	 * @param xmlStr
	 * @param clazz
	 * @return
	 */
	public static <T> T toObject(String xmlStr, Class<T> clazz) {
		  T t = null;
            //xml转对象需要用到dom4j.jar包
			XStream xStream = new XStream(new Dom4JDriver()){
			   @Override  
				protected MapperWrapper wrapMapper(MapperWrapper next) {
				   return new MapperWrapper(next) {
						@Override  
						public boolean shouldSerializeMember(Class definedIn,  
								String fieldName) {  
							if(definedIn == Object.class){  
								try{  
									return this.realClass(fieldName)!=null;        
								}catch(Exception e){  
									return false;  
								}  
							}     
							return super.shouldSerializeMember(definedIn, fieldName);  
						}  
					};
				}  
			};
			xStream.setMode(XStream.NO_REFERENCES);
			xStream.processAnnotations(clazz);    
			t = (T)xStream.fromXML(xmlStr);  
			return t;  
	}

}
