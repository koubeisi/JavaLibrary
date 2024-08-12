package com.koubs.json.fastjson.entity;

import lombok.Data;

/**
 * @author KouBeisi
 * @since 2021/6/5
 */
@Data
public class TextInfo {

    private String name;
    private String label;

    /**
     * 因为value不需要操作，所以就不抽象了，如果每层都要处理，那就得抽象
     */
    private Object value;
}
