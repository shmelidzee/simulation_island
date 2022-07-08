package com.company.island.annotations;


import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InfoPlants {
    int weight() default 1;

    String russianName() default "растения";

    int maxInOnePlace() default 200;
}
