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

public class QuotesService implements IQuotesService{
    //QuotesService is stored in a list
    List<String> quotes = new ArrayList<String>();
    Random rand = new Random();
    MainActivity mA;
    Context context;

    public QuotesService(Context context) {
        mA = new MainActivity();
        this.context = context;

        //Lägger till några quotes så att de finns per default.
        quotes.add("Hej");
        quotes.add("På");
        quotes.add("Dig");
    }

    public String getQuote() {
        //Chooses a random number after the amount of quotes
        //Takes a number between 0 and size-1
        int randQuoteIndex = rand.nextInt(quotes.size());
        System.out.println("randQuoteIndex: " + randQuoteIndex);
        //To get a random quote
        String randQuote = quotes.get(randQuoteIndex);
        System.out.println(randQuote);
        return randQuote;
    }

    //Denna kod kanske borde tas bort och självaste add raden borde finnas i inställninagr där man tar han om inputen.
    public void addQuote(String inputQuote){
        quotes.add(inputQuote);
    }


}
