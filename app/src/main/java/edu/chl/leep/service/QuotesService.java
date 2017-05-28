package edu.chl.leep.service;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.chl.leep.ctrl.MainActivity;
import edu.chl.leep.ctrl.SettingsController;
import edu.chl.leep.model.Leep;

/**
 * Created by Evelina on 2017-05-05.
 */

public class QuotesService{
    //QuotesService is stored in a list
    private List<String> quotes = new ArrayList<String>();
    private Random rand = new Random();
    private Context context;

    public QuotesService(Context context) {
        this.context = context;
        addQuote();
    }

    public String getQuote() {
        //Chooses a random number after the amount of quotes
        //Takes a number between 0 and size-1
        int randQuoteIndex = rand.nextInt(quotes.size());
        //To get a random quote
        String randQuote = quotes.get(randQuoteIndex);
        System.out.println(randQuote);
        return randQuote;
    }

    //Denna kod kanske borde tas bort och självaste add raden borde finnas i inställninagr där man tar han om inputen.
    public void addQuote(){
        quotes.add(Leep.getQuote1(context));
        quotes.add(Leep.getQuote2(context));
        quotes.add(Leep.getQuote3(context));
    }
}
