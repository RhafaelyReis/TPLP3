/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.dao;

import java.util.List;

/**
 *
 * @author rhafa
 */
public interface GenericDAO<T> {
    public boolean add(T entity);
    public T update(T entity);
    public boolean remove(T entity);
    public T getById(long id);
    public List<T> getAll();
}