package com.goodhealth.algorithm.reflex;

import com.goodhealth.comm.util.LoggerUtil;
import org.springframework.cache.annotation.Cacheable;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 动态获取类的信息以及动态调用对象的方法的功能称为Java语言的反射机制
 * Java反射机制主要提供了以下功能：
 * 在运行时判断任意一个对象所属的类；
 * 在运行时构造任意一个类的对象；
 * 在运行时判断任意一个类所具有的成员变量和方法；
 * 在运行时调用任意一个对象的方法；
 * 生成动态代理。
 */
public class Client {

    public static void main(String[] args) throws Exception {
        new Client().getterAndSetter();
    }

    public Class<?> createClass(){
        // 通过类名构造Class对象  最安全高效
        Class PC = Person.class;
        // 通过Class类的静态方法来构造Class对象
        try {
            Class Pc = Class.forName("com.goodhealth.algorithm.reflex.Person");
        } catch (ClassNotFoundException e) {
            LoggerUtil.error("找不到这个类{}",e);
        }
        //通过类的实例构造Class对象
        Class pc = new Person().getClass();
        // 特殊类的情况
        Class bc = Boolean.TYPE; // boolean.class
        /**
         * 类似的还有int double long byte short float char void
         */
        return PC;
    }

    public void getClassInfo(){
        Class pclass = createClass();
        /**  使用Java反射，你可以在运行时检查Java类。检查类是使用反射时经常做的第一件事情。
         * 从类中可以获取以下信息：
         *(1) 类名(2) 类修饰符 (public, private, synchronized等)(3) 包信息
         *(4) 父类(5) 实现的接口(6) 构造函数
         *(7) 方法(8) 字段(9) 注解
         */
        // 获取类的全限定名 com.goodhealth.algorithm.reflex.Person
        pclass.getName();
        // 获取类的类名 Person
        pclass.getSimpleName();
        // 获取类的修饰词
        int modifiers = pclass.getModifiers();
        java.lang.reflect.Modifier.isPublic(modifiers);
        // 获取类的包信息
        Package pack = pclass.getPackage();
        pack.getName();
        // 获取父类的Class
        Class superClass = pclass.getSuperclass();
        // 获取实现的接口列表 注意只返回此类实现的的接口，其父类、子类的接口都不在内
        Class[] interfaces = pclass.getInterfaces();
        // 获取构造方法  构造方法需是public的 私有的不能拿到
        Constructor[] constructors = pclass.getConstructors();
        // 获取方法
        Method[] methods = pclass.getMethods();
        // 获取字段
        Field[] fields = pclass.getFields();
        // 获取注解
        Annotation[] annotations = pclass.getAnnotations();
    }

    public Constructor useConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class pclass = createClass();
        // 获取所有构造方法  构造方法需是public的
        // 私有的不拿能到除非使用getDeclaredConstructors()--> getDeclaredXXX不限定修饰词
        Constructor[] constructors = pclass.getConstructors();
        // 获取指定的构造方法
        Constructor withArgConstructor = pclass.getConstructor(Integer.class,String.class);
        Constructor noArgConstructor = pclass.getConstructor();
        // 根据构造方法获取它的参数类型
        /** parameterTypes[0]  class java.lang.Integer */
        Class[] parameterTypes = withArgConstructor.getParameterTypes();
        // 使用构造方法实例对象
        Person person = (Person) withArgConstructor.newInstance(18,"Mr.Wang");
        person.getName(); // Mr.Wang
        return withArgConstructor;
    }


    public void useField() throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IntrospectionException {
        Class pclass = createClass();
        Person person = (Person) useConstructor().newInstance(18,"DangDang");
        // 获取类的所有属性Field对象 必须为public修饰词  除非使用getDeclaredFields
        // 私有的不拿能到除非使用getDeclaredConstructors()--> getDeclaredXXX不限定修饰词
        Field[] fieldsPublic = pclass.getFields();
        Field[] fieldsNoLimit = pclass.getDeclaredFields();
        /** fieldsNoLimit[0]-----> private java.lang.String com.goodhealth.algorithm.reflex.Person.name */
        // 获取类指定属性Field
//        Field fieldPublic = pclass.getField("age");
        Field fieldNoLimit = pclass.getDeclaredField("name");
        // 获取Field 字段名称
        fieldNoLimit.getName();
        // 获取Field字段类型
        fieldNoLimit.getType();
        // 获取、设置Field字段的值
        fieldNoLimit.setAccessible(true);  // 关闭了访问检查 暴力破解private字段的封装性
        String name = (String)fieldNoLimit.get(person); // Mr.Wang
        fieldNoLimit.set(person,"MR.Wang"); // {"name":"MR.Wang","age":18}
    }

    public void useMethod() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class pclass = createClass();
        Person person = (Person) useConstructor().newInstance(18,"Mr.Wang");
        // 获取类中的方法
        Method[] methodsPublic = pclass.getMethods();
        Method[] methodsNoLimit = pclass.getDeclaredMethods();
        Method methodNoLimit = pclass.getDeclaredMethod("doSome");
        Method setName = pclass.getDeclaredMethod("setName",String.class);
        Method staMethod = pclass.getDeclaredMethod("staMethod");
        // 获取类中方法的参数
        Class[] paramType = pclass.getDeclaredMethod("setName",String.class).getParameterTypes();
        /** paramType[0] class java.lang.String */
        // 获取类中方法的返回类型
        Class returnType = pclass.getDeclaredMethod("getName").getReturnType();
        /** returnType class java.lang.String */
        // 通过反射调用类中的方法
        methodNoLimit.invoke(person);
        setName.invoke(person,"MS.Wang");
        // 当调用的是静态方法时，实例传null值即可
        staMethod.setAccessible(true); // 关闭了访问检查 暴力破解private方法的封装性
        staMethod.invoke(null);
    }

    public void getterAndSetter() throws IntrospectionException {
        Class pclass = createClass();

        /** 利用 Field + PropertyDescriptor 获取类的get/set方法 */
        Field[] fieldsNoLimit = pclass.getDeclaredFields();
        for (Field field :fieldsNoLimit) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), pclass);
            Method getMethod = pd.getReadMethod(); // 获得get方法
            Method setMethod = pd.getWriteMethod(); // 获得set方法
        }

        /** 利用 BeanInfo + PropertyDescriptor 获取类的get/set方法 */
        BeanInfo beanInfo = Introspector.getBeanInfo(pclass);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName(); // 获取属性名
            Class type = property.getPropertyType();  // 获取属性类型
            Method setter = property.getWriteMethod(); // 获得set方法
            Method getter = property.getReadMethod(); // 获得get方法
        }
    }
}
