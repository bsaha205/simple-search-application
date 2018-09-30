package com.bishwajit.simplesearchapplication;

import com.bishwajit.simplesearchapplication.developer.Developer;
import com.bishwajit.simplesearchapplication.developer.DeveloperRepository;
import com.bishwajit.simplesearchapplication.interview.Interview;
import com.bishwajit.simplesearchapplication.interview.InterviewRepository;
import com.bishwajit.simplesearchapplication.language.Language;
import com.bishwajit.simplesearchapplication.language.LanguageRepository;
import com.bishwajit.simplesearchapplication.programminglanguage.ProgrammingLanguage;
import com.bishwajit.simplesearchapplication.programminglanguage.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private DeveloperRepository developerRepository;

    private LanguageRepository languageRepository;

    private ProgrammingLanguageRepository programmingLanguageRepository;

    private InterviewRepository interviewRepository;

    @Autowired
    public DatabaseSeeder(
                          DeveloperRepository developerRepository,
                          LanguageRepository languageRepository,
                          ProgrammingLanguageRepository programmingLanguageRepository,
                          InterviewRepository interviewRepository

    ){
        this.developerRepository = developerRepository;
        this.languageRepository = languageRepository;
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.interviewRepository = interviewRepository;

    }



    @Override
    public void run(String... args) throws Exception {
        List<Interview> interviewEntities = new ArrayList<>();
        interviewEntities.add(new Interview("5","No comment"));
        interviewEntities.add(new Interview("3","Comment Plz"));
        interviewEntities.add(new Interview("4","No special comment"));
        interviewEntities.add(new Interview("1","No doubt"));

        interviewRepository.saveAll(interviewEntities);

        List<Language> languageEntities  = new ArrayList<>();
        List<ProgrammingLanguage> programmingLanguageEntities = new ArrayList<>();
        List<Developer> developerEntities = new ArrayList<>();


        for(int i=0;i<locales.length;i++){
            languageEntities.add(new Language(locales[i].toLowerCase()));
        }

        for(int i=0;i<emailList.length;i++){
            developerEntities.add(new Developer(emailList[i]));
        }
        for(int i=0;i<programmingLanguages.length;i++){
            programmingLanguageEntities.add(new ProgrammingLanguage(programmingLanguages[i]));
        }
        Random rand = new Random();

        for(int i=0;i<developerEntities.size();i++) {

            int a = rand.nextInt(programmingLanguageEntities.size());
            int b = rand.nextInt(programmingLanguageEntities.size());
            int max = Math.max(a,b);
            int min = Math.min(a,b);

            int la = rand.nextInt(languageEntities.size());
            int lb = rand.nextInt(languageEntities.size());
            int maxla = Math.max(la,lb);
            int minla = Math.min(la,lb);

            developerEntities.get(i).setProgrammingLanguageEntities(programmingLanguageEntities.subList(min, max));
            developerEntities.get(i).setLanguageEntities(languageEntities.subList(maxla-5>0?maxla-rand.nextInt(5):0, maxla));



        }

        for(int i=0;i<programmingLanguageEntities.size();i++){
            int a = rand.nextInt(developerEntities.size());
            int b = rand.nextInt(developerEntities.size());
            int max = Math.max(a,b);
            int min = Math.min(a,b);
            if(i%4!=0)programmingLanguageEntities.get(i).setDeveloperEntitiesP(developerEntities.subList(min,max));
        }

        developerRepository.saveAll(developerEntities);
      programmingLanguageRepository.saveAll(programmingLanguageEntities);

      ProgrammingLanguage p1 = new ProgrammingLanguage("LISP");
      ProgrammingLanguage p2 = new ProgrammingLanguage("LUA");
      ProgrammingLanguage p3 = new ProgrammingLanguage("COBOL");
      ProgrammingLanguage p4 = new ProgrammingLanguage("ruby");
      ProgrammingLanguage p5 = new ProgrammingLanguage("Javascript");
      List<ProgrammingLanguage> programmingLanguageEntities1 =  new ArrayList<>();
      programmingLanguageEntities1.add(p1);
      programmingLanguageEntities1.add(p2);
      programmingLanguageEntities1.add(p3);
      programmingLanguageEntities1.add(p4);
      programmingLanguageEntities1.add(p5);
      programmingLanguageRepository.saveAll(programmingLanguageEntities1);
    }
    protected String getSaltString(int size) {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < size) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public String[] programmingLanguages = {"ajax","CSS","ATS","JAVA","C","C++","ruby","Javascript","JS","C#",


            "chomski","ObjectLOGO","AutoHotkey","Object Pascal","Babbage","Objective-J","PHP","AngelScript","occam",
            "Transcript","TTCN","Turing","TUTOR","TXL"};

    String[] locales = Locale.getISOCountries();
    String[] emailList = {"tech@rigginglifting.com","aftersale@rigginglifting.com","dbishop103@darlenebishop.com","thaisgp@singnet.com.sg","sharmadeep007@gmail.com","steve@dlendinggroup.com","webmitress@verysinful.com","info@thefloridadesigngroup.com","mtl@mtlgroup.com","careers@thefloridadesigngroup.com","info@sagedesigngroup.com","news@mashable.com","advertising@mashable.com","events@mashable.com","bizdev@mashable.com","jobs@mashable.com","contact@mashable.com","links@management-advantage.com","scouden@pacbell.net","info@management-advantage.com","directory@zeen.com","design@homeplangroup.com","information@asrec.co.uk","sales@audiobuys.net","info@expeditemg.com","legal@sutletgroup.com","accounting@sutletgroup.com","promotion@sutletgroup.com","trading@sutletgroup.com","assistance@veteranlove.com","toni@veteranlove.com","charlene@veteranlove.com","craig@veteranlove.com","jonathan@veteranlove.com","dan@veteranlove.com","mario@veteranlove.com,info@justnorth.com","garlandofroses@gmail.com","sales@linkbuildingsolution.com","superman577373@yahoo.com","jpfellwock@yahoo.com","pattimace@sbcglobal.net","sales@websource.co.in","sales@websourceeurope.com,sales@websourcepacific.com","sales@websourceasia.com.sg","rohit.z.ghosh@something.com","jack.z.welsh@something.com","dan.z.gaul@something.com","marc.h.bricman@something.com","sally.m.fields@something.com","fred_g_manning@something.com","susan.kayman@something.com","susana.virginis@something.com","gale_t_richards@something.com","steve0rourke@something.com","briggs@something.com","wiley.p.reddington@something.com","amy.n.roy@something.com","ebusinessindya@gmail.com","noreply@trendmicro.com","bizzebee_xp@yahoo.com","net@websource.co.in","sse@websource.co.in","swd@websource.co.in","jobs@websource.co.in","info@rupizxpress.com","mla@mla-india.com","sales@johnsplace.com","jack69business@gmail.com","alexwong10@hotmail.com","annitse@hotmail.com","caleb_calcar@hotmail.com","bwn_0964@hotmail.com","brendan_7667@hotmail.com","blurboy5391@hotmail.com","bestfriendsforever_1997@hotmail.com","chatty324@hotmail.com","footprint_starpint@hotmail.com","fiona_lee_92@hotmail.com","felicia_zhiling@hotmail.com","goodbyesucker@msn.com","gemini_girl_hihi@hotmail.com","i_rawkforeva@hotmail.com","hollywoodstreet_1981@hotmail.com","hiroshima_akawashi@hotmail.com","hidayah_billabong@hotmail.com","leafz19@hotmail.com","kimyan007@hotmail.com","ngbionicle@hotmail.com","masterdon2002@hotmail.com","mad_halo@hotmail.com","smileyy_jan@hotmail.com","ridhwan_5@hotmail.com","rainsnow@myself.com","tin_443@hotmail.com","thy_93@hotmail.com","teoxm91@hotmail.com","yh_musicunlimited4life@hotmail.com","yrnchan@hotmail.com","baoyue_8@hotmail.com","a_afiqah_mj@hotmail.com","sweetichickz@hotmail.com","amalina_rawk_76@hotmail.com","hazyrah@hotmail.com","ifarisha@hotmail.com","kohrongyipamela@hotmail.com","koolkitty_1997@msn.com","lizzie_mcguire_acnes@hotmail.com","maythae@hotmail.com","miragomez_95@hotmail.com","roxy_girl79@hotmail.com","adahuys95@hotmail.com","andyqa_95@hotmail.com","coolhaz_96@hotmail.com","cybergirl_v1997@hotmail.com","fortytwo_test5@hotmail.com","hairul_blueice21@hotmail.com","ifarisha@hotmail.com","rani_cuties.fah@hotmail.com","k_rina97@hotmail.com","nur_love27@hotmail.com","iduncare_11@hotmail.com","koolkitty_1997@msn.com","maythae@hotmail.com","mhb9523@hotmail.com","miza626@hotmail.com","mysteryguy_unknown007@hotmail.com","nicole_wpw@hotmail.com","kohrongyipamela@hotmail.com","a_afiqah_mj@hotmail.com","afiq_crazy@hotmail.com","amalina_rawk_76@hotmail.com","andyqa_95@hotmail.com","un_atren@hotmail.com","bmbpgirl@hotmail.com","boi_boi95@hotmail.com","danial_liverpool@hotmail.com","danish_syafiq@hotmail.com","earth_girl_rule@hotmail.com","elitefighter_10@hotmail.com","hamster_gurl95@hotmail.com","hard_tu_understand@hotmail.com","myrah_diamond17@hotmail.com","kacheek_95@hotmail.com","white_butterflywings@hotmail.com","realitygerl22@hotmail.com","relitygirl@hotmail.com","serene041094@hotmail.com","siti_sharmila08@hotmail.com","xiiaobabyyboii@hotmail.com","xiiaonana-@hotmail.com","singapore_7@hotmail.com","korea_rox_johnnybravo@hotmail.com","staryyskyy_craziieboutyuu@hotmail.com","music_rocks_life@hotmail.com","littlekitty1995@hotmail.com","liliumangel@hotmail.com","baby-felicia@hotmail.com","luck_angel579@hotmail.com","andrea_starlight@hotmail.com","joeywengshuyi@hotmail.com"};


}
