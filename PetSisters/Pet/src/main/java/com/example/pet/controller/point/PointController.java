package com.example.pet.controller.point;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pet.domain.Comments;
import com.example.pet.domain.Point;
import com.example.pet.domain.UsedMarket;
import com.example.pet.domain.User;
import com.example.pet.service.CommentsService;
import com.example.pet.service.PointService;
import com.example.pet.service.UsedMarketService;

@Controller
@RequestMapping("/view/point/*")
public class PointController {

	@Autowired(required=true)
	private PointService pointService;
	@Autowired(required=true)
	private UsedMarketService usedMarketService;
	@Autowired(required = true)
	private CommentsService commentsService;

	@ModelAttribute("Point")
	public Point formBacking() {
		return new Point();
	}

	@RequestMapping(value = "/point_main", method = RequestMethod.GET)
	public String search(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Point> pointArr = pointService.selectPoint(user.getM_num());
		
		if (pointArr.size() <= 0) {
			model.addAttribute("msg", "point_null");
		} else {
			model.addAttribute("msg", "point");
			model.addAttribute("pointArr", pointArr);
		}
		
		model.addAttribute("url", "point");
		
		return "user/mypage/mypage_main";
	}

	@RequestMapping(value = "/used_market/{uNum}", method = RequestMethod.GET)
	public String insert(@PathVariable int uNum, Model model, HttpSession session, HttpServletRequest request) {
		// 중고거래가 이루어진 날짜 구하기(오늘 날짜)
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		String date = sdf.format(cal.getTime());

		// 글 번호로 게시글 찾기
		UsedMarket usedMarket = usedMarketService.selectUsedMarketByNum(uNum);
		int price = usedMarket.getuPrice();

		
		/* buyer 설정 */
		// 글번호로 댓글 찾기(선착순 정렬)
		Comments comment = commentsService.selectCommentByNum(uNum);
		int buyer = comment.getmNum();
		List<Point> b_pointArr = pointService.selectPoint(buyer);
		System.out.println(b_pointArr);
		int b_balance;

		// 포인트 내역이 없을 경우 포인트거래 불가
		if (b_pointArr.size() == 0) {
			System.out.println("b_pointArr null");
			return "redirect:/used_market/mypage/pointFailed";
		} else {
			b_balance = (int) b_pointArr.get(b_pointArr.size() - 1).getPo_balance();
			// 포인트가 중고거래 물품의 가격보다 부족할 경우 포인트거래 불가
			if (b_balance < price) {
				System.out.println("buyer point 부족");
				return "redirect:/used_market/mypage/pointFailed";
			}
		}
		
		String b_log = "중고거래 구매-" + price + "point";
		Point buyerPoint = new Point(buyer, (b_balance - price), b_log, date);
		System.out.println("buyer: " + buyerPoint);

		
		/* seller 설정 */
		int seller = usedMarket.getmNum();
		List<Point> s_pointArr = pointService.selectPoint(seller);
		int s_balance;
		
		if (s_pointArr.size() == 0) {
			s_balance = 0;
		} else {
			s_balance = (int) s_pointArr.get(s_pointArr.size() - 1).getPo_balance();
		}
		
		String s_log = "중고거래 판매-" + price + "point";
		Point sellerPoint = new Point(seller, (s_balance + price), s_log, date);
		System.out.println("seller: " + sellerPoint);

		// 오류가 없을시 포인트거래 성사
		if (pointService.insertPoint(sellerPoint) != 1)
			System.out.println("seller point insert error");
		if (pointService.insertPoint(buyerPoint) != 1)
			System.out.println("buyer point insert error");

		return "redirect:/used_market/updateTF/" + uNum;
	}
}
