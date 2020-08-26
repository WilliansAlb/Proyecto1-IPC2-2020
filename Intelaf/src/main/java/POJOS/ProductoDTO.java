/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import java.util.ArrayList;

/**
 *
 * @author yelbetto
 */
public class ProductoDTO {
    
    private String nombre;
    private String fabricante;
    private String codigo_producto;
    private int cantidad;
    private Double precio;
    private String codigo_tienda;
    private String descripcion;
    private int garantia;
    private int codigo_existencia;
    private Double total;
    private int conteo;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    public ProductoDTO(ArrayList<String> parametros){
        nombre = parametros.get(0);
        fabricante = parametros.get(1);
        codigo_producto = parametros.get(2);
        cantidad = Integer.parseInt(parametros.get(3));
        precio = Double.parseDouble(parametros.get(4));
        codigo_tienda = parametros.get(5);
    }
    
    public ProductoDTO(){
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCodigo_tienda() {
        return codigo_tienda;
    }

    public void setCodigo_tienda(String codigo_tienda) {
        this.codigo_tienda = codigo_tienda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public int getCodigo_existencia() {
        return codigo_existencia;
    }

    public void setCodigo_existencia(int codigo_existencia) {
        this.codigo_existencia = codigo_existencia;
    }

    public int getConteo() {
        return conteo;
    }

    public void setConteo(int conteo) {
        this.conteo = conteo;
    }
    
    
}
