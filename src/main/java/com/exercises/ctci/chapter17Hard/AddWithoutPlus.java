package com.exercises.ctci.chapter17Hard;

@SuppressWarnings("unused")
public class AddWithoutPlus {

    public int add(int numberOne, int numberTwo) {
        while(numberOne != 0){
            int carry = numberTwo & numberOne;
            numberTwo = numberTwo ^ numberOne;
            numberOne = carry << 1;
        }
        return numberTwo;
    }
}
