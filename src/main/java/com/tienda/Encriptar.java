/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author joses
 */
public class Encriptar {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        var claveJuan = encoder.encode("123");
        var claveRebeca = encoder.encode("456");
        var clavePedro = encoder.encode("789");
        System.out.println("Juan (123): "+claveJuan);
        System.out.println("Rebeca (456): "+claveRebeca);
        System.out.println("Pedro (789): "+clavePedro);
    }
}
