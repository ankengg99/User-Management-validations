package com.example.library.moudle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Library {
   private String name;
    private String address;
   private String number;
   private List<String> facilities;
    @Override
    public String toString(){
        return "{"+"Library name : "+this.name+"\n"+
                "Library address : "+this.address+"\n"+
                "Library number : "+this.number+"\n"+
                "Library facilities : "+this.facilities+"\n"+
                "}";
    }
}
