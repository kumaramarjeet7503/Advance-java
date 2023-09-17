/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.helper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.File;

/**
 *
 * @author amarj
 */
public class FileHelper {
    
    public static boolean deleteFile(String path)
    {
        boolean result = false ;
        
        try{        
            File file = new File(path);
            file.delete();
            result = true ;
        }catch(Exception e)
        {
            e.printStackTrace();
        }        
        
        return result;
    }
    
   public static boolean uploadFile(InputStream is, String path )
   {
       boolean result = false ;
       
       try{
           // Create an byte array from input stream
           byte[] byteArray = new byte[is.available()] ;
           
           // Read data of the byte array
           is.read(byteArray);
           
           // Create new fileoutput stream object
           FileOutputStream fos = new FileOutputStream(path) ;
           fos.write(byteArray);
           fos.flush();
           fos.close() ;
           result = true ;
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
       return result ;
   } 
    
}
