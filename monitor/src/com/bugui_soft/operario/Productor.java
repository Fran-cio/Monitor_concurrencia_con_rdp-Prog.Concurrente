package com.bugui_soft.operario;

import com.bugui_soft.utils.Constantes;
import com.bugui_soft.utils.Rdp;

import java.util.concurrent.TimeUnit;

import static com.bugui_soft.Main.monitor;

public class Productor implements Runnable {

    private final Integer[] tInvariante;

    public Productor() {
        //Invariante de transiciones del Productor.(T4 a T7)
        tInvariante = new Integer[]{0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0};
    }

    public void run() {
        Thread.currentThread().setName("Productor");
        while (!Rdp.isHome) {
            monitor.dispararTransicion(tInvariante);
            try {
                TimeUnit.MILLISECONDS.sleep(Constantes.SLEEP_PRODUCTOR_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Simular realizar tarea
        }
    }

}
