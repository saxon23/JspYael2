/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yael;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */

public class Negocio implements Serializable    
{
    private List<Datos>lista;

    public Negocio() 
    {
        
    }
    public boolean loadLista ()
    {
        Datos datos = null;
        lista = new ArrayList<Datos> ();
        for ( int i = 1; i <= 5; i++)
        {
            datos = new Datos();
            datos.setCalf((float) (Math.random()*10));
            datos.setNombre(String.format("Alumno %d", i));
            lista.add(datos);
        }
        return  lista != null && !lista.isEmpty();
        
    }

    public List<Datos> getLista() 
    {
        if( lista == null || lista.isEmpty())
        {
            if ( !loadLista ( ) )
            {
                return null;
            }
        }
        return lista;
    }

    public void setLista(List<Datos> lista) {
        this.lista = lista;
    }
    
    
}
