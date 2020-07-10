package javaBasic.interfaceDetails;

/**
 * @author subash
 */

public interface MyData {

    default void print(String str) {
        if (!isNull(str))
            System.out.println("MyData Print::" + str);
    }

    default boolean isNull(String str) {
        System.out.println("Interface Null Check");

        return str == null ? true : "".equals(str) ? true : false;
    }

    static void isNull() {
        System.out.println("Inside void isNull");
    }
}
