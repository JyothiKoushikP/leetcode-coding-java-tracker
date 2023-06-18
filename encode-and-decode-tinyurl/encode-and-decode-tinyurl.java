public class Codec {
    String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
    Random random = new Random();
    HashMap<String,String> map = new HashMap();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<7;i++){
            Character c = alphabet.charAt(random.nextInt(alphabet.length()));
            sb.append(c);
        }
        String[] url = longUrl.split("/");
        String replace = url[url.length-1];
        map.put(sb.toString(),replace);

        return longUrl.replace(replace,sb.toString());
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] url = shortUrl.split("/");
        String org = map.get(url[url.length-1]);
        return shortUrl.replace(url[url.length-1],org);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));