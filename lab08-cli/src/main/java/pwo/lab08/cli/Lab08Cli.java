package pwo.lab08.cli;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import pwo.lab08.engine.Engine;
import pwo.lab08.engine.seq.SeqType;
import pwo.lab08.engine.utils.SequenceTools;

public class Lab08Cli {

    public static final String APP_NAME = "Lab08 CLI Application ";

    protected SeqType seqType = null;
    protected Integer from = null, to = null;
    protected String fileName = null;

    public static void main(String[] args) {
        (new Lab08Cli()).run(args);
    }

    /**
     * Główna funkcja odpowiedzialna za zapis do pliku. Funkcja jednocześnie
     * sprawdza, czy argumenty z linii poleceń zostały pobrane prawidłowo i
     * wyświetla stosowny komunikat o udanym zapisie bądź błędzie
     *
     * @param args Argumenty wiersza poleceń
     */
    public void run(String[] args) {
        System.out.println(APP_NAME + Engine.getVersion());
        System.out.println("Sequence to file CLI app");
        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to fileName");
            return;
        }
        if (!writeSeq()) {
            System.out.println("!Write to the file: "
                    + fileName + " FAILED");
            return;
        }
        System.out.println("Results write to " + fileName);
    }

    protected boolean getArgs(String[] args) {
        try {
            seqType = SeqType.fromString(args[0]);
            from = Integer.parseInt(args[1]);
            to = Integer.parseInt(args[2]);
            fileName = args[3];
        } catch (ArrayIndexOutOfBoundsException
                | NumberFormatException ex) {
            return false;
        }
        try {
            Paths.get(fileName);
        } catch (InvalidPathException ex) {
            return false;
        }
        return seqType != null && from >= 0 && to >= 0;
    }

    protected boolean writeSeq() {
        System.out.println(seqType);
        return SequenceTools.writeToFile(seqType.getGenerator(),
                from, to, fileName);
    }
}
