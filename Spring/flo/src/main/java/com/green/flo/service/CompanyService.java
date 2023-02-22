package com.green.flo.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.flo.entity.CompanyEntity;
import com.green.flo.repository.CompanyRepository;

@Service
public class CompanyService {
     @Autowired CompanyRepository companyRepository;

     public Map<String, Object> getCompanyList(String keyword, Pageable pageable) {
          Page<CompanyEntity> page = companyRepository.findByNameContains(keyword, pageable);
          Map<String, Object> map = new LinkedHashMap<>();
          map.put("list", page.getContent());
          map.put("total", page.getTotalElements());
          map.put("totalPage", page.getTotalPages());
          map.put("currentPage", page.getNumber());
          return map;
     }
     public Map<String, Object> addCompanyInfo(String name){
          Map<String, Object> resultMap = new LinkedHashMap<>();
          if(name.equals("")){
               resultMap.put("status", false);
               resultMap.put("message", "소속사가 입력되지 않았습니다.");
          }else if(companyRepository.countByName(name)==0){
               CompanyEntity company = CompanyEntity.builder().name(name).build();
               companyRepository.save(company);
               resultMap.put("status", true);
               resultMap.put("message", "소속사 정보를 추가했습니다.");
          }else{
               resultMap.put("status", false);
               resultMap.put("message", name+"는 이미 존재합니다.");
          }
          return resultMap;
     }
     @Transactional
     public void deleteCompany(Long company_no) {
          companyRepository.deleteById(company_no);
     }
     public Map<String, Object> selectCompanyInfo(Long company_no) {
          Map<String, Object> resultMap = new LinkedHashMap<>();
          Optional<CompanyEntity> entityOpt = companyRepository.findById(company_no);
          if(entityOpt.isEmpty()){
               resultMap.put("status", false);
          }else{
               resultMap.put("status", true);
               resultMap.put("no", entityOpt.get().getSeq());
               resultMap.put("name", entityOpt.get().getName());
          }
          
          return resultMap;
     }
     public Map<String, Object> updateCompanyInfo(Long no, String name) {
          Map<String, Object> map = new LinkedHashMap<>();
          Optional<CompanyEntity> entityOpt = companyRepository.findById(no);
          
          if(entityOpt.isEmpty()){
               map.put("status", false);
               map.put("no", no);
               map.put("name", name);
               map.put("message", "잘못된 소속사 정보입니다.");
          }else if(entityOpt.get().getName().equalsIgnoreCase(name)){
               map.put("status", false);
               map.put("no", no);
               map.put("name", name);
               map.put("message", "소속사 이름이 변경되지 않았습니다.");
          }else if(companyRepository.countByName(name)!=0){
               map.put("status", false);
               map.put("no", no);
               map.put("name", name);
               map.put("message", name+"는 이미 존재합니다.");
          }else if(name.equals("")){
               map.put("status", false);
               map.put("no", no);
               map.put("name", name);
               map.put("message", "변경할 이름을 입력해주세요.");
          }else{
               CompanyEntity entity = CompanyEntity.builder().name(name).seq(no).build();
               companyRepository.save(entity);
               map.put("status", true);
               map.put("message", "소속사 이름을 변경했습니다.");
          }    
          return map;
     }
}
