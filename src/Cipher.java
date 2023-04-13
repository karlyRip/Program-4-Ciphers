public abstract class Cipher {
    abstract public char encrypt (char c);

    abstract public char decrypt (char c);

    public String encrypt (String s) {
        StringBuilder en = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            en.append(encrypt(s.charAt(i)));
        }

        System.out.print(en.toString());
        return en.toString();
    }
    public String decrypt (String s) {
        StringBuilder de = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            de.insert(0, decrypt(s.charAt(i)));
        }

        System.out.println(de.toString());
        return de.toString();
    }
    abstract public Cipher newCopy();
}
