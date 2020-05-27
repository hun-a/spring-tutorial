package io.huna.spring.shop;

import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.Date;

@ToString
@Component
@Lazy
public class Cashier implements BeanNameAware {

    private String fileName;

    @Setter
    private String path;

    private BufferedWriter writer;

    @PostConstruct
    public void openFile() throws IOException {
        File targetDir = new File(path);
        if (!targetDir.exists()) {
            targetDir.mkdir();
        }

        File checkoutFile = new File(path, String.format("%s.txt", fileName));
        if (!checkoutFile.exists()) {
            checkoutFile.createNewFile();
        }

        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(checkoutFile, true)));
    }

    public void checkout(ShoppingCart cart) throws IOException {
        writer.write(String.format("%s\t%s\r\n", new Date(), cart.getItems()));
        writer.flush();
    }

    @PreDestroy
    public void closeFile() throws IOException {
        writer.close();
    }

    @Override
    public void setBeanName(String name) {
        this.fileName = name;
    }
}
