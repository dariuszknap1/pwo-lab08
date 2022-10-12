/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.lab08.engine.seq;

import java.math.BigDecimal;

/**
 * Klasa odpowiadająca za generowanie wyrazów ciągu Fibonacciego.
 *
 * @author dariusz
 * @version 1.0.0
 */
public class FibonacciGenerator extends Generator {

    /**
     * Konstruktor klasy. Ustala pierwsze dwie wartości dla ciągu Fibonacciego.
     */
    public FibonacciGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Funkcja, która resetuje aktualne wyrazy ciągu, dzięki czemu możemy zacząć
     * generować nowy ciąg od pierwszych wyrazów.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Funkcja zwraca następny wyraz ciągu. Jest zoptymalizowana i jeżeli może,
     * to korzysta z poprzednio wyliczonych wyrazów ciągu do wygenerowania
     * nowych wyrazów zamiast generować wyrazy od początku.
     *
     * @return następny wyraz ciągu
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 1) {
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
}
