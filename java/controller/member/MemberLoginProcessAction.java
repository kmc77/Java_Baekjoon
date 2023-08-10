package controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Member.DB.MemberDAO;
import controller.action.Action;
import controller.action.ActionForward;
import util.messeage;

public class MemberLoginProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
																throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		MemberDAO mdao = new MemberDAO();
		
		int result = mdao.isuserId(userId, userPw);
		System.out.println("결과는 " + result);
		
		
		if(result == 1) {										//로그인 성공시
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			
			String IDStore = request.getParameter("remember");
			Cookie cookie = new Cookie("userId", userId);
			
			
			if (IDStore != null && IDStore.equals("store")) {	//ID 기억하는 경우
				cookie.setMaxAge(2 * 60);
				
				response.addCookie(cookie);
				System.out.println("쿠키확인");
				
			}else {
				cookie.setMaxAge(0);			
				response.addCookie(cookie);
			}
		
			forward.setRedirect(true);
			forward.setPath("/project");				//로그인 성공 후 id값을 세션으로 들고감
			
			return forward;
			
		}else {													//로그인 실패시
			String message = messeage.PASSWORD.MISMATCH;
			
			if(result == -1)
				message = messeage.ID.NOT_EXEIST;
			
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<script>"
					  + "alert('" + message + "');"
					  + "location.href='/project';"				//메인페이지로 이동, 비로그인 상태
					  + "</script>");							//컨트롤러에서 protomain.me로 설정해야하는지?
			
			out.close();
			
			return null;
			
		}//if end
		
		
	}

}
