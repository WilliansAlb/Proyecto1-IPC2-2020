/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import Util.Utilidad;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author yelbetto
 */
public class PedidoDTO {
    Utilidad util = new Utilidad();
    private int codigo_pedido;
    private String codigo_tienda1;
    private String codigo_tienda2;
    private String nit;
    private Double anticipo;
    private String fecha;
    private boolean entregado;
    private Double total;
    private String codigo_producto;
    private int cantidad;
    private Date fecha2;
    private int dias;
    private String nombre_producto;
    private Double precio_producto;
    private boolean atrasado;

    public boolean isAtrasado() {
        return atrasado;
    }

    public void setAtrasado(boolean atrasado) {
        this.atrasado = atrasado;
    }
    
    public PedidoDTO(ArrayList<String> parametros){
        codigo_pedido = Integer.parseInt(parametros.get(0));
        codigo_tienda1 = parametros.get(1);
        codigo_tienda2 = parametros.get(2);
        fecha = parametros.get(3);
        nit = parametros.get(4);
        codigo_producto = parametros.get(5);
        cantidad = Integer.parseInt(parametros.get(6));
        total = Double.parseDouble(parametros.get(7));
        anticipo = Double.parseDouble(parametros.get(8));
    }

    public PedidoDTO() {
        
    }

    public int getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(int codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public String getCodigo_tienda1() {
        return codigo_tienda1;
    }

    public void setCodigo_tienda1(String codigo_tienda1) {
        this.codigo_tienda1 = codigo_tienda1;
    }

    public String getCodigo_tienda2() {
        return codigo_tienda2;
    }

    public void setCodigo_tienda2(String codigo_tienda2) {
        this.codigo_tienda2 = codigo_tienda2;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(Double anticipo) {
        this.anticipo = anticipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(Double precio_producto) {
        this.precio_producto = precio_producto;
    }
    
    
    
}
