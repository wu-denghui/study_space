package com.goodhealth.comm.util;

import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于cglib代理(不使用反射，底层依靠ASM（开源的Java字节码编辑类库）操作字节码)的Bean复制工具
 */
public class BeanUtils {

    /**
     * 静态map BEAN_COPIERS 用于保存实例过的BeanCopier 减少重复使用同一BeanCopier对象时开销
     */
    static final Map<String, BeanCopier> BEAN_COPIERS = new HashMap<String, BeanCopier>();

    public static <T> T copy(Object sourceObject, T targetObject) {
        if(sourceObject == null) {
            return targetObject;
        }
        String key = sourceObject.getClass().getName() + targetObject.getClass().getName();
        /**
         * 基于cglib的BeanCopier
         * BeanCopier只拷贝名称和类型都相同的属性。当目标类的setter数目比getter少时，创建BeanCopier会失败而导致拷贝不成功。
         */
        BeanCopier copier = null;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(sourceObject.getClass(), targetObject.getClass(), false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        copier.copy(sourceObject, targetObject, null);
        return targetObject;
    }


    /**
     * 判断该对象是否所有属性值全为空
     * @param obj
     * @return
     * @throws Exception
     */
    public static boolean isAllFieldNull(Object obj) throws Exception{
        // 得到类对象
        Class stuCla = obj.getClass();
        // 得到属性集合
        Field[] fs = stuCla.getDeclaredFields();
        boolean flag = true;
        // 遍历属性
        for (Field f : fs) {
            // 设置属性是可以访问的(私有的也可以)
            f.setAccessible(true);
            // 得到此属性的值
            Object val = f.get(obj);
            //只要有1个属性不为空,那么就不是所有的属性值都为空
            if(val!=null) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
