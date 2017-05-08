package com.example.linneabark.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Statistics extends Fragment {


    public Statistics() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false);
    }

    //skall skapa en metod som hemtar månad och dagar etc..


    /**
     * Kod nedanför för statistic view som hanterar vyn/statisticen av en dag som vy*/
    private FindWhichMonth findWhichMonth = new FindWhichMonth();
    private SaveActivity saveActivity = new SaveActivity();

    //textMonth skall bytas ut mot det som hanterar/illusterar månad i statistics.
    int numberOfMonth; //= findWhichMonth.numberOfMonth(textMonth.getText()); //textMonth skall bytas ut mot det som hanterar/illusterar månad i statistics.
    String monthInNumber = "";
    String numberOfDay;// = textDay.getText(); //textDay skall bytas ut mot det som hanterar/illusterar vilken dag som är vald i statistics.

    //Vill kunna läsa av de två första, alltså t.ex. "01"
    String firstDayOfMore;// = textDays.getText().substring(0,2);
    //vill kunna läsa av de sista datumet. Illustrerigsförslag "01-05". Kolla så att den börjar rätt, med 3.
    String lastDayOfMore;// = textDays.getText().substring(3);

    //Tar fram de värderna som typparametrarna ActivityRow objekten hanterar.
    public void giveValues () {
        if (numberOfMonth > 0 && numberOfMonth < 10) {
            monthInNumber = "0" + numberOfMonth;
        } else if (numberOfMonth >= 10) {
            monthInNumber = "" + numberOfMonth;
        }
        System.out.println("monthInNumber , klassen Statistics: " + monthInNumber);
    }

    //vi börjar med day. när man väljer dag under statistic.
    //då är en månad vald och då skall endast dagarna som månaden är kunna väljas.
    public void findAllDaysForSpecificMonth() {
        giveValues();

        for(int i= 0; i < saveActivity.activityRowList.size(); i++ ){
            //saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber); <-- kollar vilka som stämmer överrens med månaden.
            if (saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber)) {
                //lägger till alla datum som loggats under en månad.
                allDaysForSpecificMonth.add(saveActivity.activityRowList.get(i).getDay());
                //sägger till alla aktiviteter som funnits under en månad.
                allActivityRowsForSpecificMonth.add(saveActivity.activityRowList.get(i));
            }
        }
    }
    //sparar alla datum som finns på den förvalda månaden och skall sedan kunna dispalaya dessa i en lista av något slag.
    List<String> allDaysForSpecificMonth = new ArrayList<>();

    //sparar alla aktiviteter från en specifik månad.
    List <ActivityRow> allActivityRowsForSpecificMonth = new ArrayList<>();

    //en metod som lägger till alla olika aktiviteter som har använts i en String list. och all sammanlagd tid i en Long list.
    //Så ett index i ena listan hör ihop med samma index i den andra listan.
    public void monthTotalForActivity () {
        //en lista för att spara alla olika kategrier som använts
        List<String> totalOfCategoryList = new ArrayList<>();
        //En lista för att spara all sammanlagd tid för en kategori.
        List<Long> totalTimeList = new ArrayList<>();

        //For loopen gör så att man kan gå igenom alla objekt från en månad
        for (int i = 0; i < allActivityRowsForSpecificMonth.size(); i++){
            //Hämtar kategorinamnet från alla objekt i listan
            String categoryName = allActivityRowsForSpecificMonth.get(i).getCategory().getCategoryName();

            //Lägger till kategorinmanet i listan, om det ej finns i listan för att kunna jämföra med totaltiden av en kategori.
            if (!(totalOfCategoryList.contains(categoryName))) {
                totalOfCategoryList.add(categoryName);
            }
            //Varje kategori har utförts en visstid(totalTime). Denna tid måste läggas till i listan som sparar den totala tiden.

            //Hämtar indexet som kategorin ligger på.
            int indexOfCategory = totalOfCategoryList.indexOf(categoryName);
            //Hämtar den totala tiden som redan ligger i listan som hanterar total tiden
            long j = totalTimeList.get(indexOfCategory);
            //Hämtar den totala tiden just detta objekt la ner på just denna kategori
            long totalTimeOfActivity = allActivityRowsForSpecificMonth.get(i).getTotalTime();
            //Läggger ihop tiden som redan låg i listan med den "nya" för objektet
            totalTimeOfActivity = totalTimeOfActivity + j;
            //Lägger till den ökade totaltiden i listan som innehåller total tider.
            totalTimeList.add(indexOfCategory, totalTimeOfActivity);
        }
    }

    public void everythingfromspecifikday () {
        giveValues();

        //sparar alla datum som finns på den förvalda månaden och skall sedan kunna dispalaya dessa i en lista av något slag.
        List<ActivityRow> saveAllActivityForADay = new ArrayList<>();

        for(int i= 0; i < saveActivity.activityRowList.size(); i++ ){
            //saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber); <-- kollar vilka som stämmer överrens med månaden.
            if (saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber)) {
                //om månaden och dagen numberOfDay...
                if(saveActivity.activityRowList.get(i).getDay().equals(numberOfDay)){
                    //sparar den specifikt valda dagen i en lista för att illustrera dagen i progress sedan
                    saveAllActivityForADay.add(saveActivity.activityRowList.get(i));
                }
            }
        }
    }

    //en metod som ser till att alla dagar läggs till i listan.
    private boolean continueTo (int i) {
            if (saveActivity.activityRowList.get(i).getDay().equals(lastDayOfMore)) {
                return false;
            }
            return true;
    }
    //denna metoden lägger till alla dagarna som är valda i en lista. denna listan visar endast loggade dagar..
    //Ur denna listan kan man få ut all tid som en aktivitet fått tillägnad.
    public void everythingFromXDays () {
        //en bugg, detta kommer bara funka om man ej tar X dagar är på olika månader.
        giveValues();

        List<ActivityRow> saveTotalTimeForXDays = new ArrayList();

        //går igenom aktivitets listan och hämtar de valda dagarna.
        for(int i= 0; i < saveActivity.activityRowList.size(); i++) {
            //kollar så att månaden som är förvald stämmer.
            if (saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber)) {
                //om objeketet i activitetslistan är det samma som dagen vi vill kolla ifrån då läggs den till i listan.
                if(saveActivity.activityRowList.get(i).getDay().equals(firstDayOfMore)) {
                    int k = i;
                    //while loopen lägger till förtsa och dagarna efter tills det att man kommer till den näst sista dagen.
                    while (continueTo(k)){
                        saveTotalTimeForXDays.add(saveActivity.activityRowList.get(k));
                        k++;
                    }
                    System.out.println("vad har k för värde efter while loopen i classen Statistics: " + k);
                }
                //lägger till den sista dagen av flera i listan.
                else if (saveActivity.activityRowList.get(i).getDay().equals(lastDayOfMore)) {
                    saveTotalTimeForXDays.add(saveActivity.activityRowList.get(i));
                }
            }
        }
    }

    //behöver en metod som kolalr vilken månad det är och sedan tar fram alla dagar som finns i denna.
    //vill vi att den skall kolla de 5 lagrade dagarna eller typ 1-5, 2-6 osv och även om man bara lagrat en dag?
}