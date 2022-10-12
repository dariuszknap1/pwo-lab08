/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.lab08.engine.seq;

import java.math.BigDecimal;

/**
 * Klasa odpowiedzialna za generowanie wyrazów ciągu Tribonacciego
 *
 * @author dariusz
 * @version 1.0.0
 */
public class TribonacciGenerator extends FibonacciGenerator {

    /**
     * Konstruktor nadający początkowe wartości na trzeci wyraz ciągu
     * Tribonacciego
     */
    public TribonacciGenerator() {
        f_3 = new BigDecimal(0);
    }

    /**
     * Funkcja resetująca wszystkie 3 parametry ciągu Tribonacciego. Korzysta z
     * metody klasy bazowej.
     */
    @Override
    public void reset() {
        super.reset();
        f_3 = new BigDecimal(0);
    }

    /**
     * Funkcja odpowiedzialna za wyliczanie następnego wyrazu ciągu
     * Tribonacciego. Jest zoptymalizowana do wyliczania wyrazów w przód
     *
     * @return następny wyraz ciągu
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 2) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
}
