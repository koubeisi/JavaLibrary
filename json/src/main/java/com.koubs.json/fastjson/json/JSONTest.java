package com.koubs.json.fastjson.json;

import com.koubs.json.fastjson.entity.ContentValue;
import com.koubs.json.fastjson.entity.TextInfo;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author KouBeisi
 * @since 2021/6/5
 */
@Slf4j
public class JSONTest {

    String contentValueJson = "{\"formId\":\"{$formId}\",\"link\":\"www.java3y.com\",\"text\":[{\"name\":\"java3y\",\"label\":\"3y\",\"value\":{\"value\":\"{$tureName}\",\"color\":\"\",\"emphasis\":\"\"}},{\"name\":\"java4y\",\"label\":\"3y\",\"value\":{\"value\":\"{$title}\",\"color\":\"\",\"emphasis\":\"\"}},{\"name\":\"java5y\",\"label\":\"5y\",\"value\":{\"value\":\"关注我的公众号，更多干货\",\"color\":\"#ff0040\",\"emphasis\":\"\"}}],\"yyyImg\":\"\",\"yyyAge\":\"\",\"pagepath\":\"\"}";

    String textInfoJson = "{\"name\":\"java3y\",\"label\":\"3y\",\"value\":{\"value\":\"{$tureName}\",\"color\":\"\",\"emphasis\":\"\"}}";


    @Test
    void testTextInfo(){
        TextInfo textInfo = JSON.parseObject(textInfoJson,TextInfo.class);
        log.info(textInfo.toString());
    }

    @Test
    void testContentValue() {
        ContentValue contentValue = JSON.parseObject(contentValueJson,ContentValue.class);
        log.info(contentValue.toString());
    }
}
