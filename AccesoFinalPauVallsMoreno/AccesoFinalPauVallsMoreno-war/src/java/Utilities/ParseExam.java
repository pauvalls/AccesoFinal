/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author pauva
 */
public class ParseExam {
String value;
int name;

    public ParseExam(String value, int name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

     
}
