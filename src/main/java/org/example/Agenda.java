package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase que representa una agenda de contactos.
 * Permite agregar,modificar y eliminar contactos.
 */

public class Agenda implements AgendaInterface {
    private List<Persona> contacts; // Lista de Persona

    /**
     * Constructor por defecto que inicializa la lista de contactos vacía.
     */

    public Agenda() {
        this.contacts = new ArrayList<>();
    }
    /**
     * Agrega un contacto a la agenda.
     * Si ya existe, se añade el número de teléfono a la lista de números de ese contacto.
     * @param name Nombre del contacto.
     * @param phone Número de teléfono.
    */
    @Override
    public void addContact(String name, String phone) {
        boolean exists = false;
        for (Persona c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                exists = true;
                c.getPhones().add(phone);
                break;
            }
        }

        if (!exists) {
            Persona newContact = new Persona(name, phone);
            contacts.add(newContact);
        }
    }

    /**
     * Elimina un contacto de la agenda por su nombre.
     * @param name Nombre del contacto a eliminar.
     */
    @Override
    public void removeContact(String name) {
        Iterator<Persona> it = contacts.iterator();

        while (it.hasNext()) {
            Persona c = it.next();

            if (c.getName().equalsIgnoreCase(name)) {
                it.remove();
            }
        }
    }

    /**
     * Modifica un número de teléfono de un contacto. Busca el contacto por nombre y reemplaza el número antiguo por uno nuevo.
     * @param name Nombre del contacto.
     * @param oldPhone Número de teléfono antiguo.
     * @param newPhone Número de teléfono nuevo.
     */
    @Override
    public void modifyPhoneNumber(String name, String oldPhone, String newPhone) {
        for (Persona c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                List<String> phones = c.getPhones();

                int index = phones.indexOf(oldPhone);

                if (index != -1) {
                    phones.set(index, newPhone);
                }
            }
        }
    }

    /**
     * Devuelve la lista completa de contactos en la agenda.
     * @return Lista de contactos.
     */
    @Override
    public List<Persona> getContacts() {
        return this.contacts;
    }
}