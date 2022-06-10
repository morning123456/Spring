package kr.or.ddit.controller;

import java.io.File;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.command.MemberRegistCommand;
import com.jsp.command.SearchCriteria;
import com.jsp.controller.MakeFileName;
import com.jsp.dto.MemberVO;
import com.jsp.dto.NoticeVO;
import com.jsp.service.LoginSearchMemberService;
import com.jsp.service.NoticeService;

import kr.or.ddit.command.MemberModifyCommand;
import kr.or.ddit.command.NoticeModifyCommand;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("/main")
	public void main() {
	}

	@RequestMapping("/list")
	public ModelAndView list(SearchCriteria cri, HttpServletRequest request, ModelAndView mnv) throws SQLException {
		String url = "notice/list";

		Map<String, Object> dataMap = null;

		try {

			dataMap = noticeService.getNoticeList(cri);
		} catch (SQLException e) {
			// exceptionLogger.write(request, e, "MemberService");
			throw e;

		} catch (Exception e) {
			e.printStackTrace();
		}

		mnv.addObject("dataMap", dataMap);
		// mnv.addAllObjects(dataMap);
		mnv.setViewName(url);

		return mnv;
	}

	@RequestMapping(value = "/registForm", method = RequestMethod.GET)
	public String registForm() {
		String url = "notice/regist";
		return url;
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(NoticeVO notice) throws Exception {
		String url = "notice/regist_success";

		noticeService.regist(notice);

		return url;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(int nno, Model model) throws Exception {

		String url = "notice/detail";

		NoticeVO notice = noticeService.getNotice(nno);
		model.addAttribute("notice", notice);

		return url;
	}

	@RequestMapping(value = "/modifyForm", method = RequestMethod.GET)
	public String modifyForm(int nno, Model model) throws Exception {

		String url = "notice/modify";

		NoticeVO notice = noticeService.getNotice(nno);

		model.addAttribute("notice", notice);

		return url;
	}

	
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST, 
					produces = "text/plain;charset=utf-8")
	public String modify(NoticeModifyCommand modifyReq, HttpSession session, 
									RedirectAttributes rttr) throws Exception {

		String url = "redirect:/notice/detail.do";

		NoticeVO notice = modifyReq.toNoticeVO();

		
		
		//DB 내용 수정
		noticeService.modify(notice);	
		
		

//		// 로그인한 사용자의 경우 수정된 정보로 session 업로드
//		rttr.addFlashAttribute("parentReload",false);
//		NoticeVO loginUser = (NoticeVO) session.getAttribute("loginUser");
//		if (loginUser != null && notice.getId().equals(loginUser.getId())) {
//			session.setAttribute("loginUser", member);
//			rttr.addFlashAttribute("parentReload",true);
//		}
//		
//		rttr.addAttribute("id",member.getId()); 
//		rttr.addFlashAttribute("from","modify");
//		rttr.addFlashAttribute("member",memberService.getMember(modifyReq.getId())); //member -> vo = model
//		
		return url;
	}

	
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(int nno, HttpSession session, 
							RedirectAttributes rttr) throws Exception {
		String url = "redirect:/notice/detail.do";
		
		NoticeVO notice;
		
		
		//DB삭제
		noticeService.remove(nno);
		
		// 삭제되는 회원이 로그인 회원인경우 로그아웃 해야함.
//		NoticeVO loginUser = (NoticeVO) session.getAttribute("loginUser");
//		if (loginUser!=null && loginUser.getId().equals(member.getId())) {
//			session.invalidate();
//		}
//		
//		
//		rttr.addFlashAttribute("removeMember",member);		
//		rttr.addFlashAttribute("from","remove");
//		
//		rttr.addAttribute("id",id);
		
		return url;
	}
}









