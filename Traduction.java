
public class Traduction {
    public static String[] returnTraduction(String reg1, String reg2, String reg3){
        InstAndRegister register = new InstAndRegister(); // take all the registers from register.java
        String traduction[] = new String[3];

        if (reg1 == null){
            traduction[0] = "00000";
        } else if (register.getRegisterCode(reg1) != null){ //true
            traduction[0] = register.getRegisterCode(reg1);
        } 
        if (reg2 == null){
            traduction[1] = "00000";
        } else if (register.getRegisterCode(reg2) != null) { // true (catch the register on HashMap)
            traduction[1] = register.getRegisterCode(reg2);
        } 
        if (reg3 == null){
            traduction[2] = "00000";
        } else if (register.getRegisterCode(reg3) != null) { // true (catch the register on HashMap)
            traduction[2] = register.getRegisterCode(reg3);
        } else {
            System.out.println(reg3);
            traduction[2] = Integer.toBinaryString(Integer.parseInt(reg3)); // The third "reg" is always the immediate
        }
        return traduction;
    }

    //Completes immediates with necessary 0.
    public static String arrangeBinary(String binary, int len){
        if (binary.length() < len){
            int diff = len - binary.length();
            for (int x = 0; x < diff; x++){
                binary = "0" + binary;
            }
        } else if (binary.length() > len){
            String immediate = binary.substring(binary.length() -len);
            binary = immediate;
        }
        return binary;
    }

}
