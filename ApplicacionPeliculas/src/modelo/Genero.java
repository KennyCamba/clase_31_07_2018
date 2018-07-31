/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author rociomera
 */
public class Genero implements Comparable<Genero>{
    private String codigo;
    private String nombre;
    public Genero(String nombre,String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    /**
     * Esta funcion lee el archivo generos.txt que se encuentra en 
     * el paquete recursos y retorna un TreeSet de generos ordenadas
     * por el nombre 
     * FORMATO ARCHIVO
     *  nombre,codigo
     * @return 
     */
    public static Set<Genero> cargarGeneros() {
        Set<Genero> generos = new TreeSet<>(); 
        try(BufferedReader bf = new BufferedReader(new FileReader("src/recursos/generos.txt"))){
            String line;
            while((line=bf.readLine())!=null){
                String[] info = line.split(";");
                Genero g = new Genero(info[0], info[1]);
                generos.add(g);
                System.out.println(g);
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        return generos;
    }

    @Override
    public int compareTo(Genero o) {
        return nombre.compareTo(o.getNombre());
    }
}
