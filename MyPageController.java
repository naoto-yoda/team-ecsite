package jp.co.internous.knights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.knights.model.domain.MstUser;
import jp.co.internous.knights.model.mapper.MstUserMapper;
import jp.co.internous.knights.model.session.LoginSession;

@Controller
@RequestMapping("/knights/mypage")
public class MyPageController {
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@RequestMapping("/")
	public String index(Model m) {
		
		MstUser user =
				userMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		
		m.addAttribute("user", user);
		m.addAttribute("loginSession", loginSession);
		
		return "my_page";
	}

}
