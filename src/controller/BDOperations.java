/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.List;

/**
 *
 * @author Ventu
 */
public interface BDOperations {
    
    
       public List<Object> getAll();
       public boolean insert(Object object);
    public boolean update(Object object);
    public boolean delete(int id);
    
    
    
    
}
