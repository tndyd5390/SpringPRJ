package poly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.NoticeDTO;
import poly.service.INoticeService;
import poly.util.CmmUtil;

@Controller
public class NoticeController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "NoticeService")
	private INoticeService noticeService;
	
	
	@RequestMapping(value="a")
	public String a() throws Exception{
		return "/a";
	}
	
	
	@RequestMapping(value="d")
	public String d() throws Exception{
		return "/d";
	}
	//e페이지를 만들고 d페이지에서 e페이지로 핸드폰 번호를 전송하여 콘솔에 출력!!!
	
	@RequestMapping(value="e")
	public String e(HttpServletRequest request) throws Exception{
		String phone = request.getParameter("phone");
		System.out.println(phone);
		return "/e";
	}
	
	@RequestMapping(value="bmi")
	public String bmi(HttpServletRequest request, Model model) throws Exception{
		
		String cm = request.getParameter("cm");
		String kg = request.getParameter("kg");
		//일단은 bmi계산 kg/(m * m)
		
		double bmi = Integer.parseInt(kg)/((Integer.parseInt(cm)*0.01)* (Integer.parseInt(cm)*0.01));
		
		model.addAttribute("bmi", bmi); // == request.setAttribute("bmi", bmi);
		return "/bmi";
	}
	
	@RequestMapping(value="redirect")
	public String redirect(HttpServletRequest reqeust, Model model) throws Exception{
		log.info("redirect");
		model.addAttribute("tmp", "nothing");
		
		
		return "redirect:/redirect";
	}
	
	@RequestMapping(value="notice/noticeRegView")
	public String noticeRegView(HttpServletRequest request, HttpSession session,
			Model model) throws Exception{
		log.info(this.getClass() + ".noticeRegView start");
		
		String id = CmmUtil.nvl((String)session.getAttribute("id"));
		
		if("".equals(id)){
			//로그인을 안한 상태 '로그인을 해주세요' alert띄우고 메인 페이지로 이동
			model.addAttribute("msg", "로그인을 해주세요");
			model.addAttribute("url", "/main.do");
			return "/alert";
		}
		
		return "/notice/noticeReg";
	}
	
	@RequestMapping(value="notice/noticeReg")
	public String noticeReg(HttpServletRequest request, Model model) throws Exception{
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setTitle(title);
		nDTO.setContents(contents);
		nDTO.setCnt(0);
		
		int result = noticeService.insertNotice(nDTO);
		
		if(result ==1){
			//게시판 등록 성공 '게시판 등록 성공'alert창 띄우고 main화면으로 이동
			model.addAttribute("msg", "등록성공");
			model.addAttribute("url", "/main.do");
		}else{
			//게시판 등록 실패 '게시판 등록 실패'alert창 띄우고 게시판 등록 화면
			model.addAttribute("msg", "등록실패");
			model.addAttribute("url", "/notice/noticeRegView.do");
		}
		
		return "/alert";
	}
	
	@RequestMapping(value="notice/noticeList")
	public String noticeList(Model model) throws Exception{
		log.info(this.getClass() + ".noticeList start!!!");
		
		List<NoticeDTO> nList = noticeService.getNoticeList();
		
		model.addAttribute("nList", nList);
		log.info(this.getClass()  + ".noticeList end!!!");
		return "/notice/noticeList";
	}
	
	@RequestMapping(value="notice/noticeDetail")
	public String noticeDetail(HttpServletRequest req, Model model) throws Exception{
		
		String noticeNo = req.getParameter("noticeNo");

		NoticeDTO nDTO = noticeService.getNoticeCnt(noticeNo);
		
		model.addAttribute("nDTO", nDTO);
		
		return "/notice/noticeDetail";
	}
	
	@RequestMapping(value="notice/noticeDelete")
	public String noticeDelete(HttpServletRequest req, Model model) throws Exception{
		String noticeNo = req.getParameter("noticeNo");
		
		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setNotice_no(noticeNo);
		
		int result = noticeService.deleteNotice(nDTO);
		
		if(result ==1){
			model.addAttribute("msg", "삭제성공");
		}else{
			model.addAttribute("msg", "삭제실패");
		}
		model.addAttribute("url", "/notice/noticeList.do");
		
		return "/alert";
		
	}
	
	
	
	
	
	
	
	
	
}
