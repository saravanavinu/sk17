import java.util.Scanner;
class MenuDriven
{
	Scanner sc=new Scanner(System.in);
	public static void main(String[] args)
	{
		MenuDriven n=new MenuDriven();
		n.menu();
	}
	void menu()
	{
		System.out.print("Enter the size of an array :");
		int size=sc.nextInt();
		int ar[]=new int[size];
		for(int i=0;i<ar.length;i++)
		{
			System.out.print("Enter the "+(i+1)+" value :");
			ar[i]=sc.nextInt();
		}
		boolean exit=true;
		do
		{

			System.out.println("1.Insert Elements");
			System.out.println("2.Display Elements");
			System.out.println("3.Linear Search");
			System.out.println("4.Binary Search");
			System.out.println("5.Exit");
			System.out.print("Enter your option :");
			int opt=sc.nextInt();
			switch(opt)
			{
				case 1:
				{
					ar=insert(ar);
					break;
				}
				case 2:
				{
					display(ar);
					break;
				}
				case 3:
				{
					System.out.print("Enter the target value to perform Linear search :");
					int target=sc.nextInt();
					int a=linear(ar,target);
					System.out.println("Index is "+a);
					break;
				}
				case 4:
				{
					for(int i=0;i<ar.length-1;i++)
					{
						for(int j=0;j<ar.length-i-1;j++)
						{
							if(ar[j]>ar[j+1])
							{
								int temp=ar[j];
								ar[j]=ar[j+1];
								ar[j+1]=temp;
							}
						}
					}
					for(int i=0;i<ar.length;i++)
					{
						System.out.println(ar[i]+" ");
		
					}
					System.out.print("Enter the target value to perform Binary search :");
					int target1=sc.nextInt();
					int b=binary(ar,target1);
					System.out.println("Index is "+b);
					break;
				}
				case 5:
				{
					exit=false;
					break;
				}
				
			}
			
		}while(exit);
	}
	int[] insert(int arr[])
	{
		System.out.print("Enter the place the value wants to be added :");
		int position=sc.nextInt();
		System.out.print("Enter the value wants to be added :");
		int value=sc.nextInt();
		int ar[]=new int[arr.length+1];
		for(int i=0;i<position-1;i++)
		{
			ar[i]=arr[i];
		}
		ar[position-1]=value;
		for(int i=position;i<ar.length;i++)
		{
			ar[i]=arr[i-1];
		}
		return ar;
	}
	void display(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]+" ");
		
		}
	}
	int linear(int arr[],int target)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==target)
			{
				return i;
			}
		}
		return -1;
	}
	int binary(int arr[],int target1)
	{
		int left=0;
		int right=arr.length-1;
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(arr[mid]==target1)
			{
				return mid;
			}
			else if(arr[mid]<target1)
			{
				left=mid+1;
			}
			else
			{
				right=mid-1;
			}
		}
		return -1;
	}
}