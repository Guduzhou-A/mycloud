package org.gdz.mycloud.common.base.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: guduzhou
 * @Description:
 * @Date: Created in 17:56 2020/5/20 0020
 * @Modified By:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AuthLogAnnotation {

    String desc() default "";

}
