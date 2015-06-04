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
		    if ((int)passphraseChar<=126){
		    	if ((int)stuffToEncryptChar<=126){
		    		finalString += cipher.getTable()[(int)(passphraseChar)-32][(int)(stuffToEncryptChar)-32];
		    		}
		    	else if ((int)stuffToEncryptChar>126){
		    		finalString += cipher.getTable()[(int)(passphraseChar)-32][(int)(stuffToEncryptChar)-100];
		    		}
		    }
		    else if ((int)passphraseChar>126){
		    	if ((int)stuffToEncryptChar>126){
		    		finalString += cipher.getTable()[(int)(passphraseChar)-100][(int)(stuffToEncryptChar)-100];
		    		}
		    	else if ((int)stuffToEncryptChar<=126){
		    		finalString += cipher.getTable()[(int)(passphraseChar)-100][(int)(stuffToEncryptChar)-32];
		    		}
		    }
		    
		    
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
		    for (int lookingForTheChar=0;lookingForTheChar<=VigenereCipher.ARRAY_SIZE;lookingForTheChar++)
		    {
		    	if ((int) passphraseChar<=126)
			    	if (cipher.getTable()[(int)(passphraseChar)-31][lookingForTheChar]==stuffToDecryptChar)
			    		if (lookingForTheChar==0)
			    			finalString += cipher.getAllChar()[lookingForTheChar];
			    		else
			    			finalString += cipher.getAllChar()[lookingForTheChar+1];
		    	
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
		System.out.println(cipher.getAllChar());
		
		
	}
	
}



















