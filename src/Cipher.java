public abstract class Cipher {
    abstract public char encrypt (char c);

    abstract public char decrypt (char c);

    public String encrypt (String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append(encrypt(s.charAt(i)));
        }

        return sb.toString();
    }
    public String decrypt (String s) {
        for(int i = s.length()-1; i >= 0; i--){
            decrypt(s.charAt(i));
        }

        return s;
    }
    abstract public Cipher newCopy();
}
