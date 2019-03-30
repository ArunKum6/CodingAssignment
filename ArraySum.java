/*
    Make the array unique by adding one to the duplicate elements such that the sum of array should be minimum.
    Used Map and Binary search to detect the duplicate values and the new values to make the array unique.
    N - Represents number of elements
    A[N] - Represents the array of numbers
*/

/*
    Time Complexity  - O(NlogN)
    Space Complexity - O(N)
*/

import java.util.HashMap;
import java.util.Scanner;

public class ArraySum {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int A[] = new int[N];
		for(int i = 0;i < N;i++)
			A[i] = s.nextInt();
		System.out.println(minIncrementForUnique(A));
		s.close();
	}
	
	public static int binarySearch(HashMap<Integer,Integer> map,int l,int h){
        int mid = -1;
        // Check for the least possible value that doesn't appear in the array
        while(l < h){
            mid = (l + h) / 2;
            if(map.get(mid) == null)
                h = mid;
            else 
                break;
        }

        // If the intermediate result present in the array 
        // then do binary search in the lower half and upper half of the current segment.
        if(l < h){
            int lVal = binarySearch(map,l,mid-1);
            int rVal = binarySearch(map,mid + 1,h);
            lVal = (lVal < rVal) ? lVal : rVal;
            return lVal;
        }
        else if(map.get(l) == null)
            return l;
        
        return Integer.MAX_VALUE;
    }
	
	public static int minIncrementForUnique(int[] A) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        // Tracing the duplicate values
        for(int x : A){
            int count = (map.get(x) == null) ? 0 : map.get(x);
            count++;
            map.put(x,count);
        }
        
        int res = 0;
        
        for(int x : A){
            // Check if duplicate values exists if so then do binary search to get the value
            if(map.get(x) > 1){
                int count = map.get(x);
                int nextVal = binarySearch(map,x + 1,x + 1 + 2000);
                map.put(nextVal,1);
                map.put(x,count - 1);
                res += nextVal;
            }
            else
            	res += x;
        }
        
        return res;
    }
}