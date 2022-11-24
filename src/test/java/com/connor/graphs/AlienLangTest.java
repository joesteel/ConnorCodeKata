package com.connor.graphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AlienLangTest {

    @Test
    void shouldCreateGraphFromWordsWithOneLetter() {
        List<String> words = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Map<Character, List<Character>> result = AlienLang.createGraph(words);
        assertEquals(3, result.size());
        assertTrue(result.get('a').equals(Arrays.asList('b')));
        assertTrue(result.get('b').equals(Arrays.asList('c')));
        assertTrue(result.get('c').equals(Arrays.asList()));
    }

    @Test
    void shouldCreateGraphFromWordsWithTwoLetter() {
        List<String> words = new ArrayList<>(Arrays.asList("ab", "ac", "d"));
        Map<Character, List<Character>> result = AlienLang.createGraph(words);
        assertEquals(4, result.size());
        assertTrue(result.get('a').equals(Arrays.asList('d')));
        assertTrue(result.get('b').equals(Arrays.asList('c')));
        assertTrue(result.get('c').equals(Arrays.asList()));
        assertTrue(result.get('d').equals(Arrays.asList()));
    }

    @Test
    void shouldCreateGraphFromWordsWithMixedLetters2() {
        List<String> words = new ArrayList<>(Arrays.asList("on", "a"));
        Map<Character, List<Character>> result = AlienLang.createGraph(words);
        assertEquals(3, result.size());
        assertTrue(result.get('o').equals(Arrays.asList('a')));
        assertTrue(result.get('n').equals(Arrays.asList()));
        assertTrue(result.get('a').equals(Arrays.asList()));
    }

    @Test
    void shouldCountParentsCorrectly() {
        List<String> words = new ArrayList<>(Arrays.asList("ab", "ac", "d"));
        Map<Character, List<Character>> graph = AlienLang.createGraph(words);
        Map<Character, Integer> parentCounts = AlienLang.countParents(graph);
        assertEquals(4, parentCounts.size());
        assertEquals(0, parentCounts.get('a'));
        assertEquals(0, parentCounts.get('b'));
        assertEquals(1, parentCounts.get('c'));
        assertEquals(1, parentCounts.get('d'));
    }

    @Test
    void shouldCreateGraphFromWordsWithMixedLetters() {
        List<String> words = new ArrayList<>(Arrays.asList("wrt","wrf","er","ett","rftt"));
        Map<Character, List<Character>> result = AlienLang.createGraph(words);
        assertEquals(5, result.size());
        assertTrue(result.get('w').equals(Arrays.asList('e')));
        assertTrue(result.get('e').equals(Arrays.asList('r')));
        assertTrue(result.get('r').equals(Arrays.asList('t')));
        assertTrue(result.get('t').equals(Arrays.asList('f')));
        assertTrue(result.get('f').equals(Arrays.asList()));
    }

    @Test
    void shouldCreateGraphFromWordsWithMultipleChildrenForOneEntry() {
        List<String> words = new ArrayList<>(Arrays.asList("wrt","wrf","er","ett","rftt", "zw", "zf"));
        Map<Character, List<Character>> result = AlienLang.createGraph(words);
        assertEquals(6, result.size());
        assertTrue(result.get('w').equals(Arrays.asList('e', 'f')));
        assertTrue(result.get('e').equals(Arrays.asList('r')));
        assertTrue(result.get('r').equals(Arrays.asList('t', 'z')));
        assertTrue(result.get('t').equals(Arrays.asList('f')));
        assertTrue(result.get('f').equals(Arrays.asList()));
        assertTrue(result.get('z').equals(Arrays.asList()));
    }

    @Test
    void shouldCreateLetterOrderFromWordsWithOneLetter() {
        List<String> words = new ArrayList<>(Arrays.asList("a", "b", "c"));
        String result = AlienLang.alienOrder(words);
        assertTrue(result.equals("abc"));
    }

    @Test
    void shouldCreateLetterOrderFromWordsWithMultiLetters() {
        List<String> words = new ArrayList<>(Arrays.asList("she sell seashell seashore seahorse on a".split(" ")));
        String result = AlienLang.alienOrder(words);
        assertTrue(result.equals("lnrsheoa"));
    }

    @Test
    void shouldCreateLetterOrderFromWordsWithMultiLetters1() {
        List<String> words = new ArrayList<>(Arrays.asList("stdlib stl scanf sscanf printf".split(" ")));
        String result = AlienLang.alienOrder(words);
        assertTrue(result.equals("abdfilnrtcsp"));
    }

    @Test
    void shouldCreateLetterOrderFromWordsWithMultiLetters2() {
        List<String> words = new ArrayList<>(Arrays.asList("neat net nest ante one oil innit ian isotope rat reer rest".split(" ")));
        String result = AlienLang.alienOrder(words);
        assertTrue(result.equals("lnaeoiprts"));
    }

    @Test
    void shouldCreateLetterOrderFromWordsWithMultiLetters3() {
        List<String> words = new ArrayList<>(Arrays.asList("da la na fa fei jia ha hai hang hua ta sha shi si ba".split(" ")));
        String result = AlienLang.alienOrder(words);
        assertTrue(result.equals(""));
    }
}