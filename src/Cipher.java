public abstract class Cipher {
    abstract public void encrypt (char c);

    abstract public void decrypt (char c);

    public void encrypt (String s) {
        for(int i = 0; i < s.length(); i++){
            encrypt(s.charAt(i));
        }
    }
    public void decrypt (String s) {
        for(int i = s.length()-1; i >= 0; i--){
            encrypt(s.charAt(i));
        }
    }
    abstract public Cipher newCopy();
}
