package javaBasic.stringDetails;

public class PassByValue {
    public static void main(String[] args) {
        String str = "subash";
        foo(str);
        System.out.println("--> " + str.hashCode());
        System.out.println("Str : " + str);
    }

    public static void foo(String input) {
        //input = "java";
        input = new String("java");
        System.out.println("--> " + input.hashCode());
    }
}

