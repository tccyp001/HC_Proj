
import java.io.*;
import java.security.*;
import java.util.*;


public class BinarySearch {
	
	public static void main(String[] args) {
		
		try
		{
			//输入一个数组的大小，产生一个随机数组
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader buffer  = new BufferedReader(isr);
			System.out.println("请输入一个大于0的整数");
			String n_String = buffer.readLine();
			//考虑输入为小数
			double n_double = Double.parseDouble(n_String);
			//小数强制转化为整数
			int n = (int)n_double;
			//动态数组初始化
			ArrayList<Integer> array_x  = new ArrayList<Integer>();
			//随机数初始化
			SecureRandom secure_random = new SecureRandom();
			for(int i=0; i<n; i++){
				//随机数赋值
				array_x.add(i, secure_random.nextInt(10000));
				//在同一行打印数组
				System.out.print(array_x.get(i)+", ");
			}
			System.out.println();
			
			//冒泡排序
			BubbleSort(array_x);
			//在同一行打印排序结果
			for(int i=0; i<n; i++){
				System.out.print(array_x.get(i)+", ");
			}
			System.out.println();
			
			//输入要查找的数
			InputStreamReader isr_search = new InputStreamReader(System.in);
			BufferedReader buffer_search  = new BufferedReader(isr_search);
			System.out.println("请输入一个要查找的整数");
			String n_search_String = buffer_search.readLine();
			
			double n_search = Double.parseDouble(n_search_String);
			int number_search = (int)n_search;
			//显示要查询的数
			System.out.println("您要查找的数是"+number_search);
			//二分查找
			int index = BSearch(array_x, 0, array_x.size()-1, number_search);
			
			int temp_min = Integer.MAX_VALUE;
			
			if(index<0){
				
				System.out.println("数组中没有要查询的数");
				
				for(int k =0; k<array_x.size(); k++){
					if(Math.abs(array_x.get(k)-number_search) <  temp_min){
						index= k;
						temp_min =Math.abs(array_x.get(k)-number_search);
					}
				}
				
				System.out.println("距离您要查找的数最近的是" + array_x.get(index));
		
				
			}else{
				
				System.out.println("您要查找的数是" + array_x.get(index));
				
			}
			
			
		}catch(Exception e){
			System.out.println("Wrong");
		}

		
		
	}
	
	public static void BubbleSort(ArrayList<Integer> array_list){
		int temp =0;
		for(int i=array_list.size() -1; i>0; i--){
			for(int j =0; j<i; j++){
				if(array_list.get(j)>array_list.get(j+1)){
					temp= array_list.get(j);
					array_list.set(j, array_list.get(j+1));
					array_list.set(j+1, temp);				
					
				}
			}
		}
	}
	
	public static int BSearch(ArrayList<Integer> array_list, int left, int right, int the_number){
	
		
		if(right<left){
				return -1;			
		}
		
		int middle = (int)(left+right)/2;
		
		if(array_list.get(middle)==the_number){
			return middle;
		}else if(array_list.get(middle)>the_number){
			return BSearch(array_list, left,middle-1,the_number);
		}else{
			return BSearch(array_list, middle+1,right,the_number);
		}
			
		
	}

}
