import java.io.*;
import java.security.*;
import java.util.*;


public class BinarySearch {
	

	

	public static void main(String[] args) {
		
		try
		{
			//����һ������Ĵ�С������һ���������
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader buffer  = new BufferedReader(isr);
			System.out.println("������һ������0������");
			String n_String = buffer.readLine();
			//��������ΪС��
			double n_double = Double.parseDouble(n_String);
			//С��ǿ��ת��Ϊ����
			int n = (int)n_double;
			//��̬�����ʼ��
			ArrayList<Integer> array_x  = new ArrayList<Integer>();
			//�������ʼ��
			SecureRandom secure_random = new SecureRandom();
			for(int i=0; i<n; i++){
				//�������ֵ
				array_x.add(i, secure_random.nextInt(10000));
				//��ͬһ�д�ӡ����
				System.out.print(array_x.get(i)+", ");
			}
			System.out.println();
			
			//ð������
			BubbleSort(array_x);
			//��ͬһ�д�ӡ������
			for(int i=0; i<n; i++){
				System.out.print(array_x.get(i)+", ");
			}
			System.out.println();
			
			//����Ҫ���ҵ���
			InputStreamReader isr_search = new InputStreamReader(System.in);
			BufferedReader buffer_search  = new BufferedReader(isr_search);
			System.out.println("������һ��Ҫ���ҵ�����");
			String n_search_String = buffer_search.readLine();
			
			double n_search = Double.parseDouble(n_search_String);
			int number_search = (int)n_search;
			//��ʾҪ��ѯ����
			System.out.println("��Ҫ���ҵ�����"+number_search);
			//���ֲ���
			
			
			WrapDistance wrapDis = new WrapDistance(Integer.MAX_VALUE, Integer.MAX_VALUE);
			wrapDis.distance = Integer.MAX_VALUE;
			wrapDis.closest = Integer.MAX_VALUE;
			
			int index = BSearch(array_x, 0, array_x.size()-1, number_search,wrapDis);
			
			
			
			
			int temp_min = Integer.MAX_VALUE;
			
			if(index<0){
				
				System.out.println("������û��Ҫ��ѯ����");
				
//				for(int k =0; k<array_x.size(); k++){
//					if(Math.abs(array_x.get(k)-number_search) <  temp_min){
//						index= k;
//						temp_min =Math.abs(array_x.get(k)-number_search);
//					}
//				}
//				
//				System.out.println("������Ҫ���ҵ����������" + array_x.get(index));
				System.out.println("the closest number is: " + wrapDis.closest);
				
			}else{
				
				System.out.println("��Ҫ���ҵ�����" + array_x.get(index));
				
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
	// changed "the_number" to "key" 
	public static int BSearch(ArrayList<Integer> array_list, int left, int right, int key, WrapDistance wrapDis){
	
		
		if(right<left){
				return -1;			
		}
		
		int middle = (int)(left+right)/2;
		int midValue = array_list.get(middle);// define a local variable here so that we won't call array_list.get() so many times
		                                      // and it is readable
		if(midValue==key){
			return middle;
		}else if(midValue>key){
			if((midValue-key) < wrapDis.distance)
			{
				wrapDis.distance = midValue-key;
				wrapDis.closest = midValue;
			}
			return BSearch(array_list, left,middle-1,key, wrapDis);
		}else{
			if((key - midValue) < wrapDis.distance)
			{
				wrapDis.distance = key - midValue;
				wrapDis.closest =  midValue;
			}
			return BSearch(array_list, middle+1,right,key,wrapDis);
		}
			
		
	}

}
