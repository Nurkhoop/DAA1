package Assignment_3_1;

public class Task16 {
    public static void main(String[] args) throws Exception {
        Fox fox = new Fox();
        System.out.println(fox.getName());  // Output: Fox
    }

    public interface Animal {
        Color getColor();
        Integer getAge();
    }

    public static class Fox implements Animal {
        @Override
        public Color getColor() {
            return Color.RED;
        }

        @Override
        public Integer getAge() {
            return 1;
        }

        public String getName() {
            return "Fox";
        }
    }

    public enum Color {
        RED, BROWN, GREY;
    }
}
