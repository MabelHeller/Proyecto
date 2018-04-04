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
public class Media extends Material implements Serializable {
//atributos
    private String brand;
    private int quantity;

    //constructores
    public Media(String code, String name, String area, String brand, int quantity) {
        super(code, name, area);
        this.brand = brand;
        this.quantity=quantity;
    }

    public Media() {
        super();
        this.brand = "";
        this.quantity=0;
    }
    //metodos accesores
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Audiovisual{" + '}';
    }
//guarda un audiovisual en un archivo serializado
    public boolean saveAudiovisual(Media audiovisual) throws IOException, ClassNotFoundException {
        List<Media> audiovisualList = new ArrayList<Media>();
        File file = new File("Audiovisual.txt");
        if (file.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));//lee el archivo
            Object aux = objectInputStream.readObject();
            audiovisualList = (List<Media>) aux;
            objectInputStream.close();
        }//if
        for (int i = 0; i < audiovisualList.size(); i++) {
            if (audiovisualList.get(i).getCode().equals(audiovisual.getCode())) {
                return false;
            }//if
        }//for
        audiovisualList.add(audiovisual);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));//escribe
        output.writeUnshared(audiovisualList);//escribe el objeto
        output.close();//cerrar el archivo
        return true;
    }
//tamaño en bytes de los atributos del objeto
    public int sizeInBytes() {
        return this.getCode().length() * 2 + this.getName().length() * 2 + this.getArea().length() * 2 + 4;
    }
    //elimina un audiovisual por medio del nombre
    public void deletedAudiovisual(String name) throws IOException, ClassNotFoundException {
        File myFile = new File("Audiovisual.txt");
        List<Media> audiovisualList = new ArrayList<Media>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            audiovisualList = (List<Media>) aux;
            objectInputStream.close();
        }//if
        Book book = null;
        for (int i = 0; i < audiovisualList.size(); i++) {
            System.out.println(audiovisualList.get(i));
            if (audiovisualList.get(i).getName().equals(name)) {
                audiovisualList.remove(i);
                System.out.println(audiovisualList.size());
            }
        }
        //bookList.add(book);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));//escribe
        output.writeUnshared(audiovisualList);//escribe el objeto
        System.out.println(audiovisualList.size());
        output.close();
    }
//obtiene un audiovisual por medio del codigo
    public Media getAudiovisual(String code) throws IOException, ClassNotFoundException {
        File myFile = new File("Audiovisual.txt");
        List<Media> audiovisualList = new ArrayList<Media>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            audiovisualList = (List<Media>) aux;
            objectInputStream.close();
        } // if(myFile.exists())
        Media audiovisual = null;
        for (int i = 0; i < audiovisualList.size(); i++) {
            if (audiovisualList.get(i).getCode().equals(code)) {
                audiovisual = audiovisualList.get(i);
                break;
            } // if 
        } // for i
        return audiovisual;
    } 
}//fin clase
