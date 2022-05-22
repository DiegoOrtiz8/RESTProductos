package com.ibm.academia.restapi.productos.controladores;

import com.ibm.academia.restapi.productos.modelo.entidades.Producto;
import com.ibm.academia.restapi.productos.modelo.servicios.IProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final static Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private IProductoService IProductoService;

    /**
     * Enpoint para consultar todos los productos
     * @return Retorna una lista de productos
     * @author DECO 22-05-2022
     */
    @GetMapping("/listar")
    public ResponseEntity<?> consultarTodosProductos() {
        List<Producto> productos = IProductoService.buscarTodos();

        return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
    }

    /**
     * Endpoint para consultar un objeto producto
     * @param productoId Parametro de busqueda del objeto
     * @return Retorna un objeto de tipo producto
     * @exception En caso de que falle consultando el producto
     * @author DECO 22-05-2022
     */
    @GetMapping("/ver-detalle/productoId/{productoId}")
    public ResponseEntity<?> consultarDetalleProducto(@PathVariable Long productoId) {
        Optional<Producto> producto = null;

        try {
            producto = IProductoService.buscarPorId(productoId);
        }
        catch (Exception e) {
            logger.info(e.getMessage() + " causa: " + e.getCause());
            throw e;
        }

        return new ResponseEntity<Producto>(producto.get(), HttpStatus.OK);
    }
}
