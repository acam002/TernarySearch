/*******************************************************
Program Number: A1_<problem #2 (ranging from 1 to 2) >
Purpose/Description: <Ternary Search>
Author: <Alberto Camacho>
Due date: <09/10/15>
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
 < Alberto Jesus Camacho >
*******************************************************/

/*
    Considering that this search breaks down the list every method call by a factor
    of 1/3, I can say that the time complexity of this method is O(log(N))
*/

package search;

public class Search {

    public static void main(String[] args) {
        // Making new array and testing the ternary search method
        int [] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 43, 200};
        int index = terSearch(arr, 0, arr.length - 1, 43);
                
         
        System.out.println(index);
        
        
        // Trying another array with odd values
        int []arr1 = new int[1000]; 
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i * 2 + 1;
        }
        index = terSearch(arr1, 0, arr1.length-1, 513);
        System.out.println(index);
    }
    
    static int terSearch(int [] arr, int l, int r, int x) {
        // System.out.println(l+ " " + r);
        
        // Base case
        if (l >= r && x != arr[l]) {
            return -1;
        }
        // Making the dividing section
        int d1 = l + (r - l) / 3;
        int d2 = d1 + (r - l) / 3;
        
        // Check the left divider for the requested value
        if (arr[d1] == x) {
            return d1;
        }     
        // If the requested value (x) is less than the left divider's value then we go
        // to the left section of the list and place the new dividers on the left side
        else if (arr[d1] > x) {
            return terSearch(arr, l, d1 - 1, x);
        }
        // Check if the right divider has the requested value (x)
        else if (arr[d2] == x) {
            return d2;
        }
        // If the requested value (x) is less than the right divider's value, then we
        // go to the left section of the right divider and place the new dividers there 
        else if (arr[d2] > x) {
            return terSearch(arr, d1 + 1, d2 - 1, x);
        }
        // If the requested value (x) is greater than the right divider's value, then
        // we go to right section of the right divider and place the new dividers there
        else {
            return terSearch(arr, d2 + 1, r, x);
        }
    }   
}
