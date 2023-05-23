/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.laila.dao;

import com.laila.model.Musica;
import java.util.List;

public interface MusicaDAO {
    
    public List<Musica> findAll();
    public Musica insert(Musica objMusica);
    public Musica findById(Integer id);
    public Musica updateById(Integer id, Musica objMusica);
    public Boolean deleteById(Integer id);
}


