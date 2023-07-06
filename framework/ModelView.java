package etu1922.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ModelView {
    String view;
    HashMap<String,Object> data = new HashMap<String,Object>();
    HashMap<String, Object> session = new HashMap<String, Object>();
    Boolean isJson = false;
    Boolean invalidSession = false;
    List<String> removeSession = new ArrayList<>();

    public void setView(String view) {
        this.view = view;
    }
    public String getView() {
        return view;
    }
    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
    public HashMap<String, Object> getData() {
        return data;
    }
    public void setSession(HashMap<String, Object> session) {
        this.session = session;
    }
    public HashMap<String, Object> getSession() {
        return session;
    }
    public void setIsJson(Boolean isJson) {
        this.isJson = isJson;
    }
    public Boolean getIsJson() {
        return isJson;
    }
    public void setInvalidSession(Boolean invalidSession) {
        this.invalidSession = invalidSession;
    }
    public Boolean getInvalidSession() {
        return invalidSession;
    }
    public void setRemoveSession(List<String> removeSession) {
        this.removeSession = removeSession;
    }
    public List<String> getRemoveSession() {
        return removeSession;
    }

    public void addItem(String key, Object value){
        this.getData().put(key, value);
    }
    public void addSession(String key, Object object) {
        this.getSession().put(key, object);
    }
    public void remove(String...data){
        for (int i = 0; i < data.length; i++) {
            this.removeSession.add(data[i]);
        }
    }
}
