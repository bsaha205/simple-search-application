package com.bishwajit.simplesearchapplication;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class DAO {
    public List<Object[]> searchByProgrammingLanguage(String name) {
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        String query2=
                "SELECT per.id,\n" +
                        "  per.email,\n" +
                        "  conf.code,\n" +
                        "  pub.name\n" +
                        "FROM Developers AS per\n" +
                        "  LEFT JOIN developers_languages AS pconf\n" +
                        "    ON per.id = pconf.developersid\n" +
                        "  LEFT JOIN languages AS conf\n" +
                        "    ON pconf.languagesid = conf.id\n" +
                        "  LEFT JOIN programming_languages_developers AS ppub\n" +
                        "    ON per.id = ppub.developersid\n" +
                        "  LEFT JOIN programming_languages AS pub\n" +
                        "    ON ppub.programming_languagesid = pub.id\n";
        if(name.length()!=0)query2+= "  where pub.name = :name";
        List<Object[]> rows;
        if(name.length()!=0)rows= s.createSQLQuery(query2).setString("name", name)
                .list();
        else rows = s.createSQLQuery(query2).list();
        tx.commit();
        s.close();
        return rows;
    }

    public List<Object[]> search(String name,String code, String email) {
        if(name!=null && !name.isEmpty()){}else name = null;
        if(code!=null && !code.isEmpty()){}else code= null;
        if(email!=null && !email.isEmpty()){}else email = null;

        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();

        String query2=
                "SELECT per.id,\n" +
                        "  per.email,\n" +
                        "  conf.code,\n" +
                        "  pub.name\n" +
                        "FROM Developers AS per\n" +
                        "  LEFT JOIN developers_languages AS pconf\n" +
                        "    ON per.id = pconf.developersid\n" +
                        "  LEFT JOIN languages AS conf\n" +
                        "    ON pconf.languagesid = conf.id\n" +
                        "  LEFT JOIN programming_languages_developers AS ppub\n" +
                        "    ON per.id = ppub.developersid\n" +
                        "  LEFT JOIN programming_languages AS pub\n" +
                        "    ON ppub.programming_languagesid = pub.id\n"+
                        "  where (:name is null or pub.name = :name )" +
                        " and (:code is null or conf.code = :code )" +
                        " and ( :email is null or per.email = :email) ";

        System.out.println("query2.toString(): " + query2.toString());

        List<Object[]> rows= s.createSQLQuery(query2)
                        .setString("name", name)
                        .setString("code", code)
                        .setString("email",email)
                .list();
        tx.commit();
        s.close();
        return rows;
    }

    public List<Object[]> search_data(String firstPLanguage,String secondPLanguage, String code) {
        if(firstPLanguage!=null && !firstPLanguage.isEmpty()){}else firstPLanguage = null;
        if(code!=null && !code.isEmpty()){}else code= null;
        if(secondPLanguage!=null && !secondPLanguage.isEmpty()){}else secondPLanguage = null;

        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();

        String query2=
                "SELECT d.id,\n" +
                        "  d.email,\n" +
                        "  l.code,\n" +
                        "  p_l.name\n" +
                        "FROM Developers d\n" +
                        "  LEFT JOIN developers_languages d_l\n" +
                        "    ON d.id = d_l.developersid\n" +
                        "  LEFT JOIN languages l\n" +
                        "    ON d_l.languagesid = l.id\n" +
                        "  LEFT JOIN programming_languages_developers p_l_d\n" +
                        "    ON d.id = p_l_d.developersid\n" +
                        "  LEFT JOIN programming_languages p_l\n" +
                        "    ON p_l_d.programming_languagesid = p_l.id\n" +
                        "    \n" +
                        "   where  d.id = any (SELECT \n" +
                        "\t\t  d.id\n" +
                        "\t\tFROM Developers d\n" +
                        "\t\t  LEFT JOIN developers_languages d_l\n" +
                        "\t\t    ON d.id = d_l.developersid\n" +
                        "\t\t  LEFT JOIN languages l\n" +
                        "\t\t    ON d_l.languagesid = l.id\n" +
                        "\t\t  LEFT JOIN programming_languages_developers p_l_d\n" +
                        "\t\t    ON d.id = p_l_d.developersid\n" +
                        "\t\t  LEFT JOIN programming_languages p_l\n" +
                        "\t\t    ON p_l_d.programming_languagesid = p_l.id\n" +
                        "\t\t    \n" +
                        "\t\t    where (:firstPLanguage is null or p_l.name = :firstPLanguage ) )and d.id =any (SELECT \n" +
                        "\t\t  d.id\n" +
                        "\t\tFROM Developers d\n" +
                        "\t\t  LEFT JOIN developers_languages d_l\n" +
                        "\t\t    ON d.id = d_l.developersid\n" +
                        "\t\t  LEFT JOIN languages l\n" +
                        "\t\t    ON d_l.languagesid = l.id\n" +
                        "\t\t  LEFT JOIN programming_languages_developers p_l_d\n" +
                        "\t\t    ON d.id = p_l_d.developersid\n" +
                        "\t\t  LEFT JOIN programming_languages p_l\n" +
                        "\t\t    ON p_l_d.programming_languagesid = p_l.id\n" +
                        "\t\t     where (:secondPLanguage is null or p_l.name = :secondPLanguage) ) and d.id =any (SELECT \n" +
                        "\t\t  d.id\n" +
                        "\t\tFROM Developers d\n" +
                        "\t\t  LEFT JOIN developers_languages d_l\n" +
                        "\t\t    ON d.id = d_l.developersid\n" +
                        "\t\t  LEFT JOIN languages l\n" +
                        "\t\t    ON d_l.languagesid = l.id\n" +
                        "\t\t  LEFT JOIN programming_languages_developers p_l_d\n" +
                        "\t\t    ON d.id = p_l_d.developersid\n" +
                        "\t\t  LEFT JOIN programming_languages p_l\n" +
                        "\t\t    ON p_l_d.programming_languagesid = p_l.id\n" +
                        "\t\t     where (:code is null or l.code = :code) )" ;


        List<Object[]> rows= s.createSQLQuery(query2)
                .setString("firstPLanguage", firstPLanguage)

                .setString("secondPLanguage",secondPLanguage)
                .setString("code", code)
                .list();
        tx.commit();
        s.close();
        return rows;
    }



    private SessionFactory sessionFactory;
    @Autowired
    public DAO(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

}
