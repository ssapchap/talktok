package com.tt.talktok.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class TeacherController {

    private final TeacherService teacherService;

    // TeacherList
    @GetMapping("/list")
    public String tourList(Teacher teacher Model model) {
        List<Teacher> searchTeacherList = new ArrayList<>();

        int limit = 12;

        search.setLimit(limit);

        int startRow = (search.getPage() - 1) * limit;
        int endRow = startRow + 10 -1; search.setStartRow(startRow);

        searchTourList = tourService.searchTourList(search);

        int count = tourService.searchTourCount(search);
        int maxPage = count / limit + ((count % 10 ==0)? 0:1);
        int startPage = ((search.getPage()-1) /10) * 10 +1;
        int endPage = startPage + 10 - 1;
        if(endPage > maxPage) endPage = maxPage;

        model.addAttribute("search", search);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("tourCount", count);
        model.addAttribute("tourList", searchTourList);

        return "tour/list";

    }

    @GetMapping("/detail")
    public String tourDetail(@RequestParam("tour_id") int tour_id, Model model) {

        Tour tourDetail = tourService.getTourOne(tour_id);

        model.addAttribute("tour", tourDetail);

        return "tour/detail";

    }
