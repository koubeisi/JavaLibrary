package com.koubs.lombok.data;

import lombok.Data;

import java.io.Serializable;

/**
 * {@code @Data} is a convenient shortcut annotation that bundles the features of {@code @ToString},
 * {@code @EqualsAndHashCode, @Getter, @Setter and @RequiredArgsConstructor} together
 * @author KouBeisi
 */
@Data
public class Pet implements Serializable {

    private String name;

    private Integer age;

}
