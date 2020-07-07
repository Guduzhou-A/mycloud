package org.gdz.mycloud.common.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * fastJson工具类
 *
 * @author guduzhou
 */
@Slf4j
public class FastJsonUtil {

    private static final SerializeConfig CONFIG;
    private static final SimpleDateFormatSerializer FORMAT_SERIALIZER = new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss");

    static {
        CONFIG = new SerializeConfig();
        CONFIG.put(java.util.Date.class, FORMAT_SERIALIZER);
    }

    private static final SerializerFeature[] FEATURES = {
            // 输出空置字段
            SerializerFeature.WriteMapNullValue,
            // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullListAsEmpty,
            // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullNumberAsZero,
            // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullBooleanAsFalse,
            // 字符类型字段如果为null，输出为""，而不是null
            SerializerFeature.WriteNullStringAsEmpty
    };

    /**
     * 转为JSON 格式字符串 (输出空置字段,输出空list,map,数值)
     *
     * @param object
     * @return
     */

    public static String format(Object object) {
        try {
            return JSON.toJSONString(object, CONFIG, FEATURES);
        } catch (Exception e) {
            log.error("json转换Str失败！");
            return null;
        }

    }

    /**
     * 转为JSON 格式字符串 无配置
     *
     * @param object
     * @return
     */
    public static String formatNoFeatures(Object object) {
        try {
            return JSON.toJSONString(object, CONFIG, SerializerFeature.DisableCircularReferenceDetect);
        } catch (Exception e) {

            log.error("json转换Str失败！");
            return null;
        }
    }

    /**
     * @param text
     * @return
     */
    public static Object parse(String text) {
        try {
            return JSON.parse(text);
        } catch (Exception e) {
            log.error("json转换Bean失败！");

        }
        return null;
    }

    /**
     * 转换为对应实体类
     *
     * @param text
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parse(String text, Class<T> clazz) {

        try {
            return JSON.parseObject(text, clazz);
        } catch (Exception e) {
            log.error("json转换指定Bean失败！");

        }
        return null;
    }

    /**
     * 转换为数组
     *
     * @param text
     * @param <T>
     * @return
     */
    public static <T> Object[] toArray(String text) {

        try {
            return toArray(text, null);
        } catch (Exception e) {
            log.error("json转换数组失败！");

        }
        return null;
    }

    /**
     * 转换为数组
     *
     * @param text
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Object[] toArray(String text, Class<T> clazz) {

        try {
            return JSON.parseArray(text, clazz).toArray();
        } catch (Exception e) {
            log.error("json转换指定类型数组失败！");

        }
        return null;
    }

    /**
     * 转换为List
     *
     * @param text
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> asList(String text, Class<T> clazz) {

        try {
            return JSON.parseArray(text, clazz);
        } catch (Exception e) {
            log.error("json转换指定类型List失败！");

        }
        return new ArrayList<>();
    }

    /**
     * 将javabean转化为序列化的json字符串
     *
     * @param keyvalue
     * @return
     */
    public static Object beanToJson(KeyValue keyvalue) {
        try {
            String textJson = JSON.toJSONString(keyvalue);
            Object objectJson = JSON.parse(textJson);
            return objectJson;
        } catch (Exception e) {
            log.error("将javabean转化为序列化的json字符串失败！");

        }
        return null;
    }

    /**
     * 将string转化为序列化的json字符串
     *
     * @param
     * @return
     */
    public static Object textToJson(String text) {
        try {
            Object objectJson = JSON.parse(text);
            return objectJson;
        } catch (Exception e) {
            log.error("将string转化为序列化的json字符串失败！");

        }
        return null;
    }

    /**
     * json字符串转化为map
     *
     * @param s
     * @return
     */
    public static Map stringToCollect(String s) {
        try {
            Map m = JSONObject.parseObject(s);
            return m;
        } catch (Exception e) {
            log.error("json字符串转化为map失败！");

        }
        return null;
    }

    /**
     * 将map转化为string
     *
     * @param m
     * @return
     */
    public static String collectToString(Map m) {
        try {
            String s = JSONObject.toJSONString(m);
            return s;
        } catch (Exception e) {
            log.error("将map转化为string失败！");

        }
        return null;
    }

    /**
     * 把对象转换为指定对象
     */
    public static <T> T toObjectFromSource(Object source, Class<T> target) {
        return parse(format(source), target);
    }

    /**
     * 把对象转换为Map
     */
    public static Map toObject2MapFromSource(Object source) {
        return stringToCollect(format(source));
    }

    public static <T> T readJsonFromClassPath(String path, Type type) throws IOException {

        ClassPathResource resource = new ClassPathResource(path);
        if (resource.exists()) {
            return JSON.parseObject(resource.getInputStream(), StandardCharsets.UTF_8, type,
                    // 自动关闭流
                    Feature.AutoCloseSource,
                    // 允许注释
                    Feature.AllowComment,
                    // 允许单引号
                    Feature.AllowSingleQuotes,
                    // 使用 Big decimal
                    Feature.UseBigDecimal);
        } else {
            throw new IOException();
        }
    }

}
