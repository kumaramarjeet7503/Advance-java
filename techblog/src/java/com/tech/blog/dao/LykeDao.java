package com.tech.blog.dao;

import com.tech.blog.helper.ConnectionProvider;
import java.sql.ResultSet;

public class LykeDao {

    public LykeDao() {
    }
    
    public boolean insertLike(String postId, String userId)
    {
        boolean inserted = false ;
        
        try{
            String query = "insert into Lyke (PostId , UserId) values("+postId+","+userId+") " ;
            String[] values = {} ;
            inserted = QueryDao.executeInsert(query, values, ConnectionProvider.getConnection()) ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return inserted ;
    }
    
    public int countLikeOnPost(int postId, int userId)
    {
        int count = 0 ;
        
        try
        {
            String query = "select count(*) as count from Lyke where PostId = ? and UserId = ? "; 
             String[] values = { Integer.toString(postId), Integer.toString(userId)} ;
            ResultSet result = QueryDao.executeSelect(query, values, ConnectionProvider.getConnection()) ;
            if(result.next())
            {
                String rowCount = result.getString("count") ;
                count = Integer.parseInt(rowCount) ;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return count ;
    }
    
    public boolean isLikedByUser(int postId, int userId)
    {
        boolean liked = false ;
        
        try
        {
            String query = "select * as count from Lyke where PostId = ? and UserId = ? "; 
             String[] values = { Integer.toString(postId), Integer.toString(userId)} ;
            ResultSet result = QueryDao.executeSelect(query, values, ConnectionProvider.getConnection()) ;
            if(result.next())
            {
                liked = true ;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                
        return liked ;
    }
    
        public boolean deleteLike(int postId, int userId)
    {
        boolean liked = false ;
        
        try
        {
            String query = "delete from Lyke where PostId = ? and UserId = ? "; 
             String[] values = { Integer.toString(postId), Integer.toString(userId)} ;
            ResultSet result = QueryDao.executeSelect(query, values, ConnectionProvider.getConnection()) ;
            liked = true ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                
        return liked ;
    }
}
