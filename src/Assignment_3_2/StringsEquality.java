package Assignment_3_2;

public class StringsEquality {
    public static void main(String[] args) {
        String s1 = new String("JavaENU");
        s1 = "JavaENU";
        String s2 = "JavaENU";
// s2 = new String("JavaENU");
        String s3 = "JavaENU";
// s3 = new String("JavaENU");
        System.out.println(s1 == s3);
        System.out.println(s2.equals(s3));
    }
}
