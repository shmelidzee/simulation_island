package com.company.island.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InfoAnimal {
    String russianName() default "";

    double weight() default 0;

    int speed() default 0;

    int maxInOnePlace() default 0;
}
