import java.util.Random;

class randomTest {

    public static void main(String[] args) {

        String[] num = new String[5];
        Random rand1 = new Random(1);
        Random rand2 = new Random(1);

        for (int i = 0; i < num.length; i++) {
            num[i] = String.valueOf(rand1.nextInt(100));
        }

        System.out.println(java.util.Arrays.toString(num));

        for (int i = 0; i < num.length; i++) {
            num[i] = String.valueOf(rand2.nextInt(100));
        }

        System.out.println(java.util.Arrays.toString(num));

    }

}