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
        punc1 = new PunctuationNode("!");
        word1 = new WordNode("everyone",punc1);
        word2 = new WordNode("Hello", word1);
        s = new Sentence(word2);
    }

    @Test
    public void getNumberOfWords() {
        assertEquals(2, s.getNumberOfWords());
    }

    @Test
    public void longestWord() {
        assertEquals("everyone", s.longestWord());
    }

    @Test
    public void testToString() {
        IListNode word3 = new WordNode("everyone");
        IListNode word4 = new WordNode("Hello", word3);
        Sentence s2 = new Sentence(word4);

        assertEquals("Hello everyone!", s.toString());
        assertEquals("Hello everyone.", s2.toString());
    }

    @Test
    public void testClone() {
        Sentence s2 = s.clone();
        assertTrue(s.equals(s2));
    }

    @Test
    public void merge() {
        IListNode punc2 = new PunctuationNode("!");
        IListNode word3 = new WordNode("morning",punc2);
        IListNode word4 = new WordNode("Good", word3);

        Sentence s2 = new Sentence(word4);
        Sentence s3 = s2.merge(s);
        assertEquals("Good morning! Hello everyone!", s3.toString());
    }
}