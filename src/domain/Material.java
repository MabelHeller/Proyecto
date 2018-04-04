
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
public class Material implements Serializable{
    //atributos
    private String code;
    private String name;
    private String area;
    //constructores
    public Material(String code, String name, String area) {
        this.code = code;
        this.name = name;
        this.area = area;
    }

    public Material() {
        this.code = "";
        this.name = "";
        this.area = "";
    }  
    //metodos accesores
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    //toString
    @Override
    public String toString() {
        return "Materials{" + "code=" + code +  ", name=" + name + ", area=" + area + '}';
    }
    //guarda un material en un archivo serializado
    public boolean saveMaterials(Material material) throws IOException, ClassNotFoundException {
        List<Material> materialList = new ArrayList<Material>();
        File file = new File("Materials.txt");
        if (file.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));//lee el archivo
            Object aux = objectInputStream.readObject();
            materialList = (List<Material>) aux;
            objectInputStream.close();
        }//if
        for (int i = 0; i < materialList.size(); i++) {
            if (materialList.get(i).getCode().equals(material.getCode())) {
                return false;
            }//if
        }//for
        materialList.add(material);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));//escribe
        output.writeUnshared(materialList);//escribe el objeto
        output.close();//cerrar el archivo
        return true;
    }//saveStudents   
    //tamaño en bytes de los atributos del objeto
    public int sizeInBytes() {
        return this.getCode().length() * 2 + this.getName().length() * 2+this.getArea().length()*2+4;
    }    
}
