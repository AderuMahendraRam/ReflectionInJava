package org.amr.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author : AMRS
 * @CreateDate : 10-Apr-2021 (Sat) (3:05 PM)
 * @ProjectName : ReflectionInJava
 */
public class ReflectionOperations {
    public static void main(String[] args) {
        Class<UserOperations> userOperations = UserOperations.class;

        //All Fields
        System.out.println("=================================================");
        System.out.println("All Fields : ");
        Arrays.stream(userOperations.getFields()).forEach(val -> {
            System.out.println(val.getName());
        });
        System.out.println("=================================================\n");

        //All Classes
        System.out.println("=================================================");
        System.out.println("All Classes : ");
        Arrays.stream(userOperations.getClasses()).forEach(val -> {
            System.out.println(val.getName());
        });
        System.out.println("=================================================\n");

        //All Annotations
        System.out.println("=================================================");
        System.out.println("All Annotations : ");
        Arrays.stream(userOperations.getAnnotations()).forEach(val -> {
            System.out.println(val.annotationType());
        });
        System.out.println("=================================================\n");

        //All Methods
        System.out.println("=================================================");
        System.out.println("All Methods : ");
        Arrays.stream(userOperations.getMethods()).forEach(val -> {
            System.out.println(val.getName());
        });
        System.out.println("=================================================\n");

        //All Contructors
        System.out.println("=================================================");
        System.out.println("All Contructors : ");
        Constructor<?>[] constructors = userOperations.getConstructors();
        Arrays.stream(constructors).forEach(constructor -> {
            System.out.println(constructor.getName());
        });
        System.out.println("=================================================\n");

        //Execute methods
        System.out.println("=================================================");
        System.out.println("Methods execution : ");
            try {

               Method privateMethod = UserOperations.class.getDeclaredMethod("messageBuilderWithUser", String.class,Integer.class);
                privateMethod.setAccessible(true);
                String returnValue = (String) privateMethod.invoke(userOperations.getDeclaredConstructor().newInstance(),"Reflection Method invoke test...!",10);
                System.out.println("returned Value : "+returnValue);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        System.out.println("=================================================\n");


    }
}
