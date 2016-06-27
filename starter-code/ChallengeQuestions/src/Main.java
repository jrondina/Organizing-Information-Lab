import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] test = new int[2];
        test[0] = 1;
        test[1] = 5;

        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);

        List<Integer> dupList = new ArrayList<>();
        dupList.add(1);
        dupList.add(2);
        dupList.add(2);
        dupList.add(2);
        dupList.add(3);
        dupList.add(3);
        dupList.add(4);
        dupList.add(5);

        for (int i = 0; i < findLargestAndSmallest(test).length; i++) {
            System.out.print(findLargestAndSmallest(test)[i]);
            System.out.print(", ");
        }
        System.out.println("");


        System.out.println(sumOfTwoLargest(testList));
        System.out.println(removeDuplicatesFromList(dupList));

        int[] array1 = {1,4,7,9,0,0,0};
        int[] array2 = {1,5,11};
        int[] bonus = {1, 1, 4, 5, 7, 9, 11};
        System.out.println(Arrays.equals(bonus, (mergeSortedArrays(array1, array2))));

    }

    /**
     * Question 1: Find the smallest and largest numbers in an array
     *
     * You are given an array of integers, with at least two values.
     * Find the smallest and largest numbers in the array, and pass them back in an array containing two values,
     * the smallest and the largest.
     *
     * @param array An array of integers with at least two values
     * @return An array of integers with two elements, the largest and smallest from the method parameter
     */
    public static int[] findLargestAndSmallest(int array[]){
        int[] answer = new int[2];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > answer[i]) {
                answer[i] = array[i];
            }
            if (array[i] < answer[i]) {
                answer[i] = array[i];
            }

        }

        return answer;
    }



    /**
     * Questions 2
     *
     * Given a List of Integers, return the sum of the two largest values.
     *
     * If the array is empty, return 0.
     * If the array has one value, return that value.
     *
     * @param intList A List of integers of any size.
     * @return Sum of the two largest values
     */
    public static int sumOfTwoLargest(List intList){
        int largest = 0;
        int secondLargest = 0;
        if (intList.size() == 0) {
            return 0;
        }

        for (int i = 0; i < intList.size(); i++) {
            if ((int)intList.get(i) > largest) {
                secondLargest = largest;
                largest = (int)intList.get(i);
            }
            else if ((int)intList.get(i) > secondLargest) {
                secondLargest = (int)intList.get(i);
            }

        }
            return (largest + secondLargest);
       
    }


    /**
     * Question3: Remove duplicates from a List
     *
     * You are given a List of Integers that might have duplicates. You must remove any duplicates from the List,
     * and return a List that doesn't contain duplicates. The order of the elements in the original List
     * does not need to be kept the same.
     *
     * You MAY use any collections types you wish, but the method must return a List.
     *
     * Example: [1,4,3,2,1] would return, in any order, [1,2,3,4]
     *
     * @param intList A List of Integers that may or may not include duplicates
     * @return A List of Integers that doesn't contain duplicates.
     */

    public static List removeDuplicatesFromList(List intList){

        for (int i = 0; i < intList.size() ; i++) {
            for (int j = 0; j < intList.size(); j++) {
                if (intList.get(i) == intList.get(j) && (i != j)) {
                    intList.remove(j);
                }

            }

        }
        return intList;

    }


    //BONUS QUESTION IS BELOW

    /**
     * BONUS:
     *
     * Given two sorted arrays of integers, return a sorted array of the two original arrays merged together.
     * All valid numbers in these arrays are greater than 0.
     *
     * array1 has enough empty space (represented by the value 0) to hold all valid values from the original two arrays
     * combined. The returned array must be array1 with the new values merged in.
     *
     * For example:
     *      array1 = [1,4,7,9,0,0,0]
     *      array2 = [1,5,11]
     *      returned array = [1,1,4,5,7,9,11]
     *
     * No test cases are provided for this method, you will need to test it on your own.
     *
     * @param array1 Array of sorted integers
     * @param array2 Array of sorted integers
     * @return Array of sorted integers, merged from array1 and array2
     */

    public static int[] mergeSortedArrays(int[] array1, int[] array2){
        List<Integer> combination = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != 0) {
                combination.add(array1[i]);
            }

        }
        for (int i = 0; i < array2.length; i++) {
            if (array1[i] != 0) {
                combination.add(array2[i]);
            }
        }
        Collections.sort(combination);

        int[] answer = new int[combination.size()];
        for (int i = 0; i < combination.size() ; i++) {
            answer[i] = combination.get(i);
        }


        return answer;
    }

}