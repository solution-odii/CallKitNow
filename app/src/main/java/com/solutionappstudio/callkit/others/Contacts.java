package com.solutionappstudio.callkit.others;

/**
 * Created by ODII on 12/29/2018.
 */


public class Contacts {
    private String name, number, index;
    public Contacts(String index, String name, String number){
        this.name=name;
        this.number=number;
        this.index=index;

    }
    public String getIndex() {return this.index; }

    public String getName() {return this.name; }

    public String getNumber() {return this.number;}
}
