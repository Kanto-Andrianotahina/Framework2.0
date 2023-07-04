package etu1922.framework;

import java.util.HashMap;

public class ModelView {
    String view;
    HashMap<String,Object> data = new HashMap<String,Object>();
    HashMap<String, Object> session = new HashMap<String, Object>();


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

    public void addItem(String key, Object value){
        this.getData().put(key, value);
    }
    public void addSession(String key, Object object) {
        this.getSession().put(key, object);
    }
}
