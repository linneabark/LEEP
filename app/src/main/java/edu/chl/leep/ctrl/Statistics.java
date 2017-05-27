package edu.chl.leep.ctrl;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.chl.leep.model.ActivityRow;
import edu.chl.leep.model.Leep;
import edu.chl.leep.model.StatisticsModel;
import edu.chl.leep.utils.FindWhichMonth;
import com.example.linneabark.test.R;
import edu.chl.leep.service.SaveActivity;
import android.widget.Button;

import com.example.linneabark.test.StatisticsActivityAdapter;
import com.example.linneabark.test.StatisticsDateAdapter;
import com.example.linneabark.test.StatisticsMonthAdapter;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Statistics extends Fragment {
    //TODO StatisticsCtrl
    public Statistics() {
        // Required empty public constructor
    }
    private FindWhichMonth findWhichMonth = new FindWhichMonth();
    private SaveActivity saveActivity = new SaveActivity();


    static MainActivity mainActivity = new MainActivity();

    StatisticsModel statisticsModel = new StatisticsModel();
/*
    private List <ActivityRow> defaultStatisticList = new ArrayList<>();
    //listan för specifik user.
    public static List<ActivityRow> userActivityList = new ArrayList<>();
    //sparar alla datum som finns på den förvalda månaden och skall sedan kunna dispalaya dessa i en lista av något slag.
    List<String> allDaysForSpecificMonth = new ArrayList<>();
    //sparar alla aktiviteter från en specifik månad.
    public static List <ActivityRow> allActivityRowsForSpecificMonth = new ArrayList<>();

    // en lista för att spara alla olika kategrier som använts
    public static List<String> totalOfCategoryList = new ArrayList<>();
    //En lista för att spara all sammanlagd tid för en kategori.
    public static List<Long> totalTimeList = new ArrayList<>();
    */

    RecyclerView recyclerMonth;
    RecyclerView recyclerDate;
    RecyclerView recyclerActivity;

    Button btnDay;
    Button btnXDays;
    Button btnMonth;

    private float [] yvalue;
    private String [] xcategory;

    //Declare pie-chart
    PieChart pieChart;

    static long totalTimeOfEveryting;

    public String [] insertCategoryPieChart (List<String> categoryList){
        xcategory = new String [statisticsModel.getTotalOfCategoryList().size()];
        System.out.println("categprylist size" + categoryList.size());
         for (int i = 0; i < categoryList.size(); i++) {
             xcategory [i] = categoryList.get(i);
         }
        System.out.println("xcategory" + xcategory.length);
         return xcategory;
    }

    public float [] insertTotalTimePieChart (List<Long> totalTimeList){
        yvalue = new float[totalTimeList.size()];
        System.out.println("totaltimelist size" + totalTimeList.size());
        for (int i = 0; i < totalTimeList.size(); i++) {
            float totalTimeValue = Float.valueOf(totalTimeList.get(i));
            System.out.println("totaltimevalue --> "+ totalTimeValue);
            yvalue [i] = totalTimeValue;
        }
        System.out.println("yvalue" + yvalue.length);
        return yvalue;
    }


    // findMonth.month hämtar listan med alla månader.
    // denna listan skall egentligen användas --> allDaysForSpecificMonth
    public static List<String> date = new ArrayList<>();//{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10"};
    public static List <String> assList () {
        date.add("01");
        date.add("02");
        date.add("03");
        date.add("04");
        date.add("06");
        date.add("07");
        date.add("08");
        date.add("09");
        date.add("10");

        return date;
    }

    //public static StatisticsDateAdapter statisticsDateAdapter = new StatisticsDateAdapter(mainActivity.getContext(), assList());

/*
    List <String> reformListToDisplay () {
        addFirstListToCheck();
        getDefaultStatisticList();
        List<String>listToDisplay = new ArrayList<>();

        for(int i = 0; i < statisticsModel.getDefaultStatisticList().size(); i++) {
            int stopTime = Integer.valueOf(takeAwayFirstZeros(statisticsModel.getDefaultStatisticList().get(i).getStartTime()))
                    + Integer.valueOf(takeAwayFirstZeros(statisticsModel.getDefaultStatisticList().get(i).getTotalTime()));
            String s = statgetDefaultStatisticList().get(i).getCategoryName() + "    " + statisticsModel.getDefaultStatisticList().get(i).getStartTime() + " - " + stopTime;
            listToDisplay.add(s);
        }
        return listToDisplay;
    }*/
/*
    private void addFirstListToCheck(){
        //ActivityRow (String userName, String year, String month, String day, String startTime, String totalTime, String categoryName)
        getUserActivityList().add(new ActivityRow("Evelina", "1997", "05", "09", "0990", "1000", "Föreläsning"));
        getUserActivityList.add(new ActivityRow("Evelina", "1997", "04", "08", "0990", "1000", "sov"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "04", "08", "0990", "1000", "sov"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "04", "08", "0990", "1000", "sov"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "04", "08", "0990", "1000", "sov"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "04", "08", "0990", "1000", "sov"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "04", "08", "0990", "1000", "sov"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "09", "0990", "1000", "plugg"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "09", "0990", "1000", "plugg"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "09", "0990", "1000", "plugg"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "09", "0990", "1000", "plugg"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "07", "0990", "1000", "mat"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "06", "0990", "1000", "snort"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "06", "0990", "1000", "dansa"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "05", "0990", "1000", "pluggaaa"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "01", "0990", "1000", "plugg"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "02", "0990", "1000", "mat"));

        System.out.println(userActivityList.size() + "user activity sizee");
    }*/


    String [] listOfActivity = {"hej", "på", "dig", "din", "lilla", "grej", "vad", "gör", "en", "sak", "som", "dig"};


    StatisticsActivityAdapter statisticsActivityAdapter = new StatisticsActivityAdapter(mainActivity.getContext(),  statisticsModel.reformListToDisplay());
    StatisticsDateAdapter statisticsDateAdapter = new StatisticsDateAdapter(mainActivity.getContext(), assList(), statisticsActivityAdapter);
    StatisticsMonthAdapter statisticsMonthAdapter = new StatisticsMonthAdapter(mainActivity.getContext(), findWhichMonth.months, statisticsDateAdapter);




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
        * PieChart videon säger
        super.onCreate(savedInstanceState);
        * */
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_statistics, container, false);
/**/
        //to display the months
        recyclerMonth = (RecyclerView) rootview.findViewById(R.id.recyclerMonth);
        recyclerMonth.setLayoutManager(new LinearLayoutManager(mainActivity.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerMonth.setAdapter(statisticsMonthAdapter);

        //to display all the dates there where logged in a specific month.
        recyclerDate = (RecyclerView) rootview.findViewById(R.id.recyclerDate);
        recyclerDate.setLayoutManager(new LinearLayoutManager(mainActivity.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerDate.setAdapter(statisticsDateAdapter);

        btnDay = (Button) rootview.findViewById(R.id.btnDay);
        btnXDays = (Button) rootview.findViewById(R.id.btnXDays);
        btnMonth = (Button) rootview.findViewById(R.id.btnMonth);

        btnDay.setBackgroundColor(Color.LTGRAY);

        btnDay.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonsWhite();
                giveButtonColor(v,btnDay);
                statisticsModel.setWhichBtn("btnDay");
            }
        });
        btnXDays.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonsWhite();
                giveButtonColor(v,btnXDays);
            }
        });
        btnMonth.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                doButtonsWhite();
                giveButtonColor(v,btnMonth);
                statisticsModel.setWhichBtn("btnMonth");
            }
        });

        recyclerActivity = (RecyclerView) rootview.findViewById(R.id.recyclerActivity);
        recyclerActivity.setLayoutManager(new LinearLayoutManager(mainActivity.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerActivity.setAdapter(statisticsActivityAdapter);

/*
        recyclerStatistics = (RecyclerView) rootview.findViewById(R.id.recyclerStatistics);
        recyclerStatistics.setLayoutManager(new LinearLayoutManager(mainActivity.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerStatistics.setAdapter(statisticsHowAdapter);
*/
/*
        //För numberPickern
        monthPicker = (NumberPicker) rootview.findViewById(R.id.monthPicker);
        monthPicker.setMinValue(0);
        monthPicker.setMaxValue(findMonth.months.length - 1);
        monthPicker.setDisplayedValues(findMonth.months);
*/

        insertCategoryPieChart(statisticsModel.getTotalOfCategoryList());
        insertTotalTimePieChart(statisticsModel.getTotalTimeList());

        //The PieChart
        pieChart = (PieChart) rootview.findViewById(R.id.pieChart);
        //set propeties
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(50f);
        pieChart.setCenterText("Activity in percent");
        pieChart.setCenterTextSize(10);

        addDataToChart(pieChart);

        //pieChart listener så när man trycker på en pajbit så kommer de upp en text.
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                System.out.println("e: " + e.toString());
                System.out.println("h: " + h.toString());
                //e.toString().indexOf("(sum) ");man behöver detta pga att programmet skriver ut detta. Inget vi valt.
                int pos = e.toString().indexOf("y: ");
                String precent = e.toString().substring(pos + 3);

                System.out.println("pos: " + pos + ".");
                System.out.println("precent: " + precent + ".");

                for (int i = 0; i < yvalue.length; i++) {
                    if (yvalue[i] == Float.parseFloat(precent)) {
                        pos = i;
                        break;
                    }
                }

                String whichCategory = xcategory[pos];

                //För att skriva ut det snyggt...
                //För att få flera rader, lägg till "\n" där det önskas
                // Toast.makeText(mainActivity.getContext(), ("" + whichCategory + ": " + precent + " %."), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected() {}
        });

        return rootview;
    }

    //behöver ej in-parametern / typ-parametrn när variabeln ligger i denna klassen. Flyttar vi dock ut metoden eller dyligt måste det finnas en in-parameter.
    private void addDataToChart(PieChart pieChart) {
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        //Loppar igenom de procentuella värderna och lägger till  yEntry arraylist
        for(int i = 0; i < yvalue.length; i++) {
            yEntrys.add(new PieEntry(yvalue[i] , i));
        }
        //Lägger till categorinamnet i xEntry arraylisten
        for(int i = 0; i < xcategory.length; i++) {
            xEntrys.add(xcategory[i]);
        }

        //skapar the data set

        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Activitys precent");
        //Avståndet mellan de olika pajbitarna
        pieDataSet.setSliceSpace(2);
        //Storleken på den procentuella summan
        pieDataSet.setValueTextSize(12);

        //Lägger till färgerna, koppla ihop dessa med kategorierna
        //add colors to the dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.RED);
        colors.add(Color.CYAN);
        colors.add(Color.MAGENTA);

        pieDataSet.setColors(colors);

        //add legend to the chart. Förklarar hur mann gör allt: https://github.com/PhilJay/MPAndroidChart/wiki/Legend
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }


    public void giveButtonColor (View view, Button btn) {
        if (view == btn) {
            btn.setBackgroundColor(Color.LTGRAY);
        }
    }

    public void doButtonsWhite () {
        btnDay.setBackgroundColor(Color.WHITE);
        btnXDays.setBackgroundColor(Color.WHITE);
        btnMonth.setBackgroundColor(Color.WHITE);
    }

    //skall skapa en metod som hemtar månad och dagar etc..


    /**
     * Kod nedanför för statistic view som hanterar vyn/statisticen av en dag som vy*/

/*
    //textMonth skall bytas ut mot det som hanterar/illusterar månad i statistics.
    //int numberOfMonth; //= findWhichMonth.numberOfMonth(textMonth.getText()); //textMonth skall bytas ut mot det som hanterar/illusterar månad i statistics.
    //String monthInNumber = "";
    //String numberOfDay;// = textDay.getText(); //textDay skall bytas ut mot det som hanterar/illusterar vilken dag som är vald i statistics.

    String monthInNumber = statisticsMonthAdapter.getMonthOfBtn();
    String numberOfDay = statisticsDateAdapter.getDateOfBtn();


    //Vill kunna läsa av de två första, alltså t.ex. "01"
    String firstDayOfMore;// = textDays.getText().substring(0,2);
    //vill kunna läsa av de sista datumet. Illustrerigsförslag "01-05". Kolla så att den börjar rätt, med 3.
    String lastDayOfMore;// = textDays.getText().substring(3);

    public static String takeAwayFirstZeros (String string) {
        string = string.replaceFirst("^0+(?!$)", "");
        return string;
    }


    //Tar fram de värderna som typparametrarna ActivityRow objekten hanterar.
    public void giveValues () {
        if (numberOfMonth > 0 && numberOfMonth < 10) {
            monthInNumber = "0" + numberOfMonth;
        } else if (numberOfMonth >= 10) {
            monthInNumber = "" + numberOfMonth;
        }
        System.out.println("monthInNumber , klassen Statistics: " + monthInNumber);
    }

    //tar den sparade listan och lägger in allt som sparats i en ny lista för den specifika usern.
    public void getAllSavedActivitysForUser () {
        //Hämta den sparade listan i textFilen. vi antar att det är raden nedanför..
        List<ActivityRow> allActivitysForAllUsers = new ArrayList<>();

        for (int i = 0; i < allActivitysForAllUsers.size(); i++) {
            // --------------------------------------------------------------------------------------------------------------Leep.getUSER() eller AccountDetails?????
            if (Leep.getUSER().equals(allActivitysForAllUsers.get(i).getUserName())) {
                userActivityList.add(allActivitysForAllUsers.get(i));
            }
        }
    }


    private int intYearFromList (List<ActivityRow> list, int positionInList) {
        return Integer.valueOf(takeAwayFirstZeros(list.get(positionInList).getYear()));
    }
    private int intMonthFromList (List<ActivityRow> list, int positionInList) {
        return Integer.valueOf(takeAwayFirstZeros(list.get(positionInList).getMonth()));
    }
    private int intDayFromList (List<ActivityRow> list, int positionInList) {
        return Integer.valueOf(takeAwayFirstZeros(list.get(positionInList).getDay()));
    }



    public List<ActivityRow> getDefaultStatisticList () {
        int year = 0;
        int month = 0;
        int day = 0;

        // 5 > 4 -> är true
        //Find the greatest year
        for (int i = 0; i < userActivityList.size(); i++) {
            int yearFromList = intYearFromList(userActivityList,i);
            if (yearFromList > year) {
                year = yearFromList;
            }
        }

        //Find the greatest month in the greatest year
        for (int i = 0; i < userActivityList.size(); i++) {
            if (year == intYearFromList(userActivityList, i)){

                int monthFromList = intMonthFromList(userActivityList, i);
                if (monthFromList > month) {
                    month = monthFromList;
                }
            }
        }

        //find the greatest day in the greatest month and year
        for (int i = 0; i < userActivityList.size(); i++) {
            if (year == intYearFromList(userActivityList, i) && month == intMonthFromList(userActivityList, i)){

                int dayFromList = intDayFromList(userActivityList, i);
                if (dayFromList > day) {
                    day = dayFromList;
                }
            }
        }

        //Insert all the activitys from the greatest date
        for(int i = 0; i < userActivityList.size(); i++) {
            if(year == intYearFromList(userActivityList, i) &&
                    month == intMonthFromList(userActivityList, i) &&
                    day == intDayFromList(userActivityList, i)) {
                defaultStatisticList.add(userActivityList.get(i));
            }
        }

        totalForActivity(defaultStatisticList);

        return defaultStatisticList;
    }

    //vi börjar med day. när man väljer dag under statistic.
    //då är en månad vald och då skall endast dagarna som månaden är kunna väljas.

    public List<String> getAllDays () {

        int intMonth= FindWhichMonth.numberOfMonth(statisticsMonthAdapter.getMonthOfBtn());

        System.out.println("Klass statistics, metod getAllDays. Värde på månad som trycks på " + intMonth);

        for(int i= 0; i < userActivityList.size(); i++ ){
            //saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber); <-- kollar vilka som stämmer överrens med månaden.
            if (Integer.valueOf(takeAwayFirstZeros(userActivityList.get(i).getMonth())) == intMonth) {
                //lägger till alla datum som loggats under en månad.
                allDaysForSpecificMonth.add(userActivityList.get(i).getDay());
            }
        }
        return allDaysForSpecificMonth;
    }
    public void findAllDaysForSpecificMonth() {
        giveValues();

        for(int i= 0; i < userActivityList.size(); i++ ){
            //saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber); <-- kollar vilka som stämmer överrens med månaden.
            if (userActivityList.get(i).getMonth().equals(monthInNumber)) {
                //lägger till alla datum som loggats under en månad.
                allDaysForSpecificMonth.add(userActivityList.get(i).getDay());
                //sägger till alla aktiviteter som funnits under en månad.
                allActivityRowsForSpecificMonth.add(userActivityList.get(i));
            }
        }
    }


    //en metod som lägger till alla olika aktiviteter som har använts i en String list. och all sammanlagd tid i en Long list.
    //Så ett index i ena listan hör ihop med samma index i den andra listan.

    //För specifikt en månad, ta listan som används "allActivityRowsForSpecificMonth"
    //metoden hanterar den listan (för en månad eller XDays) och tar fram totala tiden alla kategorier körts

    public static void totalForActivity (List<ActivityRow> oneList) {
        long j;
        totalTimeOfEveryting = 0;

        //For loopen gör så att man kan gå igenom alla objekt från en månad
        for (int i = 0; i < oneList.size(); i++){
            //Hämtar kategorinamnet från alla objekt i listan
            String categoryName = oneList.get(i).getCategoryName();

            System.out.println("categpryname totalforactivity --> " + categoryName);

            //Hämtar indexet som kategorin ligger på.

            long totalTimeOfActivity = Long.valueOf(takeAwayFirstZeros(oneList.get(i).getTotalTime()));

            //Lägger till kategorinmanet i listan, om det ej finns i listan för att kunna jämföra med totaltiden av en kategori.
            if (!(totalOfCategoryList.contains(categoryName))) {

                totalOfCategoryList.add(categoryName);
                totalTimeList.add(totalOfCategoryList.indexOf(categoryName),totalTimeOfActivity);

            }
            else {
                int indexOfCategory = totalOfCategoryList.indexOf(categoryName);
                incActivityTotalTime(indexOfCategory, totalTimeOfActivity, totalTimeList.get(indexOfCategory));
            }
            System.out.println("index of v´categopry --> " + totalOfCategoryList.indexOf(categoryName));
//Hämtar den totala tiden just detta objekt la ner på just denna kategori
            System.out.println(" vad blir totalTimeList.get(indexOfCategory) --> " + totalTimeList.get(totalOfCategoryList.indexOf(categoryName)));

            totalTimeOfEveryting = totalTimeOfEveryting + oldTimeOfActivity;
            //Varje kategori har utförts en visstid(totalTime). Denna tid måste läggas till i listan som sparar den totala tiden.
            //Hämtar den totala tiden som redan ligger i listan som hanterar total tiden
            System.out.println("totalTimeList size in inc " + totalTimeList);

        }
    }
     static long oldTimeOfActivity = 0;

    static void incActivityTotalTime (int indexOfCategory, long totalTimeOfActivity, long oldTime) {
        //Läggger ihop tiden som redan låg i listan med den "nya" för objektet
        totalTimeOfActivity = totalTimeOfActivity + oldTime;
        System.out.println("totaltimeOfActivity " + totalTimeOfActivity);
        //Lägger till den ökade totaltiden i listan som innehåller total tider.
        totalTimeList.remove(indexOfCategory);
        totalTimeList.add(indexOfCategory, totalTimeOfActivity);

        oldTimeOfActivity = totalTimeOfActivity;
    }

    public void everythingfromspecifikday () {
        giveValues();

        //sparar alla datum som finns på den förvalda månaden och skall sedan kunna dispalaya dessa i en lista av något slag.
        List<ActivityRow> saveAllActivityForADay = new ArrayList<>();

        for(int i= 0; i < userActivityList.size(); i++ ){
            //saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber); <-- kollar vilka som stämmer överrens med månaden.
            if (userActivityList.get(i).getMonth().equals(monthInNumber)) {
                //om månaden och dagen numberOfDay...
                if(userActivityList.get(i).getDay().equals(numberOfDay)){
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
    */
}