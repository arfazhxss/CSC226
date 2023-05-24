// Template created by Zhuoli Xiao, on Sept. 19st, 2016.
// Only used for Lab 226, 2016 Fall. 
// All Rights Reserved. 

// modified by Rich Little on Sept. 23, 2016
// modified by Rich Little on May 12, 2017
// modified by Jonas Buro on May 7, 2023

// This java file contains a template for an in-place quickSelect implementation. 
// Your task is to complete the code, and test your solution using the testing harness in main().

import java.util.Random;
import java.util.*;

public class QuickSelect {
	// invocation
	public static int QS(int[] S, int k){
        if (S.length==1) {return S[0];}
        return quickSelect(0, S.length - 1, S, k);
	}
	
	// TODO recursive quickSelect
    private static int quickSelect(int left, int right, int[] array, int k){
		if (k < 1 || k > array.length) {
            return 999;
        }

        // Base case
        if (left == right) {
            return array[left];
        }

		int pIndex = pickRandomPivot(left, right);
        // Partition the sublist into two halves
        int pivotIndex = partition(left, right, array, pIndex);
        int sizeLeft = pivotIndex - left +1;

        // Perform comparisons and recurse in binary search / quicksort fashion
        if (sizeLeft == k) {
            return array[pivotIndex];
        } else if (sizeLeft > k) {
            return quickSelect(left, pivotIndex - 1, array, k);
        } else {
            return quickSelect(pivotIndex + 1, right, array, k - sizeLeft);
        }
    }
    // TODO partition an array around a pivot
    private static int partition(int left, int right, int[] array, int pIndex){
    	//move pivot to last index of the array
    	swap(array,pIndex,right);

    	int p=array[right];
    	int l=left;
    	int r=right-1;
  
    	while(l<=r){
    		while(l<=r && array[l]<=p) {l++;}
    		while(l<=r && array[r]>=p) {r--;}
    		if (l<r) {swap(array,l,r);}
    	}

        swap(array,l,right);
    	return l;
    }

    // random pivot generator
	private static int pickRandomPivot(int left, int right){
		int index = 0;
		Random rand = new Random();
		index = left + rand.nextInt(right - left + 1);
		return index;
	}

	// swap element at index a with element at index b, (triangle swap)
	private static void swap(int[]array, int a, int b){
 		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public static void printSort (int[] arr) {
		System.out.print(Arrays.toString(arr)+"\n");
		int[] temp = arr;
		Arrays.sort(temp);
		System.out.println("ArrSorted: "+Arrays.toString(arr));
	}

	public static void main (String[] args){
  		int[] array1 ={12,13,17,14,21,3,4,9,21,8};  		
  		//sorted array1 = {3,4,8,9,12,13,14,17,21,21}
  		
  		int[] array2 ={14,8,22,18,6,2,15,84,13,12};
  	    //sorted array2 = {2,6,8,12,13,14,15,18,22,84}
  		
  		int[] array3 ={6,8,14,18,22,2,12,13,15,84};
  	    
  		int[] array4 = {1,2};
  		
  		int[] array5 = {1,1,1,2,2,4};
  		
		System.out.print("array1: ");
		printSort(array1);
  		System.out.println("1st Smallest: 3 = " + "Your: "+QS(array1,1));
  		System.out.println("2nd Smallest: 4 = " + "Your: "+QS(array1,2));
  		System.out.println("3rd Smallest: 8 = " + "Your: "+QS(array1,3));
  		System.out.println("4th Smallest: 9 = " + "Your: "+QS(array1,4));
  		System.out.println("5th Smallest: 12 = " + "Your: "+QS(array1,5));
  		System.out.println("6th Smallest: 13 = " + "Your: "+QS(array1,6));
  		System.out.println("7th Smallest: 14 = " + "Your: "+QS(array1,7));
  		System.out.println("8th Smallest: 17 = " + "Your: "+QS(array1,8));
  		System.out.println("9th Smallest: 21 = " + "Your: "+QS(array1,9));
  		System.out.println("10th Smallest: 21 = " + "Your: "+QS(array1,10));
  		System.out.println("11th Smallest: X = " + "Your: "+QS(array1,11));
  		System.out.println("12th Smallest: X = " + "Your: "+QS(array1,12));
		System.out.print("array2: ");
		printSort(array2);
  		System.out.println("Correct answer is 15 = " + "Your answer: "+QS(array2,7));
		System.out.print("array3: ");
		printSort(array3);
  		System.out.println("Correct answer is 13 = " + "Your answer: "+QS(array3,5));
		System.out.print("array4: ");
		printSort(array4);
  		System.out.println("Correct answer is 1 = " + "Your answer: "+QS(array4,1));
		System.out.print("array5: ");
		printSort(array5);
  		System.out.println("Correct answer is 2 = " + "Your answer: "+QS(array5,5));
	}
}

