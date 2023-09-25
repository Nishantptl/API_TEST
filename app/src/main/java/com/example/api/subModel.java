package com.example.api;

import org.json.JSONArray;

import java.util.ArrayList;

public class subModel {

    ArrayList<String> subCat;

    public subModel(JSONArray sub) {
    }

    public subModel(ArrayList<String> subCat) {
        this.subCat = subCat;
    }

    public ArrayList<String> getSubCat() {
        return subCat;
    }

    public void setSubCat(ArrayList<String> subCat) {
        this.subCat = subCat;
    }
}
