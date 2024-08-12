package com.koubs.json.fastjson.jsonarray;

import com.koubs.json.fastjson.entity.TextInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author KouBeisi
 * @since 2021/6/5
 */
@Slf4j
class JSONArrayTest {

    String s = "[{\"name\":\"java3y\",\"label\":\"3y\",\"value\":{\"value\":\"{$tureName}\",\"color\":\"\",\"emphasis\":\"\"}},{\"name\":\"java4y\",\"label\":\"3y\",\"value\":{\"value\":\"{$title}\",\"color\":\"\",\"emphasis\":\"\"}},{\"name\":\"java5y\",\"label\":\"5y\",\"value\":{\"value\":\"关注我的公众号，更多干货\",\"color\":\"#ff0040\",\"emphasis\":\"\"}}]";

    @Test
    void test(){
        final JSONArray jsonArray = JSON.parseArray(s);
        log.info(jsonArray.toJSONString());

        final List<TextInfo> textInfos = JSON.parseArray(s, TextInfo.class);
        log.info(textInfos.toString());
    }

}
