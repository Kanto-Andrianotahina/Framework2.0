package etu1922.framework;

import java.util.HashMap;

public class ModelView {
    String view;
    HashMap<String,Object> data = new HashMap<String,Object>();

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

    public void addItem(String key, Object value){
        this.getData().put(key, value);
    }
}
