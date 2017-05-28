package edu.chl.leep.service;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import edu.chl.leep.model.LeepModel;

/**
 * Created by Evelina on 2017-05-05.
 *
 * A class which contains some methods to deal with quotes that are being displays in fragment_timelog.xml
 */

public class QuotesService{
    private List<String> quotes = new ArrayList<>();
    private Random rand = new Random();
    private Context context;

    public QuotesService(Context context) {
        this.context = context;
        addQuote();
    }

    public String getQuote() {
        int randQuoteIndex = rand.nextInt(quotes.size());
        String randQuote = quotes.get(randQuoteIndex);
        return randQuote;
    }

    private void addQuote(){
        quotes.add(LeepModel.getQuote1(context));
        quotes.add(LeepModel.getQuote2(context));
        quotes.add(LeepModel.getQuote3(context));
    }
}
