package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.NoticeDTO;
import poly.persistance.mapper.NoticeMapper;
import poly.service.INoticeService;

@Service("NoticeService")
public class NoticeService implements INoticeService{
	
	@Resource(name="NoticeMapper")
	private NoticeMapper noticeMapper;

	@Override
	public int insertNotice(NoticeDTO fuck) throws Exception {
		return noticeMapper.insertNotice(fuck);
	}

	@Override
	public List<NoticeDTO> getNoticeList() throws Exception {
		return noticeMapper.getNoticeList();
	}

	@Override
	public NoticeDTO getNoticeOne(NoticeDTO nDTO) throws Exception {
		return noticeMapper.getNoticeOnt(nDTO);
	}

	@Override
	public int deleteNotice(NoticeDTO nDTO) throws Exception {
		return noticeMapper.deleteNotice(nDTO);
	}

	@Override
	public NoticeDTO getNoticeCnt(String noticeNo) throws Exception {
		noticeMapper.updateNoticeCnt(noticeNo);
		return noticeMapper.getNotice(noticeNo);
	}
	
}
