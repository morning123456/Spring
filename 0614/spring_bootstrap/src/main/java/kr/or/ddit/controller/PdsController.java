package kr.or.ddit.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;


	@Controller
	@RequestMapping("/pds")
	public class PdsController {
		

		@Resource(name="pdsService")
		private PdsService service;
		
		@RequestMapping("/main")
		public String main()throws Exception{
			String url="pds/main";
			return url;
		}
		
		@RequestMapping("/list")
		public ModelAndView list(SearchCriteria cri, ModelAndView mnv)throws SQLException{
			String url="pds/list";		
			
			Map<String,Object> dataMap = service.getList(cri);
			
			mnv.addObject("dataMap",dataMap);
			mnv.setViewName(url);
			
			return mnv;
		}
		
		@RequestMapping("/registForm")
		public String registForm(){
			String url="pds/regist";		
			return url;
		}
		
		@RequestMapping("/regist")
		public String regist(PdsVO pds,HttpServletRequest request, //PdsVO board,
							 RedirectAttributes rttr)throws Exception{
			String url="redirect:/pds/list.do";	
			
			pds.setTitle((String)request.getAttribute("XSStitle"));
			
			service.regist(pds);
			
			rttr.addFlashAttribute("from","regist");
			
			return url;
		}
		
		@RequestMapping("/detail")
		public ModelAndView detail(int pno,String from, ModelAndView mnv )throws SQLException{
			String url="pds/detail";		
			
			PdsVO pds =null;
			if(from!=null && from.equals("list")) {
				pds=service.read(pno);
				url="redirect:/pds/detail.do?pno="+pno;
			}else {
				pds=service.getPds(pno);
			}
						
			mnv.addObject("pds",pds);		
			mnv.setViewName(url);
			
			return mnv;
		}
		
		@RequestMapping("/modifyForm")
		public ModelAndView modifyForm(int pno,ModelAndView mnv)throws SQLException{
			String url="pds/modify";
			
			PdsVO pds = service.getPds(pno);
			
			mnv.addObject("pds",pds);		
			mnv.setViewName(url);
			
			return mnv;
		}
		
		@RequestMapping(value="/modify",method=RequestMethod.POST)
		public String modifyPost(PdsVO pds,HttpServletRequest request, //BoardModifyCommand modifyReq,
								 RedirectAttributes rttr) throws Exception{
			
			String url = "redirect:/pds/detail.do";
			
			pds.setTitle((String)request.getAttribute("XSStitle"));
					
			service.modify(pds);
			
			rttr.addFlashAttribute("from","modify");
			rttr.addAttribute("pno",pds.getPno());
			
			return url;
		}
		
		@RequestMapping(value="/remove",method=RequestMethod.POST)
		public String remove(int pno,RedirectAttributes rttr) throws Exception{
			String url = "redirect:/pds/detail";
			service.remove(pno);		
			
			rttr.addAttribute("pno",pno);
			rttr.addFlashAttribute("from","remove");
			return url;		
		}
}
