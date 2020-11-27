package com.example.pet.comment;

import org.springframework.web.multipart.MultipartFile;

public class boardComment {
   private String b_pictureUrl;
   private MultipartFile b_picture;
   
   public boardComment(){  }

   public String getB_pictureUrl() { return b_pictureUrl; }
   public void setB_pictureUrl(String b_pictureUrl) { this.b_pictureUrl = b_pictureUrl; }

   public MultipartFile getB_picture() { return b_picture; }
   public void setB_picture(MultipartFile b_picture) { this.b_picture = b_picture; }

   public boardComment(String b_pictureUrl, MultipartFile b_picture) {
      super();
      this.b_pictureUrl = b_pictureUrl;
      this.b_picture = b_picture;
   }

   public boardComment(MultipartFile b_picture) {
      super();
      this.b_picture = b_picture;
   }
}