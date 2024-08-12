package com.koubs.lombok.accessors;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author koubs
 * @date 2021/4/11
 */
@Accessors
@Getter
@Setter
class AccessorsDefaultExample {
    private Integer age;
}

/**
 * A boolean. If true, generated getter and setter don't have prefix
 */
@Accessors(fluent = true)
@Getter
@Setter
class AccessorFluentExample{
    private Integer age;
}

/**
 * A boolean. If true, generated setters return this instead of void
 */
@Accessors(chain = true)
@Getter
@Setter
class AccessorChainExample{
    private Integer age;
}

/**
 * A list of strings. If present, generated setters and setter will ignore the prefix
 */
@Accessors(prefix = {"f"})
@Getter
@Setter
class AccessorPrefixExample{
    private Integer fAge;
}

