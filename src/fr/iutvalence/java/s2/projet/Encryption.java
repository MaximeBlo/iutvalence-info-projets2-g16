package fr.iutvalence.java.s2.projet;

public class Encryption {
	
	private final VigenereCipher cipher;
	
	public Encryption()
	{
		this.cipher= new VigenereCipher();
	}
	
	public String encrypt(String stuffToEncrypt, String passphrase)
	{
		int passphraseIndex=0;
		char stuffToEncryptChar;
		char passphraseChar;
		String finalString ="";
		
		for (int stuffToEncryptIndex = 0 ; stuffToEncryptIndex < stuffToEncrypt.length() ;stuffToEncryptIndex++)
		{
			stuffToEncryptChar=stuffToEncrypt.charAt(stuffToEncryptIndex);
			if (stuffToEncryptIndex>=passphrase.length())
				passphraseIndex=0;
		    passphraseChar=passphrase.charAt(passphraseIndex);
		    finalString += cipher.getTable()[(int)(passphraseChar)-32][(int)(stuffToEncryptChar)-32];
		    passphraseIndex++;
		}
		 
		return finalString;
	}
	
	public String decrypt(String stuffToDecrypt, String passphrase)
{
		int passphraseIndex=0;
		char stuffToDecryptChar;
		char passphraseChar;
		String finalString ="";
		
		for (int stuffToEncryptIndex = 0 ; stuffToEncryptIndex < stuffToDecrypt.length() ;stuffToEncryptIndex++)
		{
			stuffToDecryptChar=stuffToDecrypt.charAt(stuffToEncryptIndex);
			if (stuffToEncryptIndex>=passphrase.length())
				passphraseIndex=0;
		    passphraseChar=passphrase.charAt(passphraseIndex);
		    for (int lookingForTheChar=0;lookingForTheChar<95;lookingForTheChar++)
		    {
		    	
		    	if (cipher.getTable()[(int)(passphraseChar)-31][lookingForTheChar]==stuffToDecryptChar)
		    	{
		    		System.out.println(lookingForTheChar);
		    		
		    		finalString += cipher.getAllChar()[lookingForTheChar+1];
		    		
		    	}
		    }
		    passphraseIndex++;
		}
		 
		return finalString;
	}
	

	public void Test(String stuffToEncrypt, String passphrase)
	{
		System.out.println(stuffToEncrypt);
		System.out.println();
		String bla = encrypt(stuffToEncrypt, passphrase);
		System.out.println(bla);
		System.out.println();
		System.out.println(decrypt(bla, passphrase));
		System.out.println();
		
	}
	
}



















