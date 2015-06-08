package fr.iutvalence.java.s2.projet;

/**
 * Vigenere cipher.
 * @author Elisa
 *
 */
public class VigenereCipher {
	
	final static int ARRAY_SIZE=152;
	private final char[][] table = new char[ARRAY_SIZE+2][ARRAY_SIZE+2];
	private final char[] allChar = new char[ARRAY_SIZE+2];
	private int filling=0;
	
	/**
	 * Vigenere cipher's constructor
	 */
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
			this.filling=column;
			for (int line=0;line<=ARRAY_SIZE;line++)
			{	
				this.table[column][line]=this.allChar[this.filling];
				if (this.filling>ARRAY_SIZE)
					this.filling=0;
				this.filling++;
			}
		}
	}

	/**
	 * A method to get all the character.
	 * @return all the character
	 */
	public char[] getAllChar() {
		return this.allChar;
	}

	/**
	 * A method to get the table.
	 * @return the table
	 */
	public char[][] getTable() {
		return this.table;
	}

	@Override
	public String toString() {
		String toReturn="";
		for (int i=0;i<=ARRAY_SIZE;i++)
			toReturn+=this.allChar[i];
		
		toReturn+="\n\n\n";
		for(int column=0;column<=ARRAY_SIZE;column++)
		{
			for (int line=0;line<=ARRAY_SIZE;line++)
			{	
				toReturn+= this.table[column][line];			
			}
			toReturn+="\n";
		}
		
		
		return toReturn;
	}


	
	
	

}
