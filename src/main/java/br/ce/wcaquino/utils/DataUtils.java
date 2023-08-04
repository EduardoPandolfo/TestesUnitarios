package br.ce.wcaquino.utils;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.util.Calendar;

public class DataUtils {

    /**
     * Retorna a data enviada por parametro com a adição dos dias desejado
     * a Data pode estar no futuro (dias > 0) ou no passado (dias < 0)
     *
     * @param data
     * @param dias
     * @return
     */
    public static LocalDate adicionarDias(LocalDate data, int dias) {
        return data.plusDays(dias);
    }

    /**
     * Retorna a data atual com a diferenca de dias enviados por parametro
     * a Data pode estar no futuro (parametro positivo) ou no passado (parametro negativo)
     *
     * @param dias Quantidade de dias a ser incrementado/decrementado
     * @return Data atualizada
     */
    public static LocalDate obterDataComDiferencaDias(int dias) {
        return adicionarDias(LocalDate.now(), dias);
    }

    /**
     * Retorna uma instância de <code>LocalDate</code> refletindo os valores passados por parametro
     *
     * @param dia
     * @param mes
     * @param ano
     * @return
     */
    public static LocalDate obterData(int dia, int mes, int ano) {
        return LocalDate.of(ano, mes, dia);
    }

    /**
     * Verifica se uma data é igual a outra
     * Esta comparação considera apenas dia, mes e ano
     *
     * @param data1
     * @param data2
     * @return
     */
    public static boolean isMesmaData(LocalDate data1, LocalDate data2) {
        return data1.equals(data2);
    }

    /**
     * Verifica se uma determinada data é o dia da semana desejado
     *
     * @param data      Data a ser avaliada
     * @param diaSemana <code>true</code> caso seja o dia da semana desejado, <code>false</code> em caso contrário
     * @return
     */
    public static boolean verificarDiaSemana(LocalDate data, DayOfWeek dayOfWeek) {
        return data.getDayOfWeek() == dayOfWeek;
    }

    public LocalDate dataAtual() {
        return LocalDate.now();
    }
}
