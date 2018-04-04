/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Media;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Heller
 */
public class AudiovisualFile {
    
//atributos
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//cantidad de registros en el archivo
    private int regSize;//tama;o del registro
    private String myFilePath;//ruta

    //constructor
    public AudiovisualFile(File file) throws IOException {
        //almaceno la ruta
        myFilePath = file.getPath();
        //indico el tama;o maximo
        this.regSize = 140;
        //una validacion sencilla
        if (file.exists() && !file.isFile()) {
            throw new IOException(file.getName() + "is an invalid file");
        } else {
            //crear la nueva instancia de RAF
            randomAccessFile = new RandomAccessFile(file, "rw");//en este archivo vamos a poder escribir y leer
            //necesitamos indicar cuantos registros tiene el archivo
            this.regsQuantity = (int) Math.ceil((double) randomAccessFile.length() / (double) regSize);
        }
    }

    //MUY IMPORTANTE cerrar nuestros archivos
    public void close() throws IOException {
        randomAccessFile.close();
    }

    //indicar la cantidad de registros de nuestro archivo
    public int fileSize() {
        return this.regsQuantity;
    }

    //insertar un nuevo resgistro en una posicion especifica
    public boolean putValue(int position, Media audiovisual) throws IOException {
        //primero verificar que sea valida la insercion
        if (position < 0 && position > this.regsQuantity) {
            System.err.println("1001 - Record position is out of bounds");
            return false;
        } else {
            if (audiovisual.sizeInBytes() > this.regSize) {
                System.err.println("1002 - Record size is out of bounds");
                return false;
            } else {
                randomAccessFile.seek(position * this.regSize);
                randomAccessFile.writeUTF(audiovisual.getCode());
                randomAccessFile.writeUTF(audiovisual.getName());
                randomAccessFile.writeUTF(audiovisual.getArea());
                randomAccessFile.writeUTF(audiovisual.getBrand());
                randomAccessFile.write(audiovisual.getQuantity());

                return true;
            }
        }
    }//end method

    //insertar al final del archivo
    public boolean addEndRecord(Media audiovisual) throws IOException {
        boolean success = putValue(this.regsQuantity, audiovisual);
        if (success) {
            ++this.regsQuantity;
        }
        return success;
    }

    //obtener un audiovisual
    public Media getAudiovisual(int position) throws IOException {
        //validar la posicion
        if (position >= 0 && position <= this.regsQuantity) {
            //colocamos el brazo en el lugar adecuado
            randomAccessFile.seek(position * this.regSize);
            //llevamos a cabo la lectura
            Media audiovisualTemp = new Media();
            audiovisualTemp.setCode(randomAccessFile.readUTF());
            audiovisualTemp.setName(randomAccessFile.readUTF());
            audiovisualTemp.setArea(randomAccessFile.readUTF());
            audiovisualTemp.setBrand(randomAccessFile.readUTF());
            audiovisualTemp.setQuantity(randomAccessFile.read());            
            if (audiovisualTemp.getName().equalsIgnoreCase("deleted")) {
                return null;
            } else {
                return audiovisualTemp;
            }
            
        } else {
            System.out.println("1003-position is out of brounds");
            return null;
        }
    }

    //eliminar audiovisual
    public boolean deletedAudiovisual(String code) throws IOException {
        Media myAudiovisual;
        //buscar el audiovisual
        for (int i = 0; i < this.regsQuantity; i++) {
            //obtener el audiovisual de la posicion actual
            myAudiovisual = this.getAudiovisual(i);
            //preguntar si el audiovisual que deseo eliminar 
            if (this.getAudiovisual(i) != null) {
                if (myAudiovisual.getCode().equalsIgnoreCase(code)) {
                    //marcar como eliminado
                    myAudiovisual.setName("deleted");
                    return this.putValue(i, myAudiovisual);
                }
            }
        }
        return false;
    }

    //retornar una lista de audiovisual
    public ArrayList<Media> getAllAudiovisual() throws IOException {
        ArrayList<Media> audiovisualList = new ArrayList<Media>();
        for (int i = 0; i < this.regsQuantity; i++) {
            Media sTemp = this.getAudiovisual(i);
            if (sTemp != null) {
                audiovisualList.add(sTemp);
            }
        }//end for
        return audiovisualList;
    }
}
