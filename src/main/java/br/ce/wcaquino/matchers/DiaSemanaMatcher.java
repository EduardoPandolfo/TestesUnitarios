package br.ce.wcaquino.matchers;

import br.ce.wcaquino.utils.DataUtils;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DiaSemanaMatcher extends TypeSafeMatcher<LocalDate> {

    private final DayOfWeek diaSemana;

    public DiaSemanaMatcher(DayOfWeek diaSemana) {
        this.diaSemana = diaSemana;
    }


    @Override
    protected boolean matchesSafely(LocalDate data) {
        return DataUtils.verificarDiaSemana(data, diaSemana);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(diaSemana.name());
    }
}
