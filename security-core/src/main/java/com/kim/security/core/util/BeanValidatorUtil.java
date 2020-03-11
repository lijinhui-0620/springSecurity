package com.kim.security.core.util;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @auther: kim
 * @create: 2019-09-24 10:08
 * @description:
 */
public class BeanValidatorUtil {
    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    public static void main(String[] args) throws Exception {
//        FileInputStream fileInputStream = new FileInputStream(new File("E:\\com/kkk/netty/jvm/classloader/Person.class"));
//        FileOutputStream outputStream = new FileOutputStream("ouput.txt");
//        FileChannel inputChannel = fileInputStream.getChannel();
//        FileChannel outputChannel = outputStream.getChannel();
//        ByteBuffer allocate = ByteBuffer.allocate(512);
//        while (true) {
//            allocate.clear();
//            int read = inputChannel.read(allocate);
//            if (read == -1) {
//                break;
//            }
//            allocate.flip();
//            outputChannel.write(allocate);
//        }
//        outputStream.close();
//        fileInputStream.close();
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        arrayBlockingQueue.add("");
        arrayBlockingQueue.offer("");

    }

    public static <T> List<String> validate(T t, Class... groups) {
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> validateResult = validator.validate(t, groups);
        if (validateResult.isEmpty()) {
            return Collections.emptyList();
        }
        List errors = new LinkedList();
        Iterator<ConstraintViolation<T>> iterator = validateResult.iterator();
        while (iterator.hasNext()) {
            ConstraintViolation<T> constraintViolation = iterator.next();
            errors.add(constraintViolation.getMessage());
        }
        return errors;
    }

    public static List<String> validateForList(Collection<?> collection) {
        Iterator i$ = collection.iterator();
        List errors;
        do {
            if (!i$.hasNext()) {
                return Collections.emptyList();
            }
            Object object = i$.next();
            errors = validate(object);
        } while (errors.isEmpty());

        return errors;
    }
}
