package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.NoticeDTO;

@Mapper("NoticeMapper")
public interface NoticeMapper {

	public int insertNotice(NoticeDTO nDTO) throws Exception;
	public List<NoticeDTO> getNoticeList() throws Exception;
	public NoticeDTO getNoticeOnt(NoticeDTO nDTO) throws Exception;
	public int deleteNotice(NoticeDTO nDTO) throws Exception;
	public int updateNoticeCnt(String noticeNo) throws Exception;
	public NoticeDTO getNotice(String noticeNo) throws Exception;
	
}
