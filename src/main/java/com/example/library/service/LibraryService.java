package com.example.library.service;

import com.example.library.moudle.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    private static final List<Library> libraryList=new ArrayList<>();
    static {
        libraryList.add(new Library("Study center","BNo-1, Room No-1","LA01",List.of("computer","photocopying","online acess")));
    }
    public void addlist(Library library){
        libraryList.add(library);
    }
    public List<Library> getAllList(){
        return libraryList;
    }
    public Library getlist(String name){
        for(Library library:libraryList){
            if(library.getName().equals(name)){
                return library;
            }
        }
        return null;
    }
    public void updatelist(String name,Library newlibrary){
        Library temp=new Library();
        for(Library library:libraryList ){
            if(library.getName().equals(name)){
                temp=library;
                break;
            }
        }
        temp.setName(newlibrary.getName());
        temp.setAddress(newlibrary.getAddress());
        temp.setNumber(newlibrary.getAddress());
        temp.setFacilities(newlibrary.getFacilities());
    }
    public void deletelist(String name){
        for(Library library:libraryList ){
            if(library.getName().equals(name)){
               libraryList.remove(library);
                break;
            }
        }
    }
}
