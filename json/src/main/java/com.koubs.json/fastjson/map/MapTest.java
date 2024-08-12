package com.koubs.json.fastjson.map;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KouBeisi
 * @since 2021/8/20
 */
public class MapTest {

    @Test
    void test(){
        final HashMap<String, String> map = new HashMap<>(8);
        map.put("wechat","123");
        map.put("qq","123");
        map.put("weibo","123");
        map.put("github","123");

        final String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);

        final Map object = JSON.parseObject(jsonString, Map.class);
        System.out.println(object.toString());
    }
}
