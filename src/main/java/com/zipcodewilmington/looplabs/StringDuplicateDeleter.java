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
        String [] arrayWithLessThanMaxDuplicates = new String[0];
        Integer nextUniqueStringValue = 0;

        for (int i = 0; i < array.length; i+=nextUniqueStringValue) {
            Integer stringCounter = 1;
            for (int j = i + 1; j < array.length ; j++) {
                if(array[i].equals(array[j])){
                    stringCounter++;
                    nextUniqueStringValue = stringCounter;
                }
                if(!(array[i].equals(array[j])) || j == array.length -1){
                    nextUniqueStringValue = stringCounter; //pushes i in outer loop to the next position
                    if(stringCounter < maxNumberOfDuplications){
                        for (int k = i; k < i + stringCounter; k++){
                            arrayWithLessThanMaxDuplicates = addToArray(arrayWithLessThanMaxDuplicates, array[k]);
                        }
                        break;
                    }
                    break;
                }

            }

        }

        return arrayWithLessThanMaxDuplicates;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] arrayWithLessThanExactNumOfDuplicates = new String[0];
        Integer nextUniqueStringValue = 0;

        for (int i = 0; i < array.length; i+=nextUniqueStringValue) {
            Integer stringCounter = 1;

            for (int j = i + 1; j < array.length; j++) {
                if(array[i].equals(array[j])){
                    stringCounter++;
                    nextUniqueStringValue = stringCounter;
                }
                if(!(array[i].equals(array[j])) || j == array.length - 1){
                    nextUniqueStringValue = stringCounter; //pushes the i outer loop to the next position
                    if(stringCounter != exactNumberOfDuplications){
                        for (int k = i; k < i + stringCounter ; k++) {
                            arrayWithLessThanExactNumOfDuplicates = addToArray(arrayWithLessThanExactNumOfDuplicates, array[k]);
                        }
                        break;
                    }
                    break;
                }
            }
        }
        return arrayWithLessThanExactNumOfDuplicates;
    }


    public String[] addToArray(String[] arrayToAdd, String stringToAdd){
        String[] arrayToBeAddedTo = new String[arrayToAdd.length + 1];
        System.arraycopy(arrayToAdd, 0, arrayToAdd, 0, arrayToAdd.length);
        arrayToBeAddedTo[arrayToAdd.length] = stringToAdd;
        return arrayToBeAddedTo;
    }
}
