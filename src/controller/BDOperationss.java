/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.List;
import model.Reservas;


/**
 *
 * @author Ventu
 */
public interface BDOperationss {
    
    
       public List<Reservas> getAll();
       public boolean insert(Object object);
    public boolean update(Object object);
    public boolean delete(int id);
    
}
