import java.util.ArrayList;
public class CompositionCipher extends Cipher{
    private ArrayList<Cipher> ciphers;

    public CompositionCipher() {
        ciphers = new ArrayList<>();
    }

    public CompositionCipher(CompositionCipher other) {
        //TODO
        ciphers = new ArrayList<>();
        for (int i = 0; i < other.ciphers.size(); i++) {
            this.ciphers.add(i, other.ciphers.get(i));
        }
    }

    @Override
    public char encrypt (char c) {
        for (int i = 0; i < ciphers.size(); i++) {
            c = ciphers.get(i).encrypt(c);
        }
        return c;
    }

    @Override
    public char decrypt (char c) {
        for (int i = ciphers.size() - 1; i >= 0; i--) {
            c = ciphers.get(i).decrypt(c);
        }
        return c;
    }

    public void add (Cipher theCipher) {
        ciphers.add(theCipher);
    }

    @Override
    public CompositionCipher newCopy() {
        return new CompositionCipher(this);
    }
}
