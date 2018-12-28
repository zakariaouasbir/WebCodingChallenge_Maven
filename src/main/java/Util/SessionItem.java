    /*
    * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
    * and open the template in the editor.
    */
    package Util;

    /**
    *
    * @author zakaria
    */
    public class SessionItem {
    private String key;
    private Object object;

    public String getKey() {
    return key;
    }

    public void setKey(String key) {
    this.key = key;
    }

    public Object getObject() {
    return object;
    }

    public void setObject(Object object) {
    this.object = object;
    }

    @Override
    public String toString() {
    return "SessionItem{" + "key=" + key + ", object=" + object + '}';
    }


    }