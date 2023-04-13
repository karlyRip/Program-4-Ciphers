public abstract class Cipher {
    abstract public void encrypt (char c);

    abstract public void decrypt (char c);

    public void encrypt (String s) {

    }
    public void decrypt (String s) {

    }
    abstract public Cipher newCopy();
}
