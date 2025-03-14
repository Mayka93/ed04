package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un contacto con un nombre y una lista de números de teléfono.
 */
class Contacto {
    private String name;
    private List<String> phones;

    /**
     * Constructor que inicializa un contacto con un nombre y un número de teléfono.
     * @param name Nombre del contacto.
     * @param phone Número de teléfono del contacto.
     */
    public Contacto(String name, String phone) {
        this.name = name;
        this.phones = new ArrayList<>();
        this.phones.add(phone);
    }

    /**
     * Devuelve el nombre del contacto.
     * @return Nombre del contacto.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Devuelve la lista de números de teléfono de contacto.
     * @return Lista de números de teléfono.
     */
    public List<String> getPhones() {
        return this.phones;
    }
}