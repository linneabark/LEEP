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

    public QuotesService() {
        mA = new MainActivity();

        //Lägger till några quotes så att de finns per default.
        quotes.add("Fuck you");
        quotes.add("Life sucks, deal with it");
        quotes.add("Rumpnisse");
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

    /**
     * eller om man anropar addQuote , och man skriver in i ett textField, kallat txtQuote
     */
    public void addQuote(){
        //quotes.add(txtArea.getText());
    }

    public void printQuote() {
        for (int i = 0 ; i < quotes.size(); i++) {
            //Lägg till ett quote i t.ex. en textArea
            //textArea.setText(quotes.get(i));
        }
        //Fixa så att den skriver ut lika många textArea : s som det finns quotes.....................................................................
    }


    public int findQuote () {
        for(int i = 0 ; i < quotes.size(); i++){
        /*  if (textArea.getText().equals(quotes.get(i))) {
                return i;
            }*/
        }
        return -1;
    }

    //kanske onödig check men tänker att de är bra att he fler checks ifall ngt inte skulle stämma.
    public void isThereAQuote() {
        String changedQuoteText = "";// = textArea.getText();.......................................................
        if (findQuote() != -1) {
            changeQuote(changedQuoteText);
        }
        else {
            System.out.println("Can not find the quote you are searching for!");
        }
    }
    public void changeQuote (String changedQuoteText) {
        quotes.set(findQuote(), changedQuoteText);
    }
    /*
    //eller
    public void changeQuote (String changedQuoteText) {
            updateQuote(findQuote(), changedQuoteText);
    }
    //vi antar att ändra knappen vet vilket index quoten har, räknat från 0.
    public void updateQuote(int index, String changedQuote){
        quotes.set(index, changedQuote);
    }
    */

}
