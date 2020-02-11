import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SentenceTest {
    IListNode punc1;
    IListNode word1;
    IListNode word2;
    Sentence s;

    @Before
    public void setUp() throws Exception {
        // create new nodes
        punc1 = new PunctuationNode("!");
        word1 = new WordNode("everyone",punc1);
        word2 = new WordNode("Hello", word1);
        // create a new Sentence
        s = new Sentence(word2);
    }

    @Test
    public void getNumberOfWords() {
        // check the number of words in the Sentence s is 2
        assertEquals(2, s.getNumberOfWords());
    }

    @Test
    public void longestWord() {
        // check the longest word in the Sentence s is "everyone"
        assertEquals("everyone", s.longestWord());
    }

    @Test
    public void testToString() {
        // create new nodes and a new Sentence
        IListNode word3 = new WordNode("everyone");
        IListNode word4 = new WordNode("Hello", word3);
        Sentence s2 = new Sentence(word4);

        // check the string of Sentence s is "Hello everyone!"
        assertEquals("Hello everyone!", s.toString());

        // check the period is added successfully
        // when there is no punctuation mark at the end of the sentence
        assertEquals("Hello everyone.", s2.toString());
    }

    @Test
    public void testClone() {
        // check the cloned Sentence s2 is the same as Sentence s.
        Sentence s2 = s.clone();
        assertEquals(s2.toString(), s2.toString());
    }

    @Test
    public void merge() {
        // create new nodes and a new Sentence
        IListNode punc2 = new PunctuationNode("!");
        IListNode word3 = new WordNode("morning",punc2);
        IListNode word4 = new WordNode("Good", word3);
        Sentence s2 = new Sentence(word4);

        // merge Sentence s with Sentence s2
        Sentence s3 = s2.merge(s);

        // check if Sentence s and Sentence s2 are merged successfully
        // the string of the merged Sentence s3 should be "Good morning! Hello everyone!"
        assertEquals("Good morning! Hello everyone!", s3.toString());
    }
}