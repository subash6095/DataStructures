package misc;

public class HappyNumber {

    public static int happyNumber(int num) {
        return arriveAt1(num) ? 1 : 0;
    }


    public static int addSquares(int n){
        int sum = 0;
        for(Character c : ("" + n).toCharArray()){
            sum += Character.getNumericValue(c) * Character.getNumericValue(c);
        }
        return sum;
    }


    public static boolean arriveAt1(int num){
        while(num != 89 && num != 1){
            num = addSquares(num);
        }
        return num == 1;
    }

    public static void main(String[] args) {

        System.out.println("happy = " + happyNumber(7));
    }

}
