package com.project1.member;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.servlet.view.RedirectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class MemberController {

    static String path ="/Users/hwangjiwon/eclipse-workspace/TravelMaker/TravelMaker/src/main/resources/static/upload/";

    @Resource(name = "memberService")
    MemberService memberService;


    @RequestMapping("/member/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/login");
        return mv;
    }

    @RequestMapping("/member/signUp")
    public ModelAndView signUp(HttpSession session) {
        log.info("signUp");
        System.out.println("signup : "+session.getAttribute("email"));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/signUp");
        return mv;
    }

    @RequestMapping("/member/callSignUp")
    public String callSignUp() {
        log.info("callSignUp");
        return "redirect:/member/signUp";
    }


    @RequestMapping(value="/member/callBack", method=RequestMethod.GET)
    public ModelAndView callBack(){
        log.info("callBack");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/callBack");
        return mv;
    }

    @RequestMapping(value = "/member/naverCheck", method = RequestMethod.POST)
    public @ResponseBody String naverCheck(@RequestParam("n_email") String email, @RequestParam("n_id") String id, @RequestParam("n_name") String name, HttpSession session) {

        log.info("naverCheck");
        MemberDto memberDto = new MemberDto();
        memberDto.setEmail(email);
        memberDto.setUserComment(id);

        String result = memberService.naverCheck(memberDto);
        log.info(result);

        session.setAttribute("email", email);
           
        
        return result;
    }

    @RequestMapping(value = "/member/kakaoCheck", method = RequestMethod.POST)
    public @ResponseBody String kakaoCheck(@RequestParam("kakao_email") String email, HttpSession session) {

        log.info("kakaoCheck");
        MemberDto memberDto = new MemberDto();
        memberDto.setEmail(email);

        String result = memberService.naverCheck(memberDto);

        //if(result == "registered") {
            session.setAttribute("email", email);
        //}
        return result;
    }

    @RequestMapping(value = "/member/newSignUp", method = RequestMethod.POST)
    public @ResponseBody String memberSignUp(@RequestParam("email") String email, @RequestParam("nickName") String nickname, @RequestParam("intro") String intro, HttpSession session) {

        log.info("newSignUp");
        MemberDto memberDto = new MemberDto();
        memberDto.setUserComment(intro);
        memberDto.setNickname(nickname);

        memberService.newSignUp(memberDto);
        session.setAttribute("email", email);
        return "success";
    }

    @RequestMapping(value = "/member/newSignUpWithImage", method = RequestMethod.POST)
    public String saveFile(HttpServletRequest request, @RequestParam("attFile") MultipartFile img) throws IOException, ServletException {
        log.info("memberUpload");
        log.info("email: " + request.getAttribute("email"));
        return null;
    }

    @RequestMapping(value = "/member/memberUpdate", method = RequestMethod.POST)
    public @ResponseBody String memberUpdate(@RequestParam("email") String email, @RequestParam("nickname") String nickname, @RequestParam("intro") String intro, HttpSession session) {

        log.info("newSignUp");
        MemberDto memberDto = memberService.findMember(email);
        memberDto.setUserComment(intro);
        memberDto.setNickname(nickname);

        memberService.memberUpdate(memberDto);
        return "success";
    }

    @RequestMapping(value = "/member/memberUpdateWithImage", method = RequestMethod.POST)
    public String memberUpdateWithImage(HttpSession session, @RequestParam("nickname") String nickname, @RequestParam("intro") String intro, @RequestParam("attFile") MultipartFile img) throws IOException, ServletException {
        log.info("memberUpdateWithImage");
        log.info("email: " + session.getAttribute("email"));
        MemberDto memberDto = memberService.findMember((String) session.getAttribute("email"));
        String delFile = memberDto.getSysUserPhoto();
        log.info("nickname: " + memberDto.getNickname());
        memberDto.setUserComment(intro);
        memberDto.setNickname(nickname);
        log.info("intro: " + memberDto.getUserComment());
        log.info("nickname: " + memberDto.getNickname());
        AttVo attVo = new AttVo();
        try {
            attVo = fileupload(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(attVo != null) {
            memberDto.setOriUserPhoto(attVo.getOriFile());
            memberDto.setSysUserPhoto(attVo.getSysFile());
            if(delFile != null) {
                File file = new File(path + delFile);
                if(file.exists()) {
                    file.delete();
                }
            }
        }
        log.info("nickname: " + memberDto.getNickname());
        memberService.memberUpdate(memberDto);
        return null;
    }

    @RequestMapping("/member/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @RequestMapping("/member/callCallBack")
    public ModelAndView callCallBack() {
        ModelAndView mv = new ModelAndView();
        log.info("callCallBack");
        mv.setViewName("member/callBack");
        return mv;
    }

    @RequestMapping("/{result}")
    public ModelAndView goSignUp(@PathVariable("result") String result) {
        ModelAndView mv = new ModelAndView();
        
        mv.addObject("result", result);
        System.out.println(result);
        log.info("goSignUp");
        mv.setViewName("member/signUp");
        return mv;
    }
    
    @RequestMapping("/member/UserAdd")
    public ModelAndView UserAdd(MemberDto dto, HttpSession session) {
        log.info("UserAdd");
        ModelAndView mv = new ModelAndView();
        String email = (String)session.getAttribute("email");
        System.out.println("유저 에드 : " + email);
        
    	dto.setEmail(email);
    	memberService.insertMember(dto);
    	
        mv.setViewName("/review/reviewSelect");
        System.out.println(mv.getViewName());
        return mv;
    }

    public AttVo fileupload(MultipartFile mul) throws Exception{

            UUID uuid = UUID.randomUUID(); //랜덤 숫자. 이름중복 방지
            String oriFile = mul.getOriginalFilename();
            String sysFile = "";
            if(oriFile != null && !oriFile.equals("")) {
                sysFile = uuid.toString() + "_" + oriFile;
                File temp = new File(path + oriFile);//path + 파일명 -> temp
                mul.transferTo(temp); // 선택한 파일 -> temp로

                sysFile = (uuid.getLeastSignificantBits()*-1) + "-" + oriFile; //경로+랜덤문자+파일명
                File f = new File(path + sysFile);
                temp.renameTo(f); //f로 이름 바꿔줌

                AttVo attVo = new AttVo();//boardVo가 먼저 만들어져서 sno가 있어야 pSno도 추가되어야겠찌
                attVo.setOriFile(oriFile);
                attVo.setSysFile(sysFile);

                return attVo;
            }

        return null;
    }
}