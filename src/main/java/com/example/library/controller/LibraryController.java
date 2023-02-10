package com.example.library.controller;

import com.example.library.moudle.Library;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/v1/app")
public class LibraryController {
    @Autowired
    LibraryService libraryService;
    @GetMapping("/get-all")
    public List<Library> getAllLibrary(){
        return libraryService.getAllList();
    }

    @GetMapping("/get-by-name/{name}")
    public Library getLibrary(@PathVariable String name){
        return libraryService.getlist(name);
    }
    @PostMapping("/add-library")
    public void addLibrary(@RequestBody Library library){
        libraryService.addlist(library);
    }
    @PutMapping("/update-library/name/{name}")
    public void updateLibrary(@PathVariable String name,@RequestBody Library library){
       libraryService.updatelist(name,library);
    }
    @DeleteMapping("/delete-library/name/{name}")
    public void deleteLibrary(@PathVariable String name){
        libraryService.deletelist(name);
    }
}
