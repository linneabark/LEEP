package edu.chl.leep.model;

import com.example.linneabark.test.StatisticsActivityAdapter;
import com.example.linneabark.test.StatisticsDateAdapter;
import com.example.linneabark.test.StatisticsMonthAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.chl.leep.service.SaveActivity;
import edu.chl.leep.utils.FindWhichMonth;
import edu.chl.leep.utils.ConvertUtils;

/**
 * Created by Evelinas on 2017-05-26.
 */

public class StatisticsModel {

    static long totalTimeOfEveryting;

    StatisticsMonthAdapter statisticsMonthAdapter;
    StatisticsDateAdapter statisticsDateAdapter;

    //funkar på andra ställen.
    public static String takeAwayFirstZeros (String string) {
        string = string.replaceFirst("^0+(?!$)", "");
        return string;
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

    String monthInNumber;// = statisticsMonthAdapter.getMonthOfBtn();
    //String numberOfDay = statisticsDateAdapter.getDateOfBtn();
    String numberOfDay;// = dateBtn;

    //Vill kunna läsa av de två första, alltså t.ex. "01"
    String firstDayOfMore;// = textDays.getText().substring(0,2);
    //vill kunna läsa av de sista datumet. Illustrerigsförslag "01-05". Kolla så att den börjar rätt, med 3.
    String lastDayOfMore;// = textDays.getText().substring(3);

    private List <ActivityRow> defaultStatisticList = new ArrayList<>();
    //listan för specifik user.
    private static List<ActivityRow> userActivityList = SaveActivity.activityRowList;
    //sparar alla datum som finns på den förvalda månaden och skall sedan kunna dispalaya dessa i en lista av något slag.
    private List<String> allDaysForSpecificMonth = new ArrayList<>();
    //sparar alla aktiviteter från en specifik månad.
    private static List <ActivityRow> allActivityRowsForSpecificMonth = new ArrayList<>();

    // en lista för att spara alla olika kategrier som använts
    private static List<String> totalOfCategoryList = new ArrayList<>();
    //En lista för att spara all sammanlagd tid för en kategori.
    private static List<Long> totalTimeList = new ArrayList<>();

    public static List<String> getTotalOfCategoryList () {
        return totalOfCategoryList;
    }

    public List<Long> getTotalTimeList () {
        return totalTimeList;
    }

    public List<ActivityRow> getDefaultStatisticList () {
        return defaultStatisticList;
    }

    public List<ActivityRow> getUserActivityList () {
        return userActivityList;
    }



    public List <String> reformListToDisplay () {
        System.out.println("reformListToDisplay SM");
        //addFirstListToCheck();
        giveValuesToDefaultStatisticList();
        List<String>listToDisplay = new ArrayList<>();

        for(int i = 0; i < defaultStatisticList.size(); i++) {
            long stopTime = Long.valueOf(takeAwayFirstZeros(defaultStatisticList.get(i).getStartTime()))
                    + Long.valueOf(takeAwayFirstZeros(defaultStatisticList.get(i).getTotalTime()));
            String s = defaultStatisticList.get(i).getCategoryName() + "    " + defaultStatisticList.get(i).getStartTime() + " - " + stopTime;
            listToDisplay.add(s);
        }
        return listToDisplay;
    }
/*
    public void addFirstListToCheck(){
        System.out.println("---------------------------------------------------------------------------------------------------går in i addFristListToCheck");

        System.out.println("userActivityList size innan add: " + userActivityList.size());
        //ActivityRow (String userName, String year, String month, String day, String startTime, String totalTime, String categoryName)
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "09", "0990", "1000", "Föreläsning"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "04", "08", "0990", "1000", "sov"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "04", "08", "0990", "1000", "sov"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "04", "08", "0990", "1000", "sov"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "04", "08", "0990", "1000", "sov"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "04", "08", "0990", "1000", "sov"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "04", "08", "0990", "1000", "sov"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "09", "0990", "1000", "plugg"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "09", "0990", "1000", "plugg"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "09", "0990", "1000", "plugg"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "09", "0990", "1000", "plugg"));
        userActivityList.add(new ActivityRow("Evelina", "1997", "05", "09", "0990", "1000", "mat"));

        System.out.println("userActivityList size efter add: " + userActivityList.size() );
    }
*/

/*
    //tar den sparade listan och lägger in allt som sparats i en ny lista för den specifika usern.
    public void getAllSavedActivitysForUser () {
        System.out.println("getAllSavedActivitysForUser SM");
        //Hämta den sparade listan i textFilen. vi antar att det är raden nedanför..
        List<ActivityRow> allActivitysForAllUsers = new ArrayList<>();

        for (int i = 0; i < allActivitysForAllUsers.size(); i++) {
            // --------------------------------------------------------------------------------------------------------------Leep.getUSER() eller AccountDetails?????
            if (Leep.getUSER().equals(allActivitysForAllUsers.get(i).getUserName())) {
                userActivityList.add(allActivitysForAllUsers.get(i));
            }
        }
    }
    */

     public List<ActivityRow> giveValuesToDefaultStatisticList () {
        System.out.println("giveValuesToDefaultStatisticList SM");
        int year = 0;
        int month = 0;
        int day = 0;

        System.out.println("userActivityList i giveValuesToDefaultStatisticsList : listans size --> " + userActivityList.size());

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

        System.out.println("default StatisticList --> size  = "+defaultStatisticList.size());
        return defaultStatisticList;
    }


    //vi börjar med day. när man väljer dag under statistic.
    //då är en månad vald och då skall endast dagarna som månaden är kunna väljas.
/*
    public List<String> getAllDays (StatisticsMonthAdapter sMA) {

        int intMonth= FindWhichMonth.numberOfMonth(monthBtn);

        System.out.println("Klass statistics, metod getAllDays. Värde på månad som trycks på " + intMonth);

        for(int i= 0; i < userActivityList.size(); i++ ){
            //saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber); <-- kollar vilka som stämmer överrens med månaden.
            if (Integer.valueOf(takeAwayFirstZeros(userActivityList.get(i).getMonth())) == intMonth) {
                //lägger till alla datum som loggats under en månad.
                allDaysForSpecificMonth.add(userActivityList.get(i).getDay());
            }
        }
        return allDaysForSpecificMonth;
    }*/

 /*   public void findAllDaysForSpecificMonth() {

        for(int i= 0; i < userActivityList.size(); i++ ){
            //saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber); <-- kollar vilka som stämmer överrens med månaden.
            if (userActivityList.get(i).getMonth().equals(monthInNumber)) {
                //lägger till alla datum som loggats under en månad.
                allDaysForSpecificMonth.add(userActivityList.get(i).getDay());
                //sägger till alla aktiviteter som funnits under en månad.
                allActivityRowsForSpecificMonth.add(userActivityList.get(i));
            }
        }
    }*/


    //en metod som lägger till alla olika aktiviteter som har använts i en String list. och all sammanlagd tid i en Long list.
    //Så ett index i ena listan hör ihop med samma index i den andra listan.

    //För specifikt en månad, ta listan som används "allActivityRowsForSpecificMonth"
    //metoden hanterar den listan (för en månad eller XDays) och tar fram totala tiden alla kategorier körts
    /*

     äldre version, från början.
    public static void totalForActivity (List<ActivityRow> oneList) {

        //en lista för att spara alla olika kategrier som använts
        List<String> totalOfCategoryList = new ArrayList<>();
        //En lista för att spara all sammanlagd tid för en kategori.
        List<Long> totalTimeList = new ArrayList<>();

        //For loopen gör så att man kan gå igenom alla objekt från en månad
        for (int i = 0; i < oneList.size(); i++){
            //Hämtar kategorinamnet från alla objekt i listan
            String categoryName = oneList.get(i).getCategoryName();

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
            long totalTimeOfActivity = Integer.valueOf(takeAwayFirstZeros(oneList.get(i).getTotalTime()));
            //Läggger ihop tiden som redan låg i listan med den "nya" för objektet
            totalTimeOfActivity = totalTimeOfActivity + j;
            //Lägger till den ökade totaltiden i listan som innehåller total tider.
            totalTimeList.add(indexOfCategory, totalTimeOfActivity);
        }
    }

*/

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




  /*  public void everythingfromspecifikday () {

        //sparar alla datum som finns på den förvalda månaden och skall sedan kunna dispalaya dessa i en lista av något slag.
        List<ActivityRow> saveAllActivityForADay = new ArrayList<>();

        for(int i= 0; i < userActivityList.size(); i++ ){
            //saveActivity.activityRowList.get(i).getMonth().equals(monthInNumber); <-- kollar vilka som stämmer överrens med månaden.
            if (userActivityList.get(i).getMonth().equals(monthInNumber)) {
                //om månaden och dagen numberOfDay...
                if(userActivityList.get(i).getDay().equals(numberOfDay)){
                    //sparar den specifikt valda dagen i en lista för att illustrera dagen i progress sedan
                    saveAllActivityForADay.add(userActivityList.get(i));
                }
            }
        }
    }*/
/*
    //en metod som ser till att alla dagar läggs till i listan.
    private boolean continueTo (int i) {
        if (userActivityList.get(i).getDay().equals(lastDayOfMore)) {
            return false;
        }
        return true;
    }
    //denna metoden lägger till alla dagarna som är valda i en lista. denna listan visar endast loggade dagar..
    //Ur denna listan kan man få ut all tid som en aktivitet fått tillägnad.
    public void everythingFromXDays () {
        //en bugg, detta kommer bara funka om man ej tar X dagar är på olika månader.

        List<ActivityRow> saveTotalTimeForXDays = new ArrayList();

        //går igenom aktivitets listan och hämtar de valda dagarna.
        for(int i= 0; i < userActivityList.size(); i++) {
            //kollar så att månaden som är förvald stämmer.
            if (userActivityList.get(i).getMonth().equals(monthInNumber)) {
                //om objeketet i activitetslistan är det samma som dagen vi vill kolla ifrån då läggs den till i listan.
                if(userActivityList.get(i).getDay().equals(firstDayOfMore)) {
                    int k = i;
                    //while loopen lägger till förtsa och dagarna efter tills det att man kommer till den näst sista dagen.
                    while (continueTo(k)){
                        saveTotalTimeForXDays.add(userActivityList.get(k));
                        k++;
                    }
                    System.out.println("vad har k för värde efter while loopen i classen Statistics: " + k);
                }
                //lägger till den sista dagen av flera i listan.
                else if (userActivityList.get(i).getDay().equals(lastDayOfMore)) {
                    saveTotalTimeForXDays.add(userActivityList.get(i));
                }
            }
        }
    }*/

    //behöver en metod som kolalr vilken månad det är och sedan tar fram alla dagar som finns i denna.
    //vill vi att den skall kolla de 5 lagrade dagarna eller typ 1-5, 2-6 osv och även om man bara lagrat en dag?






    static String dateBtn;
    public void setDateBtn(String dateBtn) {
        this.dateBtn = dateBtn;
    }

    static String monthBtn;
    public void setMonthBtn(String monthBtn) {
        this.monthBtn = monthBtn;
    }


    public static List<String> getAllActivitys (StatisticsActivityAdapter statisticsActivityAdapter) {
        List <String> allActivitys = new ArrayList<>();
        List <ActivityRow> activityRowList = new ArrayList<>();

        System.out.println("Klass statisticsDateAdapter, metod getAllActivitys.");
        int intDate = Integer.valueOf(takeAwayFirstZeros(dateBtn));

        System.out.println("Klass statistics, metod getAllActivitys. Värde på datum som trycks på " + intDate);
        System.out.println("hur stor är listan.. " + userActivityList.size());

        System.out.println("hur stor är allactivityrow... --> " + allActivityRowsForSpecificMonth.size());

        if (whichBtn.equals("btnDay")) {
            for(int i = 0; i < allActivityRowsForSpecificMonth.size(); i++ ) {
                int intDayFromList = Integer.valueOf(takeAwayFirstZeros(allActivityRowsForSpecificMonth.get(i).getDay()));

                if (whichBtn.equals("btnDay")) {
                    if (intDayFromList == intDate) {
                        System.out.println("kommer jag in där vi lägger till i activiterna från en dag i allActivitys?");
                        activityToString(allActivitys, activityRowList, i);
                    }
                }
            }
        } else if (whichBtn.equals("btnMonth")) {
            for(int i= 0; i < allActivityRowsForSpecificMonth.size(); i++ ){
                System.out.println("kommer jag in där vi lägger till i activiterna från en månad i allActivitys?");
                activityToString(allActivitys, activityRowList, i);
            }

            System.out.println("kommer jag previs innan swap list  för månad i statisticsDAteMonth?");
            statisticsActivityAdapter.swapList(allActivitys);
        } else  {
            allActivitys.add("Something went wrong with how the activity should be shown");
        }

        totalForActivity(activityRowList);

        System.out.println("Får allActivitys ngt " + allActivitys.size());
        return allActivitys;
    }



    static void activityToString (List <String> allActivitys, List<ActivityRow> activityRowList, int indexFromForLoop){
        ConvertUtils sd = new ConvertUtils();
        long stopTime = Long.valueOf(takeAwayFirstZeros(allActivityRowsForSpecificMonth.get(indexFromForLoop).getStartTime()))
                + Long.valueOf(takeAwayFirstZeros(allActivityRowsForSpecificMonth.get(indexFromForLoop).getTotalTime()));

        String s = allActivityRowsForSpecificMonth.get(indexFromForLoop).getCategoryName()
                + "          " +
                sd.calculateStringToLong(allActivityRowsForSpecificMonth.get(indexFromForLoop).getStartTime()) + " - " + stopTime;

        allActivitys.add(s);

        activityRowList.add(allActivityRowsForSpecificMonth.get(indexFromForLoop));
    }
/*
    //Då whichBtn ej blivit behandlat så är whichBtn per default btnDay , för då är inget valt.
    public static String whichBtn = "btnDay";

    public void whichHowBtn (View v) {
        if (v == btnDay) {
            whichBtn = "btnDay";
        } else if (v == btnMonth) {
            whichBtn = "btnMonth";
        } else {
            whichBtn = "btnDay";
        }

    }*/
    private static String whichBtn = "btnDay";

    public void setWhichBtn (String btn) {
        whichBtn = btn;
    }

    public List<String> getAllDays () {

        int count = 0;
        List <String> allDays = new ArrayList<>();
        System.out.println("Klass statisticsMomthAdapter, metod getAllDays.");
        int intMonth= FindWhichMonth.numberOfMonth(monthBtn);

        System.out.println("Klass statistics, metod getAllDays. Värde på månad som trycks på " + intMonth);
        System.out.println("hur stor är userActivitylistan.. " + userActivityList.size());

        System.out.println();
        for(int i= 0; i < userActivityList.size(); i++ ){

            int intMonthFromList = Integer.valueOf(takeAwayFirstZeros(userActivityList.get(i).getMonth()));
            //int intDayFromList = Integer.valueOf(Statistics.takeAwayFirstZeros(Statistics.userActivityList.get(i).getDay()));
            if (whichBtn.equals("btnDay")) {
                if (intMonthFromList == intMonth) {
                    if(!(allDays.contains(userActivityList.get(i).getDay()))) {
                        //lägger till alla datum som loggats under en månad.
                        System.out.println("kommer jag in där vi lägger till i allDays?");
                        allDays.add(userActivityList.get(i).getDay());
                    }
                    //Bugg. Varje gång man byter månad kommer listan läggast till igen och visas som en dubbellista dör activitertrna visas.
                    allActivityRowsForSpecificMonth.add(userActivityList.get(i));
                    System.out.println("det som läggs till i allactivityrowsforspecificmonth: " + userActivityList.get(i));
                }
            } else if (whichBtn.equals("btnMonth")) {
                //Vill ej ha dagar i den listan just nu. I framtiden ändra till oklickbara knapar.
                if (intMonthFromList == intMonth) {
                    count++;
                    allActivityRowsForSpecificMonth.add(userActivityList.get(i));
                }
            }

        }

        if ((allDays.size() == 0) && (count == 0)){
            allDays.add("No logged days");
        }
        System.out.println("Får allDAys ngt " + allDays.size());
        System.out.println("Får allActivityRowsForSpecificMonth ngt " + allActivityRowsForSpecificMonth.size());

        return allDays;
    }
}
