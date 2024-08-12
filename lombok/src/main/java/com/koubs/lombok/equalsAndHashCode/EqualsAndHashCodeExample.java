package com.koubs.lombok.equalsAndHashCode;

import lombok.EqualsAndHashCode;
import org.example.lombok.BaseEntity;

/**
 * @author koubs
 * @date 2021/4/11
 */
@EqualsAndHashCode
class EqualsAndHashCodeExampleDefault {
    private String username;
    private String email;

}

/**
 * 生成的 hash 和 equal 只包含 username
 */
@EqualsAndHashCode(of = {"username"})
class EqualsAndHashCodeExampleClassSuperOf {

    private String username;
    private String email;

}

/**
 * 生成的 hash 和 equal 排除 email
 */
@EqualsAndHashCode(exclude = {"email"})
class EqualsAndHashCodeExampleClassSuperExclude {

    private String username;
    private String email;

}

/**
 * Call on the superclasses' implementations of {@code equals} and {@code hashCode} before calculating for the fields in this class.
 */
@EqualsAndHashCode(callSuper = true)
class EqualsAndHashCodeExampleClassSuper extends BaseEntity{

    private String email;

}
