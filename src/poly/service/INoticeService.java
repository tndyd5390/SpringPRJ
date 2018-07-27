package poly.service;

import java.util.List;

import poly.dto.NoticeDTO;

public interface INoticeService {
	public int insertNotice(NoticeDTO nDTOasdlfjkasldifuasoeisj) throws Exception;
	public List<NoticeDTO> getNoticeList() throws Exception;
	public NoticeDTO getNoticeOne(NoticeDTO nDTO) throws Exception;
	public int deleteNotice(NoticeDTO nDTO) throws Exception;
	public NoticeDTO getNoticeCnt(String noticeNo) throws Exception;
}
