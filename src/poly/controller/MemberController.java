package poly.controller;

import java.lang.ref.ReferenceQueue;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.xml.internal.dtm.DTMDOMException;

import poly.dto.MemberDTO;
import poly.service.IMemberService;
import poly.service.impl.MemberService;

@Controller
public class MemberController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="MemberService")
	private IMemberService memberService;
	
	@RequestMapping(value="main")
	public String main(HttpServletRequest request, Model model) throws Exception{
		return "/main";
	}
	
	@RequestMapping(value="member/memberReg")
	public String memberReg() throws Exception{
		return "/member/memberReg";
	}
	
	@RequestMapping(value="member/memberProc")
	public String memberProc(HttpServletRequest request, Model model) throws Exception{
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String addrDetail = request.getParameter("addrDetail");

		//데이터들을 처리하기 위해 만든 클래스를 dto라 고 부른다
		//dto(data transfer object)
		
		MemberDTO mDTO = new MemberDTO();
		mDTO.setId(id);
		mDTO.setPassword(password);
		mDTO.setMember_name(name);
		mDTO.setMember_addr(addr);
		mDTO.setMember_addrDetail(addrDetail);
		//dto를 데이터베이스에 insert해야하는데
		//insert 과정은 Controller -> Service -> Mapper -> SQL -> Mapper -> Service -> Controller
		
		int result = memberService.insertMember(mDTO);
		
		if(result != 0){
			//회원가입에 성공
			model.addAttribute("msg", "회원가입에 성공하셨습니다.");
			model.addAttribute("url", "/main.do");
		}else{
			//회원가입에 실패
		}
		
		return "/alert";
	}
	
	@RequestMapping(value="member/memberList")
	public String memberList(Model model) throws Exception{
		log.info(this.getClass() + ".memberList start!!!");
		
		//회원 목록을 불러올 로직을 작성
		
		List<MemberDTO> mList = memberService.getMemberList();
		
		/*for(int i = 0; i< mList.size();i++){
			MemberDTO mDTO = mList.get(i);
			System.out.println(mDTO.getMember_name());
			//위 두줄과 아래 한줄은 같은 의미
			System.out.println(mList.get(i).getMember_name());
		}*/
		model.addAttribute("mList", mList);
		log.info(this.getClass() + ".memberList end!!!");		
		return "/member/memberList";
	}
	
	@RequestMapping(value="member/memberDetail")
	public String memberDetail(HttpServletRequest request, Model model) throws Exception{
		log.info(this.getClass() + ".memberDetail start!!!");
		String memberNo = request.getParameter("memberNo");
		log.info("memberNo : " + memberNo);
		
		MemberDTO mDetail = new MemberDTO();
		mDetail.setMember_no(memberNo);
		 
		mDetail = memberService.getMemberDetail(mDetail);
		
		model.addAttribute("mDetail", mDetail);
		
		return "/member/memberDetail";
	}
	
	@RequestMapping(value="member/memberDelete")
	public String memberDelete(HttpServletRequest request, HttpServletResponse resp, Model model) throws Exception{
		String memberNo = request.getParameter("memberNo");
		log.info("memberNo : " + memberNo);
		MemberDTO mDTO = new MemberDTO();
		mDTO.setMember_no(memberNo);
		memberService.deleteMember(mDTO);
		
		return "redirect:/member/memberList.do";
	}
	
	@RequestMapping(value="member/updateView")
	public String updateView(HttpServletRequest request, Model model) throws Exception{
		String memberNo = request.getParameter("memberNo");
		log.info("memberNo : " + memberNo);
		
		MemberDTO mDTO = new MemberDTO();
		mDTO.setMember_no(memberNo);
		
		mDTO = memberService.getMemberDetail(mDTO);
		model.addAttribute("mDTO", mDTO);
		return "/member/memberUpdateView";
	}
	
	@RequestMapping(value="member/memberUpdateProc")
	public String updateProc(HttpServletRequest request, Model model) throws Exception{
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String addrDetail = request.getParameter("addrDetail");
		String memberNo = request.getParameter("memberNo");
		
		MemberDTO mdto = new MemberDTO();
		mdto.setId(id);
		mdto.setPassword(password);
		mdto.setMember_name(name);
		mdto.setMember_addr(addr);
		mdto.setMember_addrDetail(addrDetail);
		mdto.setMember_no(memberNo);
		
		int result = memberService.updateMember(mdto);
		
		//수정에 성공했을경우 '수정성공'alert창 띄우고 main페이지로 이동
		//수정에 실패했을 경우 '수정 실패' alert창 띄우고 main페이지로 이동
		
		if(result != 0){
			model.addAttribute("msg", "수정성공");
		}else{
			model.addAttribute("msg", "수정실패");
		}
		model.addAttribute("url", "/main.do");
		return "/alert";
	}
	
	@RequestMapping(value="member/loginProc")
	public String loginProc(HttpServletRequest request, HttpSession session)throws Exception{
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("id : " + id);
		System.out.println("password : " + password);
		MemberDTO mDTO = new MemberDTO();
		mDTO.setId(id);
		mDTO.setPassword(password);
		
		mDTO = memberService.getLogin(mDTO);
		
		if(mDTO == null){
			//로그인 오류
		}else{
			//로그인 성공
			session.setAttribute("id", mDTO.getId());
		}
		
		return "/main";
	}
	
}
