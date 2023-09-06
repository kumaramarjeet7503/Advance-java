/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tag;

import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author amarj
 */
public class TagHandler extends TagSupport {

    private int number ;
    public void setNumber(int number)
    {
        this.number = number ;
    }
    
    @Override
    public int doStartTag() throws JspException {
        
        try{
             JspWriter out = pageContext.getOut() ;
             out.println("<h1>This is a tag handler</h1>");
             out.println("The number is "+number);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       
        return super.doStartTag(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
