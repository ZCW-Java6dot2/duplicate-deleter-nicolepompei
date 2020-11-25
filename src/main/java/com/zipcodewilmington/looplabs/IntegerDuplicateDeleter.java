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
        Integer[] arrayWithLessThanMaxDuplicates = new Integer[0];
        Integer nextUniqueInt = 0;

        for (int i = 0; i < array.length; i += nextUniqueInt) {
            Integer integerCounter = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    integerCounter++;
                    nextUniqueInt = integerCounter;
                }
                if (!(array[i].equals(array[j])) || j == array.length - 1) {
                    nextUniqueInt = integerCounter; // next position to jump to in outer loop
                    if (integerCounter < maxNumberOfDuplications) { //if counted ints are less than allowable, keep them
                        for (int k = i; k < i + integerCounter; k++) {
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
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] arrayWithoutExactNumOfDuplicates = new Integer[0];
        Integer nextUniqueInteger = 0;
        for (int i = 0; i < array.length; i += nextUniqueInteger) {
            Integer integerCounter = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    integerCounter++;
                    nextUniqueInteger = integerCounter;
                }
                if (!(array[i].equals(array[j])) || j == array.length - 1) {
                    nextUniqueInteger = integerCounter; //next position to jump to in outer loop
                    if (integerCounter != exactNumberOfDuplications) { //counted elements less than elements to remove, keep elements
                        for (int k = i; k < i + integerCounter; k++) {
                            arrayWithoutExactNumOfDuplicates = addToArray(arrayWithoutExactNumOfDuplicates, array[k]);
                        }
                        break;
                    }
                    break;
                }

            }
        }
        return arrayWithoutExactNumOfDuplicates;
    }


    public Integer[] addToArray(Integer[] arrayToAdd, Integer integerToAdd) {
        Integer[] arrayToBeAddedTo = new Integer[arrayToAdd.length + 1];
        System.arraycopy(arrayToAdd, 0, arrayToBeAddedTo, 0, arrayToAdd.length);
        arrayToBeAddedTo[arrayToAdd.length] = integerToAdd;
        return arrayToBeAddedTo;
    }



}




//       Integer[] clonedArray = array.clone();
//
//        for (int i = 0; i < clonedArray.length; i++) {
//            Integer currentVal = clonedArray[i];
//            int numberOfOccurrences = getNumberOfOccurences(currentVal);
//            boolean isToBeDeleted = numberOfOccurrences >= maxNumberOfDuplications;
//
//            if(isToBeDeleted){
//               clonedArray = removeElementAtIndex(clonedArray, i);
//            }
//        }
//           return clonedArray;
//        }


//        public Integer[] removeElementAtIndex(Integer[] arrayToBeCloned, int index){
//            Integer[] clonedArray = arrayToBeCloned.clone();
//            Integer[] leftArray =  Arrays.copyOfRange(clonedArray,0, index);
//            Integer[] rightArray = Arrays.copyOfRange(clonedArray, index + 1, arrayToBeCloned.length);
//            int newArrayLength = leftArray.length + rightArray.length;
////            System.arraycopy();
//            Integer[] mergedArray = new Integer[newArrayLength];
//            int position = 0;
//
//            for(Integer element: leftArray){
//                mergedArray[position] = element;
//                position++;
//            }
//
//            for(Integer element: rightArray){
//                mergedArray[position] = element;
//                position++;
//            }
//
//            return mergedArray;
//
//        }
//        private int getNumberOfOccurences(Integer currentVal){
//            int numOfOccurrences = 0;
//            for (int i = 0; i < array.length; i++) {
//                Integer arrayElement = array[i];
//                if(arrayElement.equals(currentVal)){
//                    numOfOccurrences++;
//                }
//            }
//            return numOfOccurrences;
//        }
