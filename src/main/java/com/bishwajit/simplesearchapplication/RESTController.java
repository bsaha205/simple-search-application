package com.bishwajit.simplesearchapplication;
import com.bishwajit.simplesearchapplication.developer.Developer;
import com.bishwajit.simplesearchapplication.developer.DeveloperRepository;
import com.bishwajit.simplesearchapplication.interview.Interview;
import com.bishwajit.simplesearchapplication.interview.InterviewRepository;
import com.bishwajit.simplesearchapplication.language.Language;
import com.bishwajit.simplesearchapplication.language.LanguageRepository;
import com.bishwajit.simplesearchapplication.programminglanguage.ProgrammingLanguage;
import com.bishwajit.simplesearchapplication.programminglanguage.ProgrammingLanguageRepository;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.*;

@RestController
@RequestMapping(value = "")
public class RESTController {
    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    private InterviewRepository interviewRepository;


    @Autowired
    private DAO dao;

    @Autowired

    @RequestMapping(value="/alldev",method = RequestMethod.GET)
    public List<Developer> getAllDev(){
        return developerRepository.findAll();
    }

    @RequestMapping(value="/alll",method = RequestMethod.GET)
    public List<Language> getAllL(){
        return languageRepository.findAll();
    }

    @RequestMapping(value="/allp",method = RequestMethod.GET)
    public List<ProgrammingLanguage> getAllP(){
        return programmingLanguageRepository.findAll();
    }


    @RequestMapping(value="/allpna",method = RequestMethod.GET)
    public List<Table> getAllPna(){
        List<ProgrammingLanguage> programmingLanguageEntities =  programmingLanguageRepository.findAll();
        List<ProgrammingLanguage> programmingLanguageEntities1 = new ArrayList<>();
        List<Table> tableList = new ArrayList<>();


        for(int i=0;i<programmingLanguageEntities.size();i++){
            if(programmingLanguageEntities.get(i).getDeveloperEntitiesP().size() == 0){
                programmingLanguageEntities1.add(programmingLanguageEntities.get(i));
                Table table = new Table();
                table.setProgrammingLanguage(programmingLanguageEntities.get(i).getName());
                table.setLanguage("");
                table.setEmail("");
                tableList.add(table);
            }
        }
        return tableList;
    }


    //get email list
    @RequestMapping(value="/getemaillist/{lang}",method = RequestMethod.GET)
    public ArrayList<String> getemaillist(@PathVariable String lang){
        List<Developer> developerEntities =  developerRepository.findByEmailLike("%"+lang+"%");
        ArrayList<String> emails = new ArrayList<>();
        for(int i=0;i<developerEntities.size();i++){
            emails.add(developerEntities.get(i).getEmail());
        }

        return emails;
    }
    //get programming language list
    @RequestMapping(value="/getprogramminglanguagelist/{lang}",method = RequestMethod.GET)
    public ArrayList<String> getprogramminglanguagelist(@PathVariable String lang){
        List<ProgrammingLanguage> programmingLanguageEntities =  programmingLanguageRepository.findByNameLike("%"+lang+"%");
        ArrayList<String> codes = new ArrayList<>();
        for(int i=0;i<programmingLanguageEntities.size();i++){
            codes.add(programmingLanguageEntities.get(i).getName());
        }

        return codes;
    }
    //get language list
    @RequestMapping(value="/getlanguagelist/{lang}",method = RequestMethod.GET)
    public ArrayList<String> getlanguagelist(@PathVariable String lang){
        List<Language> developerEntities =  languageRepository.findByCodeLike("%"+lang+"%");
        ArrayList<String> codes = new ArrayList<>();
        for(int i=0;i<developerEntities.size();i++){
            codes.add(developerEntities.get(i).getCode());
        }

        return codes;
    }



    //search by programminglanguage
    @RequestMapping(value="/searchp",method = RequestMethod.GET)
    public  List<Object[]> searchByP(){
        List<Object[]> rows = dao.searchByProgrammingLanguage("en");
        return rows;
    }
    @RequestMapping(value="/searchp/{lang}",method = RequestMethod.GET)
    public  List<Object[]> searchByL(@PathVariable String lang){
        List<Object[]> rows = dao.searchByProgrammingLanguage(lang);
        return rows;
    }

    //search by programming language
    @RequestMapping(value="/searchpl/{lang}",method = RequestMethod.GET)
    public  List<Table>  searchBypl(@PathVariable String lang){
        List<Object[]> rows = dao.searchByProgrammingLanguage(lang);
        List<Table> tables = new ArrayList<>();
        for(Object[] row: rows){
            Table table = new Table();
            table.setEmail(row[1]!=null?(String)row[1]:"");
            BigInteger bigInteger = (BigInteger)row[0];
            table.setUserId(bigInteger.longValue());
            table.setLanguage((String) row[2]!=null?(String)row[2]:"");
            table.setProgrammingLanguage((String) row[3]!=null?(String)row[3]:"");
            tables.add(table);
        }
        return tables;
    }


    public class CustomComparator implements Comparator<Table> {
        @Override
        public int compare(Table o1, Table o2) {
            return o1.getEmail().compareTo(o2.getEmail());
        }
    }

    @RequestMapping(value="/searchall",method = RequestMethod.GET)
    public  List<Table> searchall(){
        List<Object[]> rows = dao.search_data("","","");
        List<Table> tables = new ArrayList<>();
        for(Object[] row: rows){
            Table table = new Table();
            table.setEmail(row[1]!=null?(String)row[1]:"");
            BigInteger bigInteger = (BigInteger)row[0];
            table.setUserId(bigInteger.longValue());
            table.setLanguage((String) row[2]!=null?(String)row[2]:"");
            table.setProgrammingLanguage((String) row[3]!=null?(String)row[3]:"");
            tables.add(table);

        }
        Collections.sort(tables,new CustomComparator());
        ArrayList<Table> newtables = new ArrayList<>();
        Table previousTable = tables.get(0);
        newtables.add(previousTable);
        for(int i=1;i<tables.size();i++){
            Table t = tables.get(i);
            if(t.getEmail().equals(previousTable.getEmail())){
                if(previousTable.getLanguage().indexOf(t.getLanguage())==-1)previousTable.setLanguage(previousTable.getLanguage() + ", " + t.getLanguage());
                if(previousTable.getProgrammingLanguage().indexOf(t.getProgrammingLanguage())==-1)previousTable.setProgrammingLanguage(previousTable.getProgrammingLanguage() + ", " + t.getProgrammingLanguage());
                continue;
            }
            previousTable = t;
            newtables.add(previousTable);
            System.out.println(i + "--> " + t.toString());
        }
        return newtables;
    }

    @RequestMapping(value="/searchalldata",method = RequestMethod.POST)
    public  List<Table> searchallData(@RequestBody JSONObject data){

        System.out.println(data);
        LinkedHashMap<String,String> linkedHashMap = (LinkedHashMap<String, String>) data.get("data");
        System.out.println(linkedHashMap);

        String name = linkedHashMap.get("name");
        String email = linkedHashMap.get("email");
        String code = linkedHashMap.get("code");



        List<Object[]> rows = dao.search(name ,code,email);
//        System.out.println("==========");
//        return programmingLanguageRepository.findAll();
        List<Table> tables = new ArrayList<>();
        for(Object[] row: rows){
            Table table = new Table();
//str!=null && str.equals("hi") (String)
            table.setEmail(row[1]!=null?(String)row[1]:"");
            BigInteger bigInteger = (BigInteger)row[0];
            table.setUserId(bigInteger.longValue());
//            table.setUserId((Long) row[0]!=null?(Long)row[0]:-1);
            table.setLanguage((String) row[2]!=null?(String)row[2]:"");
            table.setProgrammingLanguage((String) row[3]!=null?(String)row[3]:"");
            tables.add(table);

        }


        Collections.sort(tables,new CustomComparator());

        ArrayList<Table> newtables = new ArrayList<>();
        Table previousTable =  new Table();
        if(tables.size()>0)previousTable  = tables.get(0);
        newtables.add(previousTable);


        for(int i=1;i<tables.size();i++){
            Table t = tables.get(i);
            if(t.getEmail().equals(previousTable.getEmail())){
                if(previousTable.getLanguage().indexOf(t.getLanguage())==-1)previousTable.setLanguage(previousTable.getLanguage() + ", " + t.getLanguage());
                if(previousTable.getProgrammingLanguage().indexOf(t.getProgrammingLanguage())==-1)previousTable.setProgrammingLanguage(previousTable.getProgrammingLanguage() + ", " + t.getProgrammingLanguage());
//                tables.remove(t);
                continue;
            }
            previousTable = t;
            newtables.add(previousTable);
            System.out.println(i + "--> " + t.toString());
        }
        System.out.println("==========");
//        tables.remove(table);
//        tables.remove(table);
        for(Table t: newtables){
            System.out.println("NEW-" + t.toString());
        }


        return newtables;




//        return tables;
    }


        @RequestMapping(value="/searchAllData",method = RequestMethod.POST)
        public  List<Table> searchAllData(@RequestBody JSONObject data){

            System.out.println(data);
            LinkedHashMap<String,String> linkedHashMap = (LinkedHashMap<String, String>) data.get("data");
            System.out.println(linkedHashMap);

            String firstPLanguage = linkedHashMap.get("firstPLanguage");
            String secondPLanguage = linkedHashMap.get("secondPLanguage");
            String code = linkedHashMap.get("code");



            List<Object[]>  rows = dao.search_data(firstPLanguage ,secondPLanguage,code);
//        System.out.println("==========");
//        return programmingLanguageRepository.findAll();
            List<Table> tables = new ArrayList<>();
            for(Object[] row: rows){
                Table table = new Table();
//str!=null && str.equals("hi") (String)
                table.setEmail(row[1]!=null?(String)row[1]:"");
                BigInteger bigInteger = (BigInteger)row[0];
                table.setUserId(bigInteger.longValue());
//            table.setUserId((Long) row[0]!=null?(Long)row[0]:-1);
                table.setLanguage((String) row[2]!=null?(String)row[2]:"");
                table.setProgrammingLanguage((String) row[3]!=null?(String)row[3]:"");
                tables.add(table);

            }


            Collections.sort(tables,new CustomComparator());

            ArrayList<Table> newtables = new ArrayList<>();
            Table previousTable =  new Table();
            if(tables.size()>0)previousTable  = tables.get(0);
            newtables.add(previousTable);


            for(int i=1;i<tables.size();i++){
                Table t = tables.get(i);
                if(t.getEmail().equals(previousTable.getEmail())){
                    if(previousTable.getLanguage().indexOf(t.getLanguage())==-1)previousTable.setLanguage(previousTable.getLanguage() + ", " + t.getLanguage());
                    if(previousTable.getProgrammingLanguage().indexOf(t.getProgrammingLanguage())==-1)previousTable.setProgrammingLanguage(previousTable.getProgrammingLanguage() + ", " + t.getProgrammingLanguage());
//                tables.remove(t);
                    continue;
                }
                previousTable = t;
                newtables.add(previousTable);
                System.out.println(i + "--> " + t.toString());
            }
            System.out.println("==========");
//        tables.remove(table);
//        tables.remove(table);
            for(Table t: newtables){
                System.out.println("NEW-" + t.toString());
            }


            return newtables;




//        return tables;
        }


    /*all api related to interview */

    @RequestMapping(value="/createinterview", method=RequestMethod.POST)
    public List<Interview> createinterview(@RequestBody JSONObject data){
        String score = (String)data.get("score");
        String comment = (String)data.get("comment");
        interviewRepository.save(new Interview(score,comment));
        return interviewRepository.findAll();

    }

    @RequestMapping(value="/deleteinterview/{id}", method = RequestMethod.GET)
    public List<Interview> deleteinterview(@PathVariable long id){
        interviewRepository.delete(interviewRepository.getOne(id));
        return interviewRepository.findAll();
    }
    @RequestMapping(value="/getinterview", method=RequestMethod.GET)
    public List<Interview> getallinterviews(){
        return interviewRepository.findAll();
    }
    @RequestMapping(value="/updateinterview", method=RequestMethod.POST)
    public List<Interview> updateinterview(@RequestBody JSONObject data){
        LinkedHashMap<String,String> linkedHashMap = (LinkedHashMap<String, String>) data.get("data");
        Integer intId = (Integer)data.get("id");
        long id = new Long(intId);
        String score =(String) data.get("score");
        String comment =(String) data.get("comment");
        Interview interview1 = interviewRepository.getOne(id);
        interview1.setScore(score);
        interview1.setComment(comment);
        interview1.setId(id);

        interviewRepository.deleteById(id);
        interviewRepository.save(interview1);
        return interviewRepository.findAll();
    }
    /*end all api related to interview */

    /*all api related to developer */


    @RequestMapping(value="/createdeveloper", method=RequestMethod.POST)
    public List<Developer> createdeveloper(@RequestBody JSONObject data){
        String email = (String)data.get("email");
        developerRepository.save(new Developer(email));
        return developerRepository.findByEmailLike(email);

    }

    @RequestMapping(value="/deletedeveloper/{id}", method = RequestMethod.GET)
    public List<Developer> deletedev(@PathVariable long id){
        Developer developer = developerRepository.getOne(id);

        List<ProgrammingLanguage> pe = developer.getProgrammingLanguageEntities();
        for(int i=0;i<pe.size();i++){
            ProgrammingLanguage p = pe.get(i);
            p.getDeveloperEntitiesP().clear();
            programmingLanguageRepository.save(p);
        }
        developer.getProgrammingLanguageEntities().clear();
        developer.getLanguageEntities().clear();
        developerRepository.save(developer);
        developerRepository.delete(developerRepository.getOne(id));
        return developerRepository.findAll();
    }
    @RequestMapping(value="/getdeveloperbyemail/{email}",method = RequestMethod.GET)
    public List<Developer> getDeveloperByEmailAddress(@PathVariable String email){
        List<Developer> developerEntities =  developerRepository.findByEmailLike("%"+email+"%");
      return developerEntities;
    }
    @RequestMapping(value="/getalldeveloper", method=RequestMethod.GET)
    public List<Developer> getalldev(){
        return developerRepository.findAll();
    }
    @RequestMapping(value="/getdeveloperbyid/{id}", method=RequestMethod.GET)
    public Developer getdeveloperbyid(@PathVariable long id){
       /* return developerRepository.findById(id);*/
       return null;
    }

    @RequestMapping(value="/updatedeveloper", method=RequestMethod.PUT)
    public List<Developer> updatedeveloper(@RequestBody JSONObject data){
        LinkedHashMap<String,String> linkedHashMap = (LinkedHashMap<String, String>) data.get("data");
        Integer intId = (Integer)data.get("id");
        long id = new Long(intId);
        String name =(String) data.get("email");
        Developer developer1 = developerRepository.getOne(id);
        developer1.setEmail(name);
        developer1.setId(id);
        developerRepository.save(developer1);
        return developerRepository.findByEmailLike(name);
    }


    /*end all api related to interview */



}
