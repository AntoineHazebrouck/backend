package fr.but3;

public class Counter
{
	private int val = 0;

	public int intValue()
	{
		return val;
	}

	public String toString()
	{
		return "" + val;
	}

	public void incr()
	{
		val++;
	}

}
