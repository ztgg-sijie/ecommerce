package com.ztgg.ecommerce.web.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztgg.ecommerce.dto.UserExecution;
import com.ztgg.ecommerce.entity.User;
import com.ztgg.ecommerce.enums.UserStateEnum;
import com.ztgg.ecommerce.service.UserService;
import com.ztgg.ecommerce.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/superadmin")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/listusers", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> listUsers(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		UserExecution ue = null;
		
		int pageIndex = HttpServletRequestUtil.getInt(request, "page");
		int pageSize = HttpServletRequestUtil.getInt(request, "rows");
		if (pageIndex > 0 && pageSize > 0) {
			try {
				User user = new User();
				int enableStatus = HttpServletRequestUtil.getInt(request, "enableStatus");
				if (enableStatus > -1) {
					user.setEnableStatus(enableStatus);
				}
				String name = HttpServletRequestUtil.getString(request, "name");
				if (name != null) {
					user.setName(URLDecoder.decode(name, "UTF-8"));
				}
				ue = userService.getUserList(user, pageIndex, pageSize);
			} catch (Exception e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}
			if (ue.getUserList() != null) {
				modelMap.put("page", ue.getUserList());
				modelMap.put("total", ue.getUserList().size());
				modelMap.put("success", true);
			} else {
				modelMap.put("page", new ArrayList<User>());
				modelMap.put("total", 0);
				modelMap.put("success", true);
			}
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty params");
			return modelMap;
		}
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> modifyUser(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		long userId = HttpServletRequestUtil.getLong(request, "userId");
		int enableStatus = HttpServletRequestUtil.getInt(request, "enableStatus");
	
		if (userId >= 0 && enableStatus >= 0) {
			try {
				User user = new User();
				user.setUserId(userId);
				user.setEnableStatus(enableStatus);
				
				UserExecution ae = userService.modifyUser(user);
				if (ae.getState() == UserStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", ae.getStateInfo());
				}
			} catch (RuntimeException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}

		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty params");
		}
		return modelMap;
	}

}
