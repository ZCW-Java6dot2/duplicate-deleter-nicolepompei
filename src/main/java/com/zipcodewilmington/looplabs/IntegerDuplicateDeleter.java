package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }



    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] arrayWithLessThanMaxDuplicates = new Integer[0];

        for (int i = 0; i < this.array.length; i++) {
            if(getNumberOfOccurences(this.array, this.array[i]) < maxNumberOfDuplications){
                int currentIndex = arrayWithLessThanMaxDuplicates.length;
                arrayWithLessThanMaxDuplicates = Arrays.copyOf(arrayWithLessThanMaxDuplicates, currentIndex+1);
                arrayWithLessThanMaxDuplicates[currentIndex] = this.array[i];
            }
        }
        return arrayWithLessThanMaxDuplicates;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] arrayWithoutExactNumOfDuplicates = new Integer[0];

        for (int i = 0; i < this.array.length; i++) {
            if(getNumberOfOccurences(this.array, this.array[i]) != exactNumberOfDuplications){
                int currentIndex = arrayWithoutExactNumOfDuplicates.length;
                arrayWithoutExactNumOfDuplicates = Arrays.copyOf(arrayWithoutExactNumOfDuplicates, currentIndex + 1);
                arrayWithoutExactNumOfDuplicates[currentIndex] = this.array[i];
            }
        }
        return arrayWithoutExactNumOfDuplicates;
    }



    private int getNumberOfOccurences(Integer[]inputArray, int valueToCheck){
        int numberOfValueOccurrences = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if(inputArray[i].equals(valueToCheck)){
                numberOfValueOccurrences++;
            }

        }
        return numberOfValueOccurrences;
    }
}

