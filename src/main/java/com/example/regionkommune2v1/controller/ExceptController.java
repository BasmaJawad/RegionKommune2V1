package com.example.regionkommune2v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@RestController
@RequestMapping("/exp")
public class ExceptController {

    @GetMapping("/")
    public String hello() {
        return "hej";
    }

    @GetMapping("/div/{idiv}")
    public String divmednoget(@PathVariable int idiv) {
        int i1 = 100;
        i1 = i1 / idiv;
        return "" + i1;
    }

    @GetMapping("/div2/{idiv}")
    public String divmednoget2(@PathVariable int idiv) {
        int i1 = 100;
        try {
            i1 = i1 / idiv;
        } catch (ArithmeticException err) {
            return err.getMessage();
        }
        return "" + i1;
    }

    @GetMapping("/loop/{iloop}")
    public String loop(@PathVariable int iloop) {
        int i2 = 0;
        for (int i1 = 0; i1 < iloop; i1++) {
            i2++;
        }
        return "" + i2;
    }

    @GetMapping("/loop2/{iloop}")
    public String loop2(@PathVariable int iloop) {
        int i2 = 1000000000;
        for (int i1 = 0; i1 < iloop; i1++) {
            try {
                i2++;
            } catch (RuntimeException err) {
                return err.getMessage();
            }
        }
        return "" + i2;
    }

    @GetMapping("/file/{filename}")
    public String filename(@PathVariable String filename) {
        File file = new File(filename);
        String data = "";
        try {
            //file.createNewFile();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                data += scanner.nextLine();
            }
        } catch (FileNotFoundException io) {
            System.out.println(io.getMessage());
        }
        return data;
    }

}
