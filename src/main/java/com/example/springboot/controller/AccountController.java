package com.example.springboot.controller;

import com.example.springboot.controller.presenter.AccountPresenter;
import com.example.springboot.dto.Response;
import com.example.springboot.service.AccountService;
import com.example.springboot.util.CommonUtils;
import com.example.springboot.util.ResponseEnum;
import com.example.springboot.util.VerificationCodeUtil;
import com.example.springboot.util.response.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

/**
 * @title:
 * @gmail jefferyleeeg@gmail.com
 * @author:Lee
 * @date: 2018/11/9
 */
@RestController
@RequestMapping("/api/account")
@Api(value = "/account", tags = "Account", description = "帐号操作")
public class AccountController extends BaseController implements AccountPresenter {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @ApiOperation("登陆")
    @PostMapping("/register")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, dataType = "String")
    })
    @Override
    public Response register(HttpServletRequest request, String userName, String password, String phone, String code) {
        HttpSession session = request.getSession();
        Object sCode = session.getAttribute(phone + "_code");
        Object time = session.getAttribute(phone + "_time");
        if (null == sCode || null == time || sCode.toString().isEmpty() || (new Date().getTime() - Long.valueOf(time.toString()) > 60 * 1000)) {//验证码失效 60s
            return ResponseUtil.error(ResponseEnum.CODE_INVALID);
        }

        return null;
    }

    @ApiOperation("登陆")
    @PostMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @Override
    public Response login(String userName, String password) {

        return null;
    }

    @ApiOperation("获取验证码")
    @PostMapping("/getCode")
    @ApiImplicitParam(name = "phoneNumber", value = "手机号", required = true, dataType = "String")
    @Override
    public Response getCode(HttpServletRequest request, String phoneNumber) {
        logger.info("getCode : " + phoneNumber);
        if (!CommonUtils.checkPhone(phoneNumber)) {
            return ResponseUtil.error(ResponseEnum.PARAMETER_INVALID);
        }
        HttpSession session = request.getSession();
        Object time = session.getAttribute(phoneNumber + "_time");
        Long timeNow = new Date().getTime();
        logger.info("time : " + time + "  timeNow : " + timeNow);
        if (null != time && (timeNow - Long.valueOf(time.toString()) < 60 * 1000)) {//请求频率过高
            logger.info("发送过快： " + (timeNow - Long.valueOf(time.toString())));
            return ResponseUtil.error(ResponseEnum.REQUEST_INVALID);
        }
        String verificationCode = VerificationCodeUtil.getNumberCode();
        int result = accountService.getCode(phoneNumber, verificationCode);
        if (2 == result) {
            return ResponseUtil.error(ResponseEnum.ACCOUNT_EXIST);
        } else if (0 > result) {
            return ResponseUtil.error(ResponseEnum.SEND_FAILED);
        }
        session.setAttribute("code", verificationCode);
        session.setAttribute(phoneNumber + "_time", timeNow);
        return ResponseUtil.success(null);
    }

    public String imageCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        OutputStream os = response.getOutputStream();
        //返回验证码和图片的map
        Map<String, Object> map = VerificationCodeUtil.getImageCode(86, 37, os);
        String simpleCaptcha = "simpleCaptcha";
        request.getSession().setAttribute(simpleCaptcha, map.get("strEnsure").toString().toLowerCase());
        request.getSession().setAttribute("codeTime", new Date().getTime());
        try {
            ImageIO.write((BufferedImage) map.get("image"), "jpg", os);
        } catch (IOException e) {
            return "";
        } finally {
            if (os != null) {
                os.flush();
                os.close();
            }
        }
        return null;
    }

    public String checkCode(HttpServletRequest request, HttpSession session, String checkCode) throws Exception {

        // 获得验证码对象
        Object cko = session.getAttribute("simpleCaptcha");
        if (cko == null) {
            request.setAttribute("errorMsg", "请输入验证码！");
            return "请输入验证码！";
        }
        String captcha = cko.toString();

        // 验证码有效时长为1分钟
        Date now = new Date();
        Long codeTime = Long.valueOf(session.getAttribute("codeTime") + "");

        // 判断验证码输入是否正确
        if (StringUtils.isEmpty(checkCode) || captcha == null || !(checkCode.equalsIgnoreCase(captcha))) {
            request.setAttribute("errorMsg", "验证码错误！");
            return "验证码错误，请重新输入！";
        } else if ((now.getTime() - codeTime) / 1000 / 60 > 1) {
            request.setAttribute("errorMsg", "验证码已失效，请重新输入！");
            return "验证码已失效，请重新输入！";
        } else {

            // 在这里可以处理自己需要的事务，比如验证登陆等

            return "验证通过！";
        }
    }


}
