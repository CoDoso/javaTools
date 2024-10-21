package javaTools.generate;

import java.util.Random;

public class Data 
{
	public static Random random = new Random();
	/** <b><u>+ Get random Data for Testing purposes!: +</u></b><br>
	 * Default of min 2 Data Array Length
	 *@param max_length (int) the Max Length the Data Array should have 
	 *@param max_value (int) the Max Value a Data Entry should have 
	 */
	public static int[] get_random(int max_length, int max_value)
	{
		// Array Length Generation
		int Data_size = 0;
		while (Data_size <= 2)
			Data_size = random.nextInt(max_length);
		
		// Value Generation
		int Data[] = new int[Data_size];
		for (int i = 0; i != Data_size;i++)
			Data[i] = random.nextInt(max_value);
		return Data;
	}
	/** <b><u>+ Get random Data for Testing purposes!: +</u></b><br>
	 *@param max_length (int) the Max Length the Data Array should have 
	 *@param max_value (int) the Max Value a Data Entry should have 
	 *@param min_length (int) the min Length the Data Array should have 
	 */
	public static int[] get_random(int max_length, int max_value, int min_length)
	{
		// Array Length Generation
		int Data_size = 0;
		while (Data_size <= min_length)
			Data_size = random.nextInt(max_length);
		
		// Value Generation
		int Data[] = new int[Data_size];
		for (int i = 0; i != Data_size;i++)
			Data[i] = random.nextInt(max_value);
		return Data;
	}
}
