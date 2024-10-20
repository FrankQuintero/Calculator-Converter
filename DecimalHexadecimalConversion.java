package CalculatorTransformation;
import java.util.ArrayList;
import java.util.Collections;

//Name: Frank Quintero Pacheco
//This program will Convert Decimal and Hexadecimal

public class DecimalHexadecimalConversion{
    
    private static final int HEX = 16;

    //This method will Convert String to Hexadecimal 
    //@param strNum is a String input so it can take a bigger input
    public static void DecimalToHexadecimal(String StrNum){



        int num = Integer.valueOf(StrNum);

        //stores the remainder in an array to save for later
        ArrayList<Integer> array = new ArrayList<>();
        //declaring remainder to be initialized
        int remainder = 0; 

        //just so it can look nice
        System.out.println("Work:");

        //print the work that is done and stores the remainder
        while(num > 0){

            remainder = num%HEX;

            array.add(remainder);
            
            System.out.print(num + " / " + HEX + " = ");
            num = num / HEX;
            
            System.out.print(num);
            System.out.println(" remainder " + remainder);

        }

        //reverses the array so it can read from bottom to top
        Collections.reverse(array);


        String together = "";

        //converters the remainder to Hex base
        for (int i = 0; i < array.size(); i++){
            //this will add it to the together String if it is 9 or less
            if (array.get(i) <= 9){
                together += array.get(i);
            }
            //checks if the remainder is above 10
            //if so, then it converts it to Letter bc Hex
            switch (array.get(i)){
                case 10 :
                together += "A";
                break;

                case 11 :
                together += "B";
                break;

                case 12 :
                together += "C";
                break;

                case 13 :
                together += "D";
                break;

                case 14 :
                together += "E";
                break;

                case 15 :
                together += "F";
                break;

                default :
                break;
            }

            

        }


        //prints the final result
        System.out.println();
        System.out.println("The Answer: " + together);
    }


    //This method will transform a Hexadecimal to a Decimal
    //also shows the what is happening to get that number w/ remainder
    //@param number is the Hexadecimal in String format
    public static void HexadecimalToDecimal(String number){
        int length = number.length();

        //keeps count of the power
        int power = 0;

        //keeps track of the total
        int sum = 0; 

        System.out.println("Work:");
        for (int i = length-1; i >= 0; i--){

            char location = number.charAt(i);

            String strLocation = Character.toString(location);

            

            int intLocation = 0;

            switch (strLocation) {
                case "A" :
                intLocation = 10;
                break;

                case "B" :
                intLocation = 11;
                break;

                case "C" :
                intLocation = 12;
                break;

                case "D" :
                intLocation = 13;
                break;

                case "E" :
                intLocation = 14;
                break;

                case "F" :
                intLocation = 15;
                break;

                default:
                intLocation = Character.getNumericValue(location);
                    break;
            }

            
            sum += intLocation * Math.pow(HEX, power);
            System.out.println(intLocation + " * " + (long) Math.pow(HEX, power) + " = " + sum );
            power++;
        }

        System.out.println();

        System.out.println("The Answer: " + sum);
    }

    public static void main(String[] args){
        DecimalToHexadecimal("21845");
        HexadecimalToDecimal("5555");
    }
}