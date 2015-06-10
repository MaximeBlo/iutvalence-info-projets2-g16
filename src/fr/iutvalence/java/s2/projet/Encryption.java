package fr.iutvalence.java.s2.projet;

/**
 * Encryption.
 * @author Elisa
 *
 */
public class Encryption {
	
	private final VigenereCipher cipher;
	
	/**
	 * Encryption's constructor.
	 */
	public Encryption()
	{
		this.cipher= new VigenereCipher();
	}
	
	/**
	 * Encrypt a stuff with the passphrase.
	 * @param stuffToEncrypt
	 * @param passphrase
	 * @return an encrypted stuff
	 */
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
		    		finalString += this.cipher.getTable()[(int)(passphraseChar)-32][(int)(stuffToEncryptChar)-32];
		    		}
		    	else if ((int)stuffToEncryptChar>126){
		    		finalString += this.cipher.getTable()[(int)(passphraseChar)-32][(int)(stuffToEncryptChar)-100];
		    		}
		    }
		    else if ((int)passphraseChar>126){
		    	if ((int)stuffToEncryptChar>126){
		    		finalString += this.cipher.getTable()[(int)(passphraseChar)-100][(int)(stuffToEncryptChar)-100];
		    		}
		    	else if ((int)stuffToEncryptChar<=126){
		    		finalString += this.cipher.getTable()[(int)(passphraseChar)-100][(int)(stuffToEncryptChar)-32];
		    		}
		    }
		    
		    
		    passphraseIndex++;
		}
		 
		return finalString;
	}
	
	/**
	 * A method to decrypt a stuff.
	 * @param stuffToDecrypt
	 * @param passphrase
	 * @return a decrypted stuff
	 */
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
			    	if (this.cipher.getTable()[(int)(passphraseChar)-32][lookingForTheChar]==stuffToDecryptChar)
			    			finalString += this.cipher.getAllChar()[lookingForTheChar];
		    	
		    	if ((int) passphraseChar>126)
			    	if (this.cipher.getTable()[(int)(passphraseChar)-99][lookingForTheChar]==stuffToDecryptChar)
			    			finalString += this.cipher.getAllChar()[lookingForTheChar];
		    	
		    }
		    passphraseIndex++;
		}
		return finalString;
	}
	

	/**
	 * A method to test.
	 * @param stuffToEncrypt
	 * @param passphrase
	 */
	public void Test(String stuffToEncrypt, String passphrase)
	{
		System.out.println(stuffToEncrypt);
		System.out.println();
		String bla = encrypt(stuffToEncrypt, passphrase);
		System.out.println(bla);
		System.out.println();
		System.out.println(decrypt(bla, passphrase));
		System.out.println();
		System.out.println(this.cipher.getAllChar());
		
		
	}
	
}



















