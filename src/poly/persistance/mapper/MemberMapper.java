package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.MemberDTO;

@Mapper("MemberMapper")
public interface MemberMapper {
	public int insertMember(MemberDTO mDTO) throws Exception;
	public List<MemberDTO> getMemberList() throws Exception;
	public MemberDTO getMemberDetail(MemberDTO mDetail) throws Exception;
	public int deleteMember(MemberDTO dto) throws Exception;
	public int updateMember(MemberDTO dto) throws Exception;
	public MemberDTO getLogin(MemberDTO mDTO) throws Exception;
}
