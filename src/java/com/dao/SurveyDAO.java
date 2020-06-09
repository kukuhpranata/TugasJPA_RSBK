package com.dao;  
import java.util.List;  
import java.util.ArrayList;  
import org.hibernate.Query;  
import org.hibernate.Session;  
import com.util.HibernateUtil;  
import com.model.pojo.Survey;  
import javax.faces.application.FacesMessage;  
import org.primefaces.context.RequestContext;  
/** 
 * 
 * @author Raichand 
 */  
public class SurveyDAO  
{  
    private Survey survey;  
    private Survey newsurvey;  
    private List < Survey > DaoAllSurvey;  
    private List < Survey > DaoSearchSurveyList;  
    //Session session;  
    public List < Survey > AllSurvey()  
    {  
        Session session = HibernateUtil.getSessionFactory().openSession();  
        try  
        {  
            session.beginTransaction();  
            DaoAllSurvey = session.createCriteria(Survey.class).list();  
            int count = DaoAllSurvey.size();  
            // FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "List Size", Integer.toString(count));//Debugging Purpose  
            //RequestContext.getCurrentInstance().showMessageInDialog(message1);  
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();  
        return DaoAllSurvey;  
    }  

    public List < Survey > SearchByRecordNo(String Nama)  
    {  
        Session session = HibernateUtil.getSessionFactory().openSession();  
        List < Survey > daoSearchList = new ArrayList < > ();  
        try  
        {  
            session.beginTransaction();  
            Query qu = session.createQuery("From survey U where U.nama =:nama"); //User is the entity not the table  
            qu.setParameter("nama", Nama);  
            daoSearchList = qu.list();  
            int count = daoSearchList.size();  
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        finally  
        {  
            session.close();  
        }  
        return daoSearchList;  
    }  
    public void add(Survey newsurvey)  
    {  
        Session session = HibernateUtil.getSessionFactory().openSession();  
        try  
        {  
            String nama = newsurvey.getNama();  
            // begin a transaction  
            session.beginTransaction();  
            session.merge(newsurvey);  
            session.flush();  
            System.out.println("NewSurvey saved, nama: " +  
                newsurvey.getNama());  
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();  
    }  
    public void delete(Survey survey)  
    {  
        Session session = HibernateUtil.getSessionFactory().openSession();  
        try  
        {  
            String nama = survey.getNama();  
            session.beginTransaction();  
            session.delete(survey);  
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();  
    }  
    public void update(Survey survey)  
    {  
        Session session = HibernateUtil.getSessionFactory().openSession();  
        try  
        {  
            session.beginTransaction();  
            session.update(survey);  
            session.flush();  
            session.getTransaction().commit();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
            session.getTransaction().rollback();  
        }  
        session.close();  
    }  
}  