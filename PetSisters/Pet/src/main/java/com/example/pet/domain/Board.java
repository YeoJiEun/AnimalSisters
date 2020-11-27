package com.example.pet.domain;
import java.util.Date;
import java.util.List;

public class Board {
   private int b_num;
   private int m_num;
   private Date b_date;
   private String b_where;
   private int price;
   private String b_detail;
   private String b_type;
   private String b_title;
   private String b_picture;
   
   public Board() {  }
   
   public Board(int b_num, int m_num, Date b_date, String b_where, int price, String b_detail, String b_type,
         String b_title, String b_picture) {
      super();
      this.b_num = b_num;
      this.m_num = m_num;
      this.b_date = b_date;
      this.b_where = b_where;
      this.price = price;
      this.b_detail = b_detail;
      this.b_type = b_type;
      this.b_title = b_title;
      this.b_picture = b_picture;
   }

   //insert
   public Board(int b_num, int m_num, Date b_date, String b_where, int price, String b_detail, String b_type,
         String b_title) {
      super();
      this.b_num = b_num;
      this.m_num = m_num;
      this.b_date = b_date;
      this.b_where = b_where;
      this.price = price;
      this.b_detail = b_detail;
      this.b_type = b_type;
      this.b_title = b_title;
   }
  
   public Board(int b_num, int m_num, Date b_date, String b_where, int price, String b_detail, String b_type,String b_title, List<Reservation> reservationList) {
      super();
      this.b_num = b_num;
      this.m_num = m_num;
      this.b_date = b_date;
      this.b_where = b_where;
      this.price = price;
      this.b_detail = b_detail;
      this.b_type = b_type;
      this.b_title = b_title;    
   }
   
   public String getB_picture() { return b_picture; }
   public void setB_picture(String b_picture) { this.b_picture = b_picture; }
   
   public String getB_title() { return b_title; }
   public void setB_title(String b_title) { this.b_title = b_title; }

   public int getB_num() { return b_num; }
   public void setB_num(int b_num) { this.b_num = b_num; }
   
   public int getM_num() { return m_num; }  
   public void setM_num(int m_num) { this.m_num = m_num; }
   
   public Date getB_date() { return b_date; }
   public void setB_date(Date b_date) { this.b_date = b_date; }
   
   public String getB_where() { return b_where; }   
   public void setB_where(String b_where) { this.b_where = b_where; }
   
   public int getPrice() { return price; }  
   public void setPrice(int price) { this.price = price; }
   
   public String getB_detail() { return b_detail; }   
   public void setB_detail(String b_detail) { this.b_detail = b_detail; }
   
   public String getB_type() { return b_type; }   
   public void setB_type(String b_type) { this.b_type = b_type; } 
}