package com.tt.talktok.controller;

import com.tt.talktok.dto.NoticeDto;
import com.tt.talktok.entity.Notice;
import com.tt.talktok.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
@Slf4j
public class NoticeController {

    private final NoticeService noticeService;

    // 공지사항 리스트
    @GetMapping("/list") //아무 설정 없이 @PageableDefault 어노테이션을 사용시, default 설정으로 페이징 기법이 발생.
    public String noticeList(@PageableDefault(page = 0, size = 10) Pageable pageable, Model model){

        Page<Notice> list = noticeService.getNoticePage(pageable);

        model.addAttribute("list", list);

        return "notice/notice";
    }

    // 공지사항 작성폼으로 이동
    @GetMapping("/write")
    public String noticeWrite() {
        return "notice/writeForm";
    }

    // 공지사항 작성후 db 저장
    @PostMapping("/write")
    public String write(NoticeDto noticeDto) {

        System.out.println("작성폼");
        log.info("noticeDto: {}", noticeDto);
        noticeService.noticeWrite(noticeDto);

        return "redirect:list";
    }

    // 공지사항 상세 정보 출력
    @GetMapping("/detail")
    public String noticeDetail(@RequestParam("noNo") int noNo, Model model) {
        Notice noticeDetail = noticeService.getNoticeDetail(noNo);
        model.addAttribute("noticeDetail", noticeDetail);
        return "notice/detail";
    }

    // 공지사항 수정
    @GetMapping("/update")
    public String noticeUpdate(@ModelAttribute Notice notice, Model model){
        Notice noticeUpdate = noticeService.getNoticeUpdate(notice.getNoNo());
        model.addAttribute("noticeUpdate", noticeUpdate);
        return "notice/updateForm";
    }
}
