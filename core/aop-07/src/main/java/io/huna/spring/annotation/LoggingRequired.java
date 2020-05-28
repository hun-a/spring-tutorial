package io.huna.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({ METHOD, TYPE })
@Retention(RUNTIME)
@Documented
public @interface LoggingRequired {
}
