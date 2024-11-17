package Lec_23;

import java.util.ArrayList;

public class Classroom {
//	
//	public static int storeWater(ArrayList<Integer> height) {
//		int maxWater=0;
//		//brute force-O(n^2) 
//		for(int i=0;i<height.size()-1;i++) {
//			
//			for(int j=i+1;j<height.size();j++) {
//				
//				int ht=Math.min(height.get(i), height.get(j));
//				int width=j-i;
//				int currWater=ht*width  ;
//				maxWater=Math.max(maxWater, currWater);
//			}
//		}
//		
//		return maxWater;
//	}
	
	//2 pointer approach-O(n)
	public static int storeWater(ArrayList<Integer> height) {
		int maxWater=0;
		int lp=0;
		int rp=height.size()-1;
		
		while(lp<rp) {
			//calculate water area
			int ht=Math.min(height.get(lp), height.get(rp));
			int width=rp-lp;
			int currWater=ht*width;
			maxWater=Math.max(maxWater, currWater);
			
			//update ptr
			if(height.get(lp)<height.get(rp)) {
				lp++;
			}else {
				rp--;
			}
		}
		
		return maxWater;
	}
	
	//Brute Force
//	public static boolean pairSum1(ArrayList<Integer> list,int target) {
//		
//		for(int i=0;i<list.size()-1;i++) {
//			
//			for(int j=i+1;j<list.size();j++) {
//				
//				if(list.get(i)+list.get(j)==target) {
//					
//					return true;
//				}
//			}
//		}
//		
//		return false;
//	}
	
	//2 pointer approach
//	public static boolean pairSum1(ArrayList<Integer> list,int target) {
//		
//		int lp=0;
//		int rp=list.size()-1;
//			//or lp<rp
//		while(lp!=rp) {
//			
//			if(list.get(lp)+list.get(rp)==target) {
//				
//				return true;
//				
//			}else if(list.get(lp)+list.get(rp)<target) {
//				
//				lp++;
//				
//			}else {
//				
//				rp--;
//				
//			}
//		}
//		
//		return false;
//	}

	//2 pointer-Pair Sum-2
	public static boolean pairSum2(ArrayList<Integer> list,int target) {
		int bp=-1;
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i)>list.get(i+1)) {  //breaking point
				bp=i;
				break;
			}
		}
		
		int lp=bp+1; //smallest
		int rp=bp;	//largest
		int n=list.size();
		
		while(lp!=rp) {
			//case1
			if(list.get(lp)+list.get(rp)==target) {
				
				return true;
			//case2
			}
			
			if(list.get(lp)+list.get(rp)<target) {
				
				lp=(lp+1)%n;
			//case3 
			}else {
				
				rp=(n+rp-1)%n;
				
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		
//		ArrayList<Integer> height=new ArrayList<>();
//		//1,8,6,2,5,4,8,3,7
//		height.add(1);
//		height.add(8);
//		height.add(6);
//		height.add(2);
//		height.add(5);
//		height.add(4);
//		height.add(8);
//		height.add(3);
//		height.add(7);
//		
//		System.out.println(storeWater(height));
		
//		ArrayList<Integer> list=new ArrayList<>();
//		//1,2,3,4,5,6
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		list.add(6);
//		int target=5;
//		
//		System.out.println(pairSum1(list,target));
		
		ArrayList<Integer> list=new ArrayList<>();
		//11,15,6,8,9,10-Sorted & Rotated
		list.add(11);
		list.add(15);
		list.add(6);
		list.add(8);
		list.add(9);
		list.add(10);
		int target=100;
		
		System.out.println(pairSum2(list,target));
		
	}
}
