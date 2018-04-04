/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Heller
 */
public class Student implements Serializable {

    //atributos
    private String name;
    private String career;
    private String year;
    private String id;

    //constructores
    public Student(String name, String career, String year, String id) {
        this.name = name;
        this.career = career;
        this.year = year;
        this.id = id;
    }

    public Student() {
        this.name = "";
        this.career = "";
        this.year = "";
        this.id = "";
    }

    //metodos accesores
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String carnet) {
        this.id = carnet;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", career=" + career + ", year=" + year + ", id=" + id + '}';
    }
//tamaño en bytes de los atributos del objeto
    public int sizeInBytes() {
        return this.getName().length() * 2 + this.getCareer().length() * 2 + this.getYear().length() * 2 + this.getId().length() * 2 ;
    }

}
