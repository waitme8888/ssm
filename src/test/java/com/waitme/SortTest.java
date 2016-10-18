package com.waitme;

public class SortTest {
	
	public static void main(String[] args) {
		int[] o = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
		SortTest.reverse(o, 0, 4);
		SortTest.reverse(o, 5, o.length-1);
		SortTest.reverse(o, 0, o.length-1);
		for (int object : o) {
			System.out.print(object+",");
		}
		
		System.out.println("");
		o = new int[]{1,2,11,4,9,8,6,7,5,10,3,12};
		SortTest.insertSort2(o);
		for (int object : o) {
			System.out.print(object+",");
			
		}
		
		System.out.println("");
		o = new int[]{1,2,11,4,9,8,6,7,5,10,3,12};
		int d=o.length/3;
		while(d>=1) {
			shellInsertSort(o,d);
			d=d/3;
		}
		for (int object : o) {
			System.out.print(object+",");
			
		}
		
		System.out.println("");
		o = new int[]{1,2,11,4,9,8,6,7,5,10,3,12};
		selSort(o);
		for (int object : o) {
			System.out.print(object+",");
			
		}
		
		System.out.println("");
		o = new int[]{2,11,4,9,8,6,7,5,10,3,12,1};
		buildMinHeap(o, o.length);
		for (int i = o.length-1; i>0 ; i--) {
			int temp = o[0];
			o[0] = o[i];
			o[i] = temp;
			buildMinHeap(o, i);
		}
		
		for (int object : o) {
			System.out.print(object+",");
			
		}
		
		System.out.println("");
		o = new int[]{2,11,4,2,8,6,11,5,10,3,12,1};
		bubbleSort(o);
		for (int object : o) {
			System.out.print(object+",");
			
		}
		System.out.println("");
		o = new int[]{2,11,4,2,8,6,11,5,10,3,12,1};
		quicksort(o, 0, o.length-1);
		for (int object : o) {
			System.out.print(object+",");
			
		}
		System.out.println("");
		o = new int[]{2,11,4,2,8,6,11,5,10,3,12,1};
		mergePass(o);
		for (int object : o) {
			System.out.print(object+",");
			
		}
	}
	
//////////////////////////////////////////////////////////////////////////////
	
	
	public static void reverse(int[] o, int i, int j) {
		for (int k = i; k <= (i+j)/2; k++) {
			int temp = o[k];
			o[k]=o[j-(k-i)];
			o[j-(k-i)] = temp;
		}
	}
	
	public static void insertSort(int[] o) {
		for (int i = 1; i < o.length; i++) {
			int temp = o[i];
			int j;
			for (j = i-1; j>=0 && o[j]>temp; j--) {
				o[j+1] = o[j];
			}
			o[j+1] = temp;
		}
	}
	
	public static void insertSort2(int[] o) {
		for (int i = 1; i < o.length; i++) {
			int low = 0;
			int high = i- 1;
			int temp = o[i];
			while(low <= high) {
				int mid = (low + high)/2;
				if (temp>o[mid]) {
					low = mid+1;
				} else {
					high = mid-1;
				}
			}
			
			for (int j=i-1; j>=low; j--) {
				o[j+1] = o[j];
			}
			o[low] = temp;
		}
	}
	
	public static void shellInsertSort(int[] o, int d) {
		for (int i = 1; i < o.length; i+=d) {
			int temp = o[i];
			int j;
			for (j = i-d; j>=0 && o[j]>temp; j-=d) {
				o[j+d] = o[j];
			}
			o[j+d] = temp;
		}
	}
	
	public static void selSort(int[] o) {
		for (int i = 0; i < o.length; i++) {
			int min = i;
			int temp = o[i];
			for (int j = i+1; j < o.length; j++) {
				if(o[j]<temp){
					temp = o[j];
					min = j;
				}
			}
			
			o[min] = o[i];
			o[i] = temp;
		}
	}
	
	public static void buildMinHeap(int[]o, int last) {
		for (int i = (last-1)/2; i >= 0; i--) {
			int child = i * 2 + 1;
			int s = i;
			while(child<last) {
				if (child+1<last && o[child+1]>o[child]) {
					child++;
				}
				if(o[s]>o[child]) {
					break;
				} else {
					int temp = o[s];
					o[s] = o[child];
					o[child] = temp;
					s = child;
					child = s*2+1;
				}
			}
		}
	}
	
	public static void bubbleSort(int[] o) {
		for (int i = 0; i < o.length; i++) {
			boolean swap = false;
			for (int j = 0; j < o.length-1-i; j++) {
				if(o[j]>o[j+1]) {
					int temp = o[j];
					o[j] = o[j+1];
					o[j+1] = temp;
					swap = true;
				}
			}
			if (!swap) break;
		}
	}
	
	public static void quicksort(int[] o, int left, int right) {
		if (left<right){
			int low = left;
			int high = right;
			int a = o[left];
			while(left<right) {
				while(left<right && o[right]>=a) {
					right--;
				} 
				o[left] = o[right];
				while(left<right && o[left]<=a) {
					left++;
				}
				o[right] = o[left];
			}
			o[left] = a;
			quicksort(o, low, left-1);
			quicksort(o, right+1, high);
		}
	}
	
	public static void mergeSort(int[] o, int first, int mid, int last) {
		int i = first;
		int j = mid + 1;
		int[] temp = new int[last-first+1];
		int k = 0;
		
		while(i<=mid && j<=last) {
			if(o[i]<=o[j]){
				temp[k++] = o[i++];
			} else {
				temp[k++] = o[j++];
			}
		}
		while(i<=mid) {
			temp[k++] = o[i++];
		}
		while(j<=last) {
			temp[k++] = o[j++];
		}
		for (i = 0;  i< temp.length; i++) {
			o[first+i] = temp[i];
		}
	}
	
	public static void mergePass(int[] o) {
		for (int i = 1; i < o.length; i=i*2) {
			int j = 0;
			for (j = 0; j+2*i-1 < o.length; j+=i*2) {
				mergeSort(o,j, j+i-1, j+2*i-1);
			}
			if (j+i-1<o.length) {
				mergeSort(o,j, j+i-1, o.length-1);
			}
		}
	}
	
}
