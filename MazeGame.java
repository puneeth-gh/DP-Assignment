import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CreateMaze {
	public static void main(String []args) throws IOException
	{
		
		FileInputStream fstream = new FileInputStream("CreateMaze.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine=" ";
		int room=1;
		int direction=0;
		int[] ParameterArray=parameters();
		int [][]a=new int[ParameterArray[0]][ParameterArray[1]];
		while ((strLine = br.readLine()) != null)   
		{
		    String[] ar=strLine.split("\\s+");
			int[] array = new int[ar.length];			
			for(int t = 0;t < ar.length;t++)
			{
			   array[t] = Integer.parseInt(ar[t]);
			}
		
			room=array[0];
			
			for(int q=1;q<ar.length;q++)
			{
				
				if(array[q]>0)
				{
					a[room][direction]=array[q];
				}
				direction++;
			}
			direction=0;
			room++;
		}
		br.close();
		TraverseMaze(a);
	}
	public static void TraverseMaze(int [][]a) throws IOException
	{
		FileInputStream fstream = new FileInputStream("TraverseMaze.txt");
		@SuppressWarnings("resource")
		BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream));
		File fout = new File("DestinationMaze.txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	 
		String strLine;
		int i=0;
		while ((strLine = br1.readLine()) != null)   {
				String[] ar=strLine.split("\\s+");
				int[] array = new int[ar.length];
				for(int t = 0;t < ar.length;t++)
				{
				   array[t] = Integer.parseInt(ar[t]);
				}
				i=array[0];
				for(int t=1;t<ar.length;t++)
				{
					if(a[i][array[t]]>0)
					{
						i=a[i][array[t]];
					}
				}
				bw.write(new Integer(i).toString());
				bw.newLine();
		}
		bw.close();		
	}
	public static int[] parameters() throws IOException
	{
		FileInputStream fstream2 = new FileInputStream("CreateMaze.txt");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));
		String line=" ";
		int[] arr=new int[2];
		int countColoumn=1;
		int countRow=0;
		while((line=br2.readLine())!=null)
		{
			countColoumn++;
			String[] ar1=line.split("\\s+");
			countRow=ar1.length-1;
		}
	arr[0]=countColoumn;
	arr[1]=countRow;
	return arr;
	
	}
}
	
