package com.project.FinalProject.controller;

import java.util.List;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.FinalProject.domain.StudyTab;
import com.project.FinalProject.service.StudyTabService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;

@Controller
public class StudyTabController {

	@Autowired
	StudyTabService studyTabService;
	
	// 중첩된 검색 가능
	@GetMapping("/search")
	public String searchStudies(@RequestParam(value = "pId", required = false) String pId,
			@RequestParam(value = "pName", required = false) String pName,
			@RequestParam(value = "modality", required = false) String modality,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "reportStatus", required = false) Long reportStatus,
			@RequestParam(value = "verifyFlag", required = false) Long verifyFlag, Model model) {
		
		List<StudyTab> studies = studyTabService.searchStudies(
				pId, pName, modality, startDate, endDate, reportStatus,verifyFlag);
		model.addAttribute("studyTabs", studies);
		
		// 검색 후에도 값 유지
		model.addAttribute("pId", pId);
		model.addAttribute("pName", pName);
		model.addAttribute("modality", modality);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("reportStatus", reportStatus);
		model.addAttribute("verifyFlag", verifyFlag);
		
		return "home";
		}
	}
