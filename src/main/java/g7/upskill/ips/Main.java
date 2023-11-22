package g7.upskill.ips;

public class Main {
    public static void main(String[] args) {


        String original = "'85 New Wave";
        String strFinal= original.replaceAll("'"," ");

        System.out.println(strFinal);

    }
}