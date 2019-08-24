package com.linesix.akhaten.util;

import java.util.NoSuchElementException;

public class Misc {

    /**
     * Returns the first position (int) of a value in an array
     *
     * @param inputARR The array to search through
     * @param val The value to search for
     * @throws NoSuchElementException If the value couldn't be found, it throws
     * this exception
     *
     * @return returns the the position (index) of the first instance of the given value
     * in the given array
     * */
    public static int getIndexByVal(String val, String[] inputARR) throws NoSuchElementException {
        int index = 0;
        boolean succes = false;

        for (int i = 0; i < inputARR.length; i++) {
            if (inputARR[i] == val) {
                index = i;
                succes = true;
                break;
            }
        }

        if (succes)
            return index;
        else
            throw new NoSuchElementException();

    }

}
