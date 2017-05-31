package testesautomatizados;

public class TestesAutomatizados {
    // versão com erro
//    public static boolean contem(String palavra, char letra) {
//        boolean ret = false;
//        for(char ch : palavra.toCharArray()) {
//            if (ch == letra) {
//                ret = true;
//            } else {
//                ret = false;
//            }
//        }
//        return ret;
//    }

    public static boolean contem(String palavra, char letra) {
        if (palavra == null) return false;
        for(char ch : palavra.toCharArray()) {
            if (ch == letra) { return true; }
        }
        return false;
    }
}
