package com.koubs.json.fastjson.entity;

import lombok.Data;

import java.util.List;

/**
 * @author KouBeisi
 * @since 2021/6/5
 */
@Data
public class ContentValue {
    private String formId;
    private String link;
    /**
     * 这里是一个数组，我们就抽象为List，属性名为text
     */
    private List<TextInfo> text;
    private String yyyImg;
    private String yyyAge;
    private String pagepath;

}
