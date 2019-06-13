package me.thedarksid3r.tsalg.fileeditor.utils;

import java.util.Random;

public class RandGen 
{	
	private String[] chars = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","q","r","s","t","u","v","w","x","y","z"};
	
	/**
	 * Generates a random number in the range of minNum to (maxNum - 1)
	 * 
	 * @param maxNum - highest Number that can be generated
	 * @param minNum - smallest number
	 * @return	Generated Number (1 to maxNum)
	 */
	public int genRandNumber(int maxNum, int minNum)
	{
		Random r = new Random();
		
		int range = maxNum - minNum;
		int bound = range + 1;
		
		int v = r.nextInt(bound) + minNum;
		return v;
	}
	
	/**
	 * Generates a random number in the range of 0 to (maxNum - 1)
	 * 
	 * @param maxNum - highest Number that can be generated
	 * @return	Generated Number (1 to maxNum)
	 */
	public int genRandNumber(int maxNum)
	{
		return genRandNumber(maxNum, 0);
	}
	
	public String genRandString()
	{
		//Output o = new Output();
		StringBuilder sb = new StringBuilder();
		
		int stringLength = genRandNumber(100, 1);
		
		for (int i = 0; i < stringLength; i++)
		{
			int k = genRandNumber(chars.length - 1, 0);
			
			int shouldBeCap = genRandNumber(2, 1);
			
			String letter = chars[k];
			
			if (shouldBeCap == 2)
			{
				letter = letter.toUpperCase();
			}
			
			sb.append(letter);
		}
		
		return sb.toString();
	}
}
