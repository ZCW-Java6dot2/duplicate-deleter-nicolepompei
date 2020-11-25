package com.zipcodewilmington.looplabs;

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
       Integer[] clonedArray = array.clone();

        for (int i = 0; i < clonedArray.length; i++) {
            Integer currentVal = clonedArray[i];
            int numberOfOccurrences = getNumberOfOccurences(currentVal);
            boolean isToBeDeleted = numberOfOccurrences >= maxNumberOfDuplications;
            
            if(isToBeDeleted){
               clonedArray = removeElementAtIndex(clonedArray, i);
            }
        }
           return clonedArray; 
        }
        
    
        public Integer[] removeElementAtIndex(Integer[] arrayToBeCloned, int index){
            Integer[] clonedArray = arrayToBeCloned.clone();
            Integer[] leftArray =  Arrays.copyOfRange(clonedArray,0, index);
            Integer[] rightArray = Arrays.copyOfRange(clonedArray, index + 1, arrayToBeCloned.length);
            int newArrayLength = leftArray.length + rightArray.length;
//            System.arraycopy();
            Integer[] mergedArray = new Integer[newArrayLength];
            int position = 0;

            for(Integer element: leftArray){
                mergedArray[position] = element;
                position++;
            }

            for(Integer element: rightArray){
                mergedArray[position] = element;
                position++;
            }

            return mergedArray;
        
        }
        private int getNumberOfOccurences(Integer currentVal){
            int numOfOccurrences = 0;
            for (int i = 0; i < array.length; i++) {
                Integer arrayElement = array[i];
                if(arrayElement.equals(currentVal)){
                    numOfOccurrences++;
                }
            }
            return numOfOccurrences;
        }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {

       return null;
    }
}
