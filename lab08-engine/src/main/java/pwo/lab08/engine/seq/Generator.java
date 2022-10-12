/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.lab08.engine.seq;

import java.math.BigDecimal;
import pwo.lab08.engine.utils.SequenceGenerator;

/**
 * Klasa abstrakcyjna spajająca wspólne elementy wszystkich generowanych ciągów.
 * Pozostałe generatory dziedziczą po niej.
 *
 * @author dariusz
 * @version 1.0.0
 */
abstract class Generator implements SequenceGenerator {

    protected int lastIndex = 0;
    protected BigDecimal current = null,
            f_1 = null,
            f_2 = null,
            f_3 = null;

    /**
     * Funkcja resetująca index ostatniego wyliczanego wyrazu ciągu.
     */
    @Override
    public void reset() {
        lastIndex = 0;
    }

    /**
     * Funkcja zwracająca podany wyraz ciągu
     *
     * @param i indeks wyrazu ciągu
     * @return wyraz ciągu o indeksie i
     */
    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i < lastIndex) {
            reset();
        }
        while (lastIndex <= i) {
            nextTerm();
        }
        return current;
    }
}
