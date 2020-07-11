package com.gaoyuan.tank;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.IOException;
import java.util.Properties;

public class PropertiesMgr {

    static Properties props= new Properties();

    static {
        try {
            props.load(PropertiesMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if (props == null){
            return null;
        }

        return props.get(key);
    }

    public static Integer getInt(String key){
        if (props == null){
            return null;
        }

        return Integer.parseInt((String)props.get(key));
    }

    public static Long getLong(String key){
        if (props == null){
            return null;
        }

        return Long.parseLong((String)props.get(key));
    }

    public static Float getFloat(String key){
        if (props == null){
            return null;
        }

        return Float.parseFloat((String)props.get(key));
    }

    public static Double getDouble(String key){
        if (props == null){
            return null;
        }

        return Double.parseDouble((String)props.get(key));
    }

    public static Short getShort(String key){
        if (props == null){
            return null;
        }

        return Short.parseShort((String)props.get(key));
    }

    public static Byte getByte(String key){
        if (props == null){
            return null;
        }

        return Byte.parseByte((String)props.get(key));
    }

    public static Character getChar(String key){
        if (props == null){
            return null;
        }

        return Character.valueOf(((String)props.get(key)).charAt(0));
    }

    public static Boolean getBoolean(String key){
        if (props == null){
            return null;
        }

        return Boolean.parseBoolean((String)props.get(key));
    }

    public static String getString(String key){
        if (props == null){
            return null;
        }

        return (String)props.get(key);
    }


}
