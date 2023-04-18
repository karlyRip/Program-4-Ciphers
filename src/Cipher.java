public abstract class Cipher {
    abstract public char encrypt (char c);

    abstract public char decrypt (char c);

    public String encrypt (String s) {
        StringBuilder en = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            en.append(encrypt(s.charAt(i)));
        }

        return en.toString();
    }
    public String decrypt (String s) {
        StringBuilder de = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            //de.insert(0, decrypt(s.charAt(i)));
            de.append(decrypt(s.charAt(i)));
        }

        return de.toString();
    }
    abstract public Cipher newCopy();
}
