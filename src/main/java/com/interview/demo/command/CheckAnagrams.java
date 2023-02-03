package com.interview.demo.command;

import java.util.Arrays;

/**
 * RUN: java -ea src/main/java/com/interview/demo/command/CheckAnagrams.java "flop aaa" "olfp aaa"
 * -ea stands for 'enable assertion'
 */
public class CheckAnagrams {

    // O(nLog(n)) Time
    // O(n) Space
    // where n is the length of the longest word
    public static void main(String[] args) {
        if (args.length == 2) {
            final var word1 = args[0];
            final var word2 = args[1];
            assert getSortedWord(word1).equals(getSortedWord(word2)) : "Words are not anagrams!";
            System.out.println("Words " + word1 + " and " + word2 + " are anagrams");
        } else {
            throw new RuntimeException("CheckAnagrams.java expects two arguments");
        }
    }
    public static String getSortedWord(final String word) {
        var charArray = word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
