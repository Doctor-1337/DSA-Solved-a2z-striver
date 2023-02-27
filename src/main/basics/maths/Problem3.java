package main.basics.maths;

public class Problem3 {
    public static boolean revNum(int num) {
            if(num < 0)
                return false;

            int tempNum = num;
            int revNum = 0;
            while(tempNum > 0){
                revNum *= 10;
                revNum += tempNum%10;
                tempNum /= 10;
            }
        System.out.println(revNum);

            if(num == revNum)
                return true;
            return false;

        }



}
