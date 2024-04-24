package com.tt.talktok.service;

import com.tt.talktok.dto.NoticeDto;
import com.tt.talktok.entity.Notice;
import com.tt.talktok.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.Builder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@Builder
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    // DTO에서 엔터티로 변환하는 메서드
    public Notice convertToEntity(NoticeDto dto) {
        return Notice.builder()
//                .noNo(dto.getNoNo())
                .no_subject(dto.getNo_subject())
                .no_content(dto.getNo_content())
//                .no_readcount(dto.getNo_readcount())
                .build();
    }

    // 엔터티에서 DTO로 변환하는 메서드
    public NoticeDto convertToDto(Notice entity) {
        return NoticeDto.builder()
//                .noNo(entity.getNoNo())
                .no_subject(entity.getNo_subject())
                .no_content(entity.getNo_content())
//                .no_readcount(entity.getNo_readcount())
                .build();
    }


    //페이징
    public Page<Notice> getNoticePage(Pageable pageable) {

        return noticeRepository.findAll(pageable);
    }

    //저장
    public void noticeWrite(NoticeDto noticeDto){
        Notice notice = Notice.builder()
                .no_subject(noticeDto.getNo_subject())
                .no_content(noticeDto.getNo_content())
                .build();
        noticeRepository.save(notice);
    }

    //상세
    public Notice getNoticeDetail(Integer noNo) {

        return noticeRepository.findById(noNo).orElse(null);
    }

    public Notice getNoticeUpdate(Integer noNo) {
        retur
    }
}
