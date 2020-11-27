package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }


    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] arrayWithLessThanMaxDuplicates = new String[0];

        for (int i = 0; i < this.array.length; i++) {
            if (getNumberOfOccurences(this.array, this.array[i]) < maxNumberOfDuplications) {
                int currentIndex = arrayWithLessThanMaxDuplicates.length;
                arrayWithLessThanMaxDuplicates = Arrays.copyOf(arrayWithLessThanMaxDuplicates, currentIndex + 1);
                arrayWithLessThanMaxDuplicates[currentIndex] = this.array[i];
            }
        }
        return arrayWithLessThanMaxDuplicates;
    }


    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] arrayWithLessThanExactNumOfDuplicates = new String[0];
        for (int i = 0; i < this.array.length; i++) {
            if (getNumberOfOccurences(this.array, this.array[i]) != exactNumberOfDuplications) {
                int currentIndex = arrayWithLessThanExactNumOfDuplicates.length;
                arrayWithLessThanExactNumOfDuplicates = Arrays.copyOf(arrayWithLessThanExactNumOfDuplicates, currentIndex + 1);
                arrayWithLessThanExactNumOfDuplicates[currentIndex] = this.array[i];
            }
        }
        return arrayWithLessThanExactNumOfDuplicates;
    }


    private int getNumberOfOccurences(String[] inputArray, String valueToCheck) {
        int numberOfValueOccurrences = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals(valueToCheck)) {
                numberOfValueOccurrences++;
            }
        }
        return numberOfValueOccurrences;
    }

}
