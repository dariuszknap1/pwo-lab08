package pwo.lab08.engine;

import pwo.lab08.engine.seq.SeqType;
import pwo.lab08.engine.utils.SequenceTools;

public class Engine {

    public static final String VERSION = "Number sequences engine version 1.0.0";

    public static String getVersion() {
        return VERSION;
    }
    
    public static void writeToFile(SeqType type, int from, int to, String fileName){
        SequenceTools.writeToFile(type.getGenerator(), from, to, fileName);
    }
}
