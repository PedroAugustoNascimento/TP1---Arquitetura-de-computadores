import java.util.HashMap;
import java.util.Map;

public class InstAndRegister {

    // Hash-maps that contains the instruction types.
    private final Map<String, String> typeI = new HashMap<String, String>();
    private final Map<String, String> typeJ = new HashMap<String, String>();
    private final Map<String, String> typeR = new HashMap<String, String>();

    // Hash-map that contain the registers and their respectives codes.
    private Map<String, String> registers = new HashMap<String, String>();

    public InstAndRegister() {
        // Type I
        typeI.put("lb", "100000");
        typeI.put("lh", "100001");
        typeI.put("lwl", "100010");
        typeI.put("lw", "100011");
        typeI.put("lbu", "100100");
        typeI.put("lhu", "100101");
        typeI.put("lwr", "100110");
        typeI.put("sb", "101000");
        typeI.put("sh", "101001");
        typeI.put("swl", "101010");
        typeI.put("sw", "101011");
        typeI.put("swr", "101110");
        typeI.put("addi", "001000");
        typeI.put("addiu", "001001");
        typeI.put("slti", "001010");
        typeI.put("sltiu", "001011");
        typeI.put("andi", "001100");
        typeI.put("ori", "001101");
        typeI.put("xori", "001110");
        typeI.put("lui", "001111");
        typeI.put("bltz", "000001");
        typeI.put("bgez", "000001");
        typeI.put("beq", "000100");
        typeI.put("bne", "000101");
        typeI.put("blez", "000110");
        typeI.put("bgtz", "000111");
        typeI.put("bltzal", "000001");
        typeI.put("bgezal", "000001");

        // Type R
        typeR.put("add", "100000");
        typeR.put("addu", "100001");
        typeR.put("sub", "100010");
        typeR.put("subu", "100011");
        typeR.put("and", "100100");
        typeR.put("or", "100101");
        typeR.put("xor", "100110");
        typeR.put("nor", "100111");
        typeR.put("slt", "101010");
        typeR.put("sltu", "101011");
        typeR.put("sllv", "000100");
        typeR.put("srlv", "000110");
        typeR.put("srav", "000111");
        // diferences
        typeR.put("srl", "000010");
        typeR.put("sll", "000000");
        typeR.put("mfhi", "010000");
        typeR.put("mthi", "010001");
        typeR.put("mflo", "010010");
        typeR.put("mtlo", "010011");
        typeR.put("mult", "011000");
        typeR.put("multu", "011001");
        typeR.put("sra", "000011");
        typeR.put("div", "011010");
        typeR.put("divu", "011011");
        typeR.put("jr", "001000");
        typeR.put("jarl", "001001");

        // Type J
        typeJ.put("j", "000010");
        typeJ.put("jal", "000011");

        // Registers and their binary versions

        // Not-regulars
        registers.put("at", "00001");
        registers.put("v0", "00010");
        registers.put("v1", "00011");
        registers.put("a0", "00100");
        registers.put("a1", "00101");
        registers.put("a2", "00110");
        registers.put("a3", "00111");
        registers.put("t8", "10000");
        registers.put("t9", "10001");
        registers.put("k0", "10010");
        registers.put("k1", "10011");
        registers.put("gp", "10100");
        registers.put("sp", "10101");
        registers.put("s8", "10110");
        registers.put("ra", "10111");

        // $t
        registers.put("t0", "01000");
        registers.put("t1", "01001");
        registers.put("t2", "01010");
        registers.put("t3", "01011");
        registers.put("t4", "01100");
        registers.put("t5", "01101");
        registers.put("t6", "01110");
        registers.put("t7", "01111");

        // $s
        registers.put("s0", "10000");
        registers.put("s1", "10001");
        registers.put("s2", "10010");
        registers.put("s3", "10011");
        registers.put("s4", "10100");
        registers.put("s5", "10101");
        registers.put("s6", "10110");
        registers.put("s7", "10111");
        registers.put("zero", "00000");
    }

    //Getters Types Instructions
    public String getTypeI(String key) {
        return typeI.get(key);
   }
   public String getTypeR(String key) {
        return typeR.get(key);
   }
   public String getTypeJ(String key) {
        return typeJ.get(key);
   }

   //Getter registers
   public String getRegisterCode(String key){
    return registers.get(key);
}
}
