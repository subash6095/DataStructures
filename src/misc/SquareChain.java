package misc;

public class SquareChain {

    public static int count(int limit){
        int cnt = 0;
        for(int i = 1; i <= limit; i++){
            if(arriveAt1(i))
                cnt++;
        }
        return cnt;
    }

    public static int happyNumber(int num) {
        return arriveAt1(num) ? 1 : 0;
    }

    public static boolean arriveAt1(int num){
        while(num != 89 && num != 1){
            num = addSquares(num);
        }
        return num == 1;
    }

    public static int addSquares(int n){
        int sum = 0;
        for(Character c : ("" + n).toCharArray()){
            sum += Character.getNumericValue(c) * Character.getNumericValue(c);
        }
        return sum;
    }



    public static void main(String[] args) {

        int count = count(5);

        System.out.println("happy = " + happyNumber(1));
        System.out.println("happy = " + happyNumber(7));
        System.out.println("happy = " + happyNumber(22));
    }
}
