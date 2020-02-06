package com.company;
import java.util.Scanner;

public class Calculator {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {


        String num1 = get_num();

        String character = get_character();

        String num2 = get_num();

        String res = calculate(num1,num2,character);

        System.out.println(res);
    }

    static String get_num(){
        String num = in.next();
        if(is_Corect(num)) return num;
        else error();
        return null;
    }

     static String get_character(){
        String character = in.next();
        if(character.equals("+")) return "+";
        else if(character.equals("-")) return "-";
        else if(character.equals("*")) return "*";
        else if(character.equals("/")) return "/";
        else error();
        return null;
    }

    static boolean is_Arabic(String num){
        if(num.equals("1")) return true;
        else if(num.equals("2")) return true;
        else if(num.equals("3")) return true;
        else if(num.equals("4")) return true;
        else if(num.equals("5")) return true;
        else if(num.equals("6")) return true;
        else if(num.equals("7")) return true;
        else if(num.equals("8")) return true;
        else if(num.equals("9")) return true;
        else return num.equals("10");

    }
    static boolean is_Roman(String num){
        if(num.equals("I")) return true;
        else if(num.equals("II")) return true;
        else if(num.equals("III")) return true;
        else if(num.equals("IV")) return true;
        else if(num.equals("V")) return true;
        else if(num.equals("VI")) return true;
        else if(num.equals("VII")) return true;
        else if(num.equals("VIII")) return true;
        else if(num.equals("IX")) return true;
        else return num.equals("X");
    }

    static boolean is_Corect(String num){
        return is_Arabic(num) || is_Roman(num);
    }

    static String to_Arabic(String num){
        if(num.equals("I")) return "1";
        else if(num.equals("II")) return "2";
        else if(num.equals("III")) return "3";
        else if(num.equals("IV")) return "4";
        else if(num.equals("V")) return "5";
        else if(num.equals("VI")) return "6";
        else if(num.equals("VII")) return "7";
        else if(num.equals("VIII")) return "8";
        else if(num.equals("IX")) return "9";
        else return "10";
    }
    static String to_Roman(String num){
        int n = Integer.parseInt(num);
        String new_num = "";
        if(n>0) {
            do {
                if (n >= 100) {
                    n -= 100;
                    new_num += "C";
                }
                else if (n >= 90) {
                    n -= 90;
                    new_num += "XC";
                }
                else if (n >= 50) {
                    n -= 50;
                    new_num += "L";
                }
                else if (n >= 10) {
                    n -= 10;
                    new_num += "X";
                }
                else if (n >= 9) {
                    n -= 9;
                    new_num += "IX";
                }
                else if (n >= 5) {
                    n -= 5;
                    new_num += "V";
                }
                else {
                    n -= 1;
                    new_num += "I";
                }
            }
            while (n > 0) ;
        }
        else new_num = "0";
        return new_num;
    }


    static String calculate(String num1,String num2, String character){
        if(is_Arabic(num1) && is_Arabic(num2)){

            int res = Integer.parseInt(num1);

            if(character.equals("+")) res += Integer.parseInt(num2);
            else if(character.equals("-")) res -= Integer.parseInt(num2);
            else if(character.equals("*")) res *= Integer.parseInt(num2);
            else  res /= Integer.parseInt(num2);

            return "" + res;
        }

        else if(is_Roman(num1) && is_Roman(num2)){

            num1 = to_Arabic(num1);
            num2 = to_Arabic(num2);

            int res = Integer.parseInt(num1);

            if(character.equals("+")) res += Integer.parseInt(num2);
            else if(character.equals("-")) res -= Integer.parseInt(num2);
            else if(character.equals("*")) res *= Integer.parseInt(num2);
            else  res /= Integer.parseInt(num2);

            return to_Roman("" + res);
        }
        else error();
        return null;
    }

    public static void error(){
        System.out.println("ОШИБКА ВВОДА");
        System.exit(0);
    }
}
