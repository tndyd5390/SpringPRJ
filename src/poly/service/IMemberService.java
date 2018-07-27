package poly.service;

import java.util.List;

import com.mysql.fabric.xmlrpc.base.Member;

import poly.dto.MemberDTO;

public interface IMemberService {
	public int insertMember(MemberDTO mDTO) throws Exception;
	public List<MemberDTO> getMemberList() throws Exception;
	public MemberDTO getMemberDetail(MemberDTO mDetail) throws Exception;
	public int deleteMember(MemberDTO dto) throws Exception;
	public int updateMember(MemberDTO dto) throws Exception;
	public MemberDTO getLogin(MemberDTO mDTO) throws Exception;
}
