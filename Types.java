import java.util.Arrays;
import java.util.List;

public class Types {

    // Type I
    public static String returnbinaryI(String instruction, String[] word) {
        InstAndRegister txtinstruction = new InstAndRegister();
        String binary = txtinstruction.getTypeI(instruction);

        // Instructions out of pattern
        String[] nPattern = { "lui", "bltz", "bgez", "bltzal", "bgtz", "bgezal", "blez" };

        List<String> list = Arrays.asList(nPattern);

        String[] translate = new String[3];

        if (word.length == 3) {
            translate = Traduction.returnTraduction(word[1], word[2], null);
        } else if (word.length == 2) {
            translate = Traduction.returnTraduction(word[1], null, null);
        } else {
            translate = Traduction.returnTraduction(word[1], word[2], word[3]);
        }

        // Instructions out of pattern
        if (instruction.equals("lui")) {
            translate[0] = Traduction.arrangeBinary(translate[0], 5);
            translate[2] = Traduction.arrangeBinary(translate[1], 16);
            binary += "00000" + translate[0] + translate[2];
        }

        if (instruction.equals("bgtz") || instruction.equals("blez") || instruction.equals("bltz")) {
            translate[1] = Traduction.arrangeBinary(translate[1], 16);
            binary += translate[0] + "00000" + translate[1];
            return binary;
        }

        if (instruction.equals("bgez")) {
            translate[0] = Traduction.arrangeBinary(translate[0], 5);
            translate[1] = Traduction.arrangeBinary(translate[1], 16);
            binary += translate[0] + "00001" + translate[1];
            return binary;
        }

        if (instruction.equals("bgezal")) {
            translate[0] = Traduction.arrangeBinary(translate[0], 5);
            translate[1] = Traduction.arrangeBinary(translate[1], 16);
            binary += translate[0] + Traduction.arrangeBinary(Integer.toBinaryString(17), 5) + translate[1];
            return binary;
        }

        if (instruction.equals("bltzal")) {
            translate[0] = Traduction.arrangeBinary(translate[0], 5);
            translate[1] = Traduction.arrangeBinary(translate[1], 16);
            binary += translate[0] + Traduction.arrangeBinary(Integer.toBinaryString(16), 5) + translate[1];
            return binary;
        }

         //Patterns instructions
         if (!list.contains(instruction)) {
            translate[0] = Traduction.arrangeBinary(translate[0], 5);
            translate[2] = Traduction.arrangeBinary(translate[2], 16);
            binary += translate[1] + translate[0] + translate[2]; // opcode (6)rs (5) rt (5) immediate (16)
            return binary;
        }
        return binary;
    }

    // Type J
    public static String returnbinaryJ(String instruction, String word) {

        if (instruction.equals("j") || instruction.equals("J")) {
            String num = Integer.toBinaryString(Integer.parseInt(word));
            if (num.length() < 26) {
                int diff = 26 - num.length();
                for (int x = 0; x < diff; x++) {
                    num = "0" + num;
                }
            }
            return instruction + num; // opcode (6) address (26)

        } else {
            String num = Integer.toBinaryString(Integer.parseInt(word));
            if (num.length() < 26) {
                int diff = 26 - num.length();
                for (int x = 0; x < diff; x++) {
                    num = "0" + num;
                }
            }
            return instruction + num; // opcode (6) address (26)
        }
    }

    // Type R
    public static String returnbinaryR(String instruction, String[] word) {
        InstAndRegister txtinstruction = new InstAndRegister();

        String binary = txtinstruction.getTypeR(instruction);

        // Instructions out of pattern
        String[] nPattern = { "sra", "sll", "mfhi", "mthi", "mtlo", "mflo", "mult", "multu", "div", "divu", "jr",
                "jarl", "srl" };

        List<String> list = Arrays.asList(nPattern);

        String[] translate = new String[3];

        String bin = "";

        if (word.length == 3) {
            translate = Traduction.returnTraduction(word[1], word[2], null);
        } else if (word.length == 2) {
            translate = Traduction.returnTraduction(word[1], null, null);
        } else {
            translate = Traduction.returnTraduction(word[1], word[2], word[3]);
        }

        if (instruction.equals("srl") || instruction.equals("sra")) {
            translate[0] = Traduction.arrangeBinary(translate[0], 5);
            translate[1] = Traduction.arrangeBinary(translate[1], 5);
            translate[2] = Traduction.arrangeBinary(translate[2], 5);
            bin = "000000" + "00000" + translate[1] + translate[0] + translate[2] + binary;
            return bin;
        }

        if (instruction.equals("sll")) {
            translate[0] = Traduction.arrangeBinary(translate[0], 5);
            translate[1] = Traduction.arrangeBinary(translate[1], 5);
            translate[2] = Traduction.arrangeBinary(translate[2], 5);
            bin = "000000" + "00000" + translate[1] + translate[0] + translate[2] + "000000";
            return bin;
        }

        if (instruction.equals("mthi") || instruction.equals("mtlo")) {
            translate[0] = Traduction.arrangeBinary(translate[0], 5);
            translate[1] = Traduction.arrangeBinary(translate[1], 5);
            translate[2] = Traduction.arrangeBinary(translate[2], 5);
            bin = "000000" + translate[0] + "00000" + "00000" + "00000" + binary;
            return bin;
        }

        if (instruction.equals("mult") || instruction.equals("multu") || instruction.equals("div")
                || instruction.equals("divu")) {
            translate[0] = Traduction.arrangeBinary(translate[0], 5);
            translate[1] = Traduction.arrangeBinary(translate[1], 5);
            bin = "000000" + translate[1] + translate[0] + "00000" + "00000" + binary;
            return bin;
        }

        if (instruction.equals("mfhi")) {
            translate[0] = Traduction.arrangeBinary(translate[0], 5);
            translate[1] = Traduction.arrangeBinary(translate[1], 5);
            translate[2] = Traduction.arrangeBinary(translate[2], 5);
            bin = "000000" + "00000" + "00000" + translate[0] + "00000" + binary;
            return bin;
        }

        if (instruction.equals("mflo")) {
            translate[0] = Traduction.arrangeBinary(translate[0], 5);
            translate[1] = Traduction.arrangeBinary(translate[1], 5);
            translate[2] = Traduction.arrangeBinary(translate[2], 5);
            bin = "000000" + "00000" + "00000" + translate[0] + "00000" + binary;
            return bin;
        }

        if (instruction.equals("jarl")) {
            translate[1] = Traduction.arrangeBinary(translate[1], 5);
            bin = "000000" + translate[1] + "00000" + translate[0] + "00000" + binary;
        }

        if (instruction.equals("jr")) {
            translate[1] = Traduction.arrangeBinary(translate[1], 5);
            bin = "000000" + translate[1] + "00000" + "00000" + "00000" + binary;
            return bin;
        }

        // Patterns instructions
        if (!list.contains(instruction)) {
            translate[0] = Traduction.arrangeBinary(translate[0], 5);
            translate[1] = Traduction.arrangeBinary(translate[1], 5);
            translate[2] = Traduction.arrangeBinary(translate[2], 5);
            bin = "000000" + translate[1] + translate[2] + translate[0] + "00000" + binary; // opcode (6) rs (5) rt (5)
                                                                                            // rd (5) shamt (5)funct (6)
            return bin;
        }
        return bin;
    }

}
