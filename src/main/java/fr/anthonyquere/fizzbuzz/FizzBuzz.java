package fr.anthonyquere.fizzbuzz;

import java.util.List;
import java.util.ArrayList;

public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println(startFizzBuzz(0));
    }

    public static List<String> startFizzBuzz(int count) {
        List<String> ma_liste = new ArrayList<>();
        for( int i = 1 ; i <= count ; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                ma_liste.add("FizzBuzz");
            }
            else if(i % 3 == 0) {
                ma_liste.add("Fizz");
            }
            else if(i % 5 == 0) {
                ma_liste.add("Buzz");
            }
            else {
                ma_liste.add( String.valueOf(i) );
            }
        }
        return ma_liste;
    }
}
