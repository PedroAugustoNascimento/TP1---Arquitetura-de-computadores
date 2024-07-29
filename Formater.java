public class Formater {
    public static String[] format(String word){
        String formatWord = word.replace(" $", ",");
        formatWord = formatWord.replace(" ", "");

        if (word.contains("(")){
            formatWord = formatWord.replace("$", ""); // add, t1, t1, t0 -> without $ on instructions
            formatWord = formatWord.replace("(", ","); // without (
            formatWord = formatWord.replace(")", ""); // without )
            String[] rightInstruction = formatWord.split(","); // without ,
            String change = rightInstruction[2];
            rightInstruction[2] = rightInstruction[3];
            rightInstruction[3] = change;
            return rightInstruction;
        } else {
            formatWord = formatWord.replace(",,", ",");
            String[] rightInstrcution = formatWord.split(",");
            return rightInstrcution;
        }
    }

    public static String check(String word){
        InstAndRegister instruction = new InstAndRegister();
        String [] instruction_parts = word.split(" ");
        String inst = instruction_parts[0];

        if (instruction.getTypeI(inst) != null){
            if (word.contains("(")){
                String [] format = Formater.format(word);
                String returned = Types.returnbinaryI(inst, format);
                return "\n" + word + "\n" + returned;
            } else {
                String [] format = Formater.format(word);
                String returned = Types.returnbinaryI(inst, format);
                return "\n" + word + "\n" + returned;
            }
        } else if (instruction.getTypeR(inst)!= null) {
            String [] format = Formater.format(word);
            String returned = Types.returnbinaryR(inst, format);
            return "\n" + word + "\n" + returned;
        } else {
            String [] rightWord = word.split(" ");
            String returned = Types.returnbinaryJ(instruction.getTypeJ(rightWord[0]), rightWord[1]);
            return "\n" + word + "\n" + returned;
        }
    }
}
