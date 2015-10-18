package com.save.util.UrlUtils;

import com.alibaba.fastjson.JSON;
import org.nutz.json.Json;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsdevotion on 15/10/17.
 */
public class UrlUtil {


    public static void main(String[] args) {
        String packageName = "com.save.controller";

        List<String> classNames = getClassName(packageName);
        for (String className : classNames) {
            System.out.println(className);
        }
    }

    public static String getUrl(List<String> list){

        List<Online> lists = new ArrayList<Online>();
        for(String classes : list){
            try {
                Class<?> aClass = Class.forName(classes);
                Method[] methods = aClass.getMethods();

                for(Method method : methods){
                    OnlineMethod annotation = method.getAnnotation(OnlineMethod.class);
                    if(annotation!=null){
                        Online o = new Online();
                        o.setType(1);
                        o.setMethod(annotation.method());
                        o.setMemo(annotation.memo());
                        o.setParam(annotation.param());
                        o.setUrl(annotation.url());
                        lists.add(o);
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        String message = JSON.toJSONString(lists);

        return message;
    }

    public static List<String> getClassName(String packageName) {
//        String s = ClassLoader.getSystemResource("").getPath();
        String filePath = UrlUtil.class.getClassLoader().getResource("").getPath() + packageName.replace(".", "/");
        List<String> strings = FileKit.listClassFileAbsolutePath(filePath);
        return strings;
    }

    private static List<String> getClassName(String filePath, List<String> className) {
        List<String> myClassName = new ArrayList<String>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                myClassName.addAll(getClassName(childFile.getPath(), myClassName));
            } else {
                String childFilePath = childFile.getPath();
                childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
                childFilePath = childFilePath.replace("\\", ".");
                myClassName.add(childFilePath);
            }
        }

        return myClassName;
    }

}
