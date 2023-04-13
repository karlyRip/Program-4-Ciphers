import java.util.Objects;

public class CaesarCipher extends Cipher{
	private final static int NUM_LETTERS = 26;
	private final int shiftAmount;
	
	/**
	 * @param amt - the distance to shift letters when encrypting
	 */
	public CaesarCipher(int amt){
		shiftAmount = amt;
	}
	
	public CaesarCipher(CaesarCipher other){
		// TODO: complete this copy constructor
		this(other.shiftAmount);
	}
	
	@Override
	public char encrypt(char c) {
		if(Character.isAlphabetic(c)){
			final char base = (Character.isLowerCase(c) ? 'a' : 'A');		
			// c - base is the index in the alphabet: 'a' becomes 0, 'b' becomes 1, etc.
			return (char)(base + ((c - base + shiftAmount) % NUM_LETTERS));
		}
		else{
			return c;
		}
	}

	@Override
	public char decrypt(char c) {
		if(Character.isAlphabetic(c)){
			final char base = (Character.isLowerCase(c) ? 'a' : 'A');			
			return (char)(base + ((c - base - shiftAmount + NUM_LETTERS) % NUM_LETTERS));
		}
		else{
			return c;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CaesarCipher that = (CaesarCipher) o;
		return shiftAmount == that.shiftAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(shiftAmount);
	}

	// Returns a new object, a deep copy of the current object
	@Override
	public Cipher newCopy() {
		return new CaesarCipher(this);
	}

}
