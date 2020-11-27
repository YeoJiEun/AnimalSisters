package com.example.pet.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.pet.comment.RegiComment;
import com.example.pet.dao.MemberDAO;
import com.example.pet.comment.LoginComment;
import com.example.pet.comment.PetSitterComment;
import com.example.pet.domain.PetSitter;
import com.example.pet.domain.User;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
 
	// id와 pw과 일치하는 회원정보 가져오기 
    public User getMemberInfo(String id, String pw){
    	return memberDAO.selectUser(id, pw);
    }
    
    // 로그인 확인
    public boolean login(LoginComment login, User user, HttpSession session){   	
    	boolean result = false;
    	
    	if (user != null) {
	    	String login_id = login.getId();
	    	String login_pw = login.getPw();
	    	
	    	if (login_id.equals(user.getId()) && login_pw.equals(user.getPw())) {
	    		//session에  user 객체 저장
	    		session.setAttribute("user", user);
	    		result = true;
	    		System.out.println("user 정보 : " + user.toString());
	    	}	
    	}
    	
    	return result;
    }
    
    // 로그아웃
    public void logout(HttpSession session) {
    	session.invalidate();
    }
    
    // 회원가입
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=SQLException.class)
    public void insertUser(RegiComment regi, PetSitterComment sitterForm, String picture) {
    	User newUser = new User(0, regi.getId(), regi.getPw(), regi.getName(), regi.getNickname(), regi.getPhone(), regi.getAddr(), regi.getM_type());
    	memberDAO.insertUser(newUser);
    	
    	if (regi.getM_type().equals("2"))
    		memberDAO.insertPetSitter(new PetSitter(newUser.getM_num(), sitterForm.getAge(), sitterForm.getCareNum(), picture));
    }
    
    // 회원정보 수정
    public void updateUser(RegiComment regi, HttpSession session) {
    	User updateUser = new User(regi.getM_num(), regi.getId(), regi.getPw(), regi.getName(), regi.getNickname(), regi.getPhone(), regi.getAddr(), regi.getM_type());
    	memberDAO.updateUser(updateUser);
    	session.setAttribute("user", updateUser);
    }
    
    // 회원정보 삭제
    public void deleteUser(HttpSession session) {
    	User deleteUser = (User)session.getAttribute("user");
    	memberDAO.deleteUser(deleteUser.getM_num());
    	logout(session);
    }
    
    // 펫시터 찾기
    public PetSitter selectPetSitter(int m_num) {
    	return memberDAO.selectPetSitter(m_num);
    }  
    
    // 펫시터 등록
    public void insertPetSitter(int m_num, PetSitterComment sitterComment, String picture) {
    	PetSitter petSitter = new PetSitter(m_num, sitterComment.getAge(), sitterComment.getCareNum(), picture);
    	memberDAO.insertPetSitter(petSitter);
    }
    
    // 펫시터 수정
    public void updatePetSitter(int m_num, PetSitterComment sitterComment, String picture) {
    	PetSitter petSitter = new PetSitter(m_num, sitterComment.getAge(), sitterComment.getCareNum(), picture);
    	memberDAO.updatePetSitter(petSitter);
    }
    
    // 펫시터 삭제
    public void deletePetSitter(int m_num) {
    	memberDAO.deletePetSitter(m_num);
    }
    public List<PetSitter> selectAllPetSitter(){
    	return memberDAO.selectAllPetSitter();
    }
}
