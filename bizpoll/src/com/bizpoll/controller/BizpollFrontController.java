package com.bizpoll.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.action.Action;
import com.bizpoll.action.ActionForward;
import com.bizpoll.action.BoardAddAction;
import com.bizpoll.action.BoardDeleteAction;
import com.bizpoll.action.BoardDetailAction;
import com.bizpoll.action.BoardFormAction;
import com.bizpoll.action.BoardListAction;
import com.bizpoll.action.BoardModifyAction;
import com.bizpoll.action.BoardReplyAction;
import com.bizpoll.action.BoardReplyFormAction;
import com.bizpoll.action.ContractAction;
import com.bizpoll.action.DeleteAction;
import com.bizpoll.action.FindZipNumAction;
import com.bizpoll.action.IdCheckFormAction;
import com.bizpoll.action.ImagePreViewAction;
import com.bizpoll.action.IndexAction;
import com.bizpoll.action.JoinAction;
import com.bizpoll.action.JoinFormAction;
import com.bizpoll.action.LoginAct;
import com.bizpoll.action.LoginAction;
import com.bizpoll.action.LogoutAct;
import com.bizpoll.action.productDetail;

/**
 * Servlet implementation class BizpollFrontController
 */
@WebServlet("/BizpollFrontController")
public class BizpollFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BizpollFrontController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨짐 방지(post방식)
		request.setCharacterEncoding("UTF-8");
		
		//초기화
		Action action =null;
		ActionForward forward = null;
		
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());
		
		System.out.println("uri ===>" + uri);
		System.out.println("ctx ===>" + ctx);
		System.out.println("command ===>" + command);
		// -------------- 액션 맵핑 --------------
		if(command.equals("/index.bizpoll")) {
			System.out.println("여기는 index입니다.");
			action = new IndexAction();
			forward = action.excute(request, response);
		}else if(command.equals("/product_detail.bizpoll")){
			action = new productDetail();
			forward = action.excute(request, response);
		}else if(command.equals("/login_action.bizpoll")) {
			action = new LoginAction();
			forward = action.excute(request, response);
		}else if(command.equals("/login.bizpoll")) {
			action = new LoginAct();
			forward = action.excute(request, response);
		}else if(command.equals("/logout.bizpoll")) {
			action = new LogoutAct();
			forward = action.excute(request, response);
		}else if(command.equals("/contract.bizpoll")) {
			action = new ContractAction();
			forward = action.excute(request, response);
		}else if(command.equals("/join_form.bizpoll")) {
			action = new JoinFormAction();
			forward = action.excute(request, response);
		}else if(command.equals("/id_check_form.bizpoll")) {
			action = new IdCheckFormAction();
			forward = action.excute(request, response);
		}else if(command.equals("/find_zip_num.bizpoll")) {
			action = new FindZipNumAction();
			forward = action.excute(request, response);
		}else if(command.equals("/join.bizpoll")) {
			action = new JoinAction();
			forward = action.excute(request, response);
		}else if(command.equals("/delete.bizpoll")) {
			action = new DeleteAction();
			forward = action.excute(request, response);
		}
		
		// -------------- 게시판 액션 맵핑 --------------
		if (command.equals("/boardList.bizpoll")) {
			action = new BoardListAction();
			forward = action.excute(request, response);
		}else if (command.equals("/boardForm.bizpoll")) {
			action = new BoardFormAction();
			forward = action.excute(request, response);
		}else if (command.equals("/boardAdd.bizpoll")) {
			action = new BoardAddAction();
			forward = action.excute(request, response);
		}else if (command.equals("/boardDetail.bizpoll")) {
			action = new BoardDetailAction();
			forward = action.excute(request, response);
		}else if(command.equals("/boardDelete.bizpoll")) {
			action = new BoardDeleteAction();
			forward = action.excute(request, response);
		}else if(command.equals("/boardModify.bizpoll")) {
			action = new BoardModifyAction();
			forward = action.excute(request, response);
		}else if(command.equals("/imagePreView.bizpoll")) {
			action = new ImagePreViewAction();
			forward = action.excute(request, response);
		}else if(command.equals("/boardReplyForm.bizpoll")) {
			action = new BoardReplyFormAction();
			forward = action.excute(request, response);
		}else if(command.equals("/boardReply.bizpoll")) {
			action = new BoardReplyAction();
			forward = action.excute(request, response);
		}
			
		
			
		
		
		// -------------- 공통 분기작업 -------------- 
		if(forward !=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}
	}
}

