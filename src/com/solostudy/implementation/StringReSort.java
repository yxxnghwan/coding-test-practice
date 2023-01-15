package com.solostudy.implementation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringReSort {
    /**
     * 문자열 재정렬
     * <p>
     * 알파벳 대문자랑 숫자로만 이루어진 문자열이 주어진다. 알파벳을 순서대로 정렬해서 출력하고 이어서 숫자를 모두 더한 값을 출력해라.
     * <p>
     * ex) input : K1KA5CB7, output: ABCKK13
     */

    public static void main(String[] args) {
        System.out.println(solution("K1KA5CB7"));
    }

    private static String solution(final String input) {
        final List<String> onlyStr = new ArrayList<>();
        int numberSum = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                numberSum += Character.getNumericValue(input.charAt(i));
                continue;
            }
            onlyStr.add(String.valueOf(input.charAt(i)));
        }

        onlyStr.sort(Comparator.comparing(o -> o));

        return String.join("", onlyStr) + numberSum;
    }
}
