package br.ce.wcaquino.matchers;

import java.time.DayOfWeek;

public class LocalDateMatcherFactory {

    public static DiaSemanaMatcher caiEm(DayOfWeek dayOfWeek) {
        return new DiaSemanaMatcher(dayOfWeek);
    }

    public static DiaSemanaMatcher caiEmSegundaFeira() {
        return new DiaSemanaMatcher(DayOfWeek.MONDAY);
    }
}
