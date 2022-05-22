package com.ibm.academia.restapi.productos.servicios;

import com.ibm.academia.restapi.productos.modelo.entidades.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoDAO {
    public List<Producto> buscarTodos();
    public Optional<Producto> buscarPorId(Long id);
}
