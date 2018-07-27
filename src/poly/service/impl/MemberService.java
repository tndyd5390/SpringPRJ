package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.MemberDTO;
import poly.persistance.mapper.MemberMapper;
import poly.service.IMemberService;

@Service("MemberService")
public class MemberService implements IMemberService {
	
	
	//Resource는 new와 같은데 싱글톤 패턴을 적용시킨다.
	//아래문장은 private MemberMapper memberMapper = new MemberMapper();
	//와 같은 문장이다.
	@Resource(name="MemberMapper")
	private MemberMapper memberMapper;
	
	@Override
	public int insertMember(MemberDTO mDTO) throws Exception {
		//반환값이 int인 이유는
		//insert, update, delete문은 int를 반환한다.
		//select는 dto 또는 java의 HashMap을 반환한다.
		return memberMapper.insertMember(mDTO);
	}

	@Override
	public List<MemberDTO> getMemberList() throws Exception {
		return memberMapper.getMemberList();
	}

	@Override
	public MemberDTO getMemberDetail(MemberDTO mDetail) throws Exception {
		return memberMapper.getMemberDetail(mDetail);
	}

	@Override
	public int deleteMember(MemberDTO dto) throws Exception {
		return memberMapper.deleteMember(dto);
	}

	@Override
	public int updateMember(MemberDTO dto) throws Exception {
		return memberMapper.updateMember(dto);
	}

	@Override
	public MemberDTO getLogin(MemberDTO mDTO) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(mDTO.getId());
		return memberMapper.getLogin(mDTO);
	}

}
