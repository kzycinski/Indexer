package com.indexer.index;


import org.junit.Assert;
import org.junit.Test;

public class IndexerTest {

    @Test
    public void whenProvidedEmptyStringThenReturnEmptyMap() {
        Indexer indexer = new Indexer("");
        Assert.assertNotNull(indexer.getIndexMap());
        Assert.assertEquals(0, indexer.getIndexMap().size());
    }

    @Test
    public void whenProvidedFourLetterWordThenProvideProperIndex() {
        Indexer indexer = new Indexer("four");
        Assert.assertNotNull(indexer.getIndexMap());
        Assert.assertEquals(4, indexer.getIndexMap().size());
        Assert.assertTrue(indexer.getIndexMap().get('f').contains("four"));
        Assert.assertEquals(1, indexer.getIndexMap().get('f').size());
        Assert.assertTrue(indexer.getIndexMap().get('o').contains("four"));
        Assert.assertEquals(1, indexer.getIndexMap().get('o').size());
        Assert.assertTrue(indexer.getIndexMap().get('u').contains("four"));
        Assert.assertEquals(1, indexer.getIndexMap().get('u').size());
        Assert.assertTrue(indexer.getIndexMap().get('r').contains("four"));
        Assert.assertEquals(1, indexer.getIndexMap().get('r').size());
    }

    @Test
    public void whenProvidedTwoWordsThenSplitThem() {
        Indexer indexer = new Indexer("two words");
        Assert.assertNotNull(indexer.getIndexMap());
        Assert.assertEquals(1, indexer.getIndexMap().get('t').size());
        Assert.assertEquals(2, indexer.getIndexMap().get('w').size());
        Assert.assertEquals(2, indexer.getIndexMap().get('o').size());
    }

    @Test
    public void whenProvidedWortWithSpecialCharacterThenSkipThisCharacter() {
        Indexer indexer = new Indexer("word,");
        Assert.assertNotNull(indexer.getIndexMap());
        Assert.assertTrue(indexer.getIndexMap().get('w').contains("word"));
    }

    @Test
    public void whenProvidedTwoEqualWordsThenAddOnlyOne() {
        Indexer indexer = new Indexer("word word");
        Assert.assertNotNull(indexer.getIndexMap());
        Assert.assertEquals(1, indexer.getIndexMap().get('w').size());
    }

    @Test
    public void whenProvidedCapitalLetterWordThenAddLowerLetter() {
        Indexer indexer = new Indexer("Word");
        Assert.assertNotNull(indexer.getIndexMap());
        Assert.assertTrue(indexer.getIndexMap().get('w').contains("word"));
    }

}
