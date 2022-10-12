/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.lab08.engine.seq;

import java.math.BigDecimal;

/**
 * Klasa odpowiedzialna za generowanie ciągu Lucasa. Rozszerza możliwości klasy
 * odpowiedzialnej za generowanie wyrazów ciągu Fibonacciego
 *
 * @author dariusz
 * @version 1.0.0
 */
public class LucasGenerator extends FibonacciGenerator {

    /**
     * Konstruktor ustawiający pierwsze wyrazy ciągu Lucasa
     */
    public LucasGenerator() {
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Funkcja która resetuje aktualny wyraz ciągu i generator na wartości
     * początkowe.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Funkcja zwracająca następny wyraz ciągu Lucasa
     *
     * @return następny wyraz ciągu Lucasa
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex == 0) {
            lastIndex++;
            return new BigDecimal(2);
        }
        return super.nextTerm();
    }
}
