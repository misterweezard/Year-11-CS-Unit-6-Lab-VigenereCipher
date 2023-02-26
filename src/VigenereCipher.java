public class VigenereCipher {
    private String key;
    private String alphabet;

    public VigenereCipher(String key){
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key = key.toLowerCase();
    }
    public String getKey(){
        return key;
    }

    public void setKey(String x){
        key = x;
    }

    public String getAlphabet(){
        return alphabet;
    }

    public String encode(String m){
        StringBuilder encodedM = new StringBuilder();
        for(int i = 0; i < m.length(); i++){
            char z = key.charAt(i % key.length());
            boolean inAlphabet = false;
            for(int j = 0; j < 52; j++) if (alphabet.charAt(j) == m.charAt(i)) inAlphabet = true;
            if(!inAlphabet){
                encodedM.append(m.charAt(i));
                continue;
            }
            int shifted = m.charAt(i) + z - 'a';
            if (shifted > 'z') {
                char newChar = (char) shifted;
                while (newChar > 'z') newChar -= 26;
                encodedM.append(newChar);
            }
            else encodedM.append((char) shifted);
        }
        return encodedM.toString();
    }

    public String decode(String message){
        StringBuilder decodedMessage = new StringBuilder();
        for(int i = 0; i < message.length(); i++){
            boolean inAlphabet = false;
            char shift = key.charAt(i % key.length());
            for(int j = 0; j < 52; j++){
                if (alphabet.charAt(j) == message.charAt(i)) inAlphabet = true;
            }
            if(!inAlphabet){
                decodedMessage.append(message.charAt(i));
                continue;
            }
            int shifted = message.charAt(i) - shift + 'a';
            if (shifted < 'a') {
                char newChar = (char) shifted;
                while (newChar < 'a') newChar += 26;
                decodedMessage.append(newChar);
            }
            else decodedMessage.append((char) shifted);
        }
        return decodedMessage.toString();
    }
}