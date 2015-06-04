package fr.iutvalence.java.s2.projet;

public class VigenereCipher {
	
	final static int ARRAY_SIZE=152;
	private final char[][] table = new char[ARRAY_SIZE+2][ARRAY_SIZE+2];
	private final char[] allChar = new char[ARRAY_SIZE+2];
	private int filling=0;
	
	public VigenereCipher()
	{
		
		for(int fillingAllChar=0;fillingAllChar<=ARRAY_SIZE;fillingAllChar++)
		{
			if (fillingAllChar<=94)
				this.allChar[fillingAllChar]=(char)(fillingAllChar+32);
			else
				this.allChar[fillingAllChar]=(char)(fillingAllChar+100);
		}
		
		
		
		for(int column=0;column<=ARRAY_SIZE;column++)
		{
			filling=column;
			for (int line=0;line<=ARRAY_SIZE;line++)
			{	
				this.table[column][line]=allChar[filling];
				if (filling>ARRAY_SIZE)
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
		for (int i=0;i<=ARRAY_SIZE;i++)
			toReturn+=allChar[i];
		
		toReturn+="\n\n\n";
		for(int column=0;column<=ARRAY_SIZE;column++)
		{
			for (int line=0;line<=ARRAY_SIZE;line++)
			{	
				toReturn+= table[column][line];			
			}
			toReturn+="\n";
		}
		
		
		return toReturn;
	}


	
	
	

}
