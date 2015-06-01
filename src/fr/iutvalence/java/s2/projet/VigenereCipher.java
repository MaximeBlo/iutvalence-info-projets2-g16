package fr.iutvalence.java.s2.projet;

public class VigenereCipher {
	
	private final char[][] table = new char[100][100];
	private final char[] allChar = new char[100];
	private int filling=0;
	
	public VigenereCipher()
	{
		
		for(int fillingAllChar=0;fillingAllChar<=94;fillingAllChar++)
		{
			this.allChar[fillingAllChar]=ASCII.toChar(fillingAllChar+32);
		}
		
		
		for(int column=0;column<=94;column++)
		{
			filling=column;
			for (int line=0;line<=94;line++)
			{	
				this.table[column][line]=allChar[filling];
				if (filling>94)
					filling=0;
				filling++;
			}
		}
	}

	public char[] getAllChar() {
		return allChar;
	}

	public char[][] getTable() {
		return table;
	}

	@Override
	public String toString() {
		String toReturn="";
		for (int i=0;i<=94;i++)
			toReturn+=allChar[i];
		
		toReturn+="\n\n\n";
		for(int column=0;column<=94;column++)
		{
			for (int line=0;line<=94;line++)
			{	
				toReturn+= table[column][line];			
			}
			toReturn+="\n";
		}
		
		
		return toReturn;
	}


	
	
	

}
