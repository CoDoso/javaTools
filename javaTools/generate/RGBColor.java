package javaTools.generate;

import java.awt.Color;
import java.util.Random;

public class RGBColor
{
	/** <b><u>+ Generate a random RGB Color +</u></b><br>
	 */
	public static Color get_random()
	{
		Random rand = new Random();
		return new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}

}
