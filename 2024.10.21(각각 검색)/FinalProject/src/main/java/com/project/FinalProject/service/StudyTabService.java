package com.project.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project.FinalProject.domain.StudyTab;
import com.project.FinalProject.repository.StudyTabRepository;

@Service
public class StudyTabService {
	
	@Autowired
	private StudyTabRepository studyTabRepository;
	
	//기존 findAll 메소드
	public Page<StudyTab> findAll(PageRequest page) {
		return studyTabRepository.findAll(page);
		}
	
	//pId로 검색
    public List<StudyTab> findByPId(String pId) {
        return studyTabRepository.findByPId(pId);
        }
    
    //pName으로 검색
    public List<StudyTab> findByPName(String pName) {
        return studyTabRepository.findByPName(pName);
        }
    
    // studyDate로 검색
    public List<StudyTab> findByStudyDateBetween(String startDate, String endDate) {
        return studyTabRepository.findByStudyDateBetween(startDate, endDate);
    	}
    
    // reportStatus로 검색
    public List<StudyTab> findByReportStatus(Long reportStatus) {
        return studyTabRepository.findByReportStatus(reportStatus);
    	}
    
    // modality로 검색
    public List<StudyTab> findByModality(String modality) {
        return studyTabRepository.findByModality(modality);
    }
    
    public List<StudyTab> findByVerifyFlag(Long verifyFlag) {
        return studyTabRepository.findByVerifyFlag(verifyFlag);
    }
    
    }

