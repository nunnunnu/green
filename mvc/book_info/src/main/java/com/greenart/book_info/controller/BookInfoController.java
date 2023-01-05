package com.greenart.book_info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greenart.book_info.VO.BookAddVO;
import com.greenart.book_info.entity.BookInfoEntity;
import com.greenart.book_info.repository.BookInfoRepository;
import com.greenart.book_info.repository.PublishCompanyRepository;
import com.greenart.book_info.repository.TranslatorInfoRepository;
import com.greenart.book_info.repository.WriterInfoRepository;

@Controller
@RequestMapping("/book")
public class BookInfoController {

     @Autowired TranslatorInfoRepository tRepo;
     @Autowired WriterInfoRepository wRepo;
     @Autowired BookInfoRepository bRepo;
     @Autowired PublishCompanyRepository pRepo;

     @GetMapping("/add")
     public String getBookAdd(Model model){
          model.addAttribute("writerList", wRepo.findAll());
          model.addAttribute("translatorList", tRepo.findAll());
          model.addAttribute("publisherList", pRepo.findAll());
          return "/book/add";
     }
     @PostMapping("/add")
     public String postBookAdd(BookAddVO data){
          BookInfoEntity entity = BookInfoEntity.builder()
               .biTitle(data.getTitle())
               .biSubTitle(data.getSub_title())
               .biPrice(data.getPrice())
               .biDiscount(data.getDiscount()/100.0)
               .biPoint(data.getPoint()/100.0)
               .biPubDt(data.getPub_dt())
               .writer(wRepo.findByWiSeq(data.getWriter()))
               .translator(tRepo.findByTiSeq(data.getTranslator()))
               .publisher(pRepo.findByPcSeq(data.getPublisher()))
               .build();
          bRepo.save(entity);
          return "redirect:/";
     }

     
}
