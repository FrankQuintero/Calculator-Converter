package CalculatorTransformation;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;
//Name: Frank Quintero Pacheco
//This Program is a Converter from Decimal to Binary and Binary to Decimal.
public class DecimalBinaryConversion{

    //This static method will convert Decimal to Binary
    //@param num is the decimal number you'd like to convert in Binary
    public static void DecimalToBinary(long num){
        
        //converts the long to String
        String strNum = Long.toString(num);
        
        //gets the length of the number
        int lengthOfNum = strNum.length();
        
        //an array to collect all the remainders that make up
        //the binary code when divide by 2
        ArrayList<Long> remainder = new ArrayList<>();
        
        //this will collect each remainder
        long leftOver = 0;
        while (num > 0){
            //this will check what the remainder is when divided by 2
            leftOver = num%2;

            //this will add the remainder to the ArrayList;
            remainder.add(leftOver);

            //print what the number divided by 2
            System.out.print(num + " / 2 = ");

            //divides the number by two each iteration
            num = num/2;

            //continues off where the first print statement leftoff
            System.out.println(num + " remainder " + leftOver );


        }

        Collections.reverse(remainder);

        //this is to check that the first val is not "0"
        int start = 0;
        for (int i = 0; i < remainder.size(); i++){
            if (remainder.get(i) == 1){
                start = i;
                break;
            }
        }

        System.out.print("The Answer: ");
        for (int i = start; i < remainder.size(); i++){
            System.out.print(remainder.get(i));
        }
    }

    //method will convert Binary number to Decimal
    //@param num is the number to be converted
    public static void BinaryToDecimal(long num){
        
        //converts int to String
        String strNum = Long.toString(num);

        

        //length of the number
        int lengthOfNum = strNum.length();


        //checks to remove any extra 0's in front of the input
        for (int i = 0; i < lengthOfNum; i++){
            char location = strNum.charAt(i);
            if (Character.getNumericValue(location) == 1){
                break;
            }

            strNum = strNum.substring(i+1);
            lengthOfNum--;
        }
        
        int sum = 0;
        int power = 0;

        System.out.println("Work: ");
        
        for (int i = lengthOfNum -1; i >= 0; i--){
            
            char location = strNum.charAt(i);

            //converts char to int Value
            int bitValue = Character.getNumericValue(location);
            
            
            int increment = (int) Math.pow(2,power);
            
            
            sum += bitValue * increment;

            System.out.println(bitValue + " * " + increment + " = " + sum);

            power++;
        }

        System.out.println();
        System.out.println("The Answer: " + sum);
    }

    public static void main(String[] args){
        DecimalToBinary(10);
        BinaryToDecimal(1010);
    }
}