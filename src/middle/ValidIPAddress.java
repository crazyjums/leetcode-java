package middle;

import utils.MyPrintFunction;

public class ValidIPAddress {
    public String validIPAddress(String IP) {
        int len = IP.length();

        if (len <= 19) { //ipv4
            String [] sp = IP.split("\\.");
            MyPrintFunction.print(sp);
            for (String each : sp) {
                if (each.length() > 3)
                    return "Neither";
                if (each.compareTo("001") < 0 && each.compareTo("255") > 0)
                    return "Neither";
            }
            return "IPV4";
        } else {
            String [] sp = IP.split(":");
            return "IPV6";
        }
    }

    public static void main(String[] args) {
        String ip = "1e1.165.1.116";
        ValidIPAddress validIPAddress = new ValidIPAddress();
        System.out.println(validIPAddress.validIPAddress(ip));
    }
}
