package io.huna.spring;

import io.huna.spring.config.SequenceGeneratorConfiguration;
import io.huna.spring.sequence.SequenceGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        // Create the IoC Container
        ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);

        // Get the Bean from IoC Container
        SequenceGenerator gen1 = (SequenceGenerator) context.getBean("sequenceGenerator");
        SequenceGenerator gen2 = context.getBean("sequenceGenerator", SequenceGenerator.class);
        SequenceGenerator gen3 = context.getBean(SequenceGenerator.class);

        System.out.println(gen1.getSequence());
        System.out.println(gen2.getSequence());
        System.out.println(gen3.getSequence());
    }
}
