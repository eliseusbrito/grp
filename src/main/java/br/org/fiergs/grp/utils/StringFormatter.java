package br.org.fiergs.grp.utils;

import org.springframework.stereotype.Component;

import java.text.Normalizer;
import java.util.regex.Pattern;

@Component
public class StringFormatter {

    public String formatDate(String inputDate) {
        String outputDate = inputDate.replace("T", "%");
        StringBuilder sb = new StringBuilder(outputDate);
        sb.deleteCharAt(4);
        sb.deleteCharAt(6);
        sb.deleteCharAt(11);
        sb.append("0000");
        return sb.toString();
    }

    public String removeAcentuacao(String value) {
        String normalizer = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizer).replaceAll("");
    }

    public String removeEspacos(String input) {
        return input.replaceAll(" ", "");
    }

}