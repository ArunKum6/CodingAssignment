/*
	Counting pairs in the array that has difference of k.
	Used map to track the difference value and duplicate pairs.
*/

/*
	Time Complexity - O(N)
	Space Complexity - O(N)
*/
import java.util.HashMap;
import java.util.Scanner;

public class CountPairs {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int arr[] = new int[N];
		for(int i = 0;i < N;i++)
			arr[i] = s.nextInt();
		int K = s.nextInt();
		HashMap<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		int res = 0;
		for(int x : arr) {
			if(visited.get(x) == null) {
				if(map.get(x - K) != null)
					res++;
				
				if(map.get(K + x) != null)
					res++;
				map.put(x, x);
				visited.put(x,true);
			}
		}
		System.out.println(res);
		s.close();
	}
}
