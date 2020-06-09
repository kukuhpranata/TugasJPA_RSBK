package com.controller.bean;  
import javax.faces.bean.ManagedBean;  
import javax.faces.bean.ViewScoped;  
import java.util.List;  
import com.dao.SurveyDAO;  
import com.model.pojo.Survey;  
import java.io.Serializable;  
import java.util.Date;
import org.primefaces.event.RowEditEvent;  
import javax.faces.context.FacesContext;  
import javax.faces.application.FacesMessage;  
import org.primefaces.context.RequestContext;  
/** 
 * 
 * @author Raichand 
 */  
@ManagedBean(name = "surveyBean")  
@ViewScoped  
public class SurveyBean implements Serializable  
{  
    private List < Survey > surveyList;  
    private List < Survey > searchList;  
    private List < Survey > searchByRecordNoList;  
    SurveyDAO surveyDao = new SurveyDAO();  
    Survey survey = new Survey();  
    Survey newsurvey = new Survey();  
    public List < Survey > getSurvey()  
    {  
        surveyList= surveyDao.AllSurvey();  
        int count = surveyList.size();  
        return surveyList;  
    }  
    public void addSurvey()  
    {  
        String nama = newsurvey.getNama();
        String email = newsurvey.getEmail();
        String alamat = newsurvey.getAlamat();
        String kota = newsurvey.getKota();
        String negBag = newsurvey.getNegBag();
        String pos = newsurvey.getPos();
        Date tlg = newsurvey.getTgl();
        String suka = newsurvey.getSuka();
        String how = newsurvey.getHow();
        String rekomendasi = newsurvey.getRekomendasi();
        String komentar = newsurvey.getKomentar();
        surveyDao.add(newsurvey);
        System.out.println("Survey Berhasil Ditambahkan.");  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Information", "Survey Berhasil Ditambahkan.");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
        newsurvey = new Survey();  
    }  
    public void changeSurvey(Survey survey)  
    {  
        this.survey = survey;  
    }  
    public void UpdateSurvey(Survey survey)  
    {  
        String nama = survey.getNama();  
        FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nama", nama);  
        RequestContext.getCurrentInstance().showMessageInDialog(message1);  
        surveyDao.update(survey);  
        System.out.println("Survey Info successfully saved.");  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Information", "User updated successfully .");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
        survey = new Survey();  
    }  
    public void deleteSurvey(Survey survey)  
    {  
        String nama = survey.getNama();  
        //FacesMessage message3= new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete Item",contactName);  
        // RequestContext.getCurrentInstance().showMessageInDialog(message3);  
        surveyDao.delete(survey);  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete", "Record deleted successfully");  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
    }  
    public void searchbyRecordno()  
    {  
        searchByRecordNoList = surveyDao.SearchByRecordNo(survey.getNama());  
        int count = searchByRecordNoList.size();  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Number of Record Selected:", Integer.toString(count));  
        RequestContext.getCurrentInstance().showMessageInDialog(message);  
    }  
    public Survey getsurvey()  
    {  
        return survey;  
    }  
    public void setSurvey(Survey survey)  
    {  
        this.survey = survey;  
    }  
    public Survey getNewsurvey()  
    {  
        return newsurvey;  
    }  
    public void setNewsurvey(Survey newsurvey)  
    {  
        this.newsurvey = newsurvey;  
    }  
    public List < Survey > getUsersList()  
    {  
        return surveyList;  
    }  
    public void setUsersList(List < Survey > usersList)  
    {  
        this.surveyList = usersList;  
    }  
    public List < Survey > getSearchList()  
    {  
        return searchList;  
    }  
    public void setSearchList(List < Survey > searchList)  
    {  
        this.searchList = searchList;  
    }  
    public List < Survey > getSearchByRecordNoList()  
    {  
        return searchByRecordNoList;  
    }  
    public void setSearchByRecordNoList(List < Survey > searchByRecordNoList)  
    {  
        this.searchByRecordNoList = searchByRecordNoList;  
    }  
    public void onRowEdit(RowEditEvent event)  
    {  
        FacesMessage msg = new FacesMessage(" Edited Record No", ((Survey) event.getObject()).getNama());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        Survey editedsurvey = (Survey) event.getObject();  
        surveyDao.update(editedsurvey);  
    }  
    public void onCancel(RowEditEvent event)  
    {  
        FacesMessage msg = new FacesMessage("Edit Cancelled");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        surveyList.remove((Survey) event.getObject());  
    }  
}  