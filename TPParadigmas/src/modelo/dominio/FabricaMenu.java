/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dominio;

/**
 *
 * @author franc
 */
public class FabricaMenu implements Fabrica {

    @Override
    public Menu CrearMenu1() {
        return new Menu1();
    }

    @Override
    public Menu CrearMenu2() {
        return new Menu2();
    }
}
