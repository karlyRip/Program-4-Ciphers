public abstract class Cipher {
    abstract public char encrypt (char c);

    abstract public char decrypt (char c);

    public String encrypt (String s) {
        for(int i = 0; i < s.length(); i++){
            encrypt(s.charAt(i));
        }

        return s;
    }
    public String decrypt (String s) {
        for(int i = s.length()-1; i >= 0; i--){
            encrypt(s.charAt(i));
        }

        return s;
    }
    abstract public Cipher newCopy();
}
