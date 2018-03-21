package test.com.jeecode.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by 刘少年 on 2016/11/27.
 */
public class FiledValueUtils {

    public static void setToNull(Object obj, String... filedNames) {
        if (obj == null || filedNames == null) {
            return;
        }
        try {
            Collection collectionObj = new ArrayList();
            if (obj instanceof Collection) {
                collectionObj = (Collection) obj;
            } else {
                collectionObj.add(obj);
            }
            for (String filedName : filedNames) {
                setFiledToNull(collectionObj, filedName);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void setFiledToNull(Collection collectionObj, String filedName) throws NoSuchFieldException, IllegalAccessException {
        Field field = null;
        for (Object obj : collectionObj) {
            if (obj == null) {
                continue;
            }
            if (field == null) {
                Class clazz = obj.getClass();
                field = clazz.getDeclaredField(filedName);
                field.setAccessible(true);
            }
            field.set(obj, null);
        }
    }

    public static void main(String[] args) {

    }
}
