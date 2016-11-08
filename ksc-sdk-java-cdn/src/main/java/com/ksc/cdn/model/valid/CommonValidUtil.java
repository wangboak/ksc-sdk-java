package com.ksc.cdn.model.valid;

import com.ksc.cdn.KscClientException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * CommonValidUtil
 *
 * 验证请求参数是否合法
 *
 * @author jiangran@kingsoft.com
 * @date 08/11/2016
 */
public class CommonValidUtil {
    private final static Logger log= LoggerFactory.getLogger(CommonValidUtil.class);

    /**
     * 验证请求参数是否合法
     * @param object
     * @throws KscClientException
     */
    public static void check(Object object) throws KscClientException{
        Class<? extends Object> clazz=object.getClass();
        Field[] fields=clazz.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            FieldValidate annotation = field.getAnnotation(FieldValidate.class);
            if(annotation!=null) {
                if(!annotation.nullable()){
                    try {
                        Object value = field.get(object);
                        if(value==null|| StringUtils.isBlank(value.toString())){
                            throw new KscClientException(String.format("field %s not null",field.getName()));
                        }
                    } catch (IllegalAccessException e) {
                        log.warn("validate bean field {} cause illegal access exception",field.getName());
                    }

                }
            }
            field.setAccessible(false);
        }
    }
}
