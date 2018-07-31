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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author rociomera
 */
public class Pelicula {
    private Genero genero;
    private String nombre;
    private String director;
    private int rating;
    private String imagePath;
    private int year;
    public Pelicula(Genero genero, String nombre, String director, 
                        int rating, String imagePath, int year) {
        this.genero = genero;
        this.nombre = nombre;
        this.director = director;
        this.rating = rating;
        this.imagePath = imagePath;
        this.year = year;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    /**
     * Lee el archivos peliculas.txt y retornaun ArrayList<Pelicula> 
     * con las peliculas que pertenecen al genero pasado como parametro
     * FORMATO ARCHIVO
     *  nombre, codGenero, ano, rating, director, imagePath
     * @param ge: Genero
     * @return ArrayList<Pelicula>
     */
    public static ArrayList<Pelicula> cargarPelicula(Genero ge){
        ArrayList<Pelicula> pe = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("src/recursos/peliculas.txt"))) {
            String linea;
            while((linea=bf.readLine())!=null){
                System.out.println(linea);
                String p[]=linea.split(";");
                if(p[1].trim().equals(ge.getCodigo())){
                    pe.add(new Pelicula(ge,
                                            p[0].trim(),
                                            p[4].trim(),
                                            Integer.valueOf(p[3].trim()),
                                            p[5].trim(),
                                            Integer.valueOf(p[2].trim())
                                        ) 
                            );
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return pe;
    }
   
}
