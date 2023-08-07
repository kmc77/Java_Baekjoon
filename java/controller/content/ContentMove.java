package controller.content;

import Content.Content;
import Content.ContentDAO;
import controller.action.Action;
import controller.action.ActionForward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContentMove implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionForward forward = new ActionForward();
        String chInfo = (String) request.getAttribute("chInfo");
        int lastURI = chInfo.lastIndexOf('/');
        System.out.println(chInfo);
        System.out.println(chInfo.substring(lastURI+1));
        int boardNum = Integer.parseInt(chInfo.substring(lastURI+1));
        System.out.println(boardNum+"여긱가?");
        ContentDAO dao = new ContentDAO();
        Content co = dao.contentSelect(boardNum);
        request.setAttribute("co", co);
        forward.setPath("/content/contentView.jsp");
        forward.setRedirect(false);
        return forward;
    }
}