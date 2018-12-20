package com.example.springboot.util;

import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;

import java.util.List;

/**
 * @Create by lee
 * @emil JefferyLeeeg@gmail.com
 * @Date 18-12-20
 * @Time 下午8:59
 */
public class MarkDownUtil {

    private final static PegDownProcessor md = new PegDownProcessor(Extensions.ALL_WITH_OPTIONALS);

    public static String pegDown(String content) {
        return md.markdownToHtml(content);
    }

//    public String marked(String content) {
//        //处理@
//        List<String> users = StrUtil.fetchUsers(content);
//        for (String user : users) {
//            content = content.replace("@" + user, "[@" + user + "](/user/" + user + ")");
//        }
//        //markdown 转 html 并返回
//        return Jsoup.clean(MarkdownUtil.pegDown(content), Whitelist.relaxed());
//    }

}
