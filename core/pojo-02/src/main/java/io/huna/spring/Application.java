package io.huna.spring;

import io.huna.spring.dao.SequenceDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        // Create the IoC Container
        ApplicationContext context = new AnnotationConfigApplicationContext("io.huna.spring");

        // Get the Bean from IoC Container
        SequenceDao sequenceDao = context.getBean(SequenceDao.class);

        System.out.println(sequenceDao.getNextValue("IT"));
        System.out.println(sequenceDao.getNextValue("IT"));
    }
}
