import java.util.ArrayList;
import java.util.Objects;

public class VigenereCipher extends Cipher{
	
	private ArrayList<CaesarCipher> subCiphers;
	
	// These variables keep track of which
	//  CaesarCipher to use for the next encrypt
	//  or decrypt operation, respectively.
	private int nextIndexForEncrypt;
	private int nextIndexForDecrypt;
	
	
	public VigenereCipher(Iterable<Integer> shiftAmounts){
		nextIndexForEncrypt = 0;
		nextIndexForDecrypt = 0;
		
		subCiphers = new ArrayList<>();
		for(Integer amt : shiftAmounts){
			subCiphers.add(new CaesarCipher(amt));
		}
	}
	
	public VigenereCipher(VigenereCipher other){
		// TODO: complete this copy constructor
	}
	
	@Override
	public char encrypt(char c) {
		char res = subCiphers.get(nextIndexForEncrypt).encrypt(c);
		nextIndexForEncrypt = (nextIndexForEncrypt + 1) % subCiphers.size();
		return res;
	}

	@Override
	public char decrypt(char c) {
		char res = subCiphers.get(nextIndexForDecrypt).decrypt(c);
		nextIndexForDecrypt = (nextIndexForDecrypt + 1) % subCiphers.size();
		return res;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof VigenereCipher that)) return false;
		return nextIndexForEncrypt == that.nextIndexForEncrypt && nextIndexForDecrypt == that.nextIndexForDecrypt && Objects.equals(subCiphers, that.subCiphers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subCiphers, nextIndexForEncrypt, nextIndexForDecrypt);
	}

	// Returns a new object, a deep copy of the current object
	@Override
	public Cipher newCopy() {
		//?
		return new VigenereCipher(this);
	}

}
