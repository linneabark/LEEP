package edu.chl.leep.model;

import org.junit.Test;

import java.util.List;

import edu.chl.leep.service.ExpandableListService;

import static org.junit.Assert.assertTrue;

/**
 * Created by Evelinas on 2017-08-12.
 */

public class ExpandableListServiceTest {
    ExpandableListService sM = new ExpandableListService();

    public void giveValuesInitData () throws Exception {
        //Gives input so we for sure ´can se the that this works

        LeepModel.setCategory1("Studies");
        LeepModel.setCategory2("Training");
        LeepModel.setCategory3("Other");

        LeepModel.setQuote1("Keep studying");
        LeepModel.setQuote2("Keep training");
        LeepModel.setQuote3("Keep do other stuff");

        sM.initData();
    }

    @Test
    public void testGetListDataHeader () throws Exception {
        assertTrue(sM.getListDataHeader().get(0).equals("CATEGORIES"));
        assertTrue(sM.getListDataHeader().get(0).equals("QUOTES"));
        assertTrue(sM.getListDataHeader().get(0).equals("HELP"));
    }

    @Test
    public void testGetListHash() throws Exception{
        List <String> categoriList = (List<String>)sM.getListHash().get("CATEGORIES");
        assertTrue(categoriList.get(0).equals("Studies"));
        assertTrue(categoriList.get(1).equals("Training"));
        assertTrue(categoriList.get(2).equals("Other"));

        List <String> quoteList = (List<String>)sM.getListHash().get("QUOTES");
        assertTrue(quoteList.get(0).equals("Keep studying"));
        assertTrue(quoteList.get(1).equals("Keep training"));
        assertTrue(quoteList.get(2).equals("Keep do other stuff"));

        List <String> helpList = (List<String>)sM.getListHash().get("HELP");
        assertTrue(helpList.get(0).equals("Info om hur appen fungerar"));
    }
}
